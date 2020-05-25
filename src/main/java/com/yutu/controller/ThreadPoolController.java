package com.yutu.controller;

import com.alibaba.fastjson.JSON;
import com.yutu.controller.threadpool.MyIgnorePolicy;
import com.yutu.controller.threadpool.MyThreadFactory;
import com.yutu.entity.ConfigConstants;
import com.yutu.entity.MsgPack;
import com.yutu.entity.calpuff.Calpuff;
import com.yutu.service.IDataService;
import com.yutu.service.impl.DataServiceImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 18:02
 * @Description:
 */
public class ThreadPoolController {

    ThreadPoolExecutor threadPoolExecutor;

    private IDataService dataService = new DataServiceImpl();

    // 定义一个线程锁，保证当前只有一个工作在操作中
    private final Object lock = new Object();
    //定义刷新频率
    private long nextTime;

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 14:47
     * @Description: 构造函数 设置参数
     **/
    public ThreadPoolController() {
        //核心线程大小
        int corePoolSize = 2;
        //最大线程大小
        int maximumPoolSize = 4;
        // 空闲线程存活时间
        long keepAliveTime = 10;
        //时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //线程池所使用的缓冲队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(1);
        //线程池创建线程使用的工厂
        ThreadFactory threadFactory = new MyThreadFactory();
        //线程池对拒绝任务的处理策略
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        // 预启动所有核心线程
        threadPoolExecutor.prestartAllCoreThreads();
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 15:46
     * @Description: 主核心调用方法
     **/
    public void run() {
        int num=1;
        // 无限循环
        while (ConfigConstants.THREAD_SWITCH) {
            // 该过程忽略了所有的Exception，以保证线程不会因此而中断
            try {
                synchronized (lock) {
                    nextTime = ConfigConstants.TASK_INTERVAL;
                    // 获得时间区间，即要等待的时间段
                    long interval = nextTime - System.currentTimeMillis();
                    if (interval > 0) {
                        try {
                            lock.wait(interval);
                        } catch (InterruptedException e) {
                            // 忽略此Exception
                        }
                    }
                    // 如果active为false，强制中断
                    if (!ConfigConstants.THREAD_SWITCH) {
                        break;
                    }
                }

                if(num>=50){
                    nextTime=5000L;
                    threadPoolExecutor.setMaximumPoolSize(5);
                }else if(num>=36){
                    nextTime=5000L;
                }
                 else if(num>=10){
                    Thread.sleep(30000L);
                }

                 System.out.print("++++++++++++++>index-"+num+";-----+activeCount"+Thread.currentThread().getThreadGroup().activeCount()+"\r\n");
                 num++;
                // 执行具体的工作
                MsgPack msgPack = scanningTask();
                if (msgPack.getStatus() == 1) {
                    MyTaskController myTaskController = new MyTaskController(msgPack);
                    threadPoolExecutor.execute(myTaskController);
                } else {
                    nextTime = ConfigConstants.TASK_INTERVAL * 2;
                }
            } catch (Throwable t) {
                try {
                    Thread.sleep(ConfigConstants.TASK_INTERVAL);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 11:06
     * @Description: 扫描数据库，获取任务
     **/
    public MsgPack scanningTask() {
        MsgPack msgPack = new MsgPack();
        try {
            Thread.sleep(1000L);
            msgPack.setStatus(1);
            return msgPack;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> listMap = dataService.getTaskInfo();
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName = address.getHostName().toString(); //获取本机计算机名称
        //无值直接返回
        if (listMap.size() < 1) {
            //如果数据库无数据
            msgPack.setStatus(0);
            return msgPack;
        }
        String jsonObj = listMap.get(0).get("jsonobj").toString();
        String sessionId = listMap.get(0).get("session_id").toString();
        //数据库获得数据后 改变状态和相关参数
        dataService.updateScanningStatus(hostName, sessionId);
        try {
            Calpuff calpuff = JSON.parseObject(jsonObj, Calpuff.class);
            msgPack.setStatus(1);
            msgPack.setData(calpuff);
        } catch (Exception e) {
            msgPack.setStatus(0);
            dataService.updateStatus(sessionId, 0, "参数无法解析，请按接口文档检查参数是否符合标注----" + e.toString());
        }
        return msgPack;
    }
}

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

    //线程池核心方法
    private ThreadPoolExecutor threadPoolExecutor;
    //线程池所使用的缓冲队列
    private BlockingQueue<Runnable> workQueue;

    //业务层接口实现
    private IDataService dataService = new DataServiceImpl();

    // 定义一个线程锁，保证当前只有一个工作在操作中
    private final Object lock = new Object();
    //定义刷新频率
    private long nextTime;

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 14:47
     * @Description: 构造函数 设置线程库参数
     **/
    public ThreadPoolController() {
        //核心线程大小
        int corePoolSize = 2;
        //最大线程大小
        int maximumPoolSize = 4;
        // 空闲线程存活时间  10分钟线程过期
        long keepAliveTime = 600;
        //时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //队列总数10000
        workQueue = new ArrayBlockingQueue<>(1024);
        //线程池创建线程使用的工厂
        ThreadFactory threadFactory = new MyThreadFactory();
        //线程池对拒绝任务的处理策略
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        // 预启动所有核心线程
        threadPoolExecutor.prestartAllCoreThreads();

        workQueue.size();
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 15:46
     * @Description: 主核心调用方法  循环扫描任务
     **/
    public void run() {
        // 无限循环
        while (ConfigConstants.THREAD_SWITCH) {
            try {
                //首先判断线程队列总数是否超标，超标延迟处理
                if(workQueue.size()>1000){
                    Thread.sleep(ConfigConstants.TASK_INTERVAL*10);
                }
                // 执行扫描任务工作
                MsgPack msgPack = scanningTask();
                //判断任务是否有效
                if (msgPack.getStatus() == 1) {
                    MyTaskController myTaskController = new MyTaskController(msgPack);
                    threadPoolExecutor.execute(myTaskController);
                } else {
                    Thread.sleep(ConfigConstants.TASK_INTERVAL);
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
        String value = dataService.getQueue("zhaobc-20200526");
//        System.out.print("~~~~~~~~~~~~~" + value + "\r\n");
        if (value != null) {
            msgPack.setStatus(1);
            msgPack.setData(value);
        }
        return msgPack;
    }
}

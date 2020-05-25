package com.yutu.controller;

import com.yutu.entity.ConfigConstants;
import com.yutu.entity.MsgPack;
import com.yutu.service.IDriveService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

/**
 * @Author: zhaobc
 * @Date: 2020/5/22 14:48
 * @Description:初始执行类
 */
public class HomeController implements Runnable {
    //日志
    private Logger logger = Logger.getLogger(HomeController.class);

    @Resource
    private IDriveService driveService;

    // 定义一个线程锁，保证当前只有一个工作在操作中
    private final Object lock = new Object();
    //定义刷新频率
    private long nextTime;

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 15:46
     * @Description: 主核心调用方法
     **/
    @Override
    public void run() {
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
                // 执行具体的工作
                MsgPack msgPack = scanningTask();
                if (msgPack.getStatus() == 1) {
                    runDrive(msgPack);
                    nextTime = ConfigConstants.TASK_INTERVAL;
                } else {
                    nextTime = ConfigConstants.TASK_INTERVAL * 2;
                }
            } catch (Throwable t) {
                try {
                    exceptionHandle(t);
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
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/3/27 10:05
     * @Description:运行驱动程序
     **/
    public void runDrive(MsgPack msgPack) {

    }


    /**
     * @Author: zhaobc
     * @Date: 2020/3/27 10:05
     * @Description: 异常处理方法
     **/
    public void exceptionHandle(Throwable t) {

    }
}

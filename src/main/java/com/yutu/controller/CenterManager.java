package com.yutu.controller;

import com.yutu.entity.ConfigConstants;
import com.yutu.entity.MsgPack;
import org.apache.log4j.Logger;

import java.net.UnknownHostException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 10:57
 * @Description:核心线程处理
 */
public class CenterManager {

    ThreadPoolExecutor executor;

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 14:47
     * @Description: 构造函数 设置参数
     **/
    public CenterManager() {
        //核心线程大小
        int corePoolSize = 4;
        //最大线程大小
        int maximumPoolSize = 8;
        // 空闲线程存活时间
        long keepAliveTime = 1800;
        //时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //线程池所使用的缓冲队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(1);
        //线程池创建线程使用的工厂
        ThreadFactory threadFactory = new MyTreadFactory();
        //线程池对拒绝任务的处理策略
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        // 预启动所有核心线程
        executor.prestartAllCoreThreads();
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 14:03
     * @Description: 线程交由线程池统一管理
     **/
    public void mainStart() {
        HomeController homeController = new HomeController();
        executor.execute(homeController);
    }

    //线程池创建线程使用的工厂
    static class MyTreadFactory implements ThreadFactory {
        private Logger logger = Logger.getLogger(MyTreadFactory.class);

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            logger.info(t.getName() + " has been created");
            return t;
        }
    }

    //线程池对拒绝任务的处理策略
    static class MyIgnorePolicy implements RejectedExecutionHandler {
        private Logger logger = Logger.getLogger(MyIgnorePolicy.class);

        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            logger.info(r.toString() + " rejected");
        }
    }
}

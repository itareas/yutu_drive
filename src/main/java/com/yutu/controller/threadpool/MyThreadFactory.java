package com.yutu.controller.threadpool;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 18:03
 * @Description:
 */
public class MyThreadFactory implements ThreadFactory {
    private Logger logger = Logger.getLogger(MyThreadFactory.class);

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
        logger.info("------------------------><insert> "+thread.getName() + " has been created");
        return thread;
    }
}

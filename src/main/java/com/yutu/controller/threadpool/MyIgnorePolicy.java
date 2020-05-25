package com.yutu.controller.threadpool;

import org.apache.log4j.Logger;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 18:03
 * @Description:
 */
public class MyIgnorePolicy implements RejectedExecutionHandler {
    private Logger logger = Logger.getLogger(MyIgnorePolicy.class);

    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        doLog(r, e);
    }

    private void doLog(Runnable r, ThreadPoolExecutor e) {
        // 可做日志记录等
//        logger.info(r.toString() + " rejected");
    }
}

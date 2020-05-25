package com.yutu.controller;

import com.yutu.entity.MsgPack;
import com.yutu.entity.calpuff.Calpuff;
import com.yutu.service.IDataService;
import com.yutu.service.impl.DataServiceImpl;
import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 18:04
 * @Description:我的任务中心
 */
public class MyTaskController implements Runnable {
    //日志
    private Logger logger = Logger.getLogger(MyTaskController.class);

    private IDataService dataService = new DataServiceImpl();

    private MsgPack msgPack;

    public MyTaskController(MsgPack msgPack) {
        this.msgPack = msgPack;
    }

    @Override
    public void run() {
        try {
            runDrive(this.msgPack);
        } catch (Throwable t) {
            exceptionHandle(t);
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/3/27 10:05
     * @Description:运行驱动程序
     **/
    public void runDrive(MsgPack msgPack) {
        //查看线程名称
        logger.info("=======================>线程："+Thread.currentThread().getName()+";   运行模型");
        try {
            int sleepDate=(int) (Math.random() * 8999) + 3000;
            Thread.sleep(sleepDate);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/3/27 10:05
     * @Description: 异常处理方法
     **/
    public void exceptionHandle(Throwable t) {
        logger.error("=======================>"+t.getMessage(), t);
    }
}

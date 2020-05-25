package com.yutu;

import com.yutu.controller.ThreadPoolController;
import com.yutu.entity.ConfigConstants;
import com.yutu.utils.PropertiesUtils;

public class YutuApplication {

    public static void main(String[] args) {
        //加载参数
        runConfigConstants();

        //开始计算程序
        ThreadPoolController threadPoolController = new ThreadPoolController();
        threadPoolController.run();
    }

    /**
     * @Author: zhaobc
     * @Date: 2020-01-14 11:02
     * @Description: 业务配置文件位置
     **/
    private static void runConfigConstants() {
        //设置配置文件路径
        PropertiesUtils.path = "application.properties";
        //获取业务配置文件区域
        ConfigConstants.MYSQL_DRIVER = PropertiesUtils.get("mysql.datasource.driverclassname");
        ConfigConstants.MYSQL_URL = PropertiesUtils.get("mysql.datasource.url");
        ConfigConstants.MYSQL_USERNAME = PropertiesUtils.get("mysql.datasource.username");
        ConfigConstants.MYSQL_PASSWORD = PropertiesUtils.get("mysql.datasource.password");
        ConfigConstants.REDIS_HOST = PropertiesUtils.get("redis.host");
        ConfigConstants.REDIS_PORT = PropertiesUtils.get("redis.port");
        ConfigConstants.REDIS_PASSWORD = PropertiesUtils.get("redis.password");
        ConfigConstants.THREAD_TUYPE = PropertiesUtils.get("thread_type");
        ConfigConstants.THREAD_SWITCH = PropertiesUtils.get("thread_switch").equals("true");
        ConfigConstants.MODEL_CODE = PropertiesUtils.get("model_code");
        try {
            ConfigConstants.TASK_INTERVAL = Long.parseLong(PropertiesUtils.get("task_interval"));
        } catch (Exception e) {
            ConfigConstants.TASK_INTERVAL = 10000L;
        }

        ConfigConstants.ATTACHMENT_PATH = PropertiesUtils.get("attachment_path");
    }
}

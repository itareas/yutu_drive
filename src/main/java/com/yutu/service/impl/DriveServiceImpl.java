package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.service.IDriveService;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.*;

/**
 * @Author: zhaobc
 * @Date: 2020/3/25 16:55
 * @Description: calpuff业务处理
 */
public class DriveServiceImpl implements IDriveService {

    private Logger logger = Logger.getLogger(DriveServiceImpl.class);

    public MsgPack runDrive() {
        MsgPack msgPack = new MsgPack();

        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/4/1 14:01
     * @Description: 获得文件夹下所有文件
     **/
    public List<String> getAllFiles(String path, String url) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                String fileName = tempList[i].toString();
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                //判断是不是日志文件
                files.add(url + fileName);
            }
        }
        return files;
    }
}


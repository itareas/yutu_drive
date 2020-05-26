package com.yutu.service.impl;

import com.yutu.dao.IDatabaseDao;
import com.yutu.dao.impl.DatabaseDaoImpl;
import com.yutu.service.IDataService;
import com.yutu.utils.RedisUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 17:00
 * @Description:
 */
public class DataServiceImpl implements IDataService {

    private IDatabaseDao databaseDao=new DatabaseDaoImpl();

    @Override
    public List<Map<String, Object>> getTaskInfo() {
        return databaseDao.getTaskInfo();
    }

    @Override
    public List<Map<String, Object>> getSpeciesList() {
        return databaseDao.getSpeciesList();
    }

    @Override
    public int updateScanningStatus(String hostName, String sessionId) {
        return databaseDao.updateScanningStatus(hostName,sessionId);
    }

    @Override
    public int updateStatus(String sessionId, int status, String remarks) {
        return databaseDao.updateStatus(sessionId,status,remarks);
    }

    @Override
    public int updateStatus(String sessionId, int status, String result, String remarks) {
        return databaseDao.updateStatus(sessionId,status,result,remarks);
    }

    @Override
    public int updateProgress(String sessionId, double value) {
        return databaseDao.updateProgress(sessionId,value);
    }

    @Override
    public String getQueue(String key) {
       return RedisUtils.lpop(key);
    }
}

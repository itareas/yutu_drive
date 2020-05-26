package com.yutu.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaobc
 * @Date: 2020/5/25 17:00
 * @Description:
 */
public interface IDataService {
    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 16:29
     * @Description: 获得最新一条任务处理
     **/
    List<Map<String, Object>> getTaskInfo();

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 16:28
     * @Description: 获得污染物列表
     **/
    List<Map<String, Object>> getSpeciesList();

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 16:28
     * @Description: 更新状态  并修改结果信息
     **/
    int updateScanningStatus(String hostName, String sessionId);

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 16:28
     * @Description: 更新状态  并修改结果信息
     **/
    int updateStatus(String sessionId, int status, String remarks);

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 16:28
     * @Description: 重载更新状态  运行成功后存储结果信息
     **/
    int updateStatus(String sessionId, int status, String result, String remarks);

    /**
     * @Author: zhaobc
     * @Date: 2020/5/25 16:28
     * @Description: 更新状态  并修改结果信息
     **/
    int updateProgress(String sessionId, double value);


    /**
    * @Author: zhaobc
    * @Date: 2020/5/26 15:49
    * @Description: 获得队列信息
    **/
    String getQueue(String key);
}

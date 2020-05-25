package com.yutu.dao.impl;

import com.yutu.dao.IDatabaseDao;
import com.yutu.utils.PropertiesUtils;
import com.yutu.utils.SqlHelper;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaobc
 * @Date: 2020/3/26 13:53
 * @Description:数据库操作
 */

public class DatabaseDaoImpl implements IDatabaseDao {
    private Logger logger = Logger.getLogger(DatabaseDaoImpl.class);

    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 14:00
     * @Description: 获得最新一条任务处理
     **/
    public List<Map<String, Object>> getTaskInfo() {
        String sqlTask = "SELECT session_id,jsonobj FROM t_bus_task WHERE run_status=0 and model_code='" + PropertiesUtils.get("model_code") + "'  ORDER BY request_time LIMIT 1";
        List<Map<String, Object>> listMap = SqlHelper.executeQuery(sqlTask, null);
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("==================>扫描数据库任务：date：" + dfDate.format(new Date()) + "-----taskNumber:" + listMap.size());
        return listMap;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 14:00
     * @Description: 获得污染物列表
     **/
    public List<Map<String, Object>> getSpeciesList() {
        String sqlConfig = "SELECT order_by,config_code FROM  t_cod_config WHERE config_parent IN(SELECT UUID  FROM t_cod_config WHERE config_code='" + PropertiesUtils.get("species_code") + "')  ORDER BY order_by";
        List<Map<String, Object>> listMap = SqlHelper.executeQuery(sqlConfig, null);
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("==================>获取污染物列表：date：" + dfDate.format(new Date()) + "-----taskNumber:" + listMap.size());
        return listMap;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 14:01
     * @Description: 更新状态  并修改结果信息
     **/
    public int updateScanningStatus(String hostName, String sessionId) {
        String updateStatus = "UPDATE t_bus_task SET run_status=1 ,run_progress=10, run_host=? ,update_time=?  WHERE session_id = ?";
        Object[] parameters = {hostName, new Date(), sessionId};
        int resultIndex = SqlHelper.executeUpdate(updateStatus, parameters);
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //判断是否为异常事件
        logger.error("==================>扫描后更新任务状态：" + dfDate.format(new Date()) + "-----update:" + resultIndex + "------sessionId:" + sessionId + "------hostName:" + hostName);
        return resultIndex;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 14:01
     * @Description: 更新状态  并修改结果信息
     **/
    public int updateStatus(String sessionId, int status, String remarks) {
        String updateStatus = "UPDATE t_bus_task SET run_status=? ,remarks=?,update_time=?  WHERE session_id = ?";
        Object[] parameters = {status, remarks, new Date(), sessionId};
        int resultIndex = SqlHelper.executeUpdate(updateStatus, parameters);
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //判断是否为异常事件
        if (status == 0) {
            logger.error("==================>更新任务状态：" + dfDate.format(new Date()) + "-----update:" + resultIndex + "------sessionId:" + sessionId + "-----status:" + status + "-----remarks:" + remarks);
        } else {
            logger.info("==================>更新任务状态：" + dfDate.format(new Date()) + "-----update:" + resultIndex + "------sessionId:" + sessionId + "-----status:" + status + "-----remarks:" + remarks);
        }
        return resultIndex;
    }


    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 14:01
     * @Description: 重载更新状态  运行成功后存储结果信息
     **/
    public int updateStatus(String sessionId, int status, String result, String remarks) {
        String updateStatus = "UPDATE t_bus_task SET run_status=?,run_result=?,remarks=?,update_time=?  WHERE session_id = ?";
        Object[] parameters = {status, result, remarks, new Date(), sessionId};
        int resultIndex = SqlHelper.executeUpdate(updateStatus, parameters);
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("==================>运算结果入库：" + dfDate.format(new Date()) + "-----update:" + resultIndex + "------sessionId:" + sessionId + "-----status:" + status + "-----remarks:" + remarks);
        return resultIndex;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/3/26 14:01
     * @Description: 更新状态  并修改结果信息
     **/
    public int updateProgress(String sessionId, double value) {
        String sqlProgress = "UPDATE t_bus_task SET run_progress=?    WHERE session_id =? ";
        Object[] parameters = {value, sessionId};
        int resultIndex = SqlHelper.executeUpdate(sqlProgress, parameters);
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        logger.info("==================>更新任务进度（%）：" + dfDate.format(new Date()) + "-----update:" + resultIndex + "------sessionId:" + sessionId + "-----run_progress:" + value);
        return resultIndex;
    }

}

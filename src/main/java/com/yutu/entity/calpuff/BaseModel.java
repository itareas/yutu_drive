package com.yutu.entity.calpuff;

/**
 * @Author: zhaobc
 * @Date: 2020/3/25 16:07
 * @Description:
 */
public class BaseModel {
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 16:10
    * @Description: 模型代码
    **/
    private String model_code;
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 16:10
    * @Description: 访问网站id
    **/
    private String app_id;

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }
}

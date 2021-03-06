package com.yutu.entity;

/**
 * @Author: zhaobc
 * @Date: 2019/4/20 21:57
 * @Description: Json交互消息包
 **/
public class MsgPack<T> {

    /**
    * @Author: zhaobc
    * @Date: 2019-12-23 10:24
    * @Description: 构造函数 设置默认值
    **/
    public MsgPack(){
       this.setStatus(0);
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/22 16:42
     * @Description: 0 ：false   1:true
     **/
    private int status;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/22 16:42
     * @Description: 消息
     **/
    private String msg;
    /**
     * @Author: zhaobc
     * @Date: 2019/6/22 16:41
     * @Description: 泛型数据区域
     **/
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        switch (status) {
            case 0:
                this.msg = "failure";
                break;
            case 1:
                this.msg = "success";
                break;
        }
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

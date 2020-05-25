package com.yutu.entity.calpuff.source;

/**
 * @Author: zhaobc
 * @Date: 2020/3/31 11:47
 * @Description:地理坐标类
 */
public class Coordinate {
    /**
    * @Author: zhaobc
    * @Date: 2020/3/31 11:47
    * @Description: 经度
    **/
    private Double lon;

    /**
    * @Author: zhaobc
    * @Date: 2020/3/31 11:48
    * @Description: 纬度
    **/
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}

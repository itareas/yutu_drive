package com.yutu.entity.calpuff.source;

import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2020-03-06 13:23
 * @Description:面源
 */
public class AreaSource {
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 16:38
    * @Description: 四角顶点坐标（WGS84）  [{“lon”:,”lat”:},{ “lon”:,”lat”:},{ “lon”:,”lat”:},{ “lon”:,”lat”:}]  左上/右上/右下/左下
    **/
    private List<Coordinate>  area_vertex;
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 16:38
    * @Description: 烟囱高度（m）
    **/
    private double stackheight;
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 16:39
    * @Description: 海拔高度（m）
    **/
    private double baseelevation;
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 16:39
    * @Description: 污染物排放速率(kg/m2/h)
    **/
    private Species emissionrates;

    public List<Coordinate> getArea_vertex() {
        return area_vertex;
    }

    public void setArea_vertex(List<Coordinate> area_vertex) {
        this.area_vertex = area_vertex;
    }

    public double getStackheight() {
        return stackheight;
    }

    public void setStackheight(double stackheight) {
        this.stackheight = stackheight;
    }

    public double getBaseelevation() {
        return baseelevation;
    }

    public void setBaseelevation(double baseelevation) {
        this.baseelevation = baseelevation;
    }

    public Species getEmissionrates() {
        return emissionrates;
    }

    public void setEmissionrates(Species emissionrates) {
        this.emissionrates = emissionrates;
    }
}

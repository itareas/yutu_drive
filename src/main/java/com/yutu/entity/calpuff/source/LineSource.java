package com.yutu.entity.calpuff.source;

import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2020-03-06 13:23
 * @Description:线源
 */
public class LineSource {
    /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:38
     * @Description: 两点坐标（WGS84）  [{“lon”:,”lat”:},{ “lon”:,”lat”:} ]  起点/终点
     **/
    private List<Coordinate> line_vertex;
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
    private  Species emissionrates;

    public List<Coordinate> getLine_vertex() {
        return line_vertex;
    }

    public void setLine_vertex(List<Coordinate> line_vertex) {
        this.line_vertex = line_vertex;
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

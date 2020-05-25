package com.yutu.entity.calpuff.source;

/**
 * @Author: zhaobc
 * @Date: 2020-03-06 11:41
 * @Description:点源
 */
public class PointSource {

    /**
     * @Author: zhaobc
     * @Date: 2020-03-06 12:07
     * @Description: 经度
     **/
    private double source_lon;

    /**
     * @Author: zhaobc
     * @Date: 2020-03-06 12:07
     * @Description: 维度
     **/
    private double source_lat;


    /**
     * @Author: zhaobc
     * @Date: 2020-03-02 15:04
     * @Description: 烟筒高度 (m)
     **/
    private double stackheight;

    /**
     * @Author: zhaobc
     * @Date: 2020-03-06 13:32
     * @Description: 海拔高度 (m)
     **/
    private double baseelevation;

    /**
     * @Author: zhaobc
     * @Date: 2020-03-06 13:34
     * @Description: 烟囱内经 (m)
     **/
    private double stackdiameter;

    /**
     * @Author: zhaobc
     * @Date: 2020-03-02 15:06
     * @Description: 烟气流速(m / s)
     **/
    private double exitvel;

    /**
     * @Author: zhaobc
     * @Date: 2020-03-02 15:06
     * @Description: 烟气温度(℃)273.15k=0℃  【需要转成 (deg. K)】  再get方法进行转换了
     **/
    private double exittemp;
    
    /**
    * @Author: zhaobc
    * @Date: 2020/3/25 17:37
    * @Description: 污染物排放速率(kg/h)
    **/
    private  Species emissionrates;

    public double getSource_lon() {
        return source_lon;
    }

    public void setSource_lon(double source_lon) {
        this.source_lon = source_lon;
    }

    public double getSource_lat() {
        return source_lat;
    }

    public void setSource_lat(double source_lat) {
        this.source_lat = source_lat;
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

    public double getStackdiameter() {
        return stackdiameter;
    }

    public void setStackdiameter(double stackdiameter) {
        this.stackdiameter = stackdiameter;
    }

    public double getExitvel() {
        return exitvel;
    }

    public void setExitvel(double exitvel) {
        this.exitvel = exitvel;
    }

    public double getExittemp() {
        return exittemp+273.15;
    }

    public void setExittemp(double exittemp) {
        this.exittemp = exittemp;
    }

    public Species getEmissionrates() {
        return emissionrates;
    }

    public void setEmissionrates(Species emissionrates) {
        this.emissionrates = emissionrates;
    }
}

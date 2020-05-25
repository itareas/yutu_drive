package com.yutu.entity.calpuff;

/**
 * @Author: zhaobc
 * @Date: 2020/3/25 16:22
 * @Description:气象数据输出控制
 */
public class MeteoOutctl {
    /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:38
     * @Description: 是否输出风速风向数据
     **/
    private boolean isout_windvectors;
    /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:38
     * @Description: 是否输出温度数据
     **/
    private boolean isout_temp;
    /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:39
     * @Description: 是否输出降水
     **/
    private boolean isout_precipitation;
    /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:39
     * @Description: 是否输出混合层高度
     **/
    private boolean isout_mixing_height;

    /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:39
     * @Description: 是否输出大气稳定度
     **/
    private boolean isout_stability;

    public boolean isIsout_windvectors() {
        return isout_windvectors;
    }

    public void setIsout_windvectors(boolean isout_windvectors) {
        this.isout_windvectors = isout_windvectors;
    }

    public boolean isIsout_temp() {
        return isout_temp;
    }

    public void setIsout_temp(boolean isout_temp) {
        this.isout_temp = isout_temp;
    }

    public boolean isIsout_precipitation() {
        return isout_precipitation;
    }

    public void setIsout_precipitation(boolean isout_precipitation) {
        this.isout_precipitation = isout_precipitation;
    }

    public boolean isIsout_mixing_height() {
        return isout_mixing_height;
    }

    public void setIsout_mixing_height(boolean isout_mixing_height) {
        this.isout_mixing_height = isout_mixing_height;
    }

    public boolean isIsout_stability() {
        return isout_stability;
    }

    public void setIsout_stability(boolean isout_stability) {
        this.isout_stability = isout_stability;
    }
}

package com.yutu.entity.calpuff;

import com.yutu.entity.calpuff.source.AreaSource;
import com.yutu.entity.calpuff.source.LineSource;
import com.yutu.entity.calpuff.source.PointSource;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2020/3/25 17:48
 * @Description: calpuff 实体类
 */
public class Calpuff extends BaseModel {

     /**
     * @Author: zhaobc
     * @Date: 2020/3/25 16:12
     * @Description: 库选  污染物类型   PM10  SO2   NOx   CO    PM25(需要处理)     O3 (不开放)
     **/
     private List<String> species;
     
     /**
     * @Author: zhaobc
     * @Date: 2020/3/25 17:52
     * @Description: 原点坐标经度（WGS84）   Y
     **/
     private double origin_lon;
     /**
     * @Author: zhaobc
     * @Date: 2020/3/25 17:53
     * @Description: 原点坐标经度（WGS84）  Y
     **/
     private double origin_lat;

     /**
     * @Author: zhaobc
     * @Date: 2020-03-05 15:40
     * @Description: 模拟开始时间      Y
     **/
     private Date sim_starttime;


     /**
      * @Author: zhaobc
      * @Date: 2020-03-02 15:06
      * @Description: 模拟结束时间    Y
      **/
     private Date sim_endtime;

     /**
      * @Author: zhaobc
      * @Date: 2020-03-02 15:06
      * @Description: 模拟分辨率（km）  Y
      **/
     private double sim_resolution;

     /**
      * @Author: zhaobc
      * @Date: 2020-03-02 15:06
      * @Description: 时间分辨率(秒)    Y
      **/
     private int time_resolution;

     /**
      * @Author: zhaobc
      * @Date: 2020-03-02 15:06
      * @Description: 时区      Y
      **/
     private String time_zone;


     /**
     * @Author: zhaobc
     * @Date: 2020-03-06 13:20
     * @Description:点源参数
     **/
     private List<PointSource> point_sources;

     /**
     * @Author: zhaobc
     * @Date: 2020-03-06 13:24
     * @Description:线源参数
     **/
     private List<LineSource> line_sources;

     /**
     * @Author: zhaobc
     * @Date: 2020-03-06 13:26
     * @Description: 面源参数
     **/
     private List<AreaSource> area_sources;

     /**
     * @Author: zhaobc
     * @Date: 2020-03-06 14:11
     * @Description: 气象数据输出控制
     **/
     private MeteoOutctl meteo_outctl;

     public List<String> getSpecies() {
          return species;
     }

     public void setSpecies(List<String> species) {
          this.species = species;
     }

     public double getOrigin_lon() {
          return origin_lon;
     }

     public void setOrigin_lon(double origin_lon) {
          this.origin_lon = origin_lon;
     }

     public double getOrigin_lat() {
          return origin_lat;
     }

     public void setOrigin_lat(double origin_lat) {
          this.origin_lat = origin_lat;
     }

     public Date getSim_starttime() {
          return sim_starttime;
     }

     public void setSim_starttime(Date sim_starttime) {
          this.sim_starttime = sim_starttime;
     }

     public Date getSim_endtime() {
          return sim_endtime;
     }

     public void setSim_endtime(Date sim_endtime) {
          this.sim_endtime = sim_endtime;
     }

     public double getSim_resolution() {
          return sim_resolution;
     }

     public void setSim_resolution(double sim_resolution) {
          this.sim_resolution = sim_resolution;
     }

     public int getTime_resolution() {
          return time_resolution;
     }

     public void setTime_resolution(int time_resolution) {
          this.time_resolution = time_resolution;
     }

     public String getTime_zone() {
          return time_zone;
     }

     public void setTime_zone(String time_zone) {
          this.time_zone = time_zone;
     }

     public List<PointSource> getPoint_sources() {
          return point_sources;
     }

     public void setPoint_sources(List<PointSource> point_sources) {
          this.point_sources = point_sources;
     }

     public List<LineSource> getLine_sources() {
          return line_sources;
     }

     public void setLine_sources(List<LineSource> line_sources) {
          this.line_sources = line_sources;
     }

     public List<AreaSource> getArea_sources() {
          return area_sources;
     }

     public void setArea_sources(List<AreaSource> area_sources) {
          this.area_sources = area_sources;
     }

     public MeteoOutctl getMeteo_outctl() {
          return meteo_outctl;
     }

     public void setMeteo_outctl(MeteoOutctl meteo_outctl) {
          this.meteo_outctl = meteo_outctl;
     }
}

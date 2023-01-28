package com.sau.badmintonhallinformationmanagementsystem.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xkzhangsan.time.calculator.DateTimeCalculatorUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author SRDZ
 * @date 2023/1/28 18:30
 */
public class TimeUtil {

  //判断2个时间段是否有重叠（交集）
  public static boolean isOver(String startTime1,String endTime1,String startTime2,String endTime2){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    try {
      return  DateTimeCalculatorUtil.isOverlap(sdf.parse(startTime1),sdf.parse(endTime1),sdf.parse(startTime2)
          ,sdf.parse(endTime2));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  //计算2个时间段的重叠（交集）时间
  public static long overTime(String startTime1,String endTime1,String startTime2,String endTime2){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    try {
      return DateTimeCalculatorUtil.overlapTime(sdf.parse(startTime1),sdf.parse(endTime1),sdf.parse(startTime2)
          ,sdf.parse(endTime2));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public static long 	subTime(String startTime,String endTime){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    try {
      return DateTimeCalculatorUtil.betweenTotalMillis(sdf.parse(startTime),sdf.parse(endTime));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }


  //8:00-10:00
  public static boolean isFullOver(JSONArray priceInfo){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    long sum0=subTime("08:00","22:00");
    long sum1=0;
    for(int i=0;i<priceInfo.size();i++){
      sum1+=subTime(priceInfo.getJSONObject(i).getString("startTime"),
          priceInfo.getJSONObject(i).getString("endTime"));
    }
    if(sum0==sum1)
      return true;
    return false;
  }


}

package com.sau.badmintonhallinformationmanagementsystem.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.sau.badmintonhallinformationmanagementsystem.bean.Course;
import com.sau.badmintonhallinformationmanagementsystem.bean.Field;
import com.sau.badmintonhallinformationmanagementsystem.bean.Member;
import com.sau.badmintonhallinformationmanagementsystem.bean.Payment;
import com.sau.badmintonhallinformationmanagementsystem.mapper.CourseMapper;
import com.sau.badmintonhallinformationmanagementsystem.mapper.FieldMapper;
import com.sau.badmintonhallinformationmanagementsystem.mapper.MemberMapper;
import com.sau.badmintonhallinformationmanagementsystem.mapper.PaymentMapper;
import com.sau.badmintonhallinformationmanagementsystem.utils.Result;
import com.sau.badmintonhallinformationmanagementsystem.utils.TimeUtil;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SRDZ
 * @date 2023/1/14 15:21
 */

@Service
public class PaymentService {

  @Autowired
  private PaymentMapper paymentMapper;

  @Autowired
  private FieldMapper fieldMapper;

  @Autowired
  private CourseMapper courseMapper;

  @Autowired
  private MemberMapper memberMapper;

  public int insert(Payment payment){
    payment.setPayTime(new Date(System.currentTimeMillis()));
    JSONObject jsonObject = JSONObject.parseObject(payment.getInfo());
    if (jsonObject.containsKey("goods")||jsonObject.containsKey("course")) {
      Member member = memberMapper.selectById(payment.getMemberId());
      if(member!=null){
        member.setPoint(member.getPoint()+payment.getBonus());
        memberMapper.updateById(member);
      }
    }
    return paymentMapper.insert(payment);
  }

  public Result getPaySum(JSONObject jsonObject) {
    BigDecimal account = new BigDecimal("0.00");
    int bonus = 0;
    int i;
    if (jsonObject.containsKey("goods")) {
      JSONArray goods = jsonObject.getJSONArray("goods");
      for (i = 0; i < goods.size(); i++){
        BigDecimal price = goods.getJSONObject(i).getBigDecimal("price");
        BigDecimal sum = goods.getJSONObject(i).getBigDecimal("sum");
        account = account.add(price.multiply(sum));
        bonus += goods.getJSONObject(i).getInteger("bonus");
      }
    } else if (jsonObject.containsKey("course")) {
      Course course = courseMapper.selectById(jsonObject.getJSONObject("course").getInteger("courseId"));
      if(course!=null){
        BigDecimal price = new BigDecimal(course.getPrice());
        account = account.add(price);
        bonus+=course.getBonus();
      }
    } else if (jsonObject.containsKey("order")) {
      JSONObject order = jsonObject.getJSONObject("order");
      Field field = fieldMapper.selectById((Integer) order.get("fieldId"));
      if (field != null) {
        JSONArray priceInfo = JSONObject.parseArray(field.getPriceInfo());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        for (i = 0; i < priceInfo.size(); i++) {
          if(TimeUtil.isOver(order.getString("startTime"),order.getString("endTime"),
              priceInfo.getJSONObject(i).getString("startTime"),priceInfo.getJSONObject(i).getString("endTime"))){
            long sum = TimeUtil.overTime(order.getString("startTime"),order.getString("endTime"),
                priceInfo.getJSONObject(i).getString("startTime"),priceInfo.getJSONObject(i).getString("endTime"))/(1000*60);
            account = account.add(BigDecimal.valueOf(sum).multiply(priceInfo.getJSONObject(i).getBigDecimal("price")).divide(new BigDecimal("60.00")));
          }
        }
      }
    }
    return Result.ok().data("account",account.toString()).data("bonus",bonus);
  }


}

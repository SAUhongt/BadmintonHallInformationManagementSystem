package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import java.sql.Date;

/**
 * @author SRDZ
 * @date 2023/1/14 15:18
 */
public class Payment {

  @TableId(type = IdType.AUTO)
  private int id;

  private Integer memberId;

  private int bonus;

  private String info;

  private Date payTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public int getBonus() {
    return bonus;
  }

  public void setBonus(int bonus) {
    this.bonus = bonus;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  @Override
  public String toString() {
    return "Payment{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", bonus=" + bonus +
        ", info='" + info + '\'' +
        ", payTime=" + payTime +
        '}';
  }
}

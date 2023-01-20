package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author SRDZ
 * @date 2023/1/5 20:27
 */
public class Field {

  @TableId(type = IdType.AUTO)
  private int id;

  private String name;

  private String priceInfo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPriceInfo() {
    return priceInfo;
  }

  public void setPriceInfo(String priceInfo) {
    this.priceInfo = priceInfo;
  }

  @Override
  public String toString() {
    return "Field{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", priceInfo='" + priceInfo + '\'' +
        '}';
  }
}

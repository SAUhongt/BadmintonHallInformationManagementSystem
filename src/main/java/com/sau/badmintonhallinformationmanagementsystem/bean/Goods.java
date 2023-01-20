package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author SRDZ
 * @date 2023/1/9 18:09
 */
public class Goods {

  @TableId(type = IdType.AUTO)
  private int id;

  private String name;

  private String price;

  private int bonus;

  private int stock;

  private String info;

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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public int getBonus() {
    return bonus;
  }

  public void setBonus(int bonus) {
    this.bonus = bonus;
  }

  @Override
  public String toString() {
    return "Goods{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", bonus=" + bonus +
        ", stock=" + stock +
        ", info='" + info + '\'' +
        '}';
  }
}

package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author SRDZ
 * @date 2023/1/3 18:04
 */
public class Coach {

  @TableId(type = IdType.AUTO)
  private int id;

  private String name;

  private int grade;

  private String royaltyRatio;

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

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public String getRoyaltyRatio() {
    return royaltyRatio;
  }

  public void setRoyaltyRatio(String royaltyRatio) {
    this.royaltyRatio = royaltyRatio;
  }

  @Override
  public String toString() {
    return "Coach{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", grade=" + grade +
        ", royaltyRatio='" + royaltyRatio + '\'' +
        '}';
  }
}

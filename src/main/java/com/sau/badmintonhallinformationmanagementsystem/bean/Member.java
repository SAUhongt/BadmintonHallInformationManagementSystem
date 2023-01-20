package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Date;

/**
 * @author SRDZ
 * @date 2023/1/5 21:13
 */
public class Member {

  @TableId(type = IdType.AUTO)
  private int id;

  private String name;

  private Date birthday;

  private int point;

  private String royalty;

  private String grade;

  private String cardType;

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

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public String getRoyalty() {
    return royalty;
  }

  public void setRoyalty(String royalty) {
    this.royalty = royalty;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", birthday=" + birthday +
        ", point=" + point +
        ", royalty='" + royalty + '\'' +
        ", grade='" + grade + '\'' +
        ", cardType='" + cardType + '\'' +
        '}';
  }
}

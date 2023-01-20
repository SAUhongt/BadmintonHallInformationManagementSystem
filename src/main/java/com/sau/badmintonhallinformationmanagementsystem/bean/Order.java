package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.sql.Date;
import java.sql.Time;

/**
 * @author SRDZ
 * @date 2023/1/9 18:13
 */

@TableName("orders")
public class Order {

  @TableId(type = IdType.AUTO)
  private int id;

  private int memberId;

  @TableField(exist = false)
  private String memberName;
  private int coachId;

  @TableField(exist = false)
  private String coachName;

  private int fieldId;

  @TableField(exist = false)
  private String fieldName;

  private int courseId;

  @TableField(exist = false)
  private String courseName;
  private String startDate;
  private String  startTime;

  private String  endTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMemberId() {
    return memberId;
  }

  public void setMemberId(int memberId) {
    this.memberId = memberId;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public int getCoachId() {
    return coachId;
  }

  public void setCoachId(int coachId) {
    this.coachId = coachId;
  }

  public String getCoachName() {
    return coachName;
  }

  public void setCoachName(String coachName) {
    this.coachName = coachName;
  }

  public int getFieldId() {
    return fieldId;
  }

  public void setFieldId(int fieldId) {
    this.fieldId = fieldId;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", memberName='" + memberName + '\'' +
        ", coachId=" + coachId +
        ", coachName='" + coachName + '\'' +
        ", fieldId=" + fieldId +
        ", fieldName='" + fieldName + '\'' +
        ", courseId=" + courseId +
        ", courseName='" + courseName + '\'' +
        ", startDate='" + startDate + '\'' +
        ", startTime='" + startTime + '\'' +
        ", endTime='" + endTime + '\'' +
        '}';
  }
}

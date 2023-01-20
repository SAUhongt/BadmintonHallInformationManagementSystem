package com.sau.badmintonhallinformationmanagementsystem.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author SRDZ
 * @date 2023/1/9 18:13
 */

@TableName("orders")
public class Order {

  @TableId(type = IdType.AUTO)
  private int id;

  private Integer memberId;

  @TableField(exist = false)
  private String memberName;
  private Integer coachId;

  @TableField(exist = false)
  private String coachName;

  private Integer fieldId;

  @TableField(exist = false)
  private String fieldName;

  private Integer courseId;

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

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public Integer getCoachId() {
    return coachId;
  }

  public void setCoachId(Integer coachId) {
    this.coachId = coachId;
  }

  public String getCoachName() {
    return coachName;
  }

  public void setCoachName(String coachName) {
    this.coachName = coachName;
  }

  public Integer getFieldId() {
    return fieldId;
  }

  public void setFieldId(Integer fieldId) {
    this.fieldId = fieldId;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
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

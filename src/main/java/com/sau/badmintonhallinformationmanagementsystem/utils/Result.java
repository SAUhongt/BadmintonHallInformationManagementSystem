package com.sau.badmintonhallinformationmanagementsystem.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SRDZ
 * @date 2023/1/3 15:59
 */
public class Result {

  private boolean succes;

  private Integer code;

  private String message;

  private Map<String ,Object> data = new HashMap<String,Object>();

  private Result(){}

  public boolean isSucces() {
    return succes;
  }

  public void setSucces(boolean succes) {
    this.succes = succes;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }

  public static Result ok(){
    Result r = new Result();
    r.setSucces(true);
    r.setCode(ResultCode.success);
    r.setMessage("成功");
    return r;
  }

  public static Result error(){
    Result r = new Result();
    r.setSucces(false);
    r.setCode(ResultCode.error);
    r.setMessage("失败");
    return r;
  }

  public Result data(String key,Object value){
    this.data.put(key,value);
    return this;
  }

  public Result message(String message){
    this.message=message;
    return this;
  }
}

package com.sau.badmintonhallinformationmanagementsystem.service;

import com.sau.badmintonhallinformationmanagementsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SRDZ
 * @date 2023/1/9 18:46
 */

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public Boolean isExist(String userName,String password){
    int total=userMapper.userTotal(userName,password);
    if(total!=0)
      return true;
    return false;
  }
}

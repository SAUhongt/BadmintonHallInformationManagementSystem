package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.sau.badmintonhallinformationmanagementsystem.bean.User;
import com.sau.badmintonhallinformationmanagementsystem.mapper.UserMapper;
import com.sau.badmintonhallinformationmanagementsystem.service.UserService;
import com.sau.badmintonhallinformationmanagementsystem.utils.JwtUtil;
import com.sau.badmintonhallinformationmanagementsystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SRDZ
 * @date 2022/12/31 15:17
 */

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper userMapper;

  @PostMapping("/login")
  public Result login(@RequestBody User user){

    if(userService.isExist(user.getUserName(),user.getPassword())){
      String token = JwtUtil.generateToken(user.getUserName());
      return Result.ok().data("token",token);
    }else{
      return Result.error().message("用户名或密码不存在");
    }

  }

  @GetMapping("/info")
  public Result info(String token){
    String userName = JwtUtil.getClaimsByToken(token).getSubject();
    User user = userMapper.queryUserByUserName(userName);
    if(user!=null) {
      user.setPassword("******");
      return Result.ok().data("name", user.getUserName()).data("avatar","http://localhost:8080/touxiang.gif");
    }
    return Result.error().message("用户不存在");
  }

  @GetMapping("logout")
  public Result logout(){
    return Result.ok();
  }
}

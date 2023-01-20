package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/9 18:22
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

  @Select("select count(0) from user where user_name = #{userName} and password = #{password}")
  int userTotal(@Param("userName") String userName,@Param("password") String password);

  @Select("select * from user where user_name = #{userName}")
  User queryUserByUserName(@Param("userName") String userName);
}

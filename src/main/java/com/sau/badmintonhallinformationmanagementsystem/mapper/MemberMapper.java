package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.Member;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/9 22:11
 */

@Repository
public interface MemberMapper extends BaseMapper<Member> {

  @Select("select * from member")
  List<Member> findAll();

  @Select("select name from member where id = #{id}")
  String selectNameById(int id);

  @Delete("delete from member where id = #{id}")
  int deleteById(@Param("id") int id);
}

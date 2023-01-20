package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/9 19:27
 */
@Repository
public interface CoachMapper extends BaseMapper<Coach> {

  @Select("select * from coach")
  List<Coach> findAll();

  @Select("select name from coach where id = #{id}")
  String selectNameById(int id);

  @Delete("delete from coach where id = #{id}")
  int deleteById(@Param("id") int id);
}

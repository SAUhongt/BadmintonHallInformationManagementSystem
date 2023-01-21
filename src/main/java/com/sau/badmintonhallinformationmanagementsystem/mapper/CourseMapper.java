package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import com.sau.badmintonhallinformationmanagementsystem.bean.Course;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/14 14:32
 */

@Repository
public interface CourseMapper extends BaseMapper<Course> {

  @Select("select * from course where id like #{like} or name like #{like} limit 50")
  List<Course > findAll(String like);

  @Select("select name from course where id = #{id}")
  String selectNameById( int id);

  @Delete("delete from course where id = #{id}")
  int deleteById(@Param("id") int id);
}

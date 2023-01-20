package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Member;
import com.sau.badmintonhallinformationmanagementsystem.bean.Order;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/19 15:25
 */

@Repository
public interface OrderMapper extends BaseMapper<Order> {

  @Select("select * from orders")
  @Results(
      {
          @Result(column = "id", property = "id"),
          @Result(column = "member_id", property = "memberId"),
          @Result(column = "field_id", property = "fieldId"),
          @Result(column = "coach_id", property = "coachId"),
          @Result(column = "course_id", property = "courseId"),
          @Result(column = "start_date", property = "startDate"),
          @Result(column = "start_time", property = "startTime"),
          @Result(column = "end_time", property = "endTime"),
          @Result(column = "member_id", property = "memberName", javaType = String.class,
              one = @One(select = "com.sau.badmintonhallinformationmanagementsystem.mapper.MemberMapper.selectNameById")),
          @Result(column = "field_id", property = "fieldName", javaType = String.class,
              one = @One(select = "com.sau.badmintonhallinformationmanagementsystem.mapper.FieldMapper.selectNameById")),
          @Result(column = "coach_id", property = "coachName", javaType = String.class,
              one = @One(select = "com.sau.badmintonhallinformationmanagementsystem.mapper.CoachMapper.selectNameById")),
          @Result(column = "course_id", property = "courseName", javaType = String.class,
              one = @One(select = "com.sau.badmintonhallinformationmanagementsystem.mapper.CourseMapper.selectNameById"))
      }
  )
  List<Order> findAll();

  @Delete("delete from orders where id = #{id}")
  int deleteById(@Param("id") int id);

  Page<Order> findOrderPage(Page<Order> page);
}

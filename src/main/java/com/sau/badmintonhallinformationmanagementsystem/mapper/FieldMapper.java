package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import com.sau.badmintonhallinformationmanagementsystem.bean.Field;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/9 21:53
 */

@Repository
public interface FieldMapper extends BaseMapper<Field> {

  @Select("select * from field where id like #{like} or name like #{like} limit 50")
  List<Field> findAll(String like);

  @Select("select name from field where id = #{id}")
  String selectNameById(int id);

  @Delete("delete from field where id = #{id}")
  int deleteById(@Param("id") int id);
}

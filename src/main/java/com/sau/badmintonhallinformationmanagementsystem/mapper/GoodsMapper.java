package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.Goods;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/14 14:26
 */

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

  @Select("select * from goods")
  List<Goods> findAll();

  @Delete("delete from goods where id = #{id}")
  int deleteById(@Param("id") int id);
}

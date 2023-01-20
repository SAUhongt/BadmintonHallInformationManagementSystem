package com.sau.badmintonhallinformationmanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sau.badmintonhallinformationmanagementsystem.bean.Goods;
import com.sau.badmintonhallinformationmanagementsystem.bean.Payment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SRDZ
 * @date 2023/1/19 17:32
 */

@Repository
public interface PaymentMapper extends BaseMapper<Payment> {

  @Select("select * from payment")
  List<Goods> findAll();

  @Delete("delete from payment where id = #{id}")
  int deleteById(@Param("id") int id);
}

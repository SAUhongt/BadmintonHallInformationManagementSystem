package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Order;
import com.sau.badmintonhallinformationmanagementsystem.mapper.OrderMapper;
import com.sau.badmintonhallinformationmanagementsystem.utils.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SRDZ
 * @date 2023/1/19 15:47
 */

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderMapper orderMapper;

  @GetMapping
  public Result findAll(){
    List list = orderMapper.findAll();
    if(list!=null)
      return Result.ok().data("items",list);
    return Result.error().message("异常");
  }

  @GetMapping("/list")
  public Result findAll(int pageNum,int pageSize){
    Page<Order> page = new Page<>(pageNum,pageSize);
    IPage iPage = orderMapper.findOrderPage(page);
    if(iPage!=null)
      return Result.ok().data("page",iPage);
    return Result.error().message("异常");
  }

  @PostMapping
  public Result add(@RequestBody Order order){

    int result = orderMapper.insert(order);
    if(result!=0)
      return Result.ok().message("插入成功");
    return Result.error().message("插入失败");
  }

  @PutMapping
  public Result update(@RequestBody Order order){
    int result = orderMapper.updateById(order);
    if(result!=0)
      return Result.ok().message("更新成功");
    return Result.error().message("更新失败");
  }

  @DeleteMapping("/{id}")
  public Result delete(@PathVariable int id){

    int result = orderMapper.deleteById(id);
    if(result!=0)
      return Result.ok().message("删除成功");
    return Result.error().message("删除失败");
  }

  @GetMapping("/exist")
  public Result orderExist(int flag,int id){
    /*
    *  1 会员
    * 2 教练
    * 3 场地
    * 4 课程
    * */
    int result = 0;

    if(flag == 1){
      result = orderMapper.existOrderByMemberId(id);
    }else if(flag == 2){
      result = orderMapper.existOrderByCoachId(id);
    }else if(flag == 3){
      result = orderMapper.existOrderByFieldId(id);
    }else if(flag == 4){
      result = orderMapper.existOrderByCourseId(id);
    }else{
      return Result.error().message("标志错误");
    }

    return Result.ok().data("sum",result);
  }

}

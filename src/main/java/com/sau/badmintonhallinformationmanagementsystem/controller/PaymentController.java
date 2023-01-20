package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import com.sau.badmintonhallinformationmanagementsystem.bean.Member;
import com.sau.badmintonhallinformationmanagementsystem.bean.Payment;
import com.sau.badmintonhallinformationmanagementsystem.mapper.MemberMapper;
import com.sau.badmintonhallinformationmanagementsystem.mapper.PaymentMapper;
import com.sau.badmintonhallinformationmanagementsystem.service.PaymentService;
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
 * @date 2023/1/14 15:21
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  private PaymentMapper paymentMapper;

  @Autowired
  private PaymentService paymentService;

  @GetMapping
  public Result findAll(){
    List list = paymentMapper.findAll();
    if(list!=null)
      return Result.ok().data("items",list);
    return Result.error().message("异常");
  }

  @GetMapping("/list")
  public Result findAll(int pageNum,int pageSize){
    Page<Payment> page = new Page<>(pageNum,pageSize);
    IPage iPage = paymentMapper.selectPage(page,null);
    if(iPage!=null)
      return Result.ok().data("page",iPage);
    return Result.error().message("异常");
  }

  @PostMapping
  public Result add(@RequestBody Payment payment){

    int result = paymentService.insert(payment);
    if(result!=0)
      return Result.ok().message("插入成功");
    return Result.error().message("插入失败");
  }

  @PutMapping
  public Result update(@RequestBody Payment payment){
    int result = paymentMapper.updateById(payment);
    if(result!=0)
      return Result.ok().message("更新成功");
    return Result.error().message("更新失败");
  }

  @DeleteMapping("/{id}")
  public Result delete(@PathVariable int id){

    int result = paymentMapper.deleteById(id);
    if(result!=0)
      return Result.ok().message("删除成功");
    return Result.error().message("删除失败");
  }
}

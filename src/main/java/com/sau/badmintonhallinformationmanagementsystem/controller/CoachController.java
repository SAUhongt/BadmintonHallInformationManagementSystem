package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import com.sau.badmintonhallinformationmanagementsystem.mapper.CoachMapper;
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
 * @date 2023/1/3 18:06
 */

@RestController
@RequestMapping("/coach")
public class CoachController {

  @Autowired
  private CoachMapper coachMapper;

  @GetMapping
  public Result findAll(){
    List<Coach> list = coachMapper.findAll();
    if(list!=null)
      return Result.ok().data("items",list);
    return Result.error().message("异常");
  }

  @GetMapping("/list")
  public Result findAll(int pageNum,int pageSize){
    Page<Coach> page = new Page<>(pageNum,pageSize);
    IPage iPage = coachMapper.selectPage(page,null);
    if(iPage!=null)
      return Result.ok().data("page",iPage);
    return Result.error().message("异常");
  }

  @PostMapping
  public Result add(@RequestBody Coach coach){
    int result = coachMapper.insert(coach);
    if(result!=0)
      return Result.ok().message("插入成功");
    else
      return Result.error().message("插入失败");
  }

  @PutMapping
  public Result update(@RequestBody Coach coach){
    int result = coachMapper.updateById(coach);
    if(result!=0)
      return Result.ok().message("更新成功");
    else
      return Result.error().message("更新失败");
  }

  @DeleteMapping("/{id}")
  public Result delete(@PathVariable int id){

    int result = coachMapper.deleteById(id);
    if(result!=0)
      return Result.ok().message("删除成功");
    else
      return Result.error().message("删除失败");
  }

}

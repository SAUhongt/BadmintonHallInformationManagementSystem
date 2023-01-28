package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import com.sau.badmintonhallinformationmanagementsystem.bean.Field;
import com.sau.badmintonhallinformationmanagementsystem.mapper.FieldMapper;
import com.sau.badmintonhallinformationmanagementsystem.utils.Result;
import com.sau.badmintonhallinformationmanagementsystem.utils.TimeUtil;
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
 * @date 2023/1/3 18:20
 */

@RestController
@RequestMapping("/field")
public class FieldController {

  @Autowired
  private FieldMapper fieldMapper;

  @GetMapping
  public Result findAll(String like){
    List list = fieldMapper.findAll(like);
    if(list!=null)
      return Result.ok().data("items",list);
    return Result.error().message("异常");
  }

  @GetMapping("/list")
  public Result findAll(int pageNum,int pageSize){
    Page<Field> page = new Page<>(pageNum,pageSize);
    IPage iPage = fieldMapper.selectPage(page,null);
    if(iPage!=null)
      return Result.ok().data("page",iPage);
    return Result.error().message("异常");
  }

  @PostMapping
  public Result add(@RequestBody Field field){
    int result = fieldMapper.insert(field);
    if(result!=0)
      return Result.ok().message("插入成功");
    return Result.error().message("插入失败");
  }

  @PutMapping
  public Result update(@RequestBody Field field){
    int result = fieldMapper.updateById(field);
    if(result!=0)
      return Result.ok().message("更新成功");
    return Result.error().message("更新失败");
  }

  @DeleteMapping("{id}")
  public Result delete(@PathVariable int id){

    int result = fieldMapper.deleteById(id);
    if(result!=0)
      return Result.ok().message("删除成功");
    return Result.error().message("删除失败");
  }

  @GetMapping("/exist")
  public Result isExist(int id){
    QueryWrapper<Field> queryWrapper = new QueryWrapper<>();
    int result = fieldMapper.selectCount(queryWrapper.eq("id",id));
    if(result!=0){
      return Result.ok().data("exist",true);
    }
    return Result.ok().data("exist",false);
  }

  @PostMapping("/fullOver")
  public Result isfullOver(@RequestBody Field field){
    boolean result = TimeUtil.isFullOver(JSON.parseArray(field.getPriceInfo()));
    if(result){
      return Result.ok().data("fullOver",true);
    }
    return Result.ok().data("fullOver",false);
  }
}

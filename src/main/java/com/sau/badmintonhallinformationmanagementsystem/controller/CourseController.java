package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Coach;
import com.sau.badmintonhallinformationmanagementsystem.bean.Course;
import com.sau.badmintonhallinformationmanagementsystem.mapper.CoachMapper;
import com.sau.badmintonhallinformationmanagementsystem.mapper.CourseMapper;
import com.sau.badmintonhallinformationmanagementsystem.utils.Result;
import java.util.List;
import javax.xml.ws.soap.Addressing;
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
 * @date 2023/1/14 14:34
 */

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CourseMapper courseMapper;

  @GetMapping
  public Result findAll(String like){
    List list = courseMapper.findAll(like);
    if(list!=null)
      return Result.ok().data("items",list);
    return Result.error().message("异常");
  }

  @GetMapping("/list")
  public Result findAll(int pageNum,int pageSize){
    Page<Course> page = new Page<>(pageNum,pageSize);
    IPage iPage = courseMapper.selectPage(page,null);
    if(iPage!=null)
      return Result.ok().data("page",iPage);
    return Result.error().message("异常");
  }

  @PostMapping
  public Result add(@RequestBody Course course){
    int result = courseMapper.insert(course);
    if(result!=0)
      return Result.ok().message("插入成功");
    return Result.error().message("插入失败");
  }

  @PutMapping
  public Result update(@RequestBody Course course){
    int result = courseMapper.updateById(course);
    if(result!=0)
      return Result.ok().message("更新成功");
    return Result.error().message("更新失败");
  }

  @DeleteMapping("/{id}")
  public Result deleteById(@PathVariable int id){
    int result = courseMapper.deleteById(id);
    if(result!=0)
      return Result.ok().message("删除成功");
    return Result.error().message("删除失败");
  }

}

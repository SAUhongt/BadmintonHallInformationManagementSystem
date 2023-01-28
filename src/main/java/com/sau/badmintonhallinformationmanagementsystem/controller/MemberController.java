package com.sau.badmintonhallinformationmanagementsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sau.badmintonhallinformationmanagementsystem.bean.Member;
import com.sau.badmintonhallinformationmanagementsystem.mapper.MemberMapper;
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
 * @date 2023/1/3 18:23
 */

@RestController
@RequestMapping("/member")
public class MemberController {

  @Autowired
  private MemberMapper memberMapper;

  @GetMapping
  public Result findAll(String like){
    List list = memberMapper.findAll(like);
    if(list!=null)
      return Result.ok().data("items",list);
    return Result.error().message("异常");
  }

  @GetMapping("/list")
  public Result findAll(int pageNum,int pageSize){
    Page<Member> page = new Page<>(pageNum,pageSize);
    IPage iPage = memberMapper.selectPage(page,null);
    if(iPage!=null)
      return Result.ok().data("page",iPage);
    return Result.error().message("异常");
  }

  @PostMapping
  public Result add(@RequestBody Member member){

    int result = memberMapper.insert(member);
    if(result!=0)
      return Result.ok().message("插入成功");
    return Result.error().message("插入失败");
  }

  @PutMapping
  public Result update(@RequestBody Member member){
    int result = memberMapper.updateById(member);
    if(result!=0)
      return Result.ok().message("更新成功");
    return Result.error().message("更新失败");
  }

  @DeleteMapping("/{id}")
  public Result delete(@PathVariable int id){

    int result = memberMapper.deleteById(id);
    if(result!=0)
      return Result.ok().message("删除成功");
    return Result.error().message("删除失败");
  }

  @GetMapping("/exist")
  public Result isExist(int id){
    QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
    int result = memberMapper.selectCount(queryWrapper.eq("id",id));
    if(result!=0){
      return Result.ok().data("exist",true);
    }
    return Result.ok().data("exist",false);
  }

  @GetMapping("/birthday")
  public Result isBirthday(String key){
    QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
    List list = memberMapper.selectList(queryWrapper.like("birthday","%"+key));
    return Result.ok().data("items",list).data("total",list.size());
  }

}

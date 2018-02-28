package com.yzu.zhang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yzu.zhang.model.Member;
import com.yzu.zhang.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController{
	
  @Autowired
  private MemberService memberService;
  
  @RequestMapping(value="/add", method={RequestMethod.GET})
  public String add(){
    return "member/add";
  }
  
  @RequestMapping(value="/list", method={RequestMethod.GET})
  public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
	  ModelAndView view = new ModelAndView("member/list");
	  List<Member> list = new ArrayList<Member>();
	  Member member = new Member("1024", "zhanglei");
	  list.add(member);
	  member = new Member("1234", "yzuzhang");
	  list.add(member);
      view.addObject("memberList", list);
      return view;
  }
  
  @RequestMapping(value={"/addMember"},method={RequestMethod.POST})
  public ModelAndView addMember(HttpServletRequest request,HttpServletResponse response,
      @ModelAttribute("member")Member member){
    Map<String,Object> map = new HashMap<String, Object>();
    String info = member.toString();
    System.out.println("member:"+info);
    map.put("message", "成功添加数据到库," + member);
    memberService.add(member);
    map.put("message", "成功添加数据到库:" + info);
    return toView("member/message", map);
  }
  
  @RequestMapping(value={"/{id:\\d+}/query","/{id:\\d+}/query.html"},method={RequestMethod.GET,RequestMethod.POST})
  public ModelAndView queryMember(HttpServletRequest request,HttpServletResponse response,
      @PathVariable("id")String id){
    Map<String,Object> map = new HashMap<String, Object>();
    System.out.println(id);
    Member member = this.memberService.get(id);
    if(null!=member){
      map.put("message", "查询Id=" + id + "的用户名为:" + member.getNickname());
    }else{
      map.put("message", "没有查询到与Id=" + id + "相关的数据");
    }
    return toView("member/message", map);
  }
  
  @RequestMapping(value={"/{id:\\d+}/delete","/{id:\\d+}/delete.html"},method={RequestMethod.GET,RequestMethod.POST})
  public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response,
      @PathVariable("id")String id){
    Map<String,Object> map = new HashMap<String, Object>();
    try {
      this.memberService.delete(id);
      map.put("message", "删除Id为" + id +"的用户成功.");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("message", "删除Id为" + id +"的用户失败, "+e.getMessage());
    }
    return toView("member/message", map);	
  }
  
}
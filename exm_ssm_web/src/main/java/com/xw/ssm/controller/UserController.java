package com.xw.ssm.controller;

import com.xw.ssm.domain.Role;
import com.xw.ssm.domain.UserInfo;
import com.xw.ssm.service.IUserInfoService;
import com.xw.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xw
 * @date 2019-05-15 21:04
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userInfoService.findAll();
        mv.addObject("userList",userInfos);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:/user/findAll.do";
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        //根据用户id 查询用户信息
        UserInfo userInfo = userService.findById(id);
        //获取该用户未拥有的角色
        List<Role> roleList = userService.findOtherRole(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "userId",required = true)Integer userId,@RequestParam(value = "ids",required = true) Integer roleIds[]){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:/user/findAll.do";
    }
}

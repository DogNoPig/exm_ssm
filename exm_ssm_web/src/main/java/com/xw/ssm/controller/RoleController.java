package com.xw.ssm.controller;

import com.xw.ssm.domain.Permission;
import com.xw.ssm.domain.Role;
import com.xw.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色控制
 * @author xw
 * @date 2019/5/17 15:15
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam("id")Integer roleId){
        ModelAndView mv = new ModelAndView();
        //查询角色信息
        Role role = roleService.findById(roleId);
        //查询该角色未拥有的权限信息
        List<Permission> permissionList = roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 关联权限-角色信息
     * @param roleId
     * @param permissionIds
     * @return
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(value = "roleId",required = true)Integer roleId,@RequestParam(value = "ids",required = true)Integer permissionIds[]){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:/role/findAll.do";
    }
}

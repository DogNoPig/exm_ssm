package com.xw.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xw.ssm.domain.SysLog;
import com.xw.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xw
 * @date 2019/5/21 10:08
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)Integer page
                                ,@RequestParam(name = "size",required = true,defaultValue = "1")Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAllByPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }


}

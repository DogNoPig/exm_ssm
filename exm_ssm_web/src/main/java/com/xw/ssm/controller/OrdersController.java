package com.xw.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.xw.ssm.domain.Orders;
import com.xw.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单控制
 * @author xw
 * @date 2019-05-14 22:05
 */
@RequestMapping("/orders")
@Controller
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    //未分页
   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "10")
                                        Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAllByPage(page, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-list");
        System.out.println("ordersList++++"+ordersList.toString());
        mv.addObject("ordersList", ordersList);
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10")
                                        Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAllByPage(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer ordersId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}

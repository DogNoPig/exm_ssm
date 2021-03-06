package com.xw.ssm.controller;

import com.xw.ssm.domain.SysLog;
import com.xw.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志切面类
 * @author xw
 * @date 2019-05-20 23:19
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private ISysLogService sysLogService;
    @Autowired
    private HttpServletRequest request;
    //开始时间
    private Date visitTime;
    //访问的类
    private Class clazz;
    //访问的方法
    private Method method;

    //前置通知 主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* com.xw.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = jp.getTarget().getClass();//具体访问的类
        String methodName = jp.getSignature().getName();//获取访问的方法的名称
        Object[] args = jp.getArgs();//获取访问的方法参数

        //获取具体执行的方法的method的对象
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName);//只能获取无参数的方法
        }else{
            Class[] classArgs = new Class[args.length];
            for (int i = 0;i<args.length;i++){
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }
    }

    String url = "";

    //后置通知
    @After("execution(* com.xw.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        Long time = System.currentTimeMillis() - visitTime.getTime();//获取执行时长

        //获取URL
        if (clazz != null && method != null && clazz != LogAop.class){
            //1.获取类上的注解
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(XXX)的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null && !classValue[0].equals("/sysLog")){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];


                    //获取访问的ip地址
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文获取登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String userName = user.getUsername();

                    //封装日志信息
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setUserName(userName);
                    sysLog.setVisitTime(visitTime);
                    sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());

                    //记录日志操作
                    sysLogService.save(sysLog);
                }
            }
        }
    }




}

package com.property_management.configure;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 唯一索引错误，出现重复字段内容。
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = {java.sql.SQLIntegrityConstraintViolationException.class})
    @ResponseBody
    public ModelAndView  sqlIntegrityConstraintViolationException(Exception e,HttpServletRequest request){
        ModelAndView mv =new ModelAndView();
        // 设置跳转的视图名称.使用请求转发关键字forward，越过mvc视图配置
        mv.setViewName("forward:/register.jsp");
        request.setAttribute("SQLIntegrityConstraintViolationException","此电话号码已被注册！");
        return mv;

    }

//    @ExceptionHandler(value = {java.lang.IllegalStateException.class})
//    @ResponseBody
//    public String illegalStateException(HttpServletRequest request){
//        System.out.println("出错啦");
//        return "出错啦";
//    }
}

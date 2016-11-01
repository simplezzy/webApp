package com.core;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Erichou on 10/19/16.
 */
public class DefinedInterceptor implements HandlerInterceptor{
    @Override
    /**
     * 在目标方法之前被调用
     * 当返回为true:则继续调用后续的拦截器和方法;
     * 当反回为false,则不会再调用后续的拦截器和方法;
     * 可以考虑做权限/日志/事务
    */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    /**
    * 在试图渲染之前被调用
     * 可以对请求域中的属性或视图作修改
    */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * 在视图渲染之后被调用
     * 可以释放资源
     * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}

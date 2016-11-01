package com.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Erichou on 10/25/16.
 */

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        System.out.println("Exception:" + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }
}
 
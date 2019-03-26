package com.jm.technic.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类
 */
@Configuration
public class GlobalException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
//        if (e instanceof IOException) {
//
//        }
        modelAndView.setViewName("error/error");
        modelAndView.addObject("error", e.toString());
        return modelAndView;
    }
}

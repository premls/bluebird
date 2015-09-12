package com.bluebird.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {

    private static final String DEFAULT_LAYOUT = "templates/layout";
    private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "body";

    /*@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.hasView()) {
            return;
        }
        
        String originalViewName = modelAndView.getViewName();
        if (originalViewName.startsWith("redirect:") || originalViewName.startsWith("forward:")) {
        	modelAndView.setViewName(originalViewName.split(":")[1]);
            return;
        }
       
        modelAndView.setViewName(DEFAULT_LAYOUT);
        
        modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, originalViewName);
    }*/

    /**
     * This code can be used when using more than one layout in our application
     * 
     * */
    
    
   /* private void layoutProperties(Object handler, ModelAndView modelAndView) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Layout layout = getMethodOrTypeAnnotation(handlerMethod);
        if (layout != null) {

        }
    }

    private Layout getMethodOrTypeAnnotation(HandlerMethod handlerMethod) {
        Layout layout = handlerMethod.getMethodAnnotation(Layout.class);
        if (layout == null) {
            return handlerMethod.getBeanType().getAnnotation(Layout.class);
        }
        return layout;
    }*/

}
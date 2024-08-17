package com.lechi.managementsystem.Error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserCannotBeAddedException.class)
    public ModelAndView handleUserCantBeAddedException(CustomException e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFound(CustomException e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

}

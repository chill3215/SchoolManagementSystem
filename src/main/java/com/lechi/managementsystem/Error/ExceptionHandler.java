package com.lechi.managementsystem.Error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExists.class)
    public ModelAndView handleUserCantBeAddedException(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("msg", "User cant be added: "+ e.getMessage());
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFound.class)
    public ModelAndView handleUserNotFound(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("msg", "User cannot be found: " + e.getMessage());
        return modelAndView;
    }

}

package com.lechi.managementsystem.Error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserCannotBeAddedException.class)
    public ModelAndView handleUserCannotBeAddedException(CustomException e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserCannotBeUpdatedException.class)
    public ModelAndView handleUserCannotBeUpdatedException(CustomException e){
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

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder explanation = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String message = error.getDefaultMessage();
            explanation.append(message).append("; ");
        });

        CustomException exception = new DataFromUserNotValid(explanation.toString(), "Please check your data input" );
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(){
        CustomException exception = new DataFromUserNotValid("This academic ID has already been used", "Please provide another unique value");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}

package com.lechi.managementsystem.Error;

import org.springframework.validation.beanvalidation.MethodValidationAdapter;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException e) throws UserDataNotValidException{
        StringBuilder explanation = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String message = error.getDefaultMessage();
            explanation.append(message).append("; ");
        });
//        throw new UserDataNotValidException(explanation.toString(), "Please check again your data input");
        CustomException exception = new UserDataNotValidException(explanation.toString(), "Please check again your data input" );
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(UserDataNotValidException.class)
//    public ModelAndView handleUserDataNotValidException(CustomException e){
//        CustomException exception = new UserDataNotValidException(explanation.toString(), "Please check again your data input" );
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("exception", e);
//    }
}

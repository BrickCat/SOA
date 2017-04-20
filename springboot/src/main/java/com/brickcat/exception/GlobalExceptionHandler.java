package com.brickcat.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Seven on 17/4/19.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("execption",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);

        return mav;
    }
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Error");
        r.setMessage(e.getMessage());
        r.setUrl(request.getRequestURL().toString());
        return r;
    }
}

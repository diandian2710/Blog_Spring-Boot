package com.wang.exception;

import com.wang.result.Result;
import com.wang.result.ResultFactory;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleAuthorizationException(UnauthorizedException e){
        String message = "权限认证失败";
        return ResultFactory.buildFailResult(message);
    }
}

package com.flightmap.demo.Controller;

import com.flightmap.demo.Common.CustomException.CommonReturnType;
import com.flightmap.demo.Common.CustomException.TransactionException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandleAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        Map<String, Object> responseData = new HashMap<>();
        if (e instanceof TransactionException) {
            TransactionException businessException = (TransactionException)e;
            responseData.put("errCode", businessException.getErrorCode());
            responseData.put("errMsg", businessException.getErrorMsg());
        }
        else{
            responseData.put("errCode",response.getStatus()+10000);
            responseData.put("errMsg", e.toString());
        }
        return CommonReturnType.create(responseData,"fail");
    }
}

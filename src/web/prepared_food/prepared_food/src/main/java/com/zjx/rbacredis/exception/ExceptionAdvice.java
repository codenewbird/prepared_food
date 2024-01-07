package com.zjx.rbacredis.exception;

import com.zjx.rbacredis.annotation.HasPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ControllerAdvice
public class ExceptionAdvice {
    public static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(HasNotRoleException.class)
    public ResultVO handleException(HasNotRoleException e) {
        ResultVO result = new ResultVO();
        result.setMessage("系统异常信息："+e.getMessage());
        return result;
    }

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public ResultVO handleException(RuntimeException e) {
//        ResultVO result = new ResultVO();
//        result.setStatus("500");
//        result.setMessage("运行异常："+e.getMessage());
//        return result;
//    }

}
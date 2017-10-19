package com.lk.dome.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.Result;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error(e.getMessage(), e);
        Result res = new Result(500, "SYSTEM_EXCEPTIONS", "系统异常");
        return ResponseEntity.ok(res);
    }
}

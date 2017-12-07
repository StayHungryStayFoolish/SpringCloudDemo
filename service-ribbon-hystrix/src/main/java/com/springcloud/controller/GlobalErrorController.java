package com.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bonismo@hotmail.com
 * 上午10:02 on 17/12/7.
 * <p>
 * Zuul 错误处理机制
 */
@RestController
@RequestMapping(value = "/error")
public class GlobalErrorController extends AbstractErrorController {

    private static Logger logger = LoggerFactory.getLogger(GlobalErrorController.class);

    @Autowired
    public GlobalErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    public ResponseEntity<Message<String>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status.is5xxServerError()) {
            logger.info("--500");
        }
        Message<String> msg = new Message<>(Message.FAIL, "Zuul 服务器繁忙");
        msg.setCode(status.value());
        msg.setData(status.getReasonPhrase());
        return new ResponseEntity<Message<String>>(msg, status);
    }
}

class Message<T> {

    private String result;//操作结果
    private int code;//错误码
    private String msg;// 说明信息
    private T data;//数据信息
    static final String SUCCESS = "SUCCESS";
    static final String FAIL = "FAIL";

    public Message() {
        this.result = SUCCESS;
        this.msg = "成功！";
    }

    public Message(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
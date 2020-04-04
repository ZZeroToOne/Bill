package com.zero.bill.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zengzhx
 * @date 2020/4/3 3:50 PM
 */
@RestController
@RequestMapping("/zero/bill/")
public class LoginController extends BaseController{

    /**
     * 登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public ResponseEntity<String> login(HttpServletRequest request) {


        return new ResponseEntity<String>("Hello Bill", HttpStatus.OK);
    }
}

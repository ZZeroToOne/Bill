package com.zero.bill.controller;

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
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        return "";
    }
}

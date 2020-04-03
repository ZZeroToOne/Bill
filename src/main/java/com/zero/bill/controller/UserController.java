package com.zero.bill.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zengzhx
 * @date 2020/4/3 3:56 PM
 */
@RestController
@RequestMapping("/zeror/bill/user")
public class UserController extends BaseController{

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String modifyUserInfo() {

        return "";
    }


}

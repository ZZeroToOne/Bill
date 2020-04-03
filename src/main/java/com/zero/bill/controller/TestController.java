package com.zero.bill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zengzhx
 * @date 2020/4/3 12:39 PM
 */
@RestController
@RequestMapping("/a")
public class TestController {

    @RequestMapping("/b")
    public String getA() {
        return "133";
    }
}

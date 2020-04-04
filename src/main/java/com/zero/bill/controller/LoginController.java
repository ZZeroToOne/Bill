package com.zero.bill.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.bill.Service.UserDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zengzhx
 * @date 2020/4/3 3:50 PM
 */
@RestController
@RequestMapping("/zero/bill/")
public class LoginController extends BaseController{

    @Autowired
    private UserDAO userService;

    /**
     * 登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> login(HttpServletRequest request, @RequestParam(name = "userName") String userName,
                                        @RequestParam(name = "password") String password)
    {

        if (StringUtils.isBlank(userName) && StringUtils.isBlank(password)) {
            JSONObject rnt = new JSONObject();
            rnt.put("code", 400);
            rnt.put("msg", "参数类型错误！");
            return new ResponseEntity<String>(rnt.toJSONString(), HttpStatus.OK);
        }


        return new ResponseEntity<String>("Hello Bill", HttpStatus.OK);
    }
}

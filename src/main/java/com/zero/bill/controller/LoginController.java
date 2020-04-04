package com.zero.bill.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.bill.Common.BaseRespnseBuilder;
import com.zero.bill.Service.UserDAO;
import com.zero.bill.bean.UserEntity;
import com.zero.bill.bean.base.BaseResCode;
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
    public ResponseEntity<String> login(HttpServletRequest request, @RequestParam(name = "loginName") String loginName,
                                        @RequestParam(name = "password") String password)
    {

        if (StringUtils.isBlank(loginName) && StringUtils.isBlank(password))
        {
            // 请求参数不正确
            return new ResponseEntity<>(BaseRespnseBuilder.commonFail(BaseResCode.PARAMS_ERROR), HttpStatus.OK);
        }

        //TODO 2020-04-04
        // 后期需要 加入特殊字符判断校验

        UserEntity entity = userService.login(StringUtils.trim(loginName));
        if (entity == null || !StringUtils.trim(password).equals(entity.getPassword()))
        {
            // 用户密码错误
            return new ResponseEntity<>(BaseRespnseBuilder.commonFail(BaseResCode.PWD_ERROR), HttpStatus.OK);
        }

        entity.setPassword(null);
        return new ResponseEntity<>(BaseRespnseBuilder.successBaseRes(BaseResCode.SUCCESS.getCode(), entity), HttpStatus.OK);
    }
}

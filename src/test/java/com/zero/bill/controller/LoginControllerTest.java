package com.zero.bill.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

/**
 * @author Zengzhx
 * @date 2020/4/4 4:56 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//配置mock
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void login() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/zero/bill/login").accept(MediaType.APPLICATION_JSON)
                .param("loginName", "admin")
                .param("password", "admin")).andReturn();
        System.out.println(result.getModelAndView().getModel());
    }

}
package com.zero.bill.Service.ServiceImpl;

import com.zero.bill.Service.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Zengzhx
 * @date 2020/4/4 3:48 PM
 */

@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserDAO userService;


    @Test
    public void login() throws Exception {
        System.out.println(userService.login("aaaa", "aaaaa"));
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void modifyUser() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}
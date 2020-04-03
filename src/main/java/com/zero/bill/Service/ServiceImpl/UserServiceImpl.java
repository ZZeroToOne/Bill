package com.zero.bill.Service.ServiceImpl;

import com.zero.bill.Service.UserDAO;
import com.zero.bill.bean.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author Zengzhx
 * @date 2020/4/3 4:11 PM
 */
@Service("userService")
public class UserServiceImpl implements UserDAO{
    @Override
    public void login(String username, String password) {

    }

    @Override
    public void add(UserEntity userEntity) {

    }

    @Override
    public void modifyUser(UserEntity userEntity) {

    }

    @Override
    public void delete(long userId) {

    }
}

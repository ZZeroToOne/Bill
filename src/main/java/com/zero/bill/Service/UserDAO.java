package com.zero.bill.Service;

import com.zero.bill.bean.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Zengzhx
 * @date 2020/4/3 4:02 PM
 */

public interface UserDAO {

    void login(String username, String password);

    void add(UserEntity userEntity);

    void modifyUser(UserEntity userEntity);

    void delete(long userId);

}

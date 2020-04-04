package com.zero.bill.Service;

import com.zero.bill.bean.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Zengzhx
 * @date 2020/4/3 4:02 PM
 */

public interface UserDAO {

    UserEntity login(String loginName);

    boolean add(UserEntity userEntity);

    boolean modifyUser(UserEntity userEntity);

    boolean delete(long userId);

}

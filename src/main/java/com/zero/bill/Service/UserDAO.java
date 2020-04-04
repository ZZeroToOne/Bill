package com.zero.bill.Service;

import com.zero.bill.bean.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Zengzhx
 * @date 2020/4/3 4:02 PM
 */

public interface UserDAO {

    boolean login(String username, String password);

    boolean add(UserEntity userEntity);

    boolean modifyUser(UserEntity userEntity);

    boolean delete(long userId);

}

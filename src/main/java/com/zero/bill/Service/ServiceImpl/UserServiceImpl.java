package com.zero.bill.Service.ServiceImpl;

import com.zero.bill.Service.UserDAO;
import com.zero.bill.bean.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Zengzhx
 * @date 2020/4/3 4:11 PM
 */
@Service("userService")
public class UserServiceImpl implements UserDAO{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public UserEntity login(String loginName) {
        String sql = "SELECT user_id as userId, login_name as loginName, password , user_name as userName, email, phone  " +
                "FROM tb_user WHERE login_name = :loginName AND is_delete=0";
        Map<String, Object> params = new HashMap<>(1);
        params.put("loginName", loginName);
        BeanPropertyRowMapper<UserEntity> mapper = new BeanPropertyRowMapper<>(UserEntity.class);
        UserEntity userEntity = null;
        try {
            userEntity = jdbcTemplate.queryForObject(sql, params, mapper);
        }catch (DataAccessException e) {
            logger.error("", e);
        }

        return userEntity;
    }

    @Override
    public boolean add(UserEntity userEntity) {
        String sql = "INSERT INTO tb_user VALUES (:userId, :loginName, :passWord, :userName, :email, :phone)";

        return false;
    }

    @Override
    public boolean modifyUser(UserEntity userEntity) {
        return false;
    }

    @Override
    public boolean delete(long userId) {
        return false;
    }
}

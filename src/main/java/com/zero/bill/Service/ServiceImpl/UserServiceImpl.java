package com.zero.bill.Service.ServiceImpl;

import com.zero.bill.Service.UserDAO;
import com.zero.bill.bean.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

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
    public boolean login(String username, String password) {
//        String realname=null;
//        String realpassword=null;
//        int id=0;
//        // 声明Connection对象
//        Connection con;
//        // 驱动程序名
//        String driver = "com.mysql.jdbc.Driver";
//        // URL指向要访问的数据库名 test
//        String url = "jdbc:mysql://121.36.140.128:3306/test?serverTimezone=UTC";
//        // MySQL配置时的用户名
//        String sqluser = "root";
//        // MySQL配置时的密码
//        String sqlpassword = "admin";
//        //准备连接数据库，先搜账户再比对密码
//        try{
//            // 加载驱动程序
//            Class.forName(driver);
//            // 1.getConnection()方法，连接MySQL数据库！！
//            con = DriverManager.getConnection(url, sqluser, sqlpassword);
//            if (!con.isClosed())
//                System.out.println("\n\t\t成功以 " + sqluser + " 身份连接到数据库！！！");
//            // 2.创建statement类对象，用来执行SQL语句！！
//            Statement statement = con.createStatement();
//            // 要执行的SQL语句
//            String sql = String.format("select password from usrinfo where name=%s",username);
//            // 3.ResultSet类，用来存放获取的结果集！！
//            ResultSet rs = statement.executeQuery(sql);
//
//            if(!rs.next()) return; //登录失败
//            else if (!rs.getString("password").equals(username)) return;//登录失败
//            else{
//                //登录成功
//
//            }
//        }catch (ClassNotFoundException e) {
//            // 数据库驱动类异常处理
//            System.out.println("Sorry,can`t find the Driver!");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            // 数据库连接失败异常处理
//            e.printStackTrace();
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        } finally {
//            System.out.println("\t\t\t\t\t\t\t\t登录成功");
//        }

        String sql = "SELECT password FROM usrinfo WHERE name = :name";
        Map<String, Object> params = new HashMap<>(1);
        params.put("name", username);
        try {
           String pwd = jdbcTemplate.queryForObject(sql, params, String.class);
           return password.equals(pwd);
        }catch (DataAccessException e) {
            logger.error("", e);
            return false;
        }
    }

    @Override
    public boolean add(UserEntity userEntity) {
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

package com.zero.bill.Service.ServiceImpl;

import com.zero.bill.Service.UserDAO;
import com.zero.bill.bean.UserEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Zengzhx
 * @date 2020/4/3 4:11 PM
 */
@Service("userService")
public class UserServiceImpl implements UserDAO{
    @Override
    public void login(String username, String password) {
        String realname=null;
        String realpassword=null;
        int id=0;
        // 声明Connection对象
        Connection con;
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名 test
        String url = "jdbc:mysql://121.36.140.128:3306/test?serverTimezone=UTC";
        // MySQL配置时的用户名
        String sqluser = "root";
        // MySQL配置时的密码
        String sqlpassword = "admin";
        //准备连接数据库，先搜账户再比对密码
        try{
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, sqluser, sqlpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + sqluser + " 身份连接到数据库！！！");
            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句
            String sql = String.format("select password from usrinfo where name=%s",username);
            // 3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);

            if(!rs.next()) return; //登录失败
            else if (!rs.getString("password").equals(username)) return;//登录失败
            else{
                //登录成功

            }
        }catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("\t\t\t\t\t\t\t\t登录成功");
        }
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

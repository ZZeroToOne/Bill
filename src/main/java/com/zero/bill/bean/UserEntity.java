package com.zero.bill.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用户信息
 *
 * @author Zengzhx
 * @date 2020/4/3 4:06 PM
 */
public class UserEntity {
    int ID = 0;
    String name = null;
    String password = null;
    // 声明Connection对象
    Connection con;
    // 驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名 test
    String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
    // MySQL配置时的用户名
    String sqluser = "root";
    // MySQL配置时的密码
    String sqlpassword = "";

    // 遍历查询结果集
    public UserEntity() {
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, sqluser, sqlpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + sqluser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句
            String sql = "select * from usrinfo";
            // 3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("\n\t\t执行结果如下所示:");
            System.out.println("\t\t-----------------------------------------------------------------");
            System.out.println("\t\t|\t" + "ID" + "\t" + "name" + "\t" + "password" + "\t\t");
            System.out.println("\t\t-----------------------------------------------------------------");


            while (rs.next()) {
                // 获取 ID 这列数据
                ID = rs.getInt("ID");
                // 获取 Name 这列数据
                name = rs.getString("name");
                // 获取 Sex 这列数据
                password = rs.getString("password");
                // 获取 Age 这列数据
                //Age = rs.getInt("Age");
                // 获取 Phone 这列数据
                //Phone = rs.getString("Phone");
                // 获取 Address 这列数据
                //Address = rs.getString("Address");
                // 输出结果
                System.out.println("\t\t|\t" + ID + "\t" + name + "\t" + password + "\t|\t\t");
            }
            System.out.println("\t\t-----------------------------------------------------------------");
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
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
            System.out.println("\t\t\t\t\t\t\t\t获取数据库数据完毕！!！");
        }
    }

}

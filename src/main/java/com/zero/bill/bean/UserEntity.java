package com.zero.bill.bean;


/**
 * 用户信息
 *
 * @author Zengzhx
 * @date 2020/4/3 4:06 PM
 */
public class UserEntity {

    private int id = 0;
    private String name = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

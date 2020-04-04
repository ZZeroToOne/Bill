package com.zero.bill.bean.base;

/**
 * @author Zengzhx
 * @date 2020/4/4 4:33 PM
 */
public enum BaseResCode {

    SUCCESS(0, "成功"),

    FAIL(1, "失败"),

    NET_ERROR(2, "网络异常"),

    PARAMS_ERROR(4, "参数类型错误"),

    PWD_ERROR(5, "账户密码错误");


    private int code;
    private String description;

    BaseResCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

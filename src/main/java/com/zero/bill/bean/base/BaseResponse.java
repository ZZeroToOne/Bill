package com.zero.bill.bean.base;

/**
 * @author Zengzhx
 * @date 2020/4/4 4:24 PM
 */
public class BaseResponse {

    private int code;

    private Object data;

    private String msg;

    public BaseResponse() {}

    public BaseResponse(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

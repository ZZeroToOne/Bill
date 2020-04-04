package com.zero.bill.Common;

import com.alibaba.fastjson.JSONObject;
import com.zero.bill.bean.base.BaseResCode;
import com.zero.bill.bean.base.BaseResponse;

/**
 * @author Zengzhx
 * @date 2020/4/4 4:28 PM
 */
public class BaseRespnseBuilder {

    /**
     * 构建放回成功对象
     * @param code
     * @param data
     * @return
     */
    public static String successBaseRes(int code, Object data){
        BaseResponse res = new BaseResponse(code, data);
        return JSONObject.toJSONString(res);
    }

    /**
     * 构建返回失败对象
     * @param code
     * @param msg
     * @return
     */
    public static String failBaseRes(int code, String msg){
        BaseResponse res = new BaseResponse(code, msg);
        return JSONObject.toJSONString(res);
    }

    /**
     * 常见错误对象
     * @param resCode
     * @return
     */
    public static String commonFail(BaseResCode resCode){
        BaseResponse res = new BaseResponse(resCode.getCode(), resCode.getDescription());
        return JSONObject.toJSONString(res);
    }

}

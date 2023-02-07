package com.example.tradingplatform.response;

import com.example.tradingplatform.exception.AppExceptionCodeMsg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Resp<T> implements Serializable {

    @ApiModelProperty(value = "成功标志")
    private boolean success;
    @ApiModelProperty(value = "错误代码")
    private int err;
    @ApiModelProperty(value = "错误文本")
    private String msg;
    @ApiModelProperty(value = "业务数据")
    private T data;


    public static <T> Resp ok(){
        Resp<T> resp = new Resp<T>();
        resp.setSuccess(true);
        return resp;
    }

    public static <T> Resp ok(T data){
        Resp<T> resp = new Resp<T>();
        resp.setSuccess(true);
        resp.setData(data);
        return resp;
    }

     public static <T> Resp fail(int err,String msg){
         Resp<T> resp = new Resp<T>();
         resp.setSuccess(false);
         resp.setErr(err);
         resp.setMsg(msg);
         return resp;
     }

    public static <T> Resp fail(AppExceptionCodeMsg appExceptionCodeMsg){
        Resp<T> resp = new Resp<T>();
        resp.setSuccess(false);
        resp.setErr(appExceptionCodeMsg.getCode());
        resp.setMsg(appExceptionCodeMsg.getMsg());
        return resp;
    }

}

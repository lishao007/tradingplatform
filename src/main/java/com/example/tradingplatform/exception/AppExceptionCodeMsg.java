package com.example.tradingplatform.exception;

//这个枚举类中定义的都是跟业务有关的异常
public enum AppExceptionCodeMsg {

    INVALID_CODE(1000,"验证码无效"),
    USER_NOT_EXISTS(1001,"账号或密码错误，该用户不存在"),
    PASSWORD_IS_NULL(1002,"密码为空"),
    USER_IS_EXISTS(1003,"用户已存在"),
    PRODUCT_NOT_EXISTS(1004,"商品库存不足"),
    INSERT_FALSE(1005,"批量插入失败"),
    ORDER_FALSE(1006,"下单失败"),
    USER_FALSE(1007,"用户更改信息失败");
    ;

    private int code ;
    private String msg ;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    AppExceptionCodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}

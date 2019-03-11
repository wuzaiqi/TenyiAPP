package com.sxzx.bean;

//提交订单Bean
public class SubmitRepairOrderBean {

    /**
     * error_code : 0
     * msg : 提交成功
     * trade_no : 201902251138208601
     */

    private int error_code;
    private String msg;
    private String trade_no;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
}

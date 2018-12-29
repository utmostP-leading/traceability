package com.sagroup.tracibility.entities;

/**
 * @Description: 规整化返回信息，收到请求后返回的对象
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
public class ResultEntity {

    private int errCode;
    private String msg;
    private Object data;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "errCode=" + errCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

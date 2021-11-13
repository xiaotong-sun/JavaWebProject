package com.example.book.domain;

public class ResultInfo {
    private boolean flag;       // 请求是否成功
    private String errorMsg;    // 错误信息
    private Object data;        // 请求成功返回的对象

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

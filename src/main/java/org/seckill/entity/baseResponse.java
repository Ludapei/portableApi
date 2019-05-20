package org.seckill.entity;

public class baseResponse {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public baseResponse(int code, String data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public String toString() {
        return "baseResponse{" +
                "code=" + code +
                ", data='" + data + '\'' +
                '}';
    }

    private int code; // 1:成功;0:失败
    private String data;

}

package com.example.shop.entity;
//统一返回格式
public class JsonString {
	// http 状态码
	private Integer code;
	// 返回的数据
    private Object data;
    // 返回信息
	private String msg;
    public JsonString(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
	public JsonString() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
	

	
}

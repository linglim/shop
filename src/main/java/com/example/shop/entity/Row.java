package com.example.shop.entity;

import net.minidev.json.JSONObject;

public class Row {

	private String styleid;
	private float ratio;
	private JSONObject data;
	public String getStyleid() {
		return styleid;
	}
	public void setStyleid(String styleid) {
		this.styleid = styleid;
	}
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	
	
	
	
}

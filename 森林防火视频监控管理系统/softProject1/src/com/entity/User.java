package com.entity;

import org.springframework.stereotype.Component;

/**
 * 用户实体类
 * @author Congchong Fu
 *
 */
@Component
public class User {
	private int uid;//用户id，主键、自增
	private String pwd;//用户名
	private String utype;//密码
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	
}

package com.entity;

import org.springframework.stereotype.Component;

/**
 * �û�ʵ����
 * @author Congchong Fu
 *
 */
@Component
public class User {
	private int uid;//�û�id������������
	private String pwd;//�û���
	private String utype;//����
	
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

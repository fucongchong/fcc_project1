package com.entity;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 学生实体
 * @author Congchong Fu
 *
 */
@Component
public class Student {
	private String SNo;
	private String SN;
	private String gender;
	private String Dept;
	private String Clas;
	private List<Student> stuArray;
	public String getSNo() {
		return SNo;
	}
	public void setSNo(String sNo) {
		SNo = sNo;
	}
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public String getClas() {
		return Clas;
	}
	public void setClas(String clas) {
		Clas = clas;
	}
	public List<Student> getStuArray() {
		return stuArray;
	}
	public void setStuArray(List<Student> stuArray) {
		this.stuArray = stuArray;
	}
	
	
}

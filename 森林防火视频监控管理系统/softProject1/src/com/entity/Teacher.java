package com.entity;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
private String TID;
private String TN;
private String gender;
private String TProfess;
private String Tel;
public String getTID() {
	return TID;
}
public void setTID(String tID) {
	TID = tID;
}
public String getTN() {
	return TN;
}
public void setTN(String tN) {
	TN = tN;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getTProfess() {
	return TProfess;
}
public void setTProfess(String tProfess) {
	TProfess = tProfess;
}
public String getTel() {
	return Tel;
}
public void setTel(String tel) {
	Tel = tel;
}

}

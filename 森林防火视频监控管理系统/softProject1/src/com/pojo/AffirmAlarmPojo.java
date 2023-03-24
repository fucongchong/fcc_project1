package com.pojo;

import java.util.List;

public class AffirmAlarmPojo {
private int aid;
private int mid;
private String mpaddress;
private List<AffirmAlarmPojo> affirmArray;

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMpaddress() {
	return mpaddress;
}
public void setMpaddress(String mpaddress) {
	this.mpaddress = mpaddress;
}
public List<AffirmAlarmPojo> getAffirmArray() {
	return affirmArray;
}
public void setAffirmArray(List<AffirmAlarmPojo> affirmArray) {
	this.affirmArray = affirmArray;
}

}

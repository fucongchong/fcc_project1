package com.po;

import java.util.List;

public class StastisticsPo {
private int countFire;
private int astatusRight;
private int astatusWrong;
private int astatusNull;
private String adate;
private List<StastisticsPo> staArray;

public int getCountFire() {
	return countFire;
}

public void setCountFire(int countFire) {
	this.countFire = countFire;
}





public int getAstatusRight() {
	return astatusRight;
}

public void setAstatusRight(int astatusRight) {
	this.astatusRight = astatusRight;
}

public int getAstatusWrong() {
	return astatusWrong;
}

public void setAstatusWrong(int astatusWrong) {
	this.astatusWrong = astatusWrong;
}

public int getAstatusNull() {
	return astatusNull;
}

public void setAstatusNull(int astatusNull) {
	this.astatusNull = astatusNull;
}

public String getAdate() {
	return adate;
}

public void setAdate(String adate) {
	this.adate = adate;
}

public List<StastisticsPo> getStaArray() {
	return staArray;
}

public void setStaArray(List<StastisticsPo> staArray) {
	this.staArray = staArray;
}

}

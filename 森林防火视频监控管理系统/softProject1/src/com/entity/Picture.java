package com.entity;

import java.util.List;

public class Picture {
private int pid;
private String pname;
private String presolution;
private String pdaddress;
private String paddress;
private String type;
private String pdate;
private int poid;
private int puid;
private String pcmethod;
private List<Picture> picArray;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPresolution() {
	return presolution;
}
public void setPresolution(String presolution) {
	this.presolution = presolution;
}
public String getPdaddress() {
	return pdaddress;
}
public void setPdaddress(String pdaddress) {
	this.pdaddress = pdaddress;
}
public String getPaddress() {
	return paddress;
}
public void setPaddress(String paddress) {
	this.paddress = paddress;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPdate() {
	return pdate;
}
public void setPdate(String pdate) {
	this.pdate = pdate;
}
public int getPoid() {
	return poid;
}
public void setPoid(int poid) {
	this.poid = poid;
}
public int getPuid() {
	return puid;
}
public void setPuid(int puid) {
	this.puid = puid;
}
public String getPcmethod() {
	return pcmethod;
}
public void setPcmethod(String pcmethod) {
	this.pcmethod = pcmethod;
}
public List<Picture> getPicArray() {
	return picArray;
}
public void setPicArray(List<Picture> picArray) {
	this.picArray = picArray;
}

}

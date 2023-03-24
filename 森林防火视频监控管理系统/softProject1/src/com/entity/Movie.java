package com.entity;

import java.util.List;

public class Movie {
private int mid;
private String mname;
private String mdate;
private String mpaddress;
private String mdaddress;
private String mtype;
private int mlocation;
private int muid;
private List<Movie> movieArray;
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getMdate() {
	return mdate;
}
public void setMdate(String mdate) {
	this.mdate = mdate;
}
public String getMpaddress() {
	return mpaddress;
}
public void setMpaddress(String mpaddress) {
	this.mpaddress = mpaddress;
}
public String getMdaddress() {
	return mdaddress;
}
public void setMdaddress(String mdaddress) {
	this.mdaddress = mdaddress;
}
public String getMtype() {
	return mtype;
}
public void setMtype(String mtype) {
	this.mtype = mtype;
}
public int getMlocation() {
	return mlocation;
}
public void setMlocation(int mlocation) {
	this.mlocation = mlocation;
}
public int getMuid() {
	return muid;
}
public void setMuid(int muid) {
	this.muid = muid;
}
public List<Movie> getMovieArray() {
	return movieArray;
}
public void setMovieArray(List<Movie> movieArray) {
	this.movieArray = movieArray;
}

}

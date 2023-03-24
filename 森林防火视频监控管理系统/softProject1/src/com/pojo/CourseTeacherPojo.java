package com.pojo;

import java.util.List;

public class CourseTeacherPojo {
private String TID;
private String TN;
private String status;
private String CoursePeriod;
private String CN;
private List<CourseTeacherPojo> CTPArray;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCoursePeriod() {
	return CoursePeriod;
}
public void setCoursePeriod(String coursePeriod) {
	CoursePeriod = coursePeriod;
}
public List<CourseTeacherPojo> getCTPArray() {
	return CTPArray;
}
public void setCTPArray(List<CourseTeacherPojo> cTPArray) {
	CTPArray = cTPArray;
}
public String getCN() {
	return CN;
}
public void setCN(String cN) {
	CN = cN;
}

}

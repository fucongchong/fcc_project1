package com.pojo;

import java.util.List;
import java.util.Map;

public class PaperPojo {
private List<String> TopicIDArray;
private String PID;
private String PN;
private String author;
private String provenance;
private String keyword;
private String digest;
private String filePhysicalLocation;
private String uploadTime;
private List<PaperPojo> papjoArray;
private Map<String, Object> retMap;

public List<String> getTopicIDArray() {
	return TopicIDArray;
}

public void setTopicIDArray(List<String> topicIDArray) {
	TopicIDArray = topicIDArray;
}

public String getPID() {
	return PID;
}

public void setPID(String pID) {
	PID = pID;
}

public String getPN() {
	return PN;
}

public void setPN(String pN) {
	PN = pN;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getProvenance() {
	return provenance;
}

public void setProvenance(String provenance) {
	this.provenance = provenance;
}

public String getKeyword() {
	return keyword;
}

public void setKeyword(String keyword) {
	this.keyword = keyword;
}

public String getDigest() {
	return digest;
}

public void setDigest(String digest) {
	this.digest = digest;
}

public String getFilePhysicalLocation() {
	return filePhysicalLocation;
}

public void setFilePhysicalLocation(String filePhysicalLocation) {
	this.filePhysicalLocation = filePhysicalLocation;
}

public String getUploadTime() {
	return uploadTime;
}

public void setUploadTime(String uploadTime) {
	this.uploadTime = uploadTime;
}

public List<PaperPojo> getPapjoArray() {
	return papjoArray;
}

public void setPapjoArray(List<PaperPojo> papjoArray) {
	this.papjoArray = papjoArray;
}

public Map<String, Object> getRetMap() {
	return retMap;
}

public void setRetMap(Map<String, Object> retMap) {
	this.retMap = retMap;
}

}

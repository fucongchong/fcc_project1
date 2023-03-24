package com.pojo;

import java.util.List;

public class StuTopicPojo {
private String TopicID;
private String TopicName;
private String keyWord;
private String TN;
private List<PaperPojo> paperArray;
private List<StuTopicPojo> stutpArray;
private int stuTopicNum;
public String getTopicID() {
	return TopicID;
}
public void setTopicID(String topicID) {
	TopicID = topicID;
}
public String getTopicName() {
	return TopicName;
}
public void setTopicName(String topicName) {
	TopicName = topicName;
}
public String getKeyWord() {
	return keyWord;
}
public void setKeyWord(String keyWord) {
	this.keyWord = keyWord;
}
public String getTN() {
	return TN;
}
public void setTN(String tN) {
	TN = tN;
}
public List<StuTopicPojo> getStutpArray() {
	return stutpArray;
}
public void setStutpArray(List<StuTopicPojo> stutpArray) {
	this.stutpArray = stutpArray;
}
public int getStuTopicNum() {
	return stuTopicNum;
}
public void setStuTopicNum(int stuTopicNum) {
	this.stuTopicNum = stuTopicNum;
}
public List<PaperPojo> getPaperArray() {
	return paperArray;
}
public void setPaperArray(List<PaperPojo> paperArray) {
	this.paperArray = paperArray;
}

}

package com.entity;

import org.springframework.stereotype.Component;

@Component
public class Topic {
private String TopicID;
private String TopicName;
private String keyWord;
private String TN;
private String createTime;
private String peopleNumber;
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
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getPeopleNumber() {
	return peopleNumber;
}
public void setPeopleNumber(String peopleNumber) {
	this.peopleNumber = peopleNumber;
}


}

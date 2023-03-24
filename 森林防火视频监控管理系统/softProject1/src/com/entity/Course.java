package com.entity;

import org.springframework.stereotype.Component;

/**
 * @author Congchong Fu
 *
 */
@Component
public class Course {
	private String CID;
	private String CN;
	private int term;
	private String CTime;
	
	
	
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCN() {
		return CN;
	}
	public void setCN(String cN) {
		CN = cN;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getCTime() {
		return CTime;
	}
	public void setCTime(String cTime) {
		CTime = cTime;
	}
	
}

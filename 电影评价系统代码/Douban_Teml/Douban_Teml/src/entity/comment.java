package entity;
public class comment {
private int cid;
private String c_time;
private String c_content;
private String c_facility;
private int useful_amount;
private double c_score;
private String see_movie_status;





public comment()
{
	
}

public comment(int cid,String c_time,String c_content,String c_facility,int useful_amount,double c_score,String see_movie_status)
{
	this.cid=cid;
	this.c_time=c_time;
	this.c_content=c_content;
	this.c_facility=c_facility;
	this.useful_amount=useful_amount;
	this.c_score=c_score;
    this.see_movie_status=see_movie_status;

}

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getC_time() {
	return c_time;
}
public void setC_time(String c_time) {
	this.c_time = c_time;
}
public String getC_content() {
	return c_content;
}
public void setC_content(String c_content) {
	this.c_content = c_content;
}
public String getC_facility() {
	return c_facility;
}
public void setC_facility(String c_facility) {
	this.c_facility = c_facility;
}
public int getUseful() {
	return useful_amount;
}
public void setUseful(int useful_amount) {
	this.useful_amount = useful_amount;
}

public double getC_score() {
	return c_score;
}

public void setC_score(double c_score) {
	this.c_score = c_score;
}

public String getSee_movie_status() {
	return see_movie_status;
}

public void setSee_movie_status(String see_movie_status) {
	this.see_movie_status = see_movie_status;
}

}
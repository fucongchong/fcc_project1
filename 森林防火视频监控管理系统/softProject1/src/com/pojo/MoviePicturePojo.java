package com.pojo;

import java.util.List;

public class MoviePicturePojo {
private int mid;
private List<String> paddress;
private List<MoviePicturePojo> moviePicArray;
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}


public List<String> getPaddress() {
	return paddress;
}
public void setPaddress(List<String> paddress) {
	this.paddress = paddress;
}
public List<MoviePicturePojo> getMoviePicArray() {
	return moviePicArray;
}
public void setMoviePicArray(List<MoviePicturePojo> moviePicArray) {
	this.moviePicArray = moviePicArray;
}

}

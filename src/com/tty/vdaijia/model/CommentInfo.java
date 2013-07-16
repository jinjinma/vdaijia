package com.tty.vdaijia.model;

public class CommentInfo {
	String phoneNo;
	String stamp;
	String comment;
	
	public CommentInfo(){
		
	}
	public CommentInfo(String phone, String stamp, String comment){
		this.phoneNo = phone;
		this.stamp = stamp;
		this.comment = comment;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the stamp
	 */
	public String getStamp() {
		return stamp;
	}
	/**
	 * @param stamp the stamp to set
	 */
	public void setStamp(String stamp) {
		this.stamp = stamp;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

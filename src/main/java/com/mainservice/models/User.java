package com.mainservice.models;


public class User {

	private int userId;
	private String userName;
	private String userEmail;
	private String creditScore;
	private int pfId;
	public User() {}
	public User(int userId, String userName, String userEmail, String creditScore, int pfId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.creditScore = creditScore;
		this.pfId = pfId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	public int getPfId() {
		return pfId;
	}
	public void setPfId(int pfId) {
		this.pfId = pfId;
	}	
}
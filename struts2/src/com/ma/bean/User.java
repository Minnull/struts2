package com.ma.bean;

public class User {
	
 
	private Integer userID;
    @Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", userpwd=" + userpwd + "]";
	}
	private String username;
    private String userpwd;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}

package com.ma.action;

import com.opensymphony.xwork2.ActionSupport;

public class loginaction extends ActionSupport {
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
	private String username;
	   private String userpwd;
   public String execute() throws Exception{
	 
	   if(username.equals(userpwd)){
		   return ERROR;
	   }
	   return SUCCESS;
   }
}

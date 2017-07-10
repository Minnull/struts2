package com.ma.action;

import com.ma.bean.User;
import com.ma.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

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
 private User user;
	public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
	private String username;
	private String userpwd;

	public String execute() throws Exception {
		UserDaoImpl userDaoImpl = new UserDaoImpl() ;
		User user=userDaoImpl.finduserByAdminname(username);
	
		if (user.getUserpwd() != null && user.getUserpwd().equals(userpwd)) {
System.out.println(user.getUsername());
			return SUCCESS;
		}
		System.out.println(user.getUsername());
		return ERROR;
	}
}

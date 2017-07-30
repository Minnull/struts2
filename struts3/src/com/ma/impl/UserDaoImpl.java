package com.ma.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ma.bean.User;
import com.ma.dao.UserDao;

import util.jdbc;


/**
 * 
 *
 * @version 
 * @author 马伟杰
 * @date 2017年7月30日 下午5:58:18
 */
public class UserDaoImpl implements UserDao {

	
	/**
	 * 
	 *
	 * @param username
	 * @return user对象
	 */
	@SuppressWarnings("unchecked")
	public User finduserByAdminname(String username) {

		String sql = "select * from user where username=?";
		jdbc jdbc = new jdbc();
		Connection conn = new jdbc().getConnection();
		User user = new User();
		Object[] params = { username };
		List<Object> itemList = jdbc.excuteQuery(sql, params);

		Map<String, Object> users = null;

		for (int j = 0; j < itemList.size(); j++) {
			users = (Map<String, Object>) itemList.get(j);

		}
		for (Entry<String, Object> vo : users.entrySet()) {
			vo.getKey();
			vo.getValue();
			if (vo.getKey().equals("userID")) {
				user.setUserID((Integer) vo.getValue());
			} else {
				if (vo.getKey().equals("username")) {
					user.setUsername((String) vo.getValue());
				} else {
					user.setUserpwd((String) vo.getValue());
				}

			}

		}

		return user;

	}

	public User findAdminByuserid(Integer userID) {
		return null;
	}

	public void adduser(User user) {
		String sql;
		user.setUserID(null);
		user.setUsername("123");
		user.setUserpwd("d");
		sql = "insert userID username userpwd into user";
		Connection conn = new jdbc().getConnection();
		jdbc jdbc = new jdbc();
		jdbc.executeUpdate(sql, null);

	}

	public void deleteuser(User user) {

	}

	public Void updateuser(User user) {
		return null;
	}

}

package org.bildit.services;

import org.bildit.beans.User;
import org.bildit.dao.UserDao;

public class AddAdmin {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		User user = new User();
		user.setUserName("Boris_Nunic");
		user.setPassword("Boris123$$");
		user.setAdminStatus(true);
		dao.addUser(user);
		
	

	}

}

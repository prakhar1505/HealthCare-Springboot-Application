package com.healthCare.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthCare.model.Users;
import com.healthCare.security.StringEncrypter;

@Repository
public class IAdminRepository {
	@Autowired
	private IUserRepository userRep;
	public void registerAdmin(String username, String password) throws Exception {
		Users user=new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("Admin");
		userRep.addUsers(user);
	}
}

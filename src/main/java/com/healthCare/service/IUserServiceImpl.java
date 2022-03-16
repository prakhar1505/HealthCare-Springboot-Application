package com.healthCare.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.dao.IUserRepository;
import com.healthCare.dao.UserRepository;
import com.healthCare.exception.UsernameNotFoundException;
import com.healthCare.model.Users;
import com.healthCare.security.StringEncrypter;

@Service
public class IUserServiceImpl implements IUserService {
	//Log4j Implementation
	static Logger log = Logger.getLogger(IUserServiceImpl.class);
	static private PatternLayout patternLayout;
	private static FileAppender fileAppender;
	static {
		patternLayout = new PatternLayout("%d ## %M ##* %p ##* %m ## %L %n");
		try {
			fileAppender = new FileAppender(patternLayout, "mylogs.log");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		log.addAppender(fileAppender);
	}
	
	
	@Autowired
	private IUserRepository userRep;
	
	//Validate if a user exists
	@Override
	public Users validateUser(String username, String password) {

		Users user=null;
		try {
			user = userRep.validateUsers(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (user == null) {
			log.error("User Not Found");
			throw new UsernameNotFoundException("User Not Found");
		}

		return user;
	}
	//Add a new user
	@Override
	public Users addUser(Users user) {
		Users u =null;
		try {
			u = userRep.addUsers(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		log.info("User Added");
		return u;
	}
	//Remove a User
	@Override
	public Users removeUser(Users user) {
		try {
			Users u = userRep.removeUsers(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		log.info("User Removed");
		return user;
	}
	@Override
	public List<Users> getAllUsers() {
		return userRep.getAllUsers();
	}
	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return userRep.removeUserById(userId);
	}

}

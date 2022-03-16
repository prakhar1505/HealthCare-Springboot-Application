package com.healthCare.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthCare.dao.IUserRepository;
import com.healthCare.dao.UserRepository;
import com.healthCare.exception.InvalidUsernameException;
import com.healthCare.model.Users;

@Service
public class ILoginServiceImpl implements ILoginService {
	
	
	
	static Logger log = Logger.getLogger(ILoginServiceImpl.class);
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
	private IUserRepository loginRepository;

	@Override
	public Users login(Users user){
		
		Users username=null;
		try {
			username = loginRepository.validateUsers(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		if (username == null) {
			log.error("Invalid Username or Passowrd");
			throw new InvalidUsernameException(
					"The username or password that you've entered doesn't match to any account");

		}
		log.info(username.getUsername()+"Logged In");
		return username;
	}

	@Override
	public Users logout(Users user) {
		// TODO Auto-generated method stub
		Users username=null;
		try {
			username = loginRepository.validateUsers(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		if (username == null) {
			log.error("Invalid Username or Passowrd");
			throw new InvalidUsernameException(
					"The username or password that you've entered doesn't match to any account");

		}
		log.info(username.getUsername()+"Logged Out");
		return username;
	}
}

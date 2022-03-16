package com.healthCare.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.healthCare.model.Users;
import com.healthCare.service.ILoginService;
import com.healthCare.service.IUserService;
import com.healthCare.service.IUserServiceImpl;

@SpringBootTest
public class TestLoginService {
	@Autowired
	private ILoginService loginService;
	@Autowired
	private IUserService userService;
	

	@Test
	public void testLogin() {
		Users user=new Users(1, "Nomaan", "abc", "Patient");
		Users user2=new Users(1, "Nomaan", "abc", "Patient");
		userService.addUser(user);
		loginService.login(user2);
	}
	@Test
	public void testLogout() {
		Users user2=new Users(1, "Nomaan", "abc", "Patient");
		loginService.logout(user2);
	}
}

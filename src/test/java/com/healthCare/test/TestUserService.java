package com.healthCare.test;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.healthCare.dao.IUserRepository;
import com.healthCare.model.Users;
import com.healthCare.service.IUserService;

@SpringBootTest
public class TestUserService {
	@Autowired
	private IUserService userService;

	@Test
	public void testAddUser() {
		Users user = new Users(1, "Nomaan", "abc", "Patient");
		userService.addUser(user);

	}

	@Test
	public void testRemoveUser() {
		Users user = new Users(1, "Nomaan", "abc", "Patient");
		userService.removeUser(user);
	}

	@Test
	public void testValidateUser() {
		String username="Nomaan";
		String password="abc";
		Users user = new Users(2, username, password, "Patient");
		userService.addUser(user);
		userService.validateUser(username, password);
	}

}

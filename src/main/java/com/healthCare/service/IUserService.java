package com.healthCare.service;

import java.util.List;

import com.healthCare.model.Users;

public interface IUserService {
	public List<Users> getAllUsers();
	public boolean deleteUserById(int userId);
	public Users validateUser(String username, String password);
	public Users addUser(Users user);
	public Users removeUser(Users user);
}

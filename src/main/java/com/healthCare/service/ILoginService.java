package com.healthCare.service;


import com.healthCare.model.Users;


public interface ILoginService {
	public Users login(Users user);
	public Users logout(Users user);
}

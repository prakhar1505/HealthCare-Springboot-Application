package com.healthCare.controller;



import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthCare.model.Users;
import com.healthCare.security.StringEncrypter;
import com.healthCare.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.healthCare.dao.UserRepository;

 

@RestController
@RequestMapping(value = "/hcr")
@Api(value = "User", tags = { "User" },description = "Controller for User")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;
    
    @GetMapping("/validateUser/{username}")
    @ApiOperation(value = "Validate a user", response = Users.class)
    public ResponseEntity<String> validateUser(@PathVariable String username,@RequestBody String password){
    	Users u=userService.validateUser(username, password);
    	return new ResponseEntity<String>("User Exists",HttpStatus.FOUND);
    }
   
    @PostMapping("/addUser")
    @ApiOperation(value = "Add a user", response = Users.class)
    public ResponseEntity<String> addUser(@RequestBody Users user) {
       // user.setPassword(encodedPassword);
    	
        userService.addUser(user);
         
        return new ResponseEntity<String>("Success",HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteUser")
    @ApiOperation(value = "Remove a user", response = Users.class)
    public ResponseEntity<String> removeUser(@RequestBody Users user){
		
		userService.removeUser(user);
		return new ResponseEntity<String>("Removed",HttpStatus.OK);
    }
    @GetMapping("/getalluser")
    @ApiOperation(value = "List of all user", response = Users.class)
    public ResponseEntity<List<Users>> getAllUser(){
    	List<Users> list=userService.getAllUsers();
    	return new ResponseEntity<List<Users>>(list,HttpStatus.OK);
    }
    @DeleteMapping("/deleteUserById/{userId}")
    @ApiOperation(value = "Remove a user by id", response = Users.class)
    public ResponseEntity<String> removeUserById(@PathVariable int userId){
		
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("Removed",HttpStatus.OK);
    }
   
}
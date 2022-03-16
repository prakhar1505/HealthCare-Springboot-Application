package com.healthCare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthCare.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/admin")
@Api(value = "Admin", tags = { "Admin" }, description = "Controller for Admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@PostMapping("/registerAdmin/{username}")
	@ApiOperation(value = "Register an Admin")
	public ResponseEntity<String> registerAdmin(@PathVariable String username,@RequestBody String password){
		adminService.registerAdmin(username, password);
		return new ResponseEntity<String>("Admin Registered",HttpStatus.CREATED);
	}
}

package com.healthCare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Specifies that class is a entity
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue
	//Primary Key for Users
	private int usersId;
	//Property of Users
	@ApiModelProperty(notes = "Username")
	private String username;
	//Property of Users
	@ApiModelProperty(notes = "password")
	private String password;
	//Property of Users
	@ApiModelProperty(notes = "role")
	private String role;
	
	
}

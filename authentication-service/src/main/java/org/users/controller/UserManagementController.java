package org.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.users.dto.UserRequest;
import org.users.dto.UserResponse;
import org.users.services.UserManagementService;

@RestController
public class UserManagementController {

	@Autowired
	UserManagementService userService;

	@PostMapping(path = "/api/v1/user", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public UserResponse adduser(@RequestBody UserRequest addUserRequest) {
		return userService.adduser(addUserRequest);

	}

	@GetMapping(path = "/api/v1/user/{userId}")
	public UserResponse getSingleUser(@PathVariable Long userId) {
		return userService.getSingleUser(userId);
	}

	@GetMapping(path = "/api/v1/user")
	public List<Long> getAllUsers() {
		return userService.getAllUserIds();
	}

	@DeleteMapping(path = "/api/v1/user/{userId}")
	public UserResponse deleteSingleUser(@PathVariable Long userId) {
		return userService.deleteUser(userId);

	}

}

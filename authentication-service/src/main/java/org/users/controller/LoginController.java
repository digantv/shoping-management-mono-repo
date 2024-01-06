package org.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.users.dto.LoginRequest;
import org.users.dto.LoginResponse;
import org.users.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping(path = "/api/v1/validate", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public LoginResponse validate(@RequestBody LoginRequest loginRequest) {

		return loginService.validateUser(loginRequest);
	}

}

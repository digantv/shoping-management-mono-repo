package org.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.users.dto.LoginRequest;
import org.users.dto.LoginResponse;
import org.users.entity.Users;
import org.users.repo.UsersRepository;

@Service
public class LoginService {

	@Autowired
	UsersRepository userRepo;

	public LoginResponse validateUser(LoginRequest loginRequest) {

		LoginResponse response = new LoginResponse();

		List<Users> liuser = userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

		if (liuser.size() == 1) {
			response.setStatus("Success");
			response.setMessage("Login Successful");
		} else {
			response.setStatus("Fail");
			response.setMessage("Login Failed!");
		}
		return response;
	}
}

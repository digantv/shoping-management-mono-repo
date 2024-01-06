package org.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.users.dto.UserData;
import org.users.dto.UserRequest;
import org.users.dto.UserResponse;
import org.users.entity.Users;
import org.users.repo.UsersRepository;

@Service
public class UserManagementService {

	@Autowired
	UsersRepository userRepo;

	public UserResponse adduser(UserRequest userRequest) {

		UserResponse response = new UserResponse();
		response.setUserData(new UserData());
		Users usersTable = new Users();

		usersTable.setAge(userRequest.getAge());
		usersTable.setEmail(userRequest.getEmail());
		usersTable.setPassword(userRequest.getPassword());
		usersTable.setUserName(userRequest.getUsername());

		userRepo.save(usersTable);

		response.setStatus("Success");
		response.setMessage("User successfully added");
		response.setUserId(usersTable.getUserId());
		response.getUserData().setAge(usersTable.getAge());
		response.getUserData().setEmail(usersTable.getEmail());
		response.getUserData().setPassword(usersTable.getPassword());
		response.getUserData().setUsername(usersTable.getUserName());

		return response;

	}

	public UserResponse getSingleUser(Long userId) {

		UserResponse userResponse = new UserResponse();

		Optional<Users> receivedData = userRepo.findById(userId);

		if (receivedData.isEmpty()) {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User not Found");
		} else {
			if (userResponse.getUserData() == null) {
				userResponse.setUserData(new UserData());
			}
			Users user = receivedData.get();
			userResponse.setStatus("success");
			userResponse.setMessage("User Found");
			userResponse.userData.setAge(user.getAge());
			userResponse.userData.setEmail(user.getEmail());
			userResponse.userData.setUsername(user.getUserName());
			userResponse.userData.setPassword(user.getPassword());
			userResponse.setUserId(user.getUserId());
		}
		return userResponse;
	}

	public UserResponse deleteUser(Long userId) {
		UserResponse userResponse = new UserResponse();

		Optional<Users> receivedData = userRepo.findById(userId);

		if (receivedData.isEmpty()) {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User not Found");
		} else {
			Users user = receivedData.get();
			if (userResponse.getUserData() == null) {
				userResponse.setUserData(new UserData());
			}
			userRepo.deleteById(userId);

			userResponse.setStatus("Success");
			userResponse.setMessage("User successfully deleted");
			userResponse.setUserId(user.getUserId());
			userResponse.userData.setAge(user.getAge());
			userResponse.userData.setEmail(user.getEmail());
			userResponse.userData.setUsername(user.getUserName());
			userResponse.userData.setPassword(user.getPassword());
		}
		return userResponse;
	}

	@Autowired
	List<Long> userIds;

	public List<Long> getAllUserIds() {
		List<Users> users = userRepo.findAll();

		for (Users user : users)
			userIds.add(user.getUserId());
		return userIds;
	}
}

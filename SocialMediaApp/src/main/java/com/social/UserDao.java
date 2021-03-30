package com.social;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.social.exception.UserNotFoundException;

@Component
public class UserDao implements IUser {

	private static List<User> userList;
	static {

		userList = new ArrayList<User>();
		userList.add(new User(1, "jatinder", "singh", "bal.jatinder09@gmail.com"));
		userList.add(new User(2, "Kamaldeep", "singh", "Kamaldeep@gmail.com"));
		userList.add(new User(3, "Rajnish", "kumar", "Rajnish@gmail.com"));
		userList.add(new User(4, "Atul", "kumar", "atul@gmail.com"));
	}

	@Override
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User findByUserId(int userId) {

		User userOpt = userList.stream().filter(user -> user.getUserId() == userId).findFirst()
				.orElseThrow(() -> new UserNotFoundException("User Not found ::" + userId));
		return userOpt;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> tempUser = userList.stream().filter(streamUser -> streamUser.getUserId() == user.getUserId())
				.findAny();
		if (tempUser.isPresent()) {
			throw new UserAleadyExistException("UserID" + user.getUserId());
		} else {
			userList.add(user);
			return user;
		}
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		System.out.print(userId);
		//User userOpt = userList.stream().filter(user -> user.getUserId() == userId).findFirst()
		//		.orElseThrow(() -> new UserNotFoundException("User Not found ::" + userId));
		if(!userList.removeIf(user -> user.getUserId() == userId))
		{
			throw new UserNotFoundException("User Not found ::" + userId);
		}
		return "sucessFully Removed";
	}

}

package com.social;

import java.util.List;

public interface IUser {
	public List<User> retrieveAllUser();
	public User findByUserId(int userId);
	public User createUser(User user);
	public String deleteUser(int userId);
}

package com.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUser {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		return userDao.retrieveAllUser();
	}

	@Override
	public User findByUserId(int userId) {
		// TODO Auto-generated method stub
		return userDao.findByUserId(userId);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userDao.createUser(user);
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

}

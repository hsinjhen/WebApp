package com.sprhib.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhib.dao.UserDAO;
import com.sprhib.model.User;
import com.sprhib.model.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public User searchById(int id) {
		return userDAO.searchById(id);
	}

	@Override
	public List<User> searchByUsername(String username) {
		return userDAO.searchByUsername(username);
	}

	@Override
	public void setUserRole(UserRole userRole) {
		userDAO.setUserRole(userRole);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public UserRole getByUserRole(Integer userId) {
		return userDAO.getByUserRole(userId);
	}

	@Override
	public void updateUserRole(UserRole userRole) {
		userDAO.updateUserRole(userRole);
	}

}

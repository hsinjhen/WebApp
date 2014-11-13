package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.User;
import com.sprhib.model.UserRole;

public interface UserDAO {

	public User getUser(String login);

	public void addUser(User user);

	public List<User> getUsers();

	public User searchById(int id);

	public List<User> searchByUsername(String username);
	
	public void setUserRole(UserRole userRole);
	
	public void updateUserRole(UserRole userRole);
	
	public UserRole getByUserRole(Integer userId);
	
	public void updateUser(User user);
}
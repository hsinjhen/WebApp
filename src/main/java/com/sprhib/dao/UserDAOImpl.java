package com.sprhib.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sprhib.model.User;
import com.sprhib.model.UserRole;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery(
				"from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	@Override
	public void addUser(User user) {
		openSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return openSession().createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User searchById(int id) {
		String sql = "from User where id=" + id;
		Query query = openSession().createQuery(sql);
		List<User> users = query.list();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchByUsername(String username) {
		String sql = "from User where login like '%" + username + "%'";
		Query query = openSession().createQuery(sql);
		List<User> users = query.list();
		return users;
	}

	@Override
	public void setUserRole(UserRole userRole) {
		openSession().save(userRole);
	}

	@Override
	public void updateUser(User user) {
		User userToUpdate = searchById(user.getId());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setRole(user.getRole());
		openSession().update(userToUpdate);
	}

	@Override
	public void updateUserRole(UserRole userRole) {
		UserRole userRoleToUpdate = getByUserRole(userRole.getUserId().getId());
		userRoleToUpdate.setRoleId(userRole.getRoleId());
		openSession().update(userRoleToUpdate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserRole getByUserRole(Integer userId) {
		String sql = "from UserRole where user_id=" + userId;
		Query query = openSession().createQuery(sql);
		List<UserRole> userRoles = query.list();
		if (!userRoles.isEmpty()) {
			return userRoles.get(0);
		}
		return null;
	}
}
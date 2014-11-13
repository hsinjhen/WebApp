package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Role;

public interface RoleDAO {

	public List<Role> getRoles();

	public Role getRole(int id);
}
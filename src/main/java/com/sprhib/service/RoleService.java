package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Role;

public interface RoleService {

	public List<Role> getRoles();

	public Role getRole(int id);

}
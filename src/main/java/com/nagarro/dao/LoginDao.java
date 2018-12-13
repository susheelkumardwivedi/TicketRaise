package com.nagarro.dao;

import com.nagarro.model.User;

public interface LoginDao {
	public User authenticateAdmin(String adminId, String password);

	public User authenticateEmployee(String employeeId, String password);
}

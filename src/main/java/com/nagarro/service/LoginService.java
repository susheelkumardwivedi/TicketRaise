package com.nagarro.service;

import com.nagarro.model.User;

public interface LoginService {
	public User authenticateAdmin(String adminId, String password);

	public User authenticateEmployee(String employeeId, String password);

}

package com.nagarro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.User;
import com.nagarro.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public User authenticateAdmin(String adminId, String password) {
		return loginDao.authenticateAdmin(adminId, password);
	}

	@Override
	public User authenticateEmployee(String employeeId, String password) {
		return loginDao.authenticateEmployee(employeeId, password);
	}

}

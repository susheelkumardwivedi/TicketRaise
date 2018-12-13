package com.nagarro.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagarro.model.User;
import com.nagarro.service.LoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/adminloginform", method = RequestMethod.GET)
	String adminLoginForm() {
		return "admin/adminloginform";
	}

	@RequestMapping(value = "/employeeloginform", method = RequestMethod.GET)
	public String employeeLoginForm() {
		return "employee/employeeloginform";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminAuthenticate(@RequestParam("adminId") String adminId,
			@RequestParam("password") String password, Map<String, Object> map) {
		String resultView = "";
		User user = loginService.authenticateAdmin(adminId, password);
		if (user != null) {
			resultView += "admin/adminview";
			map.put("user", user);
		} else {
			resultView += "admin/adminfail";
		}
		return resultView;
	}

	@RequestMapping(value = "/employeelogin", method = RequestMethod.POST)
	public String employeeAuthenticate(@RequestParam("employeeId") String employeeId,
			@RequestParam("password") String password, Map<String, Object> map) {
		String resultView = "";
		User user = loginService.authenticateEmployee(employeeId, password);
		if (user != null) {
			resultView += "employee/employeeview";
			map.put("user", user);
		} else {
			resultView += "employee/employeefail";
		}
		return resultView;
	}
}

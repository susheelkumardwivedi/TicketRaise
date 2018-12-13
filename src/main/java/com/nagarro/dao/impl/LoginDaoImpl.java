package com.nagarro.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.Admin;
import com.nagarro.model.Employee;
import com.nagarro.model.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User authenticateAdmin(String adminId, String password) {
		User result = null;
		Session session = this.getSessionFactory().openSession();
		try {
			User admin = (User) session.get(Admin.class, adminId);
			result = (admin.getEmail().equals(adminId)
					&& admin.getPassword().equals(password) && admin.getType()
					.equals("Admin")) ? admin : null;
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public User authenticateEmployee(String employeeId, String password) {
		User result = null;
		Session session = this.getSessionFactory().openSession();
		try {
			User employee = (User) session.get(Employee.class, employeeId);
			result = (employee.getEmail().equals(employeeId)
					&& employee.getPassword().equals(password) && employee
					.getType().equals("Employee")) ? employee : null;
		} catch (NullPointerException nullExp) {
			result = null;
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return result;

	}

}

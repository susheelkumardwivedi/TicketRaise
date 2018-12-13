package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1091478361911220767L;
	@Column(name = "TYPE", insertable = false, updatable = false)
	private String type;

	public Employee() {
		super();
	}

	public Employee(String fullName, String address, String email,
			String password) {
		super(fullName, address, email, password);
	}

	@Override
	public String getType() {

		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

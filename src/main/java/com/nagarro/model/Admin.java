package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4118848867665729095L;
	@Column(name = "TYPE", insertable = false, updatable = false)
	private String type;

	public Admin() {
		super();
	}

	public Admin(String name, String address, String email, String password) {
		super(name, address, email, password);
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

}

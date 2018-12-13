package com.nagarro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force = true)
@Table(name = "USER_TABLE")
public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2144404044822506593L;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "EMAIL")
	@Id
	private String email;
	@Column(name = "PASSWORD")
	private String password;

	@OneToMany(targetEntity = Ticket.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ticket> listofTicket;

	public List<Ticket> getListofTicket() {
		return listofTicket;
	}

	public void setListofTicket(List<Ticket> listofTicket) {
		this.listofTicket = listofTicket;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {

	}

	public User(String name, String address, String email, String password) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setFullName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((listofTicket == null) ? 0 : listofTicket.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (listofTicket == null) {
			if (other.listofTicket != null)
				return false;
		} else if (!listofTicket.equals(other.listofTicket))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public abstract String getType();

	public abstract void setType(String type);

}

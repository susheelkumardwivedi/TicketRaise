package com.nagarro.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTACHEMENT")
public class Attachement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2802394450311620298L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	int id;

	@Column(name = "NAME")
	String name;

	@Column(name = "SIZE")
	int size;

	@Column(name = "BINARY_FILE")
	byte[] binaryFile;

	public Attachement() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public byte[] getBinaryFile() {
		return binaryFile;
	}

	public void setBinaryFile(byte[] binaryFile) {
		this.binaryFile = binaryFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(binaryFile);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + size;
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
		Attachement other = (Attachement) obj;
		if (!Arrays.equals(binaryFile, other.binaryFile))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	
}

package com.nagarro.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET_TABLE")
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6251084169423643722L;
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "PRIORITY")
	private String priority;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "MESSAGE")
	private String message;
	@Column(name = "DATE_OF_RAISE")
	private Date dateOfRaise;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Attachement_id")
	private Attachement attachement;
	@Column(name = "DATE_OF_ACCEPT")
	private Date dateofAccept;
	@Column(name = "DATE_OF_SOLVE")
	private Date dateofSolve;
	@Column(name = "STATUS")
	private String status;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@OneToMany(targetEntity = Comment.class, mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comment;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ASSIGNED_ID")
	private User assignedTo;
	public Ticket(String type, String priority, String title, String message,
			Attachement attachement, User user) {
		super();
		this.type = type;
		this.priority = priority;
		this.title = title;
		this.message = message;
		this.attachement = attachement;
		this.user = user;
	}

	public Ticket() {
		super();
	}
	

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Attachement getAttachement() {
		return attachement;
	}

	public void setAttachement(Attachement attachement) {
		this.attachement = attachement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOfRaise() {
		return dateOfRaise;
	}

	public void setDateOfRaise(Date dateOfRaise) {
		this.dateOfRaise = dateOfRaise;
	}

	public Date getDateofAccept() {
		return dateofAccept;
	}

	public void setDateofAccept(Date dateofAccept) {
		this.dateofAccept = dateofAccept;
	}

	public Date getDateofSolve() {
		return dateofSolve;
	}

	public void setDateofSolve(Date dateofSolve) {
		this.dateofSolve = dateofSolve;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attachement == null) ? 0 : attachement.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((dateOfRaise == null) ? 0 : dateOfRaise.hashCode());
		result = prime * result
				+ ((dateofAccept == null) ? 0 : dateofAccept.hashCode());
		result = prime * result
				+ ((dateofSolve == null) ? 0 : dateofSolve.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Ticket other = (Ticket) obj;
		if (attachement == null) {
			if (other.attachement != null)
				return false;
		} else if (!attachement.equals(other.attachement))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (dateOfRaise == null) {
			if (other.dateOfRaise != null)
				return false;
		} else if (!dateOfRaise.equals(other.dateOfRaise))
			return false;
		if (dateofAccept == null) {
			if (other.dateofAccept != null)
				return false;
		} else if (!dateofAccept.equals(other.dateofAccept))
			return false;
		if (dateofSolve == null) {
			if (other.dateofSolve != null)
				return false;
		} else if (!dateofSolve.equals(other.dateofSolve))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	

}

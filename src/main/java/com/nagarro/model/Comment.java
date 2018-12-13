package com.nagarro.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="COMMENT_TABLE")
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -503605097240902977L;

	@Id
	@Column(name="id")
	int id;
	
	@Column(name="MESSAGE")
	String message;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	User user;
	@Column(name="TIME_OF_COMMENT")
	Time timeOfComment;
	@Column(name="DATE_OF_COMMENT")
	Date dateOfCommnet;
	@ManyToOne
	@JoinColumn(name="TICKET_ID")
	Ticket ticket;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getDateOfCommnet() {
		return dateOfCommnet;
	}
	
	public Time getTimeOfComment() {
		return timeOfComment;
	}
	public void setTimeOfComment(Time timeOfComment) {
		this.timeOfComment = timeOfComment;
	}
	public void setDateOfCommnet(Date dateOfCommnet) {
		this.dateOfCommnet = dateOfCommnet;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}

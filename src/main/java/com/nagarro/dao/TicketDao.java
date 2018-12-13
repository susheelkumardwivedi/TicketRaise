package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Attachement;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;

public interface TicketDao {
	boolean addTicket(Ticket ticket);

	public List<Ticket> allTicketOFEmployee(User user);
	public List<Ticket> allFilterTicket(User user,String type,String status,String priority );
	public Attachement getAttachementById(int id);
	public List<Ticket> getAllRaisedTicket();
	public void assignTicketById(User user,int ticketId);
	public Ticket getTicketById(int id);
}

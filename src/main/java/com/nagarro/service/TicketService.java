package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Attachement;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;

public interface TicketService {
	boolean addTicket(Ticket ticket);

	public List<Ticket> allTicketOFEmployee(User user);
	public List<Ticket> allFilterTicket(User user,String type,String status,String priority );
	public List<Ticket> getAllRaisedTicket();
	public Attachement getAttachementById(int id);
	public void assignTicketById(User user,int ticketId);
	public Ticket getTicketById(int id);
}

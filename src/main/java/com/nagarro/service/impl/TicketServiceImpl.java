package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.TicketDao;
import com.nagarro.model.Attachement;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;
import com.nagarro.service.TicketService;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDao ticketDao;

	@Override
	public boolean addTicket(Ticket ticket) {
		return ticketDao.addTicket(ticket);
	}

	@Override
	public List<Ticket> allTicketOFEmployee(User user) {
		return ticketDao.allTicketOFEmployee(user);
	}

	@Override
	public Attachement getAttachementById(int id) {
		return ticketDao.getAttachementById(id);
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketDao.getTicketById(id);
	}
	@Override
	public List<Ticket> allFilterTicket(User user, String type, String status,
			String priority) {
		return ticketDao.allFilterTicket(user, type, status, priority);
	}
	@Override
	public List<Ticket> getAllRaisedTicket() {
			return ticketDao.getAllRaisedTicket();
	}
	@Override
	public void assignTicketById(User user,int ticketId) {
			ticketDao.assignTicketById(user, ticketId);
	}
}


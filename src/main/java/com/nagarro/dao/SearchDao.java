package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Ticket;
import com.nagarro.model.User;

public interface SearchDao {
	public List<Ticket> searchTicket(String idOrTitle);
	public List<Ticket> searchTicket(User user,String idOrTitle);
}

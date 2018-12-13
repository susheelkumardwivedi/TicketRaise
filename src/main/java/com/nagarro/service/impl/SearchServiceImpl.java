package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.SearchDao;
import com.nagarro.model.Ticket;
import com.nagarro.model.User;
import com.nagarro.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	@Override
	public List<Ticket> searchTicket(String idOrTitle) {
		
		return searchDao.searchTicket(idOrTitle);
	}
	@Override
	public List<Ticket> searchTicket(User user, String idOrTitle) {
	
		return searchDao.searchTicket(user, idOrTitle);
	}
}

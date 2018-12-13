package com.nagarro.utill;

import java.util.Comparator;

import com.nagarro.model.Ticket;

public class TicketIdComparator implements Comparator<Ticket> {
	@Override
	public int compare(Ticket o1, Ticket o2) {
		int id1=o1.getId();
		int id2=o2.getId();
		return id1-id2;
	}
}

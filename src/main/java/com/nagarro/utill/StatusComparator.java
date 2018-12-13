package com.nagarro.utill;

import java.util.Comparator;

import com.nagarro.model.Ticket;

public class StatusComparator implements Comparator<Ticket> {
	@Override
	public int compare(Ticket o1, Ticket o2) {
		return o1.getStatus().compareTo(o2.getStatus());
	}
}

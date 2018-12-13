package com.nagarro.constants;

public enum SortType {
	TicketId("TicketId"),Priority("Priority"),Status("Status");
	private String sortType;
	private SortType(String sortType){
		this.sortType=sortType;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
}

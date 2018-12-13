package com.nagarro.constants;

public enum TicketStatus {
	Raised("Raised"),InProgress("In Progress"),Done("Done"),Closed("Closed"),Reopened("Reopened") ;
	private String statusType;
	private TicketStatus(String statusType){
		this.statusType=statusType;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
}

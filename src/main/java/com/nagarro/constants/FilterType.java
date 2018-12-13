package com.nagarro.constants;

public enum FilterType {
	Type("Type"),Status("Status"),Priority("Status");
	private String filterType;
	private FilterType(String filterType){
		this.filterType=filterType;
	}
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
}

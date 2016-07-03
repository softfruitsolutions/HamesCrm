package com.hames.enums;

public enum TaskStatus {

	PENDING("Pending"),
	COMPLETED("Completed"),
	POSTPONED("Postponed"),
	MISSED("Missed"),
	OVERDUE("Overdue");
	
	private String text;
	private TaskStatus(String text){
		this.text = text;
	}
	public String getText(){
		return text;
	}
}
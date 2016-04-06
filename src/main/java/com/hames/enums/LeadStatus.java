package com.hames.enums;

public enum LeadStatus {

	CONTACT_IN_FUTURE("Contact_In_Future"),
	CONTACTED("Contacted"),
	JUNK_LEAD("Junk_Lead"),
	LOST_LEAD("Lost_Lead"),
	NOT_CONTACTED("Not_Contacted"),
	PRE_QUALIFIED("Pre_Qualified");
	
	private String text;
	private LeadStatus(String text){
		this.text = text;
	}
	
	public String getText(){
		return text;
	}
	
}

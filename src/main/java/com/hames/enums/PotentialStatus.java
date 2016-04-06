package com.hames.enums;

public enum PotentialStatus {

	QUALIFICATION ("Qualification"),
	NEEDS_ANALYSIS("Needs_Analysis"),
	VALUE_PROPOSITION("Value_Proposition"),
	Id_Decision_Makers("Id_Desision_Makers"),
	PROPOSAL_PRICE_QUOTE("Proposal/Price_Quote"),
	NEGOTIATION_REVIEW("Negotiation/Review");
	
	private String text;
	private PotentialStatus(String text){
		this.text = text;
	}
	public String getText(){
		return text;
	}
	
}

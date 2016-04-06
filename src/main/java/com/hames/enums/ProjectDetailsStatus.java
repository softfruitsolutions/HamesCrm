package com.hames.enums;

public enum ProjectDetailsStatus {

	MEASUREMENT("Measurement"),
	DRAWING("Drawing"),
	QUOTE("Quote"),
	ADVANCE("Advance"),
	FINAL_MEASURMENT("Final_Measurment"),
	FINAL_CADD("Final_Cadd"),
	APPROVAL("Approval"),
	PRODUCTION("Production"),
	DELIVERY("Delivery"),
	PAYMENT("Payment"),
	INSTALLATION("Installation"),
	COMPLETION("Completion");
	
	private String text;
	private ProjectDetailsStatus(String text) {
		this.text = text;
	}

	public String getText(){
		return text;
	}
}

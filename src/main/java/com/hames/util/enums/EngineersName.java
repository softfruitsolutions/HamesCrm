package com.hames.util.enums;

public enum EngineersName {

	RANEEF("Raneef"),
	SHAMNAS("Shamnas"),
	AMJAD("Amjad"),
	NISHAD("Nishad");
	
	private String text;
	private EngineersName(String text){
		this.text = text;
	}
	public String getText(){
		return text;
	}
}

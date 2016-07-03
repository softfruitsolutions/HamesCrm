package com.hames.bean;

import org.springframework.data.annotation.Id;

public class NewClient extends Audit{

	@Id
	private String leadId;
	
	private String leadNo;
	private String firstName;
	private String middleName;
	private String LastName;
	private String phoneNo;
	private String mobileNo;
	private String emailId;
	
	private String address;
	private String description;
	
	
	private String projectType;
	private String buildingType;
	private String quotedAmount;
	private String negotiatedAmount;
	private String completionPeriod;
	private String totalArea;
	private String floorType;
	private String noOfRoom;
	private String notes;

	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getFloorType() {
		return floorType;
	}
	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
	public String getNoOfRoom() {
		return noOfRoom;
	}
	public void setNoOfRoom(String noOfRoom) {
		this.noOfRoom = noOfRoom;
	}
	public String getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}
	public String getQuotedAmount() {
		return quotedAmount;
	}
	public void setQuotedAmount(String quotedAmount) {
		this.quotedAmount = quotedAmount;
	}
	public String getNegotiatedAmount() {
		return negotiatedAmount;
	}
	public void setNegotiatedAmount(String negotiatedAmount) {
		this.negotiatedAmount = negotiatedAmount;
	}
	public String getCompletionPeriod() {
		return completionPeriod;
	}
	public void setCompletionPeriod(String completionPeriod) {
		this.completionPeriod = completionPeriod;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getLeadNo() {
		return leadNo;
	}
	public void setLeadNo(String leadNo) {
		this.leadNo = leadNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "NewClient [leadId=" + leadId + ", leadNo=" + leadNo
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", LastName=" + LastName + ", phoneNo=" + phoneNo
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", address=" + address + ", description=" + description
				+ ", projectType=" + projectType + ", buildingType="
				+ buildingType + ", quotedAmount=" + quotedAmount
				+ ", negotiatedAmount=" + negotiatedAmount
				+ ", completionPeriod=" + completionPeriod + ", totalArea="
				+ totalArea + ", floorType=" + floorType + ", noOfRoom="
				+ noOfRoom + ", notes=" + notes + "]";
	}
	
	
	
}

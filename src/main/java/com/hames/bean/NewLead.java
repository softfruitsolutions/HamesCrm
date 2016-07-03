package com.hames.bean;

import org.springframework.data.annotation.Id;

public class NewLead extends Audit{

	@Id
	private String leadId;
	
	private String leadNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String companyName;
	private String title;
	private String phoneNo;
	private String mobileNo;
	private String emailId;
	private String website;
	private String leadSource;
	private String leadStatus;
	private String industry;
	private String annualRevenue;
	private String noOfEmployees;
	private String address;
	private String description;
	
	
	public String getLeadNo() {
		return leadNo;
	}
	public void setLeadNo(String leadNo) {
		this.leadNo = leadNo;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
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
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	public String getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
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
		return "NewLead [leadId=" + leadId + ", leadNo=" + leadNo
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", companyName=" + companyName
				+ ", title=" + title + ", phoneNo=" + phoneNo + ", mobileNo="
				+ mobileNo + ", emailId=" + emailId + ", website=" + website
				+ ", leadSource=" + leadSource + ", leadStatus=" + leadStatus
				+ ", industry=" + industry + ", annualRevenue=" + annualRevenue
				+ ", noOfEmployees=" + noOfEmployees + ", address=" + address
				+ ", description=" + description + "]";
	}
}
	
	

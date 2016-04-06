package com.hames.bean;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class Potential extends Audit {
	
	@Id
	private String potentialId;
	
	private String leadSource;
	private String potentialName;
	private String status;
	private DateTime currentDate;
	private DateTime deliveryDate;
	private String quotedAmount;
	private String negotiatedAmount;
	private String description;
	
	
	
	public DateTime getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(DateTime currentDate) {
		this.currentDate = currentDate;
	}
	public String getPotentialId() {
		return potentialId;
	}
	public void setPotentialId(String potentialId) {
		this.potentialId = potentialId;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getPotentialName() {
		return potentialName;
	}
	public void setPotentialName(String potentialName) {
		this.potentialName = potentialName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DateTime getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(DateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Potential [potentialId=" + potentialId + ", leadSource="
				+ leadSource + ", potentialName=" + potentialName + ", status="
				+ status + ", currentDate=" + currentDate + ", deliveryDate="
				+ deliveryDate + ", quotedAmount=" + quotedAmount
				+ ", negotiatedAmount=" + negotiatedAmount + ", description="
				+ description + "]";
	}
	
	
	
}

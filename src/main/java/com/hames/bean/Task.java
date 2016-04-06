package com.hames.bean;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class Task extends Audit {
	
	@Id
	String taskId;
	
	String leadId;
	String PotId;
	String taskOwner;
	String subject;
	String eventName;
	DateTime currentDate;
	DateTime taskDate;
	String status;
	String leadName;
	String potentialName;
	String remark;
	
	
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getPotId() {
		return PotId;
	}
	public void setPotId(String potId) {
		PotId = potId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public DateTime getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(DateTime currentDate) {
		this.currentDate = currentDate;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskOwner() {
		return taskOwner;
	}
	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public DateTime getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(DateTime taskDate) {
		this.taskDate = taskDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public String getPotentialName() {
		return potentialName;
	}
	public void setPotentialName(String potentialName) {
		this.potentialName = potentialName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", leadId=" + leadId + ", PotId="
				+ PotId + ", taskOwner=" + taskOwner + ", subject=" + subject
				+ ", eventName=" + eventName + ", currentDate=" + currentDate
				+ ", taskDate=" + taskDate + ", status=" + status
				+ ", leadName=" + leadName + ", potentialName=" + potentialName
				+ ", remark=" + remark + "]";
	}
	
	

}

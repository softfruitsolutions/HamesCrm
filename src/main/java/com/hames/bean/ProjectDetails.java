package com.hames.bean;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class ProjectDetails extends Audit{
	
	@Id
	private String projectId;
	
	private String potentialName;
	private String projectName;
	private DateTime date;
	private String description;
	private String reminder;
	private String status;
	private String remark;
	private String advanceAmount;
	private String floorLevel;
	private String mainConcrete;
	private String plastering;
	private String interior;
	private String engineer;
	
	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(String floorLevel) {
		this.floorLevel = floorLevel;
	}

	public String getMainConcrete() {
		return mainConcrete;
	}

	public void setMainConcrete(String mainConcrete) {
		this.mainConcrete = mainConcrete;
	}

	public String getPlastering() {
		return plastering;
	}

	public void setPlastering(String plastering) {
		this.plastering = plastering;
	}

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPotentialName() {
		return potentialName;
	}

	public void setPotentialName(String potentialName) {
		this.potentialName = potentialName;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "ProjectDetails [projectId=" + projectId + ", potentialName="
				+ potentialName + ", projectName=" + projectName + ", date="
				+ date + ", description=" + description + ", reminder="
				+ reminder + ", status=" + status + ", remark=" + remark
				+ ", advanceAmount=" + advanceAmount + ", floorLevel="
				+ floorLevel + ", mainConcrete=" + mainConcrete
				+ ", plastering=" + plastering + ", interior=" + interior
				+ ", engineer=" + engineer + "]";
	}
	
	
}

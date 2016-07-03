package com.hames.bean;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

/**
 * 
 * @author Raneef ibn ali nhelat
 *
 */
public class InteriorProject extends Audit {
	
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
	private String levelOne;
	private String levelTwo;
	private String finishingStage;
	private String engineer;
	private String structuralEngg;
	

	public String getStructuralEngg() {
		return structuralEngg;
	}
	public void setStructuralEngg(String structuralEngg) {
		this.structuralEngg = structuralEngg;
	}
	public String getLevelOne() {
		return levelOne;
	}
	public void setLevelOne(String levelOne) {
		this.levelOne = levelOne;
	}
	public String getLevelTwo() {
		return levelTwo;
	}
	public void setLevelTwo(String levelTwo) {
		this.levelTwo = levelTwo;
	}
	public String getFinishingStage() {
		return finishingStage;
	}
	public void setFinishingStage(String finishingStage) {
		this.finishingStage = finishingStage;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPotentialName() {
		return potentialName;
	}
	public void setPotentialName(String potentialName) {
		this.potentialName = potentialName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(String advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public String getEngineer() {
		return engineer;
	}
	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}
	@Override
	public String toString() {
		return "InteriorProject [projectId=" + projectId + ", potentialName="
				+ potentialName + ", projectName=" + projectName + ", date="
				+ date + ", description=" + description + ", reminder="
				+ reminder + ", status=" + status + ", remark=" + remark
				+ ", advanceAmount=" + advanceAmount + ", levelOne=" + levelOne
				+ ", levelTwo=" + levelTwo + ", finishingStage="
				+ finishingStage + ", engineer=" + engineer
				+ ", structuralEngg=" + structuralEngg + "]";
	}
}

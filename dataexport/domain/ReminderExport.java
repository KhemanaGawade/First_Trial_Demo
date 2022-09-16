package com.filevine.dataexport.domain;

public class ReminderExport {
	
	private String reminderId=null;
	private String projectId=null;
	private String name=null;
	private String notes=null;
	private String dueDate=null;
	private String doneDate=null;
	public String getReminderId() {
		return this.reminderId;
	}
	public void setReminderId(String reminderId) {
		this.reminderId = reminderId;
	}
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getDueDate() {
		return this.dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDoneDate() {
		return this.doneDate;
	}
	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}
	@Override
	public String toString() {
		return "ReminderExport [reminderId=" + reminderId + ", projectId=" + projectId + ", name=" + name + ", notes="
				+ notes + ", dueDate=" + dueDate + ", doneDate=" + doneDate + "]";
	}
	
	

}

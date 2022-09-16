package com.filevine.dataexport.domain;

public class LitigationLogExport {
	
	private String projectId=null;
	private String inout=null;
	private String type=null;
	private String notes=null;
	private String _id=null;
	private String createdDate=null;
	private String responseDateValue=null;
	private String responseDoneDate=null;
	private String done=null;
	private String title=null;
	private String drafter_id=null;
	
	public String getDone() {
		return this.done;
	}
	public void setDone(String done) {
		this.done = done;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDrafter_id() {
		return this.drafter_id;
	}
	public void setDrafter_id(String drafter_id) {
		this.drafter_id = drafter_id;
	}
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getInout() {
		return this.inout;
	}
	public void setInout(String inout) {
		this.inout = inout;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String get_id() {
		return this._id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getResponseDateValue() {
		return this.responseDateValue;
	}
	public void setResponseDateValue(String responseDateValue) {
		this.responseDateValue = responseDateValue;
	}
	public String getResponseDoneDate() {
		return this.responseDoneDate;
	}
	public void setResponseDoneDate(String responseDoneDate) {
		this.responseDoneDate = responseDoneDate;
	}
	@Override
	public String toString() {
		return "LitigationLogExport [projectId=" + projectId + ", inout=" + inout + ", type=" + type + ", notes="
				+ notes + ", _id=" + _id + ", createdDate=" + createdDate + ", responseDateValue=" + responseDateValue
				+ ", responseDoneDate=" + responseDoneDate + ", done=" + done + ", title=" + title + ", drafter_id="
				+ drafter_id + "]";
	}
	

}

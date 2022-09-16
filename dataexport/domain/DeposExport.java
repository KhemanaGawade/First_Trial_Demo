package com.filevine.dataexport.domain;


/**
 * This class is having all required fields of depos details tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class DeposExport {
	
	private String projectId=null;
	private String id=null;
	private String deponent=null;
	private String generalNote=null;
	private String createdDate=null;
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeponent() {
		return this.deponent;
	}
	public void setDeponent(String deponent) {
		this.deponent = deponent;
	}
	public String getGeneralNote() {
		return this.generalNote;
	}
	public void setGeneralNote(String generalNote) {
		this.generalNote = generalNote;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "DeposExport [projectId=" + projectId + ", id=" + id + ", deponent=" + deponent + ", generalNote="
				+ generalNote + ", createdDate=" + createdDate + "]";
	}
	
	
}

package com.filevine.dataexport.domain;

public class PlntfsDiscExport {
	
	private String projectId=null;
	private String notes=null;
	private String disclosuredate=null;
	private String id=null;
	private String createdDate=null;
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getDisclosuredate() {
		return this.disclosuredate;
	}
	public void setDisclosuredate(String disclosuredate) {
		this.disclosuredate = disclosuredate;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "PlntfsDiscExport [projectId=" + projectId + ", notes=" + notes + ", disclosuredate=" + disclosuredate
				+ ", id=" + id + ", createdDate=" + createdDate + "]";
	}
	
	

}

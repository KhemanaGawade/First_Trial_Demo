package com.filevine.dataexport.domain;


/**
 * This class is having all required fields of defence counsel tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class DefenceCounselExport {
	
	private String projectId=null;
	private String firmNameId=null;
	private String leadcounselId=null;
	private String paralegalId=null;
	private String assistantattorneyId=null;
	private String legalassistantId=null;
	private String notes=null;
	private String createdDate=null;
	private String id=null;
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getFirmNameId() {
		return this.firmNameId;
	}
	public void setFirmNameId(String firmNameId) {
		this.firmNameId = firmNameId;
	}
	public String getLeadcounselId() {
		return this.leadcounselId;
	}
	public void setLeadcounselId(String leadcounselId) {
		this.leadcounselId = leadcounselId;
	}
	public String getParalegalId() {
		return this.paralegalId;
	}
	public void setParalegalId(String paralegalId) {
		this.paralegalId = paralegalId;
	}
	public String getAssistantattorneyId() {
		return this.assistantattorneyId;
	}
	public void setAssistantattorneyId(String assistantattorneyId) {
		this.assistantattorneyId = assistantattorneyId;
	}
	public String getLegalassistantId() {
		return this.legalassistantId;
	}
	public void setLegalassistantId(String legalassistantId) {
		this.legalassistantId = legalassistantId;
	}
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "DefenceCounselExport [projectId=" + projectId + ", firmNameId=" + firmNameId + ", leadcounselId="
				+ leadcounselId + ", paralegalId=" + paralegalId + ", assistantattorneyId=" + assistantattorneyId
				+ ", legalassistantId=" + legalassistantId + ", notes=" + notes + ", createdDate=" + createdDate
				+ ", id=" + id + "]";
	}

}

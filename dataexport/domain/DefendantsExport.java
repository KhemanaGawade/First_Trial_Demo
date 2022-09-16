package com.filevine.dataexport.domain;

public class DefendantsExport {

	private int projectId=0;
	private String DefendantId=null;
	private String OrgID=null;
	private String DefendantFullName=null;
	@Override
	public String toString() {
		return "DefendantsExport [projectId=" + projectId + ", DefendantId=" + DefendantId + ", OrgID=" + OrgID
				+ ", DefendantFullName=" + DefendantFullName + ", CreatedDate=" + CreatedDate + ", ModiFiedDate="
				+ ModiFiedDate + ", ServiceDueDate=" + ServiceDueDate + ", ServiceDoneDate=" + ServiceDoneDate
				+ ", AttorneyForDefendantId=" + AttorneyForDefendantId + ", AttorneyForDefendantFullName="
				+ AttorneyForDefendantFullName + ", UniqueID=" + UniqueID + ", Notes=" + Notes + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getDefendantId() {
		return DefendantId;
	}
	public void setDefendantId(String defendantId) {
		DefendantId = defendantId;
	}
	public String getOrgID() {
		return OrgID;
	}
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}
	public String getDefendantFullName() {
		return DefendantFullName;
	}
	public void setDefendantFullName(String defendantFullName) {
		DefendantFullName = defendantFullName;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public String getModiFiedDate() {
		return ModiFiedDate;
	}
	public void setModiFiedDate(String modiFiedDate) {
		ModiFiedDate = modiFiedDate;
	}
	public String getServiceDueDate() {
		return ServiceDueDate;
	}
	public void setServiceDueDate(String serviceDueDate) {
		ServiceDueDate = serviceDueDate;
	}
	public String getServiceDoneDate() {
		return ServiceDoneDate;
	}
	public void setServiceDoneDate(String serviceDoneDate) {
		ServiceDoneDate = serviceDoneDate;
	}
	public String getAttorneyForDefendantId() {
		return AttorneyForDefendantId;
	}
	public void setAttorneyForDefendantId(String attorneyForDefendantId) {
		AttorneyForDefendantId = attorneyForDefendantId;
	}
	public String getAttorneyForDefendantFullName() {
		return AttorneyForDefendantFullName;
	}
	public void setAttorneyForDefendantFullName(String attorneyForDefendantFullName) {
		AttorneyForDefendantFullName = attorneyForDefendantFullName;
	}
	public String getUniqueID() {
		return UniqueID;
	}
	public void setUniqueID(String uniqueID) {
		UniqueID = uniqueID;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	private String CreatedDate=null;
	private String ModiFiedDate=null;
	private String ServiceDueDate=null;
	private String ServiceDoneDate=null;
	private String AttorneyForDefendantId=null;
	private String AttorneyForDefendantFullName=null;
	private String UniqueID=null;
	private String Notes=null;
	
	
	
	
	
	
	
	
}

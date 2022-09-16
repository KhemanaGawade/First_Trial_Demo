package com.filevine.dataexport.domain;

public class WitnessExport {

	
	private int projectId=0;
	private String DateInterViewed=null;
	private String WitnessId=null;
	private String OrgID=null;
	private String WitNessFullName=null;
	private String CreatedDate=null;
	private String ModiFiedDate=null;
	private String WitnessRole=null;
	private String Notes=null;
	private String UniqueID=null;
	@Override
	public String toString() {
		return "WitnessExport [projectId=" + projectId + ", DateInterViewed=" + DateInterViewed + ", WitnessId="
				+ WitnessId + ", OrgID=" + OrgID + ", WitNessFullName=" + WitNessFullName + ", CreatedDate="
				+ CreatedDate + ", ModiFiedDate=" + ModiFiedDate + ", WitnessRole=" + WitnessRole + ", Notes=" + Notes
				+ ", UniqueID=" + UniqueID + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getDateInterViewed() {
		return DateInterViewed;
	}
	public void setDateInterViewed(String dateInterViewed) {
		DateInterViewed = dateInterViewed;
	}
	public String getWitnessId() {
		return WitnessId;
	}
	public void setWitnessId(String witnessId) {
		WitnessId = witnessId;
	}
	public String getOrgID() {
		return OrgID;
	}
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}
	public String getWitNessFullName() {
		return WitNessFullName;
	}
	public void setWitNessFullName(String witNessFullName) {
		WitNessFullName = witNessFullName;
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
	public String getWitnessRole() {
		return WitnessRole;
	}
	public void setWitnessRole(String witnessRole) {
		WitnessRole = witnessRole;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getUniqueID() {
		return UniqueID;
	}
	public void setUniqueID(String uniqueID) {
		UniqueID = uniqueID;
	}
	
	
	
	
	
	
	
	
	
}

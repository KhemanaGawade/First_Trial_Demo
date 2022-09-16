package com.filevine.dataexport.domain;

public class ContactEmailDataExport {

	private String projectId=null;
	private String PersonID =null;
	private String EmailId=null ;
	private String Address =null;
	private String Label =null;
	private String Notes =null;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPersonID() {
		return PersonID;
	}
	public void setPersonID(String personID) {
		PersonID = personID;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	@Override
	public String toString() {
		return "ContactEmailDataExport [projectId=" + projectId + ", PersonID=" + PersonID + ", EmailId=" + EmailId
				+ ", Address=" + Address + ", Label=" + Label + ", Notes=" + Notes + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

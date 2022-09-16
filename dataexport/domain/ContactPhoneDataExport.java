package com.filevine.dataexport.domain;

public class ContactPhoneDataExport {

	
	private String ProjectId=null;
	private String ContactId=null;
	private String PersonID=null;
	private String PhoneId=null;
	private String Number=null;
	private String RawNumber=null;
	private String Label=null;
	private String Notes=null;
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getContactId() {
		return ContactId;
	}
	public void setContactId(String contactId) {
		ContactId = contactId;
	}
	public String getPersonID() {
		return PersonID;
	}
	public void setPersonID(String personID) {
		PersonID = personID;
	}
	public String getPhoneId() {
		return PhoneId;
	}
	public void setPhoneId(String phoneId) {
		PhoneId = phoneId;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getRawNumber() {
		return RawNumber;
	}
	public void setRawNumber(String rawNumber) {
		RawNumber = rawNumber;
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
		return "ContactPhoneDataExport [ProjectId=" + ProjectId + ", ContactId=" + ContactId + ", PersonID=" + PersonID
				+ ", PhoneId=" + PhoneId + ", Number=" + Number + ", RawNumber=" + RawNumber + ", Label=" + Label
				+ ", Notes=" + Notes + "]";
	}
	
}

package com.filevine.dataexport.domain;


/**
 * This class is having all required fields of contact email details tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class ContactEmailExport {
	private String ContactId = null;
	private String personId= null;
	private String EmailId = null;
	private String Address = null;
	private String Label = null;
	public String getContactId() {
		return ContactId;
	}
	public void setContactId(String contactId) {
		ContactId = contactId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
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
	@Override
	public String toString() {
		return "ContactEmailExport [ContactId=" + ContactId + ", personId=" + personId + ", EmailId=" + EmailId
				+ ", Address=" + Address + ", Label=" + Label + "]";
	}
	
	
	
	
	

}

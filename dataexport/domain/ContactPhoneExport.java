package com.filevine.dataexport.domain;

/**
 * This class is having all required fields of contact's phone details tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class ContactPhoneExport {
	
	private String ContactId = null;
	private int Id = 0;
	private String Number = null;
	private String RawNumber = null;
	private String Label = null;
	private String personId= null;
	public String getContactId() {
		return ContactId;
	}
	public void setContactId(String contactId) {
		ContactId = contactId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	@Override
	public String toString() {
		return "ContactPhoneExport [ContactId=" + ContactId + ", Id=" + Id + ", Number=" + Number + ", RawNumber="
				+ RawNumber + ", Label=" + Label + ", personId=" + personId + "]";
	}
	
	
	
}

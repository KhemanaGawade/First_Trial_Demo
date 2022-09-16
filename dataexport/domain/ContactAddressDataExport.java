package com.filevine.dataexport.domain;

public class ContactAddressDataExport {

	private String ProjectId=null;
	private String ContactId=null;
	@Override
	public String toString() {
		return "ContactAddressDataExport [ProjectId=" + ProjectId + ", ContactId=" + ContactId + ", PersonID="
				+ PersonID + ", AddressesId=" + AddressesId + ", Line1=" + Line1 + ", Line2=" + Line2 + ", City=" + City
				+ ", State=" + State + ", Zip=" + Zip + ", Label=" + Label + ", Notes=" + Notes + ", FullAddress="
				+ FullAddress + "]";
	}
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
	public String getAddressesId() {
		return AddressesId;
	}
	public void setAddressesId(String addressesId) {
		AddressesId = addressesId;
	}
	public String getLine1() {
		return Line1;
	}
	public void setLine1(String line1) {
		Line1 = line1;
	}
	public String getLine2() {
		return Line2;
	}
	public void setLine2(String line2) {
		Line2 = line2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
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
	public String getFullAddress() {
		return FullAddress;
	}
	public void setFullAddress(String fullAddress) {
		FullAddress = fullAddress;
	}
	private String PersonID=null;
	private String AddressesId=null;
	private String Line1=null;
	private String Line2=null;
	private String City=null;
	private String State=null;
	private String Zip=null;
	private String Label=null;
	private String Notes=null;
	private String FullAddress=null;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

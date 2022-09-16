package com.filevine.dataexport.domain;


/**
 * This class is having all required fields of contact address details tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class ContactAddressExport {
	
	private String ContactId = null;
	private int Id = 0;
	private String Line1 = null;
	private String Line2 = null;
	private String City = null;
	private String Zip = null;
	private String Label = null;
	private String FullAddress= null;
	private String State= null;
	private String personId= null;
	
	public String getPersonId() {
		return this.personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getContactId() {
		return this.ContactId;
	}
	public void setContactId(String contactId) {
		this.ContactId = contactId;
	}
	public int getId() {
		return this.Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getLine1() {
		return this.Line1;
	}
	public void setLine1(String line1) {
		this.Line1 = line1;
	}
	public String getLine2() {
		return this.Line2;
	}
	public void setLine2(String line2) {
		this.Line2 = line2;
	}
	public String getCity() {
		return this.City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getZip() {
		return this.Zip;
	}
	public void setZip(String zip) {
		this.Zip = zip;
	}
	public String getLabel() {
		return this.Label;
	}
	public void setLabel(String label) {
		this.Label = label;
	}
	public String getFullAddress() {
		return this.FullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.FullAddress = fullAddress;
	}
	public String getState() {
		return this.State;
	}
	public void setState(String state) {
		this.State = state;
	}
	@Override
	public String toString() {
		return "ContactAddressExport [ContactId=" + ContactId + ", Id=" + Id + ", Line1=" + Line1 + ", Line2=" + Line2
				+ ", City=" + City + ", Zip=" + Zip + ", Label=" + Label + ", FullAddress=" + FullAddress + ", State="
				+ State + ", personId=" + personId + "]";
	}
	

}

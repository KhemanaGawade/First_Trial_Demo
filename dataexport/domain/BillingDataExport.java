package com.filevine.dataexport.domain;

public class BillingDataExport {

	
	private String ProjectId=null;
	private String Type=null;
	private String Title=null;
	private String Amount=null;
	private String Date=null;
	private String Id=null;
	private String CreatedDate=null;
	@Override
	public String toString() {
		return "BillingDataExport [ProjectId=" + ProjectId + ", Type=" + Type + ", Title=" + Title + ", Amount="
				+ Amount + ", Date=" + Date + ", Id=" + Id + ", CreatedDate=" + CreatedDate + "]";
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	
	
	
	
	
	
	
	
	
	
	
}

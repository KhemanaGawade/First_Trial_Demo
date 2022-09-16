package com.filevine.dataexport.domain;

public class TimeTrackingDataExport {

	
	private String ProjectId=null;
	private String TimeWorked=null;
	private String Date=null;
	private String WorkDone=null;
	private String UserId=null;
	private String UserFullName=null;
	private String Id=null;
	private String CreatedDate=null;
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getTimeWorked() {
		return TimeWorked;
	}
	public void setTimeWorked(String timeWorked) {
		TimeWorked = timeWorked;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getWorkDone() {
		return WorkDone;
	}
	public void setWorkDone(String workDone) {
		WorkDone = workDone;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserFullName() {
		return UserFullName;
	}
	public void setUserFullName(String userFullName) {
		UserFullName = userFullName;
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
	@Override
	public String toString() {
		return "TimeTrackingDataExport [ProjectId=" + ProjectId + ", TimeWorked=" + TimeWorked + ", Date=" + Date
				+ ", WorkDone=" + WorkDone + ", UserId=" + UserId + ", UserFullName=" + UserFullName + ", Id=" + Id
				+ ", CreatedDate=" + CreatedDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}

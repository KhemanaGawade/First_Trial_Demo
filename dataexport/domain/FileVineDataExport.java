package com.filevine.dataexport.domain;

public class FileVineDataExport {
	private String TotalCount=null;
	private String Id=null;
	private String ProjectId=null;
	private String TypeTag=null;
	private String TargetDate=null;
	private String CompletedDate=null;
	private String Body=null;
	private String CreatedAt=null;
	private String lastActivity=null;
	private String Assignee=null;
	private String AuthorFullName=null;
	private String UserName=null;
	private String UserNameId =null;
//	private String PayDateDue=null;
//	private String HowMuchAmountPaid =null;
//	private String CheckNumber=null;
//	private String RecordsReceived =null;
	public String getTotalCount() {
		return TotalCount;
	}
	public void setTotalCount(String totalCount) {
		TotalCount = totalCount;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getTypeTag() {
		return TypeTag;
	}
	public void setTypeTag(String typeTag) {
		TypeTag = typeTag;
	}
	public String getTargetDate() {
		return TargetDate;
	}
	public void setTargetDate(String targetDate) {
		TargetDate = targetDate;
	}
	public String getCompletedDate() {
		return CompletedDate;
	}
	public void setCompletedDate(String completedDate) {
		CompletedDate = completedDate;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}
	public String getLastActivity() {
		return lastActivity;
	}
	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}
	public String getAssignee() {
		return Assignee;
	}
	public void setAssignee(String assignee) {
		Assignee = assignee;
	}
	public String getAuthorFullName() {
		return AuthorFullName;
	}
	public void setAuthorFullName(String authorFullName) {
		AuthorFullName = authorFullName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserNameId() {
		return UserNameId;
	}
	public void setUserNameId(String userNameId) {
		UserNameId = userNameId;
	}
	@Override
	public String toString() {
		return "FileVineDataExport [TotalCount=" + TotalCount + ", Id=" + Id + ", ProjectId=" + ProjectId + ", TypeTag="
				+ TypeTag + ", TargetDate=" + TargetDate + ", CompletedDate=" + CompletedDate + ", Body=" + Body
				+ ", CreatedAt=" + CreatedAt + ", lastActivity=" + lastActivity + ", Assignee=" + Assignee
				+ ", AuthorFullName=" + AuthorFullName + ", UserName=" + UserName + ", UserNameId=" + UserNameId + "]";
	}
	
	
	
}

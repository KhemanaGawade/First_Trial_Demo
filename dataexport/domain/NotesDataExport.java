package com.filevine.dataexport.domain;

public class NotesDataExport {

	private int Id=0;
	private int ProjectId=0;
	private String TargetDate=null;
	private String Body=null;
	private String CreatedAt=null;
	private String TypeTag=null;
	private String LastActivity=null;
	private String Assignee=null;
	private int UserId=0;
	private String UserName=null;
	private int AssigneeId=0;
	private String AssigneeName=null;
	private String AssigneeUser=null;
	@Override
	public String toString() {
		return "NotesDataExport [Id=" + Id + ", ProjectId=" + ProjectId + ", TargetDate=" + TargetDate + ", Body="
				+ Body + ", CreatedAt=" + CreatedAt + ", TypeTag=" + TypeTag + ", LastActivity=" + LastActivity
				+ ", Assignee=" + Assignee + ", UserId=" + UserId + ", UserName=" + UserName + ", AssigneeId="
				+ AssigneeId + ", AssigneeName=" + AssigneeName + ", AssigneeUser=" + AssigneeUser + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public String getTargetDate() {
		return TargetDate;
	}
	public void setTargetDate(String targetDate) {
		TargetDate = targetDate;
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
	public String getTypeTag() {
		return TypeTag;
	}
	public void setTypeTag(String typeTag) {
		TypeTag = typeTag;
	}
	public String getLastActivity() {
		return LastActivity;
	}
	public void setLastActivity(String lastActivity) {
		LastActivity = lastActivity;
	}
	public String getAssignee() {
		return Assignee;
	}
	public void setAssignee(String assignee) {
		Assignee = assignee;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getAssigneeId() {
		return AssigneeId;
	}
	public void setAssigneeId(int assigneeId) {
		AssigneeId = assigneeId;
	}
	public String getAssigneeName() {
		return AssigneeName;
	}
	public void setAssigneeName(String assigneeName) {
		AssigneeName = assigneeName;
	}
	public String getAssigneeUser() {
		return AssigneeUser;
	}
	public void setAssigneeUser(String assigneeUser) {
		AssigneeUser = assigneeUser;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

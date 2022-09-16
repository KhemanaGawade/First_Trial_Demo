package com.filevine.dataexport.domain;

public class NotesExport {

	private int id=0;
	private int projectId=0;
	private String targetDate=null;
	private String body=null;
	private String createdAt=null;
	private int userId=0;
	private String userName=null;
	private String typeTag=null;
	private int assigneeId=0;
	private String assigneeName=null;
	private String assigneeUser=null;
	private String lastActivity=null;
	private String assignee=null;
	
	public String getTypeTag() {
		return this.typeTag;
	}
	public void setTypeTag(String typeTag) {
		this.typeTag = typeTag;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTargetDate() {
		return this.targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAssigneeId() {
		return this.assigneeId;
	}
	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}
	public String getAssigneeName() {
		return this.assigneeName;
	}
	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	public String getAssigneeUser() {
		return this.assigneeUser;
	}
	public void setAssigneeUser(String assigneeUser) {
		this.assigneeUser = assigneeUser;
	}
	
	public String getLastActivity() {
		return this.lastActivity;
	}
	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}
	
	public String getAssignee() {
		return this.assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	@Override
	public String toString() {
		return "NotesExport [id=" + id + ", projectId=" + projectId + ", targetDate=" + targetDate + ", body=" + body
				+ ", createdAt=" + createdAt + ", userId=" + userId + ", userName=" + userName + ", typeTag=" + typeTag
				+ ", assigneeId=" + assigneeId + ", assigneeName=" + assigneeName + ", assigneeUser=" + assigneeUser
				+ ", lastActivity=" + lastActivity + ", assignee=" + assignee + "]";
	}

	
	
}

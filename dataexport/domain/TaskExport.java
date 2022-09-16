package com.filevine.dataexport.domain;

public class TaskExport {
	
	private int taskId;
	private int projectId;
	private String projectName;
	private String clientName;
	private String typeTag;
	private String targetDate;
	private String isUnread;
	private String isCompleted;
	private String completedDate;
	private String body;
	private String createdAt;
	private String destination;
	private String source;
	private String isEdited;
	private String lastActivity;
	private String authorFullName;
	private String authorType;
	private String authorEmail;
	private String assignee;
	private String comments;
	public int getTaskId() {
		return this.taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return this.projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return this.clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getTypeTag() {
		return this.typeTag;
	}
	public void setTypeTag(String typeTag) {
		this.typeTag = typeTag;
	}
	public String getTargetDate() {
		return this.targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getIsUnread() {
		return this.isUnread;
	}
	public void setIsUnread(String isUnread) {
		this.isUnread = isUnread;
	}
	public String getIsCompleted() {
		return this.isCompleted;
	}
	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getCompletedDate() {
		return this.completedDate;
	}
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
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
	public String getDestination() {
		return this.destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSource() {
		return this.source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIsEdited() {
		return this.isEdited;
	}
	public void setIsEdited(String isEdited) {
		this.isEdited = isEdited;
	}
	public String getLastActivity() {
		return this.lastActivity;
	}
	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}
	public String getAuthorFullName() {
		return this.authorFullName;
	}
	public void setAuthorFullName(String authorFullName) {
		this.authorFullName = authorFullName;
	}
	public String getAuthorType() {
		return this.authorType;
	}
	public void setAuthorType(String authorType) {
		this.authorType = authorType;
	}
	public String getAuthorEmail() {
		return this.authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAssignee() {
		return this.assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getComments() {
		return this.comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "TaskExport [taskId=" + taskId + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", clientName=" + clientName + ", typeTag=" + typeTag + ", targetDate=" + targetDate + ", isUnread="
				+ isUnread + ", isCompleted=" + isCompleted + ", completedDate=" + completedDate + ", body=" + body
				+ ", createdAt=" + createdAt + ", destination=" + destination + ", source=" + source + ", isEdited="
				+ isEdited + ", lastActivity=" + lastActivity + ", authorFullName=" + authorFullName + ", authorType="
				+ authorType + ", authorEmail=" + authorEmail + ", assignee=" + assignee + ", comments=" + comments
				+ "]";
	}
	
	
	
}

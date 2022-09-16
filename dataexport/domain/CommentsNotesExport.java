package com.filevine.dataexport.domain;

/**
 * This class is having all required fields of comment notes tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class CommentsNotesExport {
   private int commentId;
   private int noteId;
   private String body;
   private int userId;
   private String createdAt;
   private String fullName;
   private int task_id_input;
   
   //task data
   private String projectId;
   private String typeTag;
   private String targetDate;
   private String isUnread;
   private String isCompleted;
   private String completedDate;
   private String destination;
   private String source;
   private String isEdited;
   private String allowEditing;
   private String lastActivity;
   private int assigneeId;
   private String assigneeFullName;
   private int completerId;
   private String completerName;
   private String completerCreatedAt;
   private int authorId;
   private String authorName;
   private String taskBody;
   
   public int getCommentId() {
	   return this.commentId;
   }
   public void setCommentId(int commentId) {
	   this.commentId = commentId;
   }
   public int getNoteId() {
	   return this.noteId;
   }
   public void setNoteId(int noteId) {
	   this.noteId = noteId;
   }
   public String getBody() {
	   return this.body;
   }
   public void setBody(String body) {
	   this.body = body;
   }
   public int getUserId() {
	   return this.userId;
   }
   public void setUserId(int userId) {
	   this.userId = userId;
   }
   public String getCreatedAt() {
	   return this.createdAt;
   }
   public void setCreatedAt(String createdAt) {
	   this.createdAt = createdAt;
   }
   public String getFullName() {
	   return this.fullName;
   }
   public void setFullName(String fullName) {
	   this.fullName = fullName;
   }
   
   //task's gaetter & setter
   

public int getTask_id_input() {
	return task_id_input;
}
public void setTask_id_input(int task_id_input) {
	this.task_id_input = task_id_input;
}
public String getProjectId() {
	return this.projectId;
}
public void setProjectId(String projectId) {
	this.projectId = projectId;
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
public String getAllowEditing() {
	return this.allowEditing;
}
public void setAllowEditing(String allowEditing) {
	this.allowEditing = allowEditing;
}
public String getLastActivity() {
	return this.lastActivity;
}
public void setLastActivity(String lastActivity) {
	this.lastActivity = lastActivity;
}
public String getAssigneeFullName() {
	return this.assigneeFullName;
}
public void setAssigneeFullName(String assigneeFullName) {
	this.assigneeFullName = assigneeFullName;
}

public int getAssigneeId() {
	return this.assigneeId;
}
public void setAssigneeId(int assigneeId) {
	this.assigneeId = assigneeId;
}
public int getCompleterId() {
	return this.completerId;
}
public void setCompleterId(int completerId) {
	this.completerId = completerId;
}
public String getCompleterName() {
	return this.completerName;
}
public void setCompleterName(String completerName) {
	this.completerName = completerName;
}
public String getCompleterCreatedAt() {
	return this.completerCreatedAt;
}
public void setCompleterCreatedAt(String completerCreatedAt) {
	this.completerCreatedAt = completerCreatedAt;
}
public int getAuthorId() {
	return this.authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public String getAuthorName() {
	return this.authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
public String getTaskBody() {
	return this.taskBody;
}
public void setTaskBody(String taskBody) {
	this.taskBody = taskBody;
}
@Override
public String toString() {
	return "CommentsNotesExport [commentId=" + commentId + ", noteId=" + noteId + ", body=" + body + ", userId="
			+ userId + ", createdAt=" + createdAt + ", fullName=" + fullName + ", task_id_input=" + task_id_input
			+ ", projectId=" + projectId + ", typeTag=" + typeTag + ", targetDate=" + targetDate + ", isUnread="
			+ isUnread + ", isCompleted=" + isCompleted + ", completedDate=" + completedDate + ", destination="
			+ destination + ", source=" + source + ", isEdited=" + isEdited + ", allowEditing=" + allowEditing
			+ ", lastActivity=" + lastActivity + ", assigneeId=" + assigneeId + ", assigneeFullName=" + assigneeFullName
			+ ", completerId=" + completerId + ", completerName=" + completerName + ", completerCreatedAt="
			+ completerCreatedAt + ", authorId=" + authorId + ", authorName=" + authorName + ", taskBody=" + taskBody
			+ "]";
}


   
}

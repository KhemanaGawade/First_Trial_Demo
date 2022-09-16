package com.filevine.dataexport.domain;

public class EmailDataExport {

	private int projectId=0;
	private String Type=null;
	private String DateSent=null;
	private String DateReceived=null;
	private String From=null;
	private String To=null;
	private String Description=null;
	private String MailfaxDocsId=null;
	private String MailfaxDocsName=null;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDateSent() {
		return DateSent;
	}
	public void setDateSent(String dateSent) {
		DateSent = dateSent;
	}
	public String getDateReceived() {
		return DateReceived;
	}
	public void setDateReceived(String dateReceived) {
		DateReceived = dateReceived;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMailfaxDocsId() {
		return MailfaxDocsId;
	}
	public void setMailfaxDocsId(String mailfaxDocsId) {
		MailfaxDocsId = mailfaxDocsId;
	}
	public String getMailfaxDocsName() {
		return MailfaxDocsName;
	}
	public void setMailfaxDocsName(String mailfaxDocsName) {
		MailfaxDocsName = mailfaxDocsName;
	}
	@Override
	public String toString() {
		return "EmailDataExport [projectId=" + projectId + ", Type=" + Type + ", DateSent=" + DateSent
				+ ", DateReceived=" + DateReceived + ", From=" + From + ", To=" + To + ", Description=" + Description
				+ ", MailfaxDocsId=" + MailfaxDocsId + ", MailfaxDocsName=" + MailfaxDocsName + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

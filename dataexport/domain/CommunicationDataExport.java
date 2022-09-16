package com.filevine.dataexport.domain;

public class CommunicationDataExport {

	private int projectId=0;
	private String TypeOfCommunication=null;
	private String CommunicationTo=null;
	private String CommunicationFrom=null;
	private String CommunicationDate=null;
	private String CommunicationNotes=null;
	//private String Notes=null;
	public int getProjectId() {
		return projectId;
	}
	@Override
	public String toString() {
		return "CommunicationDataExport [projectId=" + projectId + ", TypeOfCommunication=" + TypeOfCommunication
				+ ", CommunicationTo=" + CommunicationTo + ", CommunicationFrom=" + CommunicationFrom
				+ ", CommunicationDate=" + CommunicationDate + ", CommunicationNotes=" + CommunicationNotes + "]";
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTypeOfCommunication() {
		return TypeOfCommunication;
	}
	public void setTypeOfCommunication(String typeOfCommunication) {
		TypeOfCommunication = typeOfCommunication;
	}
	public String getCommunicationTo() {
		return CommunicationTo;
	}
	public void setCommunicationTo(String communicationTo) {
		CommunicationTo = communicationTo;
	}
	public String getCommunicationFrom() {
		return CommunicationFrom;
	}
	public void setCommunicationFrom(String communicationFrom) {
		CommunicationFrom = communicationFrom;
	}
	public String getCommunicationDate() {
		return CommunicationDate;
	}
	public void setCommunicationDate(String communicationDate) {
		CommunicationDate = communicationDate;
	}
	public String getCommunicationNotes() {
		return CommunicationNotes;
	}
	public void setCommunicationNotes(String communicationNotes) {
		CommunicationNotes = communicationNotes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

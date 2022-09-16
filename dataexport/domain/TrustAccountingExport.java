package com.filevine.dataexport.domain;

public class TrustAccountingExport {

	
	private int projectId=0;
	private String Type=null;
	private String CheckNumber=null;
	private String AmountOfCheck=null;
	private String Date=null;
	private String Notes=null;
	@Override
	public String toString() {
		return "TrustAccountingExport [projectId=" + projectId + ", Type=" + Type + ", CheckNumber=" + CheckNumber
				+ ", AmountOfCheck=" + AmountOfCheck + ", Date=" + Date + ", Notes=" + Notes + ", DocumentsId="
				+ DocumentsId + ", DocumentsFileName=" + DocumentsFileName + "]";
	}
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
	public String getCheckNumber() {
		return CheckNumber;
	}
	public void setCheckNumber(String checkNumber) {
		CheckNumber = checkNumber;
	}
	public String getAmountOfCheck() {
		return AmountOfCheck;
	}
	public void setAmountOfCheck(String amountOfCheck) {
		AmountOfCheck = amountOfCheck;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getDocumentsId() {
		return DocumentsId;
	}
	public void setDocumentsId(String documentsId) {
		DocumentsId = documentsId;
	}
	public String getDocumentsFileName() {
		return DocumentsFileName;
	}
	public void setDocumentsFileName(String documentsFileName) {
		DocumentsFileName = documentsFileName;
	}
	private String DocumentsId=null;
	private String DocumentsFileName=null;
	
	
	
	
	
	
	
	
	
}

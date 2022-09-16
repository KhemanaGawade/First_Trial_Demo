package com.filevine.dataexport.domain;

public class LiensExport {

	private int projectId=0;
	private String TypeOfLien=null;
	private String ReferenceNumber=null;
	private String NoticeDateReceived=null;
	private String Amount=null;
	private String FinallienReceivedDate=null;
	private String LetterOfRepsentDate=null;
	private String Reduction=null;
	private String Notes=null;
	private String lienholder=null;
	private String RecoveryAgency=null;
	private String RecoveryAgent=null;
	@Override
	public String toString() {
		return "LiensExport [projectId=" + projectId + ", TypeOfLien=" + TypeOfLien + ", ReferenceNumber="
				+ ReferenceNumber + ", NoticeDateReceived=" + NoticeDateReceived + ", Amount=" + Amount
				+ ", FinallienReceivedDate=" + FinallienReceivedDate + ", LetterOfRepsentDate=" + LetterOfRepsentDate
				+ ", Reduction=" + Reduction + ", Notes=" + Notes + ", lienholder=" + lienholder + ", RecoveryAgency="
				+ RecoveryAgency + ", RecoveryAgent=" + RecoveryAgent + ", DocumentsId=" + DocumentsId
				+ ", DocumentsFileName=" + DocumentsFileName + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTypeOfLien() {
		return TypeOfLien;
	}
	public void setTypeOfLien(String typeOfLien) {
		TypeOfLien = typeOfLien;
	}
	public String getReferenceNumber() {
		return ReferenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		ReferenceNumber = referenceNumber;
	}
	public String getNoticeDateReceived() {
		return NoticeDateReceived;
	}
	public void setNoticeDateReceived(String noticeDateReceived) {
		NoticeDateReceived = noticeDateReceived;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getFinallienReceivedDate() {
		return FinallienReceivedDate;
	}
	public void setFinallienReceivedDate(String finallienReceivedDate) {
		FinallienReceivedDate = finallienReceivedDate;
	}
	public String getLetterOfRepsentDate() {
		return LetterOfRepsentDate;
	}
	public void setLetterOfRepsentDate(String letterOfRepsentDate) {
		LetterOfRepsentDate = letterOfRepsentDate;
	}
	public String getReduction() {
		return Reduction;
	}
	public void setReduction(String reduction) {
		Reduction = reduction;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getLienholder() {
		return lienholder;
	}
	public void setLienholder(String lienholder) {
		this.lienholder = lienholder;
	}
	public String getRecoveryAgency() {
		return RecoveryAgency;
	}
	public void setRecoveryAgency(String recoveryAgency) {
		RecoveryAgency = recoveryAgency;
	}
	public String getRecoveryAgent() {
		return RecoveryAgent;
	}
	public void setRecoveryAgent(String recoveryAgent) {
		RecoveryAgent = recoveryAgent;
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

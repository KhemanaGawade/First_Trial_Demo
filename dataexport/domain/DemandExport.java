package com.filevine.dataexport.domain;

public class DemandExport {

	private int projectId=0;
	private String OfferDemandSettled=null;
	private String Amount=null;
	private String DateSend=null;
	private String Notes=null;
	private String DemandStatus=null;
	private String LiabilitySection=null;
	private String WhoDrafted=null;
	private String DateDrafted=null;
	private String ToFrom=null;
	private String DoneDate=null;
	private String DueDate=null;
	//private int TotalItemsCount=0;
	private String ReturnReceiptId=null;
	private String ReturnReceiptFileName=null;
	private String docsId=null;
	private String docsFileName=null;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getOfferDemandSettled() {
		return OfferDemandSettled;
	}
	public void setOfferDemandSettled(String offerDemandSettled) {
		OfferDemandSettled = offerDemandSettled;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getDateSend() {
		return DateSend;
	}
	public void setDateSend(String dateSend) {
		DateSend = dateSend;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getDemandStatus() {
		return DemandStatus;
	}
	public void setDemandStatus(String demandStatus) {
		DemandStatus = demandStatus;
	}
	public String getLiabilitySection() {
		return LiabilitySection;
	}
	public void setLiabilitySection(String liabilitySection) {
		LiabilitySection = liabilitySection;
	}
	public String getWhoDrafted() {
		return WhoDrafted;
	}
	public void setWhoDrafted(String whoDrafted) {
		WhoDrafted = whoDrafted;
	}
	public String getDateDrafted() {
		return DateDrafted;
	}
	public void setDateDrafted(String dateDrafted) {
		DateDrafted = dateDrafted;
	}
	public String getToFrom() {
		return ToFrom;
	}
	public void setToFrom(String toFrom) {
		ToFrom = toFrom;
	}
	public String getDoneDate() {
		return DoneDate;
	}
	public void setDoneDate(String doneDate) {
		DoneDate = doneDate;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}
	public String getReturnReceiptId() {
		return ReturnReceiptId;
	}
	public void setReturnReceiptId(String returnReceiptId) {
		ReturnReceiptId = returnReceiptId;
	}
	public String getReturnReceiptFileName() {
		return ReturnReceiptFileName;
	}
	public void setReturnReceiptFileName(String returnReceiptFileName) {
		ReturnReceiptFileName = returnReceiptFileName;
	}
	public String getDocsId() {
		return docsId;
	}
	public void setDocsId(String docsId) {
		this.docsId = docsId;
	}
	public String getDocsFileName() {
		return docsFileName;
	}
	public void setDocsFileName(String docsFileName) {
		this.docsFileName = docsFileName;
	}
	@Override
	public String toString() {
		return "DemandExport [projectId=" + projectId + ", OfferDemandSettled=" + OfferDemandSettled + ", Amount="
				+ Amount + ", DateSend=" + DateSend + ", Notes=" + Notes + ", DemandStatus=" + DemandStatus
				+ ", LiabilitySection=" + LiabilitySection + ", WhoDrafted=" + WhoDrafted + ", DateDrafted="
				+ DateDrafted + ", ToFrom=" + ToFrom + ", DoneDate=" + DoneDate + ", DueDate=" + DueDate
				+ ", ReturnReceiptId=" + ReturnReceiptId + ", ReturnReceiptFileName=" + ReturnReceiptFileName
				+ ", docsId=" + docsId + ", docsFileName=" + docsFileName + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

package com.filevine.dataexport.domain;


public class AdvanceClientCostExport {

	private int projectId=0;
	private String Type=null;
	private String InvoiceNumber=null;
	private String AmountOfInvoice=null;
	private String DateOfInvoice=null;
	private String CardType=null;
	private String Notes=null;
	private String Description=null;
	private String WhoseCreditCard=null;
	private String FacilityName=null;
	private String PayeeName=null;
	private String MethodOfPayment=null;
	private String PayDateDone =null;
	private String PayDateDue=null;
	private String HowMuchAmountPaid =null;
	private String CheckNumber=null;
	private String RecordsReceived =null;
	private String DocumentId=null;
	private String DocumentName =null;
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
	public String getInvoiceNumber() {
		return InvoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}
	public String getAmountOfInvoice() {
		return AmountOfInvoice;
	}
	public void setAmountOfInvoice(String amountOfInvoice) {
		AmountOfInvoice = amountOfInvoice;
	}
	public String getDateOfInvoice() {
		return DateOfInvoice;
	}
	public void setDateOfInvoice(String dateOfInvoice) {
		DateOfInvoice = dateOfInvoice;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getWhoseCreditCard() {
		return WhoseCreditCard;
	}
	public void setWhoseCreditCard(String whoseCreditCard) {
		WhoseCreditCard = whoseCreditCard;
	}
	public String getFacilityName() {
		return FacilityName;
	}
	public void setFacilityName(String facilityName) {
		FacilityName = facilityName;
	}
	public String getPayeeName() {
		return PayeeName;
	}
	public void setPayeeName(String payeeName) {
		PayeeName = payeeName;
	}
	public String getMethodOfPayment() {
		return MethodOfPayment;
	}
	public void setMethodOfPayment(String methodOfPayment) {
		MethodOfPayment = methodOfPayment;
	}
	public String getPayDateDone() {
		return PayDateDone;
	}
	public void setPayDateDone(String payDateDone) {
		PayDateDone = payDateDone;
	}
	public String getPayDateDue() {
		return PayDateDue;
	}
	public void setPayDateDue(String payDateDue) {
		PayDateDue = payDateDue;
	}
	public String getHowMuchAmountPaid() {
		return HowMuchAmountPaid;
	}
	public void setHowMuchAmountPaid(String howMuchAmountPaid) {
		HowMuchAmountPaid = howMuchAmountPaid;
	}
	public String getCheckNumber() {
		return CheckNumber;
	}
	public void setCheckNumber(String checkNumber) {
		CheckNumber = checkNumber;
	}
	public String getRecordsReceived() {
		return RecordsReceived;
	}
	public void setRecordsReceived(String recordsReceived) {
		RecordsReceived = recordsReceived;
	}
	public String getDocumentId() {
		return DocumentId;
	}
	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}
	public String getDocumentName() {
		return DocumentName;
	}
	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}
	@Override
	public String toString() {
		return "AdvanceClientCostExport [projectId=" + projectId + ", Type=" + Type + ", InvoiceNumber=" + InvoiceNumber
				+ ", AmountOfInvoice=" + AmountOfInvoice + ", DateOfInvoice=" + DateOfInvoice + ", CardType=" + CardType
				+ ", Notes=" + Notes + ", Description=" + Description + ", WhoseCreditCard=" + WhoseCreditCard
				+ ", FacilityName=" + FacilityName + ", PayeeName=" + PayeeName + ", MethodOfPayment=" + MethodOfPayment
				+ ", PayDateDone=" + PayDateDone + ", PayDateDue=" + PayDateDue + ", HowMuchAmountPaid="
				+ HowMuchAmountPaid + ", CheckNumber=" + CheckNumber + ", RecordsReceived=" + RecordsReceived
				+ ", DocumentId=" + DocumentId + ", DocumentName=" + DocumentName + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
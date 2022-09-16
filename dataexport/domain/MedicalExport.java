package com.filevine.dataexport.domain;

public class MedicalExport {
	private int  ProjectId = 0; 
	private int PrivateID = 0;
	private String Amount;
	private String FinalAmount;
	private String RecordsCollectionFee = null;
	private String Reduction;
	private String Original;
	private String Notes = null;
	private String FirstDayOfTreatment = null;
	private String LastDayOfTreatment = null;
	private String DateRequested = null;
	private String DateReceived = null;
	private String OrderedBy = null;
	private String Method = null;
	private String SnagRequest = null;
	//
	private String outstandingBalance=null;
	private String recordscollectionstatus48362=null;
	private String billingcollectionstatus=null;
	private String recordrequestresponsedate=null;
	private String asof=null;
	private String createdDate=null;
	private String policynumber=null;
	private String plaintiffstreatmentstatus=null;
	private String providersaccountnumber=null;
	private String billsordered=null;
	private String billsreceived=null;
	private String recordsordered=null;
	private String recordsreceived=null;
	
	
	public String getPlaintiffstreatmentstatus() {
		return this.plaintiffstreatmentstatus;
	}
	public void setPlaintiffstreatmentstatus(String plaintiffstreatmentstatus) {
		this.plaintiffstreatmentstatus = plaintiffstreatmentstatus;
	}
	public String getProvidersaccountnumber() {
		return this.providersaccountnumber;
	}
	public void setProvidersaccountnumber(String providersaccountnumber) {
		this.providersaccountnumber = providersaccountnumber;
	}
	public String getBillsordered() {
		return this.billsordered;
	}
	public void setBillsordered(String billsordered) {
		this.billsordered = billsordered;
	}
	public String getBillsreceived() {
		return this.billsreceived;
	}
	public void setBillsreceived(String billsreceived) {
		this.billsreceived = billsreceived;
	}
	public String getRecordsordered() {
		return this.recordsordered;
	}
	public void setRecordsordered(String recordsordered) {
		this.recordsordered = recordsordered;
	}
	public String getRecordsreceived() {
		return this.recordsreceived;
	}
	public void setRecordsreceived(String recordsreceived) {
		this.recordsreceived = recordsreceived;
	}
	public String getPolicynumber() {
		return this.policynumber;
	}
	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getAsof() {
		return this.asof;
	}
	public void setAsof(String asof) {
		this.asof = asof;
	}
	public String getRecordrequestresponsedate() {
		return this.recordrequestresponsedate;
	}
	public void setRecordrequestresponsedate(String recordrequestresponsedate) {
		this.recordrequestresponsedate = recordrequestresponsedate;
	}
	public String getBillingcollectionstatus() {
		return this.billingcollectionstatus;
	}
	public void setBillingcollectionstatus(String billingcollectionstatus) {
		this.billingcollectionstatus = billingcollectionstatus;
	}
	public String getRecordscollectionstatus48362() {
		return this.recordscollectionstatus48362;
	}
	public void setRecordscollectionstatus48362(String recordscollectionstatus48362) {
		this.recordscollectionstatus48362 = recordscollectionstatus48362;
	}
	public String getOutstandingBalance() {
		return this.outstandingBalance;
	}
	public void setOutstandingBalance(String outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	
	public int getProjectId() {
		return this.ProjectId;
	}
	public void setProjectId(int projectId) {
		this.ProjectId = projectId;
	}
	public int getPrivateID() {
		return this.PrivateID;
	}
	public void setPrivateID(int privateID) {
		this.PrivateID = privateID;
	}
	
	public String getAmount() {
		return this.Amount;
	}
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public String getFinalAmount() {
		return this.FinalAmount;
	}
	public void setFinalAmount(String finalAmount) {
		this.FinalAmount = finalAmount;
	}
	public String getRecordsCollectionFee() {
		return this.RecordsCollectionFee;
	}
	public void setRecordsCollectionFee(String recordsCollectionFee) {
		this.RecordsCollectionFee = recordsCollectionFee;
	}
	public String getReduction() {
		return this.Reduction;
	}
	public void setReduction(String reduction) {
		this.Reduction = reduction;
	}
	public String getOriginal() {
		return this.Original;
	}
	public void setOriginal(String original) {
		this.Original = original;
	}
	public String getNotes() {
		return this.Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	public String getFirstDayOfTreatment() {
		return this.FirstDayOfTreatment;
	}
	public void setFirstDayOfTreatment(String firstDayOfTreatment) {
		this.FirstDayOfTreatment = firstDayOfTreatment;
	}
	public String getLastDayOfTreatment() {
		return this.LastDayOfTreatment;
	}
	public void setLastDayOfTreatment(String lastDayOfTreatment) {
		this.LastDayOfTreatment = lastDayOfTreatment;
	}
	public String getDateRequested() {
		return this.DateRequested;
	}
	public void setDateRequested(String dateRequested) {
		this.DateRequested = dateRequested;
	}
	public String getDateReceived() {
		return this.DateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.DateReceived = dateReceived;
	}
	public String getOrderedBy() {
		return this.OrderedBy;
	}
	public void setOrderedBy(String orderedBy) {
		this.OrderedBy = orderedBy;
	}
	public String getMethod() {
		return this.Method;
	}
	public void setMethod(String method) {
		this.Method = method;
	}
	public String getSnagRequest() {
		return this.SnagRequest;
	}
	public void setSnagRequest(String snagRequest) {
		this.SnagRequest = snagRequest;
	}
	@Override
	public String toString() {
		return "MedicalExport [ProjectId=" + ProjectId + ", PrivateID=" + PrivateID + ", Amount=" + Amount
				+ ", FinalAmount=" + FinalAmount + ", RecordsCollectionFee=" + RecordsCollectionFee + ", Reduction="
				+ Reduction + ", Original=" + Original + ", Notes=" + Notes + ", FirstDayOfTreatment="
				+ FirstDayOfTreatment + ", LastDayOfTreatment=" + LastDayOfTreatment + ", DateRequested="
				+ DateRequested + ", DateReceived=" + DateReceived + ", OrderedBy=" + OrderedBy + ", Method=" + Method
				+ ", SnagRequest=" + SnagRequest + ", outstandingBalance=" + outstandingBalance
				+ ", recordscollectionstatus48362=" + recordscollectionstatus48362 + ", billingcollectionstatus="
				+ billingcollectionstatus + ", recordrequestresponsedate=" + recordrequestresponsedate + ", asof="
				+ asof + ", createdDate=" + createdDate + ", policynumber=" + policynumber
				+ ", plaintiffstreatmentstatus=" + plaintiffstreatmentstatus + ", providersaccountnumber="
				+ providersaccountnumber + ", billsordered=" + billsordered + ", billsreceived=" + billsreceived
				+ ", recordsordered=" + recordsordered + ", recordsreceived=" + recordsreceived + "]";
	}
	

}

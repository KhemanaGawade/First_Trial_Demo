package com.filevine.dataexport.domain;

public class NegotiationsExport {
	//
	int projectId=0;
	String id=null;
	int docId=0;
	String docName=null;
	String offerLetter=null;
	String methodOfOffer=null;
	int toFromDemandId=0;
	double amount=0.0;
	String priorClientApproval;
	String date=null;
	String expiryDate=null;
	//
	private String demandsent=null;
	private String offerhistory=null;
	private String datedemandsent=null;
	private String createdDate=null;
	private String negotiationtype=null;
	private String notes;
	
	
	
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getNegotiationtype() {
		return this.negotiationtype;
	}
	public void setNegotiationtype(String negotiationtype) {
		this.negotiationtype = negotiationtype;
	}
	public String getDemandsent() {
		return this.demandsent;
	}
	public void setDemandsent(String demandsent) {
		this.demandsent = demandsent;
	}
	public String getOfferhistory() {
		return this.offerhistory;
	}
	public void setOfferhistory(String offerhistory) {
		this.offerhistory = offerhistory;
	}
	public String getDatedemandsent() {
		return this.datedemandsent;
	}
	public void setDatedemandsent(String datedemandsent) {
		this.datedemandsent = datedemandsent;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDocId() {
		return this.docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return this.docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getOfferLetter() {
		return this.offerLetter;
	}
	public void setOfferLetter(String offerLetter) {
		this.offerLetter = offerLetter;
	}
	public String getMethodOfOffer() {
		return this.methodOfOffer;
	}
	public void setMethodOfOffer(String methodOfOffer) {
		this.methodOfOffer = methodOfOffer;
	}
	public int getToFromDemandId() {
		return this.toFromDemandId;
	}
	public void setToFromDemandId(int toFromDemandId) {
		this.toFromDemandId = toFromDemandId;
	}
	public double getAmount() {
		return this.amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPriorClientApproval() {
		return this.priorClientApproval;
	}
	public void setPriorClientApproval(String priorClientApproval) {
		this.priorClientApproval = priorClientApproval;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getExpiryDate() {
		return this.expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "NegotiationsExport [projectId=" + projectId + ", id=" + id + ", docId=" + docId + ", docName=" + docName
				+ ", offerLetter=" + offerLetter + ", methodOfOffer=" + methodOfOffer + ", toFromDemandId="
				+ toFromDemandId + ", amount=" + amount + ", priorClientApproval=" + priorClientApproval + ", date="
				+ date + ", expiryDate=" + expiryDate + ", demandsent=" + demandsent + ", offerhistory=" + offerhistory
				+ ", datedemandsent=" + datedemandsent + ", createdDate=" + createdDate + ", negotiationtype="
				+ negotiationtype + ", notes=" + notes + "]";
	}


}

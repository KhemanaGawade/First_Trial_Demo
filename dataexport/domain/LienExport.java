package com.filevine.dataexport.domain;

public class LienExport {
	
	private int ProjectId = 0;
	private int LienHolder = 0;
	private String Amount  = null;
	private String RecoveryAgency=null ;
	private String RecoveryAgent=null;
	private String DateSent  = null;
	private String dateReceived  = null;
	private String DateOfReceipt = null;
	private String Notes  = null;
	private String noticereceived=null;
	private String finallienrecieved=null;
	private String lorsent=null;
	
	public String getLorsent() {
		return this.lorsent;
	}
	public void setLorsent(String lorsent) {
		this.lorsent = lorsent;
	}
	public String getNoticereceived() {
		return this.noticereceived;
	}
	public void setNoticereceived(String noticereceived) {
		this.noticereceived = noticereceived;
	}
	public String getFinallienrecieved() {
		return this.finallienrecieved;
	}
	public void setFinallienrecieved(String finallienrecieved) {
		this.finallienrecieved = finallienrecieved;
	}
	public int getProjectId() {
		return this.ProjectId;
	}
	public void setProjectId(int projectId) {
		this.ProjectId = projectId;
	}
	public int getLienHolder() {
		return this.LienHolder;
	}
	public void setLienHolder(int lienHolder) {
		this.LienHolder = lienHolder;
	}
	public String getAmount() {
		return this.Amount;
	}
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public String getDateSent() {
		return this.DateSent;
	}
	public void setDateSent(String dateSent) {
		this.DateSent = dateSent;
	}
	public String getDateReceived() {
		return this.dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	public String getDateOfReceipt() {
		return this.DateOfReceipt;
	}
	public void setDateOfReceipt(String dateOfReceipt) {
		this.DateOfReceipt = dateOfReceipt;
	}
	public String getNotes() {
		return this.Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	
	public String getRecoveryAgency() {
		return this.RecoveryAgency;
	}
	public void setRecoveryAgency(String recoveryAgency) {
		this.RecoveryAgency = recoveryAgency;
	}
	public String getRecoveryAgent() {
		return this.RecoveryAgent;
	}
	public void setRecoveryAgent(String recoveryAgent) {
		this.RecoveryAgent = recoveryAgent;
	}
	@Override
	public String toString() {
		return "LienExport [ProjectId=" + ProjectId + ", LienHolder=" + LienHolder + ", Amount=" + Amount
				+ ", RecoveryAgency=" + RecoveryAgency + ", RecoveryAgent=" + RecoveryAgent + ", DateSent=" + DateSent
				+ ", dateReceived=" + dateReceived + ", DateOfReceipt=" + DateOfReceipt + ", Notes=" + Notes
				+ ", noticereceived=" + noticereceived + ", finallienrecieved=" + finallienrecieved + ", lorsent="
				+ lorsent + "]";
	}

}

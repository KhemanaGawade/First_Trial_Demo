package com.filevine.dataexport.domain;

public class ExpensesExport {
	private int ProjectId = 0;
	private String title = null;
	private String Amount = null;
	private String PaymentMethod = null;
	private String dateOfExpense=null;

	private String Notes = null;
	private String CreatedDate = null;
	
	
	public String getDateOfExpense() {
		return this.dateOfExpense;
	}
	public void setDateOfExpense(String dateOfExpense) {
		this.dateOfExpense = dateOfExpense;
	}
	public int getProjectId() {
		return this.ProjectId;
	}
	public void setProjectId(int projectId) {
		this.ProjectId = projectId;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAmount() {
		return this.Amount;
	}
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public String getPaymentMethod() {
		return this.PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.PaymentMethod = paymentMethod;
	}
	public String getNotes() {
		return this.Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	public String getCreatedDate() {
		return this.CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		this.CreatedDate = createdDate;
	}
	@Override
	public String toString() {
		return "ExpensesExport [ProjectId=" + ProjectId + ", title=" + title + ", Amount=" + Amount + ", PaymentMethod="
				+ PaymentMethod + ", dateOfExpense=" + dateOfExpense + ", Notes=" + Notes + ", CreatedDate="
				+ CreatedDate + "]";
	}

	
	
}

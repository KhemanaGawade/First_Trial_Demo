package com.filevine.dataexport.domain;

public class ExpenseDocExport {
	
	private int projectId=0;
	private String ExpenseTitle=null;
	private String RecieptId=null;
	private String OrgID=null;
	private String RecieptFileName=null;
	@Override
	public String toString() {
		return "ExpenseDocExport [projectId=" + projectId + ", ExpenseTitle=" + ExpenseTitle + ", RecieptId="
				+ RecieptId + ", OrgID=" + OrgID + ", RecieptFileName=" + RecieptFileName + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getExpenseTitle() {
		return ExpenseTitle;
	}
	public void setExpenseTitle(String expenseTitle) {
		ExpenseTitle = expenseTitle;
	}
	public String getRecieptId() {
		return RecieptId;
	}
	public void setRecieptId(String recieptId) {
		RecieptId = recieptId;
	}
	public String getOrgID() {
		return OrgID;
	}
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}
	public String getRecieptFileName() {
		return RecieptFileName;
	}
	public void setRecieptFileName(String recieptFileName) {
		RecieptFileName = recieptFileName;
	}
	

}

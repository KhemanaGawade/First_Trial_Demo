package com.filevine.dataexport.domain;

public class MedicalBillsDoc {
	
	private int projectId=0;
	private String MedicalProvider=null;
	private String BillsInvoiceId=null;
	private String OrgID=null;
	private String BillsInvoiceFileName=null;
	private String RecordsRetrievalInvoiceId=null;
	private String RecordsRetrievalFilename=null;
	@Override
	public String toString() {
		return "MedicalBillsDoc [projectId=" + projectId + ", MedicalProvider=" + MedicalProvider + ", BillsInvoiceId="
				+ BillsInvoiceId + ", OrgID=" + OrgID + ", BillsInvoiceFileName=" + BillsInvoiceFileName
				+ ", RecordsRetrievalInvoiceId=" + RecordsRetrievalInvoiceId + ", RecordsRetrievalFilename="
				+ RecordsRetrievalFilename + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getMedicalProvider() {
		return MedicalProvider;
	}
	public void setMedicalProvider(String medicalProvider) {
		MedicalProvider = medicalProvider;
	}
	public String getBillsInvoiceId() {
		return BillsInvoiceId;
	}
	public void setBillsInvoiceId(String billsInvoiceId) {
		BillsInvoiceId = billsInvoiceId;
	}
	public String getOrgID() {
		return OrgID;
	}
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}
	public String getBillsInvoiceFileName() {
		return BillsInvoiceFileName;
	}
	public void setBillsInvoiceFileName(String billsInvoiceFileName) {
		BillsInvoiceFileName = billsInvoiceFileName;
	}
	public String getRecordsRetrievalInvoiceId() {
		return RecordsRetrievalInvoiceId;
	}
	public void setRecordsRetrievalInvoiceId(String recordsRetrievalInvoiceId) {
		RecordsRetrievalInvoiceId = recordsRetrievalInvoiceId;
	}
	public String getRecordsRetrievalFilename() {
		return RecordsRetrievalFilename;
	}
	public void setRecordsRetrievalFilename(String recordsRetrievalFilename) {
		RecordsRetrievalFilename = recordsRetrievalFilename;
	}
	
	
	
	

}

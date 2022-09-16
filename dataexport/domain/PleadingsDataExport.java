package com.filevine.dataexport.domain;

public class PleadingsDataExport {

	private int projectId=0;
	private String PartyServingFilingPleading=null;
	private String PleadingType=null;
	private String PleadingName=null;
	private String Defendant=null;
	private String DateFiled=null;
	private String HearingSet=null;
	private String OrderTendered=null;
	private String Notes=null;
	private String DateServed=null;
	private String Party=null;
	@Override
	public String toString() {
		return "PleadingsDataExport [projectId=" + projectId + ", PartyServingFilingPleading="
				+ PartyServingFilingPleading + ", PleadingType=" + PleadingType + ", PleadingName=" + PleadingName
				+ ", Defendant=" + Defendant + ", DateFiled=" + DateFiled + ", HearingSet=" + HearingSet
				+ ", OrderTendered=" + OrderTendered + ", Notes=" + Notes + ", DateServed=" + DateServed + ", Party="
				+ Party + ", DocumentsId=" + DocumentsId + ", DocumentsFileName=" + DocumentsFileName + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getPartyServingFilingPleading() {
		return PartyServingFilingPleading;
	}
	public void setPartyServingFilingPleading(String partyServingFilingPleading) {
		PartyServingFilingPleading = partyServingFilingPleading;
	}
	public String getPleadingType() {
		return PleadingType;
	}
	public void setPleadingType(String pleadingType) {
		PleadingType = pleadingType;
	}
	public String getPleadingName() {
		return PleadingName;
	}
	public void setPleadingName(String pleadingName) {
		PleadingName = pleadingName;
	}
	public String getDefendant() {
		return Defendant;
	}
	public void setDefendant(String defendant) {
		Defendant = defendant;
	}
	public String getDateFiled() {
		return DateFiled;
	}
	public void setDateFiled(String dateFiled) {
		DateFiled = dateFiled;
	}
	public String getHearingSet() {
		return HearingSet;
	}
	public void setHearingSet(String hearingSet) {
		HearingSet = hearingSet;
	}
	public String getOrderTendered() {
		return OrderTendered;
	}
	public void setOrderTendered(String orderTendered) {
		OrderTendered = orderTendered;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getDateServed() {
		return DateServed;
	}
	public void setDateServed(String dateServed) {
		DateServed = dateServed;
	}
	public String getParty() {
		return Party;
	}
	public void setParty(String party) {
		Party = party;
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

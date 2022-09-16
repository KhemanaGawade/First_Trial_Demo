package com.filevine.dataexport.domain;

public class DiscoveryDataExport {

	
	private int projectId=0;
	private String DefendantPlaintiff=null;
	private String Type=null;
	private String PartyIs=null;
	private String Party=null;
	private String DateFiled=null;
	private String ServedTo=null;
	private String DateServed=null;
	private String DocumentTitle=null;
	private String Notes=null;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getDefendantPlaintiff() {
		return DefendantPlaintiff;
	}
	public void setDefendantPlaintiff(String defendantPlaintiff) {
		DefendantPlaintiff = defendantPlaintiff;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getPartyIs() {
		return PartyIs;
	}
	public void setPartyIs(String partyIs) {
		PartyIs = partyIs;
	}
	public String getParty() {
		return Party;
	}
	public void setParty(String party) {
		Party = party;
	}
	public String getDateFiled() {
		return DateFiled;
	}
	public void setDateFiled(String dateFiled) {
		DateFiled = dateFiled;
	}
	public String getServedTo() {
		return ServedTo;
	}
	public void setServedTo(String servedTo) {
		ServedTo = servedTo;
	}
	public String getDateServed() {
		return DateServed;
	}
	public void setDateServed(String dateServed) {
		DateServed = dateServed;
	}
	public String getDocumentTitle() {
		return DocumentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		DocumentTitle = documentTitle;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	@Override
	public String toString() {
		return "DiscoveryDataExport [projectId=" + projectId + ", DefendantPlaintiff=" + DefendantPlaintiff + ", Type="
				+ Type + ", PartyIs=" + PartyIs + ", Party=" + Party + ", DateFiled=" + DateFiled + ", ServedTo="
				+ ServedTo + ", DateServed=" + DateServed + ", DocumentTitle=" + DocumentTitle + ", Notes=" + Notes
				+ "]";
	}
	
}
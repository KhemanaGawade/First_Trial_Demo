package com.filevine.dataexport.domain;

public class ClientInfoDataExport {

	private int projectId=0;
	private String ReferralSource=null;
	private String UniqueId=null;
	@Override
	public String toString() {
		return "ClientInfoDataExport [projectId=" + projectId + ", ReferralSource=" + ReferralSource + ", UniqueId="
				+ UniqueId + ", PrimaryContactId=" + PrimaryContactId + ", OrgID=" + OrgID + ", PrimaryContactFullName="
				+ PrimaryContactFullName + ", ClientNotes=" + ClientNotes + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getReferralSource() {
		return ReferralSource;
	}
	public void setReferralSource(String referralSource) {
		ReferralSource = referralSource;
	}
	public String getUniqueId() {
		return UniqueId;
	}
	public void setUniqueId(String uniqueId) {
		UniqueId = uniqueId;
	}
	public String getPrimaryContactId() {
		return PrimaryContactId;
	}
	public void setPrimaryContactId(String primaryContactId) {
		PrimaryContactId = primaryContactId;
	}
	public String getOrgID() {
		return OrgID;
	}
	public void setOrgID(String orgID) {
		OrgID = orgID;
	}
	public String getPrimaryContactFullName() {
		return PrimaryContactFullName;
	}
	public void setPrimaryContactFullName(String primaryContactFullName) {
		PrimaryContactFullName = primaryContactFullName;
	}
	public String getClientNotes() {
		return ClientNotes;
	}
	public void setClientNotes(String clientNotes) {
		ClientNotes = clientNotes;
	}
	private String PrimaryContactId=null;
	private String OrgID=null;
	private String PrimaryContactFullName=null;
	private String ClientNotes=null;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

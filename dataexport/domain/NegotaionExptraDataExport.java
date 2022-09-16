package com.filevine.dataexport.domain;

public class NegotaionExptraDataExport {

	
	private int projectId=0;
	private String PartyId=null;
	private String OrgId=null;
	private String PartyFullName=null;
	private String UniqueId=null;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getPartyId() {
		return PartyId;
	}
	public void setPartyId(String partyId) {
		PartyId = partyId;
	}
	public String getOrgId() {
		return OrgId;
	}
	public void setOrgId(String orgId) {
		OrgId = orgId;
	}
	public String getPartyFullName() {
		return PartyFullName;
	}
	public void setPartyFullName(String partyFullName) {
		PartyFullName = partyFullName;
	}
	public String getUniqueId() {
		return UniqueId;
	}
	public void setUniqueId(String uniqueId) {
		UniqueId = uniqueId;
	}
	@Override
	public String toString() {
		return "NegotaionExptraDataExport [projectId=" + projectId + ", PartyId=" + PartyId + ", OrgId=" + OrgId
				+ ", PartyFullName=" + PartyFullName + ", UniqueId=" + UniqueId + "]";
	}
	
	
	
	
	
	
	
	
}

package com.filevine.dataexport.domain;

public class MotionDataExport {

	
	private int projectId=0;
	private String PartyServingFilingpLeading=null;
	private String PartyServing=null;
	private String MotionName=null;
	private String PartyServed=null;
	private String DateServed=null;
	private String OrderReceived=null;
	private String MotiondocId=null;
	private String MotiondocFileName=null;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getPartyServingFilingpLeading() {
		return PartyServingFilingpLeading;
	}
	public void setPartyServingFilingpLeading(String partyServingFilingpLeading) {
		PartyServingFilingpLeading = partyServingFilingpLeading;
	}
	public String getPartyServing() {
		return PartyServing;
	}
	public void setPartyServing(String partyServing) {
		PartyServing = partyServing;
	}
	public String getMotionName() {
		return MotionName;
	}
	public void setMotionName(String motionName) {
		MotionName = motionName;
	}
	public String getPartyServed() {
		return PartyServed;
	}
	public void setPartyServed(String partyServed) {
		PartyServed = partyServed;
	}
	public String getDateServed() {
		return DateServed;
	}
	public void setDateServed(String dateServed) {
		DateServed = dateServed;
	}
	public String getOrderReceived() {
		return OrderReceived;
	}
	public void setOrderReceived(String orderReceived) {
		OrderReceived = orderReceived;
	}
	public String getMotiondocId() {
		return MotiondocId;
	}
	public void setMotiondocId(String motiondocId) {
		MotiondocId = motiondocId;
	}
	public String getMotiondocFileName() {
		return MotiondocFileName;
	}
	public void setMotiondocFileName(String motiondocFileName) {
		MotiondocFileName = motiondocFileName;
	}
	@Override
	public String toString() {
		return "MotionDataExport [projectId=" + projectId + ", PartyServingFilingpLeading=" + PartyServingFilingpLeading
				+ ", PartyServing=" + PartyServing + ", MotionName=" + MotionName + ", PartyServed=" + PartyServed
				+ ", DateServed=" + DateServed + ", OrderReceived=" + OrderReceived + ", MotiondocId=" + MotiondocId
				+ ", MotiondocFileName=" + MotiondocFileName + "]";
	}
	
	
	
	
	
	
	
	
	
}

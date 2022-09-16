package com.filevine.dataexport.domain;

public class PartysDataExport {

	private int projectId=0;
	private String DefendantType=null;
	private String Defendant=null;
	private String Counsel=null;
	private String CoCounsels=null;
	private String PersonalCounsel=null;
	private String LawsuitFiled=null;
	private String IsDefendantaBusiness=null;
	private String ProcessServer=null;
	private String DefendantServed=null;
	private String DateOfService=null;
	private String MannerOfService=null;
	private String ProofOfServiceFiled =null;
	private String DateOfFiling=null;
	private String PartyNotes=null;
	private String HasDefendantRespondedToComplaint=null;
	@Override
	public String toString() {
		return "PartysDataExport [projectId=" + projectId + ", DefendantType=" + DefendantType + ", Defendant="
				+ Defendant + ", Counsel=" + Counsel + ", CoCounsels=" + CoCounsels + ", PersonalCounsel="
				+ PersonalCounsel + ", LawsuitFiled=" + LawsuitFiled + ", IsDefendantaBusiness=" + IsDefendantaBusiness
				+ ", ProcessServer=" + ProcessServer + ", DefendantServed=" + DefendantServed + ", DateOfService="
				+ DateOfService + ", MannerOfService=" + MannerOfService + ", ProofOfServiceFiled="
				+ ProofOfServiceFiled + ", DateOfFiling=" + DateOfFiling + ", PartyNotes=" + PartyNotes
				+ ", HasDefendantRespondedToComplaint=" + HasDefendantRespondedToComplaint + ", TypeOfBusiness="
				+ TypeOfBusiness + ", AgentForProcessOfServiceName=" + AgentForProcessOfServiceName
				+ ", AgentForProcessOfServiceId=" + AgentForProcessOfServiceId + ", PosId=" + PosId + ", PosFileName="
				+ PosFileName + ", DocumentsFileName=" + DocumentsFileName + ", DocumentsId=" + DocumentsId + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getDefendantType() {
		return DefendantType;
	}
	public void setDefendantType(String defendantType) {
		DefendantType = defendantType;
	}
	public String getDefendant() {
		return Defendant;
	}
	public void setDefendant(String defendant) {
		Defendant = defendant;
	}
	public String getCounsel() {
		return Counsel;
	}
	public void setCounsel(String counsel) {
		Counsel = counsel;
	}
	public String getCoCounsels() {
		return CoCounsels;
	}
	public void setCoCounsels(String coCounsels) {
		CoCounsels = coCounsels;
	}
	public String getPersonalCounsel() {
		return PersonalCounsel;
	}
	public void setPersonalCounsel(String personalCounsel) {
		PersonalCounsel = personalCounsel;
	}
	public String getLawsuitFiled() {
		return LawsuitFiled;
	}
	public void setLawsuitFiled(String lawsuitFiled) {
		LawsuitFiled = lawsuitFiled;
	}
	public String getIsDefendantaBusiness() {
		return IsDefendantaBusiness;
	}
	public void setIsDefendantaBusiness(String isDefendantaBusiness) {
		IsDefendantaBusiness = isDefendantaBusiness;
	}
	public String getProcessServer() {
		return ProcessServer;
	}
	public void setProcessServer(String processServer) {
		ProcessServer = processServer;
	}
	public String getDefendantServed() {
		return DefendantServed;
	}
	public void setDefendantServed(String defendantServed) {
		DefendantServed = defendantServed;
	}
	public String getDateOfService() {
		return DateOfService;
	}
	public void setDateOfService(String dateOfService) {
		DateOfService = dateOfService;
	}
	public String getMannerOfService() {
		return MannerOfService;
	}
	public void setMannerOfService(String mannerOfService) {
		MannerOfService = mannerOfService;
	}
	public String getProofOfServiceFiled() {
		return ProofOfServiceFiled;
	}
	public void setProofOfServiceFiled(String proofOfServiceFiled) {
		ProofOfServiceFiled = proofOfServiceFiled;
	}
	public String getDateOfFiling() {
		return DateOfFiling;
	}
	public void setDateOfFiling(String dateOfFiling) {
		DateOfFiling = dateOfFiling;
	}
	public String getPartyNotes() {
		return PartyNotes;
	}
	public void setPartyNotes(String partyNotes) {
		PartyNotes = partyNotes;
	}
	public String getHasDefendantRespondedToComplaint() {
		return HasDefendantRespondedToComplaint;
	}
	public void setHasDefendantRespondedToComplaint(String hasDefendantRespondedToComplaint) {
		HasDefendantRespondedToComplaint = hasDefendantRespondedToComplaint;
	}
	public String getTypeOfBusiness() {
		return TypeOfBusiness;
	}
	public void setTypeOfBusiness(String typeOfBusiness) {
		TypeOfBusiness = typeOfBusiness;
	}
	public String getAgentForProcessOfServiceName() {
		return AgentForProcessOfServiceName;
	}
	public void setAgentForProcessOfServiceName(String agentForProcessOfServiceName) {
		AgentForProcessOfServiceName = agentForProcessOfServiceName;
	}
	public String getAgentForProcessOfServiceId() {
		return AgentForProcessOfServiceId;
	}
	public void setAgentForProcessOfServiceId(String agentForProcessOfServiceId) {
		AgentForProcessOfServiceId = agentForProcessOfServiceId;
	}
	public String getPosId() {
		return PosId;
	}
	public void setPosId(String posId) {
		PosId = posId;
	}
	public String getPosFileName() {
		return PosFileName;
	}
	public void setPosFileName(String posFileName) {
		PosFileName = posFileName;
	}
	public String getDocumentsFileName() {
		return DocumentsFileName;
	}
	public void setDocumentsFileName(String documentsFileName) {
		DocumentsFileName = documentsFileName;
	}
	public String getDocumentsId() {
		return DocumentsId;
	}
	public void setDocumentsId(String documentsId) {
		DocumentsId = documentsId;
	}
	private String TypeOfBusiness=null;
	private String AgentForProcessOfServiceName=null;
	private String AgentForProcessOfServiceId =null;
	private String PosId=null;
	private String PosFileName=null;
	private String DocumentsFileName=null;
	private String DocumentsId=null;
	
	
	
	
	
}

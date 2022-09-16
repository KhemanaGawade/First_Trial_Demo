package com.filevine.dataexport.domain;

/**
 * This class is having all required fields of case summary details tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class CaseSummaryExport {

	private int projectId = 0;
	private String DateOfAccident =null;
	private String StatuteOfLimitationsDate =null;
	private String StatuteOfLimitationsDue =null;
	private String firstdateoftreatment=null;
	private String lastdateoftreatment=null;
	//
	private String fieldName=null;
	private String friendlyName=null;
	private String fieldType=null;
	private String fieldValue=null;
	private String linkRefValue=null;
	private String position=null;
	
	private String Notes =null;
	private String TypeOfCase  =null;
	private String Synopsis =null;
	private String DefendantCitationDescription=null;
	private String PoliceDepartment =null;
	private String PoliceReport =null;
	private String CitationDescription =null;
	
	private String description=null;
	private String estimated_settlementvalu=null;
	private String incident_date=null;
	private String phase_date=null;
	private String ssn_number=null;
	private String emailAddress=null;
	private String projectTypeName=null;
	private String orgName=null;
	private String isBillingEnabled=null;
	private String projectName=null;
	private String phaseName=null;
	
	private String demandsent=null;
	private String finalstlmt=null;
	private String defendantId=null;
	private String plantiffId=null;
	private String co_counselId=null;
	private String cocounselfirm_id=null;
	private String courthouse_id=null;
	private String judgeId=null;
	private String paralegalId=null;
	private String primaryAttorneyId=null;
	private String caseNumber=null;
	
	public String getCaseNumber() {
		return this.caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getPrimaryAttorneyId() {
		return this.primaryAttorneyId;
	}
	public void setPrimaryAttorneyId(String primaryAttorneyId) {
		this.primaryAttorneyId = primaryAttorneyId;
	}
	public String getJudgeId() {
		return this.judgeId;
	}
	public void setJudgeId(String judgeId) {
		this.judgeId = judgeId;
	}
	public String getParalegalId() {
		return this.paralegalId;
	}
	public void setParalegalId(String paralegalId) {
		this.paralegalId = paralegalId;
	}
	public String getCourthouse_id() {
		return this.courthouse_id;
	}
	public void setCourthouse_id(String courthouse_id) {
		this.courthouse_id = courthouse_id;
	}
	public String getCocounselfirm_id() {
		return this.cocounselfirm_id;
	}
	public void setCocounselfirm_id(String cocounselfirm_id) {
		this.cocounselfirm_id = cocounselfirm_id;
	}
	public String getCo_counselId() {
		return this.co_counselId;
	}
	public void setCo_counselId(String co_counselId) {
		this.co_counselId = co_counselId;
	}
	public String getDefendantId() {
		return this.defendantId;
	}
	public void setDefendantId(String defendantId) {
		this.defendantId = defendantId;
	}
	public String getPlantiffId() {
		return this.plantiffId;
	}
	public void setPlantiffId(String plantiffId) {
		this.plantiffId = plantiffId;
	}
	public String getDemandsent() {
		return this.demandsent;
	}
	public void setDemandsent(String demandsent) {
		this.demandsent = demandsent;
	}
	public String getFinalstlmt() {
		return this.finalstlmt;
	}
	public void setFinalstlmt(String finalstlmt) {
		this.finalstlmt = finalstlmt;
	}
	public String getFirstdateoftreatment() {
		return this.firstdateoftreatment;
	}
	public void setFirstdateoftreatment(String firstdateoftreatment) {
		this.firstdateoftreatment = firstdateoftreatment;
	}
	public String getLastdateoftreatment() {
		return this.lastdateoftreatment;
	}
	public void setLastdateoftreatment(String lastdateoftreatment) {
		this.lastdateoftreatment = lastdateoftreatment;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEstimated_settlementvalu() {
		return this.estimated_settlementvalu;
	}
	public void setEstimated_settlementvalu(String estimated_settlementvalu) {
		this.estimated_settlementvalu = estimated_settlementvalu;
	}
	public String getIncident_date() {
		return this.incident_date;
	}
	public void setIncident_date(String incident_date) {
		this.incident_date = incident_date;
	}
	public String getPhase_date() {
		return this.phase_date;
	}
	public void setPhase_date(String phase_date) {
		this.phase_date = phase_date;
	}
	public String getSsn_number() {
		return this.ssn_number;
	}
	public void setSsn_number(String ssn_number) {
		this.ssn_number = ssn_number;
	}
	public String getEmailAddress() {
		return this.emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getProjectTypeName() {
		return this.projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	public String getOrgName() {
		return this.orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getIsBillingEnabled() {
		return this.isBillingEnabled;
	}
	public void setIsBillingEnabled(String isBillingEnabled) {
		this.isBillingEnabled = isBillingEnabled;
	}
	public String getProjectName() {
		return this.projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getPhaseName() {
		return this.phaseName;
	}
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getDateOfAccident() {
		return this.DateOfAccident;
	}
	public void setDateOfAccident(String dateOfAccident) {
		this.DateOfAccident = dateOfAccident;
	}
	
	public String getStatuteOfLimitationsDate() {
		return this.StatuteOfLimitationsDate;
	}
	public void setStatuteOfLimitationsDate(String statuteOfLimitationsDate) {
		this.StatuteOfLimitationsDate = statuteOfLimitationsDate;
	}
	public String getStatuteOfLimitationsDue() {
		return this.StatuteOfLimitationsDue;
	}
	public void setStatuteOfLimitationsDue(String statuteOfLimitationsDue) {
		this.StatuteOfLimitationsDue = statuteOfLimitationsDue;
	}
	public String getNotes() {
		return this.Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	public String getTypeOfCase() {
		return this.TypeOfCase;
	}
	public void setTypeOfCase(String typeOfCase) {
		this.TypeOfCase = typeOfCase;
	}
	public String getSynopsis() {
		return this.Synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.Synopsis = synopsis;
	}
	public String getDefendantCitationDescription() {
		return this.DefendantCitationDescription;
	}
	public void setDefendantCitationDescription(String defendantCitationDescription) {
		this.DefendantCitationDescription = defendantCitationDescription;
	}
	public String getPoliceDepartment() {
		return this.PoliceDepartment;
	}
	public void setPoliceDepartment(String policeDepartment) {
		this.PoliceDepartment = policeDepartment;
	}
	public String getPoliceReport() {
		return this.PoliceReport;
	}
	public void setPoliceReport(String policeReport) {
		this.PoliceReport = policeReport;
	}
	public String getCitationDescription() {
		return this.CitationDescription;
	}
	public void setCitationDescription(String citationDescription) {
		this.CitationDescription = citationDescription;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFriendlyName() {
		return this.friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getFieldType() {
		return this.fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldValue() {
		return this.fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getLinkRefValue() {
		return this.linkRefValue;
	}
	public void setLinkRefValue(String linkRefValue) {
		this.linkRefValue = linkRefValue;
	}
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "CaseSummaryExport [projectId=" + projectId + ", DateOfAccident=" + DateOfAccident
				+ ", StatuteOfLimitationsDate=" + StatuteOfLimitationsDate + ", StatuteOfLimitationsDue="
				+ StatuteOfLimitationsDue + ", firstdateoftreatment=" + firstdateoftreatment + ", lastdateoftreatment="
				+ lastdateoftreatment + ", fieldName=" + fieldName + ", friendlyName=" + friendlyName + ", fieldType="
				+ fieldType + ", fieldValue=" + fieldValue + ", linkRefValue=" + linkRefValue + ", position=" + position
				+ ", Notes=" + Notes + ", TypeOfCase=" + TypeOfCase + ", Synopsis=" + Synopsis
				+ ", DefendantCitationDescription=" + DefendantCitationDescription + ", PoliceDepartment="
				+ PoliceDepartment + ", PoliceReport=" + PoliceReport + ", CitationDescription=" + CitationDescription
				+ ", description=" + description + ", estimated_settlementvalu=" + estimated_settlementvalu
				+ ", incident_date=" + incident_date + ", phase_date=" + phase_date + ", ssn_number=" + ssn_number
				+ ", emailAddress=" + emailAddress + ", projectTypeName=" + projectTypeName + ", orgName=" + orgName
				+ ", isBillingEnabled=" + isBillingEnabled + ", projectName=" + projectName + ", phaseName=" + phaseName
				+ ", demandsent=" + demandsent + ", finalstlmt=" + finalstlmt + ", defendantId=" + defendantId
				+ ", plantiffId=" + plantiffId + ", co_counselId=" + co_counselId + ", cocounselfirm_id="
				+ cocounselfirm_id + ", courthouse_id=" + courthouse_id + ", judgeId=" + judgeId + ", paralegalId="
				+ paralegalId + ", primaryAttorneyId=" + primaryAttorneyId + ", caseNumber=" + caseNumber + "]";
	}


	
}

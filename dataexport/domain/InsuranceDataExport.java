package com.filevine.dataexport.domain;

public class InsuranceDataExport {

	private int projectId=0;
	private String InsuranceType=null;
	private String InsuranceCompany=null;
	private String Adjuster=null;
	private String Insured=null;
	private String ClaimNumber=null;
	private String PolicyNumber=null;
	private String PolicyLimits=null;
	private String AcceptLiability=null;
	private String AdditionalInsuranceNotes=null;
	private String Decsheet=null;
	private String CreatedDate =null;
	@Override
	public String toString() {
		return "InsuranceDataExport [projectId=" + projectId + ", InsuranceType=" + InsuranceType
				+ ", InsuranceCompany=" + InsuranceCompany + ", Adjuster=" + Adjuster + ", Insured=" + Insured
				+ ", ClaimNumber=" + ClaimNumber + ", PolicyNumber=" + PolicyNumber + ", PolicyLimits=" + PolicyLimits
				+ ", AcceptLiability=" + AcceptLiability + ", AdditionalInsuranceNotes=" + AdditionalInsuranceNotes
				+ ", Decsheet=" + Decsheet + ", CreatedDate=" + CreatedDate + ", InsuranceCompanyId="
				+ InsuranceCompanyId + ", AdjusterId=" + AdjusterId + ", InsuredId=" + InsuredId
				+ ", OtherInsuranceType=" + OtherInsuranceType + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getInsuranceType() {
		return InsuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		InsuranceType = insuranceType;
	}
	public String getInsuranceCompany() {
		return InsuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		InsuranceCompany = insuranceCompany;
	}
	public String getAdjuster() {
		return Adjuster;
	}
	public void setAdjuster(String adjuster) {
		Adjuster = adjuster;
	}
	public String getInsured() {
		return Insured;
	}
	public void setInsured(String insured) {
		Insured = insured;
	}
	public String getClaimNumber() {
		return ClaimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		ClaimNumber = claimNumber;
	}
	public String getPolicyNumber() {
		return PolicyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}
	public String getPolicyLimits() {
		return PolicyLimits;
	}
	public void setPolicyLimits(String policyLimits) {
		PolicyLimits = policyLimits;
	}
	public String getAcceptLiability() {
		return AcceptLiability;
	}
	public void setAcceptLiability(String acceptLiability) {
		AcceptLiability = acceptLiability;
	}
	public String getAdditionalInsuranceNotes() {
		return AdditionalInsuranceNotes;
	}
	public void setAdditionalInsuranceNotes(String additionalInsuranceNotes) {
		AdditionalInsuranceNotes = additionalInsuranceNotes;
	}
	public String getDecsheet() {
		return Decsheet;
	}
	public void setDecsheet(String decsheet) {
		Decsheet = decsheet;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public String getInsuranceCompanyId() {
		return InsuranceCompanyId;
	}
	public void setInsuranceCompanyId(String insuranceCompanyId) {
		InsuranceCompanyId = insuranceCompanyId;
	}
	public String getAdjusterId() {
		return AdjusterId;
	}
	public void setAdjusterId(String adjusterId) {
		AdjusterId = adjusterId;
	}
	public String getInsuredId() {
		return InsuredId;
	}
	public void setInsuredId(String insuredId) {
		InsuredId = insuredId;
	}
	public String getOtherInsuranceType() {
		return OtherInsuranceType;
	}
	public void setOtherInsuranceType(String otherInsuranceType) {
		OtherInsuranceType = otherInsuranceType;
	}
	private String InsuranceCompanyId=null;
	private String AdjusterId=null;
	private String InsuredId=null;
	private String OtherInsuranceType=null;
	
}

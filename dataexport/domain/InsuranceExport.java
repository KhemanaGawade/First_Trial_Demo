package com.filevine.dataexport.domain;

public class InsuranceExport {
   
	private int projectId=0;
	private String limit=null;
	private String policyId=null;
	private String policyNumber=null;
	private String claimNumber=null;
	private String policyHolder=null;
	private int inseurerId=0;
	private int adjusterId=0;
	private int insuredId=0;
	private int driverVehicleId=0;
	private int thirdPartyInsuranceId=0;
	private String ispipexhausted=null;
	private String pip=null;
	private String notes=null;
	private String pipcoverageamount=null;
	private String umuimcoverageamount=null;
	private String limit_=null;
	private String total_limit=null;
	private String insurance_type=null;
	private String umType=null;
	private String insurance_provider_id=null;
	private String liabilityDecision=null;
	
	
	public String getLiabilityDecision() {
		return this.liabilityDecision;
	}
	public void setLiabilityDecision(String liabilityDecision) {
		this.liabilityDecision = liabilityDecision;
	}
	public String getTotal_limit() {
		return this.total_limit;
	}
	public void setTotal_limit(String total_limit) {
		this.total_limit = total_limit;
	}
	public String getInsurance_type() {
		return this.insurance_type;
	}
	public void setInsurance_type(String insurance_type) {
		this.insurance_type = insurance_type;
	}
	public String getUmType() {
		return this.umType;
	}
	public void setUmType(String umType) {
		this.umType = umType;
	}
	public String getInsurance_provider_id() {
		return this.insurance_provider_id;
	}
	public void setInsurance_provider_id(String insurance_provider_id) {
		this.insurance_provider_id = insurance_provider_id;
	}
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPipcoverageamount() {
		return this.pipcoverageamount;
	}
	public void setPipcoverageamount(String pipcoverageamount) {
		this.pipcoverageamount = pipcoverageamount;
	}
	public String getUmuimcoverageamount() {
		return this.umuimcoverageamount;
	}
	public void setUmuimcoverageamount(String umuimcoverageamount) {
		this.umuimcoverageamount = umuimcoverageamount;
	}
	public String getLimit_() {
		return this.limit_;
	}
	public void setLimit_(String limit_) {
		this.limit_ = limit_;
	}
	public String getIspipexhausted() {
		return this.ispipexhausted;
	}
	public void setIspipexhausted(String ispipexhausted) {
		this.ispipexhausted = ispipexhausted;
	}
	public String getPip() {
		return this.pip;
	}
	public void setPip(String pip) {
		this.pip = pip;
	}
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public String getPolicyId() {
		return this.policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public String getPolicyNumber() {
		return this.policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getClaimNumber() {
		return this.claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getPolicyHolder() {
		return this.policyHolder;
	}
	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}
	public int getInseurerId() {
		return this.inseurerId;
	}
	public void setInseurerId(int inseurerId) {
		this.inseurerId = inseurerId;
	}
	public int getAdjusterId() {
		return this.adjusterId;
	}
	public void setAdjusterId(int adjusterId) {
		this.adjusterId = adjusterId;
	}
	public int getInsuredId() {
		return this.insuredId;
	}
	public void setInsuredId(int insuredId) {
		this.insuredId = insuredId;
	}
	
	public String getLimit() {
		return this.limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public int getDriverVehicleId() {
		return this.driverVehicleId;
	}
	public void setDriverVehicleId(int driverVehicleId) {
		this.driverVehicleId = driverVehicleId;
	}
	public int getThirdPartyInsuranceId() {
		return this.thirdPartyInsuranceId;
	}
	public void setThirdPartyInsuranceId(int thirdPartyInsuranceId) {
		this.thirdPartyInsuranceId = thirdPartyInsuranceId;
	}
	@Override
	public String toString() {
		return "InsuranceExport [projectId=" + projectId + ", limit=" + limit + ", policyId=" + policyId
				+ ", policyNumber=" + policyNumber + ", claimNumber=" + claimNumber + ", policyHolder=" + policyHolder
				+ ", inseurerId=" + inseurerId + ", adjusterId=" + adjusterId + ", insuredId=" + insuredId
				+ ", driverVehicleId=" + driverVehicleId + ", thirdPartyInsuranceId=" + thirdPartyInsuranceId
				+ ", ispipexhausted=" + ispipexhausted + ", pip=" + pip + ", notes=" + notes + ", pipcoverageamount="
				+ pipcoverageamount + ", umuimcoverageamount=" + umuimcoverageamount + ", limit_=" + limit_
				+ ", total_limit=" + total_limit + ", insurance_type=" + insurance_type + ", umType=" + umType
				+ ", insurance_provider_id=" + insurance_provider_id + ", liabilityDecision=" + liabilityDecision + "]";
	}
	
	
}

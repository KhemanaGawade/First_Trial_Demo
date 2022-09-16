package com.filevine.dataexport.domain;

public class FileVineSettlementExport {

	private int projectId=0;
	private String id=null;
	private String name=null;
	private String offer=null;
	private String attorneyPerc=null;
	private String attorneyAmt=null;
	private String medicalBillAmt=null;
	private String expenseAmt=null;
	private String netToClient=null;
	private String createDate=null;
	private String creatorId=null;
	private String creatorName=null;
	private String notes=null;
	private boolean hasCustomMeds=false;
	private boolean hasCustomExpense=false;
	//lineexport
	private String lineId=null;
	private String lineName=null;
	private String amount=null;
	private String netAmount=null;
	private String itemType=null;
	private String adjustmentAmt=null;
	private String reductionPercentage=null;
	private boolean isReductionPercentageLocked=false;
	private boolean isExcluded=false;
	private String lineNotes=null;
	
	@Override
	public String toString() {
		return "FileVineSettlementExport [projectId=" + projectId + ", id=" + id + ", name=" + name + ", offer=" + offer
				+ ", attorneyPerc=" + attorneyPerc + ", attorneyAmt=" + attorneyAmt + ", medicalBillAmt="
				+ medicalBillAmt + ", expenseAmt=" + expenseAmt + ", netToClient=" + netToClient + ", createDate="
				+ createDate + ", creatorId=" + creatorId + ", creatorName=" + creatorName + ", notes=" + notes
				+ ", hasCustomMeds=" + hasCustomMeds + ", hasCustomExpense=" + hasCustomExpense + ", lineId=" + lineId
				+ ", lineName=" + lineName + ", amount=" + amount + ", netAmount=" + netAmount + ", itemType="
				+ itemType + ", adjustmentAmt=" + adjustmentAmt + ", reductionPercentage=" + reductionPercentage
				+ ", isReductionPercentageLocked=" + isReductionPercentageLocked + ", isExcluded=" + isExcluded
				+ ", lineNotes=" + lineNotes + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getAttorneyPerc() {
		return attorneyPerc;
	}
	public void setAttorneyPerc(String attorneyPerc) {
		this.attorneyPerc = attorneyPerc;
	}
	public String getAttorneyAmt() {
		return attorneyAmt;
	}
	public void setAttorneyAmt(String attorneyAmt) {
		this.attorneyAmt = attorneyAmt;
	}
	public String getMedicalBillAmt() {
		return medicalBillAmt;
	}
	public void setMedicalBillAmt(String medicalBillAmt) {
		this.medicalBillAmt = medicalBillAmt;
	}
	public String getExpenseAmt() {
		return expenseAmt;
	}
	public void setExpenseAmt(String expenseAmt) {
		this.expenseAmt = expenseAmt;
	}
	public String getNetToClient() {
		return netToClient;
	}
	public void setNetToClient(String netToClient) {
		this.netToClient = netToClient;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isHasCustomMeds() {
		return hasCustomMeds;
	}
	public void setHasCustomMeds(boolean hasCustomMeds) {
		this.hasCustomMeds = hasCustomMeds;
	}
	public boolean isHasCustomExpense() {
		return hasCustomExpense;
	}
	public void setHasCustomExpense(boolean hasCustomExpense) {
		this.hasCustomExpense = hasCustomExpense;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getAdjustmentAmt() {
		return adjustmentAmt;
	}
	public void setAdjustmentAmt(String adjustmentAmt) {
		this.adjustmentAmt = adjustmentAmt;
	}
	public String getReductionPercentage() {
		return reductionPercentage;
	}
	public void setReductionPercentage(String reductionPercentage) {
		this.reductionPercentage = reductionPercentage;
	}
	public boolean isReductionPercentageLocked() {
		return isReductionPercentageLocked;
	}
	public void setReductionPercentageLocked(boolean isReductionPercentageLocked) {
		this.isReductionPercentageLocked = isReductionPercentageLocked;
	}
	public boolean isExcluded() {
		return isExcluded;
	}
	public void setExcluded(boolean isExcluded) {
		this.isExcluded = isExcluded;
	}
	public String getLineNotes() {
		return lineNotes;
	}
	public void setLineNotes(String lineNotes) {
		this.lineNotes = lineNotes;
	}
	
	
	
	
	
	
	
	
	
	
	
}

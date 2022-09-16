package com.filevine.dataexport.domain;

/**
 * This class is having all required fields of clinet intake tab for each casee which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class ClientIntakeExport {
	
	private String projectId=null;
	private String clienthasanumber=null;
	private String clienthasstateidnumber=null;
	private String anumber=null;
	private String stateidnumber=null;
	private String language_=null;
	private String currenttitle=null;
	private String currentemployer=null;
	private String referralsource=null;
	private String dateofintake=null;
	private String createdDate=null;
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getClienthasanumber() {
		return this.clienthasanumber;
	}
	public void setClienthasanumber(String clienthasanumber) {
		this.clienthasanumber = clienthasanumber;
	}
	public String getClienthasstateidnumber() {
		return this.clienthasstateidnumber;
	}
	public void setClienthasstateidnumber(String clienthasstateidnumber) {
		this.clienthasstateidnumber = clienthasstateidnumber;
	}
	public String getAnumber() {
		return this.anumber;
	}
	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}
	public String getStateidnumber() {
		return this.stateidnumber;
	}
	public void setStateidnumber(String stateidnumber) {
		this.stateidnumber = stateidnumber;
	}
	public String getLanguage_() {
		return this.language_;
	}
	public void setLanguage_(String language_) {
		this.language_ = language_;
	}
	public String getCurrenttitle() {
		return this.currenttitle;
	}
	public void setCurrenttitle(String currenttitle) {
		this.currenttitle = currenttitle;
	}
	public String getCurrentemployer() {
		return this.currentemployer;
	}
	public void setCurrentemployer(String currentemployer) {
		this.currentemployer = currentemployer;
	}
	public String getReferralsource() {
		return this.referralsource;
	}
	public void setReferralsource(String referralsource) {
		this.referralsource = referralsource;
	}
	public String getDateofintake() {
		return this.dateofintake;
	}
	public void setDateofintake(String dateofintake) {
		this.dateofintake = dateofintake;
	}
	public String getCreatedDate() {
		return this.createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "ClientIntakeExport [projectId=" + projectId + ", clienthasanumber=" + clienthasanumber
				+ ", clienthasstateidnumber=" + clienthasstateidnumber + ", anumber=" + anumber + ", stateidnumber="
				+ stateidnumber + ", language_=" + language_ + ", currenttitle=" + currenttitle + ", currentemployer="
				+ currentemployer + ", referralsource=" + referralsource + ", dateofintake=" + dateofintake
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	

}

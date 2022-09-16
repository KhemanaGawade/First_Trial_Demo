package com.filevine.dataexport.domain;


public class LegalResearchDataExport {

	
	private int ProjectId=0;
	private String ResearchType=null;
	private String ResearchDate=null;
	private String Notes=null;
	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public String getResearchType() {
		return ResearchType;
	}
	public void setResearchType(String researchType) {
		ResearchType = researchType;
	}
	public String getResearchDate() {
		return ResearchDate;
	}
	public void setResearchDate(String researchDate) {
		ResearchDate = researchDate;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	@Override
	public String toString() {
		return "LegalResearchDataExport [ProjectId=" + ProjectId + ", ResearchType=" + ResearchType + ", ResearchDate="
				+ ResearchDate + ", Notes=" + Notes + ", getProjectId()=" + getProjectId() + ", getResearchType()="
				+ getResearchType() + ", getResearchDate()=" + getResearchDate() + ", getNotes()=" + getNotes()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}

package com.filevine.dataexport.domain;

public class ChildernDataExport {

	private String projectId=null;
	private String FullLegalName=null;
	private String ChildsDateOfBirth=null;
	private String ChildrenId=null;
	private String CreatedDate=null;
	private String GeneralNotes=null;
	@Override
	public String toString() {
		return "ChildernDataExport [projectId=" + projectId + ", FullLegalName=" + FullLegalName
				+ ", ChildsDateOfBirth=" + ChildsDateOfBirth + ", ChildrenId=" + ChildrenId + ", CreatedDate="
				+ CreatedDate + ", GeneralNotes=" + GeneralNotes + "]";
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getFullLegalName() {
		return FullLegalName;
	}
	public void setFullLegalName(String fullLegalName) {
		FullLegalName = fullLegalName;
	}
	public String getChildsDateOfBirth() {
		return ChildsDateOfBirth;
	}
	public void setChildsDateOfBirth(String childsDateOfBirth) {
		ChildsDateOfBirth = childsDateOfBirth;
	}
	public String getChildrenId() {
		return ChildrenId;
	}
	public void setChildrenId(String childrenId) {
		ChildrenId = childrenId;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public String getGeneralNotes() {
		return GeneralNotes;
	}
	public void setGeneralNotes(String generalNotes) {
		GeneralNotes = generalNotes;
	}
}

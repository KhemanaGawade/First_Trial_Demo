package com.filevine.dataexport.domain;

public class CaseDetailsDataExport {

	private int projectId=0;
	@Override
	public String toString() {
		return "CaseDetailsDataExport [projectId=" + projectId + ", FieldName=" + FieldName + ", FriendlyName="
				+ FriendlyName + ", FieldType=" + FieldType + ", FieldValue=" + FieldValue + ", LinkRefValue="
				+ LinkRefValue + ", Position=" + Position + ", SectionLink=" + SectionLink + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getFriendlyName() {
		return FriendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		FriendlyName = friendlyName;
	}
	public String getFieldType() {
		return FieldType;
	}
	public void setFieldType(String fieldType) {
		FieldType = fieldType;
	}
	public String getFieldValue() {
		return FieldValue;
	}
	public void setFieldValue(String fieldValue) {
		FieldValue = fieldValue;
	}
	public String getLinkRefValue() {
		return LinkRefValue;
	}
	public void setLinkRefValue(String linkRefValue) {
		LinkRefValue = linkRefValue;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getSectionLink() {
		return SectionLink;
	}
	public void setSectionLink(String sectionLink) {
		SectionLink = sectionLink;
	}
	private String FieldName=null;
	private String FriendlyName=null;
	private String FieldType=null;
	private String FieldValue=null;
	private String LinkRefValue=null;
	private String Position=null;
	private String SectionLink=null;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

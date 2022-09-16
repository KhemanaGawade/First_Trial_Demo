package com.filevine.dataexport.domain;

public class ProjectIDInsert {
	private String ProjectName;
	private String ProjectID;
	
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	@Override
	public String toString() {
		return "ProjectIDInsert [ProjectName=" + ProjectName + ", ProjectID=" + ProjectID + "]";
	}

}

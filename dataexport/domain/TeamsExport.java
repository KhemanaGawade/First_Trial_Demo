package com.filevine.dataexport.domain;

public class TeamsExport {
	
	int projectId=0;
	int teamId=0;
	String teamEmail=null;
	String teamFullName=null;
	String teamUserName=null;
	String teamIsFirstPrimary=null;
	String teamIsPrimary=null;
	String isAdmin=null;
	String teamType=null; // support for collaborators & main for Followers
	int tagRoleId=0;
	String tagRoleName=null;
	
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getTeamId() {
		return this.teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamEmail() {
		return this.teamEmail;
	}
	public void setTeamEmail(String teamEmail) {
		this.teamEmail = teamEmail;
	}
	public String getTeamFullName() {
		return this.teamFullName;
	}
	public void setTeamFullName(String teamFullName) {
		this.teamFullName = teamFullName;
	}
	public String getTeamUserName() {
		return this.teamUserName;
	}
	public void setTeamUserName(String teamUserName) {
		this.teamUserName = teamUserName;
	}
	public String getTeamIsFirstPrimary() {
		return this.teamIsFirstPrimary;
	}
	public void setTeamIsFirstPrimary(String teamIsFirstPrimary) {
		this.teamIsFirstPrimary = teamIsFirstPrimary;
	}
	public String getTeamIsPrimary() {
		return this.teamIsPrimary;
	}
	public void setTeamIsPrimary(String teamIsPrimary) {
		this.teamIsPrimary = teamIsPrimary;
	}
	public String getIsAdmin() {
		return this.isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getTeamType() {
		return this.teamType;
	}
	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}
	public int getTagRoleId() {
		return this.tagRoleId;
	}
	public void setTagRoleId(int tagRoleId) {
		this.tagRoleId = tagRoleId;
	}
	public String getTagRoleName() {
		return this.tagRoleName;
	}
	public void setTagRoleName(String tagRoleName) {
		this.tagRoleName = tagRoleName;
	}
	@Override
	public String toString() {
		return "TeamsExport [projectId=" + projectId + ", teamId=" + teamId + ", teamEmail=" + teamEmail
				+ ", teamFullName=" + teamFullName + ", teamUserName=" + teamUserName + ", teamIsFirstPrimary="
				+ teamIsFirstPrimary + ", teamIsPrimary=" + teamIsPrimary + ", isAdmin=" + isAdmin + ", teamType="
				+ teamType + ", tagRoleId=" + tagRoleId + ", tagRoleName=" + tagRoleName + "]";
	}
	
	

}

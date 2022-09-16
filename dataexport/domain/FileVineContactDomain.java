package com.filevine.dataexport.domain;

public class FileVineContactDomain {

	private String projectId=null;
	private String Id=null;
	private String Role=null;
	private String PersonID=null;
	private String PersonRole=null;
	private String PersonTitle=null;
	private String RoleUniqueId=null;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getPersonID() {
		return PersonID;
	}
	public void setPersonID(String personID) {
		PersonID = personID;
	}
	public String getPersonRole() {
		return PersonRole;
	}
	public void setPersonRole(String personRole) {
		PersonRole = personRole;
	}
	public String getPersonTitle() {
		return PersonTitle;
	}
	public void setPersonTitle(String personTitle) {
		PersonTitle = personTitle;
	}
	public String getRoleUniqueId() {
		return RoleUniqueId;
	}
	public void setRoleUniqueId(String roleUniqueId) {
		RoleUniqueId = roleUniqueId;
	}
	@Override
	public String toString() {
		return "FileVineContactDomain [projectId=" + projectId + ", Id=" + Id + ", Role=" + Role + ", PersonID="
				+ PersonID + ", PersonRole=" + PersonRole + ", PersonTitle=" + PersonTitle + ", RoleUniqueId="
				+ RoleUniqueId + "]";
	}
	
	
	
}

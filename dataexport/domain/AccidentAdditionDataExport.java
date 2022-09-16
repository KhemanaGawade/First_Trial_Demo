package com.filevine.dataexport.domain;

public class AccidentAdditionDataExport {

	private int projectId=0;
	private String PassengerNo1Id=null;
	private String PassengerNo2Id=null;
	private String PassengerNo3Id=null;
	private String PassengerNo4Id=null;
	@Override
	public String toString() {
		return "AccidentAdditionDataExport [projectId=" + projectId + ", PassengerNo1Id=" + PassengerNo1Id
				+ ", PassengerNo2Id=" + PassengerNo2Id + ", PassengerNo3Id=" + PassengerNo3Id + ", PassengerNo4Id="
				+ PassengerNo4Id + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getPassengerNo1Id() {
		return PassengerNo1Id;
	}
	public void setPassengerNo1Id(String passengerNo1Id) {
		PassengerNo1Id = passengerNo1Id;
	}
	public String getPassengerNo2Id() {
		return PassengerNo2Id;
	}
	public void setPassengerNo2Id(String passengerNo2Id) {
		PassengerNo2Id = passengerNo2Id;
	}
	public String getPassengerNo3Id() {
		return PassengerNo3Id;
	}
	public void setPassengerNo3Id(String passengerNo3Id) {
		PassengerNo3Id = passengerNo3Id;
	}
	public String getPassengerNo4Id() {
		return PassengerNo4Id;
	}
	public void setPassengerNo4Id(String passengerNo4Id) {
		PassengerNo4Id = passengerNo4Id;
	}
	
	
	
	
	
	
	
	
	
	
}

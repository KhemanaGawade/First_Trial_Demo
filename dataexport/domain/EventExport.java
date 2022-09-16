package com.filevine.dataexport.domain;

public class EventExport {
	private int OwnerID = 0;
	private String OwnerName = null;
	private String EventID = null;
	
	private String Title = null;
	private Boolean AllDay = null;
	private String Start = null;
	private String End= null;
	private String Location = null;
	private String Notes = null;
	private String CalendarEventType= null;
	private int ProjectID= 0;
	private String Project= null;
	private int CreatorID= 0;
//	private String Creator= null;
	public int getOwnerID() {
		return OwnerID;
	}
	public void setOwnerID(int ownerID) {
		OwnerID = ownerID;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Boolean getAllDay() {
		return AllDay;
	}
	public void setAllDay(Boolean allDay) {
		AllDay = allDay;
	}
	public String getStart() {
		return Start;
	}
	public void setStart(String start) {
		Start = start;
	}
	public String getEnd() {
		return End;
	}
	public void setEnd(String end) {
		End = end;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getCalendarEventType() {
		return CalendarEventType;
	}
	public void setCalendarEventType(String calendarEventType) {
		CalendarEventType = calendarEventType;
	}
	public int getProjectID() {
		return ProjectID;
	}
	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}
	public String getProject() {
		return Project;
	}
	public void setProject(String project) {
		Project = project;
	}
	public int getCreatorID() {
		return CreatorID;
	}
	public void setCreatorID(int creatorID) {
		CreatorID = creatorID;
	}
	@Override
	public String toString() {
		return "EventExport [OwnerID=" + OwnerID + ", OwnerName=" + OwnerName + ", EventID=" + EventID + ", Title="
				+ Title + ", AllDay=" + AllDay + ", Start=" + Start + ", End=" + End + ", Location=" + Location
				+ ", Notes=" + Notes + ", CalendarEventType=" + CalendarEventType + ", ProjectID=" + ProjectID
				+ ", Project=" + Project + ", CreatorID=" + CreatorID + "]";
	}
	
	
	
	
	
	
}

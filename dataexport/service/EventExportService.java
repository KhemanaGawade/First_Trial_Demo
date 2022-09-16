package com.filevine.dataexport.service;



import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.EventExportDAO;
import com.filevine.dataexport.domain.EventExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class EventExportService {
	
	public String   getEventResponse(String Date,String cookie)
	{
	
	//	String cookie ="_ga=GA1.2.1760468707.1552547687; hubspotutk=a1f6677b4a0114f71f8584489f338590; __zlcmid=rJi5LYDjQbvhBs; _ga=GA1.3.1760468707.1552547687; __hstc=121834644.a1f6677b4a0114f71f8584489f338590.1552547690480.1553919906683.1553974877902.6; _gcl_au=1.1.173660776.1563259789; _gid=GA1.2.825550399.1563259797; __RequestVerificationToken=R1aKRRWzs6bOgJV1WFXZHAQNAJCF4h5yLaSGFzuhPncGBsKafE6sORXGu3VQUgbgaX-BkmtbXgHOnN7odle9SMQQsqN15LqiwaFWhj36CwE1; .AspNet.ApplicationCookie=qFSf0S5cxuaubQxOzbsTiwIZej0b2AUHJRJFjy6lTK3OfRg06SzGjjyeY2_TXu04Rty1PVw2tV7MUkFmg28MaGhRFInOrUT7URTZb_O-yl9zwSRdzZbvr6GopTvmjcsFNmwHpqRwtarq9NGne9TCiwMHDxfvS6aWrChpGLlVVmBEo_Yt_oQwi8PV976zL3y2mO7nr6UBqTOzB3r2mIAVZJjb31OjYbSR4mKykIo_YHBuzP6xQVpWHXbMvDuy8rQ5tNOTN3vE5T6slTvoRo-n3-YRshYrjzOzyaVUg615yp72f6oBpFIwNe9OXvSQWcu1Tne_bA7NigDqIAaNFO126YOt96wlctdZ7m2-SDmD0F7U0NPcck3nnW16m0G0Fu-JN7kapAGnctiIDWzHSCY6lAu6aUyBdysOEQHz8PstwyUdHP11CcbaNM9xAM7nYKuhxYjVjZib_7Ai3IFeJYxEMeXtIabOFdP8Qtr7PVPrvb4bZAiX5AqhTQCsHbP-JbTb; _gid=GA1.3.825550399.1563259797; _gat=1 " ; 
		
		
		
		String response=null;
	//	String url="https://app.filevine.com/api/calendar/projects/10071996/?start=2022-06-26&end=2022-08-07&take=null&skip=NaN";
		String url="https://app.filevine.com/api/calendar/displayableevents/"+Date+"/?timezoneOffset=-330";
		
		try {
			WebResource webResource=Client.create().resource(url);
			response=webResource.header("Cookie", cookie).get(String.class);
			
			System.out.println(response);
			
			
			
			}
			
		catch(Exception e) {
			System.out.println("Fail to get repsonse from UI");
			e.printStackTrace();
		}
		return response;
     }
	public void getEventData(String database ,String res) throws Exception
	{
		EventExport eventexport = new EventExport();
		EventExportDAO eventexportdao = new EventExportDAO();
		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		JSONArray arr = jobj.getJSONArray("data");
		for(int k = 0; k<arr.length();k++)
		{
             JSONObject jsonObj= arr.getJSONObject(k);	
			
			if(!jsonObj.opt("ownerID").equals(null)){
				eventexport.setOwnerID(jsonObj.getInt("ownerID"));
			}
			if(!jsonObj.opt("ownerName").equals(null)){
				eventexport.setOwnerName(jsonObj.getString("ownerName"));
			}
		
		
		   JSONArray array = jsonObj.getJSONArray("events");
		   for(int p = 0; p < array.length() ;p++)
		   {
		
             JSONObject jsonObj2= array.getJSONObject(p);	
			
			if(!jsonObj2.opt("id").equals(null)){
				eventexport.setEventID(jsonObj2.getString("id"));
			}
			if(!jsonObj2.opt("title").equals(null)){
				eventexport.setTitle(jsonObj2.getString("title"));
			}
			if(!jsonObj2.opt("allDay").equals(null)){
				eventexport.setAllDay(jsonObj2.getBoolean("allDay"));
			}
			if(!jsonObj2.opt("start").equals(null)){
				eventexport.setStart(jsonObj2.getString("start"));
			}
			if(!jsonObj2.opt("end").equals(null)){
				eventexport.setEnd(jsonObj2.getString("end"));
			}
			if(!jsonObj2.opt("location").equals(null)){
				eventexport.setLocation(jsonObj2.getString("location"));
			}
			if(!jsonObj2.opt("notes").equals(null)){
				eventexport.setNotes(jsonObj2.getString("notes"));
			}
			if(!jsonObj2.opt("calendarEventType").equals(null)){
				eventexport.setCalendarEventType(jsonObj2.getString("calendarEventType"));
			}
			if(!jsonObj2.opt("projectID").equals(null)){
				eventexport.setProjectID(jsonObj2.getInt("projectID"));
			}
				
			if(!jsonObj2.opt("creatorID").equals(null)){
				eventexport.setCreatorID(jsonObj2.getInt("creatorID"));
			}
				
			eventexportdao.insertEventData(database, eventexport);
		 }
		}
		
		
		
		
		
	}
	
}



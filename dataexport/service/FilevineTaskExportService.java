package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.EventExportDAO;
import com.filevine.dataexport.dao.TaskExportDao;
import com.filevine.dataexport.domain.EventExport;
import com.filevine.dataexport.domain.TaskExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FilevineTaskExportService {

	public String getTaskResponse(String cookie,int j) {
	String response=null;
		
		String url="https://app.filevine.com/api/notes/tasks?offset="+j;
		String payLoad="{\"filterByType\":0,\"filterIncompleteOnlySet\":false,\"filterCompleteOnlySet\":false,\"filterAssignedToMeSet\":false,\"filterCompletedByMeSet\":false,\"filterCreatedByMeSet\":false,\"filterUtcCreateDateRangeStart\":null,\"filterUtcCreateDateRangeEnd\":null,\"filterRawTaskTargetDateRangeStart\":null,\"filterRawTaskTargetDateRangeEnd\":\"03/20/2020\",\"filterPinnedOnly\":false,\"filterUnpinnedOnly\":false,\"filterHashtagsList\":[],\"noteId\":null}";
		
		try {
			WebResource webResource=Client.create().resource(url);
//			response=webResource.header("Cookie", cookie).post(String.class);
			
			response=webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
			
			
			System.out.println(response);
		}
			
		catch(Exception e) {
			System.out.println("Fail to get repsonse from UI");
			e.printStackTrace();
		}
		return response;
	}

	public void getTaskData(String res, String database) throws JSONException, SQLException {
		
		TaskExport taskExport = new TaskExport();
		TaskExportDao taslExportdao = new TaskExportDao();
		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		JSONObject obj = jobj.getJSONObject("data");
		JSONArray arr=obj.getJSONArray("notes");
		for(int k = 0; k<arr.length();k++)
		{
             JSONObject jsonObj= arr.getJSONObject(k);	
             if(!jsonObj.opt("id").equals(null)){
            	 taskExport.setTaskId(jsonObj.getInt("id"));
 			 }
             JSONObject jsonProject=jsonObj.getJSONObject("project");
             if(!jsonProject.opt("id").equals(null)){
            	 taskExport.setProjectId(jsonProject.getInt("id"));
 			 }
             if(!jsonProject.opt("projectName").equals(null)){
            	 taskExport.setProjectName(jsonProject.getString("projectName"));
 			 }
             if(!jsonProject.opt("clientName").equals(null)){
            	 taskExport.setClientName(jsonProject.getString("clientName"));
 			 }
             if(!jsonObj.opt("typeTag").equals(null)){
            	 taskExport.setTypeTag(jsonObj.getString("typeTag"));
 			 }
             if(!jsonObj.opt("targetDate").equals(null)){
            	 taskExport.setTargetDate(jsonObj.getString("targetDate"));
 			 }
             if(!jsonObj.opt("isUnread").equals(null)){
            	 taskExport.setIsUnread(jsonObj.getString("isUnread"));
 			 }
             if(!jsonObj.opt("isCompleted").equals(null)){
            	 taskExport.setIsCompleted(jsonObj.getString("isCompleted"));
 			 }
             if(!jsonObj.opt("completedDate").equals(null)){
            	 taskExport.setCompletedDate(jsonObj.getString("completedDate"));
 			 }
             if(!jsonObj.opt("body").equals(null)){
            	 taskExport.setBody(jsonObj.getString("body"));
 			 }
             if(!jsonObj.opt("createdAt").equals(null)){
            	 taskExport.setCreatedAt(jsonObj.getString("createdAt"));
 			 }
             if(!jsonObj.opt("destination").equals(null)){
            	 taskExport.setDestination(jsonObj.getString("destination"));
 			 }
             if(!jsonObj.opt("source").equals(null)){
            	 taskExport.setSource(jsonObj.getString("source"));
 			 }
             if(!jsonObj.opt("isEdited").equals(null)){
            	 taskExport.setIsEdited(jsonObj.getString("isEdited"));
 			 }
             if(!jsonObj.opt("lastActivity").equals(null)){
            	 taskExport.setLastActivity(jsonObj.getString("lastActivity"));
 			 }
             JSONObject objectAuthor=jsonObj.getJSONObject("author");
             if(!objectAuthor.opt("fullname").equals(null)){
            	 taskExport.setAuthorFullName(objectAuthor.getString("fullname"));
 			 }
             if(!objectAuthor.opt("type").equals(null)){
            	 taskExport.setAuthorType(objectAuthor.getString("type"));
 			 }
             if(!objectAuthor.opt("email").equals(null)){
            	 taskExport.setAuthorEmail(objectAuthor.getString("email"));
 			 }
             if(!jsonObj.opt("assignee").equals(null)){
            	 taskExport.setAssignee(jsonObj.getString("assignee"));
 			 }
             if(!jsonObj.opt("comments").equals(null)){
            	 taskExport.setComments(jsonObj.getString("comments"));
 			 }
             taslExportdao.insertTaskData(database,taskExport);
		}
		
	}

	public String getTaskResponseForCount(String cookie) {
String response=null;
		
		String url="https://app.filevine.com/api/notes/tasks?offset=0";
		String payLoad="{\"filterByType\":0,\"filterIncompleteOnlySet\":false,\"filterCompleteOnlySet\":false,\"filterAssignedToMeSet\":false,\"filterCompletedByMeSet\":false,\"filterCreatedByMeSet\":false,\"filterUtcCreateDateRangeStart\":null,\"filterUtcCreateDateRangeEnd\":null,\"filterRawTaskTargetDateRangeStart\":null,\"filterRawTaskTargetDateRangeEnd\":\"03/20/2020\",\"filterPinnedOnly\":false,\"filterUnpinnedOnly\":false,\"filterHashtagsList\":[],\"noteId\":null}";
		
		try {
			WebResource webResource=Client.create().resource(url);
//			response=webResource.header("Cookie", cookie).post(String.class);
			
			response=webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
			
			
			System.out.println(response);
		}
			
		catch(Exception e) {
			System.out.println("Fail to get repsonse from UI");
			e.printStackTrace();
		}
		return response;
	}

}

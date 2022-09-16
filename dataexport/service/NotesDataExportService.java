package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.NotesDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.NotesDataExport;
import com.filevine.dataexport.domain.NotesExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class NotesDataExportService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/notes?offset=0";
		
		String payload="{\"filterByType\":0,\"filterIncompleteOnlySet\":false,\"filterCompleteOnlySet\":false,\"filterAssignedToMeSet\":false,\"filterCompletedByMeSet\":false,\"filterCreatedByMeSet\":false,\"filterUtcCreateDateRangeStart\":null,\"filterUtcCreateDateRangeEnd\":null,\"filterRawTaskTargetDateRangeStart\":null,\"filterRawTaskTargetDateRangeEnd\":null,\"filterPinnedOnly\":false,\"filterUnpinnedOnly\":false,\"filterHashtagsList\":[],\"filterTagsList\":[],\"noteId\":null}";
		
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payload);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;

		}
	
//	public  int getNotesCount(String response, String databaseName) throws Exception{
//		
//		int notesCount=0;
//		String 	res=response;
//		int i=res.indexOf('{');
//		res=res.substring(i);
//
//		JSONObject jsonObj=new JSONObject(res);
//		JSONObject data=jsonObj.getJSONObject("data");
//		JSONArray notes=data.getJSONArray("notes");
//		notesCount=notes.length();
//		System.out.println("notes count : " +notes.length());
//		
//		return notesCount;
//			
//		
//	}
	
	public void getAdvanceClientCostData(String response, String databaseName) throws JSONException, SQLException {
		
		NotesDataExport notesdataexport=null ;
		NotesDataExportDao notesdataexportdao=new NotesDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject data=new JSONObject(res);
		JSONArray notes=data.getJSONArray("notes");
	
		try {
			for(int j=0; j<=notes.length()-1; j++) {
				notesdataexport=new NotesDataExport();
				JSONObject jsonObject=notes.getJSONObject(j);	
				
				if(!jsonObject.opt("id").equals(null)){
					notesdataexport.setId(jsonObject.getInt("id"));
				}
				if(!jsonObject.opt("projectID").equals(null)){
					notesdataexport.setProjectId(jsonObject.getInt("projectID"));
				}
				if(!jsonObject.opt("targetDate").equals(null)) {
					notesdataexport.setTargetDate(jsonObject.getString("targetDate"));
				}
				if(!jsonObject.opt("body").equals(null)) {
					notesdataexport.setBody(jsonObject.getString("body"));
				}
				if(!jsonObject.opt("createdAt").equals(null)) {
					notesdataexport.setCreatedAt(jsonObject.getString("createdAt"));
				}
				
				if(!jsonObject.opt("typeTag").equals(null)) {
					notesdataexport.setTypeTag(jsonObject.getString("typeTag"));
				}
				if(!jsonObject.opt("lastActivity").equals(null)) {
					notesdataexport.setLastActivity(jsonObject.getString("lastActivity"));
				}
				if(!jsonObject.opt("assignee").equals(null)) {
					notesdataexport.setAssignee(jsonObject.getString("assignee"));
				}
				
				JSONObject jsonUser=jsonObject.getJSONObject("author");
				if(!jsonUser.opt("id").equals(null)) {
					notesdataexport.setUserId(jsonUser.getInt("id"));
				}
				if(!jsonUser.opt("fullname").equals(null)) {
					notesdataexport.setUserName(jsonUser.getString("fullname"));
				}
				
				
				if(jsonObject.isNull("assignee")) {
					notesdataexport.setAssigneeId(0);
					notesdataexport.setAssigneeName("");
					notesdataexport.setAssigneeUser("");
				}else {
					JSONObject jsonAssignee=jsonObject.getJSONObject("assignee");
					if(!jsonAssignee.opt("id").equals(null)) {
						notesdataexport.setAssigneeId(jsonAssignee.getInt("id"));
					}
					if(!jsonAssignee.opt("fullname").equals(null)) {
						notesdataexport.setAssigneeName(jsonAssignee.getString("fullname"));
					}
					if(!jsonAssignee.opt("type").equals(null)) {
						notesdataexport.setAssigneeUser(jsonAssignee.getString("type"));
					}
				}
				
				if(notesdataexport.getTypeTag().equals("note")) {
					notesdataexportdao.insertDataNotes(databaseName, notesdataexport);
				}else
					if(notesdataexport.getTypeTag().equals("task")) {
						notesdataexportdao.insertActivityTaskData(databaseName,notesdataexport);
				}
					else{
						notesdataexportdao.insertActivitySmsData(databaseName,notesdataexport);
				}
				
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
	
	
}

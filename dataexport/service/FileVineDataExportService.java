package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.FileVineDataExportDao;

import com.filevine.dataexport.domain.FileVineDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FileVineDataExportService {

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
	
	
	public void getAdvanceClientCostData(String response, String databaseName) throws JSONException, SQLException {
		
		FileVineDataExport filevinedataexport=new FileVineDataExport();
		FileVineDataExportDao filevinedataexportdao=new FileVineDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject filevinedata=new JSONObject(res);
		JSONObject notesdata=filevinedata.getJSONObject("data");
		
		if(notesdata.isNull("totalCount")) {
			filevinedataexport.setTotalCount( null);
		}else {
			
	    if(!notesdata.opt("totalCount").equals(null)){
	    	filevinedataexport.setTotalCount( notesdata.getString("totalCount"));
	    }}

	
		if(!notesdata.opt("notes").equals(null)) {
			JSONArray communication=notesdata.getJSONArray("notes");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
		
				if(jsonObject.isNull("id")) {
					filevinedataexport.setId( null);
				}else {
					
			    if(!jsonObject.opt("id").equals(null)){
			    	filevinedataexport.setId( jsonObject.getString("id"));
			    }}
	
				if(jsonObject.isNull("projectID")) {
					filevinedataexport.setProjectId( null);
				}else {
					
			    if(!jsonObject.opt("projectID").equals(null)){
			    	filevinedataexport.setProjectId( jsonObject.getString("projectID"));
			    }}
				
				if(jsonObject.isNull("typeTag")) {
					filevinedataexport.setTypeTag( null);
				}else {
					
			    if(!jsonObject.opt("typeTag").equals(null)){
			    	filevinedataexport.setTypeTag( jsonObject.getString("typeTag"));
			    }}
				
				
				if(jsonObject.isNull("targetDate")) {
					filevinedataexport.setTargetDate( null);
				}else {
					
			    if(!jsonObject.opt("targetDate").equals(null)){
			    	filevinedataexport.setTargetDate( jsonObject.getString("targetDate"));
			    }}
				
				if(jsonObject.isNull("completedDate")) {
					filevinedataexport.setCompletedDate( null);
				}else {
					
			    if(!jsonObject.opt("completedDate").equals(null)){
			    	filevinedataexport.setCompletedDate( jsonObject.getString("completedDate"));
			    }}
				
				if(jsonObject.isNull("body")) {
					filevinedataexport.setBody( null);
				}else {
					
			    if(!jsonObject.opt("body").equals(null)){
			    	filevinedataexport.setBody( jsonObject.getString("body"));
			    }}
				
				if(jsonObject.isNull("createdAt")) {
					filevinedataexport.setCreatedAt( null);
				}else {
					
			    if(!jsonObject.opt("createdAt").equals(null)){
			    	filevinedataexport.setCreatedAt( jsonObject.getString("createdAt"));
			    }}
				
				if(jsonObject.isNull("lastActivity")) {
					filevinedataexport.setLastActivity( null);
				}else {
					
			    if(!jsonObject.opt("lastActivity").equals(null)){
			    	filevinedataexport.setLastActivity( jsonObject.getString("lastActivity"));
			    }}
				
				if(jsonObject.isNull("assignee")) {
					filevinedataexport.setAssignee( null);
				}else {
					
			    if(!jsonObject.opt("assignee").equals(null)){
			    	filevinedataexport.setAssignee( jsonObject.getString("assignee"));
			    }}
				
				JSONObject jsonUser=jsonObject.getJSONObject("author");
				
				
				if(jsonUser.isNull("fullname")) {
					filevinedataexport.setAuthorFullName( null);
				}else {
					
			    if(!jsonUser.opt("fullname").equals(null)){
			    	filevinedataexport.setAuthorFullName(jsonUser.getString("fullname"));
			    }}
				
				if(jsonUser.isNull("username")) {
					filevinedataexport.setUserName( null);
				}else {
					
			    if(!jsonUser.opt("username").equals(null)){
			    	filevinedataexport.setUserName( jsonUser.getString("username"));
			    }}
				
				if(jsonUser.isNull("id")) {
					filevinedataexport.setUserNameId( null);
				}else {
					
			    if(!jsonObject.opt("id").equals(null)){
			    	filevinedataexport.setUserNameId( jsonUser.getString("id"));
			    }}
				
				if(filevinedataexport.getTypeTag().equals("note")) {
					filevinedataexportdao.insertFileVineDataData(databaseName, filevinedataexport);
				}else
					if(filevinedataexport.getTypeTag().equals("task")) {
						filevinedataexportdao.insertActivityTaskData(databaseName,filevinedataexport);
				}
					else{
						filevinedataexportdao.insertActivitySmsData(databaseName,filevinedataexport);
				}
				
				
				
				
				
				
				
				
	
			//	filevinedataexportdao.insertFileVineDataData(databaseName,filevinedataexport);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			}
		}
	}
	
	
}

package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.FilevineNotesExportDao;
import com.filevine.dataexport.domain.NotesExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class NotesExportService {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
	public String getNotesResponse(String cookie, String projectId,int offSet) {
		MDC.put("path", "File Vine:: Notes Export");
		String response=null;
	//	String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectId+"/notes?offset="+offSet+"";
		String url="https://app.filevine.com/api/projects/"+projectId+"/notes?offset="+offSet+"";
	//	String url="https://app.filevine.com/api/projects/"+projectId+"/notes?offset="+offSet+"";
		System.out.println("url : "+url );
	//	String payLoad="{\"filterByType\":0,\"filterIncompleteOnlySet\":false,\"filterCompleteOnlySet\":false,\"filterAssignedToMeSet\":false,\"filterCompletedByMeSet\":false,\"filterCreatedByMeSet\":false,\"filterUtcCreateDateRangeStart\":null,\"filterUtcCreateDateRangeEnd\":null,\"filterRawTaskTargetDateRangeStart\":null,\"filterRawTaskTargetDateRangeEnd\":null,\"filterPinnedOnly\":false,\"filterUnpinnedOnly\":false,\"filterHashtagsList\":[],\"filterTagsList\":[],\"noteId\":null}";
		String payLoad="{\"filterByType\":0,\"filterIncompleteOnlySet\":false,\"filterCompleteOnlySet\":false,\"filterAssignedToMeSet\":false,\"filterCompletedByMeSet\":false,\"filterCreatedByMeSet\":false,\"filterUtcCreateDateRangeStart\":null,\"filterUtcCreateDateRangeEnd\":null,\"filterRawTaskTargetDateRangeStart\":null,\"filterRawTaskTargetDateRangeEnd\":null,\"filterPinnedOnly\":false,\"filterUnpinnedOnly\":false,\"filterHashtagsList\":[],\"filterTagsList\":[],\"noteId\":null}";
//		String payLoad="{\"filterByType\":0,\"filterIncompleteOnlySet\":false,\"filterCompleteOnlySet\":false,\"filterAssignedToMeSet\""
//				+ ":false,\"filterCompletedByMeSet\":false,\"filterCreatedByMeSet\":false,\"filterUtcCreateDateRangeStart\":null,\""
//				+ "filterUtcCreateDateRangeEnd\":null,\"filterRawTaskTargetDateRangeStart\":null,\"filterRawTaskTargetDateRangeEnd\":null,\""
//				+ "filterPinnedOnly\":false,\"filterUnpinnedOnly\":false,\"filterHashtagsList\":[],\"noteId\":null}";
//		
		
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
			eventLogger.info("Response has been exported!!");
//			System.out.println("response : "+response);

		}catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Not able to get response");
//			e.printStackTrace();
		}
		return response;
	}

	
	public int getNotesCount(String response, String databaseName) throws Exception {
		int notesCount=0;
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		JSONObject data=jsonObj.getJSONObject("data");
		JSONArray notes=data.getJSONArray("notes");
		notesCount=notes.length();
		System.out.println("notes count : " +notes.length());
		
		return notesCount;
	}
	
	
	
	public void getNotesData(String response, String databaseName) throws Exception {
		NotesExport notesExport=null;
		FilevineNotesExportDao notesExportDao=new FilevineNotesExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		JSONObject data=jsonObj.getJSONObject("data");
		JSONArray notes=data.getJSONArray("notes");

		//System.out.println("notes count : " +notes.length());
		try {
		for(int j=0; j<=notes.length()-1; j++) {
			notesExport=new NotesExport();
			JSONObject jsonObject=notes.getJSONObject(j);	
			
			if(!jsonObject.opt("id").equals(null)){
				 notesExport.setId(jsonObject.getInt("id"));
			}
			if(!jsonObject.opt("projectID").equals(null)){
				notesExport.setProjectId(jsonObject.getInt("projectID"));
			}
			if(!jsonObject.opt("targetDate").equals(null)) {
				notesExport.setTargetDate(jsonObject.getString("targetDate"));
			}
			if(!jsonObject.opt("body").equals(null)) {
				notesExport.setBody(jsonObject.getString("body"));
			}
			if(!jsonObject.opt("createdAt").equals(null)) {
				notesExport.setCreatedAt(jsonObject.getString("createdAt"));
			}
			
			if(!jsonObject.opt("typeTag").equals(null)) {
				notesExport.setTypeTag(jsonObject.getString("typeTag"));
			}
			if(!jsonObject.opt("lastActivity").equals(null)) {
				notesExport.setLastActivity(jsonObject.getString("lastActivity"));
			}
			if(!jsonObject.opt("assignee").equals(null)) {
				notesExport.setAssignee(jsonObject.getString("assignee"));
			}
			
			JSONObject jsonUser=jsonObject.getJSONObject("author");
			if(!jsonUser.opt("id").equals(null)) {
				notesExport.setUserId(jsonUser.getInt("id"));
			}
			if(!jsonUser.opt("fullname").equals(null)) {
				notesExport.setUserName(jsonUser.getString("fullname"));
			}
			
			
			if(jsonObject.isNull("assignee")) {
				notesExport.setAssigneeId(0);
				notesExport.setAssigneeName("");
				notesExport.setAssigneeUser("");
			}else {
				JSONObject jsonAssignee=jsonObject.getJSONObject("assignee");
				if(!jsonAssignee.opt("id").equals(null)) {
					notesExport.setAssigneeId(jsonAssignee.getInt("id"));
				}
				if(!jsonAssignee.opt("fullname").equals(null)) {
					notesExport.setAssigneeName(jsonAssignee.getString("fullname"));
				}
				if(!jsonAssignee.opt("type").equals(null)) {
					notesExport.setAssigneeUser(jsonAssignee.getString("type"));
				}
			}
			
			if(notesExport.getTypeTag().equals("note")) {
				notesExportDao.insertDataNotes(databaseName, notesExport);
			}else
				if(notesExport.getTypeTag().equals("task")) {
				notesExportDao.insertActivityTaskData(databaseName,notesExport);
			}
				else{
				notesExportDao.insertActivitySmsData(databaseName,notesExport);
			}
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

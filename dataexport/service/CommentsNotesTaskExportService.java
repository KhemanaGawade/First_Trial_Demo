package com.filevine.dataexport.service;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.CommentsNotesExportDao;
import com.filevine.dataexport.dao.CommentsNotesTaskExportDao;
import com.filevine.dataexport.domain.CommentsNotesExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CommentsNotesTaskExportService {

	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public String getCommentsNotesResponse(String cookie, int noteId) {

		MDC.put("path", "File Vine:: Comments Notes Export");

		String response=null;
      //   String url="https://app.filevine.com/api/projects/10071996/notes?offset=0";
		String url="https://app.filevine.com/api/notes/"+noteId;

		try {
			WebResource webResource=Client.create().resource(url);
			response=webResource.header("Cookie", cookie).get(String.class);
			//		eventLogger.info("Response has been exported!!");
		}

		catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
			//			e.printStackTrace();
		}
		return response;
	}

//	public void getCommentsNotesData(String response, String databaseName,int noteIdInput) throws Exception {
//		CommentsNotesExport commentsNotesExport=new CommentsNotesExport();
//		CommentsNotesTaskExportDao commentsNotesExportDao=new CommentsNotesTaskExportDao();
//		String 	res=response;
//		int i=res.indexOf('{');
//		res=res.substring(i);
//
//		JSONObject jsonObj=new JSONObject(res);
//		JSONObject data=jsonObj.getJSONObject("data");
//
//		JSONArray comments=data.getJSONArray("comments");
//
//		System.out.println(comments.length());
//		for(int j=0; j<=comments.length()-1; j++) {
//			JSONObject jsonObject=comments.getJSONObject(j);	
//
//			if(!jsonObject.opt("id").equals(null)){
//				commentsNotesExport.setCommentId(jsonObject.getInt("id"));
//			}
//
//			if(!jsonObject.opt("noteID").equals(null)){
//				commentsNotesExport.setNoteId(jsonObject.getInt("noteID"));
//			}
//			if(!jsonObject.opt("body").equals(null)) {
//				commentsNotesExport.setBody(jsonObject.getString("body"));
//			}
//			if(!jsonObject.opt("createdAt").equals(null)) {
//				commentsNotesExport.setCreatedAt(jsonObject.getString("createdAt"));
//			}
//			JSONObject jsonUser=jsonObject.getJSONObject("author");
//			if(!jsonUser.opt("id").equals(null)) {
//				commentsNotesExport.setUserId(jsonUser.getInt("id"));
//			}
//			if(!jsonUser.opt("fullname").equals(null)) {
//				commentsNotesExport.setFullName(jsonUser.getString("fullname"));
//			}
//			
//			
//			commentsNotesExport.setNoteIdInput(noteIdInput);
//			
//			commentsNotesExportDao.insertDataCommentsNotes(databaseName, commentsNotesExport);
//		}
//	}


	public void getTaskData(String response, String databaseName) throws Exception {
		
		CommentsNotesExport commentsNotesExport=new CommentsNotesExport();
		CommentsNotesTaskExportDao commentsNotesExportDao=new CommentsNotesTaskExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		JSONObject data=jsonObj.getJSONObject("data");

		if(!data.opt("id").equals(null)){
			commentsNotesExport.setNoteId(data.getInt("id"));
		}

		if(!data.opt("projectID").equals(null)){
			commentsNotesExport.setProjectId(data.getString("projectID"));
		}

		if(!data.opt("typeTag").equals(null)){
			commentsNotesExport.setTypeTag(data.getString("typeTag"));
		}

		if(!data.opt("targetDate").equals(null)){
			commentsNotesExport.setTargetDate(data.getString("targetDate"));
		}
		if(!data.opt("createdAt").equals(null)){
			commentsNotesExport.setCreatedAt(data.getString("createdAt"));
		}

		if(!data.opt("isUnread").equals(null)){
			commentsNotesExport.setIsUnread(data.getString("isUnread"));
		}

		if(!data.opt("isCompleted").equals(null)){
			commentsNotesExport.setIsCompleted(data.getString("isCompleted"));
		}

		if(!data.opt("completedDate").equals(null)){
			commentsNotesExport.setCompletedDate(data.getString("completedDate"));
		}

		if(!data.opt("destination").equals(null)){
			commentsNotesExport.setDestination(data.getString("destination"));
		}

		if(!data.opt("source").equals(null)){
			commentsNotesExport.setSource(data.getString("source"));
		}

		if(!data.opt("isEdited").equals(null)){
			commentsNotesExport.setIsEdited(data.getString("isEdited"));
		}

		if(!data.opt("allowEditing").equals(null)){
			commentsNotesExport.setAllowEditing(data.getString("allowEditing"));
		}

		if(!data.opt("lastActivity").equals(null)){
			commentsNotesExport.setLastActivity(data.getString("lastActivity"));
		}
		if(!data.opt("body").equals(null)){
			commentsNotesExport.setTaskBody(data.getString("body"));
		}

		//	JSONObject data=jsonObj.getJSONObject("data");
		if(data.isNull("assignee")) {
			commentsNotesExport.setAssigneeId(0);
			commentsNotesExport.setAssigneeFullName("");
		}else {
		JSONObject assignee=data.getJSONObject("assignee");
		if(!assignee.opt("id").equals(null)){
			commentsNotesExport.setAssigneeId(assignee.getInt("id"));
		}
		if(!assignee.opt("fullname").equals(null)){
			commentsNotesExport.setAssigneeFullName(assignee.getString("fullname"));
		}
		}
		
		//author details
		if(data.isNull("author")) {
			commentsNotesExport.setAuthorId(0);
			commentsNotesExport.setAuthorName("");
		}else {
		JSONObject author=data.getJSONObject("author");
		if(!author.opt("id").equals(null)){
			commentsNotesExport.setAuthorId(author.getInt("id"));
		}
		if(!author.opt("fullname").equals(null)){
			commentsNotesExport.setAuthorName(author.getString("fullname"));
		}
		}
		
		//completer details
		if(data.isNull("completer")) {
			commentsNotesExport.setCompleterId(0);
			commentsNotesExport.setCompleterName("");
			commentsNotesExport.setCompleterCreatedAt("");
		}else {
			JSONObject completer=data.getJSONObject("completer");
			if(!completer.opt("id").equals(null)){
				commentsNotesExport.setCompleterId(completer.getInt("id"));
			}
			if(!completer.opt("fullname").equals(null)){
				commentsNotesExport.setCompleterName(completer.getString("fullname"));
			}
			if(!completer.opt("createdAt").equals(null)){
				commentsNotesExport.setCompleterCreatedAt(completer.getString("createdAt"));
			}
			
		}
		commentsNotesExportDao.insertDataTasks(databaseName, commentsNotesExport);

	}




}

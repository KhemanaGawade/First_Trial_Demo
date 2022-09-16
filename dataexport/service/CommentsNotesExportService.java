package com.filevine.dataexport.service;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.CommentsNotesExportDao;
import com.filevine.dataexport.domain.CommentsNotesExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for comment notes tab from ui
 **/
public class CommentsNotesExportService {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	/**
	 * @return a response for comment notes from filevine  url by passing parameter cookie & note id
	 */
	public String getCommentsNotesResponse(String cookie, int noteId) {
		
		MDC.put("path", "File Vine:: Comments Notes Export");
		
		String response=null;
	    
		String url="https://app.filevine.com/api/notes/"+noteId;
		
		try {
			WebResource webResource=Client.create().resource(url);
			response=webResource.header("Cookie", cookie).get(String.class);
			eventLogger.info("Response has been exported!!");
			}
			
		catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
//			e.printStackTrace();
		}
		return response;
	}

	/**
	 * Taking input as a response.
	 * Converting JSON response to OBJECT
	 * Creating object of CommentsNotesExport class
	 * Setting values to setter methods of CommentsNotesExport class
	 * Calling method of CommentsNotesExportDao to insert all values using databaseName
	 */
	public void getCommentsNotesData(String response, String databaseName, int noteId) throws Exception {
		CommentsNotesExport commentsNotesExport=new CommentsNotesExport();
		CommentsNotesExportDao commentsNotesExportDao=new CommentsNotesExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		JSONObject data=jsonObj.getJSONObject("data");
		JSONArray comments=data.getJSONArray("comments");
		
		
		commentsNotesExport.setTask_id_input(noteId);
		System.out.println(comments.length());
		for(int j=0; j<=comments.length()-1; j++) {
			JSONObject jsonObject=comments.getJSONObject(j);	
			
			if(!jsonObject.opt("id").equals(null)){
				commentsNotesExport.setCommentId(jsonObject.getInt("id"));
			}
			if(!jsonObject.opt("noteID").equals(null)){
				commentsNotesExport.setNoteId(jsonObject.getInt("noteID"));
			}
			if(!jsonObject.opt("body").equals(null)) {
				commentsNotesExport.setBody(jsonObject.getString("body"));
			}
			if(!jsonObject.opt("createdAt").equals(null)) {
				commentsNotesExport.setCreatedAt(jsonObject.getString("createdAt"));
			}
		    JSONObject jsonUser=jsonObject.getJSONObject("author");
			if(!jsonUser.opt("id").equals(null)) {
				commentsNotesExport.setUserId(jsonUser.getInt("id"));
			}
			if(!jsonUser.opt("fullname").equals(null)) {
				commentsNotesExport.setFullName(jsonUser.getString("fullname"));
			}
			
			commentsNotesExportDao.insertDataCommentsNotes(databaseName, commentsNotesExport);
	}
	}
}

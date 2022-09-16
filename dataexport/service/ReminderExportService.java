package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.CaseSummaryExportDAO;
import com.filevine.dataexport.dao.ReminderExportDao;
import com.filevine.dataexport.domain.CaseSummaryExport;
import com.filevine.dataexport.domain.ReminderExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ReminderExportService {

	public String getReminderResponse(String cookie, String projectID) {
		String response=null;
		String url="https://app.filevine.com/api/projects/"+projectID+"/deadlines" ; 
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie)
					.get(String.class);
		
			System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}
		return response;
	}

	public void getReminderData(String response, String database) throws JSONException, SQLException {
		ReminderExportDao reminderExportDao=new ReminderExportDao();
		ReminderExport reminderExport=new ReminderExport();	
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject caseData=new JSONObject(res);
		JSONArray arr = caseData.getJSONArray("data");
		for(int k = 0; k<arr.length();k++)
		{
             JSONObject jsonObj= arr.getJSONObject(k);	
             if(jsonObj.isNull("id")) {
            	 reminderExport.setReminderId(null);
				}else {
					
			    if(!jsonObj.opt("id").equals(null)){
			    	reminderExport.setReminderId(jsonObj.getString("id"));
			 }}
             if(jsonObj.isNull("projectID")) {
            	 reminderExport.setProjectId(null);
				}else {
					
			    if(!jsonObj.opt("projectID").equals(null)){
			    	reminderExport.setProjectId(jsonObj.getString("projectID"));
			 }}
             if(jsonObj.isNull("name")) {
            	 reminderExport.setName(null);
				}else {
					
			    if(!jsonObj.opt("name").equals(null)){
			    	reminderExport.setName(jsonObj.getString("name"));
			 }}
             if(jsonObj.isNull("notes")) {
            	 reminderExport.setNotes(null);
				}else {
					
			    if(!jsonObj.opt("notes").equals(null)){
			    	reminderExport.setNotes(jsonObj.getString("notes"));
			 }}
             if(jsonObj.isNull("dueDate")) {
            	 reminderExport.setDueDate(null);
				}else {
					
			    if(!jsonObj.opt("dueDate").equals(null)){
			    	reminderExport.setDueDate(jsonObj.getString("dueDate"));
			 }}
             if(jsonObj.isNull("doneDate")) {
            	 reminderExport.setDoneDate(null);
				}else {
					
			    if(!jsonObj.opt("doneDate").equals(null)){
			    	reminderExport.setDoneDate(jsonObj.getString("doneDate"));
			 }}
             reminderExportDao.insertReminderData(database, reminderExport);
		}
		
	}

}

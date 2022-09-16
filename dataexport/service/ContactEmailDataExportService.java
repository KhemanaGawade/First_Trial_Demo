package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.ContactEmailDataExportDao;

import com.filevine.dataexport.domain.ContactEmailsDataExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ContactEmailDataExportService {
	
	
public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/uniquecontacts";
		
		
		
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).get(String.class);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;

		}
	
	
	public void getAdvanceClientCostData(String response, String databaseName,String projectID) throws JSONException, SQLException {
		
		ContactEmailsDataExport  contactemailsdataexport =null;
		ContactEmailDataExportDao ContactEmailDataExportDao=new ContactEmailDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		           JSONObject data=new JSONObject(res);
	
	
		       if(!data.opt("data").equals(null)) {
		     	JSONArray communication=data.getJSONArray("data");
			     for(int j=0; j<=communication.length()-1; j++) {
				
			    	 contactemailsdataexport=new ContactEmailsDataExport  ();
			    	 contactemailsdataexport.setProjectId(projectID);
				JSONObject jsonObject=communication.getJSONObject(j);
				if(jsonObject.isNull("id")) {
					 contactemailsdataexport.setContactId( null);
				}else {
					
			    if(!jsonObject.opt("id").equals(null)){
			    	 contactemailsdataexport.setContactId( jsonObject.getString("id"));
			    }}
				if(jsonObject.isNull("personID")) {
					 contactemailsdataexport.setPersonID( null);
				}else {
					
			    if(!jsonObject.opt("personID").equals(null)){
			    	 contactemailsdataexport.setPersonID( jsonObject.getString("personID"));
			    }}
				
				 JSONObject obj = jsonObject.getJSONObject("person");
	
				 JSONArray array = obj.getJSONArray("emails");
	
				 for(int p = 0; p < array.length() ;p++)
				   {
				
		             JSONObject jsonObj2= array.getJSONObject(p);	
	
		             if(jsonObj2.isNull("id")) {
		            	 contactemailsdataexport.setEmailId( null);
						}else {
							
					    if(!jsonObj2.opt("id").equals(null)){
					    	 contactemailsdataexport.setEmailId( jsonObj2.getString("id"));
					    }}
	
		             if(jsonObj2.isNull("address")) {
		            	 contactemailsdataexport.setAddress( null);
						}else {
							
					    if(!jsonObj2.opt("address").equals(null)){
					    	 contactemailsdataexport.setAddress( jsonObj2.getString("address"));
					    }}
	
		        
		             if(jsonObj2.isNull("label")) {
		            	 contactemailsdataexport.setLabel( null);
						}else {
							
					    if(!jsonObj2.opt("label").equals(null)){
					    	 contactemailsdataexport.setLabel( jsonObj2.getString("label"));
					    }}
	
		             if(jsonObj2.isNull("notes")) {
		            	 contactemailsdataexport.setNotes( null);
						}else {
							
					    if(!jsonObj2.opt("notes").equals(null)){
					    	 contactemailsdataexport.setNotes( jsonObj2.getString("notes"));
					    }}
		             
		             ContactEmailDataExportDao.insertContactEmailsData(databaseName, contactemailsdataexport);       
		             
}
}
		       }
	}
}
package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.filevine.dataexport.dao.ContactPhoneDataExportDao;
import com.filevine.dataexport.domain.ContactPhoneDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ContactPhoneDataExportService {

	
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
		
		ContactPhoneDataExport contactphonedataexport=null;
		ContactPhoneDataExportDao contactphonedataexportdao=new ContactPhoneDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		           JSONObject data=new JSONObject(res);
	
	
		       if(!data.opt("data").equals(null)) {
		     	JSONArray communication=data.getJSONArray("data");
			     for(int j=0; j<=communication.length()-1; j++) {
				
			    	 contactphonedataexport=new ContactPhoneDataExport ();
			    	 contactphonedataexport.setProjectId(projectID);
				JSONObject jsonObject=communication.getJSONObject(j);
				if(jsonObject.isNull("id")) {
					contactphonedataexport.setContactId( null);
				}else {
					
			    if(!jsonObject.opt("id").equals(null)){
			    	contactphonedataexport.setContactId( jsonObject.getString("id"));
			    }}
				if(jsonObject.isNull("personID")) {
					contactphonedataexport.setPersonID( null);
				}else {
					
			    if(!jsonObject.opt("personID").equals(null)){
			    	contactphonedataexport.setPersonID( jsonObject.getString("personID"));
			    }}
				
				 JSONObject obj = jsonObject.getJSONObject("person");
	
				 JSONArray array = obj.getJSONArray("phones");
	
				 for(int p = 0; p < array.length() ;p++)
				   {
				
		             JSONObject jsonObj2= array.getJSONObject(p);	
	
		             if(jsonObj2.isNull("id")) {
		            	 contactphonedataexport.setPhoneId( null);
						}else {
							
					    if(!jsonObj2.opt("id").equals(null)){
					    	contactphonedataexport.setPhoneId( jsonObj2.getString("id"));
					    }}
	
		             if(jsonObj2.isNull("number")) {
		            	 contactphonedataexport.setNumber( null);
						}else {
							
					    if(!jsonObj2.opt("number").equals(null)){
					    	contactphonedataexport.setNumber( jsonObj2.getString("number"));
					    }}
	
		             if(jsonObj2.isNull("rawNumber")) {
		            	 contactphonedataexport.setRawNumber( null);
						}else {
							
					    if(!jsonObj2.opt("rawNumber").equals(null)){
					    	contactphonedataexport.setRawNumber( jsonObj2.getString("rawNumber"));
					    }}
	
		             if(jsonObj2.isNull("label")) {
		            	 contactphonedataexport.setLabel( null);
						}else {
							
					    if(!jsonObj2.opt("label").equals(null)){
					    	contactphonedataexport.setLabel( jsonObj2.getString("label"));
					    }}
	
		             if(jsonObj2.isNull("notes")) {
		            	 contactphonedataexport.setNotes( null);
						}else {
							
					    if(!jsonObj2.opt("notes").equals(null)){
					    	contactphonedataexport.setNotes( jsonObj2.getString("notes"));
					    }}
		             
		             contactphonedataexportdao.insertContactPhoneData(databaseName,contactphonedataexport);       
		             
		             
				   }
			     }
		       }
	}
}

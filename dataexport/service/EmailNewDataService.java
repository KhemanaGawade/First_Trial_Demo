package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.EmailNewDataDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.ContactInfoDataDomain;
import com.filevine.dataexport.domain.EmailNewDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class EmailNewDataService {

	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/uniquecontacts";
		
		
		
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
	
		EmailNewDataExport emailnewdataexport=null;
		EmailNewDataDao emailnewdatadao=new EmailNewDataDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject data=new JSONObject(res);
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				
				emailnewdataexport=new EmailNewDataExport();
				emailnewdataexport.setProjectId(projectID);
				JSONObject jsonObject12=communication.getJSONObject(j);
				
				if(jsonObject12.isNull("personID")) {
					emailnewdataexport.setPersonID( null);
	 			}else {
	 				
	 		    if(!jsonObject12.opt("personID").equals(null)){
	 		    	emailnewdataexport.setPersonID(jsonObject12.getString("personID"));
	 		    }}
	
				JSONObject obj = jsonObject12.getJSONObject("person");
	
				JSONArray array = obj.getJSONArray("emails");
				   for(int p = 0; p < array.length() ;p++)
				   {
				
		             JSONObject jsonObj2= array.getJSONObject(p);	
	
		             if(jsonObj2.isNull("id")) {
		            	 emailnewdataexport.setEmailId( null);
						}else {
							
					    if(!jsonObj2.opt("id").equals(null)){
					    	emailnewdataexport.setEmailId( jsonObj2.getString("id"));
					    }}
					
		           
		             if(jsonObj2.isNull("address")) {
		            	 emailnewdataexport.setAddress( null);
						}else {
							
					    if(!jsonObj2.opt("address").equals(null)){
					    	emailnewdataexport.setAddress( jsonObj2.getString("address"));
					    }}
		             
		             if(jsonObj2.isNull("label")) {
		            	 emailnewdataexport.setLabel( null);
						}else {
							
					    if(!jsonObj2.opt("label").equals(null)){
					    	emailnewdataexport.setLabel( jsonObj2.getString("label"));
					    }}
		             
		             emailnewdatadao.insertEmailNewData(databaseName, emailnewdataexport);  
		             
	
	}
	
}
}
	}
}
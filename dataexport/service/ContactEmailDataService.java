package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.ContactEmailDataDao;

import com.filevine.dataexport.domain.ContactEmailDataExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ContactEmailDataService {

	
public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/uniquecontacts";
		
		//String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
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
	
	
public void getContactData(String database ,String res,String projectId) throws Exception
{
	ContactEmailDataExport contactemaildataexport =null;
	ContactEmailDataDao  contactemaildatadao  = new ContactEmailDataDao ();

	int i = res.indexOf("{");
	res = res.substring(i);
	JSONObject jobj = new JSONObject(res);
	System.out.println("data is inserted");
		if(!jobj.isNull("data")) {
			JSONArray arr = jobj.getJSONArray("data");
			for(int k = 0; k<=arr.length()-1;k++)
			{
				contactemaildataexport=new ContactEmailDataExport();
				contactemaildataexport.setProjectId(projectId);
				
	             JSONObject jsonObj2= arr.getJSONObject(k);
	             JSONObject obj = jsonObj2.getJSONObject("person");
	             
	        //     JSONObject jsonObj2 = jsonObj.getJSONObject("person");
	             JSONArray personType = obj.getJSONArray("emails");
	 			for(int j = 0; j<personType.length();j++) {
	 				JSONObject jsonObject = personType.getJSONObject(j);
	 				 
	 				if(jsonObject.isNull("id")) {
	 					contactemaildataexport.setEmailId( null);
					}else {
						
				    if(!jsonObject.opt("id").equals(null)){
				    	contactemaildataexport.setEmailId( jsonObject.getString("id"));
				    }}
	 				
	 				if(jsonObject.isNull("address")) {
	 					contactemaildataexport.setAddress( null);
					}else {
						
				    if(!jsonObject.opt("address").equals(null)){
				    	contactemaildataexport.setAddress( jsonObject.getString("address"));
				    }}
	 				
	 				if(jsonObject.isNull("label")) {
	 					contactemaildataexport.setLabel( null);
					}else {
						
				    if(!jsonObject.opt("label").equals(null)){
				    	contactemaildataexport.setLabel( jsonObject.getString("label"));
				    }}
	 				
	 				if(jsonObject.isNull("notes")) {
	 					contactemaildataexport.setNotes( null);
					}else {
						
				    if(!jsonObject.opt("notes").equals(null)){
				    	contactemaildataexport.setNotes( jsonObject.getString("notes"));
				    }}
	 				
	 				contactemaildatadao .insertContactEmailData(database, contactemaildataexport);
	 			}
	             
	
	}
}
}
	
}

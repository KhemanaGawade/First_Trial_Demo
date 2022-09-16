package com.filevine.dataexport.service;

import java.sql.SQLException;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.filevine.dataexport.dao.ContactAddressDataExportDao;
import com.filevine.dataexport.domain.ContactAddressDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ContactAddressDataExportService {

	
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
		
		ContactAddressDataExport contactaddressdataexport=null;
		ContactAddressDataExportDao contactaddressdataexportdao=new ContactAddressDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		           JSONObject data=new JSONObject(res);
	
	
		       if(!data.opt("data").equals(null)) {
		     	JSONArray communication=data.getJSONArray("data");
			     for(int j=0; j<=communication.length()-1; j++) {
				
				contactaddressdataexport=new ContactAddressDataExport();
				contactaddressdataexport.setProjectId(projectID);
				JSONObject jsonObject=communication.getJSONObject(j);
				if(jsonObject.isNull("id")) {
					contactaddressdataexport.setContactId( null);
				}else {
					
			    if(!jsonObject.opt("id").equals(null)){
			    	contactaddressdataexport.setContactId( jsonObject.getString("id"));
			    }}
				if(jsonObject.isNull("personID")) {
					contactaddressdataexport.setPersonID( null);
				}else {
					
			    if(!jsonObject.opt("personID").equals(null)){
			    	contactaddressdataexport.setPersonID( jsonObject.getString("personID"));
			    }}
				
				 JSONObject obj = jsonObject.getJSONObject("person");
	
				 JSONArray array = obj.getJSONArray("addresses");
	
				 for(int p = 0; p < array.length() ;p++)
				   {
				
		             JSONObject jsonObj2= array.getJSONObject(p);	
	
		             if(jsonObj2.isNull("id")) {
							contactaddressdataexport.setAddressesId( null);
						}else {
							
					    if(!jsonObj2.opt("id").equals(null)){
					    	contactaddressdataexport.setAddressesId( jsonObj2.getString("id"));
					    }}
			
		             if(jsonObj2.isNull("line1")) {
							contactaddressdataexport.setLine1( null);
						}else {
							
					    if(!jsonObj2.opt("line1").equals(null)){
					    	contactaddressdataexport.setLine1( jsonObj2.getString("line1"));
					    }}
		             
		             if(jsonObj2.isNull("line2")) {
							contactaddressdataexport.setLine2( null);
						}else {
							
					    if(!jsonObj2.opt("line2").equals(null)){
					    	contactaddressdataexport.setLine2( jsonObj2.getString("line2"));
					    }}
		             
		             if(jsonObj2.isNull("city")) {
							contactaddressdataexport.setCity( null);
						}else {
							
					    if(!jsonObj2.opt("city").equals(null)){
					    	contactaddressdataexport.setCity( jsonObj2.getString("city"));
					    }}
		             
		             if(jsonObj2.isNull("state")) {
							contactaddressdataexport.setState( null);
						}else {
							
					    if(!jsonObj2.opt("state").equals(null)){
					    	contactaddressdataexport.setState( jsonObj2.getString("state"));
					    }}
		             if(jsonObj2.isNull("zip")) {
							contactaddressdataexport.setZip( null);
						}else {
							
					    if(!jsonObj2.opt("zip").equals(null)){
					    	contactaddressdataexport.setZip( jsonObj2.getString("zip"));
					    }}
		             
		             if(jsonObj2.isNull("label")) {
							contactaddressdataexport.setLabel( null);
						}else {
							
					    if(!jsonObj2.opt("label").equals(null)){
					    	contactaddressdataexport.setLabel( jsonObj2.getString("label"));
					    }}
		             
		             if(jsonObj2.isNull("notes")) {
							contactaddressdataexport.setNotes( null);
						}else {
							
					    if(!jsonObj2.opt("notes").equals(null)){
					    	contactaddressdataexport.setNotes( jsonObj2.getString("notes"));
					    }}
		             
		             if(jsonObj2.isNull("fullAddress")) {
							contactaddressdataexport.setFullAddress( null);
						}else {
							
					    if(!jsonObj2.opt("fullAddress").equals(null)){
					    	contactaddressdataexport.setFullAddress( jsonObj2.getString("fullAddress"));
					    }}
		             
		             contactaddressdataexportdao.insertContactAddressData(databaseName,contactaddressdataexport);     
		             
		             
		             
		             
		             
				   }
			     }
		       }
	}
		             
		             
}

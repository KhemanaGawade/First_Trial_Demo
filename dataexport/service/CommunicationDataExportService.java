package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.filevine.dataexport.dao.CommunicationDataExportDao;
import com.filevine.dataexport.domain.CommunicationDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CommunicationDataExportService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/communications1032?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
		
		CommunicationDataExport communicationdataexport=new CommunicationDataExport();
		CommunicationDataExportDao CommunicationDataExportDao=new CommunicationDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			communicationdataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
		
				if(jsonObject.isNull("typeofcommunication37273")) {
					communicationdataexport.setTypeOfCommunication( null);
				}else {
					
			    if(!jsonObject.opt("typeofcommunication37273").equals(null)){
			    	communicationdataexport.setTypeOfCommunication( jsonObject.getString("typeofcommunication37273"));
			    }}
		
				if(jsonObject.isNull("communicationto37273")){
					communicationdataexport.setCommunicationTo(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("communicationto37273");
					if(!communication6.opt("fullname").equals(null)){
						communicationdataexport.setCommunicationTo(communication6.getString("fullname"));
					}}
				
				if(jsonObject.isNull("communicationfrom37273")){
					communicationdataexport.setCommunicationFrom(null);
				}else {
					JSONObject communication7=jsonObject.getJSONObject("communicationfrom37273");
					if(!communication7.opt("fullname").equals(null)){
						communicationdataexport.setCommunicationFrom(communication7.getString("fullname"));
					}}
				
				if(jsonObject.isNull("dateofcommunication37273")) {
					communicationdataexport.setCommunicationDate( null);
				}else {
					
			    if(!jsonObject.opt("dateofcommunication37273").equals(null)){
			    	communicationdataexport.setCommunicationDate( jsonObject.getString("dateofcommunication37273"));
			    }}
		
				if(jsonObject.isNull("communicationnotes37273")) {
					communicationdataexport.setCommunicationNotes( null);
				}else {
					
			    if(!jsonObject.opt("communicationnotes37273").equals(null)){
			    	communicationdataexport.setCommunicationNotes( jsonObject.getString("communicationnotes37273"));
			    }}
		
				CommunicationDataExportDao.insertCommunicationData(databaseName,communicationdataexport);
	
	
}

		}
	}
}
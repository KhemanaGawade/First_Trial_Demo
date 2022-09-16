package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.WitnessExportDao;

import com.filevine.dataexport.domain.WitnessExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class WitnessExportService {

	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/witnesses16407?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"witness191317\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
		
		WitnessExport witnessexport=new WitnessExport();
		WitnessExportDao witnessexportdao=new WitnessExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			witnessexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				if(jsonObject.isNull("dateinterviewed191317")) {
					witnessexport.setDateInterViewed( null);
				}else {
					
			    if(!jsonObject.opt("dateinterviewed191317").equals(null)){
			    	witnessexport.setDateInterViewed( jsonObject.getString("dateinterviewed191317"));
			    }}
				
			
				if(jsonObject.isNull("witness191317")){
					witnessexport.setWitnessId(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("witness191317");
					if(!communication6.opt("id").equals(null)){
						witnessexport.setWitnessId(communication6.getString("id"));
					}}
	
				if(jsonObject.isNull("witness191317")){
					witnessexport.setOrgID(null);
				}else {
					JSONObject communication7=jsonObject.getJSONObject("witness191317");
					if(!communication7.opt("orgID").equals(null)){
						witnessexport.setOrgID(communication7.getString("orgID"));
					}}
	
				if(jsonObject.isNull("witness191317")){
					witnessexport.setWitNessFullName(null);
				}else {
					JSONObject communication8=jsonObject.getJSONObject("witness191317");
					if(!communication8.opt("fullname").equals(null)){
						witnessexport.setWitNessFullName(communication8.getString("fullname"));
					}}
				if(jsonObject.isNull("witness191317")){
					witnessexport.setCreatedDate(null);
				}else {
					JSONObject communication9=jsonObject.getJSONObject("witness191317");
					if(!communication9.opt("createdDate").equals(null)){
						witnessexport.setCreatedDate(communication9.getString("createdDate"));
					}}
				
				if(jsonObject.isNull("witness191317")){
					witnessexport.setModiFiedDate(null);
				}else {
					JSONObject communication9=jsonObject.getJSONObject("witness191317");
					if(!communication9.opt("modifiedDate").equals(null)){
						witnessexport.setModiFiedDate(communication9.getString("modifiedDate"));
					}}
				
				if(jsonObject.isNull("witnesssrole191317")) {
					witnessexport.setWitnessRole( null);
				}else {
					
			    if(!jsonObject.opt("witnesssrole191317").equals(null)){
			    	witnessexport.setWitnessRole( jsonObject.getString("witnesssrole191317"));
			    }}
				if(jsonObject.isNull("notes191317")) {
					witnessexport.setNotes( null);
				}else {
					
			    if(!jsonObject.opt("notes191317").equals(null)){
			    	witnessexport.setNotes( jsonObject.getString("notes191317"));
			    }}
				if(jsonObject.isNull("_id")) {
					witnessexport.setUniqueID( null);
				}else {
					
			    if(!jsonObject.opt("_id").equals(null)){
			    	witnessexport.setUniqueID( jsonObject.getString("_id"));
			    }}
				witnessexportdao.insertWitnessData(databaseName,witnessexport);
				
			}
		}
	}
	
}

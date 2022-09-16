package com.filevine.dataexport.service;

import java.sql.SQLException;


import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DefendantsExportDao;

import com.filevine.dataexport.domain.DefendantsExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class DefendantsExportService {

	
public String getDefendantsClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/defendants16407?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
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
	
	public void getDefendantsClientCostData(String response, String databaseName) throws JSONException, SQLException {
		
		DefendantsExport defendantsexport=new DefendantsExport();
		DefendantsExportDao defendantsexportdao=new DefendantsExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			defendantsexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				
			
				if(jsonObject.isNull("defendant191325")){
					defendantsexport.setDefendantId(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("defendant191325");
					if(!communication6.opt("id").equals(null)){
						defendantsexport.setDefendantId(communication6.getString("id"));
					}}
	
				if(jsonObject.isNull("defendant191325")){
					defendantsexport.setOrgID(null);
				}else {
					JSONObject communication7=jsonObject.getJSONObject("defendant191325");
					if(!communication7.opt("orgID").equals(null)){
						defendantsexport.setOrgID(communication7.getString("orgID"));
					}}
	
				if(jsonObject.isNull("defendant191325")){
					defendantsexport.setDefendantFullName(null);
				}else {
					JSONObject communication8=jsonObject.getJSONObject("defendant191325");
					if(!communication8.opt("fullname").equals(null)){
						defendantsexport.setDefendantFullName(communication8.getString("fullname"));
					}}
				if(jsonObject.isNull("defendant191325")){
					defendantsexport.setCreatedDate(null);
				}else {
					JSONObject communication9=jsonObject.getJSONObject("defendant191325");
					if(!communication9.opt("createdDate").equals(null)){
						defendantsexport.setCreatedDate(communication9.getString("createdDate"));
					}}
				
				if(jsonObject.isNull("defendant191325")){
					defendantsexport.setModiFiedDate(null);
				}else {
					JSONObject communication9=jsonObject.getJSONObject("defendant191325");
					if(!communication9.opt("modifiedDate").equals(null)){
						defendantsexport.setModiFiedDate(communication9.getString("modifiedDate"));
					}}
				
				
				if(jsonObject.isNull("servicedate191325")){
					defendantsexport.setServiceDueDate(null);
				}else {
					JSONObject communication12=jsonObject.getJSONObject("servicedate191325");
					if(!communication12.opt("dateValue").equals(null)){
						defendantsexport.setServiceDueDate(communication12.getString("dateValue"));
					}}
				
				if(jsonObject.isNull("servicedate191325")){
					defendantsexport.setServiceDoneDate(null);
				}else {
					JSONObject communication12=jsonObject.getJSONObject("servicedate191325");
					if(!communication12.opt("doneDate").equals(null)){
						defendantsexport.setServiceDoneDate(communication12.getString("doneDate"));
					}}
				
				
				if(jsonObject.isNull("attorneyfordefendant191325")){
					defendantsexport.setAttorneyForDefendantId(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("attorneyfordefendant191325");
					if(!communication6.opt("id").equals(null)){
						defendantsexport.setAttorneyForDefendantId(communication6.getString("id"));
					}}
				
				if(jsonObject.isNull("attorneyfordefendant191325")){
					defendantsexport.setAttorneyForDefendantFullName(null);
				}else {
					JSONObject communication8=jsonObject.getJSONObject("attorneyfordefendant191325");
					if(!communication8.opt("fullname").equals(null)){
						defendantsexport.setAttorneyForDefendantFullName(communication8.getString("fullname"));
					}}
				
			
				if(jsonObject.isNull("_id")) {
					defendantsexport.setUniqueID( null);
				}else {
					
			    if(!jsonObject.opt("_id").equals(null)){
			    	defendantsexport.setUniqueID( jsonObject.getString("_id"));
			    }}
				
				if(jsonObject.isNull("notes191325")) {
					defendantsexport.setNotes( null);
				}else {
					
			    if(!jsonObject.opt("notes191325").equals(null)){
			    	defendantsexport.setNotes( jsonObject.getString("notes191325"));
			    }}
				defendantsexportdao.insertDefendantData(databaseName,defendantsexport);
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}

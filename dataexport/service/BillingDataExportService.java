package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.BillingDataExportDao;
import com.filevine.dataexport.dao.ChildernDataExportDao;
import com.filevine.dataexport.domain.BillingDataExport;
import com.filevine.dataexport.domain.ChildernDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class BillingDataExportService {

public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/billing16433?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"date191750\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
	
	BillingDataExport billingdataexport =new BillingDataExport ();
	BillingDataExportDao  BillingDataExportDao =new BillingDataExportDao ();
	String 	res=response;
	int i=res.indexOf('{');
	res=res.substring(i);
	
	JSONObject advanceClientData=new JSONObject(res);
	if(!advanceClientData.opt("projectID").equals(null)){
		billingdataexport .setProjectId(advanceClientData.getString("projectID"));
	}
	
	JSONObject data=advanceClientData.getJSONObject("data");
	
	if(!data.opt("collection").equals(null)) {
		JSONArray communication=data.getJSONArray("collection");
		for(int j=0; j<=communication.length()-1; j++) {
			JSONObject jsonObject=communication.getJSONObject(j);
	
			if(jsonObject.isNull("type191750")) {
				billingdataexport .setType( null);
			}else {
				
		    if(!jsonObject.opt("type191750").equals(null)){
		    	billingdataexport .setType( jsonObject.getString("type191750"));
		    }}
	
			if(jsonObject.isNull("title191750")) {
				billingdataexport .setTitle( null);
			}else {
				
		    if(!jsonObject.opt("title191750").equals(null)){
		    	billingdataexport .setTitle( jsonObject.getString("title191750"));
		    }}
	
			if(jsonObject.isNull("amount191750")) {
				billingdataexport .setAmount( null);
			}else {
				
		    if(!jsonObject.opt("amount191750").equals(null)){
		    	billingdataexport .setAmount( jsonObject.getString("amount191750"));
		    }}
	
			if(jsonObject.isNull("date191750")) {
				billingdataexport .setDate( null);
			}else {
				
		    if(!jsonObject.opt("date191750").equals(null)){
		    	billingdataexport .setDate( jsonObject.getString("date191750"));
		    }}
			
			if(jsonObject.isNull("_id")) {
				billingdataexport .setId( null);
			}else {
				
		    if(!jsonObject.opt("_id").equals(null)){
		    	billingdataexport .setId( jsonObject.getString("_id"));
		    }}
			
			if(jsonObject.isNull("_itemHeader")){
				billingdataexport.setCreatedDate(null);
			}else {
				JSONObject communication6=jsonObject.getJSONObject("_itemHeader");
				if(!communication6.opt("createdDate").equals(null)){
					billingdataexport.setCreatedDate(communication6.getString("createdDate"));
				}}
			
			BillingDataExportDao.insertBillingData(databaseName,billingdataexport);
			
			
			
			
		}
	}
}
	
}

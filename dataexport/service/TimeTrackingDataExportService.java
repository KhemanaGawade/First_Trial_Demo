package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.BillingDataExportDao;
import com.filevine.dataexport.dao.TimeTrackingDataExportDao;
import com.filevine.dataexport.domain.BillingDataExport;
import com.filevine.dataexport.domain.TimeTrackingDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TimeTrackingDataExportService {

public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/timetracking16433?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"workdone193300\",\"sortAscending\":false,\"filterField\":\"date193300\",\"filterText\":\"\"}";
		
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
	
	TimeTrackingDataExport timetrackingdataexport =new TimeTrackingDataExport ();
	TimeTrackingDataExportDao  timetrackingdataexportdao =new TimeTrackingDataExportDao ();
	String 	res=response;
	int i=res.indexOf('{');
	res=res.substring(i);
	
	JSONObject advanceClientData=new JSONObject(res);
	if(!advanceClientData.opt("projectID").equals(null)){
		timetrackingdataexport  .setProjectId(advanceClientData.getString("projectID"));
	}
	
	JSONObject data=advanceClientData.getJSONObject("data");
	
	if(!data.opt("collection").equals(null)) {
		JSONArray communication=data.getJSONArray("collection");
		for(int j=0; j<=communication.length()-1; j++) {
			JSONObject jsonObject=communication.getJSONObject(j);
	
			if(jsonObject.isNull("timeworked193300")) {
				timetrackingdataexport  .setTimeWorked( null);
			}else {
				
		    if(!jsonObject.opt("timeworked193300").equals(null)){
		    	timetrackingdataexport .setTimeWorked( jsonObject.getString("timeworked193300"));
		    }}
	
			if(jsonObject.isNull("date193300")) {
				timetrackingdataexport .setDate( null);
			}else {
				
		    if(!jsonObject.opt("date193300").equals(null)){
		    	timetrackingdataexport .setDate( jsonObject.getString("date193300"));
		    }}
	
			if(jsonObject.isNull("workdone193300")) {
				timetrackingdataexport .setWorkDone( null);
			}else {
				
		    if(!jsonObject.opt("workdone193300").equals(null)){
		    	timetrackingdataexport .setWorkDone( jsonObject.getString("workdone193300"));
		    }}
	
//			if(jsonObject.isNull("_id")) {
//				billingdataexport .setDate( null);
//			}else {
//				
//		    if(!jsonObject.opt("_id").equals(null)){
//		    	billingdataexport .setDate( jsonObject.getString("_id"));
//		    }}
			if(jsonObject.isNull("user193300")){
				timetrackingdataexport .setUserId(null);
			}else {
				JSONObject communication6=jsonObject.getJSONObject("user193300");
				if(!communication6.opt("id").equals(null)){
					timetrackingdataexport .setUserId(communication6.getString("id"));
				}}
			
			if(jsonObject.isNull("user193300")){
				timetrackingdataexport .setUserFullName(null);
			}else {
				JSONObject communication6=jsonObject.getJSONObject("user193300");
				if(!communication6.opt("fullname").equals(null)){
					timetrackingdataexport .setUserFullName(communication6.getString("fullname"));
				}}
			
			
			
			if(jsonObject.isNull("_id")) {
				timetrackingdataexport  .setId( null);
			}else {
				
		    if(!jsonObject.opt("_id").equals(null)){
		    	timetrackingdataexport  .setId( jsonObject.getString("_id"));
		    }}
			
			if(jsonObject.isNull("_itemHeader")){
				timetrackingdataexport .setCreatedDate(null);
			}else {
				JSONObject communication6=jsonObject.getJSONObject("_itemHeader");
				if(!communication6.opt("createdDate").equals(null)){
					timetrackingdataexport.setCreatedDate(communication6.getString("createdDate"));
				}}
			
			timetrackingdataexportdao .insertBillingData(databaseName,timetrackingdataexport);
			
			
			
			
		}
	}
}
	
	
	
	
	
	
	
	
	
	
}

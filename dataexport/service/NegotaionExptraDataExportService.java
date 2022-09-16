package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.NegotaionExptraDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.NegotaionExptraDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class NegotaionExptraDataExportService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/negotiations16407?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"date191313\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
		
		NegotaionExptraDataExport negotaionexptradataexport=new NegotaionExptraDataExport();
		NegotaionExptraDataExportDao negotaionexptradataexportdao=new NegotaionExptraDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			negotaionexptradataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		
  JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
				
				
	
				if(jsonObject.isNull("party191313")){
					negotaionexptradataexport.setPartyId(null);
				}else {
					JSONObject communication5=jsonObject.getJSONObject("party191313");
					if(!communication5.opt("id").equals(null)){
						negotaionexptradataexport.setPartyId(communication5.getString("id"));
					}}
				
				if(jsonObject.isNull("party191313")){
					negotaionexptradataexport.setOrgId(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("party191313");
					if(!communication6.opt("orgID").equals(null)){
						negotaionexptradataexport.setOrgId(communication6.getString("orgID"));
					}}
	
				if(jsonObject.isNull("party191313")){
					negotaionexptradataexport.setPartyFullName(null);
				}else {
					JSONObject communication7=jsonObject.getJSONObject("party191313");
					if(!communication7.opt("fullname").equals(null)){
						negotaionexptradataexport.setPartyFullName(communication7.getString("fullname"));
					}}
				
				if(jsonObject.isNull("_id")) {
					negotaionexptradataexport.setUniqueId( null);
				}else {
					
			    if(!jsonObject.opt("_id").equals(null)){
			    	negotaionexptradataexport.setUniqueId( jsonObject.getString("_id"));
			    }}
				negotaionexptradataexportdao.insertNegotaionExptraData(databaseName,negotaionexptradataexport);
	
	
			}
		}
	}
	
}

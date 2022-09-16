package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.ChildernDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.ChildernDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ChildernDataExportService {

	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/children16433?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"fulllegalname191743\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
		
		ChildernDataExport  childerndataexport =new ChildernDataExport ();
		ChildernDataExportDao  childerndataexportdao =new ChildernDataExportDao ();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			childerndataexport .setProjectId(advanceClientData.getString("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				if(jsonObject.isNull("fulllegalname191743")) {
					childerndataexport .setFullLegalName( null);
				}else {
					
			    if(!jsonObject.opt("fulllegalname191743").equals(null)){
			    	childerndataexport .setFullLegalName( jsonObject.getString("fulllegalname191743"));
			    }}
		
				if(jsonObject.isNull("childsdateofbirth191743")) {
					childerndataexport .setChildsDateOfBirth( null);
				}else {
					
			    if(!jsonObject.opt("childsdateofbirth191743").equals(null)){
			    	childerndataexport .setChildsDateOfBirth( jsonObject.getString("childsdateofbirth191743"));
			    }}
		
				if(jsonObject.isNull("_id")) {
					childerndataexport .setChildrenId( null);
				}else {
					
			    if(!jsonObject.opt("_id").equals(null)){
			    	childerndataexport .setChildrenId( jsonObject.getString("_id"));
			    }}
				
				
				if(jsonObject.isNull("_itemHeader")){
					childerndataexport.setCreatedDate(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("_itemHeader");
					if(!communication6.opt("createdDate").equals(null)){
						childerndataexport.setCreatedDate(communication6.getString("createdDate"));
					}}
				
			
				if(jsonObject.isNull("generalnotesaboutchild191743")) {
					childerndataexport .setGeneralNotes( null);
				}else {
					
			    if(!jsonObject.opt("generalnotesaboutchild191743").equals(null)){
			    	childerndataexport .setGeneralNotes( jsonObject.getString("generalnotesaboutchild191743"));
			    }}
	
//				if(jsonObject.isNull("citystateofbirth191743")) {
//					childerndataexport .setBirthCity( null);
//				}else {
//					
//			    if(!jsonObject.opt("citystateofbirth191743").equals(null)){
//			    	childerndataexport .setBirthCity( jsonObject.getString("citystateofbirth191743"));
//			    }}
//				
//				if(jsonObject.isNull("childislivingwith191743")){
//					childerndataexport.setChildisLivingWith(null);
//				}else {
//					JSONObject communication6=jsonObject.getJSONObject("childislivingwith191743");
//					if(!communication6.opt("id").equals(null)){
//						childerndataexport.setChildisLivingWith(communication6.getString("id"));
//					}}
				
				
				childerndataexportdao .insertChildernData(databaseName,childerndataexport);
	
			}
		}
	}
	
	
}

package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.LiensExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.LiensExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LiensExportService {

	public String getLiensExportResponse(String cookie,String projectID) {
		
		String response=null;
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/liens1032?page=1";
	
	String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"lienholder14185\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	
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
	
	
	public void getLiensExportData(String response, String databaseName) throws JSONException, SQLException {
	
		LiensExport liensexport=new LiensExport();
		LiensExportDao liensexportdao=new LiensExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject liensexportData=new JSONObject(res);
		if(!liensexportData.opt("projectID").equals(null)){
			liensexport.setProjectId(liensexportData.getInt("projectID"));
		}
	
		JSONObject data=liensexportData.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
			JSONArray liens=data.getJSONArray("collection");
			for(int j=0; j<=liens.length()-1; j++) {
				JSONObject jsonObject=liens.getJSONObject(j);
		
				if(jsonObject.isNull("typeoflien14185")) {
					liensexport.setTypeOfLien( null);
				}else {
					
			    if(!jsonObject.opt("typeoflien14185").equals(null)){
			    	liensexport.setTypeOfLien( jsonObject.getString("typeoflien14185"));
			    }}
				if(jsonObject.isNull("referencenumber14185")) {
					liensexport.setReferenceNumber( null);
				}else {
					
			    if(!jsonObject.opt("referencenumber14185").equals(null)){
			    	liensexport.setReferenceNumber( jsonObject.getString("referencenumber14185"));
			    }}
				
				if(jsonObject.isNull("noticedatereceived14185")) {
					liensexport.setNoticeDateReceived( null);
				}else {
					
			    if(!jsonObject.opt("noticedatereceived14185").equals(null)){
			    	liensexport.setNoticeDateReceived( jsonObject.getString("noticedatereceived14185"));
			    }}
				
				if(jsonObject.isNull("amount14185")) {
					liensexport.setAmount( null);
				}else {
					
			    if(!jsonObject.opt("amount14185").equals(null)){
			    	liensexport.setAmount( jsonObject.getString("amount14185"));
			    }}
				
				
				if(jsonObject.isNull("finallienreceiveddate14185")) {
					liensexport.setFinallienReceivedDate( null);
				}else {
					
			    if(!jsonObject.opt("finallienreceiveddate14185").equals(null)){
			    	liensexport.setFinallienReceivedDate( jsonObject.getString("finallienreceiveddate14185"));
			    }}
				
				if(jsonObject.isNull("letterofrepsentdate14185")) {
					liensexport.setLetterOfRepsentDate( null);
				}else {
					
			    if(!jsonObject.opt("letterofrepsentdate14185").equals(null)){
			    	liensexport.setLetterOfRepsentDate( jsonObject.getString("letterofrepsentdate14185"));
			    }}
				
				if(jsonObject.isNull("reduction14185")) {
					liensexport.setReduction( null);
				}else {
					
			    if(!jsonObject.opt("reduction14185").equals(null)){
			    	liensexport.setReduction( jsonObject.getString("reduction14185"));
			    }}
				if(jsonObject.isNull("notes14185")) {
					liensexport.setNotes( null);
				}else {
					
			    if(!jsonObject.opt("notes14185").equals(null)){
			    	liensexport.setNotes( jsonObject.getString("notes14185"));
			    }}
				
			
				if(jsonObject.isNull("lienholder14185")){
					liensexport.setLienholder(null);
				}else {
					JSONObject communication5=jsonObject.getJSONObject("lienholder14185");
					if(!communication5.opt("fullname").equals(null)){
						liensexport.setLienholder(communication5.getString("fullname"));
					}}
				
				if(jsonObject.isNull("recoveryagency14185")){
					liensexport.setRecoveryAgency(null);
				}else {
					JSONObject communication60=jsonObject.getJSONObject("recoveryagency14185");
					if(!communication60.opt("fullname").equals(null)){
						liensexport.setRecoveryAgency(communication60.getString("fullname"));
					}}
				
				if(jsonObject.isNull("recoveryagent14185")){
					liensexport.setRecoveryAgent(null);
				}else {
					JSONObject communication5=jsonObject.getJSONObject("recoveryagent14185");
					if(!communication5.opt("fullname").equals(null)){
						liensexport.setRecoveryAgent(communication5.getString("fullname"));
					}}
				
				if(jsonObject.isNull("documents14185")){
					liensexport.setDocumentsId(null);
				}else {
					JSONArray communication3=jsonObject.getJSONArray("documents14185");
					for(int k=0; k<=communication3.length()-1; k++) {
					JSONObject jsonobject=communication3.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					liensexport.setDocumentsId(jsonobject.getString("id"));
				}}}
				
				
				if(jsonObject.isNull("documents14185")){
					liensexport.setDocumentsFileName(null);
				}else {
					JSONArray communication12=jsonObject.getJSONArray("documents14185");
					for(int k=0; k<=communication12.length()-1; k++) {
					JSONObject jsonobject=communication12.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					liensexport.setDocumentsFileName(jsonobject.getString("filename"));
				}}}
				
				
				
				
				
				
				liensexportdao.insertLiensExportData(databaseName,liensexport);
				
}
}
	}
}
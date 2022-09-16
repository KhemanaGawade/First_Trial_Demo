package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.EmailDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.EmailDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class EmailDataExportService {

	public String getEmailDataExportResponse(String cookie, String projectID) {
		
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/mailroom1032?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	
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
		
		 EmailDataExportDao emaildataexportdao=new EmailDataExportDao();
		 EmailDataExport emaildataexport=new EmailDataExport();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			emaildataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
	
           JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				if(jsonObject.isNull("type37274")) {
					emaildataexport.setType( null);
				}else {
					
			    if(!jsonObject.opt("type37274").equals(null)){
			    	emaildataexport.setType( jsonObject.getString("type37274"));
			    }}
		
				if(jsonObject.isNull("datesent37274")) {
					emaildataexport.setDateSent( null);
				}else {
					
			    if(!jsonObject.opt("datesent37274").equals(null)){
			    	emaildataexport.setDateSent( jsonObject.getString("datesent37274"));
			    }}
		
	
				if(jsonObject.isNull("datereceived37274")) {
					emaildataexport.setDateReceived( null);
				}else {
					
			    if(!jsonObject.opt("datereceived37274").equals(null)){
			    	emaildataexport.setDateReceived( jsonObject.getString("datereceived37274"));
			    }}
		
				
				if(jsonObject.isNull("from37274")){
					emaildataexport.setFrom(null);
				}else {
					JSONObject communication1=jsonObject.getJSONObject("from37274");
					if(!communication1.opt("fullname").equals(null)){
						emaildataexport.setFrom(communication1.getString("fullname"));
					}}
				
				if(jsonObject.isNull("to37274")){
					emaildataexport.setTo(null);
				}else {
					JSONObject communication2=jsonObject.getJSONObject("to37274");
					if(!communication2.opt("fullname").equals(null)){
						emaildataexport.setTo(communication2.getString("fullname"));
					}}
				
				if(jsonObject.isNull("description37274")) {
					emaildataexport.setDescription( null);
				}else {
					
			    if(!jsonObject.opt("description37274").equals(null)){
			    	emaildataexport.setDescription( jsonObject.getString("description37274"));
			    }}
				
				if(jsonObject.isNull("mailfaxdocs37274")){
					emaildataexport.setMailfaxDocsId(null);
				}else {
					JSONObject communication2=jsonObject.getJSONObject("mailfaxdocs37274");
					if(!communication2.opt("id").equals(null)){
						emaildataexport.setMailfaxDocsId(communication2.getString("id"));
					}}
				
				if(jsonObject.isNull("mailfaxdocs37274")){
					emaildataexport.setMailfaxDocsName(null);
				}else {
					JSONObject communication2=jsonObject.getJSONObject("mailfaxdocs37274");
					if(!communication2.opt("filename").equals(null)){
						emaildataexport.setMailfaxDocsName(communication2.getString("filename"));
					}}
				
				emaildataexportdao.insertEmailDataExportData(databaseName,emaildataexport);	
			}			
		}			
}
}
package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.LegalResearchDataExportDao;
import com.filevine.dataexport.domain.LegalResearchDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LegalResearchDataExportService {

	
	public String getLegalResearchDataExportResponse(String cookie, String projectID) {
		
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/legalresearch1032?page=1";
		
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
		
		LegalResearchDataExport legalresearchdataexport=new LegalResearchDataExport();
		LegalResearchDataExportDao legalresearchdataexportdao=new LegalResearchDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			legalresearchdataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
	
		JSONObject data=advanceClientData.getJSONObject("data");
	
		if(data.isNull("customObject")) {
			System.out.println("No data found");
		}else {
		JSONObject jsonData=data.getJSONObject("customObject");
	
		if(jsonData.isNull("researchtype17260")) {
			legalresearchdataexport.setResearchType( null);
			}else {
				
		    if(!jsonData.opt("researchtype17260").equals(null)){
		    	legalresearchdataexport.setResearchType( jsonData.getString("researchtype17260"));
		 }} 
		
		if(jsonData.isNull("researchdate17260")) {
			legalresearchdataexport.setResearchDate( null);
			}else {
				
		    if(!jsonData.opt("researchdate17260").equals(null)){
		    	legalresearchdataexport.setResearchDate( jsonData.getString("researchdate17260"));
		 }} 
		
		if(jsonData.isNull("notes17260")) {
			legalresearchdataexport.setNotes( null);
			}else {
				
		    if(!jsonData.opt("notes17260").equals(null)){
		    	legalresearchdataexport.setNotes( jsonData.getString("notes17260"));
		 }} 
		
		legalresearchdataexportdao.insertLegalResearchData(databaseName,legalresearchdataexport);
		
		}
	}
}


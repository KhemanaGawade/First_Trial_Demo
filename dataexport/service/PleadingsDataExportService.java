package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.PleadingsDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.PleadingsDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class PleadingsDataExportService {

	public String getPleadingsDataExportResponse(String cookie,String projectID) {
	
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/pleadings1032?page=1";
	
	   String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"dateservedfiled14192\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	
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
		
		PleadingsDataExport pleadingsdataexport=new PleadingsDataExport();
		PleadingsDataExportDao pleadingsdataexportdao=new PleadingsDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			pleadingsdataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
	
	JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				if(jsonObject.isNull("partyservingfilingpleading14192")) {
					pleadingsdataexport.setPartyServingFilingPleading( null);
				}else {
					
			    if(!jsonObject.opt("partyservingfilingpleading14192").equals(null)){
			    	pleadingsdataexport.setPartyServingFilingPleading( jsonObject.getString("partyservingfilingpleading14192"));
			    }}
	
				if(jsonObject.isNull("pleadingtype14192")) {
					pleadingsdataexport.setPleadingType( null);
				}else {
					
			    if(!jsonObject.opt("pleadingtype14192").equals(null)){
			    	pleadingsdataexport.setPleadingType( jsonObject.getString("pleadingtype14192"));
			    }}
	
				if(jsonObject.isNull("pleadingname14192")) {
					pleadingsdataexport.setPleadingName( null);
				}else {
					
			    if(!jsonObject.opt("pleadingname14192").equals(null)){
			    	pleadingsdataexport.setPleadingName( jsonObject.getString("pleadingname14192"));
			    }}
				
				if(jsonObject.isNull("defendant14192")){
					pleadingsdataexport.setParty(null);
				}else {
				JSONObject communication2=jsonObject.getJSONObject("defendant14192");
				if(!communication2.opt("fullname").equals(null)){
					pleadingsdataexport.setParty(communication2.getString("fullname"));
				}}
	
//				if(jsonObject.isNull("defendant14192")) {
//					pleadingsdataexport.setDefendant( null);
//				}else {
//					
//			    if(!jsonObject.opt("defendant14192").equals(null)){
//			    	pleadingsdataexport.setDefendant( jsonObject.getString("defendant14192"));
//			    }}
	
				if(jsonObject.isNull("dateservedfiled14192")) {
					pleadingsdataexport.setDateFiled( null);
				}else {
					
			    if(!jsonObject.opt("dateservedfiled14192").equals(null)){
			    	pleadingsdataexport.setDateFiled( jsonObject.getString("dateservedfiled14192"));
			    }}
	
				if(jsonObject.isNull("hearingset14192")) {
					pleadingsdataexport.setHearingSet( null);
				}else {
					
			    if(!jsonObject.opt("hearingset14192").equals(null)){
			    	pleadingsdataexport.setHearingSet( jsonObject.getString("hearingset14192"));
			    }}
	
				if(jsonObject.isNull("ordertendered14192")) {
					pleadingsdataexport.setOrderTendered( null);
				}else {
					
			    if(!jsonObject.opt("ordertendered14192").equals(null)){
			    	pleadingsdataexport.setOrderTendered( jsonObject.getString("ordertendered14192"));
			    }}
	
				if(jsonObject.isNull("notes14192")) {
					pleadingsdataexport.setNotes( null);
				}else {
					
			    if(!jsonObject.opt("notes14192").equals(null)){
			    	pleadingsdataexport.setNotes( jsonObject.getString("notes14192"));
			    }}
				
				
				if(jsonObject.isNull("dateserved14192")) {
					pleadingsdataexport.setDateServed( null);
				}else {
					
			    if(!jsonObject.opt("dateserved14192").equals(null)){
			    	pleadingsdataexport.setDateServed( jsonObject.getString("dateserved14192"));
			    }}
				
				if(jsonObject.isNull("party14192")){
					pleadingsdataexport.setParty(null);
				}else {
				JSONObject communication1=jsonObject.getJSONObject("party14192");
				if(!communication1.opt("fullname").equals(null)){
					pleadingsdataexport.setParty(communication1.getString("fullname"));
				}}
				
				if(jsonObject.isNull("documents14192")){
					pleadingsdataexport.setDocumentsId(null);
				}else {
					JSONArray communication12=jsonObject.getJSONArray("documents14192");
					for(int k=0; k<=communication12.length()-1; k++) {
					JSONObject jsonobject=communication12.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					pleadingsdataexport.setDocumentsId(jsonobject.getString("id"));
				}}}
				
				if(jsonObject.isNull("documents14192")){
					pleadingsdataexport.setDocumentsFileName(null);
				}else {
					JSONArray communication13=jsonObject.getJSONArray("documents14192");
					for(int k=0; k<=communication13.length()-1; k++) {
					JSONObject jsonobject=communication13.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					pleadingsdataexport.setDocumentsFileName(jsonobject.getString("filename"));
				}}}
				
				
				
				
				
				pleadingsdataexportdao.insertPleadingsData(databaseName,pleadingsdataexport);	
				
			}
			
		}
				
			}				
}

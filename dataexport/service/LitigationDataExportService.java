package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.LitigationDataExportDao;

import com.filevine.dataexport.domain.LitigationDataExports;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LitigationDataExportService {

	public String getLitigationDataExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/litigation1032?page=1";
	
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

	
	public void getLitigationData(String response, String databaseName) throws JSONException, SQLException {
		
		LitigationDataExports  litigationdataexports =new LitigationDataExports ();
		LitigationDataExportDao litigationdataexportdao=new LitigationDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
	
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			litigationdataexports.setProjectId(advanceClientData.getInt("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
	
		if(data.isNull("customObject")) {
			System.out.println("No data found");
		}else {
		JSONObject jsonData=data.getJSONObject("customObject");
	
		if(jsonData.isNull("captionplaintiffs14186")) {
			litigationdataexports.setCaptionPlainTiffs( null);
			}else {
				
		    if(!jsonData.opt("captionplaintiffs14186").equals(null)){
		    	litigationdataexports.setCaptionPlainTiffs( jsonData.getString("captionplaintiffs14186"));
		 }} 
	
		if(jsonData.isNull("captiondefendants14186")) {
			litigationdataexports.setCaptionDefendants( null);
			}else {
				
		    if(!jsonData.opt("captiondefendants14186").equals(null)){
		    	litigationdataexports.setCaptionDefendants( jsonData.getString("captiondefendants14186"));
		 }} 
	
		if(jsonData.isNull("datefiled14186")) {
			litigationdataexports.setDateFiled( null);
			}else {
				
		    if(!jsonData.opt("datefiled14186").equals(null)){
		    	litigationdataexports.setDateFiled( jsonData.getString("datefiled14186"));
		 }} 
	
		if(jsonData.isNull("county14186")) {
			litigationdataexports.setCounty( null);
			}else {
				
		    if(!jsonData.opt("county14186").equals(null)){
		    	litigationdataexports.setCounty( jsonData.getString("county14186"));
		 }} 
	
		if(jsonData.isNull("judicialdistrict14186")) {
			litigationdataexports.setJudicialDistrict( null);
			}else {
				
		    if(!jsonData.opt("judicialdistrict14186").equals(null)){
		    	litigationdataexports.setJudicialDistrict( jsonData.getString("judicialdistrict14186"));
		 }} 
	
		if(jsonData.isNull("case14186")) {
			litigationdataexports.setCase( null);
			}else {
				
		    if(!jsonData.opt("case14186").equals(null)){
		    	litigationdataexports.setCase( jsonData.getString("case14186"));
		 }} 
		
		if(jsonData.isNull("courthouse14186")) {
			litigationdataexports.setCourtHouse( null);
			}else {
				
		    if(!jsonData.opt("courthouse14186").equals(null)){
		    	litigationdataexports.setCourtHouse( jsonData.getString("courthouse14186"));
		 }} 
		
		if(jsonData.isNull("judge14186")) {
			litigationdataexports.setJudge( null);
			}else {
				
		    if(!jsonData.opt("judge14186").equals(null)){
		    	litigationdataexports.setJudge( jsonData.getString("judge14186"));
		 }} 
		
		if(jsonData.isNull("casemanagementconferencesetfor14186")) {
			litigationdataexports.setCaseManagementConferenceSetFor( null);
			}else {
				
		    if(!jsonData.opt("casemanagementconferencesetfor14186").equals(null)){
		    	litigationdataexports.setCaseManagementConferenceSetFor( jsonData.getString("casemanagementconferencesetfor14186"));
		 }} 
		
		if(jsonData.isNull("timeofcmc14186")) {
			litigationdataexports.setTimeofCmc( null);
			}else {
				
		    if(!jsonData.opt("timeofcmc14186").equals(null)){
		    	litigationdataexports.setTimeofCmc( jsonData.getString("timeofcmc14186"));
		 }} 
		
		if(jsonData.isNull("cmclocation14186")) {
			litigationdataexports.setCmcLocation( null);
			}else {
				
		    if(!jsonData.opt("cmclocation14186").equals(null)){
		    	litigationdataexports.setCmcLocation( jsonData.getString("cmclocation14186"));
		 }} 
		
		if(jsonData.isNull("casemanagementorderreceived14186")) {
			litigationdataexports.setCaseManagementOrderReceived( null);
			}else {
				
		    if(!jsonData.opt("casemanagementorderreceived14186").equals(null)){
		    	litigationdataexports.setCaseManagementOrderReceived( jsonData.getString("casemanagementorderreceived14186"));
		 }} 
		
		if(jsonData.isNull("mandatorysettlementconferencesetfor14186")) {
			litigationdataexports.setMandatorySettlementConferenceSetFor( null);
			}else {
				
		    if(!jsonData.opt("mandatorysettlementconferencesetfor14186").equals(null)){
		    	litigationdataexports.setMandatorySettlementConferenceSetFor( jsonData.getString("mandatorysettlementconferencesetfor14186"));
		 }} 
		
		if(jsonData.isNull("timeofmsc14186")) {
			litigationdataexports.setTimeOfMsc( null);
			}else {
				
		    if(!jsonData.opt("timeofmsc14186").equals(null)){
		    	litigationdataexports.setTimeOfMsc( jsonData.getString("timeofmsc14186"));
		 }} 
		
		if(jsonData.isNull("msclocation14186")) {
			litigationdataexports.setMscLocation( null);
			}else {
				
		    if(!jsonData.opt("msclocation14186").equals(null)){
		    	litigationdataexports.setMscLocation( jsonData.getString("msclocation14186"));
		 }} 
		
		litigationdataexportdao.insertLitigationData(databaseName,litigationdataexports);
		
		}
	
		}
	
}

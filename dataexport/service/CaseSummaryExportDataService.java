package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.CaseSummaryExportDataDao;

import com.filevine.dataexport.domain.CaseSummaryExportData;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CaseSummaryExportDataService {

	public String getCaseSummaryExportResponse(String cookie, String projectID) {
	
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/casesummary1032?page=1";
	
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
	
	public void getCaseSummaryData(String response, String databaseName) throws JSONException, SQLException {
		
		CaseSummaryExportData casesummaryexportdata=new CaseSummaryExportData();
		CaseSummaryExportDataDao casesummaryexportdatadao=new CaseSummaryExportDataDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject casesummaryData=new JSONObject(res);
		if(!casesummaryData.opt("projectID").equals(null)){
			casesummaryexportdata.setProjectId(casesummaryData.getInt("projectID"));
		}
		
		JSONObject data=casesummaryData.getJSONObject("data");
		if(!data.isNull("customObject")) {
		JSONObject jsonObject=data.getJSONObject("customObject");
 	
		if(jsonObject.isNull("judge14176")){
			casesummaryexportdata.setJudge(null);
		}else {
			JSONObject communication13=jsonObject.getJSONObject("judge14176");
			if(!communication13.opt("fullname").equals(null)){
				casesummaryexportdata.setJudge(communication13.getString("fullname"));
			}}
		
		
		if(jsonObject.isNull("courthouse14176")){
			casesummaryexportdata.setCourthouse(null);
		}else {
			JSONObject communication12=jsonObject.getJSONObject("courthouse14176");
			if(!communication12.opt("fullname").equals(null)){
				casesummaryexportdata.setCourthouse(communication12.getString("fullname"));
			}}
		
		
		if(jsonObject.isNull("case14176")) {
        	casesummaryexportdata.setCase( null);
			}else {
				
		    if(!jsonObject.opt("case14176").equals(null)){
		    	casesummaryexportdata.setCase( jsonObject.getString("case14176"));
		 }} 
		
		if(jsonObject.isNull("county14176")) {
        	casesummaryexportdata.setCounty( null);
			}else {
				
		    if(!jsonObject.opt("county14176").equals(null)){
		    	casesummaryexportdata.setCounty( jsonObject.getString("county14176"));
		 }} 
		

		
		if(jsonObject.isNull("schedulingorder14176")){
			casesummaryexportdata.setSchedulingOrder(null);
		}else {
			JSONObject communication14=jsonObject.getJSONObject("schedulingorder14176");
			if(!communication14.opt("filename").equals(null)){
				casesummaryexportdata.setSchedulingOrder(communication14.getString("filename"));
			}}
		
		
		if(jsonObject.isNull("typeofcourt14176")) {
			casesummaryexportdata.setTypeOfCourt( null);
		}else {
			
	    if(!jsonObject.opt("typeofcourt14176").equals(null)){
	    	casesummaryexportdata.setTypeOfCourt( jsonObject.getString("typeofcourt14176"));
	    }}
		
		if(jsonObject.isNull("legalassistant14176")){
			casesummaryexportdata.setLegalAssistant(null);
		}else {
			JSONObject communication9=jsonObject.getJSONObject("legalassistant14176");
			if(!communication9.opt("fullname").equals(null)){
				casesummaryexportdata.setLegalAssistant(communication9.getString("fullname"));
			}}
		
		if(jsonObject.isNull("primaryattorney14176")){
			casesummaryexportdata.setPrimaryAttorney(null);
		}else {
			JSONObject communication6=jsonObject.getJSONObject("primaryattorney14176");
			if(!communication6.opt("fullname").equals(null)){
				casesummaryexportdata.setPrimaryAttorney(communication6.getString("fullname"));
			}}
		
		if(jsonObject.isNull("assignedparalegal14176")){
			casesummaryexportdata.setAssignedParalegal(null);
		}else {
			JSONObject communication7=jsonObject.getJSONObject("assignedparalegal14176");
			if(!communication7.opt("fullname").equals(null)){
				casesummaryexportdata.setAssignedParalegal(communication7.getString("fullname"));
			}}
		
		if(jsonObject.isNull("statuteoflimitations14176")){
			casesummaryexportdata.setStatuteOfLimitationsDueDate(null);
		}else {
			JSONObject communication8=jsonObject.getJSONObject("statuteoflimitations14176");
			if(!communication8.opt("dateValue").equals(null)){
				casesummaryexportdata.setStatuteOfLimitationsDueDate(communication8.getString("dateValue"));
			}}
		
		if(jsonObject.isNull("statuteoflimitations14176")){
			casesummaryexportdata.setStatuteOfLimitationsDoneDate(null);
		}else {
			JSONObject communication9=jsonObject.getJSONObject("statuteoflimitations14176");
			if(!communication9.opt("doneDate").equals(null)){
				casesummaryexportdata.setStatuteOfLimitationsDoneDate(communication9.getString("doneDate"));
			}}
		
		if(jsonObject.isNull("secondstatuteoflimitations14176")){
			casesummaryexportdata.setSecondstatuteOfLimitationsDueDate(null);
		}else {
			JSONObject communication8=jsonObject.getJSONObject("secondstatuteoflimitations14176");
			if(!communication8.opt("dateValue").equals(null)){
				casesummaryexportdata.setSecondstatuteOfLimitationsDueDate(communication8.getString("dateValue"));
			}}
		
		
		if(jsonObject.isNull("secondstatuteoflimitations14176")){
			casesummaryexportdata.setSecondStatuteOfLimitationsDoneDate(null);
		}else {
			JSONObject communication9=jsonObject.getJSONObject("secondstatuteoflimitations14176");
			if(!communication9.opt("doneDate").equals(null)){
				casesummaryexportdata.setSecondStatuteOfLimitationsDoneDate(communication9.getString("doneDate"));
			}}
		
		if(jsonObject.isNull("projectedsettlementdate14176")) {
        	casesummaryexportdata.setProjectedRecoveryDate( null);
			}else {
				
		    if(!jsonObject.opt("projectedsettlementdate14176").equals(null)){
		    	casesummaryexportdata.setProjectedRecoveryDate( jsonObject.getString("projectedsettlementdate14176"));
		 }}
		
		if(jsonObject.isNull("projectedsettlementgoal14176")) {
        	casesummaryexportdata.setProjectedRecoveryGoal( null);
			}else {
				
		    if(!jsonObject.opt("projectedsettlementgoal14176").equals(null)){
		    	casesummaryexportdata.setProjectedRecoveryGoal( jsonObject.getString("projectedsettlementgoal14176"));
		 }}
		
		if(jsonObject.isNull("presuitorsuitfiled14176")) {
        	casesummaryexportdata.setPresuitOrSuitFiled( null);
			}else {
				
		    if(!jsonObject.opt("presuitorsuitfiled14176").equals(null)){
		    	casesummaryexportdata.setPresuitOrSuitFiled( jsonObject.getString("presuitorsuitfiled14176"));
		 }}
		
		if(jsonObject.isNull("settled14176")) {
        	casesummaryexportdata.setSettled( null);
			}else {
				
		    if(!jsonObject.opt("settled14176").equals(null)){
		    	casesummaryexportdata.setSettled( jsonObject.getString("settled14176"));
		 }}
		
		if(jsonObject.isNull("co-counselfees14176")) {
        	casesummaryexportdata.setCoCounselFees( null);
			}else {
				
		    if(!jsonObject.opt("co-counselfees14176").equals(null)){
		    	casesummaryexportdata.setCoCounselFees( jsonObject.getString("co-counselfees14176"));
		 }}
		
		if(jsonObject.isNull("partialsettlement14176")) {
        	casesummaryexportdata.setPartialSettlement(null);
			}else {
				
		    if(!jsonObject.opt("partialsettlement14176").equals(null)){
		    	casesummaryexportdata.setPartialSettlement( jsonObject.getString("partialsettlement14176"));
		 }}
		

		if(jsonObject.isNull("verdict14176")) {
        	casesummaryexportdata.setVerdict( false);
			}else {
				
		    if(!jsonObject.opt("verdict14176").equals(null)){
		    	casesummaryexportdata.setVerdict( jsonObject.getBoolean("verdict14176"));
		 }}
		
		if(jsonObject.isNull("casefeesamount14176")) {
        	casesummaryexportdata.setCaseFeesAmount( null);
			}else {
				
		    if(!jsonObject.opt("casefeesamount14176").equals(null)){
		    	casesummaryexportdata.setCaseFeesAmount( jsonObject.getString("casefeesamount14176"));
		 }}
		
		if(jsonObject.isNull("casefeesdetails14176")) {
        	casesummaryexportdata.setCaseFeesDetails( null);
			}else {
				
		    if(!jsonObject.opt("casefeesdetails14176").equals(null)){
		    	casesummaryexportdata.setCaseFeesDetails( jsonObject.getString("casefeesdetails14176"));
		 }}
		
		if(jsonObject.isNull("clientdispersaldate14176")) {
        	casesummaryexportdata.setClientDispersalDate( null);
			}else {
				
		    if(!jsonObject.opt("clientdispersaldate14176").equals(null)){
		    	casesummaryexportdata.setClientDispersalDate( jsonObject.getString("clientdispersaldate14176"));
		 }}
		
		if(jsonObject.isNull("casenotes114176")) {
        	casesummaryexportdata.setCaseNotes1( null);
			}else {
				
		    if(!jsonObject.opt("casenotes114176").equals(null)){
		    	casesummaryexportdata.setCaseNotes1( jsonObject.getString("casenotes114176"));
		 }}
		
		if(jsonObject.isNull("casenotes214176")) {
        	casesummaryexportdata.setCaseNotes2( null);
			}else {
				
		    if(!jsonObject.opt("casenotes214176").equals(null)){
		    	casesummaryexportdata.setCaseNotes2( jsonObject.getString("casenotes214176"));
		 }}
		
		if(jsonObject.isNull("partialsettlementamount14176")) {
    	casesummaryexportdata.setPartialSettlementAmount( null);
		}else {
			
	    if(!jsonObject.opt("partialsettlementamount14176").equals(null)){
	    	casesummaryexportdata.setPartialSettlementAmount( jsonObject.getString("partialsettlementamount14176"));
	 }}
	if(jsonObject.isNull("partialsettlementdate14176")) {
    	casesummaryexportdata.setPartialSettlementDate( null);
		}else {
			
	    if(!jsonObject.opt("partialsettlementdate14176").equals(null)){
	    	casesummaryexportdata.setPartialSettlementDate( jsonObject.getString("partialsettlementdate14176"));
	 }}
	
            casesummaryexportdatadao.insertCaseSummaryData(databaseName,casesummaryexportdata);
		} 
            
	       
            
            
            
}
}
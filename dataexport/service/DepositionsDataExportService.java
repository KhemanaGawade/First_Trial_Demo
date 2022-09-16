package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DepositionsDataExportDao;
import com.filevine.dataexport.dao.DiscoveryDataExportDao;
import com.filevine.dataexport.domain.DepositionsDataExport;
import com.filevine.dataexport.domain.DiscoveryDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class DepositionsDataExportService {

public String getDepositionsDataExportResponse(String cookie,String projectID) {
		
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/depositions1032?page=1";
				
	  String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"deponent14180\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	

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
	
	
public void getDepositionsData(String response, String databaseName) throws JSONException, SQLException {
	
	DepositionsDataExport  depositionsdataexport =new DepositionsDataExport ();
	DepositionsDataExportDao depositionsdataexportdao=new DepositionsDataExportDao();
	String 	res=response;
	int i=res.indexOf('{');
	res=res.substring(i);
	
	
	JSONObject advanceClientData=new JSONObject(res);
	if(!advanceClientData.opt("projectID").equals(null)){
		depositionsdataexport.setProjectId(advanceClientData.getInt("projectID"));
	}
	
	JSONObject data=advanceClientData.getJSONObject("data");
	if(!data.opt("collection").equals(null)) {
		JSONArray communication=data.getJSONArray("collection");
		for(int j=0; j<=communication.length()-1; j++) {
			JSONObject jsonObject=communication.getJSONObject(j);
	
			if(jsonObject.isNull("deponent14180")){
				depositionsdataexport.setDeponent(null);
			}else {
			JSONObject communication1=jsonObject.getJSONObject("deponent14180");
			if(!communication1.opt("fullname").equals(null)){
				depositionsdataexport.setDeponent(communication1.getString("fullname"));
			}}
			if(jsonObject.isNull("ourclientexpert14180")) {
				depositionsdataexport.setOurClientExpert( null);
			}else {
				
		    if(!jsonObject.opt("ourclientexpert14180").equals(null)){
		    	depositionsdataexport.setOurClientExpert( jsonObject.getString("ourclientexpert14180"));
		    }}
	
			if(jsonObject.isNull("prepneeded14180")) {
				depositionsdataexport.setPrepNeeded( null);
			}else {
				
		    if(!jsonObject.opt("prepneeded14180").equals(null)){
		    	depositionsdataexport.setPrepNeeded( jsonObject.getString("prepneeded14180"));
		    }}

			if(jsonObject.isNull("attorneytakingdepo14180")){
				depositionsdataexport.setAttorneyTakingDefendingDepo(null);
			}else {
			JSONObject communication2=jsonObject.getJSONObject("attorneytakingdepo14180");
			if(!communication2.opt("fullname").equals(null)){
				depositionsdataexport.setAttorneyTakingDefendingDepo(communication2.getString("fullname"));
			}}
			
			if(jsonObject.isNull("dateofdepoprep14180")) {
				depositionsdataexport.setDateOfDepoPrep( null);
			}else {
				
		    if(!jsonObject.opt("dateofdepoprep14180").equals(null)){
		    	depositionsdataexport.setDateOfDepoPrep( jsonObject.getString("dateofdepoprep14180"));
		    }}

			if(jsonObject.isNull("timeofdepoprep14180")) {
				depositionsdataexport.setTimeOfDepoPrep( null);
			}else {
				
		    if(!jsonObject.opt("timeofdepoprep14180").equals(null)){
		    	depositionsdataexport.setTimeOfDepoPrep( jsonObject.getString("timeofdepoprep14180"));
		    }}

			if(jsonObject.isNull("depoprepnotes14180")) {
				depositionsdataexport.setDepoPrepNotes( null);
			}else {
				
		    if(!jsonObject.opt("depoprepnotes14180").equals(null)){
		    	depositionsdataexport.setDepoPrepNotes( jsonObject.getString("depoprepnotes14180"));
		    }}
			
			if(jsonObject.isNull("datescheduled14180")) {
				depositionsdataexport.setDateScheduled( null);
			}else {
				
		    if(!jsonObject.opt("datescheduled14180").equals(null)){
		    	depositionsdataexport.setDateScheduled( jsonObject.getString("datescheduled14180"));
		    }}
			
			if(jsonObject.isNull("time14180")) {
				depositionsdataexport.setTime( null);
			}else {
				
		    if(!jsonObject.opt("time14180").equals(null)){
		    	depositionsdataexport.setTime( jsonObject.getString("time14180"));
		    }}
			
			if(jsonObject.isNull("location14180")){
				depositionsdataexport.setLocation(null);
			}else {
			JSONObject communication6=jsonObject.getJSONObject("location14180");
			if(!communication6.opt("fullname").equals(null)){
				depositionsdataexport.setLocation(communication6.getString("fullname"));
			}}
			
			if(jsonObject.isNull("generalnotes14180")) {
				depositionsdataexport.setGeneralNotes( null);
			}else {
				
		    if(!jsonObject.opt("generalnotes14180").equals(null)){
		    	depositionsdataexport.setGeneralNotes( jsonObject.getString("generalnotes14180"));
		    }}
			

			if(jsonObject.isNull("depositiontranscriptreceipt14180")){
				depositionsdataexport.setDepositionTranscriptReceiptDueDate(null);
			}else {
			JSONObject communication6=jsonObject.getJSONObject("depositiontranscriptreceipt14180");
			if(!communication6.opt("dateValue").equals(null)){
				depositionsdataexport.setDepositionTranscriptReceiptDueDate(communication6.getString("dateValue"));
			}}
			
			if(jsonObject.isNull("depositiontranscriptreceipt14180")){
				depositionsdataexport.setDepositionTranscriptReceiptDoneDate(null);
			}else {
			JSONObject communication5=jsonObject.getJSONObject("depositiontranscriptreceipt14180");
			if(!communication5.opt("doneDate").equals(null)){
				depositionsdataexport.setDepositionTranscriptReceiptDoneDate(communication5.getString("doneDate"));
			}}
			
			
			if(jsonObject.isNull("erratasheetneeded14180")) {
				depositionsdataexport.setErrataSheetNeeded( null);
			}else {
				
		    if(!jsonObject.opt("erratasheetneeded14180").equals(null)){
		    	depositionsdataexport.setErrataSheetNeeded( jsonObject.getString("erratasheetneeded14180"));
		    }}
			
//			if(jsonObject.isNull("courtreporter14180")) {
//				depositionsdataexport.setCourtReporter( null);
//			}else {
//				
//		    if(!jsonObject.opt("courtreporter14180").equals(null)){
//		    	depositionsdataexport.setCourtReporter( jsonObject.getString("courtreporter14180"));
//		    }}
//			
			
			if(jsonObject.isNull("courtreporter14180")){
				depositionsdataexport.setCourtReporter(null);
			}else {
			JSONObject communication01=jsonObject.getJSONObject("courtreporter14180");
			if(!communication01.opt("id").equals(null)){
				depositionsdataexport.setCourtReporter(communication01.getString("id"));
			}}
			
			
			
			if(jsonObject.isNull("datecourtreporterconfirmed14180")) {
				depositionsdataexport.setDatecourtReporterConfirmed( null);
			}else {
				
		    if(!jsonObject.opt("datecourtreporterconfirmed14180").equals(null)){
		    	depositionsdataexport.setDatecourtReporterConfirmed( jsonObject.getString("datecourtreporterconfirmed14180"));
		    }}
			
			if(jsonObject.isNull("videographer14180")){
				depositionsdataexport.setVideoGrapher(null);
			}else {
			JSONObject communication01=jsonObject.getJSONObject("videographer14180");
			if(!communication01.opt("id").equals(null)){
				depositionsdataexport.setVideoGrapher(communication01.getString("id"));
			}}
			
			
//			if(jsonObject.isNull("videographer14180")) {
//				depositionsdataexport.setVideoGrapher( null);
//			}else {
//				
//		    if(!jsonObject.opt("videographer14180").equals(null)){
//		    	depositionsdataexport.setVideoGrapher( jsonObject.getString("videographer14180"));
//		    }}
			
			if(jsonObject.isNull("datevideographerconfirmed14180")) {
				depositionsdataexport.setDateVideoGrapherConfirmed( null);
			}else {
				
		    if(!jsonObject.opt("datevideographerconfirmed14180").equals(null)){
		    	depositionsdataexport.setDateVideoGrapherConfirmed( jsonObject.getString("datevideographerconfirmed14180"));
		    }}
			
			
			if(jsonObject.isNull("datedeponoticeservedonop14180")) {
				depositionsdataexport.setDateDepoNoticeServedOnOp( null);
			}else {
				
		    if(!jsonObject.opt("datedeponoticeservedonop14180").equals(null)){
		    	depositionsdataexport.setDateDepoNoticeServedOnOp( jsonObject.getString("datedeponoticeservedonop14180"));
		    }}
			
			
			
			
			depositionsdataexportdao.insertDepositionsData(databaseName,depositionsdataexport);		
			
			
			
			
		}
		}			
}
}
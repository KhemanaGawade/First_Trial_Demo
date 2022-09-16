package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.FileVineGhoshehLawCaseSummaryDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.FileVineGhoshehLawCaseSummaryExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FileVineGhoshehLawCaseSummaryService {

	public String getfilevineghoshehlawcaseSummaryResponse(String cookie,String projectID) {
	
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/casesummary16407?page=1";
	
		String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;	
	
}
	
	public void getFileVineGhoshehLawData(String response, String databaseName) throws JSONException, SQLException {
	
		FileVineGhoshehLawCaseSummaryExport filevineghoshehlawcasesummaryexport=new FileVineGhoshehLawCaseSummaryExport();
		FileVineGhoshehLawCaseSummaryDao filevineghoshehlawcasesummarydao=new FileVineGhoshehLawCaseSummaryDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			filevineghoshehlawcasesummaryexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.isNull("customObject")) {
			JSONObject jsonObject = data.getJSONObject("customObject");
			
			
		if(jsonObject.isNull("projectedsettlementdate191321")) {
			filevineghoshehlawcasesummaryexport.setProjectedSettlementDate( null);
		}else {
			
	    if(!jsonObject.opt("projectedsettlementdate191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setProjectedSettlementDate( jsonObject.getString("projectedsettlementdate191321"));
	    }}

		if(jsonObject.isNull("actualsettlementdate191321")) {
			filevineghoshehlawcasesummaryexport.setActualSettlementDate( null);
		}else {
			
	    if(!jsonObject.opt("actualsettlementdate191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setActualSettlementDate( jsonObject.getString("actualsettlementdate191321"));
	    }}
		
		if(jsonObject.isNull("projectedsettlementgoal191321")) {
			filevineghoshehlawcasesummaryexport.setProjectedSettlementGoal( null);
		}else {
			
	    if(!jsonObject.opt("projectedsettlementgoal191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setProjectedSettlementGoal( jsonObject.getString("projectedsettlementgoal191321"));
	    }}
		
//		if(jsonObject.isNull("clientdispersaldate191321")) {
//			filevineghoshehlawcasesummaryexport.setClientDispersalDate( null);
//		}else {
//			
//	    if(!jsonObject.opt("clientdispersaldate191321").equals(null)){
//	    	filevineghoshehlawcasesummaryexport.setClientDispersalDate( jsonObject.getString("clientdispersaldate191321"));
//	    }}
		
		if(jsonObject.isNull("actualsettlementamount191321")) {
			filevineghoshehlawcasesummaryexport.setActualSettlementAmount( null);
		}else {
			
	    if(!jsonObject.opt("actualsettlementamount191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setActualSettlementAmount( jsonObject.getString("actualsettlementamount191321"));
	    }}
		
		if(jsonObject.isNull("casefeesamount191321")) {
			filevineghoshehlawcasesummaryexport.setCaseFeesAmount( null);
		}else {
			
	    if(!jsonObject.opt("casefeesamount191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setCaseFeesAmount( jsonObject.getString("casefeesamount191321"));
	    }}
		
		if(jsonObject.isNull("casefeesdetails191321")) {
			filevineghoshehlawcasesummaryexport.setCaseFeesDetails( null);
		}else {
			
	    if(!jsonObject.opt("casefeesdetails191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setCaseFeesDetails( jsonObject.getString("casefeesdetails191321"));
	    }}
		
		if(jsonObject.isNull("clientdispersaldate191321")) {
			filevineghoshehlawcasesummaryexport.setClientDispersalDate( null);
		}else {
			
	    if(!jsonObject.opt("clientdispersaldate191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setClientDispersalDate( jsonObject.getString("clientdispersaldate191321"));
	    }}
		
		if(jsonObject.isNull("primaryattorney191321")){
			filevineghoshehlawcasesummaryexport.setPrimaryAttorneyId(null);
		}else {
			JSONObject communication6=jsonObject.getJSONObject("primaryattorney191321");
			if(!communication6.opt("id").equals(null)){
				filevineghoshehlawcasesummaryexport.setPrimaryAttorneyId(communication6.getString("id"));
			}}
		
		
		if(jsonObject.isNull("primaryattorney191321")){
			filevineghoshehlawcasesummaryexport.setOrgId(null);
		}else {
			JSONObject communication7=jsonObject.getJSONObject("primaryattorney191321");
			if(!communication7.opt("orgID").equals(null)){
				filevineghoshehlawcasesummaryexport.setOrgId(communication7.getString("orgID"));
			}}
		
		if(jsonObject.isNull("primaryattorney191321")){
			filevineghoshehlawcasesummaryexport.setPrimaryAttorneyFullName(null);
		}else {
			JSONObject communication8=jsonObject.getJSONObject("primaryattorney191321");
			if(!communication8.opt("fullname").equals(null)){
				filevineghoshehlawcasesummaryexport.setPrimaryAttorneyFullName(communication8.getString("fullname"));
			}}
		
		if(jsonObject.isNull("paralegal191321")){
			filevineghoshehlawcasesummaryexport.setParalegalId(null);
		}else {
			JSONObject communication12=jsonObject.getJSONObject("paralegal191321");
			if(!communication12.opt("id").equals(null)){
				filevineghoshehlawcasesummaryexport.setParalegalId(communication12.getString("id"));
			}}
		
		if(jsonObject.isNull("paralegal191321")){
			filevineghoshehlawcasesummaryexport.setParalegalFullName(null);
		}else {
			JSONObject communication13=jsonObject.getJSONObject("paralegal191321");
			if(!communication13.opt("fullname").equals(null)){
				filevineghoshehlawcasesummaryexport.setParalegalFullName(communication13.getString("fullname"));
			}}
		
		
//		if(!jsonObject.isNull("cocounsel191321")) {
//			if(jsonObject.isNull("cocounsel191321")) {
//				filevineghoshehlawcasesummaryexport.setCoCounselId( null);
//			}else {
//		    if(!jsonObject.opt("cocounsel191321").equals(null)){
//		    	JSONObject co_counsel=jsonObject.getJSONObject("cocounsel191321");
//		    	if(!co_counsel.opt("id").equals(null)){
//		    		filevineghoshehlawcasesummaryexport.setCoCounselId(co_counsel.getString("id"));
//			    }
//	   }}}
		
	
//				JSONArray arr = jsonObject.getJSONArray("cocounsel191321");
//				for(int k = 0; k<arr.length();k++)
//				{
//		             JSONObject jsonObj= arr.getJSONObject(k);	
//		             if(jsonObj.isNull("id")) {
//		            	 filevineghoshehlawcasesummaryexport.setCoCounselId( null);
//						}else {
//							
//					    if(!jsonObj.opt("id").equals(null)){
//					    	filevineghoshehlawcasesummaryexport.setCoCounselId( jsonObj.getString("id"));
//					 }}}
			
		
//		JSONArray array = jsonObject.getJSONArray("cocounsel191321");
//		   for(int p = 0; p < array.length() ;p++)
//		   {
//		
//          JSONObject jsonObj2= array.getJSONObject(p);	
//			
//			if(!jsonObj2.opt("id").equals(null)){
//				filevineghoshehlawcasesummaryexport.setCoCounselId(jsonObj2.getString("id"));
//			}}
//		
		
		
		
		
		
//		
		
//		if(!jsonObject.opt("cocounsel191321").equals(null)) {
//			JSONArray communication=data.getJSONArray("cocounsel191321");
//			for(int j=0; j<=communication.length()-1; j++) {
//				JSONObject jsonObject1=communication.getJSONObject(j);
//		
//				if(jsonObject1.isNull("id")) {
//					filevineghoshehlawcasesummaryexport.setCoCounselId( null);
//				}else {
//					
//			    if(!jsonObject1.opt("id").equals(null)){
//			    	filevineghoshehlawcasesummaryexport.setCoCounselId( jsonObject1.getString("id"));
//			    }}}}
//		
		
//		if(jsonObject.isNull("cocounsel191321")){
//			filevineghoshehlawcasesummaryexport.setCoCounselId(null);
//		}else {
//			JSONArray communication01=jsonObject.getJSONArray("cocounsel191321");
//			for(int k=0; k<=communication01.length(); k++) {
//			JSONObject jsonobject=communication01.getJSONObject(k);
//		if(!jsonobject.opt("id").equals(null)){
//			filevineghoshehlawcasesummaryexport.setCoCounselId(jsonobject.getString("id"));
//		}}}
//		
		
		
		
		
		
		
		
		
		
		
		
		if(jsonObject.isNull("cocounselfirm191321")){
			filevineghoshehlawcasesummaryexport.setCoCounselFirmId(null);
		}else {
			JSONObject communication25=jsonObject.getJSONObject("cocounselfirm191321");
			if(!communication25.opt("id").equals(null)){
				filevineghoshehlawcasesummaryexport.setCoCounselFirmId(communication25.getString("id"));
			}}
		
		if(jsonObject.isNull("statuteoflimitations191321")){
			filevineghoshehlawcasesummaryexport.setStatuteOfLimitationsDueDate(null);
		}else {
			JSONObject communication18=jsonObject.getJSONObject("statuteoflimitations191321");
			if(!communication18.opt("dateValue").equals(null)){
				filevineghoshehlawcasesummaryexport.setStatuteOfLimitationsDueDate(communication18.getString("dateValue"));
			}}
		
		if(jsonObject.isNull("statuteoflimitations191321")){
			filevineghoshehlawcasesummaryexport.setStatuteOfLimitationsDoneDate(null);
		}else {
			JSONObject communication26=jsonObject.getJSONObject("statuteoflimitations191321");
			if(!communication26.opt("doneDate").equals(null)){
				filevineghoshehlawcasesummaryexport.setStatuteOfLimitationsDoneDate(communication26.getString("doneDate"));
			}}
		
		if(jsonObject.isNull("demandsentdate191321")) {
			filevineghoshehlawcasesummaryexport.setDemandSentDate( null);
		}else {
			
	    if(!jsonObject.opt("demandsentdate191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setDemandSentDate( jsonObject.getString("demandsentdate191321"));
	    }}
		
		if(jsonObject.isNull("complaintfiled191321")) {
			filevineghoshehlawcasesummaryexport.setComplaintFiledDate( null);
		}else {
			
	    if(!jsonObject.opt("complaintfiled191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setComplaintFiledDate( jsonObject.getString("complaintfiled191321"));
	    }}
		
		if(jsonObject.isNull("courtdate191321")) {
			filevineghoshehlawcasesummaryexport.setCourtDate( null);
		}else {
			
	    if(!jsonObject.opt("courtdate191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setCourtDate( jsonObject.getString("courtdate191321"));
	    }}
		
	
		if(jsonObject.isNull("judge191321")){
			filevineghoshehlawcasesummaryexport.setJudgeFullName(null);
		}else {
			JSONObject communication30=jsonObject.getJSONObject("judge191321");
			if(!communication30.opt("fullname").equals(null)){
				filevineghoshehlawcasesummaryexport.setJudgeFullName(communication30.getString("fullname"));
			}}
		
		if(jsonObject.isNull("courthouse191321")){
			filevineghoshehlawcasesummaryexport.setCourtHouseFullName(null);
		}else {
			JSONObject communication31=jsonObject.getJSONObject("courthouse191321");
			if(!communication31.opt("fullname").equals(null)){
				filevineghoshehlawcasesummaryexport.setCourtHouseFullName(communication31.getString("fullname"));
			}}
		
		if(jsonObject.isNull("case191321")) {
			filevineghoshehlawcasesummaryexport.setCase( null);
		}else {
			
	    if(!jsonObject.opt("case191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setCase( jsonObject.getString("case191321"));
	    }}
		
		if(jsonObject.isNull("atfaultclaimno191321")) {
			filevineghoshehlawcasesummaryexport.setAtFaultClaimNo( null);
		}else {
			
	    if(!jsonObject.opt("atfaultclaimno191321").equals(null)){
	    	filevineghoshehlawcasesummaryexport.setAtFaultClaimNo( jsonObject.getString("atfaultclaimno191321"));
	    }}
		
		
		filevineghoshehlawcasesummarydao.insertFileVineGhoshehLawCaseSummaryData(databaseName,filevineghoshehlawcasesummaryexport);
		
		
}
	}
}
	
	
package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.PartysDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.PartysDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class PartysDataExportService {

	public String getPartysDataExportResponse(String cookie,String projectID ) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/defendants1032?page=1";           
	
	String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"defendant14197\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	
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
	
	public void getPartysData(String response, String databaseName) throws JSONException, SQLException {
		
		PartysDataExport partysdataexport=new PartysDataExport();
		PartysDataExportDao partysdataexportdao=new PartysDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
	
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			partysdataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
				
				if(jsonObject.isNull("defendanttype14197")) {
					partysdataexport.setDefendantType( null);
				}else {
					
			    if(!jsonObject.opt("defendanttype14197").equals(null)){
			    	partysdataexport.setDefendantType( jsonObject.getString("defendanttype14197"));

			    }}
				
				if(jsonObject.isNull("defendant14197")){
					partysdataexport.setDefendant(null);
				}else {
				JSONObject communication1=jsonObject.getJSONObject("defendant14197");
				if(!communication1.opt("fullname").equals(null)){
					partysdataexport.setDefendant(communication1.getString("fullname"));
				}}
				
				if(jsonObject.isNull("counsel14197")){
					partysdataexport.setCounsel(null);
				}else {
				JSONObject communication2=jsonObject.getJSONObject("counsel14197");
				if(!communication2.opt("fullname").equals(null)){
					partysdataexport.setCounsel(communication2.getString("fullname"));
				}}
				
				if(jsonObject.isNull("cocounsels14197")){
					partysdataexport.setCoCounsels(null);
				}else {
					JSONArray communication3=jsonObject.getJSONArray("cocounsels14197");
					for(int k=0; k<=communication3.length()-1; k++) {
					JSONObject jsonobject=communication3.getJSONObject(k);
				if(!jsonobject.opt("fullname").equals(null)){
					partysdataexport.setCoCounsels(jsonobject.getString("fullname"));
				}}}
				
				if(jsonObject.isNull("personalcounsel14197")) {
					partysdataexport.setPersonalCounsel( null);
				}else {
					
			    if(!jsonObject.opt("personalcounsel14197").equals(null)){
			    	partysdataexport.setPersonalCounsel( jsonObject.getString("personalcounsel14197"));

			    }}
				if(jsonObject.isNull("lawsuitfiled14197")) {
					partysdataexport.setLawsuitFiled( null);
				}else {
					
			    if(!jsonObject.opt("lawsuitfiled14197").equals(null)){
			    	partysdataexport.setLawsuitFiled( jsonObject.getString("lawsuitfiled14197"));

			    }}
				
				if(jsonObject.isNull("isdefendantabusiness14197")) {
					partysdataexport.setIsDefendantaBusiness( null);
				}else {
					
			    if(!jsonObject.opt("isdefendantabusiness14197").equals(null)){
			    	partysdataexport.setIsDefendantaBusiness( jsonObject.getString("isdefendantabusiness14197"));

			    }}
				
//				if(jsonObject.isNull("isdefendantabusiness14197")) {
//					partysdataexport.setIsDefendantaBusiness( null);
//				}else {
//					
//			    if(!jsonObject.opt("isdefendantabusiness14197").equals(null)){
//			    	partysdataexport.setIsDefendantaBusiness( jsonObject.getString("isdefendantabusiness14197"));
//
//			    }}
				
				if(jsonObject.isNull("processserver14197")){
					partysdataexport.setProcessServer(null);
				}else {
				JSONObject communication5=jsonObject.getJSONObject("processserver14197");
				if(!communication5.opt("fullname").equals(null)){
					partysdataexport.setProcessServer(communication5.getString("fullname"));
				}}
				
				if(jsonObject.isNull("defendantserved14197")) {
					partysdataexport.setDefendantServed( null);
				}else {
					
			    if(!jsonObject.opt("defendantserved14197").equals(null)){
			    	partysdataexport.setDefendantServed( jsonObject.getString("defendantserved14197"));

			    }}
				
				if(jsonObject.isNull("dateofservice14197")) {
					partysdataexport.setDateOfService( null);
				}else {
					
			    if(!jsonObject.opt("dateofservice14197").equals(null)){
			    	partysdataexport.setDateOfService( jsonObject.getString("dateofservice14197"));

			    }}
				
				if(jsonObject.isNull("mannerofservice14197")) {
					partysdataexport.setMannerOfService( null);
				}else {
					
			    if(!jsonObject.opt("mannerofservice14197").equals(null)){
			    	partysdataexport.setMannerOfService( jsonObject.getString("mannerofservice14197"));

			    }}
				
				if(jsonObject.isNull("proofofservicefiled14197")) {
					partysdataexport.setProofOfServiceFiled( null);
				}else {
					
			    if(!jsonObject.opt("proofofservicefiled14197").equals(null)){
			    	partysdataexport.setProofOfServiceFiled( jsonObject.getString("proofofservicefiled14197"));

			    }}
				
				if(jsonObject.isNull("dateoffiling14197")) {
					partysdataexport.setDateOfFiling( null);
				}else {
					
			    if(!jsonObject.opt("dateoffiling14197").equals(null)){
			    	partysdataexport.setDateOfFiling( jsonObject.getString("dateoffiling14197"));

			    }}
				
				if(jsonObject.isNull("partynotes14197")) {
					partysdataexport.setPartyNotes( null);
				}else {
					
			    if(!jsonObject.opt("partynotes14197").equals(null)){
			    	partysdataexport.setPartyNotes( jsonObject.getString("partynotes14197"));

			    }}
				
				if(jsonObject.isNull("hasdefendantrespondedtocomplaint14197")) {
					partysdataexport.setHasDefendantRespondedToComplaint( null);
				}else {
					
			    if(!jsonObject.opt("hasdefendantrespondedtocomplaint14197").equals(null)){
			    	partysdataexport.setHasDefendantRespondedToComplaint( jsonObject.getString("hasdefendantrespondedtocomplaint14197"));

			    }}
				
				
				if(jsonObject.isNull("typeofbusiness14197")) {
					partysdataexport.setTypeOfBusiness( null);
				}else {
					
			    if(!jsonObject.opt("typeofbusiness14197").equals(null)){
			    	partysdataexport.setTypeOfBusiness( jsonObject.getString("typeofbusiness14197"));

			    }}
				
				if(jsonObject.isNull("agentforprocessofservice14197")){
					partysdataexport.setAgentForProcessOfServiceName(null);
				}else {
				JSONObject communication25=jsonObject.getJSONObject("agentforprocessofservice14197");
				if(!communication25.opt("fullname").equals(null)){
					partysdataexport.setAgentForProcessOfServiceName(communication25.getString("fullname"));
				}}
				
				if(jsonObject.isNull("agentforprocessofservice14197")){
					partysdataexport.setAgentForProcessOfServiceId(null);
				}else {
				JSONObject communication26=jsonObject.getJSONObject("agentforprocessofservice14197");
				if(!communication26.opt("id").equals(null)){
					partysdataexport.setAgentForProcessOfServiceId(communication26.getString("id"));
				}}
				
				if(jsonObject.isNull("pos14197")){
					partysdataexport.setPosId(null);
				}else {
					JSONArray communication33=jsonObject.getJSONArray("pos14197");
					for(int k=0; k<=communication33.length()-1; k++) {
					JSONObject jsonobject=communication33.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					partysdataexport.setPosId(jsonobject.getString("id"));
				}}}
				
				if(jsonObject.isNull("pos14197")){
					partysdataexport.setPosFileName(null);
				}else {
					JSONArray communication43=jsonObject.getJSONArray("pos14197");
					for(int k=0; k<=communication43.length()-1; k++) {
					JSONObject jsonobject=communication43.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					partysdataexport.setPosFileName(jsonobject.getString("filename"));
				}}}
				
				if(jsonObject.isNull("documents14197")){
					partysdataexport.setDocumentsFileName(null);
				}else {
					JSONArray communication88=jsonObject.getJSONArray("documents14197");
					for(int k=0; k<=communication88.length()-1; k++) {
					JSONObject jsonobject=communication88.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					partysdataexport.setDocumentsFileName(jsonobject.getString("filename"));
				}}}
				
				if(jsonObject.isNull("documents14197")){
					partysdataexport.setDocumentsId(null);
				}else {
					JSONArray communication89=jsonObject.getJSONArray("documents14197");
					for(int k=0; k<=communication89.length()-1; k++) {
					JSONObject jsonobject=communication89.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					partysdataexport.setDocumentsId(jsonobject.getString("id"));
				}}}
				
//				if(jsonObject.isNull("dismisseddefendant14197")) {
//					partysdataexport.setDismissedDefendant( null);
//				}else {
//					
//			    if(!jsonObject.opt("dismisseddefendant14197").equals(null)){
//			    	partysdataexport.setDismissedDefendant( jsonObject.getString("dismisseddefendant14197"));
//
//			    }}
//				
//				if(jsonObject.isNull("crossdefendant14197")) {
//					partysdataexport.setCrossDefendant( null);
//				}else {
//					
//			    if(!jsonObject.opt("crossdefendant14197").equals(null)){
//			    	partysdataexport.setCrossDefendant( jsonObject.getString("crossdefendant14197"));
//
//			    }}
				
//				if(jsonObject.isNull("respondentparty14197")) {
//					partysdataexport.setRespondentParty( null);
//				}else {
//					
//			    if(!jsonObject.opt("respondentparty14197").equals(null)){
//			    	partysdataexport.setRespondentParty( jsonObject.getString("respondentparty14197"));
//
//			    }}
//				
				
				
//				if(jsonObject.isNull("3rdpartydefendant14197")){
//					partysdataexport.setProcessServer(null);
//				}else {
//				JSONObject communication4=jsonObject.getJSONObject("3rdpartydefendant14197");
//				if(!communication4.opt("fullname").equals(null)){
//					partysdataexport.setProcessServer(communication4.getString("fullname"));
//				}}
//				
				
				
				partysdataexportdao.insertPartysData(databaseName,partysdataexport);
				
				
				
				
				
				
				
}
}
	}
}
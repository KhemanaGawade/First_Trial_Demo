package com.filevine.dataexport.service;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONObject;
import com.filevine.dataexport.dao.NegotiationsExportDao;
import com.filevine.dataexport.domain.NegotiationsExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class NegotiationsExportService {
//	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public String getNegotiationsResponse(String cookie, String projectId) {
		
		MDC.put("path", "File Vine:: Negotiations Export");

        String response=null;
        String url="https://app.filevine.com/api/projects/"+projectId+"/custom/negotiations16407?page=1";
      //  String url="https://app.filevine.com/api/projects/"+projectId+"/custom/negotiations16407?page=1";
		String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"date191313\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
        
      //  String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\""
			//	+ "00000000-0000-0000-0000-000000000000\",\"sortField\":\"offerdemandsettled89449\","
			//	+ "\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		try {
			WebResource webRespource=Client.create().resource(url);
     		response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
         	eventLogger.info("Response has been exported!!");
		}
		catch(Exception e) {
			e.printStackTrace();
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Fail to get repsonse from UI");
		}
		return response;
	}

	public void getNegotiationsData(String response, String databaseName) throws Exception {
		NegotiationsExportDao negotiationsExportDao=new NegotiationsExportDao();
		NegotiationsExport negotiationsExport=new NegotiationsExport();
		System.out.println(response);
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject jsonObj=new JSONObject(res);
		if(!jsonObj.opt("projectID").equals(null)){
			negotiationsExport.setProjectId(jsonObj.getInt("projectID"));
		}
		
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
		JSONArray jsonArrayNegate=data.getJSONArray("collection");
        for(int j=0; j<=jsonArrayNegate.length()-1; j++) {
		JSONObject jsonObject=jsonArrayNegate.getJSONObject(j);
		if(!jsonObject.opt("_id").equals(null)){
			negotiationsExport.setId(jsonObject.getString("_id"));
		}
		if(!jsonObject.isNull("docs191313")) {
		JSONArray docArray=jsonObject.getJSONArray("docs191313");
		for(int k=0;k<docArray.length()-1;k++) {
			JSONObject jsonDoc=docArray.getJSONObject(k);
		    if(!jsonDoc.opt("id").equals(null)){
			negotiationsExport.setDocId(jsonDoc.getInt("id"));
		    }
		    if(!jsonDoc.opt("filename").equals(null)){
				negotiationsExport.setDocName(jsonDoc.getString("filename"));
			}
		}
		}
		if(!jsonObject.isNull("currentoffer191313")) {
		if(!jsonObject.opt("currentoffer191313").equals(null)){
			negotiationsExport.setOfferLetter(jsonObject.getString("currentoffer191313"));
		}}
		if(!jsonObject.isNull("demandsent191313")) {
		if(!jsonObject.opt("demandsent191313").equals(null)){
			negotiationsExport.setDemandsent(jsonObject.getString("demandsent191313"));
		}}
		if(!jsonObject.isNull("offerhistory191313")) {
		if(!jsonObject.opt("offerhistory191313").equals(null)){
			negotiationsExport.setOfferhistory(jsonObject.getString("offerhistory191313"));
		}}
		if(!jsonObject.isNull("datedemandsent191313")) {
		if(!jsonObject.opt("datedemandsent191313").equals(null)){
			negotiationsExport.setDatedemandsent(jsonObject.getString("datedemandsent191313"));
		}}
		if(!jsonObject.isNull("_itemHeader")) {
		JSONObject itemHeader=jsonObject.getJSONObject("_itemHeader");
		if(!itemHeader.isNull("createdDate")) {
		if(!itemHeader.opt("createdDate").equals(null)){
			negotiationsExport.setCreatedDate(itemHeader.getString("createdDate"));
		}}}
		if(!jsonObject.isNull("methodofoffer191313")) {
		if(!jsonObject.opt("methodofoffer191313").equals(null)){
			negotiationsExport.setMethodOfOffer(jsonObject.getString("methodofoffer191313"));
		}}
		if(!jsonObject.isNull("tofrom191313")) {
	    JSONObject jsonToFrom=jsonObject.getJSONObject("tofrom191313");
		if(!jsonToFrom.opt("id").equals(null)){
			negotiationsExport.setToFromDemandId(jsonToFrom.getInt("id"));
		}
		}
		if(!jsonObject.isNull("negotiationamount191313")) {
		if(!jsonObject.opt("negotiationamount191313").equals(null)){
			negotiationsExport.setAmount(jsonObject.getDouble("negotiationamount191313"));
		}}
		if(!jsonObject.isNull("priorclientapproval191313")) {
		if(!jsonObject.opt("priorclientapproval54928").equals(null)){
			negotiationsExport.setPriorClientApproval(jsonObject.getString("priorclientapproval191313"));
		}}
		if(!jsonObject.isNull("date191313")) {
		if(!jsonObject.opt("date191313").equals(null)){
			negotiationsExport.setDate(jsonObject.getString("date191313"));
		}}
		if(!jsonObject.isNull("expirationdate191313")) {
		if(!jsonObject.opt("expirationdate191313").equals(null)){
			negotiationsExport.setExpiryDate(jsonObject.getString("expirationdate191313"));
		}}
		if(!jsonObject.isNull("negotiationtype191313")) {
			if(!jsonObject.opt("negotiationtype191313").equals(null)){
				negotiationsExport.setNegotiationtype(jsonObject.getString("negotiationtype191313"));
		}}
		if(!jsonObject.isNull("negotiationnotes191313")) {
			if(!jsonObject.opt("negotiationnotes191313").equals(null)){
				negotiationsExport.setNotes(jsonObject.getString("negotiationnotes191313"));
		}}
		
//		if(!jsonObject.isNull("party191313")) {
//			JSONObject itemHeader=jsonObject.getJSONObject("party191313");
//			if(!itemHeader.isNull("id")) {
//			if(!itemHeader.opt("id").equals(null)){
//				negotiationsExport.setPartyId(itemHeader.getString("id"));
//			}}}
		
		
		
		negotiationsExportDao.insertNegotiationsData(negotiationsExport,databaseName);
        }
		}
	}

}

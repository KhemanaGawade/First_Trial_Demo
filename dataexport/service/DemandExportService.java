package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.DemandExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.DemandExport;
import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class DemandExportService {

	public String getDemandExportResponse(String cookie,String projectID) {
		
		String response=null;
		
	String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/negotiations1032?page=1";
	
	 String Payload ="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"date14189\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,Payload);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;
	
	}
	
	public void getDemandData(String response, String databaseName) throws JSONException, SQLException {
	
		DemandExport demandexport=new DemandExport();
		DemandExportDao demandexportdao=new DemandExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject demandData=new JSONObject(res);
		if(!demandData.opt("projectID").equals(null)){
			demandexport.setProjectId(demandData.getInt("projectID"));
		}
	
		
		JSONObject data=demandData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
		
				if(jsonObject.isNull("offerdemandsettled14189")) {
					demandexport.setOfferDemandSettled( null);
				}else {
					
			    if(!jsonObject.opt("offerdemandsettled14189").equals(null)){
			    	demandexport.setOfferDemandSettled( jsonObject.getString("offerdemandsettled14189"));
			    }}
		
				if(jsonObject.isNull("amount14189")) {
					demandexport.setAmount( null);
				}else {
					
			    if(!jsonObject.opt("amount14189").equals(null)){
			    	demandexport.setAmount( jsonObject.getString("amount14189"));
			    }}
		
				if(jsonObject.isNull("date14189")) {
					demandexport.setDateSend( null);
				}else {
					
			    if(!jsonObject.opt("date14189").equals(null)){
			    	demandexport.setDateSend( jsonObject.getString("date14189"));
			    }}
		
				if(jsonObject.isNull("notes14189")) {
					demandexport.setNotes( null);
				}else {
					
			    if(!jsonObject.opt("notes14189").equals(null)){
			    	demandexport.setNotes( jsonObject.getString("notes14189"));
			    }}
		
				if(jsonObject.isNull("demandstatus14189")) {
					demandexport.setDemandStatus( null);
				}else {
					
			    if(!jsonObject.opt("demandstatus14189").equals(null)){
			    	demandexport.setDemandStatus( jsonObject.getString("demandstatus14189"));
			    }}
		
				if(jsonObject.isNull("liabilitysection14189")) {
					demandexport.setLiabilitySection( null);
				}else {
					
			    if(!jsonObject.opt("liabilitysection14189").equals(null)){
			    	demandexport.setLiabilitySection( jsonObject.getString("liabilitysection14189"));
			    }}
				
				if(jsonObject.isNull("datedrafted14189")) {
					demandexport.setDateDrafted( null);
				}else {
					
			    if(!jsonObject.opt("datedrafted14189").equals(null)){
			    	demandexport.setDateDrafted( jsonObject.getString("datedrafted14189"));
			    }}
	
				if(jsonObject.isNull("whodrafted14189")){
					demandexport.setWhoDrafted(null);
				}else {
					JSONObject communication5=jsonObject.getJSONObject("whodrafted14189");
					if(!communication5.opt("fullname").equals(null)){
						demandexport.setWhoDrafted(communication5.getString("fullname"));
					}}
				
				if(jsonObject.isNull("tofrom14189")){
					demandexport.setToFrom(null);
				}else {
					JSONObject communication1=jsonObject.getJSONObject("tofrom14189");
					if(!communication1.opt("fullname").equals(null)){
						demandexport.setToFrom(communication1.getString("fullname"));
					}}
				
				
				if(jsonObject.isNull("demandexpiration14189")){
					demandexport.setDueDate(null);
				}else {
					JSONObject communication2=jsonObject.getJSONObject("demandexpiration14189");
					if(!communication2.opt("dateValue").equals(null)){
						demandexport.setDueDate(communication2.getString("dateValue"));
					}}
				
				
				if(jsonObject.isNull("returnreceipt14189")){
					demandexport.setReturnReceiptId(null);
				}else {
					JSONObject communication12=jsonObject.getJSONObject("returnreceipt14189");
					if(!communication12.opt("id").equals(null)){
						demandexport.setReturnReceiptId(communication12.getString("id"));
					}}
				
				
				if(jsonObject.isNull("returnreceipt14189")){
					demandexport.setReturnReceiptFileName(null);
				}else {
					JSONObject communication14=jsonObject.getJSONObject("returnreceipt14189");
					if(!communication14.opt("filename").equals(null)){
						demandexport.setReturnReceiptFileName(communication14.getString("filename"));
					}}
//				
				if(jsonObject.isNull("docs14189")){
					demandexport.setDocsId(null);
				}else {
					JSONArray communication3=jsonObject.getJSONArray("docs14189");
					for(int k=0; k<=communication3.length()-1; k++) {
					JSONObject jsonobject=communication3.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					demandexport.setDocsId(jsonobject.getString("id"));
				}}}
				
				if(jsonObject.isNull("docs14189")){
					demandexport.setDocsFileName(null);
				}else {
					JSONArray communication02=jsonObject.getJSONArray("docs14189");
					for(int k=0; k<=communication02.length()-1; k++) {
					JSONObject jsonobject=communication02.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					demandexport.setDocsFileName(jsonobject.getString("filename"));
				}}}
				
				
				
				
				
//				if(jsonObject.isNull("_itemHeader")){
//					demandexport.setCreatedDate(null);
//				}else {
//					JSONObject communication8=jsonObject.getJSONObject("_itemHeader");
//					if(!communication8.opt("createdDate").equals(null)){
//						demandexport.setCreatedDate(communication8.getString("createdDate));
//					}}
				
				
				demandexportdao.insertDemandExportData(databaseName,demandexport);	
}
}
	}
	
}
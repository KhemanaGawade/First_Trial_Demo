package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.filevine.dataexport.dao.MedicalBillsDocDao;
import com.filevine.dataexport.domain.MedicalBillsDoc;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class MedicalBillsDocService {

	
	public String getMedicalBillsDocResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/meds16407?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"medicalbillamount191324\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
		
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
	
	public void getMedicalBillsDocData(String response, String databaseName) throws JSONException, SQLException {
	
		
		MedicalBillsDoc medicalbillsdoc=new MedicalBillsDoc();
		 MedicalBillsDocDao  medicalbillsdocdao=new  MedicalBillsDocDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject medicalbillsdocData=new JSONObject(res);
		if(!medicalbillsdocData.opt("projectID").equals(null)){
			medicalbillsdoc.setProjectId(medicalbillsdocData.getInt("projectID"));
		}
		
		JSONObject data=medicalbillsdocData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
				
				
				if(jsonObject.isNull("medicalprovider191324")){
					medicalbillsdoc.setMedicalProvider(null);
				}else {
				JSONObject communication1=jsonObject.getJSONObject("medicalprovider191324");
				if(!communication1.opt("fullname").equals(null)){
					medicalbillsdoc.setMedicalProvider(communication1.getString("fullname"));
				}}
				
				if(jsonObject.isNull("billsinvoice191324")){
					medicalbillsdoc.setBillsInvoiceId(null);
				}else {
				JSONObject communication2=jsonObject.getJSONObject("billsinvoice191324");
				if(!communication2.opt("id").equals(null)){
					medicalbillsdoc.setBillsInvoiceId(communication2.getString("id"));
				}}
		
				if(jsonObject.isNull("billsinvoice191324")){
					medicalbillsdoc.setOrgID(null);
				}else {
				JSONObject communication3=jsonObject.getJSONObject("billsinvoice191324");
				if(!communication3.opt("orgID").equals(null)){
					medicalbillsdoc.setOrgID(communication3.getString("orgID"));
				}}
		
				if(jsonObject.isNull("billsinvoice191324")){
					medicalbillsdoc.setBillsInvoiceFileName(null);
				}else {
				JSONObject communication4=jsonObject.getJSONObject("billsinvoice191324");
				if(!communication4.opt("filename").equals(null)){
					medicalbillsdoc.setBillsInvoiceFileName(communication4.getString("filename"));
				}}
//				if(jsonObject.isNull("billsinvoice191324")){
//					medicalbillsdoc.setUploadDate(null);
//				}else {
//				JSONObject communication1=jsonObject.getJSONObject("billsinvoice191324");
//				if(!communication1.opt("uploadDate").equals(null)){
//					medicalbillsdoc.setUploadDate(communication1.getString("uploadDate"));
//				}}
				if(jsonObject.isNull("recordsretrievalinvoice191324")){
					medicalbillsdoc.setRecordsRetrievalInvoiceId(null);
				}else {
				JSONObject communication5=jsonObject.getJSONObject("recordsretrievalinvoice191324");
				if(!communication5.opt("id").equals(null)){
					medicalbillsdoc.setRecordsRetrievalInvoiceId(communication5.getString("id"));
				}}
				
				if(jsonObject.isNull("recordsretrievalinvoice191324")){
					medicalbillsdoc.setRecordsRetrievalFilename(null);
				}else {
				JSONObject communication6=jsonObject.getJSONObject("recordsretrievalinvoice191324");
				if(!communication6.opt("filename").equals(null)){
					medicalbillsdoc.setRecordsRetrievalFilename(communication6.getString("filename"));
				}}
		
				
				medicalbillsdocdao.insertMedicalDocData(databaseName,medicalbillsdoc);	
				
				
							
				
			}
		}
	}
}

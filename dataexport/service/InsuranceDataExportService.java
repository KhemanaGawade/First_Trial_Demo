package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.InsuranceDataExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.InsuranceDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class InsuranceDataExportService {

	public String getInsuranceDataExportResponse(String cookie,String projectID ) {
	
		String response=null;
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/insurance1032?page=1";
	//   String url="https://app.filevine.com/api/projects/"+projectID+"/custom/insurance16407?page=1";
	String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"insurancetype14184\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	//String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"insuranceprovider191322\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
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
	
	public void getInsuranceData(String response, String databaseName) throws JSONException, SQLException {
		
		InsuranceDataExport insurancedataexport=new InsuranceDataExport();
		InsuranceDataExportDao insurancedataexportdao=new InsuranceDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
	
		JSONObject insuranceData=new JSONObject(res);
		if(!insuranceData.opt("projectID").equals(null)){
			insurancedataexport.setProjectId(insuranceData.getInt("projectID"));
		}
	
		JSONObject data=insuranceData.getJSONObject("data");
	

		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
				
				if(jsonObject.isNull("insurancetype14184")) {
					insurancedataexport.setInsuranceType( null);
				}else {
					
			    if(!jsonObject.opt("insurancetype14184").equals(null)){
			    	insurancedataexport.setInsuranceType( jsonObject.getString("insurancetype14184"));
			    }}
				
				if(jsonObject.isNull("otherinsurancetype14184")) {
					insurancedataexport.setOtherInsuranceType( null);
				}else {
					
			    if(!jsonObject.opt("otherinsurancetype14184").equals(null)){
			    	insurancedataexport.setOtherInsuranceType( jsonObject.getString("otherinsurancetype14184"));
			    }}
				
				if(jsonObject.isNull("insurancecompany14184")){
					insurancedataexport.setInsuranceCompany(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("insurancecompany14184");
					if(!communication6.opt("fullname").equals(null)){
						insurancedataexport.setInsuranceCompany(communication6.getString("fullname"));
					}}
				
				if(jsonObject.isNull("insurancecompany14184")){
					insurancedataexport.setInsuranceCompanyId(null);
				}else {
					JSONObject communication12=jsonObject.getJSONObject("insurancecompany14184");
					if(!communication12.opt("id").equals(null)){
						insurancedataexport.setInsuranceCompanyId(communication12.getString("id"));
					}}
				
		
				if(jsonObject.isNull("adjuster14184")){
					insurancedataexport.setAdjuster(null);
				}else {
					JSONObject communication7=jsonObject.getJSONObject("adjuster14184");
					if(!communication7.opt("fullname").equals(null)){
						insurancedataexport.setAdjuster(communication7.getString("fullname"));
					}}
				
				if(jsonObject.isNull("adjuster14184")){
					insurancedataexport.setAdjusterId(null);
				}else {
					JSONObject communication13=jsonObject.getJSONObject("adjuster14184");
					if(!communication13.opt("id").equals(null)){
						insurancedataexport.setAdjusterId(communication13.getString("id"));
					}}
				
				if(jsonObject.isNull("insured14184")){
					insurancedataexport.setInsured(null);
				}else {
					JSONObject communication9=jsonObject.getJSONObject("insured14184");
					if(!communication9.opt("fullname").equals(null)){
						insurancedataexport.setInsured(communication9.getString("fullname"));
					}}
				
				if(jsonObject.isNull("insured14184")){
					insurancedataexport.setInsuredId(null);
				}else {
					JSONObject communication15=jsonObject.getJSONObject("insured14184");
					if(!communication15.opt("id").equals(null)){
						insurancedataexport.setInsuredId(communication15.getString("id"));
					}}
				
				if(jsonObject.isNull("claimnumber14184")) {
					insurancedataexport.setClaimNumber( null);
				}else {
					
			    if(!jsonObject.opt("claimnumber14184").equals(null)){
			    	insurancedataexport.setClaimNumber( jsonObject.getString("claimnumber14184"));
			    }}
				
				if(jsonObject.isNull("policynumber14184")) {
					insurancedataexport.setPolicyNumber( null);
				}else {
					
			    if(!jsonObject.opt("policynumber14184").equals(null)){
			    	insurancedataexport.setPolicyNumber( jsonObject.getString("policynumber14184"));
			    }}
				
				if(jsonObject.isNull("policylimits14184")) {
					insurancedataexport.setPolicyLimits(null);
				}else {
					
			    if(!jsonObject.opt("policylimits14184").equals(null)){
			    	insurancedataexport.setPolicyLimits( jsonObject.getString("policylimits14184"));
			    }}
				
				if(jsonObject.isNull("acceptedliability14184")) {
					insurancedataexport.setAcceptLiability(null);
				}else {
					
			    if(!jsonObject.opt("acceptedliability14184").equals(null)){
			    	insurancedataexport.setAcceptLiability( jsonObject.getString("acceptedliability14184"));
			    }}
				
				if(jsonObject.isNull("additionalinsurancenotes14184")) {
					insurancedataexport.setAdditionalInsuranceNotes(null);
				}else {
					
			    if(!jsonObject.opt("additionalinsurancenotes14184").equals(null)){
			    	insurancedataexport.setAdditionalInsuranceNotes( jsonObject.getString("additionalinsurancenotes14184"));
			    }}
				
				
				if(jsonObject.isNull("decsheet14184")){
					insurancedataexport.setDecsheet(null);
				}else {
					JSONObject communication10=jsonObject.getJSONObject("decsheet14184");
					if(!communication10.opt("filename").equals(null)){
						insurancedataexport.setDecsheet(communication10.getString("filename"));
					}}
				
				if(jsonObject.isNull("_itemHeader")){
					insurancedataexport.setCreatedDate(null);
				}else {
					JSONObject communication18=jsonObject.getJSONObject("_itemHeader");
					if(!communication18.opt("createdDate").equals(null)){
						insurancedataexport.setCreatedDate(communication18.getString("createdDate"));
					}}
				
				
		
						insurancedataexportdao.insertInsuranceData(databaseName,insurancedataexport);
			
			
					
}
			
				}
			}
		}
	


	

package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.MedicalExportDAO;
import com.filevine.dataexport.domain.MedicalExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class MedicalExportService {

	public String getMedicalResponse(String cookie,String projectId) {
		String response=null;
		String url="https://app.filevine.com/api/projects/"+projectId+"/custom/meds16407?page=1";
		String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"provider48362\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
				System.out.println("response :: "+response);

		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;
	}

	
	
	/**
	 * 
	 * INPUT RESPONSE
	 * 
	 * JSON TO OBJECT
	 * 
	 * INSERT INTO DB
	 */
	public void getMedicalData(String response, String databaseName) throws Exception {
		MedicalExportDAO medicalExportDAO=new MedicalExportDAO();
		MedicalExport medicalExport=new MedicalExport();	
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject medicalData=new JSONObject(res);
		if(!medicalData.opt("projectID").equals(null)){
			medicalExport.setProjectId(medicalData.getInt("projectID"));
		}
		JSONObject medical=medicalData.getJSONObject("data") ;
		if(medical.isNull("mainRightTotal")) {
			medicalExport.setFinalAmount( null);
		}else {

	      if(!medical.opt("mainRightTotal").equals(null)){
		  medicalExport.setFinalAmount( medical.getString("mainRightTotal"));
	    }}
		if(!medical.isNull("collection")) {
		JSONArray medicals = medical.getJSONArray("collection");

		System.out.println(medicals.length());
		for(int k=0;k < medicals.length(); k++) {
			
			JSONObject jsonObj=medicals.getJSONObject(k);	
			if(!jsonObj.isNull("medicalprovider191324")) {
			JSONObject med = jsonObj.getJSONObject("medicalprovider191324") ;
			if(!med.opt("id").equals(null)){
				medicalExport.setPrivateID(med.getInt("id"));
			}
			//Amount 
			
				if(jsonObj.isNull("medicalbillamount191324")) {
					medicalExport.setAmount( null);
				}else {
			    if(!jsonObj.opt("medicalbillamount191324").equals(null)){
//			    	System.out.println("amount"+jsonObj.getString("amount48362"));
				medicalExport.setAmount(jsonObj.getString("medicalbillamount191324"));
			    }}
				if(jsonObj.isNull("plaintiffstreatmentstatus191324")) {
					medicalExport.setPlaintiffstreatmentstatus(null);
				}else {
			    if(!jsonObj.opt("plaintiffstreatmentstatus191324").equals(null)){
				medicalExport.setPlaintiffstreatmentstatus( jsonObj.getString("plaintiffstreatmentstatus191324"));
			    }}
				if(jsonObj.isNull("providersaccountnumber191324")) {
					medicalExport.setProvidersaccountnumber(null);
				}else {
			    if(!jsonObj.opt("providersaccountnumber191324").equals(null)){
				medicalExport.setProvidersaccountnumber( jsonObj.getString("providersaccountnumber191324"));
			    }}
				if(jsonObj.isNull("billsordered191324")) {
					medicalExport.setBillsordered(null);
				}else {
			    if(!jsonObj.opt("billsordered191324").equals(null)){
				medicalExport.setBillsordered( jsonObj.getString("billsordered191324"));
			    }}
				if(jsonObj.isNull("billsreceived191324")) {
					medicalExport.setBillsreceived(null);
				}else {
			    if(!jsonObj.opt("billsreceived191324").equals(null)){
				medicalExport.setBillsreceived(jsonObj.getString("billsreceived191324"));
			    }}
				if(jsonObj.isNull("recordsordered191324")) {
					medicalExport.setRecordsordered(null);
				}else {
			    if(!jsonObj.opt("recordsordered191324").equals(null)){
				medicalExport.setRecordsordered(jsonObj.getString("recordsordered191324"));
			    }}
				if(jsonObj.isNull("recordsreceived191324")) {
					medicalExport.setRecordsreceived(null);
				}else {
			    if(!jsonObj.opt("recordsreceived191324").equals(null)){
				medicalExport.setRecordsreceived(jsonObj.getString("recordsreceived191324"));
			    }}
				if(jsonObj.isNull("outstandingbalance191324")) {
					medicalExport.setOutstandingBalance(null);
				}else {
			    if(!jsonObj.opt("outstandingbalance191324").equals(null)){
				medicalExport.setOutstandingBalance( jsonObj.getString("outstandingbalance191324"));
			    }}
				if(jsonObj.isNull("recordscollectionfee191324")) {
					medicalExport.setRecordsCollectionFee( null);
				}else {
			    if(!jsonObj.opt("recordscollectionfee191324").equals(null)){
				medicalExport.setRecordsCollectionFee(jsonObj.getString("recordscollectionfee191324"));
			    }}
				if(jsonObj.isNull("recordscollectionstatus191324")) {
					medicalExport.setRecordscollectionstatus48362(null);
				}else {
			    if(!jsonObj.opt("recordscollectionstatus191324").equals(null)){
				medicalExport.setRecordscollectionstatus48362(jsonObj.getString("recordscollectionstatus191324"));
			    }}
				if(jsonObj.isNull("billingcollectionstatus191324")) {
					medicalExport.setBillingcollectionstatus(null);
				}else {
			    if(!jsonObj.opt("billingcollectionstatus191324").equals(null)){
				medicalExport.setBillingcollectionstatus(jsonObj.getString("billingcollectionstatus191324"));
			    }}
				
				if(jsonObj.isNull("reduction191324")) {
					medicalExport.setReduction( null);
				}else {
			    if(!jsonObj.opt("reduction191324").equals(null)){
				medicalExport.setReduction(jsonObj.getString("reduction191324"));
			    }}
				
				if(jsonObj.isNull("original191324")) {
					medicalExport.setOriginal( null);
				}else {
				
			      if(!jsonObj.opt("original191324").equals(null)){
				   medicalExport.setOriginal(jsonObj.getString("original191324"));
			    }}
				if(jsonObj.isNull("notes191324")) {
					medicalExport.setNotes( null);
				}else {
				
			      if(!jsonObj.opt("notes191324").equals(null)){
				  medicalExport.setNotes(jsonObj.getString("notes191324"));
			    }}
			
				if(jsonObj.isNull("treatmentcyclestarted191324")) {
					medicalExport.setFirstDayOfTreatment( null);
				}else {
			      if(!jsonObj.opt("treatmentcyclestarted191324").equals(null)){
				  medicalExport.setFirstDayOfTreatment(jsonObj.getString("treatmentcyclestarted191324"));
			    }}
				if(jsonObj.isNull("treatmentcyclecompleted191324")) {
					medicalExport.setLastDayOfTreatment( null);
				}else {
			      if(!jsonObj.opt("treatmentcyclecompleted191324").equals(null)){
				  medicalExport.setLastDayOfTreatment(jsonObj.getString("treatmentcyclecompleted191324"));
			    }}
				if(jsonObj.isNull("recordrequestdate191324")) {
					medicalExport.setDateRequested( null);
				}else {
			      if(!jsonObj.opt("recordrequestdate191324").equals(null)){
				  medicalExport.setDateRequested(jsonObj.getString("recordrequestdate191324"));
			    }}
				if(jsonObj.isNull("recordrequestresponsedate191324")) {
					medicalExport.setRecordrequestresponsedate( null);
				}else {
			      if(!jsonObj.opt("recordrequestresponsedate191324").equals(null)){
				  medicalExport.setRecordrequestresponsedate(jsonObj.getString("recordrequestresponsedate191324"));
			    }}
				if(jsonObj.isNull("asof191324")) {
					medicalExport.setAsof( null);
				}else {
			      if(!jsonObj.opt("asof191324").equals(null)){
				  medicalExport.setAsof(jsonObj.getString("asof191324"));
			    }}
				
				if(jsonObj.isNull("datereceived191324")) {
					medicalExport.setDateReceived( null);
				}else {
			      if(!jsonObj.opt("datereceived191324").equals(null)){
				   medicalExport.setDateReceived(jsonObj.getString("datereceived191324"));
			     }}
				
				if(jsonObj.isNull("orderedby191324")) {
					medicalExport.setOrderedBy( null);
				}else {
			        if(!jsonObj.opt("orderedby191324").equals(null)){
				    medicalExport.setOrderedBy(jsonObj.getString("orderedby191324"));
			    }}
				if(jsonObj.isNull("Bymethod191324")) {
					medicalExport.setMethod( null);
				}else {
			       if(!jsonObj.opt("Bymethod191324").equals(null)){
				   medicalExport.setMethod(jsonObj.getString("Bymethod191324"));
			    }}
				
				if(jsonObj.isNull("snagrequest191324")) {
					medicalExport.setSnagRequest( null);
				}else {
			      if(!jsonObj.opt("snagrequest191324").equals(null)){
				 medicalExport.setSnagRequest(jsonObj.getString("snagrequest191324"));
			    }}
				if(jsonObj.isNull("policynumber191324")) {
					medicalExport.setPolicynumber( null);
				}else {
			      if(!jsonObj.opt("policynumber191324").equals(null)){
				 medicalExport.setPolicynumber(jsonObj.getString("policynumber191324"));
			    }}
			
				JSONObject itemHeader=jsonObj.getJSONObject("_itemHeader");
				if(itemHeader.isNull("createdDate")) {
					medicalExport.setCreatedDate( null);
				}else {
			      if(!itemHeader.opt("createdDate").equals(null)){
				 medicalExport.setCreatedDate(itemHeader.getString("createdDate"));
			    }}
			medicalExportDAO.insertMedicalData(databaseName, medicalExport);
			}
		}
		}
	}

}

package com.filevine.dataexport.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class AdvanceClientCostExportService {

	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
	
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/expenses1032?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":20,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"dateofinvoice14183\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
	
	public void getAdvanceClientCostData(String response, String databaseName) throws JSONException, SQLException {
	
		AdvanceClientCostExport advanceclientcostexport=new AdvanceClientCostExport();
		AdvanceClientCostExportDao advanceclientcostexportdao=new AdvanceClientCostExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			advanceclientcostexport.setProjectId(advanceClientData.getInt("projectID"));
		}
		
		JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
		
				if(jsonObject.isNull("type14183")) {
					advanceclientcostexport.setType( null);
				}else {
					
			    if(!jsonObject.opt("type14183").equals(null)){
			    	advanceclientcostexport.setType( jsonObject.getString("type14183"));
			    }}
		
				if(jsonObject.isNull("invoicenumber14183")) {
					advanceclientcostexport.setInvoiceNumber( null);
				}else {
					
			    if(!jsonObject.opt("invoicenumber14183").equals(null)){
			    	advanceclientcostexport.setInvoiceNumber( jsonObject.getString("invoicenumber14183"));
			    }}
		
				if(jsonObject.isNull("amountofinvoice14183")) {
					advanceclientcostexport.setAmountOfInvoice( null);
				}else {
					
			    if(!jsonObject.opt("amountofinvoice14183").equals(null)){
			    	advanceclientcostexport.setAmountOfInvoice( jsonObject.getString("amountofinvoice14183"));
			    }}
		
				if(jsonObject.isNull("dateofinvoice14183")) {
					advanceclientcostexport.setDateOfInvoice( null);
				}else {
					
			    if(!jsonObject.opt("dateofinvoice14183").equals(null)){
			    	advanceclientcostexport.setDateOfInvoice( jsonObject.getString("dateofinvoice14183"));
			    }}
				
			
				if(jsonObject.isNull("cardtype14183")) {
					advanceclientcostexport.setCardType( null);
				}else {
					
			    if(!jsonObject.opt("cardtype14183").equals(null)){
			    	advanceclientcostexport.setCardType( jsonObject.getString("cardtype14183"));
			    }}
				
				if(jsonObject.isNull("notes14183")) {
					advanceclientcostexport.setNotes( null);
				}else {
					
			    if(!jsonObject.opt("notes14183").equals(null)){
			    	advanceclientcostexport.setNotes( jsonObject.getString("notes14183"));
			    }}
				
				if(jsonObject.isNull("description14183")) {
					advanceclientcostexport.setDescription( null);
				}else {
					
			    if(!jsonObject.opt("description14183").equals(null)){
			    	advanceclientcostexport.setDescription( jsonObject.getString("description14183"));
			    }}
				
				if(jsonObject.isNull("amountpaid14183")) {
					advanceclientcostexport.setHowMuchAmountPaid( null);
				}else {
					
			    if(!jsonObject.opt("amountpaid14183").equals(null)){
			    	advanceclientcostexport.setHowMuchAmountPaid( jsonObject.getString("amountpaid14183"));
			    }}
				
				
				if(jsonObject.isNull("recordsreceived14183")) {
					advanceclientcostexport.setRecordsReceived(null);
				}else {
					
			    if(!jsonObject.opt("recordsreceived14183").equals(null)){
			    	advanceclientcostexport.setRecordsReceived( jsonObject.getString("recordsreceived14183"));
			    }}
				
				
				if(jsonObject.isNull("methodofpayment14183")) {
					advanceclientcostexport.setMethodOfPayment( null);
				}else {
					
			    if(!jsonObject.opt("methodofpayment14183").equals(null)){
			    	advanceclientcostexport.setMethodOfPayment( jsonObject.getString("methodofpayment14183"));
			    }}
				
				
				if(jsonObject.isNull("checknumber14183")) {
					advanceclientcostexport.setCheckNumber( null);
				}else {
					
			    if(!jsonObject.opt("checknumber14183").equals(null)){
			    	advanceclientcostexport.setCheckNumber( jsonObject.getString("checknumber14183"));
			    }}
			
			
				if(jsonObject.isNull("paybydate14183")){
					advanceclientcostexport.setPayDateDue(null);
				}else {
					JSONObject communication6=jsonObject.getJSONObject("paybydate14183");
					if(!communication6.opt("dateValue").equals(null)){
						advanceclientcostexport.setPayDateDue(communication6.getString("dateValue"));
					}}
				
				
				if(jsonObject.isNull("paybydate14183")){
					advanceclientcostexport.setPayDateDone(null);
				}else {
					JSONObject communication5=jsonObject.getJSONObject("paybydate14183");
					if(!communication5.opt("doneDate").equals(null)){
						advanceclientcostexport.setPayDateDone(communication5.getString("doneDate"));
					}}
	
				if(jsonObject.isNull("whosecreditcard14183")){
					advanceclientcostexport.setWhoseCreditCard(null);
				}else {
					JSONObject communication1=jsonObject.getJSONObject("whosecreditcard14183");
					if(!communication1.opt("fullname").equals(null)){
						advanceclientcostexport.setWhoseCreditCard(communication1.getString("fullname"));
					}}
				
				if(jsonObject.isNull("facilityname14183")){
					advanceclientcostexport.setFacilityName(null);
				}else {
					JSONObject communication2=jsonObject.getJSONObject("facilityname14183");
					if(!communication2.opt("fullname").equals(null)){
						advanceclientcostexport.setFacilityName(communication2.getString("fullname"));
					}}
				
				if(jsonObject.isNull("payeename14183")){
					advanceclientcostexport.setPayeeName(null);
				}else {
					JSONObject communication8=jsonObject.getJSONObject("payeename14183");
					if(!communication8.opt("fullname").equals(null)){
						advanceclientcostexport.setPayeeName(communication8.getString("fullname"));
					}}
			
				
				if(jsonObject.isNull("documents14183")){
					advanceclientcostexport.setDocumentId(null);
				}else {
					JSONArray communication3=jsonObject.getJSONArray("documents14183");
					for(int k=0; k<=communication3.length()-1; k++) {
					JSONObject jsonobject=communication3.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					advanceclientcostexport.setDocumentId(jsonobject.getString("id"));
				}}}
				
				if(jsonObject.isNull("documents14183")){
					advanceclientcostexport.setDocumentName(null);
				}else {
					JSONArray communication4=jsonObject.getJSONArray("documents14183");
					for(int k=0; k<=communication4.length()-1; k++) {
					JSONObject jsonobject=communication4.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					advanceclientcostexport.setDocumentName(jsonobject.getString("filename"));
				}}}
				
				
				
			advanceclientcostexportdao.insertAdvanceClientCostData(databaseName,advanceclientcostexport);
				
			}	
				
			}		
		
			}


		}
	

	
//List<String> exampleList = new ArrayList<String>();
//for (int i = 0; i < exampleArray.length; i++) {
 //   exampleList.add(exampleArray.getString(i));
//}
	
	
	
	
	
	
	
	
	
	
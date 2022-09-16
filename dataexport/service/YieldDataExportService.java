package com.filevine.dataexport.service;

import java.sql.SQLException;


import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.YieldDataExportDao;

import com.filevine.dataexport.domain.YieldDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class YieldDataExportService {

	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/yield/list/"+projectID;
		
		
		
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).get(String.class);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;

		}
	
	public void getAdvanceClientCostData(String response, String databaseName,String projectID) throws JSONException, SQLException {
		
		YieldDataExport yielddataexport= null;
		YieldDataExportDao yielddataexportdao=new YieldDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
	
		JSONObject jsonObj=new JSONObject(res);
		JSONArray data=jsonObj.getJSONArray("data");
	
		for(int j=0; j<=data.length()-1; j++) {
			yielddataexport= new YieldDataExport();
			yielddataexport.setProjectId(projectID);
			
			JSONObject jsonObject=data.getJSONObject(j);	
			if(jsonObject.isNull("id")) {
				yielddataexport.setId(null);
			}else {
		    if(!jsonObject.opt("id").equals(null)){
		    	yielddataexport.setId( jsonObject.getString("id"));
		    }}
			if(jsonObject.isNull("name")) {
				yielddataexport.setName(null);
			}else {
		    if(!jsonObject.opt("name").equals(null)){
		    	yielddataexport.setName( jsonObject.getString("name"));
		    }}
			if(jsonObject.isNull("offer")) {
				yielddataexport.setOffer(null);
			}else {
		    if(!jsonObject.opt("offer").equals(null)){
		    	yielddataexport.setOffer( jsonObject.getString("offer"));
		    }}
			if(jsonObject.isNull("attorneyPercentage")) {
				yielddataexport.setAttorneyPerc(null);
			}else {
		    if(!jsonObject.opt("attorneyPercentage").equals(null)){
		    	yielddataexport.setAttorneyPerc(jsonObject.getString("attorneyPercentage"));
		    }}
			if(jsonObject.isNull("attorneyAmount")) {
				yielddataexport.setAttorneyAmt(null);
			}else {
		    if(!jsonObject.opt("attorneyAmount").equals(null)){
		    	yielddataexport.setAttorneyAmt(jsonObject.getString("attorneyAmount"));
		    }}
			if(jsonObject.isNull("medicalBillAmount")) {
				yielddataexport.setMedicalBillAmt(null);
			}else {
		    if(!jsonObject.opt("medicalBillAmount").equals(null)){
		    	yielddataexport.setMedicalBillAmt(jsonObject.getString("medicalBillAmount"));
		    }}
			if(jsonObject.isNull("expenseAmount")) {
				yielddataexport.setExpenseAmt(null);
			}else {
		    if(!jsonObject.opt("expenseAmount").equals(null)){
		    	yielddataexport.setExpenseAmt(jsonObject.getString("expenseAmount"));
		    }}
			if(jsonObject.isNull("netToClient")) {
				yielddataexport.setNetToClient(null);
			}else {
		    if(!jsonObject.opt("netToClient").equals(null)){
		    	yielddataexport.setNetToClient(jsonObject.getString("netToClient"));
		    }}
			if(jsonObject.isNull("createDate")) {
				yielddataexport.setCreateDate(null);
			}else {
		    if(!jsonObject.opt("createDate").equals(null)){
		    	yielddataexport.setCreateDate(jsonObject.getString("createDate"));
		    }}
			if(jsonObject.isNull("creatorID")) {
				yielddataexport.setCreatorId(null);
			}else {
		    if(!jsonObject.opt("creatorID").equals(null)){
		    	yielddataexport.setCreatorId(jsonObject.getString("creatorID"));
		    }}
			if(jsonObject.isNull("creatorName")) {
				yielddataexport.setCreatorName(null);
			}else {
		    if(!jsonObject.opt("creatorName").equals(null)){
		    	yielddataexport.setCreatorName(jsonObject.getString("creatorName"));
		    }}
			if(jsonObject.isNull("notes")) {
				yielddataexport.setNotes(null);
			}else {
		    if(!jsonObject.opt("notes").equals(null)){
		    	yielddataexport.setNotes(jsonObject.getString("notes"));
		    }}
			if(jsonObject.isNull("hasCustomMeds")) {
				yielddataexport.setHasCustomMeds(null);
			}else {
		    if(!jsonObject.opt("hasCustomMeds").equals(null)){
		    	yielddataexport.setHasCustomMeds(jsonObject.getString("hasCustomMeds"));
		    }}
			if(jsonObject.isNull("hasCustomExpenses")) {
				yielddataexport.setHasCustomExpense(null);
			}else {
		    if(!jsonObject.opt("hasCustomExpenses").equals(null)){
		    	yielddataexport.setHasCustomExpense(jsonObject.getString("hasCustomExpenses"));
		    }}
			
//			JSONArray arrayLine=jsonObject.getJSONArray("lines");
//			for(int k=0; k<=arrayLine.length()-1; k++) {
//				JSONObject objLine=arrayLine.getJSONObject(k);	
//				if(objLine.isNull("id")) {
//					yielddataexport.setLineId(null);
//				}else {
//			    if(!objLine.opt("id").equals(null)){
//			    	yielddataexport.setLineId(objLine.getString("id"));
//			    }}
//				if(objLine.isNull("name")) {
//					yielddataexport.setLineName(null);
//				}else {
//			    if(!objLine.opt("name").equals(null)){
//			    	yielddataexport.setLineName(objLine.getString("name"));
//			    }}
//				if(objLine.isNull("amount")) {
//					yielddataexport.setAmount(null);
//				}else {
//			    if(!objLine.opt("amount").equals(null)){
//			    	yielddataexport.setAmount(objLine.getString("amount"));
//			    }}
//				if(objLine.isNull("netAmount")) {
//					yielddataexport.setNetAmount(null);
//				}else {
//			    if(!objLine.opt("netAmount").equals(null)){
//			    	yielddataexport.setNetAmount(objLine.getString("netAmount"));
//			    }}
//				if(objLine.isNull("itemType")) {
//					yielddataexport.setItemType(null);
//				}else {
//			    if(!objLine.opt("itemType").equals(null)){
//			    	yielddataexport.setItemType(objLine.getString("itemType"));
//			    }}
//				if(objLine.isNull("adjustmentAmount")) {
//					yielddataexport.setAdjustmentAmt(null);
//				}else {
//			    if(!objLine.opt("adjustmentAmount").equals(null)){
//			    	yielddataexport.setAdjustmentAmt(objLine.getString("adjustmentAmount"));
//			    }}
//				if(objLine.isNull("reductionPercentage")) {
//					yielddataexport.setReductionPercentage(null);
//				}else {
//			    if(!objLine.opt("reductionPercentage").equals(null)){
//			    	yielddataexport.setReductionPercentage(objLine.getString("reductionPercentage"));
//			    }}
//				if(objLine.isNull("isReductionPercentageLocked")) {
//					yielddataexport.setReductionPercentage(null);
//				}else {
//			    if(!objLine.opt("isReductionPercentageLocked").equals(null)){
//			    	yielddataexport.setIsReductionPercentageLocked(objLine.getString("isReductionPercentageLocked"));
//			    }}
//				if(objLine.isNull("isExcluded")) {
//					yielddataexport.setIsExcluded(null);
//				}else {
//			    if(!objLine.opt("isExcluded").equals(null)){
//			    	yielddataexport.setIsExcluded(objLine.getString("isExcluded"));
//			    }}
//				if(objLine.isNull("notes")) {
//					yielddataexport.setLineNotes(null);
//				}else {
//			    if(!objLine.opt("notes").equals(null)){
//			    	yielddataexport.setLineNotes(objLine.getString("notes"));
//			    }}
//				yielddataexportdao.insertLinesData(databaseName,yielddataexport);
//			}
			

			yielddataexportdao.insertYieldData(databaseName,yielddataexport);
	
	}
	
}
}
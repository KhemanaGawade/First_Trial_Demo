package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.FileVineSettlementExportDao;
import com.filevine.dataexport.domain.FileVineSettlementExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FileVineSettlementExportService {

	public String getFileVineSettlementExportResponse(String cookie, String projectID) {
	
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/yield/list/"+projectID; 
		
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
	
	public void getFileVineSettlementData(String response, String databaseName,String projectId ) throws JSONException, SQLException {
	
	
		FileVineSettlementExportDao fileVinesettlementexportdao=new FileVineSettlementExportDao();
		
		FileVineSettlementExport  fileVinesettlementexport =new FileVineSettlementExport ();
	
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject settlementData=new JSONObject(res);
		fileVinesettlementexport.setProjectId(Integer.parseInt(projectId));
		//if(!settlementData.opt("projectID").equals(null)){
			//fileVinesettlementexport.setProjectId(settlementData.getInt("projectID"));
		//}
	//	JSONObject data=settlementData.getJSONObject("data");
		JSONArray data=settlementData.getJSONArray("data");
		try {
		for(int j=0; j<=data.length()-1; j++) {
			JSONObject jsonObject=data.getJSONObject(j);
			//JSONObject jsonObject=data.getJSONObject(j);
			if(jsonObject.isNull("id")) {
				fileVinesettlementexport.setId(null);
			}else {
		    if(!jsonObject.opt("id").equals(null)){
		    	fileVinesettlementexport.setId( jsonObject.getString("id"));
		    }}
			if(jsonObject.isNull("name")) {
				fileVinesettlementexport.setName(null);
			}else {
		    if(!jsonObject.opt("name").equals(null)){
		    	fileVinesettlementexport.setName( jsonObject.getString("name"));
		    }}
			if(jsonObject.isNull("offer")) {
				fileVinesettlementexport.setOffer(null);
			}else {
		    if(!jsonObject.opt("offer").equals(null)){
		    	fileVinesettlementexport.setOffer( jsonObject.getString("offer"));
		    }}
			if(jsonObject.isNull("attorneyPercentage")) {
				fileVinesettlementexport.setAttorneyPerc(null);
			}else {
		    if(!jsonObject.opt("attorneyPercentage").equals(null)){
		    	fileVinesettlementexport.setAttorneyPerc(jsonObject.getString("attorneyPercentage"));
		    }}
			if(jsonObject.isNull("attorneyAmount")) {
				fileVinesettlementexport.setAttorneyAmt(null);
			}else {
		    if(!jsonObject.opt("attorneyAmount").equals(null)){
		    	fileVinesettlementexport.setAttorneyAmt(jsonObject.getString("attorneyAmount"));
		    }}
			if(jsonObject.isNull("medicalBillAmount")) {
				fileVinesettlementexport.setMedicalBillAmt(null);
			}else {
		    if(!jsonObject.opt("medicalBillAmount").equals(null)){
		    	fileVinesettlementexport.setMedicalBillAmt(jsonObject.getString("medicalBillAmount"));
		    }}
			if(jsonObject.isNull("expenseAmount")) {
				fileVinesettlementexport.setExpenseAmt(null);
			}else {
		    if(!jsonObject.opt("expenseAmount").equals(null)){
		    	fileVinesettlementexport.setExpenseAmt(jsonObject.getString("expenseAmount"));
		    }}
			if(jsonObject.isNull("netToClient")) {
				fileVinesettlementexport.setNetToClient(null);
			}else {
		    if(!jsonObject.opt("netToClient").equals(null)){
		    	fileVinesettlementexport.setNetToClient(jsonObject.getString("netToClient"));
		    }}
			if(jsonObject.isNull("createDate")) {
				fileVinesettlementexport.setCreateDate(null);
			}else {
		    if(!jsonObject.opt("createDate").equals(null)){
		    	fileVinesettlementexport.setCreateDate(jsonObject.getString("createDate"));
		    }}
			if(jsonObject.isNull("creatorID")) {
				fileVinesettlementexport.setCreatorId(null);
			}else {
		    if(!jsonObject.opt("creatorID").equals(null)){
		    	fileVinesettlementexport.setCreatorId(jsonObject.getString("creatorID"));
		    }}
			if(jsonObject.isNull("creatorName")) {
				fileVinesettlementexport.setCreatorName(null);
			}else {
		    if(!jsonObject.opt("creatorName").equals(null)){
		    	fileVinesettlementexport.setCreatorName(jsonObject.getString("creatorName"));
		    }}
			if(jsonObject.isNull("notes")) {
				fileVinesettlementexport.setNotes(null);
			}else {
		    if(!jsonObject.opt("notes").equals(null)){
		    	fileVinesettlementexport.setNotes(jsonObject.getString("notes"));
		    }}
			
			if(jsonObject.isNull("hasCustomMeds")) {
				fileVinesettlementexport.setHasCustomMeds(false);
			}else {
		    if(!jsonObject.opt("hasCustomMeds").equals(null)){
		    	fileVinesettlementexport.setHasCustomMeds(jsonObject.getBoolean("hasCustomMeds"));
		    }}
			if(jsonObject.isNull("hasCustomExpenses")) {
				fileVinesettlementexport.setHasCustomExpense(false);
			}else {
		    if(!jsonObject.opt("hasCustomExpenses").equals(null)){
		    	fileVinesettlementexport.setHasCustomExpense(jsonObject.getBoolean("hasCustomExpenses"));
		    }}
			
			JSONArray arrayLine=jsonObject.getJSONArray("lines");
			for(int k=0; k<=arrayLine.length()-1; k++) {
				JSONObject objLine=arrayLine.getJSONObject(k);	
				if(objLine.isNull("id")) {
					fileVinesettlementexport.setLineId(null);
				}else {
			    if(!objLine.opt("id").equals(null)){
			    	fileVinesettlementexport.setLineId(objLine.getString("id"));
			    }}
				if(objLine.isNull("name")) {
					fileVinesettlementexport.setLineName(null);
				}else {
			    if(!objLine.opt("name").equals(null)){
			    	fileVinesettlementexport.setLineName(objLine.getString("name"));
			    }}
				if(objLine.isNull("amount")) {
					fileVinesettlementexport.setAmount(null);
				}else {
			    if(!objLine.opt("amount").equals(null)){
			    	fileVinesettlementexport.setAmount(objLine.getString("amount"));
			    }}
				if(objLine.isNull("netAmount")) {
					fileVinesettlementexport.setNetAmount(null);
				}else {
			    if(!objLine.opt("netAmount").equals(null)){
			    	fileVinesettlementexport.setNetAmount(objLine.getString("netAmount"));
			    }}
				if(objLine.isNull("itemType")) {
					fileVinesettlementexport.setItemType(null);
				}else {
			    if(!objLine.opt("itemType").equals(null)){
			    	fileVinesettlementexport.setItemType(objLine.getString("itemType"));
			    }}
				if(objLine.isNull("adjustmentAmount")) {
					fileVinesettlementexport.setAdjustmentAmt(null);
				}else {
			    if(!objLine.opt("adjustmentAmount").equals(null)){
			    	fileVinesettlementexport.setAdjustmentAmt(objLine.getString("adjustmentAmount"));
			    }}
				if(objLine.isNull("reductionPercentage")) {
					fileVinesettlementexport.setReductionPercentage(null);
				}else {
			    if(!objLine.opt("reductionPercentage").equals(null)){
			    	fileVinesettlementexport.setReductionPercentage(objLine.getString("reductionPercentage"));
			    }}
				if(objLine.isNull("isReductionPercentageLocked")) {
					fileVinesettlementexport.setReductionPercentageLocked(false);
				}else {
			    if(!objLine.opt("isReductionPercentageLocked").equals(null)){
			    	fileVinesettlementexport.setReductionPercentageLocked(objLine.getBoolean("isReductionPercentageLocked"));
			    }}
				if(objLine.isNull("isExcluded")) {
					fileVinesettlementexport.setExcluded(false);
				}else {
			    if(!objLine.opt("isExcluded").equals(null)){
			    	fileVinesettlementexport.setExcluded(objLine.getBoolean("isExcluded"));
			    }}
				if(objLine.isNull("notes")) {
					fileVinesettlementexport.setLineNotes(null);
				}else {
			    if(!objLine.opt("notes").equals(null)){
			    	fileVinesettlementexport.setLineNotes(objLine.getString("notes"));
			    }}
				fileVinesettlementexportdao.insertLinesData(fileVinesettlementexport,databaseName);
			}
			fileVinesettlementexportdao.insertSettlementData(databaseName,fileVinesettlementexport);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
}
	}

	

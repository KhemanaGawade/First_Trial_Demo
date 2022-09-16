package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.IntakeExportDao;
import com.filevine.dataexport.dao.YieldExportDao;
import com.filevine.dataexport.domain.IntakeExport;
import com.filevine.dataexport.domain.NotesExport;
import com.filevine.dataexport.domain.YieldExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class YieldExportService {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");


	public String getYieldResponse(String cookie, String projectId) {
		MDC.put("path", "File Vine:: Yield Export");
        String response=null;
	//	String url="https://app.filevine.com/api/yield/list/"+projectId;
       String url="https://app.filevine.com/api/yield/list/"+projectId;
	//	String url="https://app.filevine.com/api/yield/list/10725782";
		
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).get(String.class);
//				System.out.println("response :: "+response);	
			eventLogger.info("Response has been exported!!");
		    }
			
		catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Fail to get repsonse from UI");
//			e.printStackTrace();
		}
		return response;
	}

	public void getYieldData(String response, String databaseName,String projectId) throws JSONException {
		YieldExportDao yieldExportDao=new YieldExportDao();
		YieldExport yieldExport = new YieldExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject jsonObj=new JSONObject(res);
		JSONArray data=jsonObj.getJSONArray("data");
		yieldExport.setProjectId(Integer.parseInt(projectId));
		//System.out.println("notes count : " +notes.length());
		try {
		for(int j=0; j<=data.length()-1; j++) {
			JSONObject jsonObject=data.getJSONObject(j);	
			if(jsonObject.isNull("id")) {
				yieldExport.setId(null);
			}else {
		    if(!jsonObject.opt("id").equals(null)){
		    	yieldExport.setId( jsonObject.getString("id"));
		    }}
			if(jsonObject.isNull("name")) {
				yieldExport.setName(null);
			}else {
		    if(!jsonObject.opt("name").equals(null)){
		    	yieldExport.setName( jsonObject.getString("name"));
		    }}
			if(jsonObject.isNull("offer")) {
				yieldExport.setOffer(null);
			}else {
		    if(!jsonObject.opt("offer").equals(null)){
		    	yieldExport.setOffer( jsonObject.getString("offer"));
		    }}
			if(jsonObject.isNull("attorneyPercentage")) {
				yieldExport.setAttorneyPerc(null);
			}else {
		    if(!jsonObject.opt("attorneyPercentage").equals(null)){
		    	yieldExport.setAttorneyPerc(jsonObject.getString("attorneyPercentage"));
		    }}
			if(jsonObject.isNull("attorneyAmount")) {
				yieldExport.setAttorneyAmt(null);
			}else {
		    if(!jsonObject.opt("attorneyAmount").equals(null)){
		    	yieldExport.setAttorneyAmt(jsonObject.getString("attorneyAmount"));
		    }}
			if(jsonObject.isNull("medicalBillAmount")) {
				yieldExport.setMedicalBillAmt(null);
			}else {
		    if(!jsonObject.opt("medicalBillAmount").equals(null)){
		    	yieldExport.setMedicalBillAmt(jsonObject.getString("medicalBillAmount"));
		    }}
			if(jsonObject.isNull("expenseAmount")) {
				yieldExport.setExpenseAmt(null);
			}else {
		    if(!jsonObject.opt("expenseAmount").equals(null)){
		    	yieldExport.setExpenseAmt(jsonObject.getString("expenseAmount"));
		    }}
			if(jsonObject.isNull("netToClient")) {
				yieldExport.setNetToClient(null);
			}else {
		    if(!jsonObject.opt("netToClient").equals(null)){
		    	yieldExport.setNetToClient(jsonObject.getString("netToClient"));
		    }}
			if(jsonObject.isNull("createDate")) {
				yieldExport.setCreateDate(null);
			}else {
		    if(!jsonObject.opt("createDate").equals(null)){
		    	yieldExport.setCreateDate(jsonObject.getString("createDate"));
		    }}
			if(jsonObject.isNull("creatorID")) {
				yieldExport.setCreatorId(null);
			}else {
		    if(!jsonObject.opt("creatorID").equals(null)){
		    	yieldExport.setCreatorId(jsonObject.getString("creatorID"));
		    }}
			if(jsonObject.isNull("creatorName")) {
				yieldExport.setCreatorName(null);
			}else {
		    if(!jsonObject.opt("creatorName").equals(null)){
		    	yieldExport.setCreatorName(jsonObject.getString("creatorName"));
		    }}
			if(jsonObject.isNull("notes")) {
				yieldExport.setNotes(null);
			}else {
		    if(!jsonObject.opt("notes").equals(null)){
		    	yieldExport.setNotes(jsonObject.getString("notes"));
		    }}
			if(jsonObject.isNull("hasCustomMeds")) {
				yieldExport.setHasCustomMeds(null);
			}else {
		    if(!jsonObject.opt("hasCustomMeds").equals(null)){
		    	yieldExport.setHasCustomMeds(jsonObject.getString("hasCustomMeds"));
		    }}
			if(jsonObject.isNull("hasCustomExpenses")) {
				yieldExport.setHasCustomExpense(null);
			}else {
		    if(!jsonObject.opt("hasCustomExpenses").equals(null)){
		    	yieldExport.setHasCustomExpense(jsonObject.getString("hasCustomExpenses"));
		    }}
			JSONArray arrayLine=jsonObject.getJSONArray("lines");
			for(int k=0; k<=arrayLine.length()-1; k++) {
				JSONObject objLine=arrayLine.getJSONObject(k);	
				if(objLine.isNull("id")) {
					yieldExport.setLineId(null);
				}else {
			    if(!objLine.opt("id").equals(null)){
			    	yieldExport.setLineId(objLine.getString("id"));
			    }}
				if(objLine.isNull("name")) {
					yieldExport.setLineName(null);
				}else {
			    if(!objLine.opt("name").equals(null)){
			    	yieldExport.setLineName(objLine.getString("name"));
			    }}
				if(objLine.isNull("amount")) {
					yieldExport.setAmount(null);
				}else {
			    if(!objLine.opt("amount").equals(null)){
			    	yieldExport.setAmount(objLine.getString("amount"));
			    }}
				if(objLine.isNull("netAmount")) {
					yieldExport.setNetAmount(null);
				}else {
			    if(!objLine.opt("netAmount").equals(null)){
			    	yieldExport.setNetAmount(objLine.getString("netAmount"));
			    }}
				if(objLine.isNull("itemType")) {
					yieldExport.setItemType(null);
				}else {
			    if(!objLine.opt("itemType").equals(null)){
			    	yieldExport.setItemType(objLine.getString("itemType"));
			    }}
				if(objLine.isNull("adjustmentAmount")) {
					yieldExport.setAdjustmentAmt(null);
				}else {
			    if(!objLine.opt("adjustmentAmount").equals(null)){
			    	yieldExport.setAdjustmentAmt(objLine.getString("adjustmentAmount"));
			    }}
				if(objLine.isNull("reductionPercentage")) {
					yieldExport.setReductionPercentage(null);
				}else {
			    if(!objLine.opt("reductionPercentage").equals(null)){
			    	yieldExport.setReductionPercentage(objLine.getString("reductionPercentage"));
			    }}
				if(objLine.isNull("isReductionPercentageLocked")) {
					yieldExport.setReductionPercentage(null);
				}else {
			    if(!objLine.opt("isReductionPercentageLocked").equals(null)){
			    	yieldExport.setIsReductionPercentageLocked(objLine.getString("isReductionPercentageLocked"));
			    }}
				if(objLine.isNull("isExcluded")) {
					yieldExport.setIsExcluded(null);
				}else {
			    if(!objLine.opt("isExcluded").equals(null)){
			    	yieldExport.setIsExcluded(objLine.getString("isExcluded"));
			    }}
				if(objLine.isNull("notes")) {
					yieldExport.setLineNotes(null);
				}else {
			    if(!objLine.opt("notes").equals(null)){
			    	yieldExport.setLineNotes(objLine.getString("notes"));
			    }}
				yieldExportDao.insertLinesData(yieldExport,databaseName);
			}
			yieldExportDao.insertYieldData(yieldExport,databaseName);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

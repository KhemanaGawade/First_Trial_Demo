package com.filevine.dataexport.service;

import java.sql.SQLException;


import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.BodyInjuryExportDao;

import com.filevine.dataexport.domain.BodyInjuryExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class BodyInjuryExportService {

	public String getBodyInjuryExportResponse(String cookie, String projectID) {
	
		String response=null;
	  
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/intakeinfo1032?page=1";
	
		String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	
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
	public void getBodyInjuryData(String response, String databaseName) throws JSONException, SQLException {
	
	
		 BodyInjuryExport  bodyinjuryexport=new  BodyInjuryExport();
		 BodyInjuryExportDao bodyinjuryexportdao=new BodyInjuryExportDao();
	
		 String 	res=response;
			int i=res.indexOf('{');
			res=res.substring(i);
	
			JSONObject bodyinjury=new JSONObject(res);
			if(!bodyinjury.opt("projectID").equals(null)){
				bodyinjuryexport.setProjectId(bodyinjury.getInt("projectID"));
			}
			JSONObject data=bodyinjury.getJSONObject("data");
			
			if(data.isNull("customObject")) {
				System.out.println("No data found");
			}else {
			JSONObject jsonData=data.getJSONObject("customObject");
			
			if(jsonData.isNull("injuriessustained14196")) {
				bodyinjuryexport.setInjuriesSustained( null);
				}else {
					
			    if(!jsonData.opt("injuriessustained14196").equals(null)){
			    	bodyinjuryexport.setInjuriesSustained( jsonData.getString("injuriessustained14196"));
			 }} 
			
			if(jsonData.isNull("describeinjuriessustainedpaincompla14196")) {
				bodyinjuryexport.setDescribeInjuriesSustainedPainComplaints( null);
				}else {
					
			    if(!jsonData.opt("describeinjuriessustainedpaincompla14196").equals(null)){
			    	bodyinjuryexport.setDescribeInjuriesSustainedPainComplaints( jsonData.getString("describeinjuriessustainedpaincompla14196"));
			 }} 
			
			if(jsonData.isNull("permanentinjuryorscarring14196")) {
				bodyinjuryexport.setPermanentInjuryOrScarring( null);
				}else {
					
			    if(!jsonData.opt("permanentinjuryorscarring14196").equals(null)){
			    	bodyinjuryexport.setPermanentInjuryOrScarring( jsonData.getString("permanentinjuryorscarring14196"));
			 }} 
			
			if(jsonData.isNull("picturestakenofinjuries14196")) {
				bodyinjuryexport.setPicturestakenofInjuries( null);
				}else {
					
			    if(!jsonData.opt("picturestakenofinjuries14196").equals(null)){
			    	bodyinjuryexport.setPicturestakenofInjuries( jsonData.getString("picturestakenofinjuries14196"));
			 }} 
			
//			JSONArray arrayLine=jsonData.getJSONArray("picturesofinjuries14196");
//			for(int k=0; k<=arrayLine.length()-1; k++) {
//				JSONObject objLine=arrayLine.getJSONObject(k);	
//				if(objLine.isNull("filename")) {
//					bodyinjuryexport.setPicturesOfInjuries(null);
//				}else {
//			    if(!objLine.opt("filename").equals(null)){
//			    	bodyinjuryexport.setPicturesOfInjuries(objLine.getString("filename"));
//			    }}
//			}
			
			if(jsonData.isNull("treatmentinfo14196")) {
				bodyinjuryexport.setTreatmentInfo( null);
				}else {
					
			    if(!jsonData.opt("treatmentinfo14196").equals(null)){
			    	bodyinjuryexport.setTreatmentInfo( jsonData.getString("treatmentinfo14196"));
			 }}
			
			if(jsonData.isNull("primarycarephysician14196")) {
				bodyinjuryexport.setPrimarycarePhysician(null);
				}else {
					
			    if(!jsonData.opt("primarycarephysician14196").equals(null)){
			    	bodyinjuryexport.setPrimarycarePhysician( jsonData.getString("primarycarephysician14196"));
			 }}
			
			if(jsonData.isNull("healthinsurance14196")) {
				bodyinjuryexport.setHealthInsurance(null);
				}else {
					
			    if(!jsonData.opt("healthinsurance14196").equals(null)){
			    	bodyinjuryexport.setHealthInsurance( jsonData.getString("healthinsurance14196"));
			 }}
			
			if(jsonData.isNull("medicaremedicaid14196")) {
				bodyinjuryexport.setMedicareMedicaid(null);
				}else {
					
			    if(!jsonData.opt("medicaremedicaid14196").equals(null)){
			    	bodyinjuryexport.setMedicareMedicaid( jsonData.getString("medicaremedicaid14196"));
			 }}
			
			if(jsonData.isNull("priortreatmentdocinfo14196")) {
				bodyinjuryexport.setPriorTreatmentdocInfo(null);
				}else {
					
			    if(!jsonData.opt("priortreatmentdocinfo14196").equals(null)){
			    	bodyinjuryexport.setPriorTreatmentdocInfo( jsonData.getString("priortreatmentdocinfo14196"));
			 }}
			if(jsonData.isNull("priorincidents14196")) {
				bodyinjuryexport.setPriorIncidents(null);
				}else {
					
			    if(!jsonData.opt("priorincidents14196").equals(null)){
			    	bodyinjuryexport.setPriorIncidents( jsonData.getString("priorincidents14196"));
			 }}
			
			if(jsonData.isNull("priorincidentinfo14196")) {
				bodyinjuryexport.setPriorIncidentInfo(null);
				}else {
					
			    if(!jsonData.opt("priorincidentinfo14196").equals(null)){
			    	bodyinjuryexport.setPriorIncidentInfo( jsonData.getString("priorincidentinfo14196"));
			 }}
			
			if(jsonData.isNull("criminalhistory14196")) {
				bodyinjuryexport.setCriminalHistory(null);
				}else {
					
			    if(!jsonData.opt("criminalhistory14196").equals(null)){
			    	bodyinjuryexport.setCriminalHistory( jsonData.getString("criminalhistory14196"));
			 }}
			
			if(jsonData.isNull("anycriminalhistory14196")) {
				bodyinjuryexport.setCriminalHistoryDetails(null);
				}else {
					
			    if(!jsonData.opt("anycriminalhistory14196").equals(null)){
			    	bodyinjuryexport.setCriminalHistoryDetails( jsonData.getString("anycriminalhistory14196"));
			 }}
			
			
			if(jsonData.isNull("negligencenotes14196")) {
				bodyinjuryexport.setNegligenceNotes(null);
				}else {
					
			    if(!jsonData.opt("negligencenotes14196").equals(null)){
			    	bodyinjuryexport.setNegligenceNotes( jsonData.getString("negligencenotes14196"));
			 }}
			bodyinjuryexportdao.insertBodyInjuryData(databaseName,bodyinjuryexport);
			
	}	
	
}
}
package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DeposExportDao;
import com.filevine.dataexport.dao.LitigationExportDao;
import com.filevine.dataexport.domain.DeposExport;
import com.filevine.dataexport.domain.LitigationExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LitigationExportService {

	public String getLitigationResponse(String cookie, String projectID) {
		 String response=null;
         String url="https://app.filevine.com/api/projects/"+projectID+"/chains";
			try {
				WebResource webRespource=Client.create().resource(url);
				response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).get(String.class);
//					System.out.println("response :: "+response);	
			    }
			catch(Exception e) {
				System.out.println("Fail to get repsonse from UI");
				e.printStackTrace();
			}
			return response;
	}

	public void getLitigationData(String response, String databaseName,String projectID) throws JSONException, SQLException {
		LitigationExportDao litigationExportDao=new LitigationExportDao();
		LitigationExport litigationExport=new LitigationExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		//System.out.println("Project ID :"+jsonObj.getInt("projectID"));
		litigationExport.setProjectId(projectID);
		JSONArray obj=jsonObj.getJSONArray("data");
		for(int j=0; j<=obj.length()-1; j++) {
			
			JSONObject jsonObject=obj.getJSONObject(j);
			if(jsonObject.isNull("id")) {
				litigationExport.setId(null);
			}else {
			if(!jsonObject.opt("id").equals(null)) {
				litigationExport.setId(jsonObject.getString("id"));
			}}
			if(!jsonObject.isNull("visibleDates")) {
			JSONArray arr=jsonObject.getJSONArray("visibleDates");
			for(int k=0; k<=arr.length()-1; k++) {
				JSONObject visibleDates=arr.getJSONObject(k);
				if(visibleDates.isNull("id")) {
					litigationExport.setVisibleDateId(null);
				}else {
				if(!visibleDates.opt("id").equals(null)) {
					litigationExport.setVisibleDateId(visibleDates.getString("id"));
				}}
				if(visibleDates.isNull("dueDate")) {
					litigationExport.setVisibleDateId(null);
				}else {
				if(!visibleDates.opt("dueDate").equals(null)) {
					litigationExport.setDueDate(visibleDates.getString("dueDate"));
				}}
				if(visibleDates.isNull("doneDate")) {
					litigationExport.setDoneDate(null);
				}else {
				if(!visibleDates.opt("doneDate").equals(null)) {
					litigationExport.setDoneDate(visibleDates.getString("doneDate"));
				}}
				if(visibleDates.isNull("chainDateTypeID")) {
					litigationExport.setChainDateTypeID(null);
				}else {
				if(!visibleDates.opt("chainDateTypeID").equals(null)) {
					litigationExport.setChainDateTypeID(visibleDates.getString("chainDateTypeID"));
				}}
				if(visibleDates.isNull("name")) {
					litigationExport.setVisibleDateName(null);
				}else {
				if(!visibleDates.opt("name").equals(null)) {
					litigationExport.setVisibleDateName(visibleDates.getString("name"));
				}}
				if(visibleDates.isNull("behavior")) {
					litigationExport.setBehavior(null);
				}else {
				if(!visibleDates.opt("behavior").equals(null)) {
					litigationExport.setBehavior(visibleDates.getString("behavior"));
				}}
				if(visibleDates.isNull("notes")) {
					litigationExport.setNotes(null);
				}else {
				if(!visibleDates.opt("notes").equals(null)) {
					litigationExport.setNotes(visibleDates.getString("notes"));
				}}
				if(visibleDates.isNull("chainDateTypeUrl")) {
					litigationExport.setChainDateTypeUrl(null);
				}else {
				if(!visibleDates.opt("chainDateTypeUrl").equals(null)) {
					litigationExport.setChainDateTypeUrl(visibleDates.getString("chainDateTypeUrl"));
				}}
				if(visibleDates.isNull("chainDateTypeNotes")) {
					litigationExport.setChainDateTypeNotes(null);
				}else {
				if(!visibleDates.opt("chainDateTypeNotes").equals(null)) {
					litigationExport.setChainDateTypeNotes(visibleDates.getString("chainDateTypeNotes"));
				}}
				litigationExportDao.insertVisibleDatesData(litigationExport,databaseName);
			}}
//			if(jsonObject.isNull("mainDate")) {
//				litigationExport.setMainDate(null);
//			}else {
//			if(!jsonObject.opt("mainDate").equals(null)) {
//				litigationExport.setMainDate(jsonObject.getString("mainDate"));
//			}}
//			if(jsonObject.isNull("name")) {
//				litigationExport.setName(null);
//			}else {
//			if(!jsonObject.opt("name").equals(null)) {
//				litigationExport.setName(jsonObject.getString("name"));
//			}}
//			if(jsonObject.isNull("chainTypeName")) {
//				litigationExport.setChainTypeName(null);
//			}else {
//			if(!jsonObject.opt("chainTypeName").equals(null)) {
//				litigationExport.setChainTypeName(jsonObject.getString("chainTypeName"));
//			}}
//			if(jsonObject.isNull("chainTypeID")) {
//				litigationExport.setChainTypeID(null);
//			}else {
//			if(!jsonObject.opt("chainTypeID").equals(null)) {
//				litigationExport.setChainTypeID(jsonObject.getString("chainTypeID"));
//			}}
//			if(jsonObject.isNull("chainTypeUrl")) {
//				litigationExport.setChainTypeUrl(null);
//			}else {
//			if(!jsonObject.opt("chainTypeUrl").equals(null)) {
//				litigationExport.setChainTypeUrl(jsonObject.getString("chainTypeUrl"));
//			}}
//			if(jsonObject.isNull("chainTypeNotes")) {
//				litigationExport.setChainTypeNotes(null);
//			}else {
//			if(!jsonObject.opt("chainTypeNotes").equals(null)) {
//				litigationExport.setChainTypeNotes(jsonObject.getString("chainTypeNotes"));
//			}}
//			if(jsonObject.isNull("chainTypeJurisdictionName")) {
//				litigationExport.setChainTypeJurisdictionName(null);
//			}else {
//			if(!jsonObject.opt("chainTypeJurisdictionName").equals(null)) {
//				litigationExport.setChainTypeJurisdictionName(jsonObject.getString("chainTypeJurisdictionName"));
//			}}
			litigationExportDao.insertLitigationData(litigationExport,databaseName);
		}
	}

}

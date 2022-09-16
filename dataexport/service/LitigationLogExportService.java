package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DeposExportDao;
import com.filevine.dataexport.dao.LitigationLogExportDao;
import com.filevine.dataexport.domain.DeposExport;
import com.filevine.dataexport.domain.LitigationLogExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LitigationLogExportService {

	public String getLitigationLogResponse(String cookie, String projectID,int pageNumber) {
		 String response=null;
         String url="https://app.filevine.com/api/projects/"+projectID+"/custom/writtendisc16407?page="+pageNumber;
         String payLoad="{\"pageNumber\":"+pageNumber+",\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
			try {
				WebResource webRespource=Client.create().resource(url);
				response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
					System.out.println("response :: "+response);	
			    }
			catch(Exception e) {
				System.out.println("Fail to get repsonse from UI");
				e.printStackTrace();
			}
			return response;
	}

	public void getLitigationLogData(String response, String databaseName) throws JSONException, SQLException {
		LitigationLogExportDao litigationLogExportDao=new LitigationLogExportDao();
		LitigationLogExport litigationLogExport=new LitigationLogExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		//System.out.println("Project ID :"+jsonObj.getInt("projectID"));
		if(!jsonObj.opt("projectID").equals(null)){
			litigationLogExport.setProjectId(jsonObj.getString("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
		JSONArray obj=data.getJSONArray("collection");
		for(int j=0; j<=obj.length()-1; j++) {
			
			JSONObject jsonObject=obj.getJSONObject(j);
			
			if(jsonObject.isNull("done191316")) {
				litigationLogExport.setDone(null);
			}else {
			if(!jsonObject.opt("done191316").equals(null)) {
				litigationLogExport.setDone(jsonObject.getString("done191316"));
			}}
			if(jsonObject.isNull("inout191316")) {
				litigationLogExport.setInout(null);
			}else {
			if(!jsonObject.opt("inout191316").equals(null)) {
				litigationLogExport.setInout(jsonObject.getString("inout191316"));
			}}
			if(jsonObject.isNull("notes191316")) {
				litigationLogExport.setNotes(null);
			}else {
			if(!jsonObject.opt("notes191316").equals(null)) {
				litigationLogExport.setNotes(jsonObject.getString("notes191316"));
			}}
			if(jsonObject.isNull("type191316")) {
				litigationLogExport.setType(null);
			}else {
			if(!jsonObject.opt("type191316").equals(null)) {
				litigationLogExport.setType(jsonObject.getString("type191316"));
			}}
			if(jsonObject.isNull("title191316")) {
				litigationLogExport.setTitle(null);
			}else {
			if(!jsonObject.opt("title191316").equals(null)) {
				litigationLogExport.setTitle(jsonObject.getString("title191316"));
			}}
			if(jsonObj.isNull("drafter191316")) {
				litigationLogExport.setDrafter_id("");
			}else {
				JSONObject drafter = jsonObj.getJSONObject("drafter191316") ;
				if(drafter.isNull("id")) {
					litigationLogExport.setDrafter_id(null);
				}else {
				if(!drafter.opt("id").equals(null)) {
					litigationLogExport.setDrafter_id(drafter.getString("id"));
				}}
			}
			if(jsonObject.isNull("_id")) {
				litigationLogExport.set_id(null);
			}else {
			if(!jsonObject.opt("_id").equals(null)) {
				litigationLogExport.set_id(jsonObject.getString("_id"));
			}}
			if(!jsonObject.isNull("_itemHeader")) {
				JSONObject itemHeader = jsonObject.getJSONObject("_itemHeader") ;
				
				if(itemHeader.isNull("createdDate")) {
					litigationLogExport.setCreatedDate( null);
				}else {
			    if(!itemHeader.opt("createdDate").equals(null)){
			    	litigationLogExport.setCreatedDate(itemHeader.getString("createdDate"));
			 }}}
			if(!jsonObject.isNull("response48366")) {
				JSONObject responseDate = jsonObject.getJSONObject("response48366") ;
				
				if(responseDate.isNull("dateValue")) {
					litigationLogExport.setResponseDateValue(null);
				}else {
			    if(!responseDate.opt("dateValue").equals(null)){
			    	litigationLogExport.setResponseDateValue(responseDate.getString("dateValue"));
			 }}
				if(responseDate.isNull("doneDate")) {
					litigationLogExport.setResponseDoneDate(null);
				}else {
			    if(!responseDate.opt("doneDate").equals(null)){
			    	litigationLogExport.setResponseDoneDate(responseDate.getString("doneDate"));
			 }}
			}
			litigationLogExportDao.insertLitigationLogData(databaseName,litigationLogExport);
		}
		}
		
	}

}

package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.FileVineContactDao;

import com.filevine.dataexport.domain.ContactInfoDataDomain;
import com.filevine.dataexport.domain.FileVineContactDomain;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class FileVineContactService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/uniquecontacts";
		
		
		
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
	
		FileVineContactDao filevinecontactdao=new FileVineContactDao();
		FileVineContactDomain filevinecontactdomain=null;
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject data=new JSONObject(res);
		
	
		if(!data.opt("data").equals(null)) {
			JSONArray communication=data.getJSONArray("data");
			for(int j=0; j<=communication.length()-1; j++) {
				
				filevinecontactdomain=new FileVineContactDomain();
				filevinecontactdomain.setProjectId(projectID);
				JSONObject jsonObject=communication.getJSONObject(j);
				
				
	         	
		
		if(jsonObject.isNull("id")) {
			filevinecontactdomain.setId( null);
		}else {
			
	    if(!jsonObject.opt("id").equals(null)){
	    	filevinecontactdomain.setId( jsonObject.getString("id"));
	    }}

		if(jsonObject.isNull("role")) {
			filevinecontactdomain.setRole( null);
		}else {
			
	    if(!jsonObject.opt("role").equals(null)){
	    	filevinecontactdomain.setRole( jsonObject.getString("role"));
	    }}

		if(jsonObject.isNull("personID")) {
			filevinecontactdomain.setPersonID( null);
		}else {
			
	    if(!jsonObject.opt("personID").equals(null)){
	    	filevinecontactdomain.setPersonID( jsonObject.getString("personID"));
	    }}
		
		if(jsonObject.isNull("breadcrumbs")){
			filevinecontactdomain.setPersonRole(null);
		}else {
			JSONArray communication3=jsonObject.getJSONArray("breadcrumbs");
			for(int k=0; k<=communication3.length()-1; k++) {
			JSONObject jsonobject=communication3.getJSONObject(k);
		if(!jsonobject.opt("fieldName").equals(null)){
			filevinecontactdomain.setPersonRole(jsonobject.getString("fieldName"));
		}}}
		
		if(jsonObject.isNull("breadcrumbs")){
			filevinecontactdomain.setPersonTitle(null);
		}else {
			JSONArray communication4=jsonObject.getJSONArray("breadcrumbs");
			for(int k=0; k<=communication4.length()-1; k++) {
			JSONObject jsonobject=communication4.getJSONObject(k);
		if(!jsonobject.opt("title").equals(null)){
			filevinecontactdomain.setPersonTitle(jsonobject.getString("title"));
		}}}
		
		
		if(jsonObject.isNull("breadcrumbs")){
			filevinecontactdomain.setRoleUniqueId(null);
		}else {
			JSONArray communication6=jsonObject.getJSONArray("breadcrumbs");
			for(int k=0; k<=communication6.length()-1; k++) {
			JSONObject jsonobject=communication6.getJSONObject(k);
		if(!jsonobject.opt("id").equals(null)){
			filevinecontactdomain.setRoleUniqueId(jsonobject.getString("id"));
		}}}

		filevinecontactdao.insertfilevinecontactData(databaseName,filevinecontactdomain);
		
	}	
		
	}		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

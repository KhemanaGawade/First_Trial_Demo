package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DefenceCounselExportDao;
import com.filevine.dataexport.dao.DeposExportDao;
import com.filevine.dataexport.domain.DefenceCounselExport;
import com.filevine.dataexport.domain.DeposExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for defence coiunsel tab from ui
 **/
public class DefenceCounselExportService {

	/**
	 * @return a response for defence counsel from filevine  url by passing parameter cookie,project id
	 */
	public String getDefenceCounselResponse(String cookie, String projectID) {
		 String response=null;
         String url="https://app.filevine.com/api/projects/"+projectID+"/custom/s1_defensecounse16433?page=1";
         String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
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

	
	/**
	 * Taking input as a response.
	 * Converting JSON response to OBJECT
	 * Creating object of DefenceCounselExport class
	 * Setting values to setter methods of DefenceCounselExport class
	 * Calling method of DefenceCounselExportDao to insert all values using databaseName
	 */
	public void getDefenceCounselData(String response, String databaseName) throws JSONException, SQLException {
		DefenceCounselExportDao defenceCounselExportDao=new DefenceCounselExportDao();
		DefenceCounselExport defenceCounselExport=new DefenceCounselExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		//System.out.println("Project ID :"+jsonObj.getInt("projectID"));
		if(!jsonObj.opt("projectID").equals(null)){
			defenceCounselExport.setProjectId(jsonObj.getString("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
		JSONArray obj=data.getJSONArray("collection");
		for(int j=0; j<=obj.length()-1; j++) {
			
			JSONObject jsonObject=obj.getJSONObject(j);
			if(!jsonObject.isNull("firmname248749")){
				JSONObject firmName=jsonObject.getJSONObject("firmname248749");
			if(firmName.isNull("id")) {
				defenceCounselExport.setFirmNameId(null);
			}else {
			if(!firmName.opt("id").equals(null)) {
				defenceCounselExport.setFirmNameId(firmName.getString("id"));
			}}}
			if(!jsonObject.isNull("leadcounsel248749")){
				JSONObject leadCounsel=jsonObject.getJSONObject("leadcounsel248749");
				if(leadCounsel.isNull("id")) {
					defenceCounselExport.setLeadcounselId(null);
			}else {
			if(!leadCounsel.opt("id").equals(null)) {
					defenceCounselExport.setLeadcounselId(leadCounsel.getString("id"));
			}}}
			if(!jsonObject.isNull("assistantattorney248749")){
				JSONObject assistantAttorney=jsonObject.getJSONObject("assistantattorney248749");
				if(assistantAttorney.isNull("id")) {
					defenceCounselExport.setAssistantattorneyId(null);
			}else {
			if(!assistantAttorney.opt("id").equals(null)) {
					defenceCounselExport.setAssistantattorneyId(assistantAttorney.getString("id"));
			}}}
			if(!jsonObject.isNull("legalassistant248749")){
				JSONObject legalassistant=jsonObject.getJSONObject("legalassistant248749");
				if(legalassistant.isNull("id")) {
					defenceCounselExport.setLegalassistantId(null);
			}else {
			if(!legalassistant.opt("id").equals(null)) {
					defenceCounselExport.setLegalassistantId(legalassistant.getString("id"));
			}}}
			if(!jsonObject.isNull("paralegal248749")){
				JSONObject paralegal=jsonObject.getJSONObject("paralegal248749");
				if(paralegal.isNull("id")) {
					defenceCounselExport.setParalegalId(null);
			}else {
			if(!paralegal.opt("id").equals(null)) {
					defenceCounselExport.setParalegalId(paralegal.getString("id"));
			}}}
			if(jsonObject.isNull("notes248749")) {
				defenceCounselExport.setNotes(null);
			}else {
			if(!jsonObject.opt("notes248749").equals(null)) {
				defenceCounselExport.setNotes(jsonObject.getString("notes248749"));
			}}
			if(jsonObject.isNull("_id")) {
				defenceCounselExport.setId(null);
			}else {
			if(!jsonObject.opt("_id").equals(null)) {
				defenceCounselExport.setId(jsonObject.getString("_id"));
			}}
			if(!jsonObject.isNull("_itemHeader")) {
				JSONObject e = jsonObject.getJSONObject("_itemHeader") ;
				
				if(e.isNull("createdDate")) {
					defenceCounselExport.setCreatedDate( null);
				}else {
			    if(!e.opt("createdDate").equals(null)){
			    	defenceCounselExport.setCreatedDate(e.getString("createdDate"));
		    }}}
			defenceCounselExportDao.insertDefenceCounselData(defenceCounselExport,databaseName);
		}
		}
		
	}

}

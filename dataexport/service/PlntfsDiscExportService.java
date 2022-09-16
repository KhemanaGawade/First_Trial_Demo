package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.InsuranceExportDao;
import com.filevine.dataexport.dao.PlntfsDiscExportDao;
import com.filevine.dataexport.domain.InsuranceExport;
import com.filevine.dataexport.domain.PlntfsDiscExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class PlntfsDiscExportService {

	public String getPlntfsDiscResponse(String cookie, String projectID) {
		   String response=null;
           String url="https://app.filevine.com/api/projects/"+projectID+"/custom/plntfsdisc6573?page=1";
           String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
			try {
				WebResource webRespource=Client.create().resource(url);
				response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
//					System.out.println("response :: "+response);	
			    }
			catch(Exception e) {
				System.out.println("Fail to get repsonse from UI");
				e.printStackTrace();
			}
			return response;
	}

	public void getPlntfsDiscData(String response, String databaseName) throws JSONException, SQLException {
		PlntfsDiscExportDao plntfsDiscExportDao=new PlntfsDiscExportDao();
		PlntfsDiscExport plntfsDiscExport=new PlntfsDiscExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		//System.out.println("Project ID :"+jsonObj.getInt("projectID"));
		if(!jsonObj.opt("projectID").equals(null)){
			plntfsDiscExport.setProjectId(jsonObj.getString("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
		JSONArray obj=data.getJSONArray("collection");
		for(int j=0; j<=obj.length()-1; j++) {
			
			JSONObject jsonObject=obj.getJSONObject(j);

			if(jsonObject.isNull("notes48364")) {
				plntfsDiscExport.setNotes(null);
			}else {
			if(!jsonObject.opt("notes48364").equals(null)) {
				plntfsDiscExport.setNotes(jsonObject.getString("notes48364"));
			}}
			if(jsonObject.isNull("disclosuredate48364")) {
				plntfsDiscExport.setDisclosuredate(null);
			}else {
			if(!jsonObject.opt("disclosuredate48364").equals(null)) {
				plntfsDiscExport.setDisclosuredate(jsonObject.getString("disclosuredate48364"));
			}}
			if(jsonObject.isNull("_id")) {
				plntfsDiscExport.setId(null);
			}else {
			if(!jsonObject.opt("_id").equals(null)) {
				plntfsDiscExport.setId(jsonObject.getString("_id"));
			}}
			if(!jsonObj.isNull("_itemHeader")) {
			JSONObject e = jsonObj.getJSONObject("_itemHeader") ;
			
			if(e.isNull("createdDate")) {
				plntfsDiscExport.setCreatedDate( null);
			}else {
		    if(!e.opt("createdDate").equals(null)){
		    	plntfsDiscExport.setCreatedDate(e.getString("createdDate"));
		    }}}
			plntfsDiscExportDao.insertPlntfsDiscData(plntfsDiscExport,databaseName);
		 
		}
	}
	}
}

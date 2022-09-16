package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DeposExportDao;
import com.filevine.dataexport.dao.PlntfsDiscExportDao;
import com.filevine.dataexport.domain.DeposExport;
import com.filevine.dataexport.domain.PlntfsDiscExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for depos tab from ui
 **/
public class DeposExportService {

	/**
	 * @return a response for depos from filevine  url by passing parameter cookie , project id
	 */
	public String getDeposResponse(String cookie, String projectID) {
		  String response=null;
//          String url="https://app.filevine.com/api/projects/"+projectID+"/custom/depos16433?page=1";
          String url="https://app.filevine.com/api/projects/"+projectID+"/custom/disposition16433?page=1";
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

	
	/**
	 * Taking input as a response.
	 * Converting JSON response to OBJECT
	 * Creating object of DeposExport class
	 * Setting values to setter methods of DeposExport class
	 * Calling method of DeposExportDao to insert all values using databaseName
	 */
	public void getDeposData(String response, String databaseName) throws JSONException, SQLException {
		DeposExportDao deposExportDao=new DeposExportDao();
		DeposExport deposExport=new DeposExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		//System.out.println("Project ID :"+jsonObj.getInt("projectID"));
		if(!jsonObj.opt("projectID").equals(null)){
			deposExport.setProjectId(jsonObj.getString("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
		JSONArray obj=data.getJSONArray("collection");
		for(int j=0; j<=obj.length()-1; j++) {
			
			JSONObject jsonObject=obj.getJSONObject(j);

			if(jsonObject.isNull("deponent48365")) {
				deposExport.setDeponent(null);
			}else {
			if(!jsonObject.opt("deponent48365").equals(null)) {
				deposExport.setDeponent(jsonObject.getString("deponent48365"));
			}}
			if(jsonObject.isNull("generalnotes48365")) {
				deposExport.setGeneralNote(null);
			}else {
			if(!jsonObject.opt("generalnotes48365").equals(null)) {
				deposExport.setGeneralNote(jsonObject.getString("generalnotes48365"));
			}}
			if(jsonObject.isNull("_id")) {
				deposExport.setId(null);
			}else {
			if(!jsonObject.opt("_id").equals(null)) {
				deposExport.setId(jsonObject.getString("_id"));
			}}
			if(!jsonObj.isNull("_itemHeader")) {
				JSONObject e = jsonObj.getJSONObject("_itemHeader") ;
				
				if(e.isNull("createdDate")) {
					deposExport.setCreatedDate( null);
				}else {
			    if(!e.opt("createdDate").equals(null)){
			    	deposExport.setCreatedDate(e.getString("createdDate"));
			    }}}
				deposExportDao.insertDeposData(deposExport,databaseName);

		}
		}
		
	}

}

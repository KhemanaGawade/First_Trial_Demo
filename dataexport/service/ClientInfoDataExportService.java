package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AccidentAdditionDataExportDao;
import com.filevine.dataexport.dao.ClientInfoDataDao;
import com.filevine.dataexport.domain.AccidentAdditionDataExport;
import com.filevine.dataexport.domain.ClientInfoDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ClientInfoDataExportService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/clientinfo16408?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
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
	
	public void getAdvanceClientCostData(String response, String databaseName) throws JSONException, SQLException {
		
		ClientInfoDataExport  clientinfodataexport =new ClientInfoDataExport ();
		ClientInfoDataDao clientinfodatadao=new ClientInfoDataDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject Data=new JSONObject(res);
		if(!Data.opt("projectID").equals(null)){
			clientinfodataexport.setProjectId(Data.getInt("projectID"));
		}

	JSONObject data1=Data.getJSONObject("data");
	if(!data1.isNull("customObject")) {
	JSONObject jsonObject=data1.getJSONObject("customObject");
	
	if(jsonObject.isNull("referralsource191336")) {
		clientinfodataexport.setReferralSource( null);
	}else {
		
    if(!jsonObject.opt("referralsource191336").equals(null)){
    	clientinfodataexport.setReferralSource( jsonObject.getString("referralsource191336"));
    }}
	
	if(jsonObject.isNull("primarycontact191336")){
		clientinfodataexport.setPrimaryContactId(null);
	}else {
		JSONObject communication6=jsonObject.getJSONObject("primarycontact191336");
		if(!communication6.opt("id").equals(null)){
			clientinfodataexport.setPrimaryContactId(communication6.getString("id"));
		}}
	
	if(jsonObject.isNull("primarycontact191336")){
		clientinfodataexport.setOrgID(null);
	}else {
		JSONObject communication7=jsonObject.getJSONObject("primarycontact191336");
		if(!communication7.opt("orgID").equals(null)){
			clientinfodataexport.setOrgID(communication7.getString("orgID"));
		}}
	
	if(jsonObject.isNull("primarycontact191336")){
		clientinfodataexport.setPrimaryContactFullName(null);
	}else {
		JSONObject communication10=jsonObject.getJSONObject("primarycontact191336");
		if(!communication10.opt("fullname").equals(null)){
			clientinfodataexport.setPrimaryContactFullName(communication10.getString("fullname"));
		}}
	
	if(jsonObject.isNull("primarycontact191336")){
		clientinfodataexport.setUniqueId(null);
	}else {
		JSONObject communication12=jsonObject.getJSONObject("primarycontact191336");
		if(!communication12.opt("uniqueID").equals(null)){
			clientinfodataexport.setUniqueId(communication12.getString("uniqueID"));
		}}
	
	
	if(jsonObject.isNull("clientnotes191336")) {
		clientinfodataexport.setClientNotes( null);
	}else {
		
    if(!jsonObject.opt("clientnotes191336").equals(null)){
    	clientinfodataexport.setClientNotes( jsonObject.getString("clientnotes191336"));
    }}
	clientinfodatadao.insertClientInfoData(databaseName, clientinfodataexport);
	
	}	
	}
	
}

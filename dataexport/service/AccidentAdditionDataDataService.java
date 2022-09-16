package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AccidentAdditionDataExportDao;

import com.filevine.dataexport.domain.AccidentAdditionDataExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class AccidentAdditionDataDataService {

	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/intakeaccidentinfo16407?page=1";
		
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
	
		AccidentAdditionDataExport accidentadditiondataexport=new AccidentAdditionDataExport();
		AccidentAdditionDataExportDao accidentadditiondataexportdao=new AccidentAdditionDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject Data=new JSONObject(res);
		if(!Data.opt("projectID").equals(null)){
			accidentadditiondataexport.setProjectId(Data.getInt("projectID"));
		}
	
		JSONObject data1=Data.getJSONObject("data");
		if(!data1.isNull("customObject")) {
		JSONObject jsonObject=data1.getJSONObject("customObject");
	
		if(jsonObject.isNull("passenger191323")){
			accidentadditiondataexport.setPassengerNo1Id(null);
		}else {
			JSONObject communication6=jsonObject.getJSONObject("passenger191323");
			if(!communication6.opt("id").equals(null)){
				accidentadditiondataexport.setPassengerNo1Id(communication6.getString("id"));
			}}
		if(jsonObject.isNull("passenger2191323")){
			accidentadditiondataexport.setPassengerNo2Id(null);
		}else {
			JSONObject communication6=jsonObject.getJSONObject("passenger2191323");
			if(!communication6.opt("id").equals(null)){
				accidentadditiondataexport.setPassengerNo2Id(communication6.getString("id"));
			}}
		if(jsonObject.isNull("passenger3191323")){
			accidentadditiondataexport.setPassengerNo3Id(null);
		}else {
			JSONObject communication6=jsonObject.getJSONObject("passenger3191323");
			if(!communication6.opt("id").equals(null)){
				accidentadditiondataexport.setPassengerNo3Id(communication6.getString("id"));
			}}
		if(jsonObject.isNull("passenger4191323")){
			accidentadditiondataexport.setPassengerNo4Id(null);
		}else {
			JSONObject communication6=jsonObject.getJSONObject("passenger4191323");
			if(!communication6.opt("id").equals(null)){
				accidentadditiondataexport.setPassengerNo4Id(communication6.getString("id"));
			}}
	
		accidentadditiondataexportdao.insertAccidentAdditionData(databaseName,accidentadditiondataexport);
	
	
		}
	}
	
}

package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.DiscoveryDataExportDao;
import com.filevine.dataexport.dao.MedicalBillsDataExportDao;
import com.filevine.dataexport.domain.DiscoveryDataExport;
import com.filevine.dataexport.domain.MedicalBillsDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class DiscoveryDataExportService {

	
public String getDiscoveryDataExportResponse(String cookie,String projectID) {
		
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/writtendisc1032?page=1";
	
	
	String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"datefiled14201\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	
	
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
public void getDiscoveryData(String response, String databaseName) throws JSONException, SQLException {
	
	DiscoveryDataExport  discoverydataexport =new DiscoveryDataExport ();
	DiscoveryDataExportDao discoverydataexportdao=new DiscoveryDataExportDao();
	String 	res=response;
	int i=res.indexOf('{');
	res=res.substring(i);
	
	
	JSONObject advanceClientData=new JSONObject(res);
	if(!advanceClientData.opt("projectID").equals(null)){
		 discoverydataexport.setProjectId(advanceClientData.getInt("projectID"));
	}
	
	JSONObject data=advanceClientData.getJSONObject("data");
	if(!data.opt("collection").equals(null)) {
		JSONArray communication=data.getJSONArray("collection");
		for(int j=0; j<=communication.length()-1; j++) {
			JSONObject jsonObject=communication.getJSONObject(j);
	
			if(jsonObject.isNull("inout14201")) {
				discoverydataexport.setDefendantPlaintiff( null);
			}else {
				
		    if(!jsonObject.opt("inout14201").equals(null)){
		    	discoverydataexport.setDefendantPlaintiff( jsonObject.getString("inout14201"));
		    }}
	
			if(jsonObject.isNull("type14201")) {
				discoverydataexport.setType( null);
			}else {
				
		    if(!jsonObject.opt("type14201").equals(null)){
		    	discoverydataexport.setType( jsonObject.getString("type14201"));
		    }}
	
			if(jsonObject.isNull("partyis14201")) {
				discoverydataexport.setPartyIs( null);
			}else {
				
		    if(!jsonObject.opt("partyis14201").equals(null)){
		    	discoverydataexport.setPartyIs( jsonObject.getString("partyis14201"));
		    }}
	
			if(jsonObject.isNull("f2_party14201")){
				discoverydataexport.setParty(null);
			}else {
			JSONObject communication1=jsonObject.getJSONObject("f2_party14201");
			if(!communication1.opt("fullname").equals(null)){
				discoverydataexport.setParty(communication1.getString("fullname"));
			}}
			if(jsonObject.isNull("datefiled14201")) {
				discoverydataexport.setDateFiled( null);
			}else {
				
		    if(!jsonObject.opt("datefiled14201").equals(null)){
		    	discoverydataexport.setDateFiled( jsonObject.getString("datefiled14201"));
		    }}
	
			if(jsonObject.isNull("party14201")){
				discoverydataexport.setServedTo(null);
			}else {
			JSONObject communication2=jsonObject.getJSONObject("party14201");
			if(!communication2.opt("fullname").equals(null)){
				discoverydataexport.setServedTo(communication2.getString("fullname"));
			}}

			if(jsonObject.isNull("date14201")) {
				discoverydataexport.setDateServed( null);
			}else {
				
		    if(!jsonObject.opt("date14201").equals(null)){
		    	discoverydataexport.setDateServed( jsonObject.getString("date14201"));
		    }}
			if(jsonObject.isNull("documenttitle14201")) {
				discoverydataexport.setDocumentTitle( null);
			}else {
				
		    if(!jsonObject.opt("documenttitle14201").equals(null)){
		    	discoverydataexport.setDocumentTitle( jsonObject.getString("documenttitle14201"));
		    }}
			if(jsonObject.isNull("notes14201")) {
				discoverydataexport.setNotes( null);
			}else {
				
		    if(!jsonObject.opt("notes14201").equals(null)){
		    	discoverydataexport.setNotes( jsonObject.getString("notes14201"));
		    }}
			
			discoverydataexportdao.insertDiscoveryData(databaseName,discoverydataexport);	
			
		}		

	}		
}
}
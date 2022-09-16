package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.MotionDataExportDao;
import com.filevine.dataexport.dao.PleadingsDataExportDao;
import com.filevine.dataexport.domain.MotionDataExport;
import com.filevine.dataexport.domain.PleadingsDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class MotionDataExportService {

	public String getMotionDataExportsResponse(String cookie,String  projectID) {
		
		String response=null;
	String url ="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/motions1032?page=1";
	
	 String payload ="{\"pageNumber\":1,\"pageSize\":20,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"dateserved18178\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	
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
	
public void getMotionData(String response, String databaseName) throws JSONException, SQLException {
		
	MotionDataExport motiondataexport=new MotionDataExport();
	MotionDataExportDao motiondataexportdao=new MotionDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject advanceClientData=new JSONObject(res);
		if(!advanceClientData.opt("projectID").equals(null)){
			motiondataexport.setProjectId(advanceClientData.getInt("projectID"));
		}
	
      JSONObject data=advanceClientData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
	
				if(jsonObject.isNull("partyservingfilingpleading18178")) {
					motiondataexport.setPartyServingFilingpLeading( null);
				}else {
					
			    if(!jsonObject.opt("partyservingfilingpleading18178").equals(null)){
			    	motiondataexport.setPartyServingFilingpLeading( jsonObject.getString("partyservingfilingpleading18178"));
			    }}
				
				if(jsonObject.isNull("partyserving18178")){
					motiondataexport.setPartyServing(null);
				}else {
				JSONObject communication2=jsonObject.getJSONObject("partyserving18178");
				if(!communication2.opt("fullname").equals(null)){
					motiondataexport.setPartyServing(communication2.getString("fullname"));
				}}
				
				if(jsonObject.isNull("motionname18178")) {
					motiondataexport.setMotionName( null);
				}else {
					
			    if(!jsonObject.opt("motionname18178").equals(null)){
			    	motiondataexport.setMotionName( jsonObject.getString("motionname18178"));
			    }}
	
				
				if(jsonObject.isNull("partyserved18178")){
					motiondataexport.setPartyServed(null);
				}else {
				JSONObject communication12=jsonObject.getJSONObject("partyserved18178");
				if(!communication12.opt("fullname").equals(null)){
					motiondataexport.setPartyServed(communication12.getString("fullname"));
				}}
				
			
//				if(jsonObject.isNull("partyserved18178")) {
//					motiondataexport.setPartyServed( null);
//				}else {
//					
//			    if(!jsonObject.opt("partyserved18178").equals(null)){
//			    	motiondataexport.setPartyServed( jsonObject.getString("partyserved18178"));
//			    }}
				
				
				if(jsonObject.isNull("dateserved18178")) {
					motiondataexport.setDateServed( null);
				}else {
					
			    if(!jsonObject.opt("dateserved18178").equals(null)){
			    	motiondataexport.setDateServed( jsonObject.getString("dateserved18178"));
			    }}
	
				if(jsonObject.isNull("orderreceived18178")) {
					motiondataexport.setOrderReceived( null);
				}else {
					
			    if(!jsonObject.opt("orderreceived18178").equals(null)){
			    	motiondataexport.setOrderReceived( jsonObject.getString("orderreceived18178"));
			    }}
	
				
				if(jsonObject.isNull("motiondoc18178")){
					motiondataexport.setMotiondocId(null);
				}else {
					JSONArray communication3=jsonObject.getJSONArray("motiondoc18178");
					for(int k=0; k<=communication3.length()-1; k++) {
					JSONObject jsonobject=communication3.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					motiondataexport.setMotiondocId(jsonobject.getString("id"));
				}}}
				
				if(jsonObject.isNull("motiondoc18178")){
					motiondataexport.setMotiondocFileName(null);
				}else {
					JSONArray communication04=jsonObject.getJSONArray("motiondoc18178");
					for(int k=0; k<=communication04.length()-1; k++) {
					JSONObject jsonobject=communication04.getJSONObject(k);
				if(!jsonobject.opt("filename").equals(null)){
					motiondataexport.setMotiondocFileName(jsonobject.getString("filename"));
				}}}
				
				
				
				
				
				
				
				
				
				motiondataexportdao.insertMotionData(databaseName,motiondataexport);		
				
			}
		}
}
}

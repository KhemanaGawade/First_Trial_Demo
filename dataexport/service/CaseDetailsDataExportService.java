package com.filevine.dataexport.service;

import java.sql.SQLException;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.filevine.dataexport.dao.CaseDetailsDataExportDao;
import com.filevine.dataexport.domain.CaseDetailsDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CaseDetailsDataExportService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/intakeinfo1032?page=1";
		
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
		
		CaseDetailsDataExport casedetailsdataexport=new CaseDetailsDataExport();
		CaseDetailsDataExportDao casedetailsdataexportdao=new CaseDetailsDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject data=new JSONObject(res);
		if(!data.opt("projectID").equals(null)){
			casedetailsdataexport.setProjectId(data.getInt("projectID"));
		}
	
		if(!data.opt("projectVitals").equals(null)) {
			JSONArray communication=data.getJSONArray("projectVitals");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				if(jsonObject.isNull("fieldName")) {
					casedetailsdataexport.setFieldName( null);
				}else {
					
			    if(!jsonObject.opt("fieldName").equals(null)){
			    	casedetailsdataexport.setFieldName( jsonObject.getString("fieldName"));
			    }}
	
				if(jsonObject.isNull("friendlyName")) {
					casedetailsdataexport.setFriendlyName( null);
				}else {
					
			    if(!jsonObject.opt("friendlyName").equals(null)){
			    	casedetailsdataexport.setFriendlyName( jsonObject.getString("friendlyName"));
			    }}
	
				if(jsonObject.isNull("fieldType")) {
					casedetailsdataexport.setFieldType( null);
				}else {
					
			    if(!jsonObject.opt("fieldType").equals(null)){
			    	casedetailsdataexport.setFieldType( jsonObject.getString("fieldType"));
			    }}
	
				if(jsonObject.isNull("value")) {
					casedetailsdataexport.setFieldValue( null);
				}else {
					
			    if(!jsonObject.opt("value").equals(null)){
			    	casedetailsdataexport.setFieldValue( jsonObject.getString("value"));
			    }}
	
				if(jsonObject.isNull("linkRefValue")) {
					casedetailsdataexport.setLinkRefValue( null);
				}else {
					
			    if(!jsonObject.opt("linkRefValue").equals(null)){
			    	casedetailsdataexport.setLinkRefValue( jsonObject.getString("linkRefValue"));
			    }}
	
				if(jsonObject.isNull("position")) {
					casedetailsdataexport.setPosition( null);
				}else {
					
			    if(!jsonObject.opt("position").equals(null)){
			    	casedetailsdataexport.setPosition( jsonObject.getString("position"));
			    }}
				if(jsonObject.isNull("sectionLink")) {
					casedetailsdataexport.setSectionLink( null);
				}else {
					
			    if(!jsonObject.opt("sectionLink").equals(null)){
			    	casedetailsdataexport.setSectionLink( jsonObject.getString("sectionLink"));
			    }}
	
				casedetailsdataexportdao.insertCaseDetailsData(databaseName,casedetailsdataexport);
				
				
				
}
		}
	}
}

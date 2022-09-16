package com.filevine.dataexport.service;
	import java.sql.SQLException;

	import javax.ws.rs.core.MediaType;

	import org.json.JSONArray;
	import org.json.JSONException;
	import org.json.JSONObject;


	import com.filevine.dataexport.dao.TrustAccountingExportDao;

	import com.filevine.dataexport.domain.TrustAccountingExport;
	import com.sun.jersey.api.client.Client;
	import com.sun.jersey.api.client.WebResource;

	public class TrustAccountingExportService { 

		
		public String getTrustAccountingExportResponse(String cookie,String projectID) {
		
			String response=null;
			
			String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/trustaccounting1032?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"type15233\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
		
		public void getTrustAccountingData(String response, String databaseName) throws JSONException, SQLException {
		
			TrustAccountingExport trustaccountingexport=new TrustAccountingExport();
			TrustAccountingExportDao trustaccountingexportdao=new TrustAccountingExportDao();
			String 	res=response;
			int i=res.indexOf('{');
			res=res.substring(i);
			
			JSONObject advanceClientData=new JSONObject(res);
			if(!advanceClientData.opt("projectID").equals(null)){
				trustaccountingexport.setProjectId(advanceClientData.getInt("projectID"));
			}
			JSONObject data=advanceClientData.getJSONObject("data");
			
			if(!data.opt("collection").equals(null)) {
				JSONArray communication=data.getJSONArray("collection");
				for(int j=0; j<=communication.length()-1; j++) {
					JSONObject jsonObject=communication.getJSONObject(j);
			
					if(jsonObject.isNull("type15233")) {
						trustaccountingexport.setType( null);
					}else {
						
				    if(!jsonObject.opt("type15233").equals(null)){
				    	trustaccountingexport.setType( jsonObject.getString("type15233"));
				    }}
					if(jsonObject.isNull("checknumber15233")) {
						trustaccountingexport.setCheckNumber( null);
					}else {
						
				    if(!jsonObject.opt("checknumber15233").equals(null)){
				    	trustaccountingexport.setCheckNumber( jsonObject.getString("checknumber15233"));
				    }}
			
					if(jsonObject.isNull("amountofcheck15233")) {
						trustaccountingexport.setAmountOfCheck( null);
					}else {
						
				    if(!jsonObject.opt("amountofcheck15233").equals(null)){
				    	trustaccountingexport.setAmountOfCheck( jsonObject.getString("amountofcheck15233"));
				    }}
					
					if(jsonObject.isNull("date15233")) {
						trustaccountingexport.setDate( null);
					}else {
						
				    if(!jsonObject.opt("date15233").equals(null)){
				    	trustaccountingexport.setDate( jsonObject.getString("date15233"));
				    }}	
					if(jsonObject.isNull("notes15233")) {
						trustaccountingexport.setNotes( null);
					}else {
						
				    if(!jsonObject.opt("notes15233").equals(null)){
				    	trustaccountingexport.setNotes( jsonObject.getString("notes15233"));
				    }}
					
					if(jsonObject.isNull("documents15233")){
						trustaccountingexport.setDocumentsId(null);
					}else {
						JSONArray communication03=jsonObject.getJSONArray("documents15233");
						for(int k=0; k<=communication03.length()-1; k++) {
						JSONObject jsonobject=communication03.getJSONObject(k);
					if(!jsonobject.opt("id").equals(null)){
						trustaccountingexport.setDocumentsId(jsonobject.getString("id"));
					}}}
					
					if(jsonObject.isNull("documents15233")){
						trustaccountingexport.setDocumentsFileName(null);
					}else {
						JSONArray communication4=jsonObject.getJSONArray("documents15233");
						for(int k=0; k<=communication4.length()-1; k++) {
						JSONObject jsonobject=communication4.getJSONObject(k);
					if(!jsonobject.opt("filename").equals(null)){
						trustaccountingexport.setDocumentsFileName(jsonobject.getString("filename"));
					}}}
					
					
					
					
					
					trustaccountingexportdao.insertTrustAccountingExportData(databaseName,trustaccountingexport);
		}	
			}
		}
	}


package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;


import com.filevine.dataexport.dao.LienExportDAO;

import com.filevine.dataexport.domain.LienExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LienExportService {
	
	public String getLienResponse(String cookie,String id) {
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+id+"/custom/liens16407?page=1";
	//	String url="https://app.filevine.com/api/projects/"+id+"/custom/liens16407?page=1" ; 
	     String payLoad	="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"lienholder191309\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"lienholder89445\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}" ;
				
				
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
//				System.out.println("response :: "+response);

		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;
	}
	
	
	
	public void getLienData(String response, String databaseName) throws Exception {
		LienExportDAO lienExportDAO=new LienExportDAO();
		LienExport lienExport=new LienExport();	
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject lienData=new JSONObject(res);
		if(!lienData.isNull("projectID")) {
		if(!lienData.opt("projectID").equals(null)){
			lienExport.setProjectId(lienData.getInt("projectID"));
		}
		JSONObject liens = lienData.getJSONObject("data") ;
		if(!liens.isNull("collection")) {
		JSONArray jsonA = liens.getJSONArray("collection");

		for(int k = 0;k< jsonA.length();k++)
		{
			JSONObject jsonObj = jsonA.getJSONObject(k) ;
			if(jsonObj.isNull("lienholder191309")) {
				lienExport.setLienHolder(0);
				
		    }
			else {
			      if(!jsonObj.opt("lienholder191309").equals(null)){
			    	  JSONObject LH = jsonObj.getJSONObject("lienholder191309");
			    	    if(LH.isNull("id")) {
			    	    	lienExport.setLienHolder(0);
						}else {

					          if(!LH.opt("id").equals(null)){
					    	  lienExport.setLienHolder(LH.getInt("id"));
					    }}
				 }}
				if(jsonObj.isNull("lienamount191309")) {
					lienExport.setAmount( null);
				}else {
					
			    if(!jsonObj.opt("lienamount191309").equals(null)){
			    	lienExport.setAmount( jsonObj.getString("lienamount191309"));
			    }}
				if(!jsonObj.isNull("recoveryagency191309")) {
				  	 JSONObject RA = jsonObj.getJSONObject("recoveryagency191309");
				  	 System.out.println(RA.getInt("id"));
//				  	 if(!RA.opt("id").equals(null)){
					  lienExport.setRecoveryAgency(RA.getString("id"));
					  System.out.println("id :"+ lienExport.getRecoveryAgency());
//				  } 
				} 
				 if(jsonObj.isNull("recoveryagent191309")) {
							lienExport.setRecoveryAgent(null);
				}else {

					 if(!jsonObj.opt("recoveryagent191309").equals(null)){
					    JSONObject RA2 = jsonObj.getJSONObject("recoveryagent191309");
							  if(RA2.isNull("id")) {
							    	lienExport.setRecoveryAgent(null);
								}else {
									   if(!RA2.opt("id").equals(null)){
									   lienExport.setRecoveryAgent(RA2.getString("id"));
							   }}
					 }}	
				if(jsonObj.isNull("datesent191309")) {
					lienExport.setDateSent( null);
				}else {
			    if(!jsonObj.opt("datesent191309").equals(null)){
			    	lienExport.setDateSent(jsonObj.getString("datesent191309"));
			    }}
				
				if(jsonObj.isNull("datereceived191309")) {
					lienExport.setDateReceived( null);
				}else {
			    if(!jsonObj.opt("datereceived191309").equals(null)){
			    	lienExport.setDateReceived(jsonObj.getString("datereceived191309"));
			    }}
				
				if(jsonObj.isNull("dateofreceipt191309")) {
					lienExport.setDateReceived( null);
				}else {
			    if(!jsonObj.opt("dateofreceipt191309").equals(null)){
			    	lienExport.setDateReceived(jsonObj.getString("dateofreceipt191309"));
			    }}
				
				if(jsonObj.isNull("notes191309")) {
					lienExport.setNotes( null);
				}else {
			    if(!jsonObj.opt("notes191309").equals(null)){
			    	lienExport.setNotes(jsonObj.getString("notes191309"));
			    }}
				if(jsonObj.isNull("noticereceived191309")) {
					lienExport.setNoticereceived( null);
				}else {
			    if(!jsonObj.opt("noticereceived191309").equals(null)){
			    	lienExport.setNoticereceived(jsonObj.getString("noticereceived191309"));
			    }}
				if(jsonObj.isNull("finallienrecieved191309")) {
					lienExport.setFinallienrecieved(null);
				}else {
			    if(!jsonObj.opt("finallienrecieved191309").equals(null)){
			    	lienExport.setFinallienrecieved(jsonObj.getString("finallienrecieved191309"));
			    }}
				if(jsonObj.isNull("lorsent191309")) {
					lienExport.setLorsent(null);
				}else {
			    if(!jsonObj.opt("lorsent191309").equals(null)){
			    	lienExport.setLorsent(jsonObj.getString("lorsent191309"));
			    }}
				
				lienExportDAO.insertLienData(databaseName, lienExport);
		}	}
		}
	}		
}			
				
				
			 
				

			
			
			
			
			
			
			
			
				
		
	
		

	


		


				      
				      

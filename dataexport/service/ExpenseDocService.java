package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.ExpenseDocDao;

import com.filevine.dataexport.domain.ExpenseDocExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ExpenseDocService {

	
	public String getExpenseDocResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/expenses16407?page=1";
		
		String payload="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"expensetitle191310\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
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
		
	public void getExpenseDocData(String response, String databaseName) throws JSONException, SQLException {
	
	
		ExpenseDocExport expensedocexport=new ExpenseDocExport();
		 ExpenseDocDao  expensedocdao=new  ExpenseDocDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
	
		JSONObject expensedocData=new JSONObject(res);
		if(!expensedocData.opt("projectID").equals(null)){
			expensedocexport.setProjectId(expensedocData.getInt("projectID"));
			
		}
	
		JSONObject data=expensedocData.getJSONObject("data");
		
		if(!data.opt("collection").equals(null)) {
			JSONArray communication=data.getJSONArray("collection");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
				
				
				if(jsonObject.isNull("expensetitle191310")) {
					expensedocexport.setExpenseTitle( null);
				}else {
					
			    if(!jsonObject.opt("expensetitle191310").equals(null)){
			    	expensedocexport.setExpenseTitle( jsonObject.getString("expensetitle191310"));
			    }}
		
				
				if(jsonObject.isNull("reciept191310")){
					expensedocexport.setRecieptId(null);
				}else {
				JSONObject communication1=jsonObject.getJSONObject("reciept191310");
				if(!communication1.opt("id").equals(null)){
					expensedocexport.setRecieptId(communication1.getString("id"));
				}}
				
				if(jsonObject.isNull("reciept191310")){
					expensedocexport.setOrgID(null);
				}else {
				JSONObject communication2=jsonObject.getJSONObject("reciept191310");
				if(!communication2.opt("orgID").equals(null)){
					expensedocexport.setOrgID(communication2.getString("orgID"));
				}}
		
				if(jsonObject.isNull("reciept191310")){
					expensedocexport.setRecieptFileName(null);
				}else {
				JSONObject communication3=jsonObject.getJSONObject("reciept191310");
				if(!communication3.opt("filename").equals(null)){
					expensedocexport.setRecieptFileName(communication3.getString("filename"));
				}}
	
				 expensedocdao.insertExpenseDocData(databaseName,expensedocexport);
	
	
}
		}
	}
}

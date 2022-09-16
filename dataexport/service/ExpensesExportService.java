package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import com.filevine.dataexport.dao.ExpensesExportDAO;
import com.filevine.dataexport.domain.ExpensesExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ExpensesExportService {
	public String getExpenseResponse(String cookie,String id) {
		String response=null;
		String url="https://app.filevine.com/api/projects/"+id+"/custom/expenses16407?page=1";
		String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"title145687\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
				//System.out.println("response :: "+response);

		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;
	}
	
	
	
	public void getExpenseData(String response, String databaseName) throws Exception {
		ExpensesExportDAO expenseExportDAO=new ExpensesExportDAO();
		ExpensesExport expenseExport=new ExpensesExport();	
		System.out.println(response);
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject expenseData=new JSONObject(res);
		if(!expenseData.opt("projectID").equals(null)){
			expenseExport.setProjectId(expenseData.getInt("projectID"));
		}
		JSONObject expense=expenseData.getJSONObject("data") ;
		if(!expense.isNull("collection")) {
		JSONArray ex = expense.getJSONArray("collection");
		for(int k=0;k < ex.length(); k++) {
			
			JSONObject jsonObj=ex.getJSONObject(k);	
				if(jsonObj.isNull("expensetitle191310")) {
					expenseExport.setTitle( null);
				}else {
					
			    if(!jsonObj.opt("expensetitle191310").equals(null)){
			    	expenseExport.setTitle( jsonObj.getString("expensetitle191310"));
			    }}
			
				if(jsonObj.isNull("expenseamount191310")) {
					expenseExport.setAmount( null);
				}else {

			      if(!jsonObj.opt("expenseamount191310").equals(null)){
			    	  expenseExport.setAmount( jsonObj.getString("expenseamount191310"));
			    }}
				
				
				if(jsonObj.isNull("paymentmethod191310")) {
					expenseExport.setPaymentMethod( null);
				}else {
			    if(!jsonObj.opt("paymentmethod191310").equals(null)){
			    	expenseExport.setPaymentMethod(jsonObj.getString("paymentmethod191310"));
			    }}
				if(jsonObj.isNull("dateofexpense191310")) {
					expenseExport.setDateOfExpense(null);
				}else {
			    if(!jsonObj.opt("dateofexpense191310").equals(null)){
			    	expenseExport.setDateOfExpense(jsonObj.getString("dateofexpense191310"));
			    }}
				
				
				if(jsonObj.isNull("expensenotes191310")) {
					expenseExport.setNotes( null);
				}else {
			    if(!jsonObj.opt("expensenotes191310").equals(null)){
			    	expenseExport.setNotes(jsonObj.getString("expensenotes191310"));
			    }}
				
				
				
				JSONObject e = jsonObj.getJSONObject("_itemHeader") ;
				
				if(e.isNull("createdDate")) {
					expenseExport.setCreatedDate( null);
				}else {
			    if(!e.opt("createdDate").equals(null)){
			    	expenseExport.setCreatedDate(e.getString("createdDate"));
			    }}
			expenseExportDAO.insertExpenseData(databaseName, expenseExport);
		}
		}

	}


}

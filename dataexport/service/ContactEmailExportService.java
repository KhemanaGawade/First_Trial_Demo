package com.filevine.dataexport.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.ContactEmailExportDAO;

import com.filevine.dataexport.domain.ContactEmailExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for contact's email tab from ui
 **/
public class ContactEmailExportService {
	
	/**
	 * @return a response for contact's email from filevine  url by passing parameter cookie and project id
	 */
	public String   getContactEmailResponse(String ProjectID,String cookie)
	{
		String response=null;
		
//		String url="https://app.filevine.com/api/projects/"+ProjectID+"/contacts";
		//for client contacts
		String url="https://app.filevine.com/api/projects/"+ProjectID+"/uniquecontacts";
		
		try {
			WebResource webResource=Client.create().resource(url);
			response=webResource.header("Cookie", cookie).get(String.class);
			
			System.out.println(response);
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
	 * Creating object of ContactEmailExport class
	 * Setting values to setter methods of ContactEmailExport class
	 * Calling method of ContactEmailExportDAO to insert all values using databaseName
	 */
	public void getContactEmailData(String database ,String res) throws Exception
	{
		ContactEmailExport contactEmailexport = new ContactEmailExport();
		ContactEmailExportDAO contactEmailexportdao = new ContactEmailExportDAO();
		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		if(!jobj.isNull("data")) {
		JSONArray arr = jobj.getJSONArray("data");
		for(int k = 0; k<arr.length();k++)
		{
             JSONObject jsonObj= arr.getJSONObject(k);	
             
             if(jsonObj.isNull("type14183")) {
            	 contactEmailexport.setContactId( null);
				}else {
					
			    if(!jsonObj.opt("type14183").equals(null)){
			    	contactEmailexport.setContactId( jsonObj.getString("type14183"));
			    }}
             if(jsonObj.isNull("personID")) {
            	 contactEmailexport.setPersonId( null);
				}else {
					
			    if(!jsonObj.opt("personID").equals(null)){
			    	contactEmailexport.setPersonId( jsonObj.getString("personID"));
			    }}
			
		    JSONObject obj = jsonObj.getJSONObject("person");
		
		   JSONArray array = obj.getJSONArray("emails");
		   for(int p = 0; p < array.length() ;p++)
		   {
		
             JSONObject jsonObj2= array.getJSONObject(p);	
             
             
             if(jsonObj2.isNull("id")) {
            	 contactEmailexport.setEmailId( null);
				}else {
					
			    if(!jsonObj2.opt("id").equals(null)){
			    	contactEmailexport.setEmailId( jsonObj2.getString("id"));
			    }}
			
//			if(!jsonObj2.opt("id").equals(null)){
//				contactEmailexport.setId(jsonObj2.getInt("id"));
//			}
             
             if(jsonObj2.isNull("address")) {
            	 contactEmailexport.setAddress( null);
				}else {
					
			    if(!jsonObj2.opt("address").equals(null)){
			    	contactEmailexport.setAddress( jsonObj2.getString("address"));
			    }}
//			if(!jsonObj2.opt("address").equals(null)){
//				contactEmailexport.setAddress(jsonObj2.getString("address"));
//			}
//			if(!jsonObj2.opt("label").equals(null)){
//				contactEmailexport.setLabel(jsonObj2.getString("label"));
//			}
             
             if(jsonObj2.isNull("label")) {
            	 contactEmailexport.setLabel( null);
				}else {
					
			    if(!jsonObj2.opt("label").equals(null)){
			    	contactEmailexport.setLabel( jsonObj2.getString("label"));
			    }}
             
             
			contactEmailexportdao.insertContactEmailData(database, contactEmailexport);
		 }
		}
	}
	}

}

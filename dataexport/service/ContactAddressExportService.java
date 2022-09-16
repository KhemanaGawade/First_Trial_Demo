package com.filevine.dataexport.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.ContactAddressExportDAO;

import com.filevine.dataexport.domain.ContactAddressExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for contact's address tab from ui
 **/
public class ContactAddressExportService {
	
	/**
	 * @return a response for contact's address from filevine  url by passing parameter cookie and project id
	 */
	public String   getContactAddressResponse(String ProjectID,String cookie)
	{
			String response=null;
		
//		String url="https://app.filevine.com/api/projects/"+ProjectID+"/contacts";
		//for client contacts
	//	String url="https://app.filevine.com/api/projects/"+ProjectID+"/uniquecontacts";
		String url="https://app.filevine.com/api/projects/"+ProjectID+"/uniquecontacts";
		try {
			WebResource webResource=Client.create().resource(url);
			response=webResource.header("Cookie", cookie).get(String.class);
			
			System.out.println(response);
			}catch(Exception e) {
			System.out.println("Fail to get repsonse from UI");
			e.printStackTrace();
		}
		return response;
     }
	
	/**
	 * Taking input as a response.
	 * Converting JSON response to OBJECT
	 * Creating object of ContactAddressExport class
	 * Setting values to setter methods of ContactAddressExport class
	 * Calling method of ContactAddressExportDAO to insert all values using databaseName
	 */
	public void getContactAddressData(String database ,String res) throws Exception
	{
		ContactAddressExport contactAddressexport = new ContactAddressExport();
		ContactAddressExportDAO contactAddressexportdao = new ContactAddressExportDAO();
		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		if(!jobj.isNull("data")) {
		JSONArray arr = jobj.getJSONArray("data");
		for(int k = 0; k<arr.length();k++)
		{
             JSONObject jsonObj= arr.getJSONObject(k);	
			
			if(!jsonObj.opt("id").equals(null)){
				contactAddressexport.setContactId(jsonObj.getString("id"));
			}
			if(!jsonObj.opt("personID").equals(null)){
				contactAddressexport.setPersonId(jsonObj.getString("personID"));
			}
			
			 JSONObject obj = jsonObj.getJSONObject("person");
		
		   JSONArray array = obj.getJSONArray("addresses");
		   for(int p = 0; p < array.length() ;p++)
		   {
		
             JSONObject jsonObj2= array.getJSONObject(p);	
			
			if(!jsonObj2.opt("id").equals(null)){
				contactAddressexport.setId(jsonObj2.getInt("id"));
			}
			if(!jsonObj2.opt("line1").equals(null)){
				contactAddressexport.setLine1(jsonObj2.getString("line1"));
			}
			if(!jsonObj2.opt("line2").equals(null)){
				contactAddressexport.setLine2(jsonObj2.getString("line2"));
			}
			if(!jsonObj2.opt("city").equals(null)){
				contactAddressexport.setCity(jsonObj2.getString("city"));
			}
			if(!jsonObj2.opt("state").equals(null)){
				contactAddressexport.setState(jsonObj2.getString("state"));
			}
			if(!jsonObj2.opt("zip").equals(null)){
				contactAddressexport.setZip(jsonObj2.getString("zip"));
			}

			if(!jsonObj2.opt("label").equals(null)){
				contactAddressexport.setLabel(jsonObj2.getString("label"));
			}
			if(!jsonObj2.opt("fullAddress").equals(null)){
				contactAddressexport.setFullAddress(jsonObj2.getString("fullAddress"));
			}
			contactAddressexportdao.insertContactAddressData(database, contactAddressexport);
		 }
		}
	}
	
	}

}

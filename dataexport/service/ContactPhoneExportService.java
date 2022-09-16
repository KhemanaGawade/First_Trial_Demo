package com.filevine.dataexport.service;

import org.json.JSONArray;
import org.json.JSONObject;
import com.filevine.dataexport.dao.ContactPhoneExportDAO;

import com.filevine.dataexport.domain.ContactPhoneExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
/**
 * This is Service class having methods to get response for contact's phone tab from ui
 **/
public class ContactPhoneExportService {
	
	/**
	 * @return a response for contact's phones from filevine  url by passing parameter cookie and project id
	 */
	public String   getContactPhoneResponse(String id,String cookie)
	{
		String response=null;
	
//		String url="https://app.filevine.com/api/projects/"+id+"/contacts";
		//for client contacts
				String url="https://app.filevine.com/api/projects/"+id+"/uniquecontacts";
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
	 * Creating object of ContactPhoneExport class
	 * Setting values to setter methods of ContactPhoneExport class
	 * Calling method of ContactPhoneExportDAO to insert all values using databaseName
	 */
	public void getContactPhoneData(String database ,String res) throws Exception
	{
		ContactPhoneExport contactPhoneexport = new ContactPhoneExport();
		ContactPhoneExportDAO contactPhoneexportdao = new ContactPhoneExportDAO();
		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		if(!jobj.isNull("data")) {
		JSONArray arr = jobj.getJSONArray("data");
		for(int k = 0; k<arr.length();k++)
		{
             JSONObject jsonObj= arr.getJSONObject(k);	
			
			if(!jsonObj.opt("id").equals(null)){
				contactPhoneexport.setContactId(jsonObj.getString("id"));
			}
			if(!jsonObj.opt("personID").equals(null)){
				contactPhoneexport.setPersonId(jsonObj.getString("personID"));
			}
			 JSONObject obj = jsonObj.getJSONObject("person");
		
		   JSONArray array = obj.getJSONArray("phones");
		   for(int p = 0; p < array.length() ;p++)
		   {
		
             JSONObject jsonObj2= array.getJSONObject(p);	
			
			if(!jsonObj2.opt("id").equals(null)){
				contactPhoneexport.setId(jsonObj2.getInt("id"));
			}
			if(!jsonObj2.opt("number").equals(null)){
				contactPhoneexport.setNumber(jsonObj2.getString("number"));
			}
			if(!jsonObj2.opt("rawNumber").equals(null)){
				contactPhoneexport.setRawNumber(jsonObj2.getString("rawNumber"));
			}
			if(!jsonObj2.opt("label").equals(null)){
				contactPhoneexport.setLabel(jsonObj2.getString("label"));
			}
			
			
			
			contactPhoneexportdao.insertContactEmailData(database, contactPhoneexport);
		 }
		}
	}
	}

}

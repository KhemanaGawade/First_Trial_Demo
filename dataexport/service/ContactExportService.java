package com.filevine.dataexport.service;

import org.json.JSONArray;

import org.json.JSONObject;


import com.filevine.dataexport.dao.ContactExportDAO;

import com.filevine.dataexport.domain.ContactExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for contact detail tab from ui
 **/
public class ContactExportService {
	
	/**
	 * @return a response for contact's details from filevine  url by passing parameter cookie, project id
	 */
	public String   getContactResponse(String ProjectID,String cookie)
	{
		String response=null;
		// for contacts
//		String url="https://app.filevine.com/api/projects/"+ProjectID+"/contacts";
		String url="https://app.filevine.com/api/projects/"+ProjectID+"/uniquecontacts";
		//for client contacts
	//	String url="https://app.filevine.com/api/projects/"+ProjectID+"/uniquecontacts";
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
	 * Creating object of ContactExport class
	 * Setting values to setter methods of ContactExport class
	 * Calling method of contactexportdao to insert all values using databaseName
	 */
	public void getContactData(String database ,String res,String projectId) throws Exception
	{
		ContactExport contactexport =null;
		ContactExportDAO contactexportdao = new ContactExportDAO();

		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		System.out.println("data is inserted");
		if(!jobj.isNull("data")) {
		JSONArray arr = jobj.getJSONArray("data");
		for(int k = 0; k<=arr.length()-1;k++)
		{
			contactexport=new ContactExport();
			contactexport.setProjectId(projectId);
             JSONObject jsonObj= arr.getJSONObject(k);	
			
			if(!jsonObj.opt("id").equals(null)){
				contactexport.setID(jsonObj.getString("id"));
			}
			if(!jsonObj.opt("role").equals(null)){
				contactexport.setRole(jsonObj.getString("role"));
			}
			
			if(!jsonObj.opt("personID").equals(null)){
				contactexport.setPersonID(jsonObj.getInt("personID"));
			}
		
		   JSONObject jsonObj2 = jsonObj.getJSONObject("person");
		   if(!jsonObj2.opt("ssn").equals(null)){
				contactexport.setSsn(jsonObj2.getString("ssn"));
			}
		   JSONArray personType = jsonObj2.getJSONArray("personTypes");
			for(int j = 0; j<personType.length();j++)
			{
				 JSONObject jsonObjType = personType.getJSONObject(j);
				 if(!jsonObjType.opt("name").equals(null)){
						contactexport.setPersonType(jsonObjType.getString("name"));
				 }
			}
			if(!jsonObj2.opt("birthDate").equals(null)){
				contactexport.setBirthDate(jsonObj2.getString("birthDate"));
			}
			if(!jsonObj2.opt("notes").equals(null)){
				contactexport.setNotes(jsonObj2.getString("notes"));
			}
			if(!jsonObj2.opt("fromCompany").equals(null)){
				contactexport.setFromCompany(jsonObj2.getString("fromCompany"));
			}
			if(!jsonObj2.opt("specialty").equals(null)){
				contactexport.setSpecialty(jsonObj2.getString("specialty"));
			}
			if(!jsonObj2.opt("gender").equals(null)){
				contactexport.setGender(jsonObj2.getString("gender"));
			}
			if(!jsonObj2.opt("language").equals(null)){
				contactexport.setLanguage(jsonObj2.getString("language"));
			}
			if(!jsonObj2.opt("maritalStatus").equals(null)){
				contactexport.setMaritalStatus(jsonObj2.getString("maritalStatus"));
			}
			if(!jsonObj2.opt("middleName").equals(null)){
				contactexport.setMiddleName(jsonObj2.getString("middleName"));
			}
			if(jsonObj2.isNull("isTextingPermitted")) {
				contactexport.setIsTextingPermitted(null);
			}else {
			if(!jsonObj2.opt("isTextingPermitted").equals(null)){
				contactexport.setIsTextingPermitted(jsonObj2.getString("isTextingPermitted"));
			}
			}
			if(!jsonObj2.opt("remarket").equals(null)){
				contactexport.setRemarket(jsonObj2.getBoolean("remarket"));
			}
			if(!jsonObj2.opt("abbreviatedName").equals(null)){
				contactexport.setAbbreviatedName(jsonObj2.getString("abbreviatedName"));
			}
			if(!jsonObj2.opt("driverLicenseNumber").equals(null)){
				contactexport.setDriverLicenseNumber(jsonObj2.getString("driverLicenseNumber"));
			}
			//System.out.println((jsonObj2.opt("isTypeClient")).getClass());
			if(!jsonObj2.opt("isTypeClient").equals(null)){
				contactexport.setIsTypeClient((jsonObj2.getBoolean("isTypeClient")));
			}
			if(!jsonObj2.opt("isTypeAdjuster").equals(null)){
				contactexport.setIsTypeAdjuster(jsonObj2.getBoolean("isTypeAdjuster"));
			}
			if(!jsonObj2.opt("isTypeDefendant").equals(null)){
				contactexport.setIsTypeDefendant(jsonObj2.getBoolean("isTypeDefendant"));
			}
			if(!jsonObj2.opt("isTypePlaintiff").equals(null)){
				contactexport.setIsTypePlaintiff(jsonObj2.getBoolean("isTypePlaintiff"));
			}
			if(!jsonObj2.opt("isTypeAttorney").equals(null)){
				contactexport.setIsTypeAttorney(jsonObj2.getBoolean("isTypeAttorney"));
			}
			if(!jsonObj2.opt("isTypeFirm").equals(null)){
				contactexport.setIsTypeFirm(jsonObj2.getBoolean("isTypeFirm"));
			}
			if(!jsonObj2.opt("isTypeExpert").equals(null)){
				contactexport.setIsTypeExpert(jsonObj2.getBoolean("isTypeExpert"));
			}
			if(!jsonObj2.opt("isTypeMedicalProvider").equals(null)){
				contactexport.setIsTypeMedicalProvider(jsonObj2.getBoolean("isTypeMedicalProvider"));
			}
			if(!jsonObj2.opt("isTypeInvolvedParty").equals(null)){
				contactexport.setIsTypeInvolvedParty(jsonObj2.getBoolean("isTypeInvolvedParty"));
			}
			if(!jsonObj2.opt("isTypeJudge").equals(null)){
				contactexport.setIsTypeJudge(jsonObj2.getBoolean("isTypeJudge"));
			}
			if(!jsonObj2.opt("isTypeCourt").equals(null)){
				contactexport.setIsTypeCourt(jsonObj2.getBoolean("isTypeCourt"));
			}
			if(!jsonObj2.opt("isTypeInsuranceCompany").equals(null)){
				contactexport.setIsTypeInsuranceCompany(jsonObj2.getBoolean("isTypeInsuranceCompany"));
			}
			if(!jsonObj2.opt("salutation").equals(null)){
				contactexport.setSalutation(jsonObj2.getString("salutation"));
			}
			if(!jsonObj2.opt("barNumber").equals(null)){
				contactexport.setBarNumber(jsonObj2.getString("barNumber"));
			}
			if(!jsonObj2.opt("fiduciary").equals(null)){
				contactexport.setFiduciary(jsonObj2.getString("fiduciary"));
			}
			if(!jsonObj2.opt("isMinor").equals(null)){
				contactexport.setIsMinor(jsonObj2.getBoolean("isMinor"));
			}
			if(!jsonObj2.opt("uniqueID").equals(null)){
				contactexport.setUniqueID(jsonObj2.getString("uniqueID"));
			}
			if(!jsonObj2.opt("searchNames").equals(null)){
				contactexport.setSearchNames(jsonObj2.getString("searchNames"));
			}
			if(!jsonObj2.opt("orgID").equals(null)){
				contactexport.setOrgID(jsonObj2.getInt("orgID"));
			}
			if(!jsonObj2.opt("firstName").equals(null)){
				contactexport.setFirstName(jsonObj2.getString("firstName"));
			}
			if(!jsonObj2.opt("lastName").equals(null)){
				contactexport.setLastName(jsonObj2.getString("lastName"));
			}
			if(!jsonObj2.opt("isSingleName").equals(null)){
				contactexport.setIsSingleName(jsonObj2.getBoolean("isSingleName"));
			}
			if(!jsonObj2.opt("fullname").equals(null)){
				contactexport.setFullname(jsonObj2.getString("fullname"));
			}
			
			if(jsonObj2.isNull("breadcrumbs")){
				contactexport.setRoleTitle(null);
			}else {
				JSONArray communication3=jsonObj2.getJSONArray("breadcrumbs");
				for(int g=0; g<=communication3.length()-1; k++) {
				JSONObject jsonobject=communication3.getJSONObject(g);
			if(!jsonobject.opt("fieldName").equals(null)){
				contactexport.setRoleTitle(jsonobject.getString("fieldName"));
			}}}
			
			
			contactexportdao.insertContactEmailData(database, contactexport);
		}
		}
	}


}

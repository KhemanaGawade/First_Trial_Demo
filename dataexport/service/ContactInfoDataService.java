package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.AdvanceClientCostExportDao;
import com.filevine.dataexport.dao.ContactExportDAO;
import com.filevine.dataexport.dao.ContactInfoDataDao;
import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.ContactExport;
import com.filevine.dataexport.domain.ContactInfoDataDomain;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ContactInfoDataService {

	
	public String getContactInfoDataResponse(String cookie,String projectID) {
		
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/uniquecontacts";
	
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).get(String.class);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;

		}
	

	public void getContactData(String res, String databaseName,String projectID) throws JSONException, SQLException {
		
		ContactInfoDataDomain  contactinfodatadomain =null;
		ContactInfoDataDao  contactinfodatadao =new ContactInfoDataDao ();
		
		
		int i = res.indexOf("{");
		res = res.substring(i);
		JSONObject jobj = new JSONObject(res);
		if(!jobj.isNull("data")) {
		JSONArray arr = jobj.getJSONArray("data");
		for(int k = 0; k<=arr.length()-1;k++)
		{
			contactinfodatadomain=new ContactInfoDataDomain();
			contactinfodatadomain.setProjectId(projectID);
             JSONObject jsonObj= arr.getJSONObject(k);	
		
             if(jsonObj.isNull("id")) {
  				contactinfodatadomain.setId( null);
 			}else {
 				
 		    if(!jsonObj.opt("id").equals(null)){
 		    	contactinfodatadomain.setId( jsonObj.getString("id"));
 		    }}
             
             if(jsonObj.isNull("role")) {
   				contactinfodatadomain.setRole( null);
  			}else {
  				
  		    if(!jsonObj.opt("role").equals(null)){
  		    	contactinfodatadomain.setRole( jsonObj.getString("role"));
  		    }}
              
             
             if(jsonObj.isNull("personID")) {
    				contactinfodatadomain.setPersonId( null);
   			}else {
   				
   		    if(!jsonObj.opt("personID").equals(null)){
   		    	contactinfodatadomain.setPersonId( jsonObj.getString("personID"));
   		    }}
             
             
 
//             if(!jsonObj.opt("id").equals(null)){
//            	 contactinfodatadomain.setId(jsonObj.getString("id"));
// 			}
// 			if(!jsonObj.opt("role").equals(null)){
// 				contactinfodatadomain.setRole(jsonObj.getString("role"));
// 			}
// 			
// 			if(!jsonObj.opt("personID").equals(null)){
// 				contactinfodatadomain.setPersonId(jsonObj.getString("personID"));
// 			}
//		
 			 JSONObject jsonObj2 = jsonObj.getJSONObject("person");
 			 
 			if(jsonObj2.isNull("orgID")) {
 				contactinfodatadomain.setOrgID( null);
			}else {
				
		    if(!jsonObj2.opt("orgID").equals(null)){
		    	contactinfodatadomain.setOrgID( jsonObj2.getString("orgID"));
		    }}
		
 			if(jsonObj2.isNull("firstName")) {
 				contactinfodatadomain.setFirstName( null);
			}else {
				
		    if(!jsonObj2.opt("firstName").equals(null)){
		    	contactinfodatadomain.setFirstName( jsonObj2.getString("firstName"));
		    }}
		
 			if(jsonObj2.isNull("middleName")) {
 				contactinfodatadomain.setMiddleName( null);
			}else {
				
		    if(!jsonObj2.opt("middleName").equals(null)){
		    	contactinfodatadomain.setMiddleName( jsonObj2.getString("middleName"));
		    }}
 			
 			if(jsonObj2.isNull("lastName")) {
 				contactinfodatadomain.setLastName( null);
			}else {
				
		    if(!jsonObj2.opt("lastName").equals(null)){
		    	contactinfodatadomain.setLastName( jsonObj2.getString("lastName"));
		    }}
 			
 			if(jsonObj2.isNull("fullname")) {
 				contactinfodatadomain.setFullName( null);
			}else {
				
		    if(!jsonObj2.opt("fullname").equals(null)){
		    	contactinfodatadomain.setFullName( jsonObj2.getString("fullname"));
		    }}
 			
 			if(jsonObj2.isNull("fromCompany")) {
 				contactinfodatadomain.setFromCompany( null);
			}else {
				
		    if(!jsonObj2.opt("fromCompany").equals(null)){
		    	contactinfodatadomain.setFromCompany( jsonObj2.getString("fromCompany"));
		    }}
 			
 			if(jsonObj2.isNull("jobTitle")) {
 				contactinfodatadomain.setJobTitle( null);
			}else {
				
		    if(!jsonObj2.opt("jobTitle").equals(null)){
		    	contactinfodatadomain.setJobTitle( jsonObj2.getString("jobTitle"));
		    }}
 			
 			if(jsonObj2.isNull("department")) {
 				contactinfodatadomain.setDepartment( null);
			}else {
				
		    if(!jsonObj2.opt("department").equals(null)){
		    	contactinfodatadomain.setDepartment( jsonObj2.getString("department"));
		    }}
 			
 			if(jsonObj2.isNull("prefix")) {
 				contactinfodatadomain.setPrefix( null);
			}else {
				
		    if(!jsonObj2.opt("prefix").equals(null)){
		    	contactinfodatadomain.setPrefix( jsonObj2.getString("prefix"));
		    }}
		
 			if(jsonObj2.isNull("suffix")) {
 				contactinfodatadomain.setSuffix( null);
			}else {
				
		    if(!jsonObj2.opt("suffix").equals(null)){
		    	contactinfodatadomain.setSuffix( jsonObj2.getString("suffix"));
		    }}
 			
 			if(jsonObj2.isNull("nickname")) {
 				contactinfodatadomain.setNickName( null);
			}else {
				
		    if(!jsonObj2.opt("nickname").equals(null)){
		    	contactinfodatadomain.setNickName( jsonObj2.getString("nickname"));
		    }}
 			
 			if(jsonObj2.isNull("birthDate")) {
 				contactinfodatadomain.setBirthDate( null);
			}else {
				
		    if(!jsonObj2.opt("birthDate").equals(null)){
		    	contactinfodatadomain.setBirthDate( jsonObj2.getString("birthDate"));
		    }}
 			
 			if(jsonObj2.isNull("personTypes")){
 				contactinfodatadomain.setPersonTypes(null);
			}else {
				JSONArray communication3=jsonObj2.getJSONArray("personTypes");
				for(int r=0; r<=communication3.length()-1; r++) {
				JSONObject jsonobject=communication3.getJSONObject(r);
			if(!jsonobject.opt("name").equals(null)){
				contactinfodatadomain.setPersonTypes(jsonobject.getString("name"));
			}}}
 			
 			if(jsonObj2.isNull("isTextingPermitted")) {
 				contactinfodatadomain.setIsTextingPermitted( null);
			}else {
				
		    if(!jsonObj2.opt("isTextingPermitted").equals(null)){
		    	contactinfodatadomain.setIsTextingPermitted( jsonObj2.getString("isTextingPermitted"));
		    }}
 			
 			if(jsonObj2.isNull("gender")) {
 				contactinfodatadomain.setGender( null);
			}else {
				
		    if(!jsonObj2.opt("gender").equals(null)){
		    	contactinfodatadomain.setGender( jsonObj2.getString("gender"));
		    }}
 			
 			
 			if(jsonObj2.isNull("language")) {
 				contactinfodatadomain.setLanguage( null);
			}else {
				
		    if(!jsonObj2.opt("language").equals(null)){
		    	contactinfodatadomain.setLanguage( jsonObj2.getString("language"));
		    }}
 			
 			if(jsonObj2.isNull("maritalStatus")) {
 				contactinfodatadomain.setMaritalStatus( null);
			}else {
				
		    if(!jsonObj2.opt("maritalStatus").equals(null)){
		    	contactinfodatadomain.setMaritalStatus( jsonObj2.getString("maritalStatus"));
		    }}
 			
 			if(jsonObj2.isNull("ssn")) {
 				contactinfodatadomain.setSsn( null);
			}else {
				
		    if(!jsonObj2.opt("ssn").equals(null)){
		    	contactinfodatadomain.setSsn( jsonObj2.getString("ssn"));
		    }}
 			
 			if(jsonObj2.isNull("specialty")) {
 				contactinfodatadomain.setSpecialty( null);
			}else {
				
		    if(!jsonObj2.opt("specialty").equals(null)){
		    	contactinfodatadomain.setSpecialty( jsonObj2.getString("specialty"));
		    }}
 			if(jsonObj2.isNull("notes")) {
 				contactinfodatadomain.setNotes( null);
			}else {
				
		    if(!jsonObj2.opt("notes").equals(null)){
		    	contactinfodatadomain.setNotes( jsonObj2.getString("notes"));
		    }}
 			
 			
 			if(jsonObj2.isNull("driverLicenseNumber")) {
 				contactinfodatadomain.setDriverLicenseNumber( null);
			}else {
				
		    if(!jsonObj2.opt("driverLicenseNumber").equals(null)){
		    	contactinfodatadomain.setDriverLicenseNumber( jsonObj2.getString("driverLicenseNumber"));
		    }}
 			
 			if(jsonObj2.isNull("salutation")) {
 				contactinfodatadomain.setSalutation( null);
			}else {
				
		    if(!jsonObj2.opt("salutation").equals(null)){
		    	contactinfodatadomain.setSalutation( jsonObj2.getString("salutation"));
		    }}
 			
 			if(jsonObj2.isNull("barNumber")) {
 				contactinfodatadomain.setBarNumber( null);
			}else {
				
		    if(!jsonObj2.opt("barNumber").equals(null)){
		    	contactinfodatadomain.setBarNumber( jsonObj2.getString("barNumber"));
		    }}
 			
 			if(jsonObj2.isNull("fiduciary")) {
 				contactinfodatadomain.setFiduciary( null);
			}else {
				
		    if(!jsonObj2.opt("fiduciary").equals(null)){
		    	contactinfodatadomain.setFiduciary( jsonObj2.getString("fiduciary"));
		    }}
 			
 			if(jsonObj2.isNull("remarket")) {
 				contactinfodatadomain.setRemarket( null);
			}else {
				
		    if(!jsonObj2.opt("remarket").equals(null)){
		    	contactinfodatadomain.setRemarket( jsonObj2.getString("remarket"));
		    }}
 			
 			
 			if(jsonObj2.isNull("education")) {
 				contactinfodatadomain.setEducation( null);
			}else {
				
		    if(!jsonObj2.opt("education").equals(null)){
		    	contactinfodatadomain.setEducation( jsonObj2.getString("education"));
		    }}
 			
 			if(jsonObj2.isNull("children")) {
 				contactinfodatadomain.setChildren( null);
			}else {
				
		    if(!jsonObj2.opt("children").equals(null)){
		    	contactinfodatadomain.setChildren( jsonObj2.getString("children"));
		    }}
 			
 			if(jsonObj2.isNull("spouse")){
 				contactinfodatadomain.setSpouse(null);
			}else {
			JSONObject communication9=jsonObj2.getJSONObject("spouse");
			if(!communication9.opt("fullname").equals(null)){
				contactinfodatadomain.setSpouse(communication9.getString("fullname"));
			}}
 			
 			
 			
// 			
// 			if(jsonObj2.isNull("spouse")) {
// 				contactinfodatadomain.setSpouse( null);
//			}else {
//				
//		    if(!jsonObj2.opt("spouse").equals(null)){
//		    	contactinfodatadomain.setSpouse( jsonObj2.getString("spouse"));
//		    }}
 			
 			if(jsonObj2.isNull("taxid")) {
 				contactinfodatadomain.setTaxId( null);
			}else {
				
		    if(!jsonObj2.opt("taxid").equals(null)){
		    	contactinfodatadomain.setTaxId( jsonObj2.getString("taxid"));
		    }}
 			
 			if(jsonObj2.isNull("isMinor")) {
 				contactinfodatadomain.setIsMinor( null);
			}else {
				
		    if(!jsonObj2.opt("isMinor").equals(null)){
		    	contactinfodatadomain.setIsMinor( jsonObj2.getString("isMinor"));
		    }}
 			
 			if(jsonObj2.isNull("isMinor")) {
 				contactinfodatadomain.setIsMinor( null);
			}else {
				
		    if(!jsonObj2.opt("isMinor").equals(null)){
		    	contactinfodatadomain.setIsMinor( jsonObj2.getString("isMinor"));
		    }}
 			
 			if(jsonObj2.isNull("citystatebornin")) {
 				contactinfodatadomain.setCityStateBornIn( null);
			}else {
				
		    if(!jsonObj2.opt("citystatebornin").equals(null)){
		    	contactinfodatadomain.setCityStateBornIn( jsonObj2.getString("citystatebornin"));
		    }}
 			
 			if(jsonObj2.isNull("abbreviatedname")) {
 				contactinfodatadomain.setAbbreviatedName( null);
			}else {
				
		    if(!jsonObj2.opt("abbreviatedname").equals(null)){
		    	contactinfodatadomain.setAbbreviatedName( jsonObj2.getString("abbreviatedname"));
		    }}
 			
 			if(jsonObj2.isNull("recordskeeper")) {
 				contactinfodatadomain.setRecordsKeeper( null);
			}else {
				
		    if(!jsonObj2.opt("recordskeeper").equals(null)){
		    	contactinfodatadomain.setRecordsKeeper( jsonObj2.getString("recordskeeper"));
		    }}
 			
 			
 			if(jsonObj.isNull("breadcrumbs")){
 				contactinfodatadomain.setWorkRole(null);
			}else {
				JSONArray communication4=jsonObj.getJSONArray("breadcrumbs");
				for(int g=0; g<=communication4.length()-1; g++) {
				JSONObject jsonobject=communication4.getJSONObject(g);
			if(jsonobject.isNull("fieldName")){
				contactinfodatadomain.setWorkRole(null);
			}
			else {
				
			    if(!jsonobject.opt("fieldName").equals(null)){
			    	contactinfodatadomain.setWorkRole( jsonobject.getString("fieldName"));
			    }}}}
 			
 			
 			
 			
 			
 			if(jsonObj2.isNull("spouse")){
 				contactinfodatadomain.setSpouse(null);
			}else {
			JSONObject communication12=jsonObj2.getJSONObject("spouse");
			if(!communication12.opt("fullname").equals(null)){
				contactinfodatadomain.setSpouse(communication12.getString("fullname"));
			}}
 			
 			
 			
 			
 			try {
				contactinfodatadao.insertContactData(databaseName, contactinfodatadomain);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
		
	
		}
		
		
		
		}
	}
}
		
		
		
		
		
		
		
		
		
		
	
	
	
		


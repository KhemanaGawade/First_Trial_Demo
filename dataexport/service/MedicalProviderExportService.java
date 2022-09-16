package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.MedicalExportDAO;
import com.filevine.dataexport.dao.MedicalProviderExportDao;
import com.filevine.dataexport.domain.MedicalExport;
import com.filevine.dataexport.domain.MedicalProviderExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class MedicalProviderExportService {

	public String getMedicalProviderResponse(String cookie, String projectID) {
		String response=null;
		//For Witness
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/witnesses16407?page=1";
		//For Employer
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/employer16485?page=1";
		// for defendant
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/defendants16407?page=1";
		// for client info
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/clientinfo16408?page=1";
//		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"selectedPageNumber\":1,\"sortField\":\"witness191317\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
        String url="https://app.filevine.com/api/projects/+projectID+/custom/witnesses16407?page=1";
	//	String url="https://app.filevine.com/api/projects/"+projectID+"/custom/defendants16407?page=1";
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"witness191317\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		//medical provider from med/sub
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/meds16407?page=1";
//		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"provider145685\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}s";
//		employer48361,driver48361,officername48361,nameofspouse48361,passengerinyourcar48361,emergencycontact48361,vehicleowner48361  from intake
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/intake6573?page=1";
//		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
//		insurance- insurer48355,adjuster48355
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/insurance6573?page=1";
//		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"insurer48355\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
//		3rd party insurance- insurer55525,adjuster55525
//		String url="https://app.filevine.com/api/projects/"+projectID+"/custom/s_1stpartyinsurance6573?page=1";
//		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"insurer55525\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";

		try {
			WebResource webRespource=Client.create().resource(url);
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;
	}

	public void getMedicalProviderData(String response, String database) throws JSONException, SQLException {
		MedicalProviderExportDao medicalExportDAO=new MedicalProviderExportDao();
		MedicalProviderExport medicalExport=new MedicalProviderExport();	
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject medicalData=new JSONObject(res);
		if(!medicalData.opt("projectID").equals(null)){
			medicalExport.setProjectId(medicalData.getString("projectID"));
		}
		JSONObject medical=medicalData.getJSONObject("data") ;
		if(!medical.isNull("customObject")) {
		JSONObject jsonObj1=medical.getJSONObject("customObject") ;
		// for client info
		if(!jsonObj1.isNull("primarycontact191336")) {
			JSONObject clientInfo = jsonObj1.getJSONObject("primarycontact191336") ;
			if(!clientInfo.opt("id").equals(null)){
				medicalExport.setPersonId(clientInfo.getString("id"));
			}
			if(!clientInfo.opt("fullname").equals(null)){
				medicalExport.setFullname(clientInfo.getString("fullname"));
			}
		}
		if(!jsonObj1.isNull("referralsource191336")) {
		if(!jsonObj1.opt("referralsource191336").equals(null)){
			medicalExport.setReferalSource(jsonObj1.getString("referralsource191336"));
		}}else {
			medicalExport.setReferalSource(null);
		}
		if(!jsonObj1.isNull("clientnotes191336")) {
		if(!jsonObj1.opt("clientnotes191336").equals(null)){
			medicalExport.setClientInfoNote(jsonObj1.getString("clientnotes191336"));
		}}else {
			medicalExport.setClientInfoNote(null);
		}
		if(!jsonObj1.isNull("_itemHeader")) {
			JSONObject itemHeader=jsonObj1.getJSONObject("_itemHeader");
			if(!itemHeader.isNull("createdDate")) {
			if(!itemHeader.opt("createdDate").equals(null)){
				medicalExport.setCreated_date(itemHeader.getString("createdDate"));
		}}}
		if(!jsonObj1.opt("_id").equals(null)){
			medicalExport.setId(jsonObj1.getString("_id"));
		}
   //	medicalExportDAO.inserEmployerData(database,medicalExport);
	}
    	if(!medical.isNull("collection")) {

    			JSONArray medicals = medical.getJSONArray("collection");
    //

			for(int k=0;k<medicals.length(); k++) {
				
				JSONObject jsonObj=medicals.getJSONObject(k);	
				if(!jsonObj.isNull("witness191317")) {
					JSONObject witness = jsonObj.getJSONObject("witness191317") ;
					if(!witness.opt("id").equals(null)){
						medicalExport.setPersonId(witness.getString("id"));
					}
					if(!witness.opt("fullname").equals(null)){
						medicalExport.setFullname(witness.getString("fullname"));
					}
					
				}
				// employer
				if(!jsonObj.isNull("name192618")) {
					JSONObject employer = jsonObj.getJSONObject("name192618") ;
					if(!employer.opt("id").equals(null)){
						medicalExport.setPersonId(employer.getString("id"));
					}
					if(!employer.opt("fullname").equals(null)){
						medicalExport.setFullname(employer.getString("fullname"));
					}
					
				}
				if(!jsonObj.isNull("defendant191325")) {
					JSONObject defendant = jsonObj.getJSONObject("defendant191325") ;
					if(!defendant.opt("id").equals(null)){
						medicalExport.setPersonId(defendant.getString("id"));
					}
					if(!defendant.opt("fullname").equals(null)){
						medicalExport.setFullname(defendant.getString("fullname"));
					}
					
				}
				if(!jsonObj.isNull("notes191325")) {
				if(!jsonObj.opt("notes191325").equals(null)){
					medicalExport.setDefendanNotes(jsonObj.getString("notes191325"));
				}}else {
					medicalExport.setDefendanNotes(null);
				}
				
				medicalExportDAO.inserwitnessData(database,medicalExport);
				
				if(!jsonObj.isNull("insurer55525")) {
				JSONObject med = jsonObj.getJSONObject("insurer55525") ;
				if(!med.opt("id").equals(null)){
					medicalExport.setPersonId(med.getString("id"));
				}
				if(!med.opt("orgID").equals(null)){
					medicalExport.setOrgId(med.getString("orgID"));
				}
				if(!med.opt("firstName").equals(null)){
					medicalExport.setFirstName(med.getString("firstName"));
				}
				if(!med.opt("middleName").equals(null)){
					medicalExport.setMiddleName(med.getString("middleName"));
				}
				if(!med.opt("lastName").equals(null)){
					medicalExport.setLastName(med.getString("lastName"));
				}
				if(!med.opt("fullname").equals(null)){
					medicalExport.setFullname(med.getString("fullname"));
				}
				if(!med.opt("isSingleName").equals(null)){
					medicalExport.setIsSingleName(med.getString("isSingleName"));
				}
				if(!med.opt("fromCompany").equals(null)){
					medicalExport.setFromCompany(med.getString("fromCompany"));
				}
				if(!med.opt("ssn").equals(null)){
					medicalExport.setSsn(med.getString("ssn"));
				}
				if(!med.opt("birthDate").equals(null)){
					medicalExport.setBirthDate(med.getString("birthDate"));
				}
				if(!med.opt("notes").equals(null)){
					medicalExport.setNotes(med.getString("notes"));
				}
				if(!med.opt("specialty").equals(null)){
					medicalExport.setSpecialty(med.getString("specialty"));
				}
				if(!med.opt("gender").equals(null)){
					medicalExport.setGender(med.getString("gender"));
				}
				if(!med.opt("language").equals(null)){
					medicalExport.setLanguage(med.getString("language"));
				}
				if(!med.opt("maritalStatus").equals(null)){
					medicalExport.setMaritalStatus(med.getString("maritalStatus"));
				}
				if(!med.opt("isTextingPermitted").equals(null)){
					medicalExport.setIsTextingPermitted(med.getString("isTextingPermitted"));
				}
				if(!med.opt("remarket").equals(null)){
					medicalExport.setRemarket(med.getString("remarket"));
				}
				if(!med.opt("abbreviatedName").equals(null)){
					medicalExport.setAbbreviatedName(med.getString("abbreviatedName"));
				}
				if(!med.opt("driverLicenseNumber").equals(null)){
					medicalExport.setDriverLicenseNumber(med.getString("driverLicenseNumber"));
				}
				if(!med.opt("isTypeClient").equals(null)){
					medicalExport.setIsTypeClient(med.getString("isTypeClient"));
				}
				if(!med.opt("uniqueID").equals(null)){
					medicalExport.setUniqueID(med.getString("uniqueID"));
				}
				if(!med.opt("isTypeAdjuster").equals(null)){
					medicalExport.setIsTypeAdjuster(med.getString("isTypeAdjuster"));
				}
				if(!med.opt("isTypeDefendant").equals(null)){
					medicalExport.setIsTypeDefendant(med.getString("isTypeDefendant"));
				}
				if(!med.opt("isTypePlaintiff").equals(null)){
					medicalExport.setIsTypePlaintiff(med.getString("isTypePlaintiff"));
				}
				if(!med.opt("isTypeAttorney").equals(null)){
					medicalExport.setIsTypeAttorney(med.getString("isTypeAttorney"));
				}
				if(!med.opt("isTypeFirm").equals(null)){
					medicalExport.setIsTypeFirm(med.getString("isTypeFirm"));
				}
				if(!med.opt("isTypeExpert").equals(null)){
					medicalExport.setIsTypeExpert(med.getString("isTypeExpert"));
				}
				if(!med.opt("isTypeMedicalProvider").equals(null)){
					medicalExport.setIsTypeMedicalProvider(med.getString("isTypeMedicalProvider"));
				}
				if(!med.opt("isTypeInvolvedParty").equals(null)){
					medicalExport.setIsTypeInvolvedParty(med.getString("isTypeInvolvedParty"));
				}
				if(!med.opt("isTypeJudge").equals(null)){
					medicalExport.setIsTypeJudge(med.getString("isTypeJudge"));
				}
				if(!med.opt("isTypeCourt").equals(null)){
					medicalExport.setIsTypeCourt(med.getString("isTypeCourt"));
				}
				if(!med.opt("isTypeInsuranceCompany").equals(null)){
					medicalExport.setIsTypeInsuranceCompany(med.getString("isTypeInsuranceCompany"));
				}
				if(!med.opt("salutation").equals(null)){
					medicalExport.setSalutation(med.getString("salutation"));
				}
				if(!med.opt("fiduciary").equals(null)){
					medicalExport.setFiduciary(med.getString("fiduciary"));
				}
				if(!med.opt("isMinor").equals(null)){
					medicalExport.setIsMinor(med.getString("isMinor"));
				}
				if(!med.opt("barNumber").equals(null)){
					medicalExport.setBarNumber(med.getString("barNumber"));
				}
				
				if(!med.opt("searchNames").equals(null)){
					medicalExport.setSearchNames(med.getString("searchNames"));
				}
				 JSONArray personType = med.getJSONArray("personTypes");
					for(int j = 0; j<personType.length();j++)
					{
						 JSONObject jsonObjType = personType.getJSONObject(j);
						 if(!jsonObjType.opt("name").equals(null)){
							 medicalExport.setPersonType(jsonObjType.getString("name"));
						 }
					}
//				medicalExportDAO.insertMedicalProviderData(database,medicalExport);
				
				//phone
				JSONArray phoneArray=med.getJSONArray("phones");
				for(int j=0;j<phoneArray.length(); j++) {
					
				JSONObject jsonObjPhone=phoneArray.getJSONObject(j);	
				if(!jsonObjPhone.opt("id").equals(null)){
					medicalExport.setPhoneId(jsonObjPhone.getString("id"));
				}
				if(!jsonObjPhone.opt("number").equals(null)){
					medicalExport.setNumber(jsonObjPhone.getString("number"));
				}
				if(!jsonObjPhone.opt("rawNumber").equals(null)){
					medicalExport.setRawNumber(jsonObjPhone.getString("rawNumber"));
				}
				if(!jsonObjPhone.opt("label").equals(null)){
					medicalExport.setPhoneLabel(jsonObjPhone.getString("label"));
				}
//				medicalExportDAO.insertPhoneData(database,medicalExport);
				}
				//address
				JSONArray addressArray=med.getJSONArray("addresses");
				for(int j=0;j<addressArray.length(); j++) {
					
				JSONObject jsonObjAddress=addressArray.getJSONObject(j);	
				if(!jsonObjAddress.opt("id").equals(null)){
					medicalExport.setAddressId(jsonObjAddress.getString("id"));
				}
				if(!jsonObjAddress.opt("line1").equals(null)){
					medicalExport.setLine1(jsonObjAddress.getString("line1"));
				}
				if(!jsonObjAddress.opt("line2").equals(null)){
					medicalExport.setLine2(jsonObjAddress.getString("line2"));
				}
				if(!jsonObjAddress.opt("city").equals(null)){
					medicalExport.setCity(jsonObjAddress.getString("city"));
				}
				if(!jsonObjAddress.opt("state").equals(null)){
					medicalExport.setState(jsonObjAddress.getString("state"));
				}
				if(!jsonObjAddress.opt("zip").equals(null)){
					medicalExport.setZip(jsonObjAddress.getString("zip"));
				}
				if(!jsonObjAddress.opt("label").equals(null)){
					medicalExport.setAddressLabel(jsonObjAddress.getString("label"));
				}
				if(!jsonObjAddress.opt("fullAddress").equals(null)){
					medicalExport.setFullAddress(jsonObjAddress.getString("fullAddress"));
				}
	//			medicalExportDAO.insertAddressData(database,medicalExport);
				}
				//email
				JSONArray emailArray=med.getJSONArray("emails");
				for(int j=0;j<emailArray.length(); j++) {
					
				JSONObject jsonObjEmail=emailArray.getJSONObject(j);	
				if(!jsonObjEmail.opt("id").equals(null)){
					medicalExport.setEmailId(jsonObjEmail.getString("id"));
				}
				if(!jsonObjEmail.opt("address").equals(null)){
					medicalExport.setAddress(jsonObjEmail.getString("address"));
				}
				if(!jsonObjEmail.opt("label").equals(null)){
					medicalExport.setEmailLable(jsonObjEmail.getString("label"));
				}
				
//				medicalExportDAO.insertEmailData(database,medicalExport);
				}
				
				}
			}
		}
		
	}

}

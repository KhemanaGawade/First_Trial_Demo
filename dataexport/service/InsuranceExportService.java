package com.filevine.dataexport.service;

import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;
import com.filevine.dataexport.dao.InsuranceExportDao;
import com.filevine.dataexport.domain.InsuranceExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class InsuranceExportService {

	public String getInsuranceResponse(String cookie, String projectId) {
    String response=null;
		
//		String id="74925151";
         String url="https://app.filevine.com/api/projects/"+projectId+"/custom/insurance16407?page=1";
		//for insurance
	//	String url="https://app.filevine.com/api/projects/"+projectId+"/custom/insurance16407?page=1";
	//	String url="https://app.filevine.com/api/projects/10152766/custom/insurance16407?page=1";
		//for 3rd party insurance
//		String url="https://app.filevine.com/api/projects/"+projectId+"/custom/s_1stpartyinsurance16407?page=1";
		String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"insuranceprovider191322\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":20,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"insurer55525\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
//				System.out.println("response :: "+response);	
		    }
			
		catch(Exception e) {
			System.out.println("Fail to get repsonse from UI");
			e.printStackTrace();
		}
		return response;
		
	}

	public void getInsuranceData(String response, String databaseName) throws Exception {
		InsuranceExportDao insuranceExportDao=new InsuranceExportDao();
		InsuranceExport insuranceExport=new InsuranceExport();
		System.out.println(response);
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		//System.out.println("Project ID :"+jsonObj.getInt("projectID"));
		if(!jsonObj.isNull("projectID")) {
		if(!jsonObj.opt("projectID").equals(null)){
			insuranceExport.setProjectId(jsonObj.getInt("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.opt("collection").equals(null)) {
		JSONArray insurance=data.getJSONArray("collection");
		for(int j=0; j<=insurance.length()-1; j++) {
			
			JSONObject jsonObject=insurance.getJSONObject(j);

			if(jsonObject.isNull("policynumber191322") ) {
				insuranceExport.setPolicyNumber(null);
			}else {
			if(!jsonObject.opt("policynumber191322").equals(null)) {
				insuranceExport.setPolicyNumber(jsonObject.getString("policynumber191322"));
			}}
			if(!jsonObject.opt("_id").equals(null)){
				insuranceExport.setPolicyId(jsonObject.getString("_id"));
			}
			if(jsonObject.isNull("claimnumber191322")) {
				insuranceExport.setClaimNumber(null);
			}else {
			if(!jsonObject.opt("claimnumber191322").equals(null)){
				insuranceExport.setClaimNumber(jsonObject.getString("claimnumber191322"));
			}}
			if(jsonObject.isNull("insurancetype191322")) {
				insuranceExport.setInsurance_type(null);
			}else {
			if(!jsonObject.opt("insurancetype191322").equals(null)){
				insuranceExport.setInsurance_type(jsonObject.getString("insurancetype191322"));
			}}
			if(jsonObject.isNull("liabilitydecision191322")) {
				insuranceExport.setLiabilityDecision(null);
			}else {
			if(!jsonObject.opt("liabilitydecision191322").equals(null)){
				insuranceExport.setLiabilityDecision(jsonObject.getString("liabilitydecision191322"));
			}}
			if(jsonObject.isNull("umtype191322")) {
				insuranceExport.setUmType(null);
			}else {
			if(!jsonObject.opt("umtype191322").equals(null)){
				insuranceExport.setUmType(jsonObject.getString("umtype191322"));
			}}
			if(jsonObject.isNull("ispipexhausted191322")) {
				insuranceExport.setIspipexhausted(null);
			}else {
			if(!jsonObject.opt("ispipexhausted191322").equals(null)){
				insuranceExport.setIspipexhausted(jsonObject.getString("ispipexhausted191322"));
			}}
			if(jsonObject.isNull("pip191322")) {
				insuranceExport.setPip(null);
			}else {
			if(!jsonObject.opt("pip191322").equals(null)){
				insuranceExport.setPip(jsonObject.getString("pip191322"));
			}}
			if(jsonObject.isNull("notes191322")) {
				insuranceExport.setNotes(null);
			}else {
			if(!jsonObject.opt("notes191322").equals(null)){
				insuranceExport.setNotes(jsonObject.getString("notes191322"));
			}}
			if(jsonObject.isNull("pipcoverageamount191322")) {
				insuranceExport.setPipcoverageamount(null);
			}else {
			if(!jsonObject.opt("pipcoverageamount191322").equals(null)){
				insuranceExport.setPipcoverageamount(jsonObject.getString("pipcoverageamount191322"));
			}}
			if(jsonObject.isNull("umuimcoverageamount191322")) {
				insuranceExport.setUmuimcoverageamount(null);
			}else {
			if(!jsonObject.opt("umuimcoverageamount191322").equals(null)){
				insuranceExport.setUmuimcoverageamount(jsonObject.getString("umuimcoverageamount191322"));
			}}
			
		//	System.out.println("policy holder : "+jsonObject.opt("policyholder145686"));
			if(jsonObject.isNull("policyholder191322")) {
				insuranceExport.setPolicyHolder("null");
			}else {
			if(!jsonObject.opt("policyholder191322").equals(null)){
				insuranceExport.setPolicyHolder(jsonObject.getString("policyholder191322"));
			}}
			if(jsonObject.isNull("insuranceprovider191322")){
				insuranceExport.setInsurance_provider_id("");
			}else {
			JSONObject jsonInsurer=jsonObject.getJSONObject("insuranceprovider191322");
			if(!jsonInsurer.opt("id").equals(null)){
				insuranceExport.setInsurance_provider_id(jsonInsurer.getString("id"));
			}}
			if(jsonObject.isNull("insurer191322")){
				insuranceExport.setInseurerId(0);
			}else {
			JSONObject jsonInsurer=jsonObject.getJSONObject("insurer191322");
			if(!jsonInsurer.opt("id").equals(null)){
				insuranceExport.setInseurerId(jsonInsurer.getInt("id"));
			}}
			if(jsonObject.isNull("personinsured191322")) {
				insuranceExport.setInsuredId(0);
			}else {
			JSONObject jsonInsured=jsonObject.getJSONObject("personinsured191322");
			if(!jsonInsured.opt("id").equals(null)){
				insuranceExport.setInsuredId(jsonInsured.getInt("id"));
			}}
			if(jsonObject.isNull("adjuster191322")) {
				insuranceExport.setAdjusterId(0);
			}else {
			JSONObject jsonAdjuster=jsonObject.getJSONObject("adjuster191322");
			if(!jsonAdjuster.opt("id").equals(null)){
				insuranceExport.setAdjusterId(jsonAdjuster.getInt("id"));
			}}
			if(jsonObject.isNull("policylimits191322")) {
				insuranceExport.setLimit(null);
			}else {
			if(!jsonObject.opt("policylimits191322").equals(null)){
				insuranceExport.setLimit(jsonObject.getString("policylimits191322"));
			}}
			if(jsonObject.isNull("totallimits191322")) {
				insuranceExport.setTotal_limit(null);
			}else {
			if(!jsonObject.opt("totallimits191322").equals(null)){
				insuranceExport.setTotal_limit(jsonObject.getString("totallimits191322"));
			}}
			if(jsonObject.isNull("driverofvehicle191322")) {
				insuranceExport.setDriverVehicleId(0);
			}else {
			JSONObject jsonDriverVehicle=jsonObject.getJSONObject("driverofvehicle191322");
			if(!jsonDriverVehicle.opt("id").equals(null)){
				insuranceExport.setDriverVehicleId(jsonDriverVehicle.getInt("id"));
			}}
			if(jsonObject.isNull("f_3rdpartyinsurancecompany191322")) {
				insuranceExport.setThirdPartyInsuranceId(0);
			}else {
			JSONObject jsonThirdPartyInsurance=jsonObject.getJSONObject("f_3rdpartyinsurancecompany191322");
			if(!jsonThirdPartyInsurance.opt("id").equals(null)){
				insuranceExport.setThirdPartyInsuranceId(jsonThirdPartyInsurance.getInt("id"));
			}
			}
			insuranceExportDao.insertInsuranceData(insuranceExport, databaseName);
		}
		}
		}}

}

package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.IntakeExportDao;
import com.filevine.dataexport.domain.IntakeDetailExport;
import com.filevine.dataexport.domain.IntakeExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class IntakeExportService {
//	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public String getIntakeResponse(String cookie, String projectId) {
		MDC.put("path", "File Vine:: Intake Export");
        String response=null;
		
      //  String url="https://app.filevine.com/api/projects/"+projectId+"/custom/intakeaccidentinfo16407?page=1";
		String url="https://app.filevine.com/api/projects/"+projectId+"/custom/intakeaccidentinfo16407?page=1";
       String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
        //String url="https://app.filevine.com/api/projects/"+projectId+"/custom/intake16433?page=1";
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
//		String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\r\n" + 
//				"\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
//				System.out.println("response :: "+response);	
			eventLogger.info("Response has been exported!!");
		    }
			
		catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Fail to get repsonse from UI");
//			e.printStackTrace();
		}
		return response;
	}

	public void getIntakeData(String response, String databaseName) throws Exception {
		IntakeExportDao intakeExportDao=new IntakeExportDao();
		IntakeExport intakeExport = new IntakeExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject jsonObj=new JSONObject(res);
		if(!jsonObj.opt("projectID").equals(null)){
			intakeExport.setProjectId(jsonObj.getString("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(data.isNull("customObject")) {
			System.out.println("No data found");
		}else {
		JSONObject intakeData=data.getJSONObject("customObject");
		if(intakeData.isNull("werecitationsissued191323")) {
			intakeExport.setWerecitationsissued(null);
		}else {
		if(!intakeData.opt("werecitationsissued191323").equals(null)){
			intakeExport.setWerecitationsissued(intakeData.getString("werecitationsissued191323"));
		}
		}
		if(intakeData.isNull("policereport191323")) {
			intakeExport.setPolicereport(null);
		}else {
		if(!intakeData.opt("policereport191323").equals(null)){
			intakeExport.setPolicereport(intakeData.getString("policereport191323"));
		}
		}
		if(intakeData.isNull("picturesofdamages191323")) {
			intakeExport.setPicturesofdamages(null);
		}else {
		if(!intakeData.opt("picturesofdamages191323").equals(null)){
			intakeExport.setPicturesofdamages(intakeData.getString("picturesofdamages191323"));
		}
		}
		if(intakeData.isNull("vehicletowed191323")) {
			intakeExport.setVehicletowed(null);
		}else {
		if(!intakeData.opt("vehicletowed191323").equals(null)){
			intakeExport.setVehicletowed(intakeData.getString("vehicletowed191323"));
		}
		}
		if(intakeData.isNull("estimatedone191323")) {
			intakeExport.setEstimatedone(null);
		}else {
		if(!intakeData.opt("estimatedone191323").equals(null)){
			intakeExport.setEstimatedone(intakeData.getString("estimatedone191323"));
		}
		}
		if(intakeData.isNull("picturestakenofinjuries191323")) {
			intakeExport.setPicturestakenofinjuries(null);
		}else {
		if(!intakeData.opt("picturestakenofinjuries191323").equals(null)){
			intakeExport.setPicturestakenofinjuries(intakeData.getString("picturestakenofinjuries191323"));
		}
		}
		if(intakeData.isNull("subsequentaccidents191323")) {
			intakeExport.setSubsequentaccidents(null);
		}else {
		if(!intakeData.opt("subsequentaccidents191323").equals(null)){
			intakeExport.setSubsequentaccidents(intakeData.getString("subsequentaccidents191323"));
		}
		}
		if(intakeData.isNull("reviewsocialmedialetterpolicy191323")) {
			intakeExport.setReviewsocialmedialetterpolicy(null);
		}else {
		if(!intakeData.opt("reviewsocialmedialetterpolicy191323").equals(null)){
			intakeExport.setReviewsocialmedialetterpolicy(intakeData.getString("reviewsocialmedialetterpolicy191323"));
		}
		}
		if(intakeData.isNull("concurrentemployment191323")) {
			intakeExport.setConcurrentemployment(null);
		}else {
		if(!intakeData.opt("concurrentemployment191323").equals(null)){
			intakeExport.setConcurrentemployment(intakeData.getString("concurrentemployment191323"));
		}
		}
		if(intakeData.isNull("witnesses191323")) {
			intakeExport.setWitnesses(null);
		}else{
		if(!intakeData.opt("witnesses191323").equals(null)){
			intakeExport.setWitnesses(intakeData.getString("witnesses191323"));
		}
		}
		if(intakeData.isNull("wereyoutransportedinanambulance191323")) {
			intakeExport.setWereyoutransportedinanambulance(null);
		}else {
		if(!intakeData.opt("wereyoutransportedinanambulance191323").equals(null)){
			intakeExport.setWereyoutransportedinanambulance(intakeData.getString("wereyoutransportedinanambulance191323"));
		}
		}
		if(intakeData.isNull("didyougotothehospital191323")) {
			intakeExport.setDidyougotothehospital(null);
		}else {
		if(!intakeData.opt("didyougotothehospital191323").equals(null)){
			intakeExport.setDidyougotothehospital(intakeData.getString("didyougotothehospital191323"));
		}
		}
		if(intakeData.isNull("chiropractictreatment191323")) {
			intakeExport.setChiropractictreatment(null);
		}else {
		if(!intakeData.opt("chiropractictreatment191323").equals(null)){
			intakeExport.setChiropractictreatment(intakeData.getString("chiropractictreatment191323"));
		}
		}
		if(intakeData.isNull("accidenttype191323")) {
			intakeExport.setAccidenttype(null);
		}else {
		if(!intakeData.opt("accidenttype191323").equals(null)){
			intakeExport.setAccidenttype(intakeData.getString("accidenttype191323"));
		}
		}
		if(intakeData.isNull("timeofaccident191323")) {
			intakeExport.setTimeofaccident(null);
		}else {
		if(!intakeData.opt("timeofaccident191323").equals(null)){
			intakeExport.setTimeofaccident(intakeData.getString("timeofaccident191323"));
		}
		}
		if(intakeData.isNull("descriptionofaccident191323")) {
			intakeExport.setDescriptionofaccident(null);
		}else {
		if(!intakeData.opt("descriptionofaccident191323").equals(null)){
			intakeExport.setDescriptionofaccident(intakeData.getString("descriptionofaccident191323"));
		}
		}
		if(intakeData.isNull("clientsvehiclemakemodel191323")) {
			intakeExport.setClientsvehiclemakemodel(null);
		}else {
		if(!intakeData.opt("clientsvehiclemakemodel191323").equals(null)){
			intakeExport.setClientsvehiclemakemodel(intakeData.getString("clientsvehiclemakemodel191323"));
		}
		}
		if(intakeData.isNull("damagetoclientsvehicle191323")) {
			intakeExport.setDamagetoclientsvehicle(null);
		}else {
		if(!intakeData.opt("damagetoclientsvehicle191323").equals(null)){
			intakeExport.setDamagetoclientsvehicle(intakeData.getString("damagetoclientsvehicle191323"));
		}
		}
		if(intakeData.isNull("defendantsvehiclemakemodel191323")) {
			intakeExport.setDefendantsvehiclemakemodel(null);
		}else {
		if(!intakeData.opt("defendantsvehiclemakemodel191323").equals(null)){
			intakeExport.setDefendantsvehiclemakemodel(intakeData.getString("defendantsvehiclemakemodel191323"));
		}
		}
		if(intakeData.isNull("damagetodefendantsvehicle191323")) {
			intakeExport.setDamagetodefendantsvehicle(null);
		}else {
		if(!intakeData.opt("damagetodefendantsvehicle191323").equals(null)){
			intakeExport.setDamagetodefendantsvehicle(intakeData.getString("damagetodefendantsvehicle191323"));
		}
		}
		if(intakeData.isNull("bywhomandwhere191323")) {
			intakeExport.setBywhomandwhere(null);
		}else {
		if(!intakeData.opt("bywhomandwhere191323").equals(null)){
			intakeExport.setBywhomandwhere(intakeData.getString("bywhomandwhere191323"));
		}
		}
		if(intakeData.isNull("locationofclientsvehicle191323")) {
			intakeExport.setLocationofclientsvehicle(null);
		}else {
		if(!intakeData.opt("locationofclientsvehicle191323").equals(null)){
			intakeExport.setLocationofclientsvehicle(intakeData.getString("locationofclientsvehicle191323"));
		}
		}
		if(intakeData.isNull("rentaloptionsownliabnone191323")) {
			intakeExport.setRentaloptionsownliabnone(null);
		}else {
		if(!intakeData.opt("rentaloptionsownliabnone191323").equals(null)){
			intakeExport.setRentaloptionsownliabnone(intakeData.getString("rentaloptionsownliabnone191323"));
		}
		}
		if(intakeData.isNull("injuriessustainedpaincomplaints191323")) {
			intakeExport.setInjuriessustainedpaincomplaints(null);
		}else {
		if(!intakeData.opt("injuriessustainedpaincomplaints191323").equals(null)){
			intakeExport.setInjuriessustainedpaincomplaints(intakeData.getString("injuriessustainedpaincomplaints191323"));
		}
		}
		if(intakeData.isNull("priorinjuries191323")) {
			intakeExport.setPriorinjuries(null);
		}else {
		if(!intakeData.opt("priorinjuries191323").equals(null)){
			intakeExport.setPriorinjuries(intakeData.getString("priorinjuries191323"));
		}
		}
		if(intakeData.isNull("priorclaimswattorneyandreceived191323")) {
			intakeExport.setPriorclaimswattorneyandreceived(null);
		}else {
		if(!intakeData.opt("priorclaimswattorneyandreceived191323").equals(null)){
			intakeExport.setPriorclaimswattorneyandreceived(intakeData.getString("priorclaimswattorneyandreceived191323"));
		}
		}
		if(intakeData.isNull("priorlawsuitswattorneyandreceived191323")) {
			intakeExport.setPriorlawsuitswattorneyandreceived(null);
		}else {
		if(!intakeData.opt("priorlawsuitswattorneyandreceived191323").equals(null)){
			intakeExport.setPriorlawsuitswattorneyandreceived(intakeData.getString("priorlawsuitswattorneyandreceived191323"));
		}
		}
		if(intakeData.isNull("employmentstatus191323")) {
			intakeExport.setEmploymentstatus(null);
		}else {
		if(!intakeData.opt("employmentstatus191323").equals(null)){
			intakeExport.setEmploymentstatus(intakeData.getString("employmentstatus191323"));
		}
		}
		if(intakeData.isNull("jobtitle191323")) {
			intakeExport.setJobtitle(null);
		}else {
		if(!intakeData.opt("jobtitle191323").equals(null)){
			intakeExport.setJobtitle(intakeData.getString("jobtitle191323"));
		}
		}
		if(intakeData.isNull("thingsclientcannolongerdoatall191323")) {
			intakeExport.setThingsclientcannolongerdoatall(null);
		}else {
		if(!intakeData.opt("thingsclientcannolongerdoatall191323").equals(null)){
			intakeExport.setThingsclientcannolongerdoatall(intakeData.getString("thingsclientcannolongerdoatall191323"));
		}
		}
		if(intakeData.isNull("canbutwithpainnotaswell191323")) {
			intakeExport.setCanbutwithpainnotaswell(null);
		}else {
		if(!intakeData.opt("canbutwithpainnotaswell191323").equals(null)){
			intakeExport.setCanbutwithpainnotaswell(intakeData.getString("canbutwithpainnotaswell191323"));
		}
		}
		if(intakeData.isNull("lossoflifesenjoyment191323")) {
			intakeExport.setLossoflifesenjoyment(null);
		}else {
		if(!intakeData.opt("lossoflifesenjoyment191323").equals(null)){
			intakeExport.setLossoflifesenjoyment(intakeData.getString("lossoflifesenjoyment191323"));
		}
		}
		if(intakeData.isNull("healthhistoryoverallhealthsurgerie191323")) {
			intakeExport.setHealthhistoryoverallhealthsurgerie(null);
		}else {
		if(!intakeData.opt("healthhistoryoverallhealthsurgerie191323").equals(null)){
			intakeExport.setHealthhistoryoverallhealthsurgerie(intakeData.getString("healthhistoryoverallhealthsurgerie191323"));
		}
		}
		if(intakeData.isNull("additionalthoughtsconcernsraisedab191323")) {
			intakeExport.setAdditionalthoughtsconcernsraisedab(null);
		}else {
		if(!intakeData.opt("additionalthoughtsconcernsraisedab191323").equals(null)){
			intakeExport.setAdditionalthoughtsconcernsraisedab(intakeData.getString("additionalthoughtsconcernsraisedab191323"));
		}
		}
		if(intakeData.isNull("additionalinfo191323")) {
			intakeExport.setAdditionalinfo(null);
		}else {
		if(!intakeData.opt("additionalinfo191323").equals(null)){
			intakeExport.setAdditionalinfo(intakeData.getString("additionalinfo191323"));
		}
		}
		if(intakeData.isNull("locationofaccident191323")) {
			intakeExport.setLocationofaccident(null);
		}else {
		if(!intakeData.opt("locationofaccident191323").equals(null)){
			intakeExport.setLocationofaccident(intakeData.getString("locationofaccident191323"));
		}
		}
		if(intakeData.isNull("referralsource191323")) {
			intakeExport.setReferralsource(null);
		}else {
		if(!intakeData.opt("referralsource191323").equals(null)){
			intakeExport.setReferralsource(intakeData.getString("referralsource191323"));
		}
		}
		if(intakeData.isNull("resolution191323")) {
			intakeExport.setResolution(null);
		}else {
		if(!intakeData.opt("resolution191323").equals(null)){
			intakeExport.setResolution(intakeData.getString("resolution191323"));
		}}
		if(intakeData.isNull("qualificationstatus191323")) {
			intakeExport.setQualificationstatus(null);
		}else {
		if(!intakeData.opt("qualificationstatus191323").equals(null)){
			intakeExport.setQualificationstatus(intakeData.getString("qualificationstatus191323"));
		}}
		if(intakeData.isNull("citationcodesection191323")) {
			intakeExport.setCitationcodesection(null);
		}else {
		if(!intakeData.opt("citationcodesection191323").equals(null)){
			intakeExport.setCitationcodesection(intakeData.getString("citationcodesection191323"));
		}}
		if(intakeData.isNull("citationnumber191323")) {
			intakeExport.setCitationnumber(null);
		}else {
		if(!intakeData.opt("citationnumber191323").equals(null)){
			intakeExport.setCitationnumber(intakeData.getString("citationnumber191323"));
		}}
		if(intakeData.isNull("employer191323")) {
			intakeExport.setEmployerId(null);
		}else {
		if(!intakeData.opt("employer191323").equals(null)){
			JSONObject objEmployer=intakeData.getJSONObject("employer191323");
			if(!objEmployer.opt("id").equals(null)){
				intakeExport.setEmployerId(objEmployer.getString("id"));
			}
		}}
		if(intakeData.isNull("ambulancecompany191323")) {
			intakeExport.setAmbulanceId(null);
		}else {
		if(!intakeData.opt("ambulancecompany191323").equals(null)){
			JSONObject objAmbulance=intakeData.getJSONObject("ambulancecompany191323");
			if(!objAmbulance.opt("id").equals(null)){
				intakeExport.setAmbulanceId(objAmbulance.getString("id"));
			}
		}}
		if(intakeData.isNull("personperformingintake191323")) {
			intakeExport.setPersonperformingintakeId(null);
		}else {
		if(!intakeData.opt("personperformingintake191323").equals(null)){
			JSONObject objPersonPerformingIntake=intakeData.getJSONObject("personperformingintake191323");
			if(!objPersonPerformingIntake.opt("id").equals(null)){
				intakeExport.setPersonperformingintakeId(objPersonPerformingIntake.getString("id"));
			}
		}}
		if(intakeData.isNull("spousepartnerifapplicable191323")) {
			intakeExport.setSpousepartnerifapplicableId(null);
		}else {
		if(!intakeData.opt("spousepartnerifapplicable191323").equals(null)){
			JSONObject objSpousePartner=intakeData.getJSONObject("spousepartnerifapplicable191323");
			if(!objSpousePartner.opt("id").equals(null)){
				intakeExport.setSpousepartnerifapplicableId(objSpousePartner.getString("id"));
			}
		}}
		if(intakeData.isNull("maincontactcaretakerguardianorclie191323")) {
			intakeExport.setMaincontactcaretakerguardianorclie(null);
		}else {
		if(!intakeData.opt("maincontactcaretakerguardianorclie191323").equals(null)){
			JSONObject objMainContactCareTaker=intakeData.getJSONObject("maincontactcaretakerguardianorclie191323");
			if(!objMainContactCareTaker.opt("id").equals(null)){
				intakeExport.setMaincontactcaretakerguardianorclie(objMainContactCareTaker.getString("id"));
			}
		}}
		if(intakeData.isNull("driver191323")) {
			intakeExport.setDriverId(null);
		}else {
		if(!intakeData.opt("driver191323").equals(null)){
			JSONObject objDriver=intakeData.getJSONObject("driver191323");
			if(!objDriver.opt("id").equals(null)){
				intakeExport.setDriverId(objDriver.getString("id"));
			}
		}}
		if(intakeData.isNull("vehicleowner191323")) {
			intakeExport.setVehicleownerId(null);
		}else {
		if(!intakeData.opt("vehicleowner191323").equals(null)){
			JSONObject objvehicleowner=intakeData.getJSONObject("vehicleowner191323");
			if(!objvehicleowner.opt("id").equals(null)){
				intakeExport.setVehicleownerId(objvehicleowner.getString("id"));
			}
		}}
		if(intakeData.isNull("chiropracticfacility191323")) {
			intakeExport.setChiropracticfacilityId(null);
		}else {
		if(!intakeData.opt("chiropracticfacility191323").equals(null)){
			JSONObject objchiropracticfacility=intakeData.getJSONObject("chiropracticfacility191323");
			if(!objchiropracticfacility.opt("id").equals(null)){
				intakeExport.setChiropracticfacilityId(objchiropracticfacility.getString("id"));
			}
		}}
		if(intakeData.isNull("children191323")) {
			intakeExport.setChildren(null);
		}else {
		if(!intakeData.opt("children191323").equals(null)){
			JSONArray arrayChildren=intakeData.getJSONArray("children191323");
			 for(int j=0; j<=arrayChildren.length()-1; j++) {
				JSONObject jsonObject=arrayChildren.getJSONObject(j);
			if(!jsonObject.opt("id").equals(null)){
				intakeExport.setChildren(jsonObject.getString("id"));
			}
		}}}
		if(intakeData.isNull("referredfrom191323")) {
			intakeExport.setReferredfromId(null);
		}else {
		if(!intakeData.opt("referredfrom191323").equals(null)){
			JSONObject objReferredFrom=intakeData.getJSONObject("referredfrom191323");
			if(!objReferredFrom.opt("id").equals(null)){
				intakeExport.setReferredfromId(objReferredFrom.getString("id"));
			}
		}}
		if(intakeData.isNull("passenger191323")) {
			intakeExport.setPassengerId(null);
		}else {
		if(!intakeData.opt("passenger191323").equals(null)){
			JSONObject objpassenger=intakeData.getJSONObject("passenger191323");
			if(!objpassenger.opt("id").equals(null)){
				intakeExport.setPassengerId(objpassenger.getString("id"));
			}
		}}
		if(intakeData.isNull("datetaken191323")) {
			intakeExport.setDatetaken(null);
		}else {
		if(!intakeData.opt("datetaken191323").equals(null)){
			intakeExport.setDatetaken(intakeData.getString("datetaken191323"));
		}}
		if(intakeData.isNull("dateofintake191323")) {
			intakeExport.setDateofintake(null);
		}else {
		if(!intakeData.opt("dateofintake191323").equals(null)){
			intakeExport.setDateofintake(intakeData.getString("dateofintake191323"));
		}}
		if(intakeData.isNull("datecontractsigned191323")) {
			intakeExport.setDatecontractsigned(null);
		}else {
		if(!intakeData.opt("datecontractsigned191323").equals(null)){
			intakeExport.setDatecontractsigned(intakeData.getString("datecontractsigned191323"));
		}}
		if(intakeData.isNull("statuteoflimitations191323")) {
			intakeExport.setStatuteoflimitations(null);
		}else {
		if(!intakeData.opt("statuteoflimitations191323").equals(null)){
			intakeExport.setStatuteoflimitations(intakeData.getString("statuteoflimitations191323"));
		}}
		if(intakeData.isNull("incidentdate191323")) {
			intakeExport.setIncidentdate(null);
		}else {
		if(!intakeData.opt("incidentdate191323").equals(null)){
			intakeExport.setIncidentdate(intakeData.getString("incidentdate191323"));
		}}
		if(intakeData.isNull("towedto191323")) {
			intakeExport.setTowedTo(null);
		}else {
		if(!intakeData.opt("towedto191323").equals(null)){
			intakeExport.setTowedTo(intakeData.getString("towedto191323"));
		}}
		if(intakeData.isNull("policereportnarative191323")) {
			intakeExport.setPolicereportnarative(null);
		}else {
		if(!intakeData.opt("policereportnarative191323").equals(null)){
			intakeExport.setPolicereportnarative(intakeData.getString("policereportnarative191323"));
		}}
		if(intakeData.isNull("towedby191323")) {
			intakeExport.setTowedById(null);
		}else {
		if(!intakeData.opt("towedby191323").equals(null)){
			JSONObject towedby=intakeData.getJSONObject("towedby191323");
			if(!towedby.opt("id").equals(null)){
				intakeExport.setTowedById(towedby.getString("id"));
			}
		}}
		if(intakeData.isNull("_itemHeader")) {
			intakeExport.setCreatedDate(null);
		}else {
			if(!intakeData.isNull("_itemHeader")) {
		JSONObject itemHeader = intakeData.getJSONObject("_itemHeader");
		if(!itemHeader.opt("createdDate").equals(null)){
			intakeExport.setCreatedDate(itemHeader.getString("createdDate"));
		}}
		}

		intakeExportDao.insertIntakeData(intakeExport,databaseName);
		}
		
	}

	public String getIntakeDetailsResponse(String cookie, String projectID) {
		MDC.put("path", "File Vine:: Intake Export");
        String response=null;
		
//        String url="https://app.filevine.com/api/projects/"+projectID+"/custom/intake16433?page=1";
     //   String url="https://app.filevine.com/api/projects/"+projectID+"/custom/intake16485?page=1";
		
        String url="https://app.filevine.com/api/projects/"+projectID+"/custom/intake16433?page=1";
     //   String url="https://app.filevine.com/api/projects/"+projectID+"/custom/intakeaccidentinfo16407?page=1";
		String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
        
       // String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\","
	//			+ "\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
		try {
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
				System.out.println("response :: "+response);	
			eventLogger.info("Response has been exported!!");
		    }
			
		catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Fail to get repsonse from UI");
//			e.printStackTrace();
		}
		return response;
	}

	public void getIntakeDetailData(String response, String databaseName) throws JSONException, SQLException {
		IntakeExportDao intakeExportDao=new IntakeExportDao();
		IntakeDetailExport intakeExport = new IntakeDetailExport();
		
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		JSONObject jsonObj=new JSONObject(res);
		if(!jsonObj.opt("projectID").equals(null)){
			intakeExport.setProjectId(jsonObj.getString("projectID"));
		}
		JSONObject data=jsonObj.getJSONObject("data");
		if(data.isNull("customObject")) {
			System.out.println("No data found");
		}else {
		JSONObject intakeData=data.getJSONObject("customObject");
		if(intakeData.isNull("married192619")) {
			intakeExport.setMarried(null);
		}else {
		if(!intakeData.opt("married192619").equals(null)){
			intakeExport.setMarried(intakeData.getString("married192619"));
		}}
		if(intakeData.isNull("children192619")) {
			intakeExport.setChildren(null);
		}else {
		if(!intakeData.opt("children192619").equals(null)){
			intakeExport.setChildren(intakeData.getString("children192619"));
		}}
		if(intakeData.isNull("childsupportarrearages192619")) {
			intakeExport.setChildsupportarrearages(null);
		}else {
		if(!intakeData.opt("childsupportarrearages192619").equals(null)){
			intakeExport.setChildsupportarrearages(intakeData.getString("childsupportarrearages192619"));
		}}
		if(intakeData.isNull("reportedtoemployer192619")) {
			intakeExport.setReportedtoemployer(null);
		}else {
		if(!intakeData.opt("reportedtoemployer192619").equals(null)){
			intakeExport.setReportedtoemployer(intakeData.getString("reportedtoemployer192619"));
		}}
		if(intakeData.isNull("treatingwithdoctor192619")) {
			intakeExport.setTreatingwithdoctor(null);
		}else {
		if(!intakeData.opt("treatingwithdoctor192619").equals(null)){
			intakeExport.setTreatingwithdoctor(intakeData.getString("treatingwithdoctor192619"));
		}}
		if(intakeData.isNull("fringebenefits192619")) {
			intakeExport.setFringebenefits(null);
		}else {
		if(!intakeData.opt("fringebenefits192619").equals(null)){
			intakeExport.setFringebenefits(intakeData.getString("fringebenefits192619"));
		}}
		if(intakeData.isNull("areyoureceivingchecks192619")) {
			intakeExport.setAreyoureceivingchecks(null);
		}else {
		if(!intakeData.opt("areyoureceivingchecks192619").equals(null)){
			intakeExport.setAreyoureceivingchecks(intakeData.getString("areyoureceivingchecks192619"));
		}}
		if(intakeData.isNull("haveyoureturnedtowork192619")) {
			intakeExport.setHaveyoureturnedtowork(null);
		}else {
		if(!intakeData.opt("haveyoureturnedtowork192619").equals(null)){
			intakeExport.setHaveyoureturnedtowork(intakeData.getString("haveyoureturnedtowork192619"));
		}}
		if(intakeData.isNull("areyouworkingnow192619")) {
			intakeExport.setAreyouworkingnow(null);
		}else {
		if(!intakeData.opt("areyouworkingnow192619").equals(null)){
			intakeExport.setAreyouworkingnow(intakeData.getString("areyouworkingnow192619"));
		}}
		if(intakeData.isNull("haveyoubeenterminated192619")) {
			intakeExport.setHaveyoubeenterminated(null);
		}else {
		if(!intakeData.opt("haveyoubeenterminated192619").equals(null)){
			intakeExport.setHaveyoubeenterminated(intakeData.getString("haveyoubeenterminated192619"));
		}}
		if(intakeData.isNull("weretherewitnessestoaccident192619")) {
			intakeExport.setWeretherewitnessestoaccident(null);
		}else {
		if(!intakeData.opt("weretherewitnessestoaccident192619").equals(null)){
			intakeExport.setWeretherewitnessestoaccident(intakeData.getString("weretherewitnessestoaccident192619"));
		}}
		if(intakeData.isNull("didyouhaveanythingtodrinkonthedayo192619")) {
			intakeExport.setDidyouhaveanythingtodrinkonthedayo(null);
		}else {
		if(!intakeData.opt("didyouhaveanythingtodrinkonthedayo192619").equals(null)){
			intakeExport.setDidyouhaveanythingtodrinkonthedayo(intakeData.getString("didyouhaveanythingtodrinkonthedayo192619"));
		}}
		if(intakeData.isNull("wereanymedsordrugslegalorillegalta192619")) {
			intakeExport.setWereanymedsordrugslegalorillegalta(null);
		}else {
		if(!intakeData.opt("wereanymedsordrugslegalorillegalta192619").equals(null)){
			intakeExport.setWereanymedsordrugslegalorillegalta(intakeData.getString("wereanymedsordrugslegalorillegalta192619"));
		}}
		if(intakeData.isNull("takentoahospital192619")) {
			intakeExport.setTakentoahospital(null);
		}else {
		if(!intakeData.opt("takentoahospital192619").equals(null)){
			intakeExport.setTakentoahospital(intakeData.getString("takentoahospital192619"));
		}}
		if(intakeData.isNull("takenbyambulance192619")) {
			intakeExport.setTakenbyambulance(null);
		}else {
		if(!intakeData.opt("takenbyambulance192619").equals(null)){
			intakeExport.setTakenbyambulance(intakeData.getString("takenbyambulance192619"));
		}}
		if(intakeData.isNull("referredforanyothertreatmentordoct192619")) {
			intakeExport.setTakentoahospital(null);
		}else {
		if(!intakeData.opt("referredforanyothertreatmentordoct192619").equals(null)){
			intakeExport.setReferredforanyothertreatmentordoct(intakeData.getString("referredforanyothertreatmentordoct192619"));
		}}
		if(intakeData.isNull("areyoucurrentlyourofworkbyatreatin192619")) {
			intakeExport.setAreyoucurrentlyourofworkbyatreatin(null);
		}else {
		if(!intakeData.opt("areyoucurrentlyourofworkbyatreatin192619").equals(null)){
			intakeExport.setAreyoucurrentlyourofworkbyatreatin(intakeData.getString("areyoucurrentlyourofworkbyatreatin192619"));
		}}
		if(intakeData.isNull("areyoureceivingchecksfromworkersco192619")) {
			intakeExport.setAreyoureceivingchecksfromworkersco(null);
		}else {
		if(!intakeData.opt("areyoureceivingchecksfromworkersco192619").equals(null)){
			intakeExport.setAreyoureceivingchecksfromworkersco(intakeData.getString("areyoureceivingchecksfromworkersco192619"));
		}}
		if(intakeData.isNull("referralsource192619")) {
			intakeExport.setReferralsource(null);
		}else {
		if(!intakeData.opt("referralsource192619").equals(null)){
			intakeExport.setReferralsource(intakeData.getString("referralsource192619"));
		}}
		if(intakeData.isNull("locationofaccidentcitystate192619")) {
			intakeExport.setLocationofaccidentcitystate(null);
		}else {
		if(!intakeData.opt("locationofaccidentcitystate192619").equals(null)){
			intakeExport.setLocationofaccidentcitystate(intakeData.getString("locationofaccidentcitystate192619"));
		}}
		if(intakeData.isNull("resolution192619")) {
			intakeExport.setResolution(null);
		}else {
		if(!intakeData.opt("resolution192619").equals(null)){
			intakeExport.setResolution(intakeData.getString("resolution192619"));
		}}
		if(intakeData.isNull("educationlevel192619")) {
			intakeExport.setEducationlevel(null);
		}else {
		if(!intakeData.opt("educationlevel192619").equals(null)){
			intakeExport.setEducationlevel(intakeData.getString("educationlevel192619"));
		}}
		if(intakeData.isNull("positionheld192619")) {
			intakeExport.setResolution(null);
		}else {
		if(!intakeData.opt("positionheld192619").equals(null)){
			intakeExport.setPositionheld(intakeData.getString("positionheld192619"));
		}}
		if(intakeData.isNull("towhomreported192619")) {
			intakeExport.setTowhomreported(null);
		}else {
		if(!intakeData.opt("towhomreported192619").equals(null)){
			intakeExport.setTowhomreported(intakeData.getString("towhomreported192619"));
		}}
		if(intakeData.isNull("whoareyoutreatingwith192619")) {
			intakeExport.setWhoareyoutreatingwith(null);
		}else {
		if(!intakeData.opt("whoareyoutreatingwith192619").equals(null)){
			intakeExport.setWhoareyoutreatingwith(intakeData.getString("whoareyoutreatingwith192619"));
		}}
		if(intakeData.isNull("per192619")) {
			intakeExport.setPer(null);
		}else {
		if(!intakeData.opt("per192619").equals(null)){
			intakeExport.setPer(intakeData.getString("per192619"));
		}}
		if(intakeData.isNull("hoursperweek192619")) {
			intakeExport.setHoursperweek(null);
		}else {
		if(!intakeData.opt("hoursperweek192619").equals(null)){
			intakeExport.setHoursperweek(intakeData.getString("hoursperweek192619"));
		}}
		if(intakeData.isNull("dateslostfromworkbecauseofinjury192619")) {
			intakeExport.setDateslostfromworkbecauseofinjury(null);
		}else {
		if(!intakeData.opt("dateslostfromworkbecauseofinjury192619").equals(null)){
			intakeExport.setDateslostfromworkbecauseofinjury(intakeData.getString("dateslostfromworkbecauseofinjury192619"));
		}}
		if(intakeData.isNull("timeofday192619")) {
			intakeExport.setTimeofday(null);
		}else {
		if(!intakeData.opt("timeofday192619").equals(null)){
			intakeExport.setTimeofday(intakeData.getString("timeofday192619"));
		}}
		if(intakeData.isNull("dayofweek192619")) {
			intakeExport.setDayofweek(null);
		}else {
		if(!intakeData.opt("dayofweek192619").equals(null)){
			intakeExport.setDayofweek(intakeData.getString("dayofweek192619"));
		}}
		if(intakeData.isNull("witnesses192619")) {
			intakeExport.setWitnesses(null);
		}else {
		if(!intakeData.opt("witnesses192619").equals(null)){
			intakeExport.setWitnesses(intakeData.getString("witnesses192619"));
		}}
		if(intakeData.isNull("describehowtheaccidenthappened192619")) {
			intakeExport.setDescribehowtheaccidenthappened(null);
		}else {
		if(!intakeData.opt("describehowtheaccidenthappened192619").equals(null)){
			intakeExport.setDescribehowtheaccidenthappened(intakeData.getString("describehowtheaccidenthappened192619"));
		}}
		if(intakeData.isNull("injuries192619")) {
			intakeExport.setInjuries(null);
		}else {
		if(!intakeData.opt("injuries192619").equals(null)){
			intakeExport.setInjuries(intakeData.getString("injuries192619"));
		}}
		if(intakeData.isNull("priorcomplaintsofinjuredbodyparts192619")) {
			intakeExport.setPriorcomplaintsofinjuredbodyparts(null);
		}else {
		if(!intakeData.opt("priorcomplaintsofinjuredbodyparts192619").equals(null)){
			intakeExport.setPriorcomplaintsofinjuredbodyparts(intakeData.getString("priorcomplaintsofinjuredbodyparts192619"));
		}}
		if(intakeData.isNull("priororcurrentmedicalconditions192619")) {
			intakeExport.setPriororcurrentmedicalconditions(null);
		}else {
		if(!intakeData.opt("priororcurrentmedicalconditions192619").equals(null)){
			intakeExport.setPriororcurrentmedicalconditions(intakeData.getString("priororcurrentmedicalconditions192619"));
		}}
		if(intakeData.isNull("priorworkerscompensationclaims192619")) {
			intakeExport.setPriorworkerscompensationclaims(null);
		}else {
		if(!intakeData.opt("priorworkerscompensationclaims192619").equals(null)){
			intakeExport.setPriorworkerscompensationclaims(intakeData.getString("priorworkerscompensationclaims192619"));
		}}
		if(intakeData.isNull("priorlawyersforaccidents192619")) {
			intakeExport.setPriorlawyersforaccidents(null);
		}else {
		if(!intakeData.opt("priorlawyersforaccidents192619").equals(null)){
			intakeExport.setPriorlawyersforaccidents(intakeData.getString("priorlawyersforaccidents192619"));
		}}
		if(intakeData.isNull("criminalbackground192619")) {
			intakeExport.setCriminalbackground1(null);
		}else {
		if(!intakeData.opt("criminalbackground192619").equals(null)){
			intakeExport.setCriminalbackground1(intakeData.getString("criminalbackground192619"));
		}}
		if(intakeData.isNull("objectiveinfilingworkerscompensati192619")) {
			intakeExport.setObjectiveinfilingworkerscompensati(null);
		}else {
		if(!intakeData.opt("objectiveinfilingworkerscompensati192619").equals(null)){
			intakeExport.setObjectiveinfilingworkerscompensati(intakeData.getString("objectiveinfilingworkerscompensati192619"));
		}}
		if(intakeData.isNull("otheroutstandingmedicalissues192619")) {
			intakeExport.setOtheroutstandingindemnityissues(null);
		}else {
		if(!intakeData.opt("otheroutstandingmedicalissues192619").equals(null)){
			intakeExport.setOtheroutstandingindemnityissues(intakeData.getString("otheroutstandingmedicalissues192619"));
		}}
		if(intakeData.isNull("interviewer192619")) {
			intakeExport.setInterviewer(null);
		}else {
		if(!intakeData.opt("interviewer192619").equals(null)){
			intakeExport.setInterviewer(intakeData.getString("interviewer192619"));
		}}
		if(intakeData.isNull("madeappointment191740")) {
			intakeExport.setMadeappointment(null);
		}else {
		if(!intakeData.opt("madeappointment191740").equals(null)){
			intakeExport.setMadeappointment(intakeData.getString("madeappointment191740"));
		}}
		if(intakeData.isNull("feecancellationexplained191740")) {
			intakeExport.setFeecancellationexplained(null);
		}else {
		if(!intakeData.opt("feecancellationexplained191740").equals(null)){
			intakeExport.setFeecancellationexplained(intakeData.getString("feecancellationexplained191740"));
		}}
		if(intakeData.isNull("minorchildren191740")) {
			intakeExport.setMinorchildren(null);
		}else {
		if(!intakeData.opt("minorchildren191740").equals(null)){
			intakeExport.setMinorchildren(intakeData.getString("minorchildren191740"));
		}}
		if(intakeData.isNull("opposingpartyapplicable191740")) {
			intakeExport.setOpposingpartyapplicable(null);
		}else {
		if(!intakeData.opt("opposingpartyapplicable191740").equals(null)){
			intakeExport.setOpposingpartyapplicable(intakeData.getString("opposingpartyapplicable191740"));
		}}
		if(intakeData.isNull("bestwaytocontactyou191740")) {
			intakeExport.setBestwaytocontactyou(null);
		}else {
		if(!intakeData.opt("bestwaytocontactyou191740").equals(null)){
			intakeExport.setBestwaytocontactyou(intakeData.getString("bestwaytocontactyou191740"));
		}}
		if(intakeData.isNull("typeoffamilylaw191740")) {
			intakeExport.setTypeoffamilylaw(null);
		}else {
		if(!intakeData.opt("typeoffamilylaw191740").equals(null)){
			intakeExport.setTypeoffamilylaw(intakeData.getString("typeoffamilylaw191740"));
		}}
		if(intakeData.isNull("referralsource191740")) {
			intakeExport.setReferralsource(null);
		}else {
		if(!intakeData.opt("referralsource191740").equals(null)){
			intakeExport.setReferralsource(intakeData.getString("referralsource191740"));
		}}
		if(intakeData.isNull("timeofappointment191740")) {
			intakeExport.setTimeofappointment(null);
		}else {
		if(!intakeData.opt("timeofappointment191740").equals(null)){
			intakeExport.setTimeofappointment(intakeData.getString("timeofappointment191740"));
		}}
		if(intakeData.isNull("referralname191740")) {
			intakeExport.setReferralnameId(null);
		}else {
		if(!intakeData.opt("referralname191740").equals(null)){
			JSONObject obhReferal=intakeData.getJSONObject("referralname191740");
			if(!obhReferal.opt("id").equals(null)){
				intakeExport.setReferralnameId(obhReferal.getString("id"));
			}
		}}
		if(intakeData.isNull("opposingparty191740")) {
			intakeExport.setReferralnameId(null);
		}else {
		if(!intakeData.opt("opposingparty191740").equals(null)){
			JSONObject objOpposingParty=intakeData.getJSONObject("opposingparty191740");
			if(!objOpposingParty.opt("id").equals(null)){
				intakeExport.setReferralnameId(objOpposingParty.getString("id"));
			}
		}}
		if(intakeData.isNull("opposingpartyattorney191740")) {
			intakeExport.setOpposingpartyattorneyId(null);
		}else {
		if(!intakeData.opt("opposingpartyattorney191740").equals(null)){
			JSONObject objOpposingAtt=intakeData.getJSONObject("opposingpartyattorney191740");
			if(!objOpposingAtt.opt("id").equals(null)){
				intakeExport.setOpposingpartyattorneyId(objOpposingAtt.getString("id"));
			}
		}}
		if(intakeData.isNull("intaketakenby191740")) {
			intakeExport.setIntaketakenbyId(null);
		}else {
		if(!intakeData.opt("intaketakenby191740").equals(null)){
			JSONObject intaketakenby=intakeData.getJSONObject("intaketakenby191740");
			if(!intaketakenby.opt("id").equals(null)){
				intakeExport.setIntaketakenbyId(intaketakenby.getString("id"));
			}
		}}
		if(intakeData.isNull("child1191740")) {
			intakeExport.setChildId(null);
		}else {
		if(!intakeData.opt("child1191740").equals(null)){
			JSONObject child1=intakeData.getJSONObject("child1191740");
			if(!child1.opt("id").equals(null)){
				intakeExport.setChildId(child1.getString("id"));
			}
		}}
		if(intakeData.isNull("employersname192619")) {
			intakeExport.setEmployersnameId(null);
		}else {
		if(!intakeData.opt("employersname192619").equals(null)){
			JSONObject employersname=intakeData.getJSONObject("employersname192619");
			if(!employersname.opt("id").equals(null)){
				intakeExport.setEmployersnameId(employersname.getString("id"));
			}
		}}
		if(intakeData.isNull("directsupervisorsname192619")) {
			intakeExport.setDirectsupervisorsnameId(null);
		}else {
		if(!intakeData.opt("directsupervisorsname192619").equals(null)){
			JSONObject directsupervisorsname=intakeData.getJSONObject("directsupervisorsname192619");
			if(!directsupervisorsname.opt("id").equals(null)){
				intakeExport.setDirectsupervisorsnameId(directsupervisorsname.getString("id"));
			}
		}}
		if(intakeData.isNull("personperformingintake192619")) {
			intakeExport.setPersonperformingintakeId(null);
		}else {
		if(!intakeData.opt("personperformingintake192619").equals(null)){
			JSONObject personperformingintake=intakeData.getJSONObject("personperformingintake192619");
			if(!personperformingintake.opt("id").equals(null)){
				intakeExport.setPersonperformingintakeId(personperformingintake.getString("id"));
			}
		}}
		if(intakeData.isNull("rateofpay192619")) {
			intakeExport.setRateofpay(null);
		}else {
		if(!intakeData.opt("rateofpay192619").equals(null)){
			intakeExport.setRateofpay(intakeData.getString("rateofpay192619"));
		}}
		if(intakeData.isNull("amountraised192619")) {
			intakeExport.setAmountraised(null);
		}else {
		if(!intakeData.opt("amountraised192619").equals(null)){
			intakeExport.setAmountraised(intakeData.getString("amountraised192619"));
		}}
		if(intakeData.isNull("dateofintake191740")) {
			intakeExport.setDateofintake(null);
		}else {
		if(!intakeData.opt("dateofintake191740").equals(null)){
			intakeExport.setDateofintake(intakeData.getString("dateofintake191740"));
		}}
		if(intakeData.isNull("datecontactsigned192619")) {
			intakeExport.setDatecontactsigned(null);
		}else {
		if(!intakeData.opt("datecontactsigned192619").equals(null)){
			intakeExport.setDatecontactsigned(intakeData.getString("datecontactsigned192619"));
		}}
		if(intakeData.isNull("dateemploymentstarted192619")) {
			intakeExport.setDateemploymentstarted(null);
		}else {
		if(!intakeData.opt("dateemploymentstarted192619").equals(null)){
			intakeExport.setDateemploymentstarted(intakeData.getString("dateemploymentstarted192619"));
		}}
		if(intakeData.isNull("whenreported192619")) {
			intakeExport.setWhenreported(null);
		}else {
		if(!intakeData.opt("whenreported192619").equals(null)){
			intakeExport.setWhenreported(intakeData.getString("whenreported192619"));
		}}
		if(intakeData.isNull("lastpayraisedate192619")) {
			intakeExport.setLastpayraisedate(null);
		}else {
		if(!intakeData.opt("lastpayraisedate192619").equals(null)){
			intakeExport.setLastpayraisedate(intakeData.getString("lastpayraisedate192619"));
		}}
		if(intakeData.isNull("datereturned192619")) {
			intakeExport.setDatereturned(null);
		}else {
		if(!intakeData.opt("datereturned192619").equals(null)){
			intakeExport.setDatereturned(intakeData.getString("datereturned192619"));
		}}
		if(intakeData.isNull("dateoftermination192619")) {
			intakeExport.setDateoftermination(null);
		}else {
		if(!intakeData.opt("dateoftermination192619").equals(null)){
			intakeExport.setDateoftermination(intakeData.getString("dateoftermination192619"));
		}}
		if(intakeData.isNull("dateofinterview192619")) {
			intakeExport.setDateofinterview(null);
		}else {
		if(!intakeData.opt("dateofinterview192619").equals(null)){
			intakeExport.setDateofinterview(intakeData.getString("dateofinterview192619"));
		}}
		if(intakeData.isNull("dateofappt191740")) {
			intakeExport.setDateofappt(null);
		}else {
		if(!intakeData.opt("dateofappt191740").equals(null)){
			intakeExport.setDateofappt(intakeData.getString("dateofappt191740"));
		}}
		if(intakeData.isNull("_itemHeader")) {
			intakeExport.setCreatedDate(null);
		}else {
		if(!intakeData.opt("_itemHeader").equals(null)){
			JSONObject _itemHeader=intakeData.getJSONObject("_itemHeader");
			if(!_itemHeader.opt("createdDate").equals(null)){
				intakeExport.setCreatedDate(_itemHeader.getString("createdDate"));
			}
		}}
		intakeExportDao.insertIntakeDetailsData(intakeExport,databaseName);
		}
	}
  
}

package com.filevine.dataexport.service;

import java.sql.SQLException;


import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.filevine.dataexport.dao.CaseSummaryExportDataDao;
import com.filevine.dataexport.dao.IntakeDataExportDao;
import com.filevine.dataexport.domain.CaseSummaryExportData;
import com.filevine.dataexport.domain.IntakeDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class IntakeDataExportService {

	
	public String getIntakeDataExportResponse(String cookie,String projectID) {
	
		String response=null;
	
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/intakeinfo1032?page=1";
	
	String payload="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	
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
public void getIntakeData(String response, String databaseName) throws JSONException, SQLException {
		
	     IntakeDataExport intakedataexport=new IntakeDataExport();
		IntakeDataExportDao intakedataexportdao=new IntakeDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject intakeData=new JSONObject(res);
		if(!intakeData.opt("projectID").equals(null)){
			intakedataexport.setProjectId(intakeData.getInt("projectID"));
		}
		JSONObject data=intakeData.getJSONObject("data");

		if(data.isNull("customObject")) {
			System.out.println("No data found");
		}else {
		JSONObject jsonData=data.getJSONObject("customObject");
		
		if(jsonData.isNull("dateofintake14196")) {
			intakedataexport.setDateOfIntaket( null);
			}else {
				
		    if(!jsonData.opt("dateofintake14196").equals(null)){
		    	intakedataexport.setDateOfIntaket( jsonData.getString("dateofintake14196"));
		 }} 
		
		if(jsonData.isNull("personperformingintake14196")){
			intakedataexport.setPersonPerformingIntake(null);
		}else {
			JSONObject communication25=jsonData.getJSONObject("personperformingintake14196");
			if(!communication25.opt("fullname").equals(null)){
				intakedataexport.setPersonPerformingIntake(communication25.getString("fullname"));
			}}
		
		if(jsonData.isNull("employeeperformingintake14196")){
			intakedataexport.setEmployeePerformingIntake(null);
		}else {
			JSONObject communication26=jsonData.getJSONObject("employeeperformingintake14196");
			if(!communication26.opt("id").equals(null)){
				intakedataexport.setEmployeePerformingIntake(communication26.getString("id"));
			}}
		
		if(jsonData.isNull("referralsource14196")) {
			intakedataexport.setReferralSource( null);
			}else {
				
		    if(!jsonData.opt("referralsource14196").equals(null)){
		    	intakedataexport.setReferralSource( jsonData.getString("referralsource14196"));
		 }}
		
		
		if(jsonData.isNull("referredfrom14196")){
			intakedataexport.setReferredFrom(null);
		}else {
			JSONObject communication21=jsonData.getJSONObject("referredfrom14196");
			if(!communication21.opt("fullname").equals(null)){
				intakedataexport.setReferredFrom(communication21.getString("fullname"));
			}}
		
		if(jsonData.isNull("referralsourcefee14196")) {
			intakedataexport.setReferralSourceFee( null);
			}else {
				
		    if(!jsonData.opt("referralsourcefee14196").equals(null)){
		    	intakedataexport.setReferralSourceFee( jsonData.getString("referralsourcefee14196"));
		 }} 
		

		if(jsonData.isNull("leadstatus14196")) {
			intakedataexport.setLeadStatus( null);
			}else {
				
		    if(!jsonData.opt("leadstatus14196").equals(null)){
		    	intakedataexport.setLeadStatus( jsonData.getString("leadstatus14196"));
		 }}
		
		if(jsonData.isNull("qualified14196")) {
			intakedataexport.setQualiFied(null);
			}else {
				
		    if(!jsonData.opt("qualified14196").equals(null)){
		    	intakedataexport.setQualiFied( jsonData.getString("qualified14196"));
		 }}
		
		
		if(jsonData.isNull("datecontractsent14196")) {
			intakedataexport.setDateContractSent( null);
			}else {
				
		    if(!jsonData.opt("datecontractsent14196").equals(null)){
		    	intakedataexport.setDateContractSent( jsonData.getString("datecontractsent14196"));
		 }}
		
		
		if(jsonData.isNull("datecontractsigned14196")) {
			intakedataexport.setDateContractSigned( null);
			}else {
				
		    if(!jsonData.opt("datecontractsigned14196").equals(null)){
		    	intakedataexport.setDateContractSigned( jsonData.getString("datecontractsigned14196"));
		 }}
		if(jsonData.isNull("incidentdate14196")) {
			intakedataexport.setIncidentDate( null);
			}else {
				
		    if(!jsonData.opt("incidentdate14196").equals(null)){
		    	intakedataexport.setIncidentDate( jsonData.getString("incidentdate14196"));
		 }}
		if(jsonData.isNull("statuteoflimitations14196")) {
			intakedataexport.setStatuteOfLimitations( null);
			}else {
				
		    if(!jsonData.opt("statuteoflimitations14196").equals(null)){
		    	intakedataexport.setStatuteOfLimitations( jsonData.getString("statuteoflimitations14196"));
		 }}
		
		if(jsonData.isNull("incidenttype14196")) {
			intakedataexport.setIncidentType( null);
			}else {
				
		    if(!jsonData.opt("incidenttype14196").equals(null)){
		    	intakedataexport.setIncidentType( jsonData.getString("incidenttype14196"));
		 }}
		
		if(jsonData.isNull("typeofmva14196")) {
			intakedataexport.setTypeOfMva( null);
			}else {
				
		    if(!jsonData.opt("typeofmva14196").equals(null)){
		    	intakedataexport.setTypeOfMva( jsonData.getString("typeofmva14196"));
		 }}
		if(jsonData.isNull("statewhereaccidentoccurred14196")) {
			intakedataexport.setStateWhereAccidentOccurred( null);
			}else {
				
		    if(!jsonData.opt("statewhereaccidentoccurred14196").equals(null)){
		    	intakedataexport.setStateWhereAccidentOccurred( jsonData.getString("statewhereaccidentoccurred14196"));
		 }}
		
		
		if(jsonData.isNull("citywhereaccidentoccurred14196")) {
			intakedataexport.setCityWhereAccidentOccurred( null);
			}else {
				
		    if(!jsonData.opt("citywhereaccidentoccurred14196").equals(null)){
		    	intakedataexport.setCityWhereAccidentOccurred( jsonData.getString("citywhereaccidentoccurred14196"));
		 }}
		
		if(jsonData.isNull("county14196")) {
		intakedataexport.setCounty( null);
		}else {
			
	    if(!jsonData.opt("county14196").equals(null)){
	    	intakedataexport.setCounty( jsonData.getString("county14196"));
	 }}
		
		if(jsonData.isNull("whatwereyou14196")) {
			intakedataexport.setWhatWereYou( null);
			}else {
				
		    if(!jsonData.opt("whatwereyou14196").equals(null)){
		    	intakedataexport.setWhatWereYou( jsonData.getString("whatwereyou14196"));
		 }}
		if(jsonData.isNull("descriptionofaccident14196")) {
			intakedataexport.setDescriptionOfAccident( null);
			}else {
				
		    if(!jsonData.opt("descriptionofaccident14196").equals(null)){
		    	intakedataexport.setDescriptionOfAccident( jsonData.getString("descriptionofaccident14196"));
		 }}
		
		if(jsonData.isNull("timeofaccident14196")) {
		intakedataexport.setTimeofAccident( null);
		}else {
			
	    if(!jsonData.opt("timeofaccident14196").equals(null)){
	    	intakedataexport.setTimeofAccident( jsonData.getString("timeofaccident14196"));
	 }}
		
		if(jsonData.isNull("locationofaccident14196")) {
			intakedataexport.setLocationOfAccident( null);
			}else {
				
		    if(!jsonData.opt("locationofaccident14196").equals(null)){
		    	intakedataexport.setLocationOfAccident( jsonData.getString("locationofaccident14196"));
		 }}
		
		if(jsonData.isNull("weatherandroadconditions14196")) {
		intakedataexport.setWeatherAndRoadConditions( null);
		}else {
			
	    if(!jsonData.opt("weatherandroadconditions14196").equals(null)){
	    	intakedataexport.setWeatherAndRoadConditions( jsonData.getString("weatherandroadconditions14196"));
	 }}
		
		if(jsonData.isNull("authoritiescalledtothescene14196")) {
		intakedataexport.setAuthoritiesCalledToTheScene(null);
		}else {
			
	    if(!jsonData.opt("authoritiescalledtothescene14196").equals(null)){
	    	intakedataexport.setAuthoritiesCalledToTheScene( jsonData.getString("authoritiescalledtothescene14196"));
	 }}	
		
		if(jsonData.isNull("policeofficerdepartment14196")){
			intakedataexport.setPoliceOfficerDepartmentr(null);
		}else {
			JSONObject communication25=jsonData.getJSONObject("policeofficerdepartment14196");
			if(!communication25.opt("id").equals(null)){
				intakedataexport.setPoliceOfficerDepartmentr(communication25.getString("id"));
			}}
		
		if(jsonData.isNull("policeofficerdepartment214196")){
			intakedataexport.setPoliceOfficerDepartmentr2(null);
		}else {
			JSONObject communication26=jsonData.getJSONObject("policeofficerdepartment214196");
			if(!communication26.opt("id").equals(null)){
				intakedataexport.setPoliceOfficerDepartmentr2(communication26.getString("id"));
			}}
		
		if(jsonData.isNull("f2_policereport14196")) {
			intakedataexport.setPolicerReportNo( null);
			}else {
				
		    if(!jsonData.opt("f2_policereport14196").equals(null)){
		    	intakedataexport.setPolicerReportNo( jsonData.getString("f2_policereport14196"));
		 }}
		
		if(jsonData.isNull("officertrooper14196")) {
			intakedataexport.setOfficerTrooper( null);
			}else {
				
		    if(!jsonData.opt("officertrooper14196").equals(null)){
		    	intakedataexport.setOfficerTrooper( jsonData.getString("officertrooper14196"));
		 }}
		
		if(jsonData.isNull("policereport14196")) {
			intakedataexport.setPoliceReport(null);
			}else {
				
		    if(!jsonData.opt("policereport14196").equals(null)){
		    	intakedataexport.setPoliceReport( jsonData.getString("policereport14196"));
		 }}
		   
		if(jsonData.isNull("citationsissued14196")) {
			intakedataexport.setCitationsIssued(null);
			}else {
				
		    if(!jsonData.opt("citationsissued14196").equals(null)){
		    	intakedataexport.setCitationsIssued( jsonData.getString("citationsissued14196"));
		 }}
		
		if(jsonData.isNull("citationtypenumber14196")) {
			intakedataexport.setCitationTypeNumber(null);
			}else {
				
		    if(!jsonData.opt("citationtypenumber14196").equals(null)){
		    	intakedataexport.setCitationTypeNumber( jsonData.getString("citationtypenumber14196"));
		 }}
//		if(jsonData.isNull("citationfinaldisposition14196")){
//			intakedataexport.setCitationFinalDisposition(null);
//		}else {
//			JSONObject communication4=jsonData.getJSONObject("citationfinaldisposition14196");
//			if(!communication4.opt("filename").equals(null)){
//				intakedataexport.setCitationFinalDisposition(communication4.getString("filename"));
//			}}
		
		
		if(jsonData.isNull("citationfinaldisposition14196")){
			intakedataexport.setCitationFinalDisposition(null);
		}else {
			JSONArray communication01=jsonData.getJSONArray("citationfinaldisposition14196");
			for(int k=0; k<=communication01.length()-1; k++) {
			JSONObject jsonobject=communication01.getJSONObject(k);
		if(!jsonobject.opt("filename").equals(null)){
			intakedataexport.setCitationFinalDisposition(jsonobject.getString("filename"));
		}}}
		
		if(jsonData.isNull("witnesses14196")) {
			intakedataexport.setWitnesses(null);
			}else {
				
		    if(!jsonData.opt("witnesses14196").equals(null)){
		    	intakedataexport.setWitnesses( jsonData.getString("witnesses14196"));
		 }}
		
		if(jsonData.isNull("witnessdetails14196")) {
			intakedataexport.setWitnessesDetails(null);
			}else {
				
		    if(!jsonData.opt("witnesses14196").equals(null)){
		    	intakedataexport.setWitnessesDetails( jsonData.getString("witnessdetails14196"));
		 }}
		
		
		if(jsonData.isNull("witness14196")){
			intakedataexport.setWitness(null);
		}else {
			JSONObject communication78=jsonData.getJSONObject("witness14196");
			if(!communication78.opt("id").equals(null)){
				intakedataexport.setWitness(communication78.getString("id"));
			}}
		
		
		
		if(jsonData.isNull("incidentinfo14196")) {
			intakedataexport.setIncidentInfo( null);
			}else {
				
		    if(!jsonData.opt("incidentinfo14196").equals(null)){
		    	intakedataexport.setIncidentInfo( jsonData.getString("incidentinfo14196"));
		 }}
		
		if(jsonData.isNull("didclientgotothehospital14196")) {
			intakedataexport.setDidClientGoToTheHospital(null);
			}else {
					
			 if(!jsonData.opt("didclientgotothehospital14196").equals(null)){
			intakedataexport.setDidClientGoToTheHospital( jsonData.getString("didclientgotothehospital14196"));
	 }}
		
		if(jsonData.isNull("hospital14196")){
			intakedataexport.setHospital(null);
		}else {
			JSONObject communication10=jsonData.getJSONObject("hospital14196");
			if(!communication10.opt("id").equals(null)){
				intakedataexport.setHospital(communication10.getString("id"));
			}}
		
		if(jsonData.isNull("testscompleted14196")) {
			intakedataexport.setTestsCompleted( null);
			}else {
				
		    if(!jsonData.opt("testscompleted14196").equals(null)){
		    	intakedataexport.setTestsCompleted(jsonData.getString("testscompleted14196"));
		 }}
		
		if(jsonData.isNull("clienttransportedinanambulance14196")) {
		intakedataexport.setClientTransportedInanAmbulance(null);
		}else {
				
		 if(!jsonData.opt("clienttransportedinanambulance14196").equals(null)){
		intakedataexport.setClientTransportedInanAmbulance( jsonData.getString("clienttransportedinanambulance14196"));
 }}
		
		if(jsonData.isNull("ambulance14196")){
			intakedataexport.setAmbulance(null);
		}else {
			JSONObject communication30=jsonData.getJSONObject("ambulance14196");
			if(!communication30.opt("id").equals(null)){
				intakedataexport.setAmbulance(communication30.getString("id"));
			}}
		
	
	if(jsonData.isNull("didincidentresultindeath14196")) {
		intakedataexport.setDidIncidentResultInDeath(null);
		}else {
			
	    if(!jsonData.opt("didincidentresultindeath14196").equals(null)){
	    	intakedataexport.setDidIncidentResultInDeath( jsonData.getString("didincidentresultindeath14196"));
	 }}
	
	if(jsonData.isNull("dateofdeath14196")) {
		intakedataexport.setDateOfDeath(null);
		}else {
			
	    if(!jsonData.opt("dateofdeath14196").equals(null)){
	    	intakedataexport.setDateOfDeath( jsonData.getString("dateofdeath14196"));
	 }}
		
	if(jsonData.isNull("hostvehicledriver14196")) {
		intakedataexport.setHostVehicleDriver(null);
		}else {
			
	    if(!jsonData.opt("hostvehicledriver14196").equals(null)){
	    	intakedataexport.setHostVehicleDriver( jsonData.getString("hostvehicledriver14196"));
	 }}
	
	if(jsonData.isNull("hostvehicleinsurance14196")) {
		intakedataexport.setHostVehicleOwner(null);
		}else {
			
	    if(!jsonData.opt("hostvehicleinsurance14196").equals(null)){
	    	intakedataexport.setHostVehicleOwner( jsonData.getString("hostvehicleinsurance14196"));
	 }}
	
	
	if(jsonData.isNull("insuranceinfo14196")) {
		intakedataexport.setHostInsuranceInfo(null);
		}else {
			
	    if(!jsonData.opt("insuranceinfo14196").equals(null)){
	    	intakedataexport.setHostInsuranceInfo( jsonData.getString("insuranceinfo14196"));
	 }}
	
	if(jsonData.isNull("passengers14196")) {
		intakedataexport.setPassengers(null);
		}else {
			
	    if(!jsonData.opt("passengers14196").equals(null)){
	    	intakedataexport.setPassengers( jsonData.getString("passengers14196"));
	 }}
	
	if(jsonData.isNull("passenger14196")) {
		intakedataexport.setPassenger(null);
		}else {
			
	    if(!jsonData.opt("passenger14196").equals(null)){
	    	intakedataexport.setPassenger( jsonData.getString("passenger14196"));
	 }}
	
	if(jsonData.isNull("defendantdriver14196")) {
		intakedataexport.setDefendantDriver(null);
		}else {
			
	    if(!jsonData.opt("defendantdriver14196").equals(null)){
	    	intakedataexport.setDefendantDriver( jsonData.getString("defendantdriver14196"));
	 }}
	
	if(jsonData.isNull("defendantowner14196")) {
		intakedataexport.setDefendantOwner(null);
		}else {
			
	    if(!jsonData.opt("defendantowner14196").equals(null)){
	    	intakedataexport.setDefendantOwner( jsonData.getString("defendantowner14196"));
	 }}
	
	if(jsonData.isNull("defendantdetails14196")) {
		intakedataexport.setDefendantInsurance(null);
		}else {
			
	    if(!jsonData.opt("defendantdetails14196").equals(null)){
	    	intakedataexport.setDefendantInsurance( jsonData.getString("defendantdetails14196"));
	 }}
	
	if(jsonData.isNull("clientvehicletype14196")) {
		intakedataexport.setClientVehicleType(null);
		}else {
			
	    if(!jsonData.opt("clientvehicletype14196").equals(null)){
	    	intakedataexport.setClientVehicleType( jsonData.getString("clientvehicletype14196"));
	 }}
	
	
	if(jsonData.isNull("clientsvehiclemakemodel14196")) {
		intakedataexport.setClientsVehicleYearMakeModelColor(null);
		}else {
			
	    if(!jsonData.opt("clientsvehiclemakemodel14196").equals(null)){
	    	intakedataexport.setClientsVehicleYearMakeModelColor( jsonData.getString("clientsvehiclemakemodel14196"));
	 }}
	
	if(jsonData.isNull("damagetoclientsvehicle14196")) {
		intakedataexport.setDamageToClientsVehicle(null);
		}else {
			
	    if(!jsonData.opt("damagetoclientsvehicle14196").equals(null)){
	    	intakedataexport.setDamageToClientsVehicle( jsonData.getString("damagetoclientsvehicle14196"));
	 }}
	
	if(jsonData.isNull("defendantvehicletype14196")) {
		intakedataexport.setDefendantVehicleType(null);
		}else {
			
	    if(!jsonData.opt("defendantvehicletype14196").equals(null)){
	    	intakedataexport.setDefendantVehicleType( jsonData.getString("defendantvehicletype14196"));
	 }}
	
	if(jsonData.isNull("defendantsvehiclemakemodel14196")) {
		intakedataexport.setDefendantsVehicleMakeModel(null);
		}else {
			
	    if(!jsonData.opt("defendantsvehiclemakemodel14196").equals(null)){
	    	intakedataexport.setDefendantsVehicleMakeModel( jsonData.getString("defendantsvehiclemakemodel14196"));
	 }}
	
	if(jsonData.isNull("damagetodefendantsvehicle14196")) {
		intakedataexport.setDamageToDefendantsVehicle(null);
		}else {
			
	    if(!jsonData.opt("damagetodefendantsvehicle14196").equals(null)){
	    	intakedataexport.setDamageToDefendantsVehicle( jsonData.getString("damagetodefendantsvehicle14196"));
	 }}
	if(jsonData.isNull("picturesofdamages14196")) {
		intakedataexport.setPicturesOfDamages(null);
		}else {
			
	    if(!jsonData.opt("picturesofdamages14196").equals(null)){
	    	intakedataexport.setPicturesOfDamages( jsonData.getString("picturesofdamages14196"));
	 }}
	
	if(jsonData.isNull("pdestimate14196")) {
		intakedataexport.setPDEstimate(null);
		}else {
			
	    if(!jsonData.opt("pdestimate14196").equals(null)){
	    	intakedataexport.setPDEstimate( jsonData.getString("pdestimate14196"));
	 }}
	if(jsonData.isNull("bywhomandwhere14196")) {
		intakedataexport.setByWhomAndWhere(null);
		}else {
			
	    if(!jsonData.opt("bywhomandwhere14196").equals(null)){
	    	intakedataexport.setByWhomAndWhere( jsonData.getString("bywhomandwhere14196"));
	 }}
	
	if(jsonData.isNull("datetaken14196")) {
		intakedataexport.setDateTaken(null);
		}else {
			
	    if(!jsonData.opt("datetaken14196").equals(null)){
	    	intakedataexport.setDateTaken( jsonData.getString("datetaken14196"));
	 }}
	if(jsonData.isNull("locationofclientsvehicle14196")) {
		intakedataexport.setLocationOfClientsVehicle(null);
		}else {
			
	    if(!jsonData.opt("locationofclientsvehicle14196").equals(null)){
	    	intakedataexport.setLocationOfClientsVehicle( jsonData.getString("locationofclientsvehicle14196"));
	 }}
	
	if(jsonData.isNull("rentaloptionsownliabnone14196")) {
		intakedataexport.setRentalOptionsOwnLiabNone(null);
		}else {
			
	    if(!jsonData.opt("rentaloptionsownliabnone14196").equals(null)){
	    	intakedataexport.setRentalOptionsOwnLiabNone( jsonData.getString("rentaloptionsownliabnone14196"));
	 }}
	
	if(jsonData.isNull("vehicletowed14196")) {
		intakedataexport.setVehicleTowed(null);
		}else {
			
	    if(!jsonData.opt("vehicletowed14196").equals(null)){
	    	intakedataexport.setVehicleTowed( jsonData.getString("vehicletowed14196"));
	 }}
	
	if(jsonData.isNull("towedby14196")){
		intakedataexport.setTowedBy(null);
	}else {
		JSONObject communication61=jsonData.getJSONObject("towedby14196");
		if(!communication61.opt("id").equals(null)){
			intakedataexport.setTowedBy(communication61.getString("id"));
		}}
	
	if(jsonData.isNull("towedto14196")) {
		intakedataexport.setTowedTo(null);
		}else {
			
	    if(!jsonData.opt("towedto14196").equals(null)){
	    	intakedataexport.setTowedTo( jsonData.getString("towedto14196"));
	 }}
	
	if(jsonData.isNull("pdnotes14196")) {
		intakedataexport.setPDNotes(null);
		}else {
			
	    if(!jsonData.opt("pdnotes14196").equals(null)){
	    	intakedataexport.setPDNotes( jsonData.getString("pdnotes14196"));
	 }}
	
	
	
	if(jsonData.isNull("employmentstatus14196")) {
		intakedataexport.setEmploymentStatus(null);
		}else {
			
	    if(!jsonData.opt("employmentstatus14196").equals(null)){
	    	intakedataexport.setEmploymentStatus( jsonData.getString("employmentstatus14196"));
	 }}
	
	if(jsonData.isNull("jobtitleduties14196")) {
		intakedataexport.setJobTitleDuties(null);
		}else {
			
	    if(!jsonData.opt("jobtitleduties14196").equals(null)){
	    	intakedataexport.setJobTitleDuties( jsonData.getString("jobtitleduties14196"));
	 }}
	
	if(jsonData.isNull("clientshourlyratesalary14196")) {
		intakedataexport.setClientsHourlyRateSalary(null);
		}else {
			
	    if(!jsonData.opt("clientshourlyratesalary14196").equals(null)){
	    	intakedataexport.setClientsHourlyRateSalary( jsonData.getString("clientshourlyratesalary14196"));
	 }}
	
	if(jsonData.isNull("employer14196")){
		intakedataexport.setEmployerId(null);
	}else {
		JSONObject communication70=jsonData.getJSONObject("employer14196");
		if(!communication70.opt("id").equals(null)){
			intakedataexport.setEmployerId(communication70.getString("id"));
		}}
	
	if(jsonData.isNull("supervisor14196")){
		intakedataexport.setSupervisorId(null);
	}else {
		JSONObject communication70=jsonData.getJSONObject("supervisor14196");
		if(!communication70.opt("id").equals(null)){
			intakedataexport.setSupervisorId(communication70.getString("id"));
		}}
	
	if(jsonData.isNull("lostwagesstart14196")) {
		intakedataexport.setLostWagesStart(null);
		}else {
			
	    if(!jsonData.opt("lostwagesstart14196").equals(null)){
	    	intakedataexport.setLostWagesStart( jsonData.getString("lostwagesstart14196"));
	 }}
	
	if(jsonData.isNull("lostwagesend14196")) {
		intakedataexport.setLostWagesEnd(null);
		}else {
			
	    if(!jsonData.opt("lostwagesend14196").equals(null)){
	    	intakedataexport.setLostWagesEnd( jsonData.getString("lostwagesend14196"));
	 }}
	
	if(jsonData.isNull("concurrentemployment14196")) {
		intakedataexport.setConcurrentEmployment(null);
		}else {
			
	    if(!jsonData.opt("concurrentemployment14196").equals(null)){
	    	intakedataexport.setConcurrentEmployment( jsonData.getString("concurrentemployment14196"));
	 }}
	
	if(jsonData.isNull("ccemployer114196")){
		intakedataexport.setCCEmployer1(null);
	}else {
		JSONObject communication71=jsonData.getJSONObject("ccemployer114196");
		if(!communication71.opt("id").equals(null)){
			intakedataexport.setCCEmployer1(communication71.getString("id"));
		}}
	
	if(jsonData.isNull("cc1hourlyratesalary14196")) {
		intakedataexport.setCC1HourlyRateSalary(null);
		}else {
			
	    if(!jsonData.opt("cc1hourlyratesalary14196").equals(null)){
	    	intakedataexport.setCC1HourlyRateSalary( jsonData.getString("cc1hourlyratesalary14196"));
	 }}
	
	
	if(jsonData.isNull("ccemployer214196")){
		intakedataexport.setCCEmployer2(null);
	}else {
		JSONObject communication73=jsonData.getJSONObject("ccemployer214196");
		if(!communication73.opt("id").equals(null)){
			intakedataexport.setCCEmployer2(communication73.getString("id"));
		}}
	
	if(jsonData.isNull("cc2hourlyratesalary14196")) {
		intakedataexport.setCC2HourlyRateSalary(null);
		}else {
			
	    if(!jsonData.opt("cc2hourlyratesalary14196").equals(null)){
	    	intakedataexport.setCC2HourlyRateSalary( jsonData.getString("cc2hourlyratesalary14196"));
	 }}
	
	if(jsonData.isNull("employmentnotes14196")) {
		intakedataexport.setEmploymentNotes(null);
		}else {
			
	    if(!jsonData.opt("employmentnotes14196").equals(null)){
	    	intakedataexport.setEmploymentNotes( jsonData.getString("employmentnotes14196"));
	 }}
	
	if(jsonData.isNull("thingsclientcannolongerdoatall14196")) {
		intakedataexport.setThingsclientcanNoLongerDo(null);
		}else {
			
	    if(!jsonData.opt("thingsclientcannolongerdoatall14196").equals(null)){
	    	intakedataexport.setThingsclientcanNoLongerDo( jsonData.getString("thingsclientcannolongerdoatall14196"));
	 }}
	
	if(jsonData.isNull("thingsclientcandobutwithpainnotaswell14196")) {
		intakedataexport.setThingsclientCANDo(null);
		}else {
			
	    if(!jsonData.opt("thingsclientcandobutwithpainnotaswell14196").equals(null)){
	    	intakedataexport.setThingsclientCANDo( jsonData.getString("thingsclientcandobutwithpainnotaswell14196"));
	 }}
	
	if(jsonData.isNull("lossoflifesenjoyment14196")) {
		intakedataexport.setLossOfLifesEnjoyment(null);
		}else {
			
	    if(!jsonData.opt("lossoflifesenjoyment14196").equals(null)){
	    	intakedataexport.setLossOfLifesEnjoyment( jsonData.getString("lossoflifesenjoyment14196"));
	 }}
	
	if(jsonData.isNull("healthhistoryoverallhealthsurgeries14196")) {
		intakedataexport.setHealthHistoryOverallHealth(null);
		}else {
			
	    if(!jsonData.opt("healthhistoryoverallhealthsurgeries14196").equals(null)){
	    	intakedataexport.setHealthHistoryOverallHealth( jsonData.getString("healthhistoryoverallhealthsurgeries14196"));
	 }}
	
	if(jsonData.isNull("socialmediaaccounts14196")) {
		intakedataexport.setSocialMediaAccounts(null);
		}else {
			
	    if(!jsonData.opt("socialmediaaccounts14196").equals(null)){
	    	intakedataexport.setSocialMediaAccounts( jsonData.getString("socialmediaaccounts14196"));
	 }}
	
	if(jsonData.isNull("didyougooversocialmediapostingwithc14196")) {
		intakedataexport.setSocialMediaPostingWithClient(null);
		}else {
			
	    if(!jsonData.opt("didyougooversocialmediapostingwithc14196").equals(null)){
	    	intakedataexport.setSocialMediaPostingWithClient( jsonData.getString("didyougooversocialmediapostingwithc14196"));
	 }}
	
	if(jsonData.isNull("redflags14196")) {
		intakedataexport.setRedFlags(null);
		}else {
			
	    if(!jsonData.opt("redflags14196").equals(null)){
	    	intakedataexport.setRedFlags( jsonData.getString("redflags14196"));
	 }}
	
	if(jsonData.isNull("additionalnotes14196")) {
		intakedataexport.setAdditionalNotes(null);
		}else {
			
	    if(!jsonData.opt("additionalnotes14196").equals(null)){
	    	intakedataexport.setAdditionalNotes( jsonData.getString("additionalnotes14196"));
	 }}
	
	if(jsonData.isNull("dateintakeupdated14196")) {
		intakedataexport.setDateIntakeUpdated(null);
		}else {
			
	    if(!jsonData.opt("dateintakeupdated14196").equals(null)){
	    	intakedataexport.setDateIntakeUpdated( jsonData.getString("dateintakeupdated14196"));
	 }}
	
	if(jsonData.isNull("intakeupdatedbywho14196")) {
		intakedataexport.setIntakeUpdatedByWho(null);
		}else {
			
	    if(!jsonData.opt("intakeupdatedbywho14196").equals(null)){
	    	intakedataexport.setIntakeUpdatedByWho( jsonData.getString("intakeupdatedbywho14196"));
	 }}
	
	if(jsonData.isNull("didyoutakeanyscenephotos14196")) {
		intakedataexport.setDidYouTakeAnyScenePhotos(null);
		}else {
			
	    if(!jsonData.opt("didyoutakeanyscenephotos14196").equals(null)){
	    	intakedataexport.setDidYouTakeAnyScenePhotos( jsonData.getString("didyoutakeanyscenephotos14196"));
	 }}
	
	
	

		
		
	
		
	/*	
		if(jsonData.isNull("personperformingintake14196")){
			intakedataexport.setPersonPerformingIntake(null);
		}else {
			JSONObject communication12=jsonData.getJSONObject("personperformingintake14196");
			if(!communication12.opt("fullname").equals(null)){
				intakedataexport.setPersonPerformingIntake(communication12.getString("fullname"));
			}}
		if(jsonData.isNull("incidenttype14196")) {
			intakedataexport.setIncidentType( null);
			}else {
				
		    if(!jsonData.opt("incidenttype14196").equals(null)){
		    	intakedataexport.setIncidentType( jsonData.getString("incidenttype14196"));
		 }} 
		
		if(jsonData.isNull("qualified14196")) {
			intakedataexport.setQualiFied(false);
			}else {
				
		    if(!jsonData.opt("qualified14196").equals(null)){
		    	intakedataexport.setQualiFied( jsonData.getBoolean("qualified14196"));
		 }}
		
		
		
		
		
		if(jsonData.isNull("qualified14196")) {
			intakedataexport.setQualiFied(false);
			}else {
				
		    if(!jsonData.opt("qualified14196").equals(null)){
		    	intakedataexport.setQualiFied( jsonData.getBoolean("qualified14196"));
		 }}
		
		if(jsonData.isNull("datecontractsent14196")) {
			intakedataexport.setDateContractSent( null);
			}else {
				
		    if(!jsonData.opt("datecontractsent14196").equals(null)){
		    	intakedataexport.setDateContractSent( jsonData.getString("datecontractsent14196"));
		 }}
		
		if(jsonData.isNull("datecontractsigned14196")) {
			intakedataexport.setDateContractSigned( null);
			}else {
				
		    if(!jsonData.opt("datecontractsigned14196").equals(null)){
		    	intakedataexport.setDateContractSigned( jsonData.getString("datecontractsigned14196"));
		 }}
		if(jsonData.isNull("contractupload14196")){
			intakedataexport.setContractUpload(null);
		}else {
			JSONObject communication15=jsonData.getJSONObject("contractupload14196");
			if(!communication15.opt("filename").equals(null)){
				intakedataexport.setContractUpload(communication15.getString("filename"));
			}}
		
		
		
		
		
//		if(jsonData.isNull("incidenttype14196")) {
//			intakedataexport.setIncidentType( null);
//			}else {
//				
//		    if(!jsonData.opt("incidenttype14196").equals(null)){
//		    	intakedataexport.setIncidentType( jsonData.getString("incidenttype14196"));
//		 }}
		
		if(jsonData.isNull("typeofmva14196")) {
			intakedataexport.setTypeOfMva( null);
			}else {
				
		    if(!jsonData.opt("typeofmva14196").equals(null)){
		    	intakedataexport.setTypeOfMva( jsonData.getString("typeofmva14196"));
		 }}
		
		
		
		
		
		
		
		
		
		
		
//		if(jsonData.isNull("weatherandroadconditions14196")) {
//			intakedataexport.setWeatherAndRoadConditions( null);
//			}else {
//				
//		    if(!jsonData.opt("weatherandroadconditions14196").equals(null)){
//		    	intakedataexport.setWeatherAndRoadConditions( jsonData.getString("weatherandroadconditions14196"));
//		 }}
//		
		
		
		if(jsonData.isNull("policeofficerdepartment14196")) {
			intakedataexport.setPoliceOfficerDepartmentr( null);
			}else {
				
		    if(!jsonData.opt("policeofficerdepartment14196").equals(null)){
		    	intakedataexport.setPoliceOfficerDepartmentr( jsonData.getString("policeofficerdepartment14196"));
		 }}
		if(jsonData.isNull("policeofficerdepartment214196")) {
			intakedataexport.setSetPoliceOfficerDepartmentr2( null);
			}else {
				
		    if(!jsonData.opt("policeofficerdepartment214196").equals(null)){
		    	intakedataexport.setSetPoliceOfficerDepartmentr2( jsonData.getString("policeofficerdepartment214196"));
		 }}
		if(jsonData.isNull("f2_policereport14196")) {
			intakedataexport.setPolicerReportNo( null);
			}else {
				
		    if(!jsonData.opt("f2_policereport14196").equals(null)){
		    	intakedataexport.setPolicerReportNo( jsonData.getString("f2_policereport14196"));
		 }}
		if(jsonData.isNull("officertrooper14196")) {
			intakedataexport.setOfficerTrooper( null);
			}else {
				
		    if(!jsonData.opt("officertrooper14196").equals(null)){
		    	intakedataexport.setOfficerTrooper( jsonData.getString("officertrooper14196"));
		 }}
		
		
		
		
		if(jsonData.isNull("citationsissued14196")) {
			intakedataexport.setCitationsIssued(false);
			}else {
				
		    if(!jsonData.opt("citationsissued14196").equals(null)){
		    	intakedataexport.setCitationsIssued( jsonData.getBoolean("citationsissued14196"));
		 }}
		
		if(jsonData.isNull("citationfinaldisposition14196")){
			intakedataexport.setCitationFinalDisposition(null);
		}else {
			JSONObject communication8=jsonData.getJSONObject("citationfinaldisposition14196");
			if(!communication8.opt("filename").equals(null)){
				intakedataexport.setCitationFinalDisposition(communication8.getString("filename"));
			}}
		
//		if(jsonData.isNull("witnesses14196")){
//			intakedataexport.setWitnesses(null);
//		}else {
//			JSONObject communication8=jsonData.getJSONObject("witness14196");
//			if(!communication8.opt("fullname").equals(null)){
//				intakedataexport.setWitnesses(communication8.getString("fullname"));
//			}}
		
		
		
//		if(jsonData.isNull("incidentdiagrams14196")) {
//					intakedataexport.setIncidentdiagrams(false);
//					}else {
//						
//				    if(!jsonObject.opt("incidentdiagrams14196").equals(null)){
//				    	intakedataexport.setIncidentdiagrams( jsonData.getBoolean("incidentdiagrams14196"));
//				 }}
//				
//				if(jsonData.isNull("incidentphotosvideos14196")) {
//					intakedataexport.setIncidentPhotosVideos(false);
//					}else {
//						
//				    if(!jsonData.opt("incidentphotosvideos14196").equals(null)){
//				    	intakedataexport.setIncidentPhotosVideos( jsonData.getBoolean("incidentphotosvideos14196"));
//				 }}
 * 
 * 
		
		if(jsonData.isNull("incidentinfo14196")) {
			intakedataexport.setIncidentInfo( null);
			}else {
				
		    if(!jsonData.opt("incidentinfo14196").equals(null)){
		    	intakedataexport.setIncidentInfo( jsonData.getString("incidentinfo14196"));
		 }}
		
		if(jsonData.isNull("hospital14196")){
			intakedataexport.setHospital(null);
		}else {
			JSONObject communication10=jsonData.getJSONObject("hospital14196");
			if(!communication10.opt("fullname").equals(null)){
				intakedataexport.setHospital(communication10.getString("fullname"));
			}}
		
		
		if(jsonData.isNull("didclientgotothehospital14196")) {
			intakedataexport.setDidClientGoToTheHospital(false);
			}else {
					
			 if(!jsonData.opt("didclientgotothehospital14196").equals(null)){
			intakedataexport.setDidClientGoToTheHospital( jsonData.getBoolean("didclientgotothehospital14196"));
	 }}
		
		
		if(jsonData.isNull("hostvehicleinsurance14196")) {
			intakedataexport.setHostVehicleDriver(null);
			}else {
				
		    if(!jsonData.opt("hostvehicledriver14196").equals(null)){
		    	intakedataexport.setHostVehicleDriver( jsonData.getString("hostvehicleinsurance14196"));
		 }}
		
		if(jsonData.isNull("hostinsuranceinfo14196")) {
			intakedataexport.setHostInsuranceOwner(null);
			}else {
				
		    if(!jsonData.opt("hostinsuranceinfo14196").equals(null)){
		    	intakedataexport.setHostInsuranceOwner( jsonData.getString("hostinsuranceinfo14196"));
		 }}
		
		
		if(jsonData.isNull("passengers14196")) {
			intakedataexport.setPassengers(false);
			}else {
				
		    if(!jsonData.opt("passengers14196").equals(null)){
		    	intakedataexport.setPassengers( jsonData.getBoolean("passengers14196"));
		 }}
		
		if(jsonData.isNull("defendantdriver14196")) {
			intakedataexport.setDefendantDriver(null);
			}else {
				
		    if(!jsonData.opt("defendantdriver14196").equals(null)){
		    	intakedataexport.setDefendantDriver( jsonData.getString("defendantdriver14196"));
		 }}
		
		if(jsonData.isNull("defendantowner14196")) {
			intakedataexport.setDefendantOwner(null);
			}else {
				
		    if(!jsonData.opt("defendantowner14196").equals(null)){
		    	intakedataexport.setDefendantOwner( jsonData.getString("defendantowner14196"));
		 }}
		
		if(jsonData.isNull("defendantinsurance14196")) {
			intakedataexport.setDefendantInsurance(null);
			}else {
				
		    if(!jsonData.opt("defendantinsurance14196").equals(null)){
		    	intakedataexport.setDefendantInsurance( jsonData.getString("defendantinsurance14196"));
		 }}
		if(jsonData.isNull("clientvehicletype14196")) {
			intakedataexport.setClientVehicleType(null);
			}else {
				
		    if(!jsonData.opt("clientvehicletype14196").equals(null)){
		    	intakedataexport.setClientVehicleType( jsonData.getString("clientvehicletype14196"));
		 }}
		
		if(jsonData.isNull("clientsvehiclemakemodel14196")) {
			intakedataexport.setClientsVehicleMakeModel(null);
			}else {
				
		    if(!jsonData.opt("clientsvehiclemakemodel14196").equals(null)){
		    	intakedataexport.setClientsVehicleMakeModel( jsonData.getString("clientsvehiclemakemodel14196"));
		 }}
		
		if(jsonData.isNull("damagetoclientsvehicle14196")) {
			intakedataexport.setDamageToClientsVehicle(null);
			}else {
				
		    if(!jsonData.opt("damagetoclientsvehicle14196").equals(null)){
		    	intakedataexport.setDamageToClientsVehicle( jsonData.getString("damagetoclientsvehicle14196"));
		 }}
		
		if(jsonData.isNull("defendantvehicletype14196")) {
			intakedataexport.setDefendantVehicleType(null);
			}else {
				
		    if(!jsonData.opt("defendantvehicletype14196").equals(null)){
		    	intakedataexport.setDefendantVehicleType( jsonData.getString("defendantvehicletype14196"));
		 }}
		
		if(jsonData.isNull("defendantsvehiclemakemodel14196")) {
			intakedataexport.setDefendantsVehicleMakeModel(null);
			}else {
				
		    if(!jsonData.opt("defendantsvehiclemakemodel14196").equals(null)){
		    	intakedataexport.setDefendantsVehicleMakeModel( jsonData.getString("defendantsvehiclemakemodel14196"));
		 }}
		
		if(jsonData.isNull("damagetodefendantsvehicle14196")) {
			intakedataexport.setDamageToDefendantsVehicle(null);
			}else {
				
		    if(!jsonData.opt("damagetodefendantsvehicle14196").equals(null)){
		    	intakedataexport.setDamageToDefendantsVehicle( jsonData.getString("damagetodefendantsvehicle14196"));
		 }}
		if(jsonData.isNull("picturesofdamages14196")) {
			intakedataexport.setPicturesOfDamages(false);
			}else {
				
		    if(!jsonData.opt("picturesofdamages14196").equals(null)){
		    	intakedataexport.setPicturesOfDamages( jsonData.getBoolean("picturesofdamages14196"));
		 }}
		if(jsonData.isNull("pdestimate14196")) {
			intakedataexport.setPdeStimate(null);
			}else {
				
		    if(!jsonData.opt("pdestimate14196").equals(null)){
		    	intakedataexport.setPdeStimate(jsonData.getString("pdestimate14196"));
		 }}
		
		if(jsonData.isNull("locationofclientsvehicle14196")) {
			intakedataexport.setLocationOfClientsVehicle(null);
			}else {
				
		    if(!jsonData.opt("locationofclientsvehicle14196").equals(null)){
		    	intakedataexport.setLocationOfClientsVehicle( jsonData.getString("locationofclientsvehicle14196"));
		 }}
		
		if(jsonData.isNull("rentaloptionsownliabnone14196")) {
			intakedataexport.setRentalOptionsOwnLiaBnone(null);
			}else {
				
		    if(!jsonData.opt("rentaloptionsownliabnone14196").equals(null)){
		    	intakedataexport.setRentalOptionsOwnLiaBnone( jsonData.getString("rentaloptionsownliabnone14196"));
		 }}
		
		if(jsonData.isNull("vehicletowed14196")) {
			intakedataexport.setVehicletowed(false);
			}else {
				
		    if(!jsonData.opt("vehicletowed14196").equals(null)){
		    	intakedataexport.setVehicletowed( jsonData.getBoolean("vehicletowed14196"));
		 }}
		if(jsonData.isNull("pdnotes14196")) {
			intakedataexport.setPdnotes(null);
			}else {
				
		    if(!jsonData.opt("pdnotes14196").equals(null)){
		    	intakedataexport.setPdnotes( jsonData.getString("pdnotes14196"));
		 }}
		
	//==============BODY INJURY JSON=========================
		if(jsonData.isNull("injuriessustained14196")) {
			intakedataexport.setInjuriessuStained(null);
			}else {
				
		    if(!jsonData.opt("injuriessustained14196").equals(null)){
		    	intakedataexport.setInjuriessuStained( jsonData.getString("injuriessustained14196"));
		 }}
		
		if(jsonData.isNull("permanentinjuryorscarring14196")) {
			intakedataexport.setPermanentInjuryorScarring(false);
			}else {
				
		    if(!jsonData.opt("permanentinjuryorscarring14196").equals(null)){
		    	intakedataexport.setPermanentInjuryorScarring( jsonData.getBoolean("permanentinjuryorscarring14196"));
		 }}
		if(jsonData.isNull("describeinjuriessustainedpaincompla14196")) {
			intakedataexport.setDescribeInjurieSsustainedPainComplaints(null);
			}else {
				
		    if(!jsonData.opt("describeinjuriessustainedpaincompla14196").equals(null)){
		    	intakedataexport.setDescribeInjurieSsustainedPainComplaints( jsonData.getString("describeinjuriessustainedpaincompla14196"));
		 }}
		
		if(jsonData.isNull("picturestakenofinjuries14196")) {
			intakedataexport.setPicturesTakenOfInjuries(false);
			}else {
				
		    if(!jsonData.opt("picturestakenofinjuries14196").equals(null)){
		    	intakedataexport.setPicturesTakenOfInjuries( jsonData.getBoolean("picturestakenofinjuries14196"));
		 }}
		if(jsonData.isNull("treatmentinfo14196")) {
			intakedataexport.setTreatmentInfo(null);
			}else {
				
//		    if(!jsonData.opt("treatmentinfo14196").equals(null)){
//		    	intakedataexport.setTreatmentInfo( jsonData.getString("treatmentinfo14196"));
//		 }}
//		if(jsonData.isNull("primarycarephysician14196")) {
//			intakedataexport.setPrimaryCarePhysician(null);
//			}else {
//				
//		    if(!jsonData.opt("primarycarephysician14196").equals(null)){
//		    	intakedataexport.setPrimaryCarePhysician( jsonData.getString("primarycarephysician14196"));
//		 }}
		 
		*/ 
//		if(jsonData.isNull("healthinsurance14196")) {
//			intakedataexport.setHealthInsurance(null);
//			}else {
//				
//		    if(!jsonData.opt("healthinsurance14196").equals(null)){
//		    	intakedataexport.setHealthInsurance( jsonData.getString("healthinsurance14196"));
//		 }}
//		if(jsonData.isNull("medicaremedicaid14196")) {
//			intakedataexport.setMedicareMedicaid(null);
//			}else {
//				
//		    if(!jsonData.opt("medicaremedicaid14196").equals(null)){
//		    	intakedataexport.setMedicareMedicaid( jsonData.getString("medicaremedicaid14196"));
//		 }}
//		if(jsonData.isNull("priortreatmentdocinfo14196")) {
//			intakedataexport.setPriorTreatmentDocInfo(null);
//			}else {
//				
//		    if(!jsonData.opt("priortreatmentdocinfo14196").equals(null)){
//		    	intakedataexport.setPriorTreatmentDocInfo( jsonData.getString("priortreatmentdocinfo14196"));
//		 }}
		/*
		if(jsonData.isNull("priorincidents14196")) {
			intakedataexport.setPriorIncidents(false);
			}else {
				
		    if(!jsonData.opt("priorincidents14196").equals(null)){
		    	intakedataexport.setPriorIncidents( jsonData.getBoolean("priorincidents14196"));
		 }}
		if(jsonData.isNull("criminalhistory14196")) {
			intakedataexport.setCriminalHistory(false);
			}else {
				
		    if(!jsonData.opt("criminalhistory14196").equals(null)){
		    	intakedataexport.setCriminalHistory( jsonData.getBoolean("criminalhistory14196"));
		 }}
		*/
		intakedataexportdao.insertIntakeData(databaseName,intakedataexport);
		
		
			}	
		
}
}


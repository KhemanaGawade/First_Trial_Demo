package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.IntakeDetailExport;
import com.filevine.dataexport.domain.IntakeExport;

import util.DBProvider;

public class IntakeExportDao {
//
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertIntakeData(IntakeExport intakeExport, String databaseName) throws Exception {
		MDC.put("path", "File Vine:: Intake Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_intakeAccidentIfo_export("
					+ "projectId,"
					+ "werecitationsissued,"
					+ "policereport,"
					+ "picturesofdamages,"
					+ "vehicletowed,"
					+ "estimatedone,"
					+ "picturestakenofinjuries,"
					+ "subsequentaccidents,"
					+ "reviewsocialmedialetterpolicy,"
					+ "concurrentemployment,"
					+ "witnesses,"
					+ "wereyoutransportedinanambulance,"
					+ "didyougotothehospital,"
					+ "chiropractictreatment,"
					+ "accidenttype,"
					+ "timeofaccident,"
					+ "descriptionofaccident,"
					+ "clientsvehiclemakemodel,"
					+ "damagetoclientsvehicle,"//
					+ "defendantsvehiclemakemodel,"
					+ "damagetodefendantsvehicle,"
					+ "bywhomandwhere,"
					+ "locationofclientsvehicle,"
					+ "rentaloptionsownliabnone,"
					+ "injuriessustainedpaincomplaints,"
					+ "priorinjuries,"
					+ "priorclaimswattorneyandreceived,"
					+ "priorlawsuitswattorneyandreceived,"
					+ "employmentstatus,"
					+ "jobtitle,"
					+ "thingsclientcannolongerdoatall,"
					+ "canbutwithpainnotaswell,"
					+ "lossoflifesenjoyment,"
					+ "healthhistoryoverallhealthsurgerie,"
					+ "additionalthoughtsconcernsraisedab,"
					+ "additionalinfo,"
					+ "locationofaccident,"
					+ "referralsource,"
					+ "resolution,"
					+ "qualificationstatus,"
					+ "citationcodesection,"
					+ "employerId,"
					+ "personperformingintakeId,"
					+ "spousepartnerifapplicableId,"
					+ "maincontactcaretakerguardianorclie,"
					+ "driverId,"
					+ "vehicleownerId,chiropracticfacilityId,passengerId,children,datetaken,"
					+ "dateofintake,datecontractsigned,statuteoflimitations,incidentdate,createdDate,"
					+ "referredfromId,towed_byId,towed_to,policereportnarative,citationnumber,ambulanceId)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setString(1,intakeExport.getProjectId());
			ps.setString(2, intakeExport.getWerecitationsissued());
			ps.setString(3, intakeExport.getPolicereport());
			ps.setString(4, intakeExport.getPicturesofdamages());
			ps.setString(5,intakeExport.getVehicletowed());
			ps.setString(6,intakeExport.getEstimatedone());
			ps.setString(7,intakeExport.getPicturestakenofinjuries());
			ps.setString(8, intakeExport.getSubsequentaccidents());
			ps.setString(9, intakeExport.getReviewsocialmedialetterpolicy());
			ps.setString(10, intakeExport.getConcurrentemployment());
			ps.setString(11, intakeExport.getWitnesses());
			ps.setString(12, intakeExport.getWereyoutransportedinanambulance());
			ps.setString(13, intakeExport.getDidyougotothehospital());
			ps.setString(14, intakeExport.getChiropractictreatment());
			ps.setString(15, intakeExport.getAccidenttype());
			ps.setString(16, intakeExport.getTimeofaccident());
			ps.setString(17, intakeExport.getDescriptionofaccident());
			ps.setString(18, intakeExport.getClientsvehiclemakemodel());
			ps.setString(19, intakeExport.getDamagetoclientsvehicle());
			ps.setString(20, intakeExport.getDefendantsvehiclemakemodel());
			ps.setString(21, intakeExport.getDamagetodefendantsvehicle());
			ps.setString(22, intakeExport.getBywhomandwhere());
			ps.setString(23, intakeExport.getLocationofclientsvehicle());
			ps.setString(24, intakeExport.getRentaloptionsownliabnone());
			ps.setString(25, intakeExport.getInjuriessustainedpaincomplaints());
			ps.setString(26, intakeExport.getPriorinjuries());
			ps.setString(27, intakeExport.getPriorclaimswattorneyandreceived());
			ps.setString(28, intakeExport.getPriorlawsuitswattorneyandreceived());
			ps.setString(29, intakeExport.getEmploymentstatus());
			ps.setString(30, intakeExport.getJobtitle());
			ps.setString(31, intakeExport.getThingsclientcannolongerdoatall());
			ps.setString(32, intakeExport.getCanbutwithpainnotaswell());
			ps.setString(33, intakeExport.getLossoflifesenjoyment());
			ps.setString(34, intakeExport.getHealthhistoryoverallhealthsurgerie());
			ps.setString(35, intakeExport.getAdditionalthoughtsconcernsraisedab());
			ps.setString(36, intakeExport.getAdditionalinfo());
			ps.setString(37, intakeExport.getLocationofaccident());
			ps.setString(38, intakeExport.getReferralsource());
			ps.setString(39, intakeExport.getResolution());
			ps.setString(40, intakeExport.getQualificationstatus());
			ps.setString(41, intakeExport.getCitationcodesection());
			ps.setString(42, intakeExport.getEmployerId());
			ps.setString(43, intakeExport.getPersonperformingintakeId());
			ps.setString(44, intakeExport.getSpousepartnerifapplicableId());
			ps.setString(45, intakeExport.getMaincontactcaretakerguardianorclie());
			ps.setString(46, intakeExport.getDriverId());
			ps.setString(47, intakeExport.getVehicleownerId());
			ps.setString(48, intakeExport.getChiropracticfacilityId());
			ps.setString(49, intakeExport.getPassengerId());
			ps.setString(50, intakeExport.getChildren());
			ps.setString(51, intakeExport.getDatetaken());
			ps.setString(52, intakeExport.getDateofintake());
			ps.setString(53, intakeExport.getDatecontractsigned());
			ps.setString(54, intakeExport.getStatuteoflimitations());
			ps.setString(55, intakeExport.getIncidentdate());
			ps.setString(56, intakeExport.getCreatedDate());
			ps.setString(57, intakeExport.getReferredfromId());
			ps.setString(58, intakeExport.getTowedById());
			ps.setString(59, intakeExport.getTowedTo());
			ps.setString(60, intakeExport.getPolicereportnarative());
			ps.setString(61, intakeExport.getCitationnumber());
			ps.setString(62, intakeExport.getAmbulanceId());
			ps.executeUpdate();
			//System.out.println("Project id :: "+ intakeExport.getProjectId() +" has been exported!!");
			eventLogger.info("Project id :: "+ intakeExport.getProjectId() + " has been exported!!");
			
		}catch(Exception e) {
			errorLogger.error("Project id :: "+ intakeExport.getProjectId() + " alrready exists!",e);
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}


	public void insertIntakeDetailsData(IntakeDetailExport intakeExport, String databaseName) throws SQLException {
	MDC.put("path", "File Vine:: Intake Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_intakeData_export("
					+ "projectId,"
					+ "madeappointment,"
					+ "feecancellationexplained,"
					+ "minorchildren,"
					+ "opposingpartyapplicable,"
					+ "bestwaytocontactyou,"
					+ "typeoffamilylaw,"
					+ "referralsource,"
					+ "timeofappointment,"
					+ "referralnameId,"
					+ "opposingpartyId,"
					+ "opposingpartyattorneyId,"
					+ "intaketakenbyId,"
					+ "childId,"
					+ "married,"
					+ "childsupportarrearages,"
					+ "reportedtoemployer,"
					+ "treatingwithdoctor,"
					+ "fringebenefits,"
					+ "areyoureceivingchecks,"
					+ "haveyoureturnedtowork,"
					+ "areyouworkingnow,"
					+ "haveyoubeenterminated,"
					+ "weretherewitnessestoaccident,"
					+ "didyouhaveanythingtodrinkonthedayo,"
					+ "wereanymedsordrugslegalorillegalta,"
					+ "takentoahospital,"
					+ "takenbyambulance,"
					+ "referredforanyothertreatmentordoct,"
					+ "areyoucurrentlyourofworkbyatreatin,"
					+ "areyoureceivingchecksfromworkersco,"
					+ "locationofaccidentcitystate,"
					+ "resolution,"
					+ "educationlevel,"
					+ "positionheld,"
					+ "towhomreported,"
					+ "whoareyoutreatingwith,"
					+ "per,"
					+ "hoursperweek,"
					+ "dateslostfromworkbecauseofinjury,"
					+ "timeofday,"
					+ "dayofweek,"
					+ "witnesses,"
					+ "describehowtheaccidenthappened,"
					+ "injuries,"
					+ "priorcomplaintsofinjuredbodyparts,"
					+ "priororcurrentmedicalconditions,priorworkerscompensationclaims,priorlawyersforaccidents,criminalbackground1,objectiveinfilingworkerscompensati,"
					+ "otheroutstandingmedicalissues,otheroutstandingindemnityissues,interviewer,employersnameId,directsupervisorsnameId,"
					+ "personperformingintakeId,rateofpay,amountraised,dateofintake,datecontactsigned,dateemploymentstarted,whenreported,"
					+ "lastpayraisedate,datereturned,dateoftermination,dateofinterview,dateofappt,createdDate)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setString(1,intakeExport.getProjectId());
			ps.setString(2, intakeExport.getMadeappointment());
			ps.setString(3, intakeExport.getFeecancellationexplained());
			ps.setString(4, intakeExport.getMinorchildren());
			ps.setString(5,intakeExport.getOpposingpartyapplicable());
			ps.setString(6,intakeExport.getBestwaytocontactyou());
			ps.setString(7,intakeExport.getTypeoffamilylaw());
			ps.setString(8, intakeExport.getReferralsource());
			ps.setString(9, intakeExport.getTimeofappointment());
			ps.setString(10, intakeExport.getReferralnameId());
			ps.setString(11, intakeExport.getOpposingpartyId());
			ps.setString(12, intakeExport.getOpposingpartyattorneyId());
			ps.setString(13, intakeExport.getIntaketakenbyId());
			ps.setString(14, intakeExport.getChildId());
			ps.setString(15, intakeExport.getMarried());
			ps.setString(16, intakeExport.getChildsupportarrearages());
			ps.setString(17, intakeExport.getReportedtoemployer());
			ps.setString(18, intakeExport.getTreatingwithdoctor());
			ps.setString(19, intakeExport.getFringebenefits());
			ps.setString(20, intakeExport.getAreyoureceivingchecks());
			ps.setString(21, intakeExport.getHaveyoureturnedtowork());
			ps.setString(22, intakeExport.getAreyouworkingnow());
			ps.setString(23, intakeExport.getHaveyoubeenterminated());
			ps.setString(24, intakeExport.getWeretherewitnessestoaccident());
			ps.setString(25, intakeExport.getDidyouhaveanythingtodrinkonthedayo());
			ps.setString(26, intakeExport.getWereanymedsordrugslegalorillegalta());
			ps.setString(27, intakeExport.getTakentoahospital());
			ps.setString(28, intakeExport.getTakenbyambulance());
			ps.setString(29, intakeExport.getReferredforanyothertreatmentordoct());
			ps.setString(30, intakeExport.getAreyoucurrentlyourofworkbyatreatin());
			ps.setString(31, intakeExport.getAreyoureceivingchecksfromworkersco());
			ps.setString(32, intakeExport.getLocationofaccidentcitystate());
			ps.setString(33, intakeExport.getResolution());
			ps.setString(34, intakeExport.getEducationlevel());
			ps.setString(35, intakeExport.getPositionheld());
			ps.setString(36, intakeExport.getTowhomreported());
			ps.setString(37, intakeExport.getWhoareyoutreatingwith());
			ps.setString(38, intakeExport.getPer());
			ps.setString(39, intakeExport.getHoursperweek());
			ps.setString(40, intakeExport.getDateslostfromworkbecauseofinjury());
			ps.setString(41, intakeExport.getTimeofday());
			ps.setString(42, intakeExport.getDayofweek());
			ps.setString(43, intakeExport.getWitnesses());
			ps.setString(44, intakeExport.getDescribehowtheaccidenthappened());
			ps.setString(45, intakeExport.getInjuries());
			ps.setString(46, intakeExport.getPriorcomplaintsofinjuredbodyparts());
			ps.setString(47, intakeExport.getPriororcurrentmedicalconditions());
			ps.setString(48, intakeExport.getPriorworkerscompensationclaims());
			ps.setString(49, intakeExport.getPriorlawyersforaccidents());
			ps.setString(50, intakeExport.getCriminalbackground1());
			ps.setString(51, intakeExport.getObjectiveinfilingworkerscompensati());
			ps.setString(52, intakeExport.getOtheroutstandingmedicalissues());
			ps.setString(53, intakeExport.getOtheroutstandingindemnityissues());
			ps.setString(54, intakeExport.getInterviewer());
			ps.setString(55, intakeExport.getEmployersnameId());
			ps.setString(56, intakeExport.getDirectsupervisorsnameId());
			ps.setString(57, intakeExport.getPersonperformingintakeId());
			ps.setString(58, intakeExport.getRateofpay());
			ps.setString(59, intakeExport.getAmountraised());
			ps.setString(60, intakeExport.getDateofintake());
			ps.setString(61, intakeExport.getDatecontactsigned());
			ps.setString(62, intakeExport.getDateemploymentstarted());
			ps.setString(63, intakeExport.getWhenreported());
			ps.setString(64, intakeExport.getLastpayraisedate());
			ps.setString(65, intakeExport.getDatereturned());
			ps.setString(66, intakeExport.getDateoftermination());
			ps.setString(67, intakeExport.getDateofinterview());
			ps.setString(68, intakeExport.getDateofappt());
			ps.setString(69, intakeExport.getCreatedDate());
			ps.executeUpdate();
			//System.out.println("Project id :: "+ intakeExport.getProjectId() +" has been exported!!");
			eventLogger.info("Project id :: "+ intakeExport.getProjectId() + " has been exported!!");
			
		}catch(Exception e) {
			errorLogger.error("Project id :: "+ intakeExport.getProjectId() + " alrready exists!",e);
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
	}

}

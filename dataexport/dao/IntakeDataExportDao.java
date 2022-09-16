package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.CaseSummaryExportData;
import com.filevine.dataexport.domain.IntakeDataExport;

import util.DBProvider;

public class IntakeDataExportDao {

	
public void insertIntakeData(String databaseName, IntakeDataExport intakedataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_intake_data_export_new("
					+ "project_id,"					
					+ "date_of_intake,"
					+ "person_performing_intake,"
					+ "employee_performing_intake,"
					+ "referral_source,"
					+ "referred_from,"
					+ "referral_source_fee,"
					+ "lead_status,"
					+ "qualified_,"
					+ "date_contract_sent,"
					+ "date_contract_signed,"
					+ "incident_date,"
					+ "statute_of_limitations,"
					+ "incident_type,"
					+ "type_of_mva,"
					+ "state_where_accident_occurred,"
					+ "city_where_accident_occurred,"
					+ "county_,"
					+  "what_were_you,"
					+ "description_of_accident,"
					+ "time_of_accident,"
					+ "location_of_accident,"
					+ "weather_and_road_conditions,"
					+ "authorities_called_to_thescene,"
					+ "police_officer_departmentr,"
					+ "police_officer_department_2,"
					+ "policer_report_no,"
					+ "officer_trooper,"
					+ "police_report,"
					+ "citations_issued,"
					+ "citation_type_number,"
					+ "citation_final_disposition,"
					+ "witnesses_,"
					+ "incident_info,"
					+ "did_client_go_to_the_hospital,"
					+ "hospital_,"
					+ "tests_completed,"
					+ "client_transported_in_anambulance,"
					+ "ambulance_,"
					+ "did_incident_result_in_death,"
					+ "date_of_death,"
					+ "host_vehicle_driver,"
					+ "host_vehicle_owner,"
					+ "host_insurance_info,"
					+ "passengers_,"
					+ "passenger_,"
					+ "defendant_driver,"
					+ "defendant_owner,"
					+ "defendant_insurance,"
					+ "client_vehicle_type,"
					+ "clients_vehicle_year_make_model_color,"
					+ "damage_to_clients_vehicle,"
					+ "defendant_vehicle_type,"
					+ "defendants_vehicle_make_model,"
					+ "damage_to_defendants_vehicle,"
					+ "pictures_of_damages,"
					+ "pd_estimate,"
					+ "by_whom_and_where,"
					+ "date_taken,"
					+ "location_of_clients_vehicle,"
					+ "rental_options_own_liab_none,"
					+ "vehicle_towed,"
					+ "towed_by,"
					+ "towed_to,"
					+ "pd_notes,"
					+ "employment_status,"
					+ "job_title_duties,"
					+ "clients_hourly_rate_salary,"
					+ "employer_id,"
					+ "supervisor_id,"
					+ "lost_wages_start,"
					+ "lost_wages_end,"
					+ "concurrent_employment,"
					+ "cc_employer1,"
					+ "cc1_hourly_rate_salary,"
					+ "cc_employer2,"
					+ "cc2_hourly_rate_salary,"
					+ "employment_notes,"
					+ "things_client_can_no_longer_do,"
					+ "things_client_can_do,"
					+ "loss_of_lifes_enjoyment,"
					+ "health_history_overall_health,"
					+ "social_media_accounts,"
					+ "social_media_posting_with_client,"
					+ "red_flags,"
					+ "additional_notes,"
					+ "date_intake_updated,"
					+ "intake_updated_by_who,"
					+ "witnesses_details,"
					+ "witness_,"
					+ "did_you_take_any_scene_photos)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, intakedataexport. getProjectId());
			ps.setString(2, intakedataexport. getDateOfIntaket());
			ps.setString(3, intakedataexport. getPersonPerformingIntake());
			ps.setString(4, intakedataexport. getEmployeePerformingIntake());
			ps.setString(5, intakedataexport. getReferralSource());
			ps.setString(6, intakedataexport. getReferredFrom());
			ps.setString(7, intakedataexport. getReferralSourceFee());
			ps.setString(8, intakedataexport. getLeadStatus());
			ps.setString(9, intakedataexport. getQualiFied());
			ps.setString(10, intakedataexport. getDateContractSent());
			ps.setString(11, intakedataexport. getDateContractSigned());
			ps.setString(12, intakedataexport. getIncidentDate());
			ps.setString(13, intakedataexport. getStatuteOfLimitations());
			ps.setString(14, intakedataexport. getIncidentType());
			ps.setString(15, intakedataexport. getTypeOfMva());
			ps.setString(16, intakedataexport. getStateWhereAccidentOccurred());
			ps.setString(17, intakedataexport. getCityWhereAccidentOccurred());
			ps.setString(18, intakedataexport. getCounty());
			ps.setString(19, intakedataexport. getWhatWereYou());
			ps.setString(20, intakedataexport. getDescriptionOfAccident());
			ps.setString(21, intakedataexport. getTimeofAccident());
			ps.setString(22, intakedataexport. getLocationOfAccident());
			ps.setString(23, intakedataexport. getWeatherAndRoadConditions());
			ps.setString(24, intakedataexport. getAuthoritiesCalledToTheScene());
			ps.setString(25, intakedataexport. getPoliceOfficerDepartmentr());
			ps.setString(26, intakedataexport. getPoliceOfficerDepartmentr2());
			ps.setString(27, intakedataexport. getPolicerReportNo());
			ps.setString(28, intakedataexport. getOfficerTrooper());
			ps.setString(29, intakedataexport. getPoliceReport());
			ps.setString(30, intakedataexport. getCitationsIssued());
			ps.setString(31, intakedataexport. getCitationTypeNumber());
			ps.setString(32, intakedataexport. getCitationFinalDisposition());
			ps.setString(33, intakedataexport. getWitnesses());
			ps.setString(34, intakedataexport. getIncidentInfo());
			ps.setString(35, intakedataexport. getDidClientGoToTheHospital());
			ps.setString(36, intakedataexport. getHospital());
			ps.setString(37, intakedataexport. getTestsCompleted());
			ps.setString(38, intakedataexport. getClientTransportedInanAmbulance());
			ps.setString(39, intakedataexport. getAmbulance());
			ps.setString(40, intakedataexport. getDidIncidentResultInDeath());
			ps.setString(41, intakedataexport. getDateOfDeath());
			ps.setString(42, intakedataexport. getHostVehicleDriver());
			ps.setString(43, intakedataexport. getHostVehicleOwner());
			ps.setString(44, intakedataexport. getHostInsuranceInfo());
			ps.setString(45, intakedataexport. getPassengers());
			ps.setString(46, intakedataexport. getPassenger());
			ps.setString(47, intakedataexport. getDefendantDriver());
			ps.setString(48, intakedataexport. getDefendantOwner());
			ps.setString(49, intakedataexport. getDefendantInsurance());
			ps.setString(50, intakedataexport. getClientVehicleType());
			ps.setString(51, intakedataexport. getClientsVehicleYearMakeModelColor());
			ps.setString(52, intakedataexport. getDamageToClientsVehicle());
			ps.setString(53, intakedataexport. getDefendantVehicleType());
			ps.setString(54, intakedataexport. getDefendantsVehicleMakeModel());
			ps.setString(55, intakedataexport. getDamageToDefendantsVehicle());
			ps.setString(56, intakedataexport. getPicturesOfDamages());
			ps.setString(57, intakedataexport. getPDEstimate());
			ps.setString(58, intakedataexport. getByWhomAndWhere());
			ps.setString(59, intakedataexport. getDateTaken());
			ps.setString(60, intakedataexport. getLocationOfClientsVehicle());
			ps.setString(61, intakedataexport. getRentalOptionsOwnLiabNone());
			ps.setString(62, intakedataexport. getVehicleTowed());
			ps.setString(63, intakedataexport. getTowedBy());
			ps.setString(64, intakedataexport. getTowedTo());
			ps.setString(65, intakedataexport. getPDNotes());
			ps.setString(66, intakedataexport. getEmploymentStatus());
			ps.setString(67, intakedataexport. getJobTitleDuties());
			ps.setString(68, intakedataexport. getClientsHourlyRateSalary());
			ps.setString(69, intakedataexport. getEmployerId());
			ps.setString(70, intakedataexport. getSupervisorId());
			ps.setString(71, intakedataexport. getLostWagesStart());
			ps.setString(72, intakedataexport. getLostWagesEnd());
			ps.setString(73, intakedataexport. getConcurrentEmployment());
			ps.setString(74, intakedataexport. getCCEmployer1());
			ps.setString(75, intakedataexport. getCC1HourlyRateSalary());
			ps.setString(76, intakedataexport. getCCEmployer2());
			ps.setString(77, intakedataexport. getCC2HourlyRateSalary());
			ps.setString(78, intakedataexport. getEmploymentNotes());
			
			ps.setString(79, intakedataexport. getThingsclientcanNoLongerDo());
			ps.setString(80, intakedataexport. getThingsclientCANDo());
			ps.setString(81, intakedataexport. getLossOfLifesEnjoyment());
			ps.setString(82, intakedataexport. getHealthHistoryOverallHealth());
			ps.setString(83, intakedataexport. getSocialMediaAccounts());
			ps.setString(84, intakedataexport. getSocialMediaPostingWithClient());
			ps.setString(85, intakedataexport. getRedFlags());
			ps.setString(86, intakedataexport. getAdditionalNotes());
			ps.setString(87, intakedataexport. getDateIntakeUpdated());
			ps.setString(88, intakedataexport. getIntakeUpdatedByWho());
			
			ps.setString(89, intakedataexport.  getWitnessesDetails());
			ps.setString(90, intakedataexport.  getWitness());
			ps.setString(91, intakedataexport.  getDidYouTakeAnyScenePhotos());
//			ps.setBoolean(60, intakedataexport.  getCriminalHistory());		
//			ps.setString(61, intakedataexport.  getDateContractSent());
//			ps.setString(62, intakedataexport.  getDateContractSigned());
//			ps.setString(63, intakedataexport.  getPersonPerformingIntake());
	ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ intakedataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ intakedataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	}
	
}
	
	


	

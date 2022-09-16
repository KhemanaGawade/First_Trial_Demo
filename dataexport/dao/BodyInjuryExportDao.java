package com.filevine.dataexport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.BodyInjuryExport;


import util.DBProvider;

public class BodyInjuryExportDao {

public void insertBodyInjuryData(String databaseName, BodyInjuryExport bodyInjuryexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_bodyinjury_Data_export("
					+ "project_id,"					
					+ "injuriessu_stained,"
					+ "permanent_injuryor_scarring,"
					+ "describe_injurie_ssustained_paincomplaints,"
					+ "pictures_taken_of_injuries,"
				//	+ "pictures_of_injuries,"
					+ "treatment_info,"
					+ "primary_care_physician,"
					+ "health_insurance,"
					+ "medicare_medicaid,"
					+ "prior_treatment_docinfo,"
					+ "prior_incidents,"
					+ "prior_incident_info,"
					+ "criminal_history,"
					+ "criminal_history_details,"
					+ "negligence_notes)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			ps=conn.prepareStatement(sql);
				
			
			ps.setInt(1,    bodyInjuryexport.getProjectId());
			ps.setString(2,  bodyInjuryexport.  getInjuriesSustained());
			ps.setString(3, bodyInjuryexport.  getPermanentInjuryOrScarring());
			ps.setString(4,  bodyInjuryexport.  getDescribeInjuriesSustainedPainComplaints());
			ps.setString(5, bodyInjuryexport.  getPicturestakenofInjuries());
	//		ps.setString(5, bodyInjuryexport.  getPicturesOfInjuries());
			ps.setString(6,  bodyInjuryexport.  getTreatmentInfo());
			ps.setString(7,  bodyInjuryexport.   getPrimarycarePhysician());
			ps.setString(8, bodyInjuryexport.    getHealthInsurance());
			ps.setString(9,  bodyInjuryexport.  getMedicareMedicaid());
			ps.setString(10, bodyInjuryexport.  getPriorTreatmentdocInfo());
			ps.setString(11, bodyInjuryexport.  getPriorIncidents());
			ps.setString(12, bodyInjuryexport.  getPriorIncidentInfo());
			ps.setString(13, bodyInjuryexport.  getCriminalHistory());
			ps.setString(14, bodyInjuryexport.  getCriminalHistoryDetails());
			ps.setString(15, bodyInjuryexport.  getNegligenceNotes());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ bodyInjuryexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ bodyInjuryexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
			
			
}
}
	
	
		
	
	
	
	
	
	
	
	
	
	


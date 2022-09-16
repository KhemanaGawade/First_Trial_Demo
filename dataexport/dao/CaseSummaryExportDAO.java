package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import util.DBProvider;
import com.filevine.dataexport.domain.CaseSummaryExport;

/**
 * This is Dao class used for database operation for case summary details
*/
public class CaseSummaryExportDAO {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	/**
	 * Inserting all CaseSummaryExport class values into database case summary table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertCaseSummaryData(String database,CaseSummaryExport caseSummaryExport) throws Exception
	{
		MDC.put("path", "File Vine:: Notes Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_case_summary(" + 
					"project_id," + 
					"date_of_accident," +
					"statute_of_limitations_dateValue," +
					"statute_of_limitations_doneDate," + 
					"notes," + 
					"type_of_case  ," +
					"synopsis," + 
					"defendant_citation_description," + 
					"police_department," + 
					"police_report," + 
					" citation_description,"+
					"firstdateoftreatment,"+
					"lastdateoftreatment,"
					+ "demandsent,"
					+"finalstlmt,"
					+"defendant_id,"
					+"plantiff_id,"
					+"co_counsel_id,"
					+ "cocounselfirm_id,"
					+"courtHouse_id,"
					+"judge_id,"
					+"paralegal_id,"
					+"primary_attorney_id,"
					+"caseNumber)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,caseSummaryExport.getProjectId());
			ps.setString(2, caseSummaryExport.getDateOfAccident());
			ps.setString(3, caseSummaryExport.getStatuteOfLimitationsDate());
			ps.setString(4, caseSummaryExport.getStatuteOfLimitationsDue());
			ps.setString(5, caseSummaryExport.getNotes());
			ps.setString(6, caseSummaryExport.getTypeOfCase());
			ps.setString(7, caseSummaryExport.getSynopsis());
			ps.setString(8, caseSummaryExport.getDefendantCitationDescription());
			ps.setString(9, caseSummaryExport.getPoliceDepartment());
			ps.setString(10, caseSummaryExport.getPoliceReport());
			ps.setString(11, caseSummaryExport.getCitationDescription());
			ps.setString(12, caseSummaryExport.getFirstdateoftreatment());
			ps.setString(13, caseSummaryExport.getLastdateoftreatment());
			ps.setString(14, caseSummaryExport.getDemandsent());
			ps.setString(15, caseSummaryExport.getFinalstlmt());
			ps.setString(16, caseSummaryExport.getDefendantId());
			ps.setString(17, caseSummaryExport.getPlantiffId());
			ps.setString(18, caseSummaryExport.getCo_counselId());
			ps.setString(19, caseSummaryExport.getCocounselfirm_id());
			ps.setString(20, caseSummaryExport.getCourthouse_id());
			ps.setString(21, caseSummaryExport.getJudgeId());
			ps.setString(22, caseSummaryExport.getParalegalId());
			ps.setString(23, caseSummaryExport.getPrimaryAttorneyId());
			ps.setString(24, caseSummaryExport.getCaseNumber());
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ caseSummaryExport.getProjectId());
		} catch (Exception e) {
			
			errorLogger.error(e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
	
		
	}

	public void insertCaseDetailsData(CaseSummaryExport caseExport, String databaseName) throws SQLException {
		MDC.put("path", "File Vine:: Notes Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_case_details(" + 
					"project_id," + 
					"field_name," +
					"friendly_name," +
					"field_type," + 
					"field_value," + 
					"position," + 
					"link_ref_value)values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,caseExport.getProjectId());
			ps.setString(2, caseExport.getFieldName());
			ps.setString(3, caseExport.getFriendlyName());
			ps.setString(4, caseExport.getFieldType());
			ps.setString(5, caseExport.getFieldValue());
			ps.setString(6, caseExport.getPosition());
			ps.setString(7, caseExport.getLinkRefValue());
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ caseExport.getProjectId());
		} catch (Exception e) {
			
			errorLogger.error(e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
	}

	public void insertCasedetailsData(String databaseName, CaseSummaryExport caseExport) throws SQLException {
		MDC.put("path", "File Vine:: Notes Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_case_summaryDetails(" + 
					"project_id," + 
					"description," +
					"estimated_settlementvalu," +
					"incident_date," + 
					"phase_date," + 
					"ssn_number,"
					+ "email_address,"
					+ "project_typeName,"
					+ "org_name,"
					+ "isBillingEnabled,"
					+ "project_name,"
					+ "phase_namr,"
					+ "firstdateoftreatment,"
					+ "lastdateoftreatment)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,caseExport.getProjectId());
			ps.setString(2, caseExport.getDescription());
			ps.setString(3, caseExport.getEstimated_settlementvalu());
			ps.setString(4, caseExport.getIncident_date());
			ps.setString(5, caseExport.getPhase_date());
			ps.setString(6, caseExport.getSsn_number());
			ps.setString(7, caseExport.getEmailAddress());
			ps.setString(8, caseExport.getProjectTypeName());
			ps.setString(9, caseExport.getOrgName());
			ps.setString(10, caseExport.getIsBillingEnabled());
			ps.setString(11, caseExport.getProjectName());
			ps.setString(12, caseExport.getPhaseName());
			ps.setString(13, caseExport.getFirstdateoftreatment());
			ps.setString(14, caseExport.getLastdateoftreatment());
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ caseExport.getProjectId());
		} catch (Exception e) {
			
			errorLogger.error(e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
		
	}
}

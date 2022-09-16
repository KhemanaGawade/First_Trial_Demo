package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.MDC;
import com.filevine.dataexport.domain.CaseSummaryExportData;
import util.DBProvider;

public class CaseSummaryExportDataDao {

	
	public void insertCaseSummaryData(String databaseName, CaseSummaryExportData casesummaryexportdata ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_casesummarydata_export("
					+ "project_id,"
					+ "judge_,"
					+ "court_house,"
					+ "case_,"
					+ "county_,"
					+ "schedu_ling_order,"
					+ "legal_assistant,"
					+ "type_of_court,"
					+ "primary_attorney,"
					+ "assigned_paralegal,"
					+ "statute_of_limitations_duedate,"
					+ "statute_of_limitations_donedate,"
					+ "second_statute_of_limitations_duedate,"
					+ "second_statute_of_limitations_donedate,"
					+ "projected_recovery_date,"
					+ "projected_recovery_goal,"
					+ "presuit_or_suit_filed,"
					+ "settled_,"
					+ "co_counsel_fees,"
					+ "partial_settlement,"
					+ "verdict_,"
					+ "case_fees_amount,"
					+ "case_fees_details,"
					+ "client_dispersal_date,"
					+ "case_notes_1,"	
				//	+ "partial_settlement_amount,"
					//+ "partial_settlement_date,"
					+ "case_notes_2,"
					+ "partial_settlement_amount,"
					+ "partial_settlement_date)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, casesummaryexportdata.getProjectId());
			ps.setString(2,  casesummaryexportdata.getJudge());
			ps.setString(3,  casesummaryexportdata.getCourthouse());
			ps.setString(4,  casesummaryexportdata.getCase());
			ps.setString(5,  casesummaryexportdata.getCounty());
			ps.setString(6, casesummaryexportdata.getSchedulingOrder());
			ps.setString(7,  casesummaryexportdata.getLegalAssistant());
			ps.setString(8,  casesummaryexportdata.getTypeOfCourt());
			ps.setString(9,  casesummaryexportdata.getPrimaryAttorney());
			ps.setString(10, casesummaryexportdata.getAssignedParalegal());
			ps.setString(11,  casesummaryexportdata.getStatuteOfLimitationsDueDate());
			ps.setString(12,  casesummaryexportdata.getStatuteOfLimitationsDoneDate());
			ps.setString(13,  casesummaryexportdata.getSecondstatuteOfLimitationsDueDate());
			ps.setString(14, casesummaryexportdata.getSecondStatuteOfLimitationsDoneDate());
			ps.setString(15, casesummaryexportdata.getProjectedRecoveryDate());
			ps.setString(16, casesummaryexportdata.getProjectedRecoveryGoal());
			ps.setString(17, casesummaryexportdata.getPresuitOrSuitFiled());
			ps.setString(18,  casesummaryexportdata.getSettled());
			ps.setString(19,  casesummaryexportdata.getCoCounselFees());
			ps.setString(20,  casesummaryexportdata.getPartialSettlement());
			ps.setBoolean(21,  casesummaryexportdata.isVerdict());
			ps.setString(22, casesummaryexportdata.getCaseFeesAmount());
			ps.setString(23,  casesummaryexportdata.getCaseFeesDetails());
		//	ps.setString(24,  casesummaryexportdata.getPayDateDue());
			ps.setString(24,  casesummaryexportdata.getClientDispersalDate());
			ps.setString(25, casesummaryexportdata.getCaseNotes1());
			ps.setString(26,  casesummaryexportdata.getCaseNotes2());
			ps.setString(27,  casesummaryexportdata.getPartialSettlementAmount());
			ps.setString(28,  casesummaryexportdata.getPartialSettlementDate());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ casesummaryexportdata.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ casesummaryexportdata.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
}

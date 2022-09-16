package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.FileVineGhoshehLawCaseSummaryExport;

import util.DBProvider;

public class FileVineGhoshehLawCaseSummaryDao {

	
	public void insertFileVineGhoshehLawCaseSummaryData(String databaseName, FileVineGhoshehLawCaseSummaryExport filevineghoshehlawcasesummaryexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_ghoshehlaw_summary_data_export("
					+ "project_id,"
					+ "projected_settlement_date,"
					+ "actual_settlement_date,"
					+ "projected_settlement_goal,"
					+ "actual_settlement_amount,"
					+ "case_fees_amount,"
					+ "case_fees_details,"
					+ "client_dispersal_date,"
					+ "primary_attorney_id,"
					+ "org_id,"
					+ "primary_attorney_fullname,"
					+ "paralegal_id,"
					+ "paralegal_full_name,"
					+ "co_counsel_id,"
					+ "co_counsel_firm_id,"
					+ "statute_of_limitations_due_date,"
                    + "statute_of_limitations_done_date,"
                    + "demand_sent_date,"
                    + "complaint_filed_date,"
					+ "court_date,"
					+ "judge_full_name,"
                    + "court_house_full_name,"
                    + "case_,"
                    + "at_fault_claim_no)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, filevineghoshehlawcasesummaryexport .getProjectId());
			ps.setString(2,  filevineghoshehlawcasesummaryexport .getProjectedSettlementDate());
			ps.setString(3,  filevineghoshehlawcasesummaryexport .getActualSettlementDate());
			ps.setString(4,  filevineghoshehlawcasesummaryexport .getProjectedSettlementGoal());
			ps.setString(5,  filevineghoshehlawcasesummaryexport .getActualSettlementAmount());
			ps.setString(6, filevineghoshehlawcasesummaryexport .getCaseFeesAmount());
			ps.setString(7,  filevineghoshehlawcasesummaryexport .getCaseFeesDetails());
			ps.setString(8,  filevineghoshehlawcasesummaryexport .getClientDispersalDate());
			ps.setString(9, filevineghoshehlawcasesummaryexport .getPrimaryAttorneyId());
			ps.setString(10, filevineghoshehlawcasesummaryexport.getOrgId());
			ps.setString(11, filevineghoshehlawcasesummaryexport.getPrimaryAttorneyFullName());
			ps.setString(12, filevineghoshehlawcasesummaryexport.getParalegalId());
			ps.setString(13, filevineghoshehlawcasesummaryexport.getParalegalFullName());
			ps.setString(14,  filevineghoshehlawcasesummaryexport.getCoCounselId());
			ps.setString(15,  filevineghoshehlawcasesummaryexport.getCoCounselFirmId());
			ps.setString(16, filevineghoshehlawcasesummaryexport. getStatuteOfLimitationsDueDate());
			ps.setString(17,  filevineghoshehlawcasesummaryexport.getStatuteOfLimitationsDoneDate());
			ps.setString(18,  filevineghoshehlawcasesummaryexport.getDemandSentDate());
			ps.setString(19, filevineghoshehlawcasesummaryexport. getComplaintFiledDate());
			ps.setString(20, filevineghoshehlawcasesummaryexport.getCourtDate());
			ps.setString(21,  filevineghoshehlawcasesummaryexport.getJudgeFullName());
			ps.setString(22,  filevineghoshehlawcasesummaryexport.getCourtHouseFullName());
			ps.setString(23, filevineghoshehlawcasesummaryexport. getCase());
			ps.setString(24, filevineghoshehlawcasesummaryexport.getAtFaultClaimNo());
//			
//			ps.setString(16, advanceclientcostexport.getCheckNumber());
//			ps.setString(17, advanceclientcostexport.getRecordsReceived());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ filevineghoshehlawcasesummaryexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ filevineghoshehlawcasesummaryexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}

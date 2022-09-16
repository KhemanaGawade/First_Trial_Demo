package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.LitigationDataExports;

import util.DBProvider;

public class LitigationDataExportDao {

	public void insertLitigationData(String databaseName, LitigationDataExports litigationdataexports ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_litigation_Data_export("
					+ "project_id,"
					+ "caption_plaintiffs,"
					+ "caption_defendants,"
					+ "date_filed,"
					+ "county_,"
					//+ "amount_paid,"
					+ "judicial_district,"
					+ "case_,"
					+ "court_house,"
					+ "judge_,"
					+ "case_management_conference_set_for,"
					+ "time_of_cmc,"
					+ "cmc_location,"
					//+ "check_number,"
					+ "case_management_order_received,"
					+ "mandatory_settlement_conference_Set_For,"
					+ "Time_Of_Msc,"
					+ "msc_location)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, litigationdataexports.getProjectId());
			ps.setString(2,  litigationdataexports.getCaptionPlainTiffs());
			ps.setString(3,  litigationdataexports.getCaptionDefendants());
			ps.setString(4,  litigationdataexports.getDateFiled());
			ps.setString(5, litigationdataexports. getCounty());
			ps.setString(6, litigationdataexports.getJudicialDistrict());
			ps.setString(7,  litigationdataexports.getCase());
			ps.setString(8,  litigationdataexports.getCourtHouse());
			ps.setString(9,  litigationdataexports.getJudge());
			ps.setString(10, litigationdataexports.getCaseManagementConferenceSetFor());
			ps.setString(11,  litigationdataexports. getTimeofCmc());
			ps.setString(12,  litigationdataexports.getCmcLocation());
			ps.setString(13,  litigationdataexports.getCaseManagementOrderReceived());
			ps.setString(14, litigationdataexports.getMandatorySettlementConferenceSetFor());
			ps.setString(15, litigationdataexports.getTimeOfMsc());
			//ps.setString(16, advanceclientcostexport.getCheckNumber());
			ps.setString(16, litigationdataexports.getMscLocation());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ litigationdataexports.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ litigationdataexports.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


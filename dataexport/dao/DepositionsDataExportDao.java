package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.DepositionsDataExport;
import com.filevine.dataexport.domain.DiscoveryDataExport;

import util.DBProvider;

public class DepositionsDataExportDao {

	
public void insertDepositionsData(String databaseName,DepositionsDataExport  depositionsdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_depositions_data_export("
					+ "project_id,"
					+ "deponent_,"
					+ "our_client_expert,"
					+ "prep_needed,"
					+ "attorney_taking_defending_depo,"
					+ "date_of_depo_prep,"
					+ "time_of_depo_prep,"
					+ "depo_prep_notes,"
					+ "date_scheduled,"
					+ "time_,"
					+ "location_,"
					+ "general_notes,"
					+ "deposition_transcript_receipt_due_date,"
					+ "deposition_transcript_receipt_done_date ,"
					+ "errata_sheet_needed,"
					+ "court_reporter,"
					+ "datecourt_reporter_confirmed,"
					+ "video_grapher,"
					+ "date_video_grapher_confirmed,"
					+ "date_depo_notice_served_on_op)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
				
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1,depositionsdataexport.getProjectId());
			ps.setString(2,  depositionsdataexport.getDeponent());
			ps.setString(3, depositionsdataexport.getOurClientExpert());
			ps.setString(4,  depositionsdataexport.getPrepNeeded());
			ps.setString(5,  depositionsdataexport.getAttorneyTakingDefendingDepo());
			ps.setString(6, depositionsdataexport.getDateOfDepoPrep());
			ps.setString(7, depositionsdataexport.getTimeOfDepoPrep());
			ps.setString(8, depositionsdataexport. getDepoPrepNotes());
			ps.setString(9,  depositionsdataexport.getDateScheduled());
			ps.setString(10,  depositionsdataexport.getTime());
			ps.setString(11,  depositionsdataexport.getLocation());
			ps.setString(12, depositionsdataexport.getGeneralNotes());
			ps.setString(13,  depositionsdataexport.getDepositionTranscriptReceiptDoneDate());
			ps.setString(14,  depositionsdataexport.getDepositionTranscriptReceiptDueDate());
			ps.setString(15, depositionsdataexport.getErrataSheetNeeded());
			ps.setString(16, depositionsdataexport.getCourtReporter());
			ps.setString(17, depositionsdataexport.getDatecourtReporterConfirmed());
			ps.setString(18,  depositionsdataexport.getVideoGrapher());
			ps.setString(19,  depositionsdataexport.getDateVideoGrapherConfirmed());
			ps.setString(20, depositionsdataexport.getDateDepoNoticeServedOnOp());
			

			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+  depositionsdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+  depositionsdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
}
	
	
	
	
}

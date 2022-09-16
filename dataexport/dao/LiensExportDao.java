package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.LiensExport;

import util.DBProvider;

public class LiensExportDao {

	public void insertLiensExportData(String databaseName, LiensExport liensexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			
			String sql="insert into "+databaseName+".filevine_liensdata_export("
					+ "project_id,"
					+ "type_of_lien,"
					+ "reference_number,"
					+ "notice_date_received,"
					+ "amount_,"
					//+ "amount_paid,"
					+ "finallien_received_date,"
					+ "letter_of_repsent_date,"
					+ "reduction,"
					+ "notes,"
					+ "lien_holder,"
					+ "recovery_agency,"
					+ "recovery_agent,"
					+ "documents_id,"
					+ "documents_file_name)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			
			//String sql="insert into "+databaseName+".filevine_liensdata_export("
				//	+ "project_id,"
//					+ "type_of_lien,"
//					+ "reference_number,"
//					+ "notice_date_received,"
//					+ "amount_,"
//					+ "finallien_received_date,"
//					+ "letter_of_repsent_date,"
//					+ "reduction,"
//					+ "notes,"
//					+ "lien_holder,"
//					+ "recovery_agency,"
//					+ "recovery_agent)value(?,?,?,?,?,?,?,?,?,?,?,?,)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, liensexport.getProjectId());
			ps.setString(2,  liensexport.getTypeOfLien());
			ps.setString(3,  liensexport. getReferenceNumber());
			ps.setString(4,  liensexport.getNoticeDateReceived());
			ps.setString(5,  liensexport.getAmount());
			ps.setString(6, liensexport.getFinallienReceivedDate());
			ps.setString(7,  liensexport.getLetterOfRepsentDate());
			ps.setString(8,  liensexport. getReduction());
			ps.setString(9,  liensexport.getNotes());
			ps.setString(10, liensexport.getLienholder());
			ps.setString(11,  liensexport. getRecoveryAgency());
			ps.setString(12,  liensexport.getRecoveryAgent());
			ps.setString(13,  liensexport. getDocumentsId());
			ps.setString(14,  liensexport.getDocumentsFileName());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ liensexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ liensexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	

	
	
}

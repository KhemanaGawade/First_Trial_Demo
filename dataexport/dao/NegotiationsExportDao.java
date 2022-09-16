package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.NegotiationsExport;

import util.DBProvider;

public class NegotiationsExportDao {
//
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertNegotiationsData(NegotiationsExport negotiationsExport, String databaseName) throws Exception {
		
		MDC.put("path", "File Vine:: Negotiations Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_negotiations_export("
					+ "project_id,"
					+ "id,"
					+ "doc_id,"
					+ "doc_name,"
					+ "offer_letter,"
					+ "method_of_offer,"
					+ "to_from_demandId,"
					+ "amount,"
					+ "prior_client_approval,"
					+ "date,"
					+ "expiry_date,"
					+ "demandsent,"
					+ "offerhistory,"
					+ "datedemandsent,"
					+ "createdDate,negotiationtype,notes)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,negotiationsExport.getProjectId());
			ps.setString(2, negotiationsExport.getId());
			ps.setInt(3, negotiationsExport.getDocId());
			ps.setString(4, negotiationsExport.getDocName());
			ps.setString(5, negotiationsExport.getOfferLetter());
			ps.setString(6,negotiationsExport.getMethodOfOffer());
			ps.setInt(7,negotiationsExport.getToFromDemandId());
			ps.setDouble(8,negotiationsExport.getAmount());
			ps.setString(9, negotiationsExport.getPriorClientApproval());
			ps.setString(10, negotiationsExport.getDate());
			ps.setString(11, negotiationsExport.getExpiryDate());
			ps.setString(12, negotiationsExport.getDemandsent());
			ps.setString(13, negotiationsExport.getOfferhistory());
			ps.setString(14, negotiationsExport.getDatedemandsent());
			ps.setString(15, negotiationsExport.getCreatedDate());
			ps.setString(16, negotiationsExport.getNegotiationtype());
			ps.setString(17, negotiationsExport.getNotes());
			
			ps.executeUpdate();
			eventLogger.info("Project id :: "+ negotiationsExport.getProjectId() +" has been exported!!");
			
		}catch(Exception e) {
			errorLogger.error("Project id :: "+ negotiationsExport.getProjectId() +" already exists!!",e);
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

	
}

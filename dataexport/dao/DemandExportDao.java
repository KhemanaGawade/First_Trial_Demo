package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.DemandExport;

import util.DBProvider;

public class DemandExportDao {

	public void insertDemandExportData(String databaseName, DemandExport demandexport  ) throws SQLException {
	
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
	
		try {
			String sql="insert into "+databaseName+".filevine_demanddata_export("
					+ "project_id,"
					+ "Offer_DemandSettled,"
					+ "Amount_,"
					+ "Date_Send,"
					+ "Notes_,"
					//+ "Return_Receipt,"
					//+ "Created_Date,"
					+ "Demand_Status,"
					+ "Liability_Section,"
					+ "Who_Drafted,"
					+ "Date_Drafted,"
					+ "To_From,"
					+ "Done_Date,"
					//+ "Total_Items_Count,"
					+ "DueDate_,"
					+ "Returnreceipt_Id,"
					+ "Returnreceipt_Filename,"
					+ "Docs_Id,"
					+ "Docs_Filename)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, demandexport.getProjectId());
			ps.setString(2,  demandexport.getOfferDemandSettled());
			ps.setString(3,  demandexport. getAmount());
			ps.setString(4,  demandexport.getDateSend());
			ps.setString(5,  demandexport.getNotes());
		//	ps.setString(5,  demandexport.getReturnReceipt());
		//	ps.setString(5,  demandexport.getCreatedDate());
			ps.setString(6, demandexport.getDemandStatus());
			ps.setString(7,  demandexport.getLiabilitySection());
			ps.setString(8,  demandexport.getWhoDrafted());
			ps.setString(9,  demandexport.getDateDrafted());
			ps.setString(10, demandexport.getToFrom());
			ps.setString(11,  demandexport.getDoneDate());
			ps.setString(12,  demandexport.getDueDate());
		//	ps.setInt(13,  demandexport.getTotalItemsCount());
			ps.setString(13,  demandexport.getReturnReceiptId());
			ps.setString(14, demandexport.getReturnReceiptFileName());
			ps.setString(15,  demandexport.getDocsId());
			ps.setString(16,  demandexport.getDocsFileName());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ demandexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ demandexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

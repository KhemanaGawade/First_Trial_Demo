package com.filevine.dataexport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.YieldDataExport;

import util.DBProvider;

public class YieldDataExportDao {

	public void insertYieldData(String databaseName, YieldDataExport yielddataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_yield_data_export("
					+ "project_id,"
					+ "id_,"
					+ "name_,"
					+ "offer_,"
					+ "attorney_perc,"
					+ "attorney_amt,"
					+ "medical_bill_amt,"
					+ "expense_amt,"
					+ "net_to_client,"
					+ "create_date,"
					+ "creator_id,"
					+ "creator_name,"
					+ "notes_,"
					+ "has_custom_meds,"
					+ "has_custom_expense)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, yielddataexport.getProjectId());
			ps.setString(2,  yielddataexport.getId());
			ps.setString(3,  yielddataexport.getName());
			ps.setString(4,  yielddataexport.getOffer());
			ps.setString(5,  yielddataexport.getAttorneyPerc());
			ps.setString(6, yielddataexport.getAttorneyAmt());
			ps.setString(7,  yielddataexport.getMedicalBillAmt());
			ps.setString(8,  yielddataexport.getExpenseAmt());
			ps.setString(9,  yielddataexport.getNetToClient());
			ps.setString(10, yielddataexport.getCreateDate());
			ps.setString(11,  yielddataexport.getCreatorId());
			ps.setString(12,  yielddataexport.getCreatorName());
			ps.setString(13,  yielddataexport.getNotes());
			ps.setString(14, yielddataexport.getHasCustomMeds());
			ps.setString(15, yielddataexport.getHasCustomExpense());
//			ps.setString(16, advanceclientcostexport.getCheckNumber());
//			ps.setString(17, advanceclientcostexport.getRecordsReceived());
//			ps.setString(18, advanceclientcostexport.getDocumentId());
//			ps.setString(19, advanceclientcostexport.getDocumentName());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ yielddataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ yielddataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	}
//		public void insertLinesData(String databaseName, YieldDataExport yielddataexport ) throws SQLException {
//			
//			MDC.put("path", "Firm Central Matter Export");
//			MDC.put("fid", databaseName);
//			Connection conn=DBProvider.getJDBC();
//		
//			PreparedStatement ps=null;
//			try {
//				String sql="insert into "+databaseName+".filevine_line_yield_data_export("
//						+ "project_id,"
//						+ "line_id,"
//						+ "line_name,"
//						+ "amount_,"
//						+ "net_amount,"
//						+ "item_type,"
//						+ "adjust_mentamt,"
//						+ "reduction_percentage,"
//						+ "is_reduction_percentage_locked,"
//						+ "is_excluded,"
//						+ "line_notes)value(?,?,?,?,?,?,?,?,?,?,?,?)";
//				ps=conn.prepareStatement(sql);
//		
//				ps.setString(1, yielddataexport.getProjectId());
//				ps.setString(2, yielddataexport.getLineId());
//				ps.setString(3, yielddataexport.getId());
//				ps.setString(4, yielddataexport.getLineName());
//				ps.setString(5, yielddataexport.getAmount());
//				ps.setString(6, yielddataexport.getNetAmount());
//				ps.setString(7, yielddataexport.getItemType());
//				ps.setString(8, yielddataexport.getAdjustmentAmt());
//				ps.setString(9, yielddataexport.getReductionPercentage());
//				ps.setString(10, yielddataexport.getIsReductionPercentageLocked());
//				ps.setString(11, yielddataexport.getIsExcluded());
//				ps.setString(12, yielddataexport.getLineNotes());
////				ps.setString(12,  advanceclientcostexport.getMethodOfPayment());
////				ps.setString(13,  advanceclientcostexport.getPayDateDone());
////				ps.setString(14, advanceclientcostexport.getPayDateDue());
////				ps.setString(15, advanceclientcostexport.getHowMuchAmountPaid());
////				ps.setString(16, advanceclientcostexport.getCheckNumber());
////				ps.setString(17, advanceclientcostexport.getRecordsReceived());
////				ps.setString(18, advanceclientcostexport.getDocumentId());
////				ps.setString(19, advanceclientcostexport.getDocumentName());
//				
//				ps.executeUpdate();
//				System.out.println("Data  has been exported for ProjectID :: "+ yielddataexport.getProjectId());
//				
//			}catch(Exception e) {
//				System.out.println("Data  all ready  exported for ProjectID :: "+ yielddataexport.getProjectId());
//				e.printStackTrace();
//			}finally {
//				conn.close();
//			}
//		
//		
	
	
	

	
	
	

}


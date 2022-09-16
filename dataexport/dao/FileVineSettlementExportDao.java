package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.FileVineSettlementExport;
import com.filevine.dataexport.domain.YieldExport;

import util.DBProvider;


public class FileVineSettlementExportDao {

	public void insertSettlementData(String databaseName, FileVineSettlementExport filevinesettlementexport) throws SQLException {
	
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_settlement_export("
					+ "project_id,"
					+ "id_,"
					+ "name_,"
					+ "offer_,"
					+ "attorney_perc,"
					//+ "amount_paid,"
					+ "attorney_amt,"
					+ "medical_bill_amt,"
					+ "expense_amt,"
					+ "net_to_client,"
					+ "create_date,"
					+ "creator_id,"
					//+ "check_number,"
					+ "creator_name,"
					+ "notes_,"
					+ "has_custom_meds,"
					+ "has_custom_expense)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, filevinesettlementexport.getProjectId());
			ps.setString(2,  filevinesettlementexport.getId());
			ps.setString(3,  filevinesettlementexport.getName());
			ps.setString(4,  filevinesettlementexport.getOffer());
			ps.setString(5,  filevinesettlementexport.getAttorneyPerc());
			ps.setString(6, filevinesettlementexport.getAttorneyAmt());
			ps.setString(7,  filevinesettlementexport.getMedicalBillAmt());
			ps.setString(8,  filevinesettlementexport.getExpenseAmt());
			ps.setString(9,  filevinesettlementexport.getNetToClient());
			ps.setString(10, filevinesettlementexport.getCreateDate());
			ps.setString(11,  filevinesettlementexport.getCreatorId());
			ps.setString(12,  filevinesettlementexport.getCreatorName());
			ps.setString(13,  filevinesettlementexport.getNotes());
			ps.setBoolean(14, filevinesettlementexport.isHasCustomMeds());
			//ps.setString(15, advanceclientcostexport.getAmountPaid());
			//ps.setString(16, advanceclientcostexport.getCheckNumber());
			ps.setBoolean(15, filevinesettlementexport.isHasCustomExpense());
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ filevinesettlementexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ filevinesettlementexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	}
		public void insertLinesData(FileVineSettlementExport filevinesettlementexport, String databaseName) throws SQLException {
			MDC.put("path", "Firm Central Matter Export");
			MDC.put("fid", databaseName);
			
			Connection conn=DBProvider.getJDBC();
			PreparedStatement ps=null;
			try {
				
				String sql = "insert into "+databaseName+".filevine_settlement_export_2("
				+"project_id,"
				+"line_id,"
				+ "id_,"
				+"line_name,"
				+ " amount_,"
				+ "net_amount,"
			    + "item_type,"
				+"adjustment_amount,"
				+" reduction_percentage ,"
				+" isReduction_percentagelocked ,"
				+"  is_excluded," 
				+" line_notes )values(?,?,?,?,?,?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1,String.valueOf(filevinesettlementexport.getProjectId()));
				ps.setString(2, filevinesettlementexport.getLineId());
				ps.setString(3, filevinesettlementexport.getId());
				ps.setString(4, filevinesettlementexport.getLineName());
				ps.setString(5, filevinesettlementexport.getAmount());
				ps.setString(6, filevinesettlementexport.getNetAmount());
				ps.setString(7,filevinesettlementexport.getItemType());
				ps.setString(8, filevinesettlementexport.getAdjustmentAmt());
				ps.setString(9, filevinesettlementexport.getReductionPercentage());
				ps.setBoolean(10, filevinesettlementexport.isReductionPercentageLocked());
				ps.setBoolean(11, filevinesettlementexport.isExcluded());
				ps.setString(12,filevinesettlementexport.getLineNotes());
				ps.executeUpdate();
				System.out.println("Data  has been exported for ProjectID :: "+ filevinesettlementexport.getProjectId());
			} catch (Exception e) {
				System.out.println("Data  all ready  exported for ProjectID :: "+ filevinesettlementexport.getProjectId());
				e.printStackTrace();
				
				
			}
		finally {
			conn.close();
		}
		}
	
}

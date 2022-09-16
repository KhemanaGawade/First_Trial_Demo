package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.YieldExport;

import util.DBProvider;

public class YieldExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertLinesData(YieldExport yieldExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_yield_export(" +
					"project_id,"+
					"id," + 
					"name_," +
					"offer," + 
					" attorny_percentage," + 
					"attorny_amount," + 
					"medical_bill_amount," +
					"expense_amount," +
					" nettoClient ," +
					" create_date ," +
					"  creator_id," +
					" creator_name," +
					" notes," +
					" hasCustomMeds," +
					" hasCustomExpense)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,String.valueOf(yieldExport.getProjectId()));
			ps.setString(2, yieldExport.getId());
			ps.setString(3, yieldExport.getName());
			ps.setString(4, yieldExport.getOffer());
			ps.setString(5, yieldExport.getAttorneyPerc());
			ps.setString(6, yieldExport.getAttorneyAmt());
			ps.setString(7, yieldExport.getMedicalBillAmt());
			ps.setString(8, yieldExport.getExpenseAmt());
			ps.setString(9, yieldExport.getNetToClient());
			ps.setString(10, yieldExport.getCreateDate());
			ps.setString(11, yieldExport.getCreatorId());
			ps.setString(12, yieldExport.getCreatorName());
			ps.setString(13, yieldExport.getNotes());
			ps.setString(14, yieldExport.getHasCustomMeds());
			ps.setString(15, yieldExport.getHasCustomExpense());
						
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ yieldExport.getProjectId());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			errorLogger.error(e);
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
		
	}

	public void insertYieldData(YieldExport yieldExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_lineYield_export(" +
					"project_id,"+
					"line_id," + 
					"id," +
					"line_name," + 
					" amount," + 
					"net_amount," + 
					"item_type," +
					"adjustment_amount," +
					" reductionPercentage ," +
					" isReductionPercentageLocked ," +
					"  isExcluded," +
					" lineNotes)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,String.valueOf(yieldExport.getProjectId()));
			ps.setString(2, yieldExport.getLineId());
			ps.setString(3, yieldExport.getId());
			ps.setString(4, yieldExport.getLineName());
			ps.setString(5, yieldExport.getAmount());
			ps.setString(6, yieldExport.getNetAmount());
			ps.setString(7, yieldExport.getItemType());
			ps.setString(8, yieldExport.getAdjustmentAmt());
			ps.setString(9, yieldExport.getReductionPercentage());
			ps.setString(10, yieldExport.getIsReductionPercentageLocked());
			ps.setString(11, yieldExport.getIsExcluded());
			ps.setString(12, yieldExport.getLineNotes());
									
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ yieldExport.getProjectId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorLogger.error(e);
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
		
	}

}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.LitigationExport;

import util.DBProvider;

public class LitigationExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertVisibleDatesData(LitigationExport litigationExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_litigation_visibleDates(" + 
					"project_id," + 
					"id," +
					"visibleDateId," + 
					"dueDate," + 
					"doneDate,"
					+ "chainDateTypeID,"
					+ "name_,"
					+ "behavior,"
					+ "notes,"
					+ "chainDateTypeUrl,"
					+ "chainDateTypeNotes)values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,litigationExport.getProjectId());
			ps.setString(2, litigationExport.getId());
			ps.setString(3, litigationExport.getVisibleDateId());
			ps.setString(4, litigationExport.getDueDate());
			ps.setString(5, litigationExport.getDoneDate());
			ps.setString(6, litigationExport.getChainDateTypeID());
			ps.setString(7, litigationExport.getVisibleDateName());
			ps.setString(8, litigationExport.getBehavior());
			ps.setString(9, litigationExport.getNotes());
			ps.setString(10, litigationExport.getChainDateTypeUrl());
			ps.setString(11, litigationExport.getChainDateTypeNotes());


			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ litigationExport.getProjectId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorLogger.error(e);
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
		
	}

	public void insertLitigationData(LitigationExport litigationExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_litigation_export(" + 
					"project_id," + 
					"id," +
					"mainDate," + 
					"name_," + 
					"chainTypeName,"
					+ "chainTypeID,"
					+ "chainTypeUrl,"
					+ "chainTypeNotes,"
					+ "chainTypeJurisdictionName)values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,litigationExport.getProjectId());
			ps.setString(2, litigationExport.getId());
			ps.setString(3, litigationExport.getMainDate());
			ps.setString(4, litigationExport.getName());
			ps.setString(5, litigationExport.getChainTypeName());
			ps.setString(6, litigationExport.getChainTypeID());
			ps.setString(7, litigationExport.getChainTypeUrl());
			ps.setString(8, litigationExport.getChainTypeNotes());
			ps.setString(9, litigationExport.getChainTypeJurisdictionName());
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ litigationExport.getProjectId());
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

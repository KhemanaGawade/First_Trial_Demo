package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.LitigationLogExport;

import util.DBProvider;

public class LitigationLogExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertLitigationLogData(String databaseName, LitigationLogExport litigationLogExport) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_WrittenDisc_export(" + 
					"project_id," + 
					"id," +
					"inout_," + 
					"type_," + 
					"notes,"
					+ "createdDate,"
					+ "responseDateValue,"
					+ "responseDoneDate,done,title,drafter_id)values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,litigationLogExport.getProjectId());
			ps.setString(2, litigationLogExport.get_id());
			ps.setString(3, litigationLogExport.getInout());
			ps.setString(4, litigationLogExport.getType());
			ps.setString(5, litigationLogExport.getNotes());
			ps.setString(6, litigationLogExport.getCreatedDate());
			ps.setString(7, litigationLogExport.getResponseDateValue());
			ps.setString(8, litigationLogExport.getResponseDoneDate());
			ps.setString(9, litigationLogExport.getDone());
			ps.setString(10, litigationLogExport.getTitle());
			ps.setString(11, litigationLogExport.getDrafter_id());
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ litigationLogExport.getProjectId());
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

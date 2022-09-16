package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.DeposExport;

import util.DBProvider;

/**
 * This is Dao class used for database operation for depos details
*/
public class DeposExportDao {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	/**
	 * Inserting all DeposExport class values into database depos table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertDeposData(DeposExport deposExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_depos_export(" + 
					"project_id," + 
					"id," +
					"deponent," + 
					"generalNote," + 
					"createdDate)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,deposExport.getProjectId());
			ps.setString(2, deposExport.getId());
			ps.setString(3, deposExport.getDeponent());
			ps.setString(4, deposExport.getGeneralNote());
			ps.setString(5, deposExport.getCreatedDate());

			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ deposExport.getProjectId());
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

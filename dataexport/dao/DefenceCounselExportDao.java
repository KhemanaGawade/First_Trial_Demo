package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.DefenceCounselExport;

import util.DBProvider;

/**
 * This is Dao class used for database operation for defence counsel details
*/
public class DefenceCounselExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	/**
	 * Inserting all DefenceCounselExport class values into database case summary table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertDefenceCounselData(DefenceCounselExport defenceCounselExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_defenceCounsel_export(" + 
					"project_id," + 
					"firmNameId," +
					"leadcounselId," + 
					"paralegalId," + 
					"assistantattorneyId,"
					+ "legalassistantId,"
					+ "notes,"
					+ "createdDate,"
					+ "id)values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,defenceCounselExport.getProjectId());
			ps.setString(2, defenceCounselExport.getFirmNameId());
			ps.setString(3, defenceCounselExport.getLeadcounselId());
			ps.setString(4, defenceCounselExport.getParalegalId());
			ps.setString(5, defenceCounselExport.getAssistantattorneyId());
			ps.setString(6, defenceCounselExport.getLegalassistantId());
			ps.setString(7, defenceCounselExport.getNotes());
			ps.setString(8, defenceCounselExport.getCreatedDate());
			ps.setString(9, defenceCounselExport.getId());

			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ defenceCounselExport.getProjectId());
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

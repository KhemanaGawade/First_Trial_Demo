package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.PlntfsDiscExport;

import util.DBProvider;

public class PlntfsDiscExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertPlntfsDiscData(PlntfsDiscExport plntfsDiscExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_plnthsDisc_export(" + 
					"project_id," + 
					"notes," +
					"disclosure_date," + 
					"id," + 
					"created_date)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,plntfsDiscExport.getProjectId());
			ps.setString(2, plntfsDiscExport.getNotes());
			ps.setString(3, plntfsDiscExport.getDisclosuredate());
			ps.setString(4, plntfsDiscExport.getId());
			ps.setString(5, plntfsDiscExport.getCreatedDate());

			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ plntfsDiscExport.getProjectId());
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

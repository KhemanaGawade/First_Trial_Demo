package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.ClientIntakeExport;

import util.DBProvider;

public class ClientIntakeExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertClientIntakeData(ClientIntakeExport clientIntakeExport, String databaseName) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+databaseName+".filevine_clientIntake_export(" + 
					"projectId," + 
					"clienthasanumber," +
					"clienthasstateidnumber," + 
					"anumber," + 
					"stateidnumber,"
					+ "language_,"
					+ "currenttitle,"
					+ "currentemployer,"
					+ "referralsource,"
					+ "dateofintake,"
					+ "createdDate)values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,clientIntakeExport.getProjectId());
			ps.setString(2, clientIntakeExport.getClienthasanumber());
			ps.setString(3, clientIntakeExport.getClienthasstateidnumber());
			ps.setString(4, clientIntakeExport.getAnumber());
			ps.setString(5, clientIntakeExport.getStateidnumber());
			ps.setString(6, clientIntakeExport.getLanguage_());
			ps.setString(7, clientIntakeExport.getCurrenttitle());
			ps.setString(8, clientIntakeExport.getCurrentemployer());
			ps.setString(9, clientIntakeExport.getReferralsource());
			ps.setString(10, clientIntakeExport.getDateofintake());
			ps.setString(11, clientIntakeExport.getCreatedDate());

			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ clientIntakeExport.getProjectId());
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

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.BillingDataExport;
import com.filevine.dataexport.domain.TimeTrackingDataExport;

import util.DBProvider;

public class TimeTrackingDataExportDao {

public void insertBillingData(String databaseName,TimeTrackingDataExport timetrackingdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_time_tracking_data_export("
					+ "project_id,"
					+ "time_worked,"
					+ "date_,"
					+ "work_done,"
					+ "user_id,"
					+ "user_full_name,"
					+ "id_,"
					+ "created_date)value(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, timetrackingdataexport  .getProjectId());
			ps.setString(2,  timetrackingdataexport  .getTimeWorked());
			ps.setString(3, timetrackingdataexport  .getDate());
			ps.setString(4, timetrackingdataexport  .getWorkDone());
			ps.setString(5,  timetrackingdataexport  .getUserId());
			ps.setString(6, timetrackingdataexport .getUserFullName());
			ps.setString(7, timetrackingdataexport .getId());
			ps.setString(8, timetrackingdataexport .getCreatedDate());
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+  timetrackingdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ timetrackingdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
}
	
}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.ReminderExport;

import util.DBProvider;

public class ReminderExportDao {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertReminderData(String database, ReminderExport reminderExport) throws SQLException {
        MDC.put("path", "File Vine:: Reminder Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+database+".filevine_reminder("
					+ "reminder_id,"
					+ "project_id,"
					+ "name_,"
					+ "notes,"
					+ "dueDate,"
					+ "doneDate)"
					+ "value(?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setString(1,reminderExport.getProjectId());
			ps.setString(2, reminderExport.getReminderId());
			ps.setString(3, reminderExport.getName());
			ps.setString(4, reminderExport.getNotes());
			ps.setString(5, reminderExport.getDueDate());
			ps.setString(6,reminderExport.getDoneDate());
			ps.executeUpdate();
//			System.out.println("Team id :: "+ teamsExport.getTeamId() +" has been exported!!");
			eventLogger.info("Reminder id :: "+ reminderExport.getReminderId() +" has been exported!!");
			
		}catch(Exception e) {
			errorLogger.error("Invalid data !!",e);
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
	}

}

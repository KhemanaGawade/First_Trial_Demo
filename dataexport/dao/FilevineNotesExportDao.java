package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.NotesExport;

import util.DBProvider;

public class FilevineNotesExportDao {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertDataNotes(String databasename, NotesExport notesExport) throws Exception {
		
		MDC.put("path", "File Vine:: Notes Export");
	
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databasename+".filevine_notes_export("
					+ "ID,"
					+ "project_id,"
					+ "target_date,"
					+ "body,"
					+ "created_at,"
					+ "userId,"
					+ "userName,"
					+ "type_tag,"
					+ "assignee_id,"
					+ "assignee_name,"
					+ "assignee_type)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,notesExport.getId());
			ps.setInt(2, notesExport.getProjectId());
			ps.setString(3, notesExport.getTargetDate());
			ps.setString(4, notesExport.getBody());
			ps.setString(5, notesExport.getCreatedAt());
			ps.setInt(6, notesExport.getUserId());
			ps.setString(7, notesExport.getUserName());
			ps.setString(8, notesExport.getTypeTag());
			ps.setInt(9, notesExport.getAssigneeId());
			ps.setString(10, notesExport.getAssigneeName());
			ps.setString(11, notesExport.getAssigneeUser());
			
			ps.executeUpdate();
			eventLogger.info("Note id :: "+ notesExport.getId() +" has been exported!!");
		}catch(Exception e) {
			errorLogger.error("Note id :: "+ notesExport.getId() +" already exists !!",e);
		//	e.printStackTrace();
		}finally {
			conn.close();
		}
	}

	public ArrayList<Integer> getProjectIdList(String databaseName) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Integer> projectIdList=new ArrayList<Integer>();
		Connection conn=DBProvider.getJDBC();
		Statement st=conn.createStatement();
		ResultSet rs=null;
	    String sql="SELECT  distinct project_id FROM "+databaseName+".filevine_event";
		rs=st.executeQuery(sql);
		while(rs.next()) {
	     	int projectID= rs.getInt("project_id");
	     	System.out.println("Project Id : "+projectID);
	     	projectIdList.add(projectID);
		}
		
		return projectIdList;
	}

	public void insertActivityTaskData(String databaseName, NotesExport notesExport) throws SQLException {
		
		
		MDC.put("path", "File Vine:: Tasks Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_activity_task_export("
					+ "ID,"
					+ "project_id,"
					+ "target_date,"
					+ "body,"
					+ "created_at,"
					+ "userId,"
					+ "userName,"
					+ "type_tag,"
					+ "assignee_id,"
					+ "assignee_name,"
					+ "assignee_type,"
					+ "assignee,"
					+ "last_activity)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,notesExport.getId());
			ps.setInt(2, notesExport.getProjectId());
			ps.setString(3, notesExport.getTargetDate());
			ps.setString(4, notesExport.getBody());
			ps.setString(5, notesExport.getCreatedAt());
			ps.setInt(6, notesExport.getUserId());
			ps.setString(7, notesExport.getUserName());
			ps.setString(8, notesExport.getTypeTag());
			ps.setInt(9, notesExport.getAssigneeId());
			ps.setString(10, notesExport.getAssigneeName());
			ps.setString(11, notesExport.getAssigneeUser());
			ps.setString(12, notesExport.getAssignee());
			ps.setString(13, notesExport.getLastActivity());
			
			ps.executeUpdate();
			eventLogger.info("Task id :: "+ notesExport.getId() +" has been exported!!");
		}catch(Exception e) {
			errorLogger.error("Task id :: "+ notesExport.getId() +" already exists !!",e);
		//	e.printStackTrace();
		}finally {
			conn.close();
		}
		
	}

	public void insertActivitySmsData(String databaseName, NotesExport notesExport) throws SQLException {
		
MDC.put("path", "File Vine:: SMS Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_activity_sms_export("
					+ "ID,"
					+ "project_id,"
					+ "target_date,"
					+ "body,"
					+ "created_at,"
					+ "userId,"
					+ "userName,"
					+ "type_tag,"
					+ "assignee_id,"
					+ "assignee_name,"
					+ "assignee_type)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,notesExport.getId());
			ps.setInt(2, notesExport.getProjectId());
			ps.setString(3, notesExport.getTargetDate());
			ps.setString(4, notesExport.getBody());
			ps.setString(5, notesExport.getCreatedAt());
			ps.setInt(6, notesExport.getUserId());
			ps.setString(7, notesExport.getUserName());
			ps.setString(8, notesExport.getTypeTag());
			ps.setInt(9, notesExport.getAssigneeId());
			ps.setString(10, notesExport.getAssigneeName());
			ps.setString(11, notesExport.getAssigneeUser());
			
			ps.executeUpdate();
			eventLogger.info("SMS id :: "+ notesExport.getId() +" has been exported!!");
		}catch(Exception e) {
			errorLogger.error("SMS id :: "+ notesExport.getId() +" already exists !!",e);
		//	e.printStackTrace();
		}finally {
			conn.close();
		}
	}

}

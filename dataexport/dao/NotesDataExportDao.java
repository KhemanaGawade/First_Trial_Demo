package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.NotesDataExport;

import util.DBProvider;

public class NotesDataExportDao {

	
	public void insertDataNotes(String databaseName, NotesDataExport notesdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_notes_data_export("
					+ "id_,"
					+ "project_id,"
					+ "target_date,"
					+ "body_,"
					+ "created_at,"
					+ "type_tag,"
					+ "user_Id,"
					+ "user_name,"
					+ "assignee_id,"
					+ "assignee_name,"
					+ "assignee_user)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, notesdataexport.getId());
			ps.setInt(2,  notesdataexport.getProjectId());
			ps.setString(3,  notesdataexport.getTargetDate());
			ps.setString(4,  notesdataexport.getBody());
			ps.setString(5,  notesdataexport.getCreatedAt());
			ps.setString(6, notesdataexport.getTypeTag());
			ps.setInt(7,  notesdataexport.getUserId());
			ps.setString(8, notesdataexport.getUserName());
			ps.setInt(9,  notesdataexport.getAssigneeId());
			ps.setString(10,  notesdataexport.getAssigneeName());
			ps.setString(11,  notesdataexport.getAssigneeUser());

			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ notesdataexport.getId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ notesdataexport.getId());
			e.printStackTrace();
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
	
	

	
public void insertActivityTaskData(String databaseName, NotesDataExport notesdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_activity_task_data_export("
					+ "id_,"
					+ "project_id,"
					+ "target_date,"
					+ "body_,"
					+ "created_at,"
					+ "type_tag,"
					+ "user_Id,"
					+ "user_name,"
					+ "assignee_id,"
					+ "assignee_name,"
					+ "assignee_user)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, notesdataexport.getId());
			ps.setInt(2,  notesdataexport.getProjectId());
			ps.setString(3,  notesdataexport.getTargetDate());
			ps.setString(4,  notesdataexport.getBody());
			ps.setString(5,  notesdataexport.getCreatedAt());
			ps.setString(6, notesdataexport.getTypeTag());
			ps.setInt(7,  notesdataexport.getUserId());
			ps.setString(8, notesdataexport.getUserName());
			ps.setInt(9,  notesdataexport.getAssigneeId());
			ps.setString(10,  notesdataexport.getAssigneeName());
			ps.setString(11,  notesdataexport.getAssigneeUser());
//			ps.setString(11,  advanceclientcostexport.getPayeeName());
//			ps.setString(12,  advanceclientcostexport.getMethodOfPayment());
//			ps.setString(13,  advanceclientcostexport.getPayDateDone());
//			ps.setString(14, advanceclientcostexport.getPayDateDue());
//			ps.setString(15, advanceclientcostexport.getHowMuchAmountPaid());
//			ps.setString(16, advanceclientcostexport.getCheckNumber());
//			ps.setString(17, advanceclientcostexport.getRecordsReceived());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ notesdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ notesdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
public void insertActivitySmsData(String databaseName, NotesDataExport notesdataexport ) throws SQLException {
	
	MDC.put("path", "Firm Central Matter Export");
	MDC.put("fid", databaseName);
	Connection conn=DBProvider.getJDBC();

	PreparedStatement ps=null;
	try {
		String sql="insert into "+databaseName+".filevine_Activity_sms_data_export("
				+ "id_,"
				+ "project_id,"
				+ "target_date,"
				+ "body_,"
				+ "created_at,"
				+ "type_tag,"
				+ "last_activity,"
				+ "assignee_,"
				+ "user_Id,"
				+ "user_name,"
				+ "assignee_id,"
				+ "assignee_name,"
				+ "assignee_user)"
				+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		ps=conn.prepareStatement(sql);


		ps.setInt(1, notesdataexport.getId());
		ps.setInt(2,  notesdataexport.getProjectId());
		ps.setString(3,  notesdataexport.getTargetDate());
		ps.setString(4,  notesdataexport.getBody());
		ps.setString(5,  notesdataexport.getCreatedAt());
		ps.setString(6, notesdataexport.getTypeTag());
		ps.setString(7,  notesdataexport.getLastActivity());
		ps.setString(8,  notesdataexport.getAssignee());
		ps.setInt(9,  notesdataexport.getUserId());
		ps.setString(10, notesdataexport.getUserName());
		ps.setInt(11,  notesdataexport.getAssigneeId());
		ps.setString(12,  notesdataexport.getAssigneeName());
		ps.setString(13,  notesdataexport.getAssigneeUser());
		
//		ps.setString(11,  advanceclientcostexport.getPayeeName());
//		ps.setString(12,  advanceclientcostexport.getMethodOfPayment());
//		ps.setString(13,  advanceclientcostexport.getPayDateDone());
//		ps.setString(14, advanceclientcostexport.getPayDateDue());
//		ps.setString(15, advanceclientcostexport.getHowMuchAmountPaid());
//		ps.setString(16, advanceclientcostexport.getCheckNumber());
//		ps.setString(17, advanceclientcostexport.getRecordsReceived());
		
		ps.executeUpdate();
		System.out.println("Data  has been exported for ProjectID :: "+  notesdataexport .getId());
		
	}catch(Exception e) {
		System.out.println("Data  all ready  exported for ProjectID :: "+ notesdataexport.getId());
		e.printStackTrace();
	}finally {
		conn.close();
	}




	}

	
	
	
	
	
	
	
	
	
	
}

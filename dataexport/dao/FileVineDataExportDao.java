package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.FileVineDataExport;

import util.DBProvider;

public class FileVineDataExportDao {

	
	public void insertFileVineDataData(String databaseName,FileVineDataExport filevinedataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_notes_data_export("
					+ "total_count,"
					+ "id_,"
					+ "project_id,"
					+ "type_tag,"
					+ "target_date,"
					+ "completed_date,"
					+ "body_,"
					+ "created_at,"
					+ "last_activity,"
					+ "assignee_,"
					+ "author_full_name,"
					+ "user_name,"
//					+ "pay_date_done,"
//					+ "pay_date_due,"
//					+ "how_much_amount_paid,"
//					+ "check_number,"
					+ "user_name_id)value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, filevinedataexport.getTotalCount());
			ps.setString(2,  filevinedataexport.getId());
			ps.setString(3,  filevinedataexport.getProjectId());
			ps.setString(4,  filevinedataexport.getTypeTag());
			ps.setString(5,  filevinedataexport.getTargetDate());
			ps.setString(6, filevinedataexport.getCompletedDate());
			ps.setString(7,  filevinedataexport.getBody());
			ps.setString(8,  filevinedataexport.getCreatedAt());
			ps.setString(9,  filevinedataexport.getLastActivity());
			ps.setString(10, filevinedataexport.getAssignee());
			ps.setString(11,  filevinedataexport.getAuthorFullName());
			ps.setString(12,  filevinedataexport.getUserName());
			ps.setString(13,  filevinedataexport.getUserNameId());
//			ps.setString(14, filevinedataexport.getPayDateDue());
//			ps.setString(15, filevinedataexport.getHowMuchAmountPaid());
//			ps.setString(16, filevinedataexport.getCheckNumber());
//			ps.setString(17, filevinedataexport.getRecordsReceived());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ filevinedataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ filevinedataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
		}
	
	
public void insertActivityTaskData(String databaseName,FileVineDataExport filevinedataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_notes_data_task_export("
					+ "total_count,"
					+ "id_,"
					+ "project_id,"
					+ "type_tag,"
					+ "target_date,"
					+ "completed_date,"
					+ "body_,"
					+ "created_at,"
					+ "last_activity,"
					+ "assignee_,"
					+ "author_full_name,"
					+ "user_name,"
//					+ "pay_date_done,"
//					+ "pay_date_due,"
//					+ "how_much_amount_paid,"
//					+ "check_number,"
					+ "user_name_id)value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, filevinedataexport.getTotalCount());
			ps.setString(2,  filevinedataexport.getId());
			ps.setString(3,  filevinedataexport.getProjectId());
			ps.setString(4,  filevinedataexport.getTypeTag());
			ps.setString(5,  filevinedataexport.getTargetDate());
			ps.setString(6, filevinedataexport.getCompletedDate());
			ps.setString(7,  filevinedataexport.getBody());
			ps.setString(8,  filevinedataexport.getCreatedAt());
			ps.setString(9,  filevinedataexport.getLastActivity());
			ps.setString(10, filevinedataexport.getAssignee());
			ps.setString(11,  filevinedataexport.getAuthorFullName());
			ps.setString(12,  filevinedataexport.getUserName());
			ps.setString(13,  filevinedataexport.getUserNameId());
//			ps.setString(14, filevinedataexport.getPayDateDue());
//			ps.setString(15, filevinedataexport.getHowMuchAmountPaid());
//			ps.setString(16, filevinedataexport.getCheckNumber());
//			ps.setString(17, filevinedataexport.getRecordsReceived());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ filevinedataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ filevinedataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
public void insertActivitySmsData(String databaseName,FileVineDataExport filevinedataexport ) throws SQLException {
	
	MDC.put("path", "Firm Central Matter Export");
	MDC.put("fid", databaseName);
	Connection conn=DBProvider.getJDBC();

	PreparedStatement ps=null;
	try {
		String sql="insert into "+databaseName+".filevine_notes_sms_data_export("
				+ "total_count,"
				+ "id_,"
				+ "project_id,"
				+ "type_tag,"
				+ "target_date,"
				+ "completed_date,"
				+ "body_,"
				+ "created_at,"
				+ "last_activity,"
				+ "assignee_,"
				+ "author_full_name,"
				+ "user_name,"
//				+ "pay_date_done,"
//				+ "pay_date_due,"
//				+ "how_much_amount_paid,"
//				+ "check_number,"
				+ "user_name_id)value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);


		ps.setString(1, filevinedataexport.getTotalCount());
		ps.setString(2,  filevinedataexport.getId());
		ps.setString(3,  filevinedataexport.getProjectId());
		ps.setString(4,  filevinedataexport.getTypeTag());
		ps.setString(5,  filevinedataexport.getTargetDate());
		ps.setString(6, filevinedataexport.getCompletedDate());
		ps.setString(7,  filevinedataexport.getBody());
		ps.setString(8,  filevinedataexport.getCreatedAt());
		ps.setString(9,  filevinedataexport.getLastActivity());
		ps.setString(10, filevinedataexport.getAssignee());
		ps.setString(11,  filevinedataexport.getAuthorFullName());
		ps.setString(12,  filevinedataexport.getUserName());
		ps.setString(13,  filevinedataexport.getUserNameId());
//		ps.setString(14, filevinedataexport.getPayDateDue());
//		ps.setString(15, filevinedataexport.getHowMuchAmountPaid());
//		ps.setString(16, filevinedataexport.getCheckNumber());
//		ps.setString(17, filevinedataexport.getRecordsReceived());
		
		ps.executeUpdate();
		System.out.println("Data  has been exported for ProjectID :: "+ filevinedataexport.getProjectId());
		
	}catch(Exception e) {
		System.out.println("Data  all ready  exported for ProjectID :: "+ filevinedataexport.getProjectId());
		e.printStackTrace();
	}finally {
		conn.close();
	}




	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

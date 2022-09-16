package com.filevine.dataexport.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import util.DBProvider;
//import util.DBProvider;
import com.filevine.dataexport.domain.CommentsNotesExport;

public class CommentsNotesTaskExportDao {

	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
//	public void insertDataCommentsNotes(String databaseName, CommentsNotesExport commentsNotesExport) throws Exception {
//		
//		MDC.put("path", "File Vine:: Comments of notes Export");
//		Connection conn=DBProvider.getJDBC();
//		PreparedStatement ps=null;
//		try {
//			String sql="insert into "+databaseName+".filevine_comment_notes_export("
//					+ "comment_id,"
//					+ "note_id,"
//					+ "body,"
//					+ "created_at,"
//					+ "userId,"
//					+ "fullname,note_id_input)"
//					+ "value(?,?,?,?,?,?,?);";
//			ps=conn.prepareStatement(sql);
//
//			ps.setInt(1,commentsNotesExport.getCommentId());
//			ps.setInt(2, commentsNotesExport.getNoteId());
//			ps.setString(3, commentsNotesExport.getBody());
//			ps.setString(4, commentsNotesExport.getCreatedAt());
//			ps.setInt(5, commentsNotesExport.getUserId());
//			ps.setString(6, commentsNotesExport.getFullName());
//			ps.setInt(7, commentsNotesExport.getNoteIdInput());
//			ps.executeUpdate();
//			eventLogger.info("Comment id :: "+ commentsNotesExport.getCommentId() +" has been exported!!");
//		}catch(Exception e) {
//			errorLogger.error("Comment id :: "+ commentsNotesExport.getCommentId() +" already exists !!",e);
//			//e.printStackTrace();
//		}finally {
//			conn.close();
//		}
//
//	}

	
public void insertDataTasks(String databaseName, CommentsNotesExport commentsNotesExport) throws Exception {
		
		MDC.put("path", "File Vine:: Comments of tasks Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="INSERT INTO `"+databaseName+"`.`filevine_activity_taskdata_export`\r\n" + 
					"(`task_id`,\r\n" + 
					"`project_id`,\r\n" + 
					"`type_tag`,\r\n" + 
					"`target_date`,\r\n" + 
					"`is_unread`,\r\n" + 
					"`is_completed`,\r\n" + 
					"`completed_date`,\r\n" + 
					"`destination`,\r\n" + 
					"`source`,\r\n" + 
					"`is_edited`,\r\n" + 
					"`allow_editing`,\r\n" + 
					"`last_activity`,\r\n" + 
					"`assign_to`,\r\n" +
					"`assignee_id`,\r\n" +
					"`completer_id`,\r\n" +
					"`complter_name`,`completer_createdAt`,`author_id`,`author_fullName`,`body`,`created_at`)\r\n" + 
					 "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,commentsNotesExport.getNoteId());
			ps.setString(2, commentsNotesExport.getProjectId());
			ps.setString(3, commentsNotesExport.getTypeTag());
			ps.setString(4, commentsNotesExport.getTargetDate());
			ps.setString(5, commentsNotesExport.getIsUnread());
			ps.setString(6, commentsNotesExport.getIsCompleted());
			ps.setString(7, commentsNotesExport.getCompletedDate());
			ps.setString(8, commentsNotesExport.getDestination());
			ps.setString(9, commentsNotesExport.getSource());
			ps.setString(10, commentsNotesExport.getIsEdited());
			ps.setString(11, commentsNotesExport.getAllowEditing());
			ps.setString(12, commentsNotesExport.getLastActivity());
			ps.setString(13, commentsNotesExport.getAssigneeFullName());
			ps.setInt(14, commentsNotesExport.getAssigneeId());
			ps.setInt(15, commentsNotesExport.getCompleterId());
			ps.setString(16, commentsNotesExport.getCompleterName());
			ps.setString(17, commentsNotesExport.getCompleterCreatedAt());
			ps.setInt(18, commentsNotesExport.getAuthorId());
			ps.setString(19, commentsNotesExport.getAuthorName());
			ps.setString(20, commentsNotesExport.getTaskBody());
			ps.setString(21, commentsNotesExport.getCreatedAt());

			ps.executeUpdate();
			
			eventLogger.info("Task id :: "+ commentsNotesExport.getNoteId() +" has been exported!!");
		}catch(Exception e) {
			errorLogger.error("Task id :: "+ commentsNotesExport.getNoteId() +" already exists !!",e);
			//e.printStackTrace();
		}finally {
			conn.close();
		}

	}
	
	
	
	public ArrayList<Integer> getNoteIdList(String databaseName) throws Exception{
		
		Connection conn = DBProvider.getJDBC();
		ArrayList<Integer> noteIdList=new ArrayList<Integer>();
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs=null;
			String sql="select ID from "+databaseName+".filevine_notes_export";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int noteId=rs.getInt("ID");
				noteIdList.add(noteId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return noteIdList;
	}

	/****************
	 * 
	 * GET TASKS LIST
	 * 
	 */
	
public ArrayList<Integer> getTasksIdList(String databaseName,int batch) throws Exception{
		
		Connection conn = DBProvider.getJDBC();
		ArrayList<Integer> noteIdList=new ArrayList<Integer>();
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs=null;
			String sql="select ID from "+databaseName+".filevine_activity_task_export where type_tag='task'";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				int noteId=rs.getInt("ID");
				noteIdList.add(noteId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return noteIdList;
	}
	
}

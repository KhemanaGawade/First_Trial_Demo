package com.filevine.dataexport.dao;

import static util.Constants.CONST_ENV;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import util.DBProvider;
import com.filevine.dataexport.domain.CommentsNotesExport;

/**
 * This is Dao class used for database operation for comment notes details
*/
public class CommentsNotesExportDao {

	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
	/**
	 * Inserting all CommentsNotesExport class values into database case summary table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertDataCommentsNotes(String databaseName, CommentsNotesExport commentsNotesExport) throws Exception {
		
		MDC.put("path", "File Vine:: Comments of notes Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_comment_activitynotes_export("
				//	String sql="insert into "+databaseName+".filevine_comment_activitytasks_export("
				//	String sql="insert into "+databaseName+".filevine_comment_activitysms_export("
					
					+ "comment_id,"
					+ "task_id,"
					+ "body,"
					+ "created_at,"
					+ "userId,"
					+ "fullname,"
					+ "task_id_input)"
					+ "value(?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,commentsNotesExport.getCommentId());
			ps.setInt(2, commentsNotesExport.getNoteId());
			ps.setString(3, commentsNotesExport.getBody());
			ps.setString(4, commentsNotesExport.getCreatedAt());
			ps.setInt(5, commentsNotesExport.getUserId());
			ps.setString(6, commentsNotesExport.getFullName());
			ps.setInt(7, commentsNotesExport.getTask_id_input());
			
			ps.executeUpdate();
			eventLogger.info("Comment id :: "+ commentsNotesExport.getCommentId() +" has been exported!!");
		}catch(Exception e) {
			errorLogger.error("Comment id :: "+ commentsNotesExport.getCommentId() +" already exists !!",e);
			//e.printStackTrace();
		}finally {
			conn.close();
		}

	}

	/**
	 * return a list of note ids from notes table by passing batch and database name
	 * @throws Exception
	 */
	public ArrayList<Integer> getNoteIdList(String databaseName,String batch) throws Exception{
		
		Connection conn = DBProvider.getJDBC();
		ArrayList<Integer> noteIdList=new ArrayList<Integer>();
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs=null;
			String sql="select ID from "+databaseName+".filevine_notes_export";
		//	String sql="select ID from "+databaseName+".filevine_activity_task_export";
		//	String sql="select ID from "+databaseName+".filevine_activity_sms_export";
			//			
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

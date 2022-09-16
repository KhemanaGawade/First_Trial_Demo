package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.filevine.dataexport.domain.TaskExport;

import util.DBProvider;

public class TaskExportDao {

	public void insertTaskData(String database, TaskExport taskExport) throws SQLException {
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {

			String sql = "insert into "+database+".filevine_task_export(" + 
					"task_id ," + 
					" project_id ," + 
					" project_name," + 
					" client_name," + 
					" type_tag," + 
					" targer_date," + 
					" is_unread," + 
					" is_complete," + 
					"  completed_date ," + 
					" body ," + 
					" created_at," + 
					" destination,"
					+ "source,"
					+ "is_edited,"
					+ "last_activity,"
					+ "author_fullname,"
					+ "author_type,"
					+ "author_email,"
					+ "assignee,"
					+ "comments)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,taskExport.getTaskId());
			ps.setInt(2, taskExport.getProjectId());
			ps.setString(3, taskExport.getProjectName());
			ps.setString(4, taskExport.getClientName());
			ps.setString(5, taskExport.getTypeTag());
			ps.setString(6, taskExport.getTargetDate());
			ps.setString(7, taskExport.getIsUnread());
			ps.setString(8, taskExport.getIsCompleted());
			ps.setString(9, taskExport.getCompletedDate());
			ps.setString(10, taskExport.getBody());
			ps.setString(11, taskExport.getCreatedAt());
			ps.setString(12, taskExport.getDestination());
			ps.setString(13, taskExport.getSource());
			ps.setString(14, taskExport.getIsEdited());
			ps.setString(15, taskExport.getLastActivity());
			ps.setString(16, taskExport.getAuthorFullName());
			ps.setString(17, taskExport.getAuthorType());
			ps.setString(18, taskExport.getAuthorEmail());
			ps.setString(19, taskExport.getAssignee());
			ps.setString(20, taskExport.getComments());

			ps.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
	}

}

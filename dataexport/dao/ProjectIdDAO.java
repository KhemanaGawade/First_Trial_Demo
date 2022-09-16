package com.filevine.dataexport.dao;

// import static com.cloudlex.util.Constants.CONST_ENV;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBProvider;
import com.filevine.dataexport.domain.ProjectIDInsert;


public class ProjectIdDAO {
	
	public static void insertProject(ProjectIDInsert project ,String dbName) throws Exception {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement stmt=null;
	
		
		try {
			String sql="insert into "+dbName+".filevine_project_info(project_name,project_id)values(?,?)";
			
//			System.out.println(sql);
//			System.out.println(project.getProjectID());
//			System.out.println(project.getProjectName());
			stmt=conn.prepareStatement(sql);
		
			stmt.setString(1,project.getProjectName());
			stmt.setString(2, project.getProjectID());
			int rows=stmt.executeUpdate();
			
			if(rows >0) {
				System.out.println("Data inserted, projectid :  "+ project.getProjectID());
			}else {
				System.out.println("Project data not inserted, projectid :  "+project.getProjectID());				
			}
		}catch(Exception e){

			e.printStackTrace();

		}finally {
			conn.close();
		}

	}
	/**
	 * return a list of project ids from project info table by passing batch and database name
	 * @throws Exception
	 */
	public ArrayList<String> getProjectIDList(String databaseName,Connection con ,int batch) throws SQLException {
	
		ArrayList<String>  projectId = new ArrayList<String>();
		
		String qry = " select  project_id from "+databaseName+".filevine_project_info where batch="+batch;
		PreparedStatement pst  = con.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			projectId.add(rs.getString("project_id")) ;
		}
		pst.close();
		return projectId;

	}

}

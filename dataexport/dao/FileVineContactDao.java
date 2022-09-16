package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.FileVineContactDomain;

import util.DBProvider;

public class FileVineContactDao {

	public void insertfilevinecontactData(String databaseName, FileVineContactDomain filevinecontactdomain ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_contact_data_export("
					+ "project_id,"
					+ "id_,"
					+ "role_,"
					+ "person_id,"
					+ "person_role,"
					+ "person_title,"
					+ "	role_unique_id)value(?,?,?,?,?,?,?)";

			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, filevinecontactdomain.getProjectId());
			ps.setString(2,  filevinecontactdomain.getId());
			ps.setString(3,  filevinecontactdomain.getRole());
			ps.setString(4,  filevinecontactdomain.getPersonID());
			ps.setString(5,  filevinecontactdomain.getPersonRole());
			ps.setString(6,  filevinecontactdomain.getPersonTitle());
			ps.setString(7,  filevinecontactdomain.getRoleUniqueId());
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ filevinecontactdomain.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ filevinecontactdomain.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	}
	
}

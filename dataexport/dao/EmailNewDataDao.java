package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.EmailNewDataExport;

import util.DBProvider;

public class EmailNewDataDao {

	public void insertEmailNewData(String databaseName, EmailNewDataExport emailnewdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_email_data_export("
					+ "project_id,"
					+ "person_id,"
					+ "email_id,"
					+ "address_,"
					+ "label_)value(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, emailnewdataexport.getProjectId());
			ps.setString(2,  emailnewdataexport.getPersonID());
			ps.setString(3,  emailnewdataexport.getEmailId());
			ps.setString(4, emailnewdataexport.getAddress());
			ps.setString(5,  emailnewdataexport.getLabel());
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ emailnewdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ emailnewdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	}
	
}

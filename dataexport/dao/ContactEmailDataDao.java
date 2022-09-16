package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AccidentAdditionDataExport;
import com.filevine.dataexport.domain.ContactEmailDataExport;

import util.DBProvider;

public class ContactEmailDataDao {

	
public void insertContactEmailData(String databaseName, ContactEmailDataExport contactemaildataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_email_new_data_export("
					+ "project_id,"
					+ "PersonID,"
					+ "EmailId,"
					+ "Address,"
					+ "Label,"
					+ "Notes)value(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, contactemaildataexport.getProjectId());
			ps.setString(2,  contactemaildataexport.getPersonID());
			ps.setString(3,  contactemaildataexport.getEmailId());
			ps.setString(4,  contactemaildataexport.getAddress());
			ps.setString(5,  contactemaildataexport.getLabel());
			ps.setString(6,  contactemaildataexport.getNotes());	
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ contactemaildataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ contactemaildataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
}
	
}

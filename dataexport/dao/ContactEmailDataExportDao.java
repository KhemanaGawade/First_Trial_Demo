package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.ContactEmailsDataExport;


import util.DBProvider;

public class ContactEmailDataExportDao {

public void insertContactEmailsData(String databaseName, ContactEmailsDataExport  contactemailsdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_contact_Address_data_export("
					+ "project_id,"
					+ "contact_id,"
					+ "person_id,"
					+ "email_id,"
					+ "address_,"
					+ "label_,"
					+ "notes_)value(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
			ps.setString(1,contactemailsdataexport .getProjectId());
			ps.setString(2, contactemailsdataexport .getContactId());
			ps.setString(3,  contactemailsdataexport .getPersonID());
			ps.setString(4,  contactemailsdataexport .getEmailId());
			ps.setString(5,  contactemailsdataexport .getAddress());
			ps.setString(6, contactemailsdataexport.getLabel());
			ps.setString(7,  contactemailsdataexport.getNotes());
			
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+contactemailsdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ contactemailsdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
	
}
	
	
}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.ContactPhoneDataExport;

import util.DBProvider;

public class ContactPhoneDataExportDao {

public void insertContactPhoneData(String databaseName, ContactPhoneDataExport contactphonedataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_contact_phone_data_export("
					+ "project_id,"
					+ "contact_id,"
					+ "person_id,"
					+ "phone_id,"
					+ "number_,"
					+ "raw_number,"
					+ "label_,"
					+ "notes_)value(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
			ps.setString(1,contactphonedataexport.getProjectId());
			ps.setString(2, contactphonedataexport.getContactId());
			ps.setString(3,  contactphonedataexport.getPersonID());
			ps.setString(4,  contactphonedataexport.getPhoneId());
			ps.setString(5,  contactphonedataexport.getNumber());
			ps.setString(6,  contactphonedataexport.getRawNumber());
			ps.setString(7, contactphonedataexport.getLabel());
			ps.setString(8,  contactphonedataexport.getNotes());
			
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+contactphonedataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ contactphonedataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

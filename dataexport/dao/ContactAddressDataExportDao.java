package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.ContactAddressDataExport;

import util.DBProvider;

public class ContactAddressDataExportDao {

	
	public void insertContactAddressData(String databaseName, ContactAddressDataExport contactaddressdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_contact_email_data_export("
					+ "project_id,"
					+ "contact_id,"
					+ "person_id,"
					+ "addresses_id,"
					+ "line_1,"
					+ "line_2,"
					+ "city_,"
					+ "state_,"
					+ "zip_,"
					+ "label_,"
					+ "notes_,"
					+ "full_address)value(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
			ps.setString(1, contactaddressdataexport.getProjectId());
			ps.setString(2, contactaddressdataexport.getContactId());
			ps.setString(3,  contactaddressdataexport.getPersonID());
			ps.setString(4,  contactaddressdataexport.getAddressesId());
			ps.setString(5,  contactaddressdataexport.getLine1());
			ps.setString(6,  contactaddressdataexport.getLine2());
			ps.setString(7, contactaddressdataexport.getCity());
			ps.setString(8,  contactaddressdataexport.getState());
			ps.setString(9,  contactaddressdataexport.getZip());
			ps.setString(10,  contactaddressdataexport.getLabel());
			ps.setString(11, contactaddressdataexport.getNotes());
			ps.setString(12,  contactaddressdataexport.getFullAddress());
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ contactaddressdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ contactaddressdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.ClientInfoDataExport;

import util.DBProvider;

public class ClientInfoDataDao {

	public void insertClientInfoData(String databaseName, ClientInfoDataExport  clientinfodataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_client_info_export("
					+ "project_id,"
					+ "referral_source,"
					+ "unique_id,"
					+ "primary_contact_id,"
					+ "org_id,"
					+ "primary_contact_fullname,"
					+ "client_notes)value(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, clientinfodataexport.getProjectId());
			ps.setString(2, clientinfodataexport.getReferralSource());
			ps.setString(3,  clientinfodataexport. getUniqueId());
			ps.setString(4,  clientinfodataexport.getPrimaryContactId());
			ps.setString(5, clientinfodataexport.getOrgID());
			ps.setString(6,  clientinfodataexport.getPrimaryContactFullName());
			ps.setString(7, clientinfodataexport.getClientNotes());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+  clientinfodataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+  clientinfodataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	}
	
	
	
}

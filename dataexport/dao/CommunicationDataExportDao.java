package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.CommunicationDataExport;

import util.DBProvider;

public class CommunicationDataExportDao {

	
	public void insertCommunicationData(String databaseName,CommunicationDataExport communicationdataexport) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_communication_data_export("
					+ "project_id,"
					+ "type_of_communication,"
					+ "communication_to,"
					+ "communication_from,"
					+ "communication_date,"
					+ "communication_notes)value(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, communicationdataexport.getProjectId());
			ps.setString(2,  communicationdataexport.getTypeOfCommunication());
			ps.setString(3,  communicationdataexport.getCommunicationTo());
			ps.setString(4,  communicationdataexport.getCommunicationFrom());
			ps.setString(5,  communicationdataexport.getCommunicationDate());
			ps.setString(6, communicationdataexport.getCommunicationNotes());
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ communicationdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ communicationdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
		}
	
	
}

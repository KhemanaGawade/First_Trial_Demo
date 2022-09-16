package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.DiscoveryDataExport;
import com.filevine.dataexport.domain.MedicalBillsDataExport;

import util.DBProvider;

public class DiscoveryDataExportDao {

	
public void insertDiscoveryData(String databaseName,DiscoveryDataExport discoverydataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_discovery_data_export("
					+ "project_id,"
					+ "defendant_plaintiff,"
					+ "type_,"
					+ "party_is,"
					+ "party_,"
					+ "date_filed,"
					+ "served_to,"
					+ "date_served,"
					+ "document_title,"
					+ "notes_)value(?,?,?,?,?,?,?,?,?,?)";
				
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1,discoverydataexport.getProjectId());
			ps.setString(2,  discoverydataexport.getDefendantPlaintiff());
			ps.setString(3,  discoverydataexport.getType());
			ps.setString(4,  discoverydataexport.getPartyIs());
			ps.setString(5,  discoverydataexport.getParty());
			ps.setString(6, discoverydataexport.getDateFiled());
			ps.setString(7,  discoverydataexport.getServedTo());
			ps.setString(8,  discoverydataexport. getDateServed());
			ps.setString(9,  discoverydataexport.getDocumentTitle());
			ps.setString(10,  discoverydataexport.getNotes());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ discoverydataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ discoverydataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
}	
	
	
}

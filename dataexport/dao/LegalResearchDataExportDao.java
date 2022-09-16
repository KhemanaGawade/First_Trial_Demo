package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.LegalResearchDataExport;

import util.DBProvider;


public class LegalResearchDataExportDao {

	
	
public void insertLegalResearchData(String databaseName, LegalResearchDataExport legalresearchdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_legalresearch_data_export("
					+ "project_id,"					
					+ "research_type,"
					+ "research_date,"
					+ "notes_)value(?,?,?,?)";
					
			ps=conn.prepareStatement(sql);
				
			
			ps.setInt(1,    legalresearchdataexport.getProjectId());
			ps.setString(2,  legalresearchdataexport.getResearchType());
			ps.setString(3, legalresearchdataexport.getResearchDate());
			ps.setString(4,  legalresearchdataexport.getNotes());
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ legalresearchdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ legalresearchdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
}	
	
}

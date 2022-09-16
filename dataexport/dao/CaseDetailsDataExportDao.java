package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.CaseDetailsDataExport;

import util.DBProvider;

public class CaseDetailsDataExportDao {

	
	public void insertCaseDetailsData(String databaseName, CaseDetailsDataExport casedetailsdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_case_details_data_export("
					+ "project_id,"
					+ "field_name,"
					+ "friendly_name,"
					+ "field_type,"
					+ "field_value,"
					+ "linkref_value,"
					+ "position_,"
					+ "section_link)value(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, casedetailsdataexport.getProjectId());
			ps.setString(2,  casedetailsdataexport.getFieldName());
			ps.setString(3,  casedetailsdataexport.getFriendlyName());
			ps.setString(4,  casedetailsdataexport.getFieldType());
			ps.setString(5,  casedetailsdataexport.getFieldValue());
			ps.setString(6, casedetailsdataexport.getLinkRefValue());
			ps.setString(7,  casedetailsdataexport.getPosition());
			ps.setString(8,  casedetailsdataexport.getSectionLink());
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ casedetailsdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ casedetailsdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
	}
	
	
}

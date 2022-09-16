package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.MedicalBillsDataExport;
import com.filevine.dataexport.domain.PleadingsDataExport;

import util.DBProvider;

public class PleadingsDataExportDao {

	
	
public void insertPleadingsData(String databaseName, PleadingsDataExport  pleadingsdataexport) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_pleading_data_export("
					+ "project_id,"
					+ "party_serving_filing_pleading,"
					+ "pleading_type,"
					+ "pleading_name,"
					+ "defendant_,"
					+ "date_filed,"
					+ "hearing_set,"
					+ "order_tendered,"
					+ "notes_,"
			        + "date_served_,"
					+ "party_,"
					+ "documents_id,"
					+ "documents_file_name)value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1,pleadingsdataexport.getProjectId());
			ps.setString(2,  pleadingsdataexport.getPartyServingFilingPleading());
			ps.setString(3,  pleadingsdataexport.getPleadingType());
			ps.setString(4,  pleadingsdataexport.getPleadingName());
			ps.setString(5,  pleadingsdataexport.getDefendant());
			ps.setString(6, pleadingsdataexport.getDateFiled());
			ps.setString(7,  pleadingsdataexport.getHearingSet());
			ps.setString(8,  pleadingsdataexport. getOrderTendered());
			ps.setString(9,  pleadingsdataexport.getNotes());
			ps.setString(10,  pleadingsdataexport.getDateServed());
			ps.setString(11,  pleadingsdataexport.getParty());
			ps.setString(12,  pleadingsdataexport.getDocumentsId());
			ps.setString(13,  pleadingsdataexport.getDocumentsFileName());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ pleadingsdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ pleadingsdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
}	
	
	
}

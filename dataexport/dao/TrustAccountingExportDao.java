package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.TrustAccountingExport;

import util.DBProvider;

public class TrustAccountingExportDao {

	public void insertTrustAccountingExportData(String databaseName,TrustAccountingExport trustaccountingexport ) throws SQLException {
	
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
	
		try {
			String sql="insert into "+databaseName+".filevine_trustaccounting_export("
					+ "project_id,"
					+ "type_,"
					+ "check_number,"
					+ "amount_of_check,"
					+ "date_,"
					+ "notes,"
					+ "documents_id,"
					+ "documents_filename)value(?,?,?,?,?,?,?,?)";
	
			ps=conn.prepareStatement(sql);
			
			
			ps.setInt(1, trustaccountingexport.getProjectId());
			ps.setString(2,  trustaccountingexport.getType());
			ps.setString(3,  trustaccountingexport. getCheckNumber());
			ps.setString(4,  trustaccountingexport.getAmountOfCheck());
			ps.setString(5,  trustaccountingexport.getDate());
			ps.setString(6, trustaccountingexport.getNotes());
			ps.setString(7,  trustaccountingexport.getDocumentsId());
			ps.setString(8, trustaccountingexport.getDocumentsFileName());
	
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ trustaccountingexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ trustaccountingexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
}
}
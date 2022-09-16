package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.BillingDataExport;


import util.DBProvider;

public class BillingDataExportDao {

	
public void insertBillingData(String databaseName, BillingDataExport billingdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_billing_data_export("
					+ "project_id,"
					+ "type_,"
					+ "title_,"
					+ "amount_,"
					+ "date_,"
					+ "id_,"
					+ "created_date)value(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, billingdataexport .getProjectId());
			ps.setString(2,  billingdataexport .getType());
			ps.setString(3, billingdataexport .getTitle());
			ps.setString(4,  billingdataexport .getAmount());
			ps.setString(5,  billingdataexport .getDate());
			ps.setString(6, billingdataexport.getId());
			ps.setString(7, billingdataexport.getCreatedDate());
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+  billingdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+  billingdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
}
	
	
}

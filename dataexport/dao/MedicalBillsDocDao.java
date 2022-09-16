package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.MedicalBillsDoc;

import util.DBProvider;

public class MedicalBillsDocDao {

	
public void insertMedicalDocData(String databaseName,MedicalBillsDoc medicalbillsdoc ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_medical_doc_data_export("
					+ "project_id,"
					+ "medical_provider,"
					+ "bills_invoice_id,"
					+ "org_id,"
					+ "bills_invoice_filename,"
					+ "records_retrieval_invoice_id,"
					+ "records_retrieval_filename)value(?,?,?,?,?,?,?)";
			
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1,medicalbillsdoc.getProjectId());
			ps.setString(2,  medicalbillsdoc.getMedicalProvider());
			ps.setString(3, medicalbillsdoc.getBillsInvoiceId());
			ps.setString(4,  medicalbillsdoc.getOrgID());
			ps.setString(5, medicalbillsdoc.getBillsInvoiceFileName());
			ps.setString(6, medicalbillsdoc.getRecordsRetrievalInvoiceId());
			ps.setString(7,  medicalbillsdoc.getRecordsRetrievalFilename());
			
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ medicalbillsdoc.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ medicalbillsdoc.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
}
	
	
	
}

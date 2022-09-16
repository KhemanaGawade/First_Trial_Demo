package com.filevine.dataexport.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;

import util.DBProvider;



public class AdvanceClientCostExportDao {

	public void insertAdvanceClientCostData(String databaseName, AdvanceClientCostExport advanceclientcostexport ) throws SQLException {
	
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_advance_client_cost_data_export("
					+ "project_id,"
					+ "type_,"
					+ "invoice_number,"
					+ "amount_of_invoice,"
					+ "date_of_invoice,"
					+ "card_type,"
					+ "notes_,"
					+ "description_,"
					+ "whose_credit_card,"
					+ "facility_name,"
					+ "payee_name,"
					+ "method_of_payment,"
					+ "pay_date_done,"
					+ "pay_date_due,"
					+ "how_much_amount_paid,"
					+ "check_number,"
					+ "records_received,"
					+ "document_id,"
					+ "document_name)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, advanceclientcostexport.getProjectId());
			ps.setString(2,  advanceclientcostexport.getType());
			ps.setString(3,  advanceclientcostexport.getInvoiceNumber());
			ps.setString(4,  advanceclientcostexport.getAmountOfInvoice());
			ps.setString(5,  advanceclientcostexport.getDateOfInvoice());
			ps.setString(6, advanceclientcostexport.getCardType());
			ps.setString(7,  advanceclientcostexport.getNotes());
			ps.setString(8,  advanceclientcostexport.getDescription());
			ps.setString(9,  advanceclientcostexport.getWhoseCreditCard());
			ps.setString(10, advanceclientcostexport.getFacilityName());
			ps.setString(11,  advanceclientcostexport.getPayeeName());
			ps.setString(12,  advanceclientcostexport.getMethodOfPayment());
			ps.setString(13,  advanceclientcostexport.getPayDateDone());
			ps.setString(14, advanceclientcostexport.getPayDateDue());
			ps.setString(15, advanceclientcostexport.getHowMuchAmountPaid());
			ps.setString(16, advanceclientcostexport.getCheckNumber());
			ps.setString(17, advanceclientcostexport.getRecordsReceived());
			ps.setString(18, advanceclientcostexport.getDocumentId());
			ps.setString(19, advanceclientcostexport.getDocumentName());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ advanceclientcostexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ advanceclientcostexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
			
	
}

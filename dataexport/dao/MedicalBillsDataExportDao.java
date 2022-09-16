package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.MedicalBillsDataExport;

import util.DBProvider;

public class MedicalBillsDataExportDao {

	public void insertMedicalBillsData(String databaseName,MedicalBillsDataExport medicalbillsdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_medical_bills_data_export("
					+ "project_id,"
					+ "Provider_,"
					+ "amount_,"
					+ "payments_or_reductions,"
					+ "is_thisa_lien,"
					+ "is_bill_In_collections,"
					+ "date_treatment_started,"
					+ "date_treatment_completed,"
					+ "providers_account_number,"
					+ "plaintiffs_treatment_status,"
					+ "notes_,"
					+ "have_all_bills_been_received,"
					+ "have_all_bills_been_ordered,"
					+ "bill_invoice_received,"
					+ "records_ordered_date,"
					+ "records_invoice_received,"
					+ "records_received_date,"
					+ "have_all_records_beeno_odered,"
					+ "have_all_records_been_received,"
					+ "personal_health_payment,"
					+ "total_reductions,"
					+ "bills_ordered_date,"
					+ "bills_received_date,"
					+ "list_all_dates_of_service,"
					+ "pip_med_pay_payment,"
			        + "write_offs_adjust_ments,"
			        + "client_payment,"
					+ "collection_agency,"
					+ "medical_records_id,"
					+ "medical_records_filename,"
					+ "medical_bills_id,"
					+ "medical_bills_filename)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1,medicalbillsdataexport.getProjectId());
			ps.setString(2,  medicalbillsdataexport.getProvider());
			ps.setString(3,  medicalbillsdataexport.getAmount());
			ps.setString(4,  medicalbillsdataexport.getPaymentsOrReductions());
			ps.setString(5,  medicalbillsdataexport.getIsThisaLien());
			ps.setString(6, medicalbillsdataexport.getIsBillInCollections());
			ps.setString(7,  medicalbillsdataexport.getDatetreatmentstarted());
			ps.setString(8,  medicalbillsdataexport. getDateTreatmentCompleted());
			ps.setString(9,  medicalbillsdataexport.getProvidersAccountNumber());
			ps.setString(10, medicalbillsdataexport.getPlaintiffsTreatmentStatus());
			ps.setString(11,  medicalbillsdataexport.getNotes());
			ps.setString(12,  medicalbillsdataexport.getHaveAllBillsBeenReceived());
			ps.setString(13,  medicalbillsdataexport.getHaveAllbillsBeenOrdered());
			ps.setString(14, medicalbillsdataexport.getBillInvoiceReceived());
			ps.setString(15, medicalbillsdataexport.getRecordsOrderedDate());
			ps.setString(16, medicalbillsdataexport.getRecordsInvoiceReceived());
			ps.setString(17, medicalbillsdataexport.getRecordsReceivedDate());
			ps.setString(18,  medicalbillsdataexport.getHaveallRecordsBeenoOdered());
			ps.setString(19,  medicalbillsdataexport.getHaveAllRecordsBeenReceived());
			ps.setString(20, medicalbillsdataexport.getPersonalHealthPayment());
			ps.setString(21, medicalbillsdataexport.getTotalReductions());
			ps.setString(22, medicalbillsdataexport.getBillsOrderedDate());
			ps.setString(23, medicalbillsdataexport.getBillsReceivedDate());
			ps.setString(24, medicalbillsdataexport.getListAllDatesOfService());
			ps.setString(25, medicalbillsdataexport.getPipMedpayPayment());
			ps.setString(26, medicalbillsdataexport.getWriteOffsAdjustments());
			ps.setString(27, medicalbillsdataexport.getClientPayment());
			ps.setString(28, medicalbillsdataexport.getCollectionAgency());
			ps.setString(29, medicalbillsdataexport.getMedicalRecordsId());
			ps.setString(30, medicalbillsdataexport.getMedicalRecordsFileName());
			ps.setString(31, medicalbillsdataexport.getMedicalBillsId());
			ps.setString(32, medicalbillsdataexport.getMedicalBillsFileName());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ medicalbillsdataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ medicalbillsdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

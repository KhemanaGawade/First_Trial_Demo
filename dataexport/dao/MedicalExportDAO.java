package com.filevine.dataexport.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.MedicalExport;

import util.DBProvider;

public class MedicalExportDAO {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	public void insertMedicalData(String database,MedicalExport medicalexport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_medicals(" +
					"project_id,"+
					"id," + 
					"amount," +
					"final_amount," + 
					" records_collection_fee," + 
					"reduction," + 
					"original," +
					"notes," +
					" first_day_of_treatment ," +
					" last_day_of_treatment ," +
					"  date_requested," +
					" date_received ," +
					" ordered_by ," +
					"  method," +
					" snag_request,"
					+ "outstandingBalance,"
					+ "recordscollectionstatus48362,"
					+ "billingcollectionstatus,"
					+ "recordrequestresponsedate,"
					+ "asof,"
					+ "createdDate,"
					+ "policynumber,"
					+ "plaintiffstreatmentstatus,providersaccountnumber,billsordered,billsreceived,"
					+ "recordsordered,recordsreceived)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,medicalexport.getProjectId());
			ps.setInt(2, medicalexport.getPrivateID());
			ps.setString(3, medicalexport.getAmount());
			ps.setString(4, medicalexport.getFinalAmount());
			ps.setString(5, medicalexport.getRecordsCollectionFee());
			ps.setString(6, medicalexport.getReduction());
			ps.setString(7, medicalexport.getOriginal());
			ps.setString(8, medicalexport.getNotes());
			ps.setString(9, medicalexport.getFirstDayOfTreatment());
			ps.setString(10, medicalexport.getLastDayOfTreatment());
			ps.setString(11, medicalexport.getDateRequested());
			ps.setString(12, medicalexport.getDateReceived());
			ps.setString(13, medicalexport.getOrderedBy());
			ps.setString(14, medicalexport.getMethod());
			ps.setString(15, medicalexport.getSnagRequest());
			ps.setString(16, medicalexport.getOutstandingBalance());
			ps.setString(17, medicalexport.getRecordscollectionstatus48362());
			ps.setString(18, medicalexport.getBillingcollectionstatus());
			ps.setString(19, medicalexport.getRecordrequestresponsedate());
			ps.setString(20, medicalexport.getAsof());
			ps.setString(21, medicalexport.getCreatedDate());
			ps.setString(22, medicalexport.getPolicynumber());
			ps.setString(23, medicalexport.getPlaintiffstreatmentstatus());
			ps.setString(24, medicalexport.getProvidersaccountnumber());
			ps.setString(25, medicalexport.getBillsordered());
			ps.setString(26, medicalexport.getBillsreceived());
			ps.setString(27, medicalexport.getRecordsordered());
			ps.setString(28, medicalexport.getRecordsreceived());
			
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ medicalexport.getProjectId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorLogger.error(e);
			//e.printStackTrace();
		}
	finally {
		conn.close();
	}
	
		
	}

}

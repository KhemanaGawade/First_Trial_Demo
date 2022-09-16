package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.InsuranceDataExport;

import util.DBProvider;

public class InsuranceDataExportDao {

	
	
	public void insertInsuranceData(String databaseName, InsuranceDataExport insurancedataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_insurance_data_export("
					+ "project_id,"
					+ "insurance_type,"
					+ "insurance_company,"
					+ "adjuster_,"
					+ "insured_,"
					+ "claim_number,"
					+ "policy_number,"
					+ "policy_limits,"
					+ "accept_liability,"
					+ "additional_insurance_notes,"
					+ "decsheet_,"
					+ "created_date,"
					+ "insurance_company_id,"
					+ "adjuster_id,"
					+ "insured_id,"
					+ "other_insurance_type)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, insurancedataexport.getProjectId());
			ps.setString(2,  insurancedataexport.getInsuranceType());
			ps.setString(3,  insurancedataexport.getInsuranceCompany());
			ps.setString(4,  insurancedataexport.getAdjuster());
			ps.setString(5,  insurancedataexport.getInsured());
			ps.setString(6, insurancedataexport.getClaimNumber());
			ps.setString(7,  insurancedataexport.getPolicyNumber());
			ps.setString(8,  insurancedataexport.getPolicyLimits());
			ps.setString(9,  insurancedataexport.getAcceptLiability());
			ps.setString(10, insurancedataexport.getAdditionalInsuranceNotes());
			ps.setString(11,  insurancedataexport.getDecsheet());
			ps.setString(12,  insurancedataexport.getCreatedDate());
			ps.setString(13,  insurancedataexport.getInsuranceCompanyId());
			ps.setString(14,  insurancedataexport.getAdjusterId());
			ps.setString(15,  insurancedataexport.getInsuredId());
			ps.setString(16,  insurancedataexport.getOtherInsuranceType());
		
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ insurancedataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ insurancedataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

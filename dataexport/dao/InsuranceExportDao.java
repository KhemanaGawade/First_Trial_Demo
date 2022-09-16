package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.InsuranceExport;

import util.DBProvider;

public class InsuranceExportDao {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public ArrayList<Integer> getProjectIdList(String databaseName) throws Exception {
		ArrayList<Integer> projectIdList=new ArrayList<Integer>();
		Connection conn=DBProvider.getJDBC();
		Statement st=conn.createStatement();
		ResultSet rs=null;
		try {
	    String sql="SELECT project_id FROM migrationdb_filevine_AnnMarieEvans.filevine_project_info";
		rs=st.executeQuery(sql);
		while(rs.next()) {
	     	int projectID= rs.getInt("project_id");
	     	//System.out.println("Project Id : "+projectID);
	     	projectIdList.add(projectID);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return projectIdList;
	
	}

	public void insertInsuranceData(InsuranceExport insuranceExport, String databaseName) throws Exception {
		MDC.put("path", "File Vine:: Insurance Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
	//	System.out.println("value : "+insuranceExport);
		try {
			String sql="insert into "+databaseName+".filevine_insurance_export("
					+ "project_id,"
					+ "policy_id,"
					+ "policy_number,"
					+ "claim_number,"
					+ "policy_holder,"
					+ "inseurer_id,"
					+ "inseured_id,"
					+ "adjusterId,"
					+ "driver_vehicle_id,"
					+ "third_party_insurance_id,"
					+ "insurance_limit,"
					+ "ispipexhausted,pip,"
					+ "notes,pipcoverageamount,umuimcoverageamount,"
					+ "total_limit,insurance_type,umType,insurance_provider_id,liability_decision)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,insuranceExport.getProjectId());
			ps.setString(2, insuranceExport.getPolicyId());
			ps.setString(3, insuranceExport.getPolicyNumber());
			ps.setString(4, insuranceExport.getClaimNumber());
			ps.setString(5, insuranceExport.getPolicyHolder());
			ps.setInt(6,insuranceExport.getInseurerId());
			ps.setInt(7,insuranceExport.getInsuredId());
			ps.setInt(8,insuranceExport.getAdjusterId());
			ps.setInt(9, insuranceExport.getDriverVehicleId());
			ps.setInt(10, insuranceExport.getThirdPartyInsuranceId());
			ps.setString(11, insuranceExport.getLimit());
			ps.setString(12, insuranceExport.getIspipexhausted());
			ps.setString(13, insuranceExport.getPip());
			ps.setString(14, insuranceExport.getNotes());
			ps.setString(15, insuranceExport.getPipcoverageamount());
			ps.setString(16, insuranceExport.getUmuimcoverageamount());
			ps.setString(17, insuranceExport.getTotal_limit());
			ps.setString(18, insuranceExport.getInsurance_type());
			ps.setString(19, insuranceExport.getUmType());
			ps.setString(20, insuranceExport.getInsurance_provider_id());
			ps.setString(21, insuranceExport.getLiabilityDecision());
			
			ps.executeUpdate();
			eventLogger.info("Policy id :: "+ insuranceExport.getPolicyId() +" has been exported!!");
			
		}catch(Exception e) {
			errorLogger.error("Policy id :: "+ insuranceExport.getPolicyId() +" already exists !!",e);
//			e.printStackTrace();
		}finally {
			conn.close();
		}

		
	}

}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.WitnessExport;

import util.DBProvider;

public class WitnessExportDao {

	
	
	public void insertWitnessData(String databaseName, WitnessExport witnessexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_witness_data_export("
					+ "project_id,"
					+ "date_inter_viewed,"
					+ "witness_id,"
					+ "org_id,"
					+ "witness_full_name,"
					+ "created_date,"
					+ "modified_date,"
					+ "witness_role,"
					+ "notes_,"
                    + "unique_id)value(?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, witnessexport.getProjectId());
			ps.setString(2, witnessexport.getDateInterViewed());
			ps.setString(3,  witnessexport.getWitnessId());
			ps.setString(4,  witnessexport.getOrgID());
			ps.setString(5,  witnessexport.getWitNessFullName());
			ps.setString(6, witnessexport.getCreatedDate());
			ps.setString(7,  witnessexport.getModiFiedDate());
			ps.setString(8,  witnessexport.getWitnessRole());
			ps.setString(9, witnessexport. getNotes());
			ps.setString(10,  witnessexport.getUniqueID());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ witnessexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ witnessexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
}
}
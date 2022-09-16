package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.NegotaionExptraDataExport;

import util.DBProvider;

public class NegotaionExptraDataExportDao {

	
	
	public void insertNegotaionExptraData(String databaseName, NegotaionExptraDataExport negotaionexptradataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_Negotaion_ExptraData_export("
					+ "project_id,"
					+ "party_id,"
					+ "org_id,"
					+ "party_full_name,"
					+ "UniqueId)value(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, negotaionexptradataexport.getProjectId());
			ps.setString(2,  negotaionexptradataexport.getPartyId());
			ps.setString(3,  negotaionexptradataexport.getOrgId());
			ps.setString(4,  negotaionexptradataexport.getPartyFullName());
			ps.setString(5,  negotaionexptradataexport.getUniqueId());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ negotaionexptradataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ negotaionexptradataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
}
}
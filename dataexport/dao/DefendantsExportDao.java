package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.DefendantsExport;
import com.filevine.dataexport.domain.WitnessExport;

import util.DBProvider;

public class DefendantsExportDao {

public void insertDefendantData(String databaseName, DefendantsExport defendantsexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_defendant_data_export("
					+ "project_id,"
					+ "defendant_id,"
					+ "org_id,"
					+ "defendant_fullname,"
					+ "created_date,"
					+ "modified_date,"
					+ "service_due_date,"
					+ "service_done_date,"
					+ "attorney_for_defendant_id,"
					+ "attorney_for_defendant_fullname,"
					+"unique_id,"
					+ "notes_ )value(?,?,?,?,?,?,?,?,?,?,?,?)";
                  
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, defendantsexport .getProjectId());
			ps.setString(2, defendantsexport .getDefendantId());
			ps.setString(3,  defendantsexport .getOrgID());
			ps.setString(4,  defendantsexport .getDefendantFullName());
			ps.setString(5, defendantsexport .getCreatedDate());
			ps.setString(6,  defendantsexport .getModiFiedDate());
			ps.setString(7,  defendantsexport .getServiceDueDate());
			ps.setString(8, defendantsexport . getServiceDoneDate());
			ps.setString(9,  defendantsexport . getAttorneyForDefendantId());
			ps.setString(10, defendantsexport . getAttorneyForDefendantFullName());
			ps.setString(11,  defendantsexport .getUniqueID());
			ps.setString(12, defendantsexport .getNotes());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ defendantsexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ defendantsexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
}

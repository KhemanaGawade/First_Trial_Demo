package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.ChildernDataExport;

import util.DBProvider;

public class ChildernDataExportDao {

	
	public void insertChildernData(String databaseName, ChildernDataExport  childerndataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_children_data_export("
					+ "project_id,"
					+ "fulllegal_name,"
					+ "childsdate_of_birth,"
					+ "children_id,"
					+ "created_date,"
					+ "general_notes)value(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setString(1, childerndataexport .getProjectId());
			ps.setString(2,  childerndataexport .getFullLegalName());
			ps.setString(3,  childerndataexport .getChildsDateOfBirth());
			ps.setString(4,  childerndataexport .getChildrenId());
			ps.setString(5,  childerndataexport .getCreatedDate());
			ps.setString(6,  childerndataexport.getGeneralNotes());
			
			
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+  childerndataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+  childerndataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
	}	
	
	
}

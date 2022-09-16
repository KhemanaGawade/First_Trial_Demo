package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.MotionDataExport;
import com.filevine.dataexport.domain.PleadingsDataExport;

import util.DBProvider;

public class MotionDataExportDao {

	
public void insertMotionData(String databaseName, MotionDataExport  motiondataexport) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_motions_data_export("
					+ "project_id,"
					+ "party_serving_filing_pleading,"
					+ "party_serving,"
					+ "motion_name,"
					+ "party_served,"
					+ "date_served,"
					+ "order_received,"
					+ "motiondoc_id,"
					+ "motiondoc_filename)value(?,?,?,?,?,?,?,?,?)";
					
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1,motiondataexport.getProjectId());
			ps.setString(2,  motiondataexport.getPartyServingFilingpLeading());
			ps.setString(3,  motiondataexport.getPartyServing());
			ps.setString(4,  motiondataexport.getMotionName());
			ps.setString(5,  motiondataexport.getPartyServed());
			ps.setString(6, motiondataexport.getDateServed());
			ps.setString(7,  motiondataexport.getOrderReceived());
			ps.setString(8, motiondataexport.getMotiondocId());
			ps.setString(9,  motiondataexport.getMotiondocFileName());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ motiondataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ motiondataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
}

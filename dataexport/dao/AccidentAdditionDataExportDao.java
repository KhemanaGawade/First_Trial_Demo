package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AccidentAdditionDataExport;


import util.DBProvider;

public class AccidentAdditionDataExportDao {

	public void insertAccidentAdditionData(String databaseName, AccidentAdditionDataExport accidentadditiondataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_accident_addition_data_export("
					+ "project_id,"
					+ "Passenger_no1_id,"
					+ "passenger_no2_id,"
					+ "passenger_no3_id,"
					//+ "date_of_invoice,"
					+ "passenger_no4_id)value(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, accidentadditiondataexport.getProjectId());
			ps.setString(2,  accidentadditiondataexport.getPassengerNo1Id());
			ps.setString(3,  accidentadditiondataexport.getPassengerNo2Id());
			ps.setString(4,  accidentadditiondataexport.getPassengerNo3Id());
			ps.setString(5,  accidentadditiondataexport.getPassengerNo4Id());	
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ accidentadditiondataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ accidentadditiondataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	}
	
	
}

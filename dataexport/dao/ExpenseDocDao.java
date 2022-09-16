package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.ExpenseDocExport;


import util.DBProvider;

public class ExpenseDocDao {

	public void insertExpenseDocData(String databaseName,ExpenseDocExport expensedocexport ) throws SQLException {
	
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_expense_doc_data_export("
					+ "project_id,"
					+ "expense_title,"
					+ "reciept_id,"
					+ "org_id,"
					+ "reciept_file_name)value(?,?,?,?,?)";
			
			ps=conn.prepareStatement(sql);
	
			ps.setInt(1,expensedocexport.getProjectId());
			ps.setString(2,  expensedocexport.getExpenseTitle());
			ps.setString(3, expensedocexport.getRecieptId());
			ps.setString(4,  expensedocexport.getOrgID());
			ps.setString(5, expensedocexport.getRecieptFileName());
	
	
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ expensedocexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ expensedocexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	}
	
	
}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.filevine.dataexport.domain.ExpensesExport;

import util.DBProvider;


public class ExpensesExportDAO {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	public void insertExpenseData(String database,ExpensesExport expenseExport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_expenses(" + 
					"project_id," + 
					"title," +
					"amount," + 
					"payment_method," + 
					"notes  ," +
					"date_of_expense,"+
					" created_date)values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,expenseExport.getProjectId());
			ps.setString(2, expenseExport.getTitle());
			ps.setString(3, expenseExport.getAmount());
			ps.setString(4, expenseExport.getPaymentMethod());
			ps.setString(5, expenseExport.getNotes());
			ps.setString(6, expenseExport.getDateOfExpense());
			ps.setString(7, expenseExport.getCreatedDate());

			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ expenseExport.getProjectId());
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

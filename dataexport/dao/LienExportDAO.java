package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.LienExport;

import util.DBProvider;

public class LienExportDAO {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public void insertLienData(String database,LienExport lienexport) throws Exception
	{
		MDC.put("path", "File Vine:: Notes Export");
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_liens(" +
					"lien_holder," +
					"amount," +
					"recovery_agency," +
					"recovery_agent," + 
					"date_sent," + 
					"date_received," +
					"date_of_receipt," + 
					"notes,noticereceived,finallienrecieved," +
					" project_id,lor_sent)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,lienexport.getLienHolder());
			ps.setString(2, lienexport.getAmount());
			ps.setString(3, lienexport.getRecoveryAgency());
			ps.setString(4, lienexport.getRecoveryAgent());
			ps.setString(5, lienexport.getDateSent());
			ps.setString(6, lienexport.getDateReceived());
			ps.setString(7, lienexport.getDateOfReceipt());
			ps.setString(8, lienexport.getNotes());
			ps.setString(9, lienexport.getNoticereceived());
			ps.setString(10, lienexport.getFinallienrecieved());
			ps.setInt(11, lienexport.getProjectId());
			ps.setString(12, lienexport.getLorsent());
			ps.executeUpdate();
			eventLogger.info("Data  has been exported for ProjectID :: "+ lienexport.getProjectId());
		} catch (Exception e) {
			
			errorLogger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		conn.close();
	}
	
		
	}

}

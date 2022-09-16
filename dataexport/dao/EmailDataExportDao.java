package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.EmailDataExport;

import util.DBProvider;

public class EmailDataExportDao {

	
	public void insertEmailDataExportData(String databaseName, EmailDataExport emaildataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_email_data_export("
					+ "project_id,"
					+ "type_,"
					+ "date_sent,"
					+ "date_received,"
					+ "from_,"
					+ "to_,"
					+ "description_,"
					+ "mail_faxdocs_id,"
					+ "mail_faxdocs_name)value(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, emaildataexport.getProjectId());
			ps.setString(2,  emaildataexport.getType());
			ps.setString(3,  emaildataexport.getDateSent());
			ps.setString(4,  emaildataexport.getDateReceived());
			ps.setString(5, emaildataexport.getFrom());
			ps.setString(6, emaildataexport.getTo());
			ps.setString(7,  emaildataexport.getDescription());
			ps.setString(8, emaildataexport.getMailfaxDocsId());
			ps.setString(9,  emaildataexport.getMailfaxDocsName());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ emaildataexport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ emaildataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

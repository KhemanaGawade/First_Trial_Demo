package com.filevine.dataexport.dao;

import static util.Constants.CONST_ENV;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBProvider;
import com.filevine.dataexport.domain.ContactEmailExport;

/**
 * This is Dao class used for database operation for contact's email details
*/
public class ContactEmailExportDAO {
	
	/**
	 * Inserting all ContactEmailExport class values into database contact email table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertContactEmailData(String database,ContactEmailExport contactEmailexport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact_email(" + 
					"contact_id," + 
					"person_id,"+
					" address," + 
					" label,"
					+"email_id)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,contactEmailexport.getContactId());
			ps.setString(2, contactEmailexport.getEmailId());
			ps.setString(3, contactEmailexport.getAddress());
			ps.setString(4, contactEmailexport.getLabel());
			ps.setString(5, contactEmailexport.getPersonId());
		
			

			ps.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		conn.close();
	}
	
		
	}

}

package com.filevine.dataexport.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.filevine.dataexport.domain.ContactPhoneExport;

import util.DBProvider;

/**
 * This is Dao class used for database operation for contact's phone details
*/
public class ContactPhoneExportDAO {
	
	/**
	 * Inserting all ContactPhoneExport class values into database contact phone table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertContactEmailData(String database,ContactPhoneExport contactPhoneexport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact_phone(" + 
					"contact_id," + 
					"phone_id," +
					" phone_number ," + 
					" rawNumber," + 
					" label,"
					+"person_id)values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,contactPhoneexport.getContactId());
			ps.setInt(2, contactPhoneexport.getId());
			ps.setString(3, contactPhoneexport.getNumber());
			ps.setString(4, contactPhoneexport.getRawNumber());
			ps.setString(5, contactPhoneexport.getLabel());
			ps.setString(6, contactPhoneexport.getPersonId());
			

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

package com.filevine.dataexport.dao;

import static util.Constants.CONST_ENV;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBProvider;
import com.filevine.dataexport.domain.ContactAddressExport;

/**
 * This is Dao class used for database operation for contact address details
*/
public class ContactAddressExportDAO {

	/**
	 * Inserting all ContactAddressExport class values into database contact address table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertContactAddressData(String database,ContactAddressExport contactAddressexport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {

			String sql = "insert into "+database+".filevine_contact_address(" + 
					"contact_id," + 
					"address_id ," +
					" address_line1," + 
					" address_line2," + 
					"city  ," + 
					" state," + 
					" zip ," + 
					" full_address  ," + 
					" label,person_id)values(?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,contactAddressexport.getContactId());
			ps.setInt(2, contactAddressexport.getId());
			ps.setString(3, contactAddressexport.getLine1());
			ps.setString(4, contactAddressexport.getLine2());
			ps.setString(5, contactAddressexport.getCity());
			ps.setString(6, contactAddressexport.getState());
			ps.setString(7, contactAddressexport.getZip());
			ps.setString(8, contactAddressexport.getFullAddress());
			ps.setString(9, contactAddressexport.getLabel());
			ps.setString(10, contactAddressexport.getPersonId());

			ps.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}


	}

}

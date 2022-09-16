package com.filevine.dataexport.dao;

import static util.Constants.CONST_ENV;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBProvider;

import com.filevine.dataexport.domain.ContactExport;

/**
 * This is Dao class used for database operation for contact details
*/
public class ContactExportDAO {
	
	/**
	 * Inserting all ContactExport class values into database contact table by creating connection class object
	 * & PreparedStatement object
	 */
	public void insertContactEmailData(String database,ContactExport contactexport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact(" + 
					"contact_id," + 
					"role," +
					" person_id," + 
					"org_id," + 
					"firstname  ," + 
					"lastName," + 
					"is_single_name," + 
					" fullname  ," + 
					"ssn," +
					"birthdate," +
					"notes," +
					"from_company," +
					"specialty," +
					"gender ," +
					"c_language ," +
					"marital_status," +
					"middle_name," +
					"is_texting_permitted ," +
					"remarket ," +
					"abbreviated_name," +
					"driver_license_number," +
					"is_type_client," +
					"is_type_adjuster ," +
					"is_type_defendant," +
					"is_type_plaintiff," +
					"is_type_attorney ," +
					"is_type_firm," +
					"is_type_expert," +
					"is_type_involved_party ," +
					"is_type_judge ," +
					"is_type_court," +
					"is_type_insurance_company," +
					"salutation," +
					"bar_number," +
					"fiduciary," +
					"is_minor," +
					"unique_id," +
					" search_names,"
					+ "project_id,person_type,role_title )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,contactexport.getID());
			ps.setString(2, contactexport.getRole());
			ps.setInt(3, contactexport.getPersonID());
			ps.setInt(4, contactexport.getOrgID());
			ps.setString(5, contactexport.getFirstName());
			ps.setString(6, contactexport.getLastName());
			ps.setBoolean(7, contactexport.isIsSingleName());
			ps.setString(8, contactexport.getFullname());
			ps.setString(9, contactexport.getSsn());
			
			ps.setString(10, contactexport.getBirthDate());
			ps.setString(11, contactexport.getNotes());
			ps.setString(12, contactexport.getFromCompany());
			ps.setString(13, contactexport.getSpecialty());
			ps.setString(14, contactexport.getGender());
			ps.setString(15, contactexport.getLanguage());
			ps.setString(16,contactexport.getMaritalStatus());
			ps.setString(17, contactexport.getMiddleName());
			ps.setString(18, contactexport.getIsTextingPermitted());
			ps.setBoolean(19, contactexport.isRemarket());
			ps.setString(20, contactexport.getAbbreviatedName());
			ps.setString(21, contactexport.getDriverLicenseNumber());
			ps.setBoolean(22,contactexport.isIsTypeClient());
			ps.setBoolean(23, contactexport.isIsTypeClient());
			ps.setBoolean(24, contactexport.isIsTypeDefendant());
			ps.setBoolean(25, contactexport.isIsTypePlaintiff());
			ps.setBoolean(26, contactexport.isIsTypeAttorney());
			ps.setBoolean(27, contactexport.isIsTypeFirm());
			ps.setBoolean(28,contactexport.isIsTypeExpert());
			ps.setBoolean(29, contactexport.isIsTypeMedicalProvider());
			ps.setBoolean(30, contactexport.isIsTypeInvolvedParty());
			ps.setBoolean(31, contactexport.isIsTypeJudge());
			ps.setBoolean(32, contactexport.isIsTypeCourt());
			ps.setBoolean(33, contactexport.isIsTypeInsuranceCompany());
			ps.setString(34,contactexport.getSalutation());
			ps.setString(35, contactexport.getFiduciary());
			ps.setBoolean(36, contactexport.isIsMinor());
			ps.setString(37, contactexport.getUniqueID());
			ps.setString(38, contactexport.getSearchNames());
			ps.setString(39, contactexport.getProjectId());
			ps.setString(40, contactexport.getPersonType());
			ps.setString(41, contactexport.getRoleTitle());
			
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

	/**
	 * return a list of contact ids from filevine_contact table by passing database name
	 * @throws Exception
	 */
	public ArrayList<String> getContactID(String databaseName) throws Exception{
		
		Connection conn=DBProvider.getJDBC();
		Statement stmt;
		stmt=conn.createStatement();
		String sql=null;
		ResultSet rst;
		ArrayList<String>  contactList=new ArrayList<String>();
		
		
			sql="SELECT contact_id FROM "+databaseName+"filevine_contact ";
		
		rst=stmt.executeQuery(sql);
		
		while(rst.next()) {
	     	String contactID= rst.getString("contact_id");
	     	
	     	contactList.add(contactID);
		}
		
		return contactList;
	}


}

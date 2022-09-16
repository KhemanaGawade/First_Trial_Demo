package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.filevine.dataexport.domain.ContactExport;
import com.filevine.dataexport.domain.ContactInfoDataDomain;

import util.DBProvider;

public class ContactInfoDataDao {

	
	public void insertContactData(String database,ContactInfoDataDomain contactinfodatadomain) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact_data_export(" 
					+"Project_Id," 
					+"client_id_," 
					+" role_," 
					+"person_id,"
					+"first_name, "
					+ "middle_name,"
					+ "last_name,"
					+ "full_name,"
					+ "from_company,"
					+ "job_title,"
					+ "department_,"
					+ "prefix_,"
					+ "suffix_,"
					+ "nick_name,"
					+ "birth_date,"
					+ "person_types,"
					+ "is_texting_permitted,"
					+ "gender_,"
					+ "language_,"
					+ "marital_status,"
					+ "ssn_,"
					+ "specialty_,"
					+ "notes_,"
					+ "driver_license_number,"
					+ "salutation_,"
					+ "bar_number,"
					+ "fiduciary_,"
					+ "remarket_,"
					+ "education_,"
					+ "children_,"
					+ "spouse_,"
					+ "tax_id,"
					+ "is_minor,"
					+ "city_state_born_in,"
					+ "abbreviated_name,"
					+ "records_keeper,"
					+ "work_role,"
					+ "org_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
	
ps=conn.prepareStatement(sql);
			ps.setString(1,contactinfodatadomain.getProjectId());
			ps.setString(2, contactinfodatadomain.getId());
			ps.setString(3,contactinfodatadomain.getRole());
			ps.setString(4, contactinfodatadomain.getPersonId());
			ps.setString(5, contactinfodatadomain.getFirstName());
			ps.setString(6,contactinfodatadomain.getMiddleName());
			ps.setString(7, contactinfodatadomain.getLastName());
			ps.setString(8, contactinfodatadomain.getFullName());
			ps.setString(9, contactinfodatadomain.getFromCompany());
			ps.setString(10, contactinfodatadomain.getJobTitle());
			ps.setString(11, contactinfodatadomain.getDepartment());
			ps.setString(12,contactinfodatadomain.getPrefix());
			ps.setString(13, contactinfodatadomain.getSuffix());
			ps.setString(14, contactinfodatadomain.getNickName());
			ps.setString(15, contactinfodatadomain.getBirthDate());
			ps.setString(16, contactinfodatadomain.getPersonTypes());
			ps.setString(17,contactinfodatadomain.getIsTextingPermitted());
			ps.setString(18, contactinfodatadomain.getGender());
			ps.setString(19, contactinfodatadomain.getLanguage());
			ps.setString(20, contactinfodatadomain.getMaritalStatus());
			ps.setString(21, contactinfodatadomain.getSsn());
			ps.setString(22, contactinfodatadomain.getSpecialty());
			ps.setString(23,contactinfodatadomain.getNotes());
			ps.setString(24, contactinfodatadomain.getDriverLicenseNumber());
			ps.setString(25, contactinfodatadomain.getSalutation());
			ps.setString(26, contactinfodatadomain.getBarNumber());
			ps.setString(27, contactinfodatadomain.getFiduciary());
			ps.setString(28, contactinfodatadomain.getRemarket());
			ps.setString(29,contactinfodatadomain.getEducation());
			ps.setString(30, contactinfodatadomain.getChildren());
			ps.setString(31, contactinfodatadomain.getSpouse());
			ps.setString(32, contactinfodatadomain.getTaxId());
			ps.setString(33, contactinfodatadomain.getIsMinor());
			ps.setString(34, contactinfodatadomain.getCityStateBornIn());
			ps.setString(35, contactinfodatadomain.getAbbreviatedName());
			ps.setString(36, contactinfodatadomain.getRecordsKeeper());
			ps.setString(37, contactinfodatadomain.getWorkRole());
			ps.setString(38, contactinfodatadomain.getOrgID());
			ps.executeUpdate();
			
			System.out.println("Data  has been exported for ProjectID :: "+ contactinfodatadomain.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ contactinfodatadomain.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
//		public ArrayList<String> getContactID(String databaseName) throws Exception{
//			
//			Connection conn=DBProvider.getJDBC();
//			Statement stmt;
//			stmt=conn.createStatement();
//			String sql=null;
//			ResultSet rst;
//			ArrayList<String>  contactList=new ArrayList<String>();
//			
//			
//				sql="SELECT contact_id FROM "+databaseName+"filevine_contact ";
//			
//			rst=stmt.executeQuery(sql);
//			
//			while(rst.next()) {
//		     	String contactID= rst.getString("contact_id");
//		     	
//		     	contactList.add(contactID);
//			}
//			
//			return contactList;
//		}
//	
	
	
	
	
	}
	
	
	
	
}

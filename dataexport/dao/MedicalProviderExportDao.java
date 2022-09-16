package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.filevine.dataexport.domain.MedicalProviderExport;

import util.DBProvider;

public class MedicalProviderExportDao {

	public void insertMedicalProviderData(String database, MedicalProviderExport medicalExport) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact(" + 
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
					"is_type_medical_provider," +
					"is_type_involved_party ," +
					"is_type_judge ," +
					"is_type_court," +
					"is_type_insurance_company," +
					"salutation," +
					"bar_number," +
					"fiduciary," +
					"is_minor," +
					" search_names,"
					+ "project_id,person_type,unique_id )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,medicalExport.getPersonId());
			ps.setString(2, medicalExport.getOrgId());
			ps.setString(3, medicalExport.getFirstName());
			ps.setString(4, medicalExport.getLastName());
			ps.setString(5, medicalExport.getIsSingleName());
			ps.setString(6, medicalExport.getFullname());
			ps.setString(7, medicalExport.getSsn());
			ps.setString(8, medicalExport.getBirthDate());
			ps.setString(9, medicalExport.getNotes());
			ps.setString(10, medicalExport.getFromCompany());
			ps.setString(11, medicalExport.getSpecialty());
			ps.setString(12, medicalExport.getGender());
			ps.setString(13, medicalExport.getLanguage());
			ps.setString(14,medicalExport.getMaritalStatus());
			ps.setString(15, medicalExport.getMiddleName());
			ps.setString(16, medicalExport.getIsTextingPermitted());
			ps.setString(17, medicalExport.getRemarket());
			ps.setString(18, medicalExport.getAbbreviatedName());
			ps.setString(19, medicalExport.getDriverLicenseNumber());
			ps.setString(20,medicalExport.getIsTypeClient());
			ps.setString(21, medicalExport.getIsTypeAdjuster());
			ps.setString(22, medicalExport.getIsTypeDefendant());
			ps.setString(23, medicalExport.getIsTypePlaintiff());
			ps.setString(24, medicalExport.getIsTypeAttorney());
			ps.setString(25, medicalExport.getIsTypeFirm());
			ps.setString(26,medicalExport.getIsTypeExpert());
			ps.setString(27, medicalExport.getIsTypeMedicalProvider());
			ps.setString(28, medicalExport.getIsTypeInvolvedParty());
			ps.setString(29, medicalExport.getIsTypeJudge());
			ps.setString(30, medicalExport.getIsTypeCourt());
			ps.setString(31, medicalExport.getIsTypeInsuranceCompany());
			ps.setString(32,medicalExport.getSalutation());
			ps.setString(33,medicalExport.getBarNumber());
			ps.setString(34, medicalExport.getFiduciary());
			ps.setString(35, medicalExport.getIsMinor());
			ps.setString(36, medicalExport.getSearchNames());
			ps.setString(37, medicalExport.getProjectId());
			ps.setString(38, medicalExport.getPersonType());
			ps.setString(39, medicalExport.getUniqueID());
			
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

	public void insertPhoneData(String database, MedicalProviderExport medicalExport) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact_phone(" + 
					"contact_id," + 
					"phone_id," +
					" phone_number ," + 
					" rawNumber," + 
					" label)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,medicalExport.getPersonId());
			ps.setString(2, medicalExport.getPhoneId());
			ps.setString(3, medicalExport.getNumber());
			ps.setString(4, medicalExport.getRawNumber());
			ps.setString(5, medicalExport.getPhoneLabel());
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

	public void insertAddressData(String database, MedicalProviderExport medicalExport) throws SQLException {
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
					" label)values(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,medicalExport.getPersonId());
			ps.setString(2, medicalExport.getAddressId());
			ps.setString(3, medicalExport.getLine1());
			ps.setString(4, medicalExport.getLine2());
			ps.setString(5, medicalExport.getCity());
			ps.setString(6, medicalExport.getState());
			ps.setString(7, medicalExport.getZip());
			ps.setString(8, medicalExport.getFullAddress());
			ps.setString(9, medicalExport.getAddressLabel());
			ps.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
	}

	public void insertEmailData(String database, MedicalProviderExport medicalExport) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contact_email(" + 
					"contact_id," + 
					" email_id ," + 
					" address," + 
					" label)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,medicalExport.getPersonId());
			ps.setString(2, medicalExport.getEmailId());
			ps.setString(3, medicalExport.getAddress());
			ps.setString(4, medicalExport.getEmailLable());
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

	public void inserwitnessData(String database, MedicalProviderExport medicalExport) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_witness_export(" + 
					"projectId," + 
					"id," + 
					" witness_id ," + 
					" full_name," + 
					" created_date)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,medicalExport.getProjectId());
			ps.setString(2,medicalExport.getId());
			ps.setString(3, medicalExport.getPersonId());
			ps.setString(4, medicalExport.getFullname());
			ps.setString(5, medicalExport.getCreated_date());
			ps.executeUpdate();
			System.out.println("data inserted for witness id: "+medicalExport.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		conn.close();
	}
	
		
	}

	public void inserEmployerData(String database, MedicalProviderExport medicalExport) throws SQLException {
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			
			String sql = "insert into "+database+".filevine_contactLinking_export(" + 
					"projectId," + 
					"id," + 
					" contact_id ," + 
					" full_name," + 
					" created_date,def_notes,referal_source,clientInfo_notes)values(?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,medicalExport.getProjectId());
			ps.setString(2,medicalExport.getId());
			ps.setString(3, medicalExport.getPersonId());
			ps.setString(4, medicalExport.getFullname());
			ps.setString(5, medicalExport.getCreated_date());
			ps.setString(6, medicalExport.getDefendanNotes());
			ps.setString(7, medicalExport.getReferalSource());
			ps.setString(8, medicalExport.getClientInfoNote());
			ps.executeUpdate();
			System.out.println("data inserted for contact linking id: "+medicalExport.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		conn.close();
	}
		
	}

}

package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.AdvanceClientCostExport;
import com.filevine.dataexport.domain.PartysDataExport;

import util.DBProvider;

public class PartysDataExportDao {

	public void insertPartysData(String databaseName, PartysDataExport PartysDataExport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_party_data_export("
					+ "project_id,"
					+ "defendant_type,"
					+ "defendant_,"
					+ "counsel_,"
					+ "co_counsels,"
					+ "personal_counsel,"
					+ "lawsuit_filed,"
					+ "is_defendanta_business,"
					+ "process_server,"
					+ "defendant_served,"
					+ "date_of_service,"
					+ "manner_of_service,"
					+ "proof_of_service_filed,"
					//+ "check_number,"
					+ "date_of_filing,"
					+ "party_notes,"
					+ "has_defendant_responded_to_complaint,"
					+ "type_of_business,"
					+ "agent_for_process_of_service_name,"
					+ "agent_for_process_of_service_id,"
					+ "pos_id,"
					+ "pos_file_name,"
					+ "documents_file_name,"
					+ "documents_id)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, PartysDataExport.getProjectId());
			ps.setString(2,  PartysDataExport.getDefendantType());
			ps.setString(3,  PartysDataExport.getDefendant());
			ps.setString(4,  PartysDataExport.getCounsel());
			ps.setString(5,  PartysDataExport.getCoCounsels());
			ps.setString(6, PartysDataExport.getPersonalCounsel());
			ps.setString(7,  PartysDataExport.getLawsuitFiled());
			ps.setString(8,  PartysDataExport.getIsDefendantaBusiness());
			ps.setString(9,  PartysDataExport.getProcessServer());
			ps.setString(10, PartysDataExport.getDefendantServed());
			ps.setString(11,  PartysDataExport.getDateOfService());
			ps.setString(12,  PartysDataExport.getMannerOfService());
			ps.setString(13,  PartysDataExport.getProofOfServiceFiled());
			ps.setString(14, PartysDataExport.getDateOfFiling());
			ps.setString(15, PartysDataExport.getPartyNotes());
			//ps.setString(16, advanceclientcostexport.getCheckNumber());
			ps.setString(16, PartysDataExport.getHasDefendantRespondedToComplaint());
			
			ps.setString(17,  PartysDataExport.getTypeOfBusiness());
			ps.setString(18,  PartysDataExport.getAgentForProcessOfServiceName());
			ps.setString(19, PartysDataExport.getAgentForProcessOfServiceId());
			ps.setString(20, PartysDataExport.getPosId());
			ps.setString(21, PartysDataExport.getPosFileName());
			ps.setString(22, PartysDataExport.getDocumentsFileName());
			ps.setString(23, PartysDataExport.getDocumentsId());
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ PartysDataExport.getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ PartysDataExport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	
	}
	
	
	
}

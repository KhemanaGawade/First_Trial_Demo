package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.MDC;


import com.filevine.dataexport.domain.TeamDataExport;

import util.DBProvider;

public class TeamDataExportDao {

	
	
	public void insertTeamData(String databaseName, TeamDataExport teamdataexport ) throws SQLException {
		
		MDC.put("path", "Firm Central Matter Export");
		MDC.put("fid", databaseName);
		Connection conn=DBProvider.getJDBC();
	
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_team_data_export("
					+ "project_id,"
					+ "id_,"
					+ "first_name,"
					+ "last_name,"
					+ "full_name,"
					+ "email_,"
					+ "is_current_user,"
					+ "contextual_reference,"
					+ "user_name,"
					+ "is_first_primary,"
					+ "is_primary,"
					+ "position_,"
					+ "is_admin,"
					+ "is_filevine_system_admin,"
					+ "team_,"
					+ "access_level,"
					+ "is_only_primary,"
					+ "is_subscribed,"
					+ "section_shares,"
					+ "picture_url,"
					+ "tag_role_id,"
					+ "name_)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
	
	
			ps.setInt(1, teamdataexport .getProjectId());
			ps.setString(2,  teamdataexport .getId());
			ps.setString(3,  teamdataexport.getFirstName());
			ps.setString(4,  teamdataexport.getLastName());
			ps.setString(5,  teamdataexport.getFullName());
			ps.setString(6, teamdataexport.getEmail());
			ps.setString(7,  teamdataexport.getIsCurrentUser());
			ps.setString(8,  teamdataexport.getContextualReference());
			ps.setString(9,  teamdataexport.getUserName());
			ps.setString(10, teamdataexport.getIsFirstPrimary());
			ps.setString(11,  teamdataexport.getIsPrimary());
			ps.setString(12,  teamdataexport.getPosition());
			ps.setString(13,  teamdataexport.getIsAdmin());
			ps.setString(14, teamdataexport.getIsFilevineSystemAdmin());
			ps.setString(15, teamdataexport.getTeam());
			ps.setString(16, teamdataexport.getAccessLevel());
			ps.setString(17, teamdataexport.getIsOnlyPrimary());
			ps.setString(18,  teamdataexport.getIsSubscribed());
			ps.setString(19,  teamdataexport.getSectionShares());
			ps.setString(20,  teamdataexport.getPictureUrl());
			ps.setString(21, teamdataexport.getTagRoleId());
			ps.setString(22, teamdataexport.getName());
//			ps.setString(16, teamdataexport.getAccessLevel());
//			ps.setString(17, teamdataexport.getIsOnlyPrimary());
			
			ps.executeUpdate();
			System.out.println("Data  has been exported for ProjectID :: "+ teamdataexport .getProjectId());
			
		}catch(Exception e) {
			System.out.println("Data  all ready  exported for ProjectID :: "+ teamdataexport.getProjectId());
			e.printStackTrace();
		}finally {
			conn.close();
		}
	
	
	
	
	
	
	
	}
	
	
	
	
}

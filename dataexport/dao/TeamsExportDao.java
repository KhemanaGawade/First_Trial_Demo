package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.domain.TeamsExport;

import util.DBProvider;

public class TeamsExportDao {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
	public HashMap<Integer,Integer> projectIdcountList(String databaseName) throws Exception {
		Map<Integer,Integer> projectIdCountList=new HashMap<Integer,Integer>();
		Connection conn=DBProvider.getJDBC();
		Statement st=conn.createStatement();
		ResultSet rs=null;
		String sql="select project_id,count(project_id) from "+databaseName+".filevine_teams_export group by project_id";
		rs=st.executeQuery(sql);
	
		while(rs.next()) {
			int projectIdCount=rs.getInt("project_id");
			int projectId=rs.getInt("count(project_id)");
			System.out.println("Project Id:" +projectIdCount+" Count="+projectId);
			projectIdCountList.put(projectIdCount, projectId);
		}
		return (HashMap<Integer, Integer>) projectIdCountList;
	}

	public void insertTeamsData(TeamsExport teamsExport, String databaseName) throws Exception {
		
		MDC.put("path", "File Vine:: Teams Export");
		
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {
			String sql="insert into "+databaseName+".filevine_teams_export("
					+ "project_id,"
					+ "team_id,"
					+ "team_email,"
					+ "team_fullname,"
					+ "team_username,"
					+ "team_is_firPrimary,"
					+ "team_is_primary,"
					+ "team_isAdmin,"
					+ "team_type,"
					+ "tag_roleId,"
					+ "tag_roleName)"
					+ "value(?,?,?,?,?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);

			ps.setInt(1,teamsExport.getProjectId());
			ps.setInt(2, teamsExport.getTeamId());
			ps.setString(3, teamsExport.getTeamEmail());
			ps.setString(4, teamsExport.getTeamFullName());
			ps.setString(5, teamsExport.getTeamUserName());
			ps.setString(6,teamsExport.getTeamIsFirstPrimary());
			ps.setString(7,teamsExport.getTeamIsPrimary());
			ps.setString(8,teamsExport.getIsAdmin());
			ps.setString(9, teamsExport.getTeamType());
			ps.setInt(10, teamsExport.getTagRoleId());
			ps.setString(11, teamsExport.getTagRoleName());
			
			ps.executeUpdate();
//			System.out.println("Team id :: "+ teamsExport.getTeamId() +" has been exported!!");
			eventLogger.info("Team id :: "+ teamsExport.getTeamId() +" has been exported!!");
			
		}catch(Exception e) {
			errorLogger.error("Invalid data !!",e);
			e.printStackTrace();
		}finally {
			conn.close();
		}

		
	}

}

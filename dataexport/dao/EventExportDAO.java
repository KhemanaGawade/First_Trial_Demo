package com.filevine.dataexport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.filevine.dataexport.domain.EventExport;

import util.DBProvider;

public class EventExportDAO {
	public void insertEventData(String database,EventExport eventexport) throws Exception
	{
		Connection conn=DBProvider.getJDBC();
		PreparedStatement ps=null;
		try {

			String sql = "insert into "+database+".filevine_event_2(" + 
					"owner_id ," + 
					" owner_name ," + 
					" event_id," + 
					" title," + 
					" allday," + 
					" event_start," + 
					" event_end," + 
					" location," + 
					"  notes ," + 
					" calendar_event_type ," + 
					" project_id," + 
					" creator_id)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,eventexport.getOwnerID());
			ps.setString(2, eventexport.getOwnerName());
			ps.setString(3, eventexport.getEventID());
			ps.setString(4, eventexport.getTitle());
			ps.setBoolean(5, eventexport.getAllDay());
			ps.setString(6, eventexport.getStart());
			ps.setString(7, eventexport.getEnd());
			ps.setString(8, eventexport.getLocation());
			ps.setString(9, eventexport.getNotes());
			ps.setString(10, eventexport.getCalendarEventType());
			ps.setInt(11, eventexport.getProjectID());

			ps.setInt(12, eventexport.getCreatorID());


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

	public ArrayList<String> getdate() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://clxdemodb.eastus.cloudapp.azure.com/migrationdbmaster","cloudlexuser","Cloudlex123!@#");
	//	Connection con = DriverManager.getConnection("clx_db_url","clx_db_username","clx_db_password");
		
		//	Statement st = con.createStatement();
		ArrayList<String>  Date = new ArrayList<String>();
		String sql1 = " select * from migrationdbmaster.filevine_cal_date_range;";
		PreparedStatement pst  = con.prepareStatement(sql1);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			Date.add(rs.getString("date_range")) ;

		}
		pst.close();
		return Date;

	}

	public ArrayList<Integer> getProjectID(String databaseName) throws Exception{

		Connection conn=util.DBProvider.getJDBC();
		Statement stmt;
		stmt=conn.createStatement();
		String sql=null;
		ResultSet rst;
		ArrayList<Integer>  projectList=new ArrayList<Integer>();
		sql="SELECT  distinct project_id FROM "+databaseName+".filevine_event";

		rst=stmt.executeQuery(sql);

		while(rst.next()) {
			int projectID= rst.getInt("project_id");

			projectList.add(projectID);
		}

		return projectList;
	}

}

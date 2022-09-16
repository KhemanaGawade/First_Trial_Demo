package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.TeamsExportService;

import util.DBProvider;



public class TeamsExportMain {

	public static void main(String[] args) throws Exception {

		TeamsExportService service =  new TeamsExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine TEAMS EXPORT !!!!!!!!");
		System.out.println("**************************************************");

		Connection con= DBProvider .getJDBC();
		Scanner scanner=new Scanner(System.in);

		System.out.println("Please provide database name : ");
		String databaseName=scanner.nextLine();

		System.out.println("Please provide file vine cookie : ");
		String cookie=scanner.nextLine();
		
		System.out.println("Please provide batch : ");
		int batch=scanner.nextInt();
		scanner.close();

		ProjectIdDAO projectIdDAO =new ProjectIdDAO();


		ArrayList<String> projectIdList=new ArrayList<String>();
		try {
			projectIdList=projectIdDAO.getProjectIDList(databaseName,con,batch);
			for(String projectId : projectIdList) {
				try {
				if(projectId!=null) {
					//get Response
					String response=service.getTeamsResponse(cookie,projectId);

					//Export teams data
					service.getTeamsData(response,databaseName);
				}
				}catch(Exception e) {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

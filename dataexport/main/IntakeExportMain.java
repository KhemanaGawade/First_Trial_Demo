package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import com.filevine.dataexport.dao.InsuranceExportDao;
import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.IntakeExportService;

import util.DBProvider;


public class IntakeExportMain {
	
	public static void main(String[] args) {
		IntakeExportService service =  new IntakeExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Intake EXPORT !!!!!!!!");
		System.out.println("**************************************************");

        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please provide database name.");
		String databaseName=scanner.nextLine();
		
		System.out.println("Please provide filevine cookie.");
		String cookie=scanner.nextLine();
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
		Connection con = DBProvider .getJDBC();
		scanner.close();

		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(databaseName, con,batch);

			for(String projectID: projectId ){
				// for intake
//				String projectID="5350454";
			   String response=service.getIntakeDetailsResponse(cookie,projectID);
				
				service.getIntakeDetailData(response,databaseName);
				// for Intake/Accident Info
				//get Response
			//	String response=service.getIntakeResponse(cookie,projectID);
				
				//Export teams data
			//	service.getIntakeData(response,databaseName);
				}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		

	}

}

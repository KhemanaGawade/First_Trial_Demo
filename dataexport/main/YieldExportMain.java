package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.InsuranceExportDao;
import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.IntakeExportService;
import com.filevine.dataexport.service.YieldExportService;

import util.DBProvider;

public class YieldExportMain {
	public static void main(String[] args) {
		YieldExportService service =  new YieldExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Yield EXPORT !!!!!!!!");
		System.out.println("**************************************************");

        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please provide database name.");
		String databaseName=scanner.nextLine();
		
		System.out.println("Please provide filevine cookie.");
		String cookie=scanner.nextLine();
		
		Connection con = DBProvider .getJDBC();
		
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
		scanner.close();

		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(databaseName, con,batch);

			for(String projectID: projectId ){
	
				//get Response
				String response=service.getYieldResponse(cookie,projectID);
				
				//Export teams data
				service.getYieldData(response,databaseName,projectID);
				}
			} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		

	}


}

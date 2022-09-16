package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.ContactEmailDataExportService;


import util.DBProvider;

public class ContactEmailDataExportMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE EMAIL DATA EXPORT ..... !!");
		System.out.println("=========================================================\n");
		ContactEmailDataExportService  contactemaildataexportservice =new ContactEmailDataExportService ();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please enter Database name.");
		String  database = scanner.nextLine();
		
		System.out.println("Please enter cookie.");
		String  cookie=scanner.nextLine();
		
		
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();

		scanner.close();
		
		Connection con = DBProvider .getJDBC();
		
		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(database, con,batch);
			for(String projectID: projectId ){
		
		
		String response=contactemaildataexportservice.getAdvanceClientCostExportResponse(cookie,projectID);
		contactemaildataexportservice.getAdvanceClientCostData(response,database,projectID);
		System.out.println(response);
	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

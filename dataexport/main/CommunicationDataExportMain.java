package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.CommunicationDataExportService;

import util.DBProvider;

public class CommunicationDataExportMain {

	public static void main(String[] args) {
	
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE COOMUNICATION DATA EXPORT ..... !!");
		System.out.println("=========================================================\n");
		CommunicationDataExportService communicationdataexportservice=new CommunicationDataExportService();
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
				
			
		String response=communicationdataexportservice.getAdvanceClientCostExportResponse(cookie,projectID);
		communicationdataexportservice.getAdvanceClientCostData(response,database);
		System.out.println(response);
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

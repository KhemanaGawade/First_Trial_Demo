package com.filevine.dataexport.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.NotesDataExportService;

import util.DBProvider;

public class NotesDataExportMain {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE NOTES DATA EXPORT ..... !!");
		System.out.println("=========================================================\n");
		 NotesDataExportService notesdataexportservice=new  NotesDataExportService();
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
//				try {
////					int offSet=0;
////					int totalCount=0;
////					do {
//		
						String response=notesdataexportservice.getAdvanceClientCostExportResponse(cookie, projectID);
					//	totalCount=notesdataexportservice.getNotesCount(response,database);
					//	System.out.println(totalCount);
						
						notesdataexportservice.getAdvanceClientCostData(response,database);
						System.out.println(response);
		
//							offSet=offSet+25;
		
//					}while(totalCount==25);
//					System.out.println(totalCount);
			}
					}catch(Exception e) {
						System.out.println("data is not exported");
					}
		
		
	
				
		
		
			}
		
		
		
		
	}



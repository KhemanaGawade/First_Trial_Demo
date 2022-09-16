package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.FileVineSettlementExportService;

import util.DBProvider;



public class FileVineSettlementExportMain {

	public static void main(String[] args) {
		
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE CASE SETTLEMENT EXPORT ..... !!");
		System.out.println("=========================================================\n");
	
		Scanner scanner=new Scanner(System.in);
	
		FileVineSettlementExportService fileVinesettlementexportservice=new FileVineSettlementExportService();
	
		System.out.println("Please enter Database name.");
		String  databaseName = scanner.nextLine();
		
		System.out.println("Please enter cookie.");
		String  cookie=scanner.nextLine();
		
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
	
		scanner.close();
		
		Connection con = DBProvider .getJDBC();
		
		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(databaseName, con,batch);
			for(String projectID: projectId ){
	
		String response=fileVinesettlementexportservice.getFileVineSettlementExportResponse(cookie,projectID);
		fileVinesettlementexportservice.getFileVineSettlementData(response,databaseName,projectID);
		System.out.println(response);
	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	
	}

}

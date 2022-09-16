package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.ContactAddressDataExportService;
import com.filevine.dataexport.service.ContactPhoneDataExportService;

import util.DBProvider;

public class ContactPhoneDataExportMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE PHONE DATA EXPORT ..... !!");
		System.out.println("=========================================================\n");
		ContactPhoneDataExportService  contactphonedataexportservice =new ContactPhoneDataExportService ();
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
		
		
		String response=contactphonedataexportservice .getAdvanceClientCostExportResponse(cookie,projectID);
		contactphonedataexportservice .getAdvanceClientCostData(response,database,projectID);
		System.out.println(response);
	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

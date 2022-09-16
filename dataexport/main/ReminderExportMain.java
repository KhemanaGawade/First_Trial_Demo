package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.CaseSummaryExportService;
import com.filevine.dataexport.service.ReminderExportService;

import util.DBProvider;

public class ReminderExportMain {
	public static void main(String[] args) {

		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE REMINDER EXPORT ..... !!");
		System.out.println("=========================================================\n");


		Connection con = DBProvider .getJDBC();
		Scanner scanner=new Scanner(System.in);
		ReminderExportService service=new ReminderExportService();
		System.out.println("Please enter Database name : ");
		String  database = scanner.nextLine();

		System.out.println("Please enter cookie : ");
		String  cookie=scanner.nextLine();

		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
	
		scanner.close();

		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(database, con,batch);

			for(String projectID: projectId ){
				//get Response
				String response=service.getReminderResponse(cookie,projectID);

				service.getReminderData(response , database);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

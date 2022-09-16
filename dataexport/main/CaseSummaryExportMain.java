package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.CaseSummaryExportService;

import util.DBProvider;

/**
 * This class is used to export case summary.
 */
public class CaseSummaryExportMain {

	/**
	 * This main method is used to pass database name, cookie and batch for cases/project using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class CaseSummaryExportService and dao class ProjectIdDAO.
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE CASE SUMMARY EXPORT ..... !!");
		System.out.println("=========================================================\n");
		Connection con = DBProvider .getJDBC();
		Scanner scanner=new Scanner(System.in);
		CaseSummaryExportService service=new CaseSummaryExportService();
		System.out.println("Please enter Database name : ");
		String  database = scanner.nextLine();

		System.out.println("Please enter cookie : ");
		String  cookie=scanner.nextLine();

		System.out.println("Please enter clientId(i.e each filevine client have unique client id, that you can find on api url : ");
		String  clientId=scanner.nextLine();
		
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
	
		scanner.close();
		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			/**
			 * Getting batch wise list of project ids from project info table
			 */
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(database, con,batch);

			for(String projectID: projectId ){
				/**
    			 * Calling method of service class to get response by passing cookie, project id and client id
    			 */
				//get Response
				String response=service.getCaseSummaryResponse(cookie,projectID,clientId);

				service.getCaseSummaryData(response , database);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.ClientIntakkeExportService;

import util.DBProvider;

/**
 * This class is used to export client intake details for cases.
 */
public class ClientIntakeExportMain {

	/**
	 * This main method is used to pass database name, cookie and batch for cases/project using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class ClientIntakkeExportService and dao class ProjectIdDAO.
	 * @param args
	 */
	public static void main(String[] args) {
		ClientIntakkeExportService service =  new ClientIntakkeExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Client Intake EXPORT !!!!!!!!");
		System.out.println("**************************************************");

        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please provide database name.");
		String databaseName=scanner.nextLine();
		
		System.out.println("Please provide file vine cookie.");
		String cookie=scanner.nextLine();
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
	
		scanner.close();
		Connection con = DBProvider .getJDBC();
		try {
			ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
			/**
			 * Getting batch wise list of project ids from project info table
			 */
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(databaseName, con,batch);

		for(String projectID: projectId ){
		/**
    	 * Calling method of service class to get response by passing cookie, project id
    	 */
		//get Response
		String response=service.getClientIntakeResponse(cookie,projectID);
		
		//Export teams data
		service.getClientIntakeData(response,databaseName);
}
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

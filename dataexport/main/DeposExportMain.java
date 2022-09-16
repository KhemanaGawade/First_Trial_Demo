package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.DeposExportService;
import com.filevine.dataexport.service.PlntfsDiscExportService;

import util.DBProvider;

/**
 * This class is used to export depos for cases.
 */
public class DeposExportMain {

	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
	/**
	 * This main method is used to pass database name, cookie and batch for cases/project using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class DeposExportService and dao class ProjectIdDAO.
	 * @param args
	 */
	public static void main(String[] args)  {
		
		MDC.put("path", "File Vine:: Depos Export");
		// TODO Auto-generated method stub
		DeposExportService service =  new DeposExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Depos EXPORT !!!!!!!!");
		System.out.println("**************************************************");

        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please provide database name.");
		String databaseName=scanner.nextLine();
		
		System.out.println("Please provide file vine cookie.");
		String cookie=scanner.nextLine();
		
		System.out.println("Please enter batch : ");
		int  batch=scanner.nextInt();
		Connection con = DBProvider .getJDBC();
		scanner.close();

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
				String response=service.getDeposResponse(cookie,projectID);

				service.getDeposData(response , databaseName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.DefenceCounselExportService;
import com.filevine.dataexport.service.DeposExportService;

import util.DBProvider;

/**
 * This class is used to export defence counsel for cases.
 */
public class DefenceCounselExportMain {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
	/**
	 * This main method is used to pass database name, cookie and batch for cases/project using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class DefenceCounselExportService and dao class ProjectIdDAO.
	 * @param args
	 */
	public static void main(String[] args)  {
		
		MDC.put("path", "File Vine:: DefenceCounsel Export");
		// TODO Auto-generated method stub
		DefenceCounselExportService service =  new DefenceCounselExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine DefenceCounsel EXPORT !!!!!!!!");
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
				String response=service.getDefenceCounselResponse(cookie,projectID);

				service.getDefenceCounselData(response , databaseName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

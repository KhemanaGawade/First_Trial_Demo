package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.DeposExportService;
import com.filevine.dataexport.service.LitigationExportService;

import util.DBProvider;

public class LitigationExportMain {

	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");
	
	public static void main(String[] args)  {
		
		MDC.put("path", "File Vine:: Litigation Export");
		// TODO Auto-generated method stub
		LitigationExportService service =  new LitigationExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Litigation EXPORT !!!!!!!!");
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
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(databaseName, con,batch);

			for(String projectID: projectId ){
				//get Response
				String response=service.getLitigationResponse(cookie,projectID);

				service.getLitigationData(response , databaseName,projectID);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


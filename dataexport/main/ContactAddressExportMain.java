package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.ContactAddressExportService;

import util.DBProvider;

/**
 * This class is used to export address for contacts.
 */
public class ContactAddressExportMain {
	
	/**
	 * This main method is used to pass database name, cookie and batch for cases/project using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class ContactAddressExportService and dao class ProjectIdDAO.
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = DBProvider .getJDBC();
		
		Scanner scanner=new Scanner(System.in);
		ContactAddressExportService service=new ContactAddressExportService();
		System.out.println("Please enter Database name.");
		String  database = scanner.nextLine();
		
		System.out.println("Please enter cookie.");
		String  cookie=scanner.nextLine();
		
		System.out.println("Please enter batch.");//1
		int  batch=scanner.nextInt();
		
		scanner.close();
        try {
        	
        	ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
        	/**
			 * Getting batch wise list of project ids from project info table
			 */
    		ArrayList<String> projectIdList= ProjectIdDAO.getProjectIDList(database, con, batch);
    		for(String id: projectIdList)
    		{
    			/**
    			 * Calling method of service class to get response by passing cookie, project id 
    			 */
			//get Response
			String response=service.getContactAddressResponse(id,cookie);
			
			
			   service.getContactAddressData(database,response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}

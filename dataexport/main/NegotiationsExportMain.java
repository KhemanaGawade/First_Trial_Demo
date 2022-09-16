package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.InsuranceExportDao;
import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.NegotiationsExportService;

import util.DBProvider;

public class NegotiationsExportMain {
//
	public static void main(String[] args) throws Exception {
		NegotiationsExportService service =  new NegotiationsExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Negotiations EXPORT !!!!!!!!");
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
			ArrayList<String> projectId= ProjectIdDAO.getProjectIDList(databaseName, con,batch);

			for(String projectID: projectId ){
		//get Response
		String response=service.getNegotiationsResponse(cookie,projectID);
		
		//Export teams data
		service.getNegotiationsData(response,databaseName);
}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

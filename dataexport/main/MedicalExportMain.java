package com.filevine.dataexport.main;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.MedicalExportService;

import util.DBProvider;

public class MedicalExportMain {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		MedicalExportService service=new MedicalExportService();
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
//				String projectID="105903";
			for(String projectID: projectId ){
  			//get Response
			String response=service.getMedicalResponse(cookie,projectID);
			   service.getMedicalData(response,database);
			}
 		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}

package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.MedicalExportService;
import com.filevine.dataexport.service.MedicalProviderExportService;

import util.DBProvider;

public class MedicalProviderExportMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		MedicalProviderExportService service=new MedicalProviderExportService();
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
//				String projectID="5350454";
  			//get Response
			String response=service.getMedicalProviderResponse(cookie,projectID);
			   service.getMedicalProviderData(response,database);
			}
 		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}

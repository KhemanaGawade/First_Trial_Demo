package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.MotionDataExportService;
import com.filevine.dataexport.service.PleadingsDataExportService;

import util.DBProvider;

public class MotionDataExportMain {

	public static void main(String[] args) {
		
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE MOTION DATA  EXPORT ..... !!");
		System.out.println("=========================================================\n");
		MotionDataExportService motiondataexportservice=new MotionDataExportService  ();
		Scanner scanner=new Scanner(System.in);
		
		
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
		
		String response=motiondataexportservice.getMotionDataExportsResponse(cookie,projectID);
		motiondataexportservice.getMotionData(response,database);
		System.out.println(response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

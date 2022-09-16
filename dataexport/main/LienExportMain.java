package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.LienExportService;

import util.DBProvider;

public class LienExportMain {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		LienExportService service=new LienExportService();
		Connection con = DBProvider .getJDBC();
		System.out.println("Please enter Database name.");
		String  database = scanner.nextLine();
		
		System.out.println("Please enter cookie.");
		String  cookie=scanner.nextLine();
		System.out.println("Please enter batch.");
		int  batch=scanner.nextInt();
		scanner.close();
        try {
        	ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
    		ArrayList<String> projectIdList= ProjectIdDAO.getProjectIDList(database, con,batch);
     		for(String id: projectIdList)
    		{
			//get Response
			String response=service.getLienResponse(cookie,id);
     	    service.getLienData(response , database);
   		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}

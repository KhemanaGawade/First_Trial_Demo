package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.ExpensesExportService;

import util.DBProvider;

/**
 * This class is used to export expense related to cases.
 */
public class ExpensesExportMain {
	
	/**
	 * This main method is used to pass database name, cookie and batch for cases/project using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class ExpensesExportService and dao class ProjectIdDAO.
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = DBProvider .getJDBC();
		Scanner scanner=new Scanner(System.in);
		ExpensesExportService service=new ExpensesExportService();
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
      			
//      			String id="9545527";
			String response=service.getExpenseResponse(cookie,id);
			
			
			   service.getExpenseData(response , database);
    		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

}

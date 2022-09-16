package com.filevine.dataexport.main;

import java.sql.Connection;


import java.util.ArrayList;
import java.util.Scanner;

import com.filevine.dataexport.dao.ProjectIdDAO;
import com.filevine.dataexport.service.NotesExportService;

import util.DBProvider;

public class FileVineNotesExportMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBProvider .getJDBC();
		NotesExportService service =  new NotesExportService();
		System.out.println("**************************************************");
		System.out.println("FILEVINE NOTES EXPORT !!!!!!!!");
		System.out.println("**************************************************");

		Scanner scanner=new Scanner(System.in);

		System.out.println("Please provide database name : ");
		String database=scanner.nextLine();

		System.out.println("Please provide filevine cookie : ");
		String cookie=scanner.nextLine();
		
		System.out.println("Please provide batch for ids : ");
		int batch=scanner.nextInt();

		scanner.close();

		ProjectIdDAO ProjectIdDAO=new ProjectIdDAO();
		ArrayList<String> projectIdList= ProjectIdDAO.getProjectIDList(database, con,batch);

		for(String projectId : projectIdList) {
			try {
			int offSet=0;
			int totalCount=0;
			do {
				String response=service.getNotesResponse(cookie,projectId,offSet);
				totalCount=service.getNotesCount(response,database);
				System.out.println("LN :: "+totalCount);

				System.out.println("response"+response);
				service.getNotesData(response, database);

				offSet=offSet+25;
			}while(totalCount==25);
			System.out.println(totalCount);
			}catch(Exception e) {
				continue;
			}
			
		}
	}

}

package com.filevine.dataexport.main;

import java.util.ArrayList;
import java.util.Scanner;


import com.filevine.dataexport.dao.CommentsNotesExportDao;
import com.filevine.dataexport.dao.CommentsNotesTaskExportDao;
import com.filevine.dataexport.service.CommentsNotesExportService;
import com.filevine.dataexport.service.CommentsNotesTaskExportService;

public class FileVineTasksExportMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//	Connection con = DBProvider .getJDBC();


		System.out.println("**************************************************");
		System.out.println("FILEVINE TASKS EXPORT !!!!!!!!");
		System.out.println("**************************************************");


		Scanner scanner=new Scanner(System.in);

		System.out.println("Please provide database name : ");
		String databaseName=scanner.nextLine();

		System.out.println("Please provide fileVine cookie : ");
		String cookie=scanner.nextLine();
		
		System.out.println("Please provide batch : ");
		int batch=scanner.nextInt();
		scanner.close();
		
		CommentsNotesTaskExportService service =  new CommentsNotesTaskExportService();
		CommentsNotesTaskExportDao commentsNotesExportDao =new CommentsNotesTaskExportDao();

		ArrayList<Integer> taskIdList=new ArrayList<Integer>();
		taskIdList=commentsNotesExportDao.getTasksIdList(databaseName,batch);
		try {
		for(int taskId : taskIdList) {//1,2,3,4,5,6,7,8,9,10,11,12,13
			if(taskId!=0) {
				System.out.println("taskId :"+taskId);
				//get Response
				String response=service.getCommentsNotesResponse(cookie,taskId);

				//Export tasks data
				service.getTaskData(response,databaseName);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

package com.filevine.dataexport.main;

import java.util.ArrayList;
import java.util.Scanner;


import com.filevine.dataexport.dao.CommentsNotesExportDao;
//
import com.filevine.dataexport.service.CommentsNotesExportService;
/**
 * This class is used to export comment notes data.
 */
public class CommentsNotesExportMain {

	/**
	 * This main method is used to pass database name, cookie and batch for notes using scanner.
	 * Need to login filevine ui to get cookie from response.
	 * Creating object for service class CommentsNotesExportService and dao class CommentsNotesExportDao.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
	
		CommentsNotesExportService service =  new CommentsNotesExportService();
		System.out.println("**************************************************");
		System.out.println("FileVine Notes Comments EXPORT !!!!!!!!");
		System.out.println("**************************************************");

        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Please provide database name : ");
		String databaseName=scanner.nextLine();
		
		System.out.println("Please provide fileVine cookie : ");
		String cookie=scanner.nextLine();
		
		System.out.println("Please provide batch fileVine notes : ");
		String batch=scanner.nextLine();
		scanner.close();
		
		CommentsNotesExportDao commentsNotesExportDao =new CommentsNotesExportDao();
	
		ArrayList<Integer> noteIdList=new ArrayList<Integer>();
		noteIdList=commentsNotesExportDao.getNoteIdList(databaseName,batch);
		
		for(int noteId : noteIdList) {
		if(noteId!=0) {
//			int noteId=115378809;
			//get Response
			String response=service.getCommentsNotesResponse(cookie,noteId);
		
			//Export notes data
			service.getCommentsNotesData(response,databaseName,noteId);
		}
		}
	}

}

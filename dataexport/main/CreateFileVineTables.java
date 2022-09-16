package com.filevine.dataexport.main;

import java.util.Scanner;

import com.filevine.dataexport.service.CreateFilevineTableService;

/**
 * This class is used to create tables for filevine ui.
 */
public class CreateFileVineTables {

	/**
	 * This main method is used to pass database name using scanner.
	 * Creating object for service class CreateFilevineTableService.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE TABLES CREATION ..... !!");
		System.out.println("=========================================================\n");
		
		
		CreateFilevineTableService service=new CreateFilevineTableService();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter database name : ");
		String dbName=scanner.nextLine();
		
		/**
		 * Calling method of service class to create tables in fileine database
		 */
		service.CreateFileVineTables(dbName);

		scanner.close();
	}

}

package com.filevine.dataexport.main;

import java.io.IOException;
import java.util.Scanner;

import com.filevine.dataexport.service.ProjectIdInsetService;

import jxl.JXLException;

public class ProjectIdInsertMain {

	public static void main(String[] args) throws JXLException, IOException {
		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE INSERT PROJECT ID  ..... !!");
		System.out.println("=========================================================\n");
		
		
		
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("Enter Database name :");
			String databaseName=scanner.nextLine();
			
			ProjectIdInsetService.projectDetailsInsert(databaseName);;
			
			scanner.close();
		}

	}

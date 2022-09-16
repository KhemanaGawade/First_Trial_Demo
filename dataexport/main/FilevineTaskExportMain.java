package com.filevine.dataexport.main;

import java.sql.Connection;
import java.util.Scanner;

import org.json.JSONObject;

import com.filevine.dataexport.service.FilevineTaskExportService;

import util.DBProvider;

public class FilevineTaskExportMain {

	public static void main(String[] args) {

		System.out.println("\n=========================================================");
		System.out.println(" FILEVINE TASK EXPORT ..... !!");
		System.out.println("=========================================================\n");


		Connection con = DBProvider .getJDBC();
		Scanner scanner=new Scanner(System.in);
		FilevineTaskExportService service=new FilevineTaskExportService();
		System.out.println("Please enter Database name : ");
		String  database = scanner.nextLine();

		System.out.println("Please enter cookie : ");
		String  cookie=scanner.nextLine();

		scanner.close();

		try {
			
			//get Response
			String responseForCount=service.getTaskResponseForCount(cookie);
			//get Response
        	String 	res=responseForCount;
    		int i=res.indexOf('{');
    		res=res.substring(i);
    		JSONObject matters =new JSONObject(res);
    		JSONObject jsonObject=matters.getJSONObject("data");
    		String temp=jsonObject.getString("totalCount");
    		int a=0;
    		for (int j = 0; j<Integer.parseInt(temp); j+=25) {
//    			if(j<Integer.parseInt(temp)) {
    			System.out.println("Offset : "+j);
			   String response=service.getTaskResponse(cookie,j);
		    	//Export teams data
			    service.getTaskData(response , database);
				a=j;
    		}
    		a=a+25;

				//get Response
				

				
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


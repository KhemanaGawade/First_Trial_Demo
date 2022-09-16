package com.filevine.dataexport.main;

import java.util.Scanner;

import org.json.JSONObject;

import com.filevine.dataexport.dao.EventExportDAO;
import com.filevine.dataexport.service.EventExportService;


public class FileVineEventExportMain {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		EventExportService service=new EventExportService();
		System.out.println("Please enter Database name.");
		String  database = scanner.nextLine();
		
		System.out.println("Please enter cookie.");
		String  cookie=scanner.nextLine();
		
		
		scanner.close();
        try {
        	EventExportDAO  events =new EventExportDAO();

			java.util.ArrayList<String> date = events.getdate();


			//get Response
			for(String Date :date)
			{
			  String response=service.getEventResponse(Date, cookie);
			
			
			   service.getEventData(database,response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String
		 * cookie="_ga=GA1.2.1760468707.1552547687; hubspotutk=a1f6677b4a0114f71f8584489f338590; __zlcmid=rJi5LYDjQbvhBs; _ga=GA1.3.1760468707.1552547687; __hstc=121834644.a1f6677b4a0114f71f8584489f338590.1552547690480.1553919906683.1553974877902.6; _gcl_au=1.1.173660776.1563259789; _gid=GA1.2.825550399.1563259797; __RequestVerificationToken=R1aKRRWzs6bOgJV1WFXZHAQNAJCF4h5yLaSGFzuhPncGBsKafE6sORXGu3VQUgbgaX-BkmtbXgHOnN7odle9SMQQsqN15LqiwaFWhj36CwE1; .AspNet.ApplicationCookie=qFSf0S5cxuaubQxOzbsTiwIZej0b2AUHJRJFjy6lTK3OfRg06SzGjjyeY2_TXu04Rty1PVw2tV7MUkFmg28MaGhRFInOrUT7URTZb_O-yl9zwSRdzZbvr6GopTvmjcsFNmwHpqRwtarq9NGne9TCiwMHDxfvS6aWrChpGLlVVmBEo_Yt_oQwi8PV976zL3y2mO7nr6UBqTOzB3r2mIAVZJjb31OjYbSR4mKykIo_YHBuzP6xQVpWHXbMvDuy8rQ5tNOTN3vE5T6slTvoRo-n3-YRshYrjzOzyaVUg615yp72f6oBpFIwNe9OXvSQWcu1Tne_bA7NigDqIAaNFO126YOt96wlctdZ7m2-SDmD0F7U0NPcck3nnW16m0G0Fu-JN7kapAGnctiIDWzHSCY6lAu6aUyBdysOEQHz8PstwyUdHP11CcbaNM9xAM7nYKuhxYjVjZib_7Ai3IFeJYxEMeXtIabOFdP8Qtr7PVPrvb4bZAiX5AqhTQCsHbP-JbTb; _gid=GA1.3.825550399.1563259797; _gat=1 "
		 * ;
		 * 
		 * String response=null; JSONObject jsonObj=null; String url=
		 * "https://app.filevine.com/api/calendar/displayableevents/2019-05-26/2019-07-07/?timezoneOffset=-330";
		 * //
		 * https://app.filevine.com/api/calendar/displayableevents/2019-07-28/2019-09-01
		 * /?timezoneOffset=-330 try { WebResource
		 * webResource=Client.create().resource(url);
		 * response=webResource.header("Cookie", cookie).get(String.class);
		 * 
		 * System.out.println(response);
		 * 
		 * JSONObject jsonObject=new JSONObject(response);
		 * System.out.println(jsonObject); jsonObj=jsonObject.getJSONObject("data");
		 * 
		 * if (!jsonObj.get("start").equals(null)) { String ownerID=(String)
		 * jsonObj.get("start");
		 * 
		 * System.out.println("start : "+ ownerID); }else { }
		 * 
		 * }catch(Exception e) { e.printStackTrace(); //
		 * System.out.println("Fail to get repsonse from UI"); }
		 */
		
	}

}

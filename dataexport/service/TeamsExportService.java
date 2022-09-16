package com.filevine.dataexport.service;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.TeamsExportDao;
import com.filevine.dataexport.domain.TeamsExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TeamsExportService {
	
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	public String getTeamsResponse(String cookie, String projectId) {
		
		MDC.put("path", "File Vine:: Teams Export");
		String response=null;
		String url="https://app.filevine.com/api/projects/"+projectId+"/team";
     //   String url="https://app.filevine.com/api/projects/"+projectId+"/team";
		
		try {
			WebResource webResource=Client.create().resource(url);
			response=webResource.header("Cookie", cookie).get(String.class);
			//System.out.println(response);
			//eventLogger.info("Response has been exported!!");
			}
			
		catch(Exception e) {
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Fail to get repsonse from UI");
//			e.printStackTrace();
		}
		return response;
	}

	public void getTeamsData(String response, String databaseName) throws Exception {
		TeamsExportDao teamsExportDao=new TeamsExportDao();
		TeamsExport teamsExport=new TeamsExport();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject jsonObj=new JSONObject(res);
		if(!jsonObj.opt("projectID").equals(null)){
		  teamsExport.setProjectId(jsonObj.getInt("projectID"));
		}
		JSONArray teamData=jsonObj.getJSONArray("data");
		
		System.out.println(teamData.length());
		for(int j=0; j<=teamData.length()-1; j++) {
			JSONObject jsonObject=teamData.getJSONObject(j);	
			
			if(!jsonObject.opt("id").equals(null)){
				teamsExport.setTeamId(jsonObject.getInt("id"));
			}
			if(!jsonObject.opt("email").equals(null)) {
				teamsExport.setTeamEmail(jsonObject.getString("email"));
			}
			if(!jsonObject.opt("fullname").equals(null)) {
				teamsExport.setTeamFullName(jsonObject.getString("fullname"));
			}
			if(!jsonObject.opt("username").equals(null)) {
				teamsExport.setTeamUserName(jsonObject.getString("username"));
			}
			if(!jsonObject.opt("isFirstPrimary").equals(null)) {
				teamsExport.setTeamIsFirstPrimary(jsonObject.getString("isFirstPrimary"));
			}
			if(!jsonObject.opt("isPrimary").equals(null)) {
				teamsExport.setTeamIsPrimary(jsonObject.getString("isPrimary"));
			}
			if(!jsonObject.opt("isAdmin").equals(null)) {
				teamsExport.setIsAdmin(jsonObject.getString("isAdmin"));
			}
			// support for collaborators & main for Followers
			if(!jsonObject.opt("team").equals(null)) {
				teamsExport.setTeamType(jsonObject.getString("team"));
			}
			JSONArray tagRoleArray=jsonObject.getJSONArray("tagRoles");
	     		if(tagRoleArray.length()==0) {
	     			teamsExport.setTagRoleId(0);
					teamsExport.setTagRoleName(null);
					teamsExportDao.insertTeamsData(teamsExport, databaseName);	
	     		}else {
	     				
				for(int k=0; k<=tagRoleArray.length()-1; k++) {
					JSONObject jsonTagRole = tagRoleArray.getJSONObject(k);
						
					if(!jsonTagRole.opt("id").equals(null)) {
					teamsExport.setTagRoleId(jsonTagRole.getInt("id"));
//						tagRoleId=jsonTagRole.getInt("id");
					}
					if(!jsonTagRole.opt("name").equals(null)) {
						teamsExport.setTagRoleName(jsonTagRole.getString("name"));
//						tagRoleName=jsonTagRole.getString("name");
					}
//					Map<Integer,Integer> projectIdCountList=new HashedMap<Integer,Integer>();
//					projectIdCountList=teamsExportDao.projectIdcountList(databaseName);
//					for(Map.Entry<Integer, Integer> val: projectIdCountList.entrySet()) {
//						if(val.getKey().equals(teamsExport.getProjectId()) && val.getValue().equals(teamData.length())) {
//							System.out.println("Data already exported");
//						}else {
							teamsExportDao.insertTeamsData(teamsExport, databaseName);		
//						}
//					}
					
				}
			}
			
			
		}
	}
  
}

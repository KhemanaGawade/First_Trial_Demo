package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.TeamDataExportDao;
import com.filevine.dataexport.domain.TeamDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TeamDataExportService {

	
	public String getAdvanceClientCostExportResponse(String cookie,String projectID) {
		
		String response=null;
		
		String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/team";
		
		//String payload="{\"pageNumber\":1,\"pageSize\":20,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"dateofinvoice14183\",\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).get(String.class);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;

		}
	
	public void getAdvanceClientCostData(String response, String databaseName) throws JSONException, SQLException {
		
		TeamDataExport teamdataexport=new TeamDataExport();
		TeamDataExportDao teamdataexportdao=new TeamDataExportDao();
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject Data=new JSONObject(res);
		if(!Data.opt("projectID").equals(null)){
			teamdataexport.setProjectId(Data.getInt("projectID"));
		}
	
		if(!Data.opt("data").equals(null)) {
			JSONArray communication=Data.getJSONArray("data");
			for(int j=0; j<=communication.length()-1; j++) {
				JSONObject jsonObject=communication.getJSONObject(j);
	
				if(jsonObject.isNull("id")) {
					teamdataexport.setId( null);
				}else {
					
			    if(!jsonObject.opt("id").equals(null)){
			    	teamdataexport.setId( jsonObject.getString("id"));
			    }}
	
				if(jsonObject.isNull("firstName")) {
					teamdataexport.setFirstName( null);
				}else {
					
			    if(!jsonObject.opt("firstName").equals(null)){
			    	teamdataexport.setFirstName( jsonObject.getString("firstName"));
			    }}
				
				if(jsonObject.isNull("lastName")) {
					teamdataexport.setLastName( null);
				}else {
					
			    if(!jsonObject.opt("lastName").equals(null)){
			    	teamdataexport.setLastName( jsonObject.getString("lastName"));
			    }}
				
				if(jsonObject.isNull("fullname")) {
					teamdataexport.setFullName( null);
				}else {
					
			    if(!jsonObject.opt("fullname").equals(null)){
			    	teamdataexport.setFullName( jsonObject.getString("fullname"));
			    }}
				if(jsonObject.isNull("email")) {
					teamdataexport.setEmail( null);
				}else {
					
			    if(!jsonObject.opt("email").equals(null)){
			    	teamdataexport.setEmail( jsonObject.getString("email"));
			    }}
				
				if(jsonObject.isNull("isCurrentUser")) {
					teamdataexport.setIsCurrentUser( null);
				}else {
					
			    if(!jsonObject.opt("isCurrentUser").equals(null)){
			    	teamdataexport.setIsCurrentUser( jsonObject.getString("isCurrentUser"));
			    }}
				
				if(jsonObject.isNull("contextualReference")) {
					teamdataexport.setContextualReference( null);
				}else {
					
			    if(!jsonObject.opt("contextualReference").equals(null)){
			    	teamdataexport.setContextualReference( jsonObject.getString("contextualReference"));
			    }}
				
				if(jsonObject.isNull("username")) {
					teamdataexport.setUserName( null);
				}else {
					
			    if(!jsonObject.opt("username").equals(null)){
			    	teamdataexport.setUserName( jsonObject.getString("username"));
			    }}
				
				if(jsonObject.isNull("isFirstPrimary")) {
					teamdataexport.setIsFirstPrimary( null);
				}else {
					
			    if(!jsonObject.opt("isFirstPrimary").equals(null)){
			    	teamdataexport.setIsFirstPrimary( jsonObject.getString("isFirstPrimary"));
			    }}
				
				if(jsonObject.isNull("isPrimary")) {
					teamdataexport.setIsPrimary( null);
				}else {
					
			    if(!jsonObject.opt("isPrimary").equals(null)){
			    	teamdataexport.setIsPrimary( jsonObject.getString("isPrimary"));
			    }}
				
				if(jsonObject.isNull("position")) {
					teamdataexport.setPosition( null);
				}else {
					
			    if(!jsonObject.opt("position").equals(null)){
			    	teamdataexport.setPosition( jsonObject.getString("position"));
			    }}
				
				if(jsonObject.isNull("isAdmin")) {
					teamdataexport.setIsAdmin( null);
				}else {
					
			    if(!jsonObject.opt("isAdmin").equals(null)){
			    	teamdataexport.setIsAdmin( jsonObject.getString("isAdmin"));
			    }}
				
				if(jsonObject.isNull("isFilevineSystemAdmin")) {
					teamdataexport.setIsFilevineSystemAdmin( null);
				}else {
					
			    if(!jsonObject.opt("isFilevineSystemAdmin").equals(null)){
			    	teamdataexport.setIsFilevineSystemAdmin( jsonObject.getString("isFilevineSystemAdmin"));
			    }}
				
				if(jsonObject.isNull("team")) {
					teamdataexport.setTeam( null);
				}else {
					
			    if(!jsonObject.opt("team").equals(null)){
			    	teamdataexport.setTeam( jsonObject.getString("team"));
			    }}
				
				if(jsonObject.isNull("accessLevel")) {
					teamdataexport.setAccessLevel( null);
				}else {
					
			    if(!jsonObject.opt("accessLevel").equals(null)){
			    	teamdataexport.setAccessLevel( jsonObject.getString("accessLevel"));
			    }}
				
				if(jsonObject.isNull("isOnlyPrimary")) {
					teamdataexport.setIsOnlyPrimary( null);
				}else {
					
			    if(!jsonObject.opt("isOnlyPrimary").equals(null)){
			    	teamdataexport.setIsOnlyPrimary( jsonObject.getString("isOnlyPrimary"));
			    }}
				
				if(jsonObject.isNull("isSubscribed")) {
					teamdataexport.setIsSubscribed( null);
				}else {
					
			    if(!jsonObject.opt("isSubscribed").equals(null)){
			    	teamdataexport.setIsSubscribed( jsonObject.getString("isSubscribed"));
			    }}
				
				if(jsonObject.isNull("sectionShares")) {
					teamdataexport.setSectionShares( null);
				}else {
					
			    if(!jsonObject.opt("sectionShares").equals(null)){
			    	teamdataexport.setSectionShares( jsonObject.getString("sectionShares"));
			    }}
				
				if(jsonObject.isNull("pictureUrl")) {
					teamdataexport.setPictureUrl( null);
				}else {
					
			    if(!jsonObject.opt("pictureUrl").equals(null)){
			    	teamdataexport.setPictureUrl( jsonObject.getString("pictureUrl"));
			    }}
				
				if(jsonObject.isNull("tagRoles")){
					teamdataexport.setTagRoleId(null);
				}else {
					JSONArray communication3=jsonObject.getJSONArray("tagRoles");
					for(int k=0; k<=communication3.length()-1; k++) {
					JSONObject jsonobject=communication3.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					teamdataexport.setTagRoleId(jsonobject.getString("id"));
				}}
					
					if(jsonObject.isNull("tagRoles")){
						teamdataexport.setName(null);
					}else {
						JSONArray communication4=jsonObject.getJSONArray("tagRoles");
						for(int k=0; k<=communication4.length()-1; k++) {
						JSONObject jsonobject=communication4.getJSONObject(k);
					if(!jsonobject.opt("name").equals(null)){
						teamdataexport.setName(jsonobject.getString("name"));
					}}
				
//				if(jsonObject.isNull("name")) {
//					teamdataexport.setName( null);
//				}else {
//					
//			    if(!jsonObject.opt("name").equals(null)){
//			    	teamdataexport.setName( jsonObject.getString("name"));
//			    }}
//					
//				if(jsonObject.isNull("selector")) {
//					teamdataexport.setSelector( null);
//				}else {
//					
//			    if(!jsonObject.opt("selector").equals(null)){
//			    	teamdataexport.setSelector( jsonObject.getString("selector"));
//			    }}	
//					
//				if(jsonObject.isNull("position")) {
//					teamdataexport.setPositionRole( null);
//				}else {
//					
//			    if(!jsonObject.opt("position").equals(null)){
//			    	teamdataexport.setPositionRole( jsonObject.getString("position"));
//			    }}	
//				
//				if(jsonObject.isNull("legacyRoleID")) {
//					teamdataexport.setLegacyRoleID( null);
//				}else {
//					
//			    if(!jsonObject.opt("legacyRoleID").equals(null)){
//			    	teamdataexport.setLegacyRoleID( jsonObject.getString("legacyRoleID"));
//			    }}	
//				
//				if(jsonObject.isNull("isProjectOwner")) {
//					teamdataexport.setisProjectOwner( null);
//				}else {
//					
//			    if(!jsonObject.opt("isProjectOwner").equals(null)){
//			    	teamdataexport.setisProjectOwner( jsonObject.getString("isProjectOwner"));
//			    }}
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				teamdataexportdao.insertTeamData(databaseName,teamdataexport);
	
	
	
			}
	
	
	
	
		}
	
	
	}
	
	}
}



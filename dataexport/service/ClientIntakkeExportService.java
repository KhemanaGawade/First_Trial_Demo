package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.ClientIntakeExportDao;
import com.filevine.dataexport.dao.NegotiationsExportDao;
import com.filevine.dataexport.domain.ClientIntakeExport;
import com.filevine.dataexport.domain.NegotiationsExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


/**
 * This is Service class having methods to get response for client intake tab from ui
 **/

public class ClientIntakkeExportService {
	public static final Logger eventLogger = Logger.getLogger("eventLoggerV10");
	public static final Logger errorLogger = Logger.getLogger("errorLoggerV10");

	/**
	 * @return a response for client intake for each case from filevine  url by passing parameter cookie and project id
	 */
	public String getClientIntakeResponse(String cookie, String projectID) {
		MDC.put("path", "File Vine:: Client Intake Export");

        String response=null;
        String url="https://app.filevine.com/api/projects/"+projectID+"/custom/clientintake16409?page=1";
    //    String url="https://app.filevine.com/api/projects/"+projectID+"/custom/clientintake16407?page=1";
		String payLoad="{\"pageNumber\":1,\"pageSize\":100,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
        
//        String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\""
//				+ "00000000-0000-0000-0000-000000000000\",\"sortField\":\"offerdemandsettled89449\","
//				+ "\"sortAscending\":false,\"filterField\":null,\"filterText\":\"\"}";
		try {
			WebResource webRespource=Client.create().resource(url);
     		response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
         	eventLogger.info("Response has been exported!!");
		}
		catch(Exception e) {
			e.printStackTrace();
			errorLogger.error("Fail to get response from UI!!",e);
//			System.out.println("Fail to get repsonse from UI");
		}
		return response;
	}

	
	/**
	 * Taking input as a response.
	 * Converting JSON response to OBJECT
	 * Creating object of ClientIntakeExport class
	 * Setting values to setter methods of ClientIntakeExport class
	 * Calling method of ClientIntakeExportDao to insert all values using databaseName
	 */
	public void getClientIntakeData(String response, String databaseName) throws JSONException, SQLException {
		ClientIntakeExportDao clientIntakeExportDao=new ClientIntakeExportDao();
		ClientIntakeExport clientIntakeExport=new ClientIntakeExport();
		System.out.println(response);
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);
		
		JSONObject jsonObj=new JSONObject(res);
		if(!jsonObj.opt("projectID").equals(null)){
			clientIntakeExport.setProjectId(jsonObj.getString("projectID"));
		}
		
		JSONObject data=jsonObj.getJSONObject("data");
		if(!data.isNull("customObject")) {
		JSONObject jsonObject=data.getJSONObject("customObject");
		if(!jsonObject.isNull("clienthasanumber191345")) {
		if(!jsonObject.opt("clienthasanumber191345").equals(null)){
			clientIntakeExport.setClienthasanumber(jsonObject.getString("clienthasanumber191345"));
		}}else {
			clientIntakeExport.setClienthasanumber(null);
		}
		if(!jsonObject.isNull("clienthasstateidnumber191345")) {
			if(!jsonObject.opt("clienthasstateidnumber191345").equals(null)){
				clientIntakeExport.setClienthasstateidnumber(jsonObject.getString("clienthasstateidnumber191345"));
			}}else {
				clientIntakeExport.setClienthasstateidnumber(null);
		}
		if(!jsonObject.isNull("anumber191345")) {
			if(!jsonObject.opt("anumber191345").equals(null)){
				clientIntakeExport.setAnumber(jsonObject.getString("anumber191345"));
			}}else {
				clientIntakeExport.setAnumber(null);
		}
		if(!jsonObject.isNull("stateidnumber191345")) {
			if(!jsonObject.opt("stateidnumber191345").equals(null)){
				clientIntakeExport.setStateidnumber(jsonObject.getString("stateidnumber191345"));
			}}else {
				clientIntakeExport.setStateidnumber(null);
		}
		if(!jsonObject.isNull("language191345")) {
			if(!jsonObject.opt("language191345").equals(null)){
				clientIntakeExport.setLanguage_(jsonObject.getString("language191345"));
			}}else {
				clientIntakeExport.setLanguage_(null);
		}
		if(!jsonObject.isNull("currenttitle191345")) {
			if(!jsonObject.opt("currenttitle191345").equals(null)){
				clientIntakeExport.setCurrenttitle(jsonObject.getString("currenttitle191345"));
			}}else {
				clientIntakeExport.setCurrenttitle(null);
		}
		if(!jsonObject.isNull("currentemployer191345")) {
			if(!jsonObject.opt("currentemployer191345").equals(null)){
				clientIntakeExport.setCurrentemployer(jsonObject.getString("currentemployer191345"));
			}}else {
				clientIntakeExport.setCurrentemployer(null);
		}
		if(!jsonObject.isNull("referralsource191345")) {
			if(!jsonObject.opt("referralsource191345").equals(null)){
				clientIntakeExport.setReferralsource(jsonObject.getString("referralsource191345"));
			}}else {
				clientIntakeExport.setReferralsource(null);
		}
		if(!jsonObject.isNull("dateofintake191740")) {
			if(!jsonObject.opt("dateofintake191740").equals(null)){
				clientIntakeExport.setDateofintake(jsonObject.getString("dateofintake191740"));
			}}else {
				clientIntakeExport.setDateofintake(null);
		}
		if(!jsonObject.isNull("_itemHeader")) {
			JSONObject _itemHeader=jsonObject.getJSONObject("_itemHeader");
			if(!_itemHeader.opt("createdDate").equals(null)){
				clientIntakeExport.setCreatedDate(_itemHeader.getString("createdDate"));
			}}else {
				clientIntakeExport.setCreatedDate(null);
		}
		clientIntakeExportDao.insertClientIntakeData(clientIntakeExport,databaseName);
        }
	}

}

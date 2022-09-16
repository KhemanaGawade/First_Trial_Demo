package com.filevine.dataexport.service;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.filevine.dataexport.dao.LitigationDataExportDao;
import com.filevine.dataexport.dao.MedicalBillsDataExportDao;
import com.filevine.dataexport.domain.LitigationDataExports;
import com.filevine.dataexport.domain.MedicalBillsDataExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class MedicalBillsDataExportService {

	
public String getMedicalBillsDataExportResponse(String cookie,String projectID) {
		
		String response=null;
	   String url="https://caininjurylaw.filevineapp.com/api/projects/"+projectID+"/custom/s1_meds1032?page=1";

	   String payload="{\"pageNumber\":1,\"pageSize\":20,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"datetreatmentstarted15561\",\"sortAscending\":true,\"filterField\":\"provider15561\",\"filterText\":\"\"}";
	   
		try {
			WebResource webRespource=Client.create().resource(url);
			System.out.println("response is in process");
			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payload);
				System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;

		}
public void getMedicalBillsData(String response, String databaseName) throws JSONException, SQLException {
	
	MedicalBillsDataExport  medicalbillsdataexport =new MedicalBillsDataExport ();
	MedicalBillsDataExportDao medicalbillsdataexportdao=new MedicalBillsDataExportDao();
	String 	res=response;
	int i=res.indexOf('{');
	res=res.substring(i);

	JSONObject advanceClientData=new JSONObject(res);
	if(!advanceClientData.opt("projectID").equals(null)){
		medicalbillsdataexport.setProjectId(advanceClientData.getInt("projectID"));
	}
	
	JSONObject data=advanceClientData.getJSONObject("data");
	if(!data.opt("collection").equals(null)) {
		JSONArray communication=data.getJSONArray("collection");
		for(int j=0; j<=communication.length()-1; j++) {
			JSONObject jsonObject=communication.getJSONObject(j);
			
			if(jsonObject.isNull("provider15561")){
				medicalbillsdataexport.setProvider(null);
			}else {
			JSONObject communication1=jsonObject.getJSONObject("provider15561");
			if(!communication1.opt("fullname").equals(null)){
				medicalbillsdataexport.setProvider(communication1.getString("fullname"));
			}}
	
			if(jsonObject.isNull("amount15561")) {
				medicalbillsdataexport.setAmount( null);
			}else {
				
		    if(!jsonObject.opt("amount15561").equals(null)){
		    	medicalbillsdataexport.setAmount( jsonObject.getString("amount15561"));
		    }}
	
			if(jsonObject.isNull("paymentsorreductions15561")) {
				medicalbillsdataexport.setPaymentsOrReductions( null);
			}else {
				
		    if(!jsonObject.opt("paymentsorreductions15561").equals(null)){
		    	medicalbillsdataexport.setPaymentsOrReductions( jsonObject.getString("paymentsorreductions15561"));
		    }}
	
			if(jsonObject.isNull("isthisalien15561")) {
				medicalbillsdataexport.setIsThisaLien( null);
			}else {
				
		    if(!jsonObject.opt("isthisalien15561").equals(null)){
		    	medicalbillsdataexport.setIsThisaLien( jsonObject.getString("isthisalien15561"));
		    }}
	
			if(jsonObject.isNull("isbillincollections15561")) {
				medicalbillsdataexport.setIsBillInCollections( null);
			}else {
				
		    if(!jsonObject.opt("isbillincollections15561").equals(null)){
		    	medicalbillsdataexport.setIsBillInCollections( jsonObject.getString("isbillincollections15561"));
		    }}
	
			if(jsonObject.isNull("datetreatmentstarted15561")) {
				medicalbillsdataexport.setDatetreatmentstarted( null);
			}else {
				
		    if(!jsonObject.opt("datetreatmentstarted15561").equals(null)){
		    	medicalbillsdataexport.setDatetreatmentstarted( jsonObject.getString("datetreatmentstarted15561"));
		    }}
	
			if(jsonObject.isNull("datetreatmentcompleted15561")) {
				medicalbillsdataexport.setDateTreatmentCompleted( null);
			}else {
				
		    if(!jsonObject.opt("datetreatmentcompleted15561").equals(null)){
		    	medicalbillsdataexport.setDateTreatmentCompleted( jsonObject.getString("datetreatmentcompleted15561"));
		    }}
	
			if(jsonObject.isNull("providersaccountnumber15561")) {
				medicalbillsdataexport.setProvidersAccountNumber( null);
			}else {
				
		    if(!jsonObject.opt("providersaccountnumber15561").equals(null)){
		    	medicalbillsdataexport.setProvidersAccountNumber( jsonObject.getString("providersaccountnumber15561"));
		    }}
	
			if(jsonObject.isNull("plaintiffstreatmentstatus15561")) {
				medicalbillsdataexport.setPlaintiffsTreatmentStatus( null);
			}else {
				
		    if(!jsonObject.opt("plaintiffstreatmentstatus15561").equals(null)){
		    	medicalbillsdataexport.setPlaintiffsTreatmentStatus( jsonObject.getString("plaintiffstreatmentstatus15561"));
		    }}
	
			if(jsonObject.isNull("notes15561")) {
				medicalbillsdataexport.setNotes( null);
			}else {
				
		    if(!jsonObject.opt("notes15561").equals(null)){
		    	medicalbillsdataexport.setNotes( jsonObject.getString("notes15561"));
		    }}
	
			if(jsonObject.isNull("haveallbillsbeenreceived15561")) {
				medicalbillsdataexport.setHaveAllBillsBeenReceived( null);
			}else {
				
		    if(!jsonObject.opt("haveallbillsbeenreceived15561").equals(null)){
		    	medicalbillsdataexport.setHaveAllBillsBeenReceived( jsonObject.getString("haveallbillsbeenreceived15561"));
		    }}
	
			if(jsonObject.isNull("haveallbillsbeenordered15561")) {
				medicalbillsdataexport.setHaveAllbillsBeenOrdered( null);
			}else {
				
		    if(!jsonObject.opt("haveallbillsbeenordered15561").equals(null)){
		    	medicalbillsdataexport.setHaveAllbillsBeenOrdered( jsonObject.getString("haveallbillsbeenordered15561"));
		    }}
	
			if(jsonObject.isNull("billinvoicereceived15561")) {
				medicalbillsdataexport.setBillInvoiceReceived( null);
			}else {
				
		    if(!jsonObject.opt("billinvoicereceived15561").equals(null)){
		    	medicalbillsdataexport.setBillInvoiceReceived( jsonObject.getString("billinvoicereceived15561"));
		    }}
	
			if(jsonObject.isNull("recordsreceiveddate15561")) {
				medicalbillsdataexport.setRecordsReceivedDate( null);
			}else {
				
		    if(!jsonObject.opt("recordsreceiveddate15561").equals(null)){
		    	medicalbillsdataexport.setRecordsReceivedDate( jsonObject.getString("recordsreceiveddate15561"));
		    }}
	
			if(jsonObject.isNull("haveallrecordsbeenordered15561")) {
				medicalbillsdataexport.setHaveallRecordsBeenoOdered( null);
			}else {
				
		    if(!jsonObject.opt("haveallrecordsbeenordered15561").equals(null)){
		    	medicalbillsdataexport.setHaveallRecordsBeenoOdered( jsonObject.getString("haveallrecordsbeenordered15561"));
		    }}
	
			if(jsonObject.isNull("haveallrecordsbeenreceived15561")) {
				medicalbillsdataexport.setHaveAllRecordsBeenReceived( null);
			}else {
				
		    if(!jsonObject.opt("haveallrecordsbeenreceived15561").equals(null)){
		    	medicalbillsdataexport.setHaveAllRecordsBeenReceived( jsonObject.getString("haveallrecordsbeenreceived15561"));
		    }}
	
			if(jsonObject.isNull("recordsinvoicereceived15561")) {
				medicalbillsdataexport.setRecordsInvoiceReceived( null);
			}else {
				
		    if(!jsonObject.opt("recordsinvoicereceived15561").equals(null)){
		    	medicalbillsdataexport.setRecordsInvoiceReceived( jsonObject.getString("recordsinvoicereceived15561"));
		    }}
	
			if(jsonObject.isNull("recordsordereddate15561")) {
				medicalbillsdataexport.setRecordsOrderedDate( null);
			}else {
				
		    if(!jsonObject.opt("recordsordereddate15561").equals(null)){
		    	medicalbillsdataexport.setRecordsOrderedDate( jsonObject.getString("recordsordereddate15561"));
		    }}
	
			if(jsonObject.isNull("plaintiffstreatmentstatus15561")) {
				medicalbillsdataexport.setPlaintiffsTreatmentStatus( null);
			}else {
				
		    if(!jsonObject.opt("plaintiffstreatmentstatus15561").equals(null)){
		    	medicalbillsdataexport.setPlaintiffsTreatmentStatus( jsonObject.getString("plaintiffstreatmentstatus15561"));
		    }}
			
			if(jsonObject.isNull("personalhealthpayment15561")) {
				medicalbillsdataexport.setPersonalHealthPayment( null);
			}else {
				
		    if(!jsonObject.opt("personalhealthpayment15561").equals(null)){
		    	medicalbillsdataexport.setPersonalHealthPayment( jsonObject.getString("personalhealthpayment15561"));
		    }}
			
			if(jsonObject.isNull("totalreductions15561")){
				medicalbillsdataexport.setTotalReductions(null);
			}else {
				
		    if(!jsonObject.opt("totalreductions15561").equals(null)){
		    	medicalbillsdataexport.setTotalReductions( jsonObject.getString("totalreductions15561"));
		    }}
			
			if(jsonObject.isNull("billsordereddate15561")) {
				medicalbillsdataexport.setBillsOrderedDate( null);
			}else {
				
		    if(!jsonObject.opt("billsordereddate15561").equals(null)){
		    	medicalbillsdataexport.setBillsOrderedDate( jsonObject.getString("billsordereddate15561"));
		    }}
			
			if(jsonObject.isNull("billsreceiveddate15561")) {
				medicalbillsdataexport.setBillsReceivedDate( null);
			}else {
				
		    if(!jsonObject.opt("billsreceiveddate15561").equals(null)){
		    	medicalbillsdataexport.setBillsReceivedDate( jsonObject.getString("billsreceiveddate15561"));
		    }}
			
			if(jsonObject.isNull("listalldatesofservice15561")) {
				medicalbillsdataexport.setListAllDatesOfService( null);
			}else {
				
		    if(!jsonObject.opt("listalldatesofservice15561").equals(null)){
		    	medicalbillsdataexport.setListAllDatesOfService( jsonObject.getString("listalldatesofservice15561"));
		    }}
			
			if(jsonObject.isNull("pipmedpaypayment15561")) {
				medicalbillsdataexport.setPipMedpayPayment( null);
			}else {
				
		    if(!jsonObject.opt("pipmedpaypayment15561").equals(null)){
		    	medicalbillsdataexport.setPipMedpayPayment( jsonObject.getString("pipmedpaypayment15561"));
		    }}
			
//			if(jsonObject.isNull("medpaypayment15561")) {
//				medicalbillsdataexport.setMedPayPayment( null);
//			}else {
//				
//		    if(!jsonObject.opt("medpaypayment15561").equals(null)){
//		    	medicalbillsdataexport.setMedPayPayment( jsonObject.getString("medpaypayment15561"));
//		    }}
//			
			if(jsonObject.isNull("writeoffsadjustments15561")) {
				medicalbillsdataexport.setWriteOffsAdjustments( null);
			}else {
				
		    if(!jsonObject.opt("writeoffsadjustments15561").equals(null)){
		    	medicalbillsdataexport.setWriteOffsAdjustments( jsonObject.getString("writeoffsadjustments15561"));
		    }}

			if(jsonObject.isNull("clientpayment15561")) {
				medicalbillsdataexport.setClientPayment( null);
			}else {
				
		    if(!jsonObject.opt("clientpayment15561").equals(null)){
		    	medicalbillsdataexport.setClientPayment( jsonObject.getString("clientpayment15561"));
		    }}
			
			if(jsonObject.isNull("collectionagency15561")){
				medicalbillsdataexport.setCollectionAgency(null);
			}else {
			JSONObject communication4=jsonObject.getJSONObject("collectionagency15561");
			if(!communication4.opt("fullname").equals(null)){
				medicalbillsdataexport.setCollectionAgency(communication4.getString("fullname"));
			}}
	
			
			if(jsonObject.isNull("medicalrecords15561")){
				medicalbillsdataexport.setMedicalRecordsId(null);
			}else {
				JSONArray communication9=jsonObject.getJSONArray("medicalrecords15561");
				for(int k=0; k<=communication9.length()-1; k++) {
				JSONObject jsonobject=communication9.getJSONObject(k);
			if(!jsonobject.opt("id").equals(null)){
				medicalbillsdataexport.setMedicalRecordsId(jsonobject.getString("id"));
			}}}
			
			if(jsonObject.isNull("medicalrecords15561")){
				medicalbillsdataexport.setMedicalRecordsFileName(null);
			}else {
				JSONArray communication16=jsonObject.getJSONArray("medicalrecords15561");
				for(int k=0; k<=communication16.length()-1; k++) {
				JSONObject jsonobject=communication16.getJSONObject(k);
			if(!jsonobject.opt("filename").equals(null)){
				medicalbillsdataexport.setMedicalRecordsFileName(jsonobject.getString("filename"));
			}}}
			
			if(jsonObject.isNull("medicalbills15561")){
				medicalbillsdataexport.setMedicalBillsId(null);
			}else {
				JSONArray communication78=jsonObject.getJSONArray("medicalbills15561");
				for(int k=0; k<=communication78.length()-1; k++) {
				JSONObject jsonobject=communication78.getJSONObject(k);
			if(!jsonobject.opt("id").equals(null)){
				medicalbillsdataexport.setMedicalBillsId(jsonobject.getString("id"));
			}}}
			
			if(jsonObject.isNull("medicalbills15561")){
				medicalbillsdataexport.setMedicalBillsFileName(null);
			}else {
				JSONArray communication77=jsonObject.getJSONArray("medicalbills15561");
				for(int k=0; k<=communication77.length()-1; k++) {
				JSONObject jsonobject=communication77.getJSONObject(k);
			if(!jsonobject.opt("filename").equals(null)){
				medicalbillsdataexport.setMedicalBillsFileName(jsonobject.getString("filename"));
			}}}
			
			
			
		
			medicalbillsdataexportdao.insertMedicalBillsData(databaseName,	medicalbillsdataexport);	
}
	
}
}
}


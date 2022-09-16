package com.filevine.dataexport.service;


import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.filevine.dataexport.dao.CaseSummaryExportDAO;

import com.filevine.dataexport.domain.CaseSummaryExport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * This is Service class having methods to get response for case summary tab from ui
 **/
public class CaseSummaryExportService {
	
	/**
	 * @return a response for case summary from filevine  url by passing parameter cookie , client id and project id
	 */
	public String getCaseSummaryResponse(String cookie,String projectID,String clientId) {
		String response=null;
		
	//	String url="https://app.filevine.com/api/projects/"+projectID+"/custom/casesummary16433?page=1";
		
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
		
		
		
		
	//    String url="https://app.filevine.com/api/projects/10725782/custom/casesummary16407?page=1";
//	String url="https://app.filevine.com/api/projects/"+projectID+"/custom/casesummary16407?page=1";
	//String url="https://app.filevine.com/api/projects/"+projectID+"/custom/casesummary16433?page=1";
		//	String url="https://app.filevine.com/api/projects/"+projectID+"/custom/casesummary16407?page=1" ; 
     //   String url="https://app.filevine.com/api/projects/10071996/custom/casesummary16407?page=1";
		//		String url="https://app.filevine.com/api/projects/"+projectID;
	//	String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}" ;
	//  String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
		
	  
	  //String payLoad="{\"pageNumber\":1,\"pageSize\":10,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	//String payLoad="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	  
	  
	  String url ="https://app.filevine.com/api/projects/"+projectID+"/custom/casesummary16433?page=1";
	  
	  String payLoad ="{\"pageNumber\":1,\"pageSize\":50,\"collectionItemID\":\"00000000-0000-0000-0000-000000000000\",\"sortField\":\"\",\"sortAscending\":true,\"filterField\":null,\"filterText\":\"\"}";
	  
	  
	 
	  try {
			
			WebResource webRespource=Client.create().resource(url);

			response=webRespource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).header("cookie",cookie).post(String.class,payLoad);
		
//			System.out.println("response :: "+response);
		}catch(Exception e) {
			System.out.println("Not able to get response");
			e.printStackTrace();
		}

		return response;
	}
	
	
	/**
	 * Taking input as a response.
	 * Converting JSON response to OBJECT
	 * Creating object of CaseSummaryExport class
	 * Setting values to setter methods of CaseSummaryExport class
	 * Calling method of CaseSummaryExportDAO to insert all values using databaseName
	 */
	public void getCaseSummaryData(String response, String databaseName) throws Exception {
		CaseSummaryExportDAO caseSummaryExportDAO=new CaseSummaryExportDAO();
		CaseSummaryExport caseExport=new CaseSummaryExport();	
		String 	res=response;
		int i=res.indexOf('{');
		res=res.substring(i);

		JSONObject caseData=new JSONObject(res);
		if(!caseData.opt("projectID").equals(null)){
		   caseExport.setProjectId(caseData.getInt("projectID"));
		}
//		JSONArray arr = caseData.getJSONArray("projectVitals");
//		for(int k = 0; k<arr.length();k++)
//		{
//             JSONObject jsonObj= arr.getJSONObject(k);	
//             if(jsonObj.isNull("fieldName")) {
//				   caseExport.setFieldName( null);
//				}else {
//					
//			    if(!jsonObj.opt("fieldName").equals(null)){
//			        caseExport.setFieldName( jsonObj.getString("fieldName"));
//			 }}
//             if(jsonObj.isNull("friendlyName")) {
//				   caseExport.setFriendlyName( null);
//				}else {
//					
//			    if(!jsonObj.opt("friendlyName").equals(null)){
//			        caseExport.setFriendlyName( jsonObj.getString("friendlyName"));
//			 }}
//             if(jsonObj.isNull("fieldType")) {
//				   caseExport.setFieldType( null);
//				}else {
//					
//			    if(!jsonObj.opt("fieldType").equals(null)){
//			        caseExport.setFieldType( jsonObj.getString("fieldType"));
//			 }}
//             if(jsonObj.isNull("value")) {
//				   caseExport.setFieldValue(null);
//				}else {
//					
//			    if(!jsonObj.opt("value").equals(null)){
//			        caseExport.setFieldValue( jsonObj.getString("value"));
//			 }}
//             if(jsonObj.isNull("linkRefValue")) {
//				   caseExport.setLinkRefValue(null);
//				}else {
//					
//			    if(!jsonObj.opt("linkRefValue").equals(null)){
//			        caseExport.setLinkRefValue( jsonObj.getString("linkRefValue"));
//			 }}
//             if(jsonObj.isNull("position")) {
//				   caseExport.setPosition(null);
//				}else {
//					
//			    if(!jsonObj.opt("position").equals(null)){
//			        caseExport.setPosition( jsonObj.getString("position"));
//			 }}
//             caseSummaryExportDAO.insertCaseDetailsData(caseExport,databaseName);
//		}
		JSONObject cases= caseData.getJSONObject("data");	
		 if(cases.isNull("description")) {
			   caseExport.setDescription(null);
			}else {
				
		    if(!cases.opt("description").equals(null)){
		        caseExport.setDescription(cases.getString("description"));
		 }}
		 if(cases.isNull("estimatedSettlementValue")) {
			   caseExport.setEstimated_settlementvalu(null);
			}else {
				
		    if(!cases.opt("estimatedSettlementValue").equals(null)){
		        caseExport.setEstimated_settlementvalu( cases.getString("estimatedSettlementValue"));
		 }}
		 if(cases.isNull("incidentDate")) {
			   caseExport.setIncident_date(null);
			}else {
				
		    if(!cases.opt("incidentDate").equals(null)){
		        caseExport.setIncident_date( cases.getString("incidentDate"));
		 }}
		 if(cases.isNull("phaseDate")) {
			   caseExport.setPhase_date(null);
			}else {
				
		    if(!cases.opt("phaseDate").equals(null)){
		        caseExport.setPhase_date( cases.getString("phaseDate"));
		 }}
		 if(cases.isNull("smsNumber")) {
			   caseExport.setSsn_number(null);
			}else {
				
		    if(!cases.opt("smsNumber").equals(null)){
		        caseExport.setSsn_number( cases.getString("smsNumber"));
		 }}
		 
		 if(cases.isNull("emailAddress")) {
			   caseExport.setEmailAddress(null);
			}else {
				
		    if(!cases.opt("emailAddress").equals(null)){
		        caseExport.setEmailAddress( cases.getString("emailAddress"));
		 }}
		 if(cases.isNull("projectTypeName")) {
			   caseExport.setProjectTypeName(null);
			}else {
				
		    if(!cases.opt("projectTypeName").equals(null)){
		        caseExport.setProjectTypeName( cases.getString("projectTypeName"));
		 }}
		 if(cases.isNull("orgName")) {
			   caseExport.setOrgName(null);
			}else {
				
		    if(!cases.opt("orgName").equals(null)){
		        caseExport.setOrgName( cases.getString("orgName"));
		 }}
		 if(cases.isNull("isBillingEnabled")) {
			   caseExport.setIsBillingEnabled(null);
			}else {
				
		    if(!cases.opt("isBillingEnabled").equals(null)){
		        caseExport.setIsBillingEnabled( cases.getString("isBillingEnabled"));
		 }}
		 if(cases.isNull("projectName")) {
			   caseExport.setProjectName(null);
			}else {
				
		    if(!cases.opt("projectName").equals(null)){
		        caseExport.setProjectName( cases.getString("projectName"));
		 }}
		 if(cases.isNull("phaseName")) {
			   caseExport.setPhaseName(null);
			}else {
				
		    if(!cases.opt("phaseName").equals(null)){
		        caseExport.setPhaseName( cases.getString("phaseName"));
		 }}
		 
		if(!cases.isNull("customObject")) {
		JSONObject objCustom = cases.getJSONObject("customObject");

				if(objCustom.isNull("dateofaccident191321")) {
				   caseExport.setDateOfAccident( null);
				}else {
					
			    if(!objCustom.opt("dateofaccident191321").equals(null)){
			        caseExport.setDateOfAccident( objCustom.getString("dateofaccident191321"));
			    }}
				if(objCustom.isNull("firstdateoftreatment191321")) {
					   caseExport.setFirstdateoftreatment( null);
					}else {
						
				    if(!objCustom.opt("firstdateoftreatment191321").equals(null)){
				        caseExport.setFirstdateoftreatment(objCustom.getString("firstdateoftreatment191321"));
				}}
				if(objCustom.isNull("lastdateoftreatment191321")) {
					   caseExport.setLastdateoftreatment( null);
					}else {
						
				    if(!objCustom.opt("lastdateoftreatment191321").equals(null)){
				        caseExport.setLastdateoftreatment( objCustom.getString("lastdateoftreatment191321"));
				}}
				if(objCustom.isNull("statuteoflimitations191321")) {
					   caseExport.setStatuteOfLimitationsDue( null);
					   caseExport.setStatuteOfLimitationsDate( null);
					}else {

				      if(!objCustom.opt("statuteoflimitations191321").equals(null)){
				    	  JSONObject Obj = objCustom.getJSONObject("statuteoflimitations191321");
				    	    if(Obj.isNull("doneDate")) {
							   caseExport.setStatuteOfLimitationsDue( null);
							}else {

						      if(!Obj.opt("doneDate").equals(null)){
						      caseExport.setStatuteOfLimitationsDue( Obj.getString("doneDate"));
						    }}
				    	    if(Obj.isNull("dateValue")) {
								   caseExport.setStatuteOfLimitationsDate( null);
								}else {

							   if(!Obj.opt("dateValue").equals(null)){
							   caseExport.setStatuteOfLimitationsDate( Obj.getString("dateValue"));
							}}
				    	    
				    }}
				
				if(objCustom.isNull("notes191321")) {
					caseExport.setNotes( null);
				}else {
			    if(!objCustom.opt("notes191321").equals(null)){
			    	caseExport.setNotes(objCustom.getString("notes191321"));
			    }}
				if(objCustom.isNull("demandsent191321")) {
					caseExport.setDemandsent( null);
				}else {
			    if(!objCustom.opt("demandsent191321").equals(null)){
			    	caseExport.setDemandsent(objCustom.getString("demandsent191321"));
			    }}
				if(objCustom.isNull("finalstlmt191321")) {
					caseExport.setFinalstlmt( null);
				}else {
			    if(!objCustom.opt("finalstlmt191321").equals(null)){
			    	caseExport.setFinalstlmt(objCustom.getString("finalstlmt191321"));
			    }}
				if(objCustom.isNull("typeofcase191321")) {
					caseExport.setTypeOfCase( null);
				}else {
			    if(!objCustom.opt("typeofcase191321").equals(null)){
			    	caseExport.setTypeOfCase(objCustom.getString("typeofcase191321"));
			    }}
				if(objCustom.isNull("f2_synopsis191321")) {
					caseExport.setSynopsis( null);
				}else {
			    if(!objCustom.opt("f2_synopsis191321").equals(null)){
			    	caseExport.setSynopsis(objCustom.getString("f2_synopsis191321"));
			    }}
				
				if(objCustom.isNull("defendantcitationdescription191321")) {
					caseExport.setDefendantCitationDescription( null);
				}else {
			    if(!objCustom.opt("defendantcitationdescription191321").equals(null)){
			    	caseExport.setDefendantCitationDescription(objCustom.getString("defendantcitationdescription191321"));
			    }}
				if(objCustom.isNull("policedepartment191321")) {
					caseExport.setPoliceDepartment( null);
				}else {
			    if(!objCustom.opt("policedepartment191321").equals(null)){
			    	caseExport.setPoliceDepartment(objCustom.getString("policedepartment191321"));
			    }}
				if(objCustom.isNull("policereport191321")) {
					caseExport.setPoliceReport( null);
				}else {
			    if(!objCustom.opt("policereport1191321").equals(null)){
			    	caseExport.setPoliceReport(objCustom.getString("policereport145692"));
			    }}
			 
//				if(objCustom.isNull("case191321")) {
//					caseExport.setCaseNumber(null);
//				}else {
//					if(!objCustom.opt("case191321").equals(null)){
//				    	caseExport.setCaseNumber(objCustom.getString("case191321"));
//				    }}
//					
//			    if(objCustom.isNull("citationdescription191321")){
//					caseExport.setCitationDescription( null);
//				}else {
//			    if(!objCustom.opt("citationdescription191321").equals(null)){
//			    	caseExport.setCitationDescription(objCustom.getString("citationdescription191321"));
//			    }}
			    
			    if(objCustom.isNull("case191751")) {
					caseExport.setCaseNumber(null);
				}else {
			    if(!objCustom.opt("case191751").equals(null)){
			    	caseExport.setCaseNumber(objCustom.getString("case191751"));
			    }}
				if(objCustom.isNull("citationdescription191321")) {
					caseExport.setCitationDescription( null);
				}else {
			    if(!objCustom.opt("citationdescription191321").equals(null)){
			    	caseExport.setCitationDescription(objCustom.getString("citationdescription191321"));
			    }}
//				if(!objCustom.isNull("def1191321")) {
//				if(objCustom.isNull("def1191321")) {
//					caseExport.setDefendantId( null);
//				}else {
//			    if(!objCustom.opt("def1191321").equals(null)){
//			    	JSONObject defendant=objCustom.getJSONObject("def1191321");
//			    	caseExport.setDefendantId(defendant.getString("id"));
//			    }}}
			    
				if(!objCustom.isNull("def1191321")) {
				if(objCustom.isNull("def1191321")) {
					caseExport.setDefendantId( null);
				}else {
			    if(!objCustom.opt("def1191321").equals(null)){
			    	JSONObject defendant=objCustom.getJSONObject("def1191321");
			    	caseExport.setDefendantId(defendant.getString("id"));
			    }}}
				if(!objCustom.isNull("plaintiff1191321")) {
					if(objCustom.isNull("plaintiff1191321")) {
						caseExport.setPlantiffId( null);
					}else {
				    if(!objCustom.opt("plaintiff1191321").equals(null)){
				    	JSONObject plantiff=objCustom.getJSONObject("plaintiff1191321");
				    	caseExport.setPlantiffId(plantiff.getString("id"));
				 }}}
//				if(!objCustom.isNull("cocounsel192614")) {
//					if(objCustom.isNull("cocounsel192614")) {
//						caseExport.setCo_counselId( null);
//					}else {
//				    if(!objCustom.opt("cocounsel192614").equals(null)){
//				    	JSONObject co_counsel=objCustom.getJSONObject("cocounsel192614");
//				    	if(!co_counsel.opt("id").equals(null)){
//				    		caseExport.setCo_counselId(co_counsel.getString("id"));
//					    }
//			   }}}
				
				
				if(objCustom.isNull("cocounsel191321")){
					caseExport.setCo_counselId(null);
				}else {
					JSONArray communication01=objCustom.getJSONArray("cocounsel191321");
					for(int k=0; k<=communication01.length()-1; k++) {
					JSONObject jsonobject=communication01.getJSONObject(k);
				if(!jsonobject.opt("id").equals(null)){
					caseExport.setCo_counselId(jsonobject.getString("id"));
				}}}
				
				if(!objCustom.isNull("cocounselfirm191321")) {
					if(objCustom.isNull("cocounselfirm191321")) {
						caseExport.setCocounselfirm_id( null);
					}else {
				    if(!objCustom.opt("cocounselfirm191321").equals(null)){
				    	JSONObject cocounselfirm=objCustom.getJSONObject("cocounselfirm191321");
				    	if(!cocounselfirm.opt("id").equals(null)){
				    		caseExport.setCocounselfirm_id(cocounselfirm.getString("id"));
					    }
			   }}}
				if(!objCustom.isNull("judge191751")) {
					if(objCustom.isNull("judge191751")) {
						caseExport.setJudgeId(null);
					}else {
				    if(!objCustom.opt("judge191751").equals(null)){
				    	JSONObject judge=objCustom.getJSONObject("judge191751");
				    	if(!judge.opt("id").equals(null)){
				    		caseExport.setJudgeId(judge.getString("id"));
					    }
			   }}}
				if(!objCustom.isNull("courthouse191751")) {
					if(objCustom.isNull("courthouse191751")) {
						caseExport.setCourthouse_id( null);
					}else {
				    if(!objCustom.opt("courthouse191751").equals(null)){
				    	JSONObject courtHouse=objCustom.getJSONObject("courthouse191751");
				    	if(!courtHouse.opt("id").equals(null)){
				    		caseExport.setCourthouse_id(courtHouse.getString("id"));
					    }
			   }}}
				if(!objCustom.isNull("paralegal191751")) {
					if(objCustom.isNull("paralegal191751")) {
						caseExport.setParalegalId(null);
					}else {
				    if(!objCustom.opt("paralegal191751").equals(null)){
				    	JSONObject paralegal=objCustom.getJSONObject("paralegal191751");
				    	if(!paralegal.opt("id").equals(null)){
				    		caseExport.setParalegalId(paralegal.getString("id"));
					    }
			   }}}
				if(!objCustom.isNull("primaryattorney191751")) {
					if(objCustom.isNull("primaryattorney191751")) {
						caseExport.setPrimaryAttorneyId(null);
					}else {
				    if(!objCustom.opt("primaryattorney191751").equals(null)){
				    	JSONObject primaryAttorney=objCustom.getJSONObject("primaryattorney191751");
				    	if(!primaryAttorney.opt("id").equals(null)){
				    		caseExport.setPrimaryAttorneyId(primaryAttorney.getString("id"));
					    }
			   }}}
				caseSummaryExportDAO.insertCaseSummaryData(databaseName, caseExport);

		}
		caseSummaryExportDAO.insertCasedetailsData(databaseName,caseExport);
//		}
	}
}


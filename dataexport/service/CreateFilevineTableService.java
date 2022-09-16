package com.filevine.dataexport.service;

//import static com.cloudlex.util.Constants.CONST_ENV;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBProvider;

/**
 * This is Service class having method to add sql queries for all filevine tables
 **/
public class CreateFilevineTableService {

	/**
	 *This maethod is used to create table with all queries by passing databasename
	 */
	public void CreateFileVineTables(String databaseName) throws Exception {
		Connection conn=DBProvider.getJDBC();
		Statement stmt=null;
	
		try {
			
			stmt=conn.createStatement();

			//filevine project info
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_project_info (\r\n" + 
					"  project_name varchar(225) DEFAULT NULL,\r\n" + 
					"  project_id varchar(225) NOT NULL,\r\n" + 
					"  batch int(11) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (project_id));");
			
			System.out.println("'filevine_project_info' TABLE IS CREATED");
			
			//filevine event
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_event (\r\n" + 
					" owner_id int(11) DEFAULT NULL,\r\n" + 
					" owner_name varchar(225) DEFAULT NULL,\r\n" + 
					" event_id varchar(225) NOT NULL,\r\n" + 
					" title varchar(225) DEFAULT NULL,\r\n" + 
					" allday varchar(225) DEFAULT NULL,\r\n" + 
					" event_start varchar(225) DEFAULT NULL,\r\n" + 
					" event_end varchar(225) DEFAULT NULL,\r\n" + 
					" location varchar(225) DEFAULT NULL,\r\n" + 
					" notes text,\r\n" + 
					" calendar_event_type varchar(225) DEFAULT NULL,\r\n" + 
					" project_id varchar(225) DEFAULT NULL,\r\n" + 
					" project varchar(225) DEFAULT NULL,\r\n" + 
					" creator_id varchar(225) DEFAULT NULL,\r\n" + 
					" creator varchar(225) DEFAULT NULL,\r\n" + 
					" PRIMARY KEY (event_id)\r\n);");
			
			System.out.println("'filevine_event' TABLE IS CREATED");
			
			//filevine contact
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_contact(\r\n" + 
					"  contact_id varchar(225) DEFAULT NULL,\r\n" + 
					"  role varchar(225) DEFAULT NULL,\r\n" + 
					"  person_id varchar(225) DEFAULT NULL,\r\n" + 
					"  org_id varchar(225) DEFAULT NULL,\r\n" + 
					"  firstname varchar(225) DEFAULT NULL,\r\n" + 
					"  lastName varchar(225) DEFAULT NULL,\r\n" + 
					"  is_single_name varchar(255) DEFAULT NULL,\r\n" + 
					"  fullname varchar(225) DEFAULT NULL,\r\n" + 
					"  ssn varchar(225) DEFAULT NULL,\r\n" + 
					"  birthdate varchar(225) DEFAULT NULL,\r\n" + 
					"  notes text,\r\n" + 
					"  from_company varchar(225) DEFAULT NULL,\r\n" + 
					"  specialty varchar(225) DEFAULT NULL,\r\n" + 
					"  gender varchar(225) DEFAULT NULL,\r\n" + 
					"  c_language varchar(225) DEFAULT NULL,\r\n" + 
					"  marital_status varchar(225) DEFAULT NULL,\r\n" + 
					"  middle_name varchar(225) DEFAULT NULL,\r\n" + 
					"  is_texting_permitted varchar(225) DEFAULT NULL,\r\n" + 
					"  remarket varchar(225) DEFAULT NULL,\r\n" + 
					"  abbreviated_name varchar(225) DEFAULT NULL,\r\n" + 
					"  driver_license_number varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_client varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_adjuster varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_defendant varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_plaintiff varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_attorney varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_firm varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_expert varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_involved_party varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_judge varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_court varchar(225) DEFAULT NULL,\r\n" + 
					"  is_type_insurance_company varchar(225) DEFAULT NULL,\r\n" + 
					"  salutation varchar(225) DEFAULT NULL,\r\n" + 
					"  bar_number varchar(225) DEFAULT NULL,\r\n" + 
					"  fiduciary varchar(225) DEFAULT NULL,\r\n" + 
					"  is_minor varchar(225) DEFAULT NULL,\r\n" + 
					"  unique_id varchar(225) DEFAULT NULL,\r\n" + 
					"  search_names varchar(225) DEFAULT NULL,\r\n" + 
					"  project_id varchar(255) DEFAULT NULL,\r\n" + 
					"  person_type varchar(255) DEFAULT NULL,\r\n" + 
					"  is_type_medical_provider varchar(255) DEFAULT NULL);\r\n");
			
			System.out.println("'filevine_contact' TABLE IS CREATED");
			
			//filevine expenses
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_expenses (\r\n" + 
					"  project_id int(11) DEFAULT NULL,\r\n" + 
					"  title varchar(225) DEFAULT NULL,\r\n" + 
					"  amount varchar(225) DEFAULT NULL,\r\n" + 
					"  payment_method varchar(225) DEFAULT NULL,\r\n" + 
					"  notes text,\r\n" + 
					"  created_date varchar(225) DEFAULT NULL,\r\n" + 
					"  date_of_expense varchar(255) DEFAULT NULL\r\n);");
		    
			System.out.println("'filevine_expenses' TABLE IS CREATED");
			
			//filevine liens
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_liens(\r\n" + 
					"  lien_holder varchar(225) DEFAULT NULL,\r\n" + 
					"  amount varchar(225) DEFAULT NULL,\r\n" + 
					"  recovery_agency varchar(225) DEFAULT NULL,\r\n" + 
					"  recovery_agent varchar(225) DEFAULT NULL,\r\n" + 
					"  date_sent varchar(225) DEFAULT NULL,\r\n" + 
					"  date_received varchar(225) DEFAULT NULL,\r\n" + 
					"  date_of_receipt varchar(225) DEFAULT NULL,\r\n" + 
					"  notes varchar(225) DEFAULT NULL,\r\n" + 
					"  project_id int(11) DEFAULT NULL,\r\n" + 
					"  noticereceived varchar(255) DEFAULT NULL,\r\n" + 
					"  finallienrecieved varchar(255) DEFAULT NULL,\r\n" + 
					"  lor_sent varchar(255) DEFAULT NULL\r\n);");
			
			System.out.println("'filevine_liens' TABLE IS CREATED");
			
			//filevine liens yield
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_lineYield_export(\r\n" + 
					"  project_id varchar(255) DEFAULT NULL,\r\n" + 
					"  line_id varchar(255) DEFAULT NULL,\r\n" + 
					"  id varchar(255) NOT NULL,\r\n" + 
					"  line_name varchar(500) DEFAULT NULL,\r\n" + 
					"  amount varchar(255) DEFAULT NULL,\r\n" + 
					"  net_amount varchar(255) DEFAULT NULL,\r\n" + 
					"  item_type varchar(255) DEFAULT NULL,\r\n" + 
					"  adjustment_amount varchar(255) DEFAULT NULL,\r\n" + 
					"  reductionPercentage varchar(255) DEFAULT NULL,\r\n" + 
					"  isReductionPercentageLocked varchar(255) DEFAULT NULL,\r\n" + 
					"  isExcluded varchar(255) DEFAULT NULL,\r\n" + 
					"  lineNotes varchar(255) DEFAULT NULL) ;\r\n" + 
					"");
			
			System.out.println("'filevine_lineYield_export' TABLE IS CREATED");
			
			//filevine case details
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_case_details (\r\n" + 
					"  project_id varchar(255) DEFAULT NULL,\r\n" + 
					"  field_name varchar(255) DEFAULT NULL,\r\n" + 
					"  friendly_name varchar(255) DEFAULT NULL,\r\n" + 
					"  field_type varchar(255) DEFAULT NULL,\r\n" + 
					"  field_value varchar(255) DEFAULT NULL,\r\n" + 
					"  position varchar(255) DEFAULT NULL,\r\n" + 
					"  link_ref_value varchar(255) DEFAULT NULL\r\n);");
			
			System.out.println("'filevine_case_details' TABLE IS CREATED");
			
			//filevine case summary
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_case_summary (\r\n" + 
					"  project_id int(11) DEFAULT NULL,\r\n" + 
					"  date_of_accident varchar(225) DEFAULT NULL,\r\n" + 
					"  statute_of_limitations_dateValue varchar(225) DEFAULT NULL,\r\n" + 
					"  statute_of_limitations_doneDate varchar(225) DEFAULT NULL,\r\n" + 
					"  notes text,\r\n" + 
					"  type_of_case varchar(225) DEFAULT NULL,\r\n" + 
					"  synopsis text,\r\n" + 
					"  defendant_citation_description varchar(225) DEFAULT NULL,\r\n" + 
					"  police_department varchar(225) DEFAULT NULL,\r\n" + 
					"  police_report varchar(225) DEFAULT NULL,\r\n" + 
					"  citation_description varchar(225) DEFAULT NULL,\r\n" + 
					"  firstdateoftreatment varchar(255) DEFAULT NULL,\r\n" + 
					"  lastdateoftreatment varchar(255) DEFAULT NULL,\r\n" + 
					"  demandsent varchar(255) DEFAULT NULL,\r\n" + 
					"  finalstlmt varchar(255) DEFAULT NULL,\r\n" + 
					"  defendant_id varchar(255) DEFAULT NULL,\r\n" + 
					"  plantiff_id varchar(255) DEFAULT NULL,\r\n" + 
					"  co_counsel_id varchar(255) DEFAULT NULL,\r\n" + 
					"  cocounselfirm_id varchar(255) DEFAULT NULL,\r\n" + 
					"  courtHouse_id varchar(255) DEFAULT NULL,\r\n" + 
					"  judge_id varchar(255) DEFAULT NULL,\r\n" + 
					"  paralegal_id varchar(255) DEFAULT NULL,\r\n" + 
					"  primary_attorney_id varchar(255) DEFAULT NULL\r\n" + 
					")");
		
			System.out.println("'filevine_case_summary' TABLE IS CREATED");
			
			//filevine case summary details
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_case_summaryDetails (\r\n" + 
					"  project_id varchar(255) NOT NULL,\r\n" + 
					"  description text,\r\n" + 
					"  estimated_settlementvalu varchar(255) DEFAULT NULL,\r\n" + 
					"  incident_date varchar(255) DEFAULT NULL,\r\n" + 
					"  phase_date varchar(255) DEFAULT NULL,\r\n" + 
					"  ssn_number varchar(255) DEFAULT NULL,\r\n" + 
					"  email_address varchar(1000) DEFAULT NULL,\r\n" + 
					"  project_typeName varchar(255) DEFAULT NULL,\r\n" + 
					"  org_name varchar(255) DEFAULT NULL,\r\n" + 
					"  isBillingEnabled varchar(255) DEFAULT NULL,\r\n" + 
					"  project_name varchar(500) DEFAULT NULL,\r\n" + 
					"  phase_namr varchar(1000) DEFAULT NULL,\r\n" + 
					"  firstdateoftreatment varchar(255) DEFAULT NULL,\r\n" + 
					"  lastdateoftreatment varchar(255) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (project_id));");
		
			System.out.println("'filevine_case_summaryDetails' TABLE IS CREATED");
			
			//filevine medicals
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_medicals (\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  id int(11) DEFAULT NULL,\r\n" + 
	    			"  amount text,\r\n" + 
	    			"  final_amount varchar(225) DEFAULT NULL,\r\n" + 
	    			"  records_collection_fee varchar(225) DEFAULT NULL,\r\n" + 
	    			"  reduction float DEFAULT NULL,\r\n" + 
	    			"  original float DEFAULT NULL,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  first_day_of_treatment varchar(225) DEFAULT NULL,\r\n" + 
	    			"  last_day_of_treatment varchar(225) DEFAULT NULL,\r\n" + 
	    			"  date_requested varchar(225) DEFAULT NULL,\r\n" + 
	    			"  date_received varchar(225) DEFAULT NULL,\r\n" + 
	    			"  ordered_by varchar(225) DEFAULT NULL,\r\n" + 
	    			"  method varchar(225) DEFAULT NULL,\r\n" + 
	    			"  snag_request varchar(225) DEFAULT NULL,\r\n" + 
	    			"  outstandingBalance varchar(255) DEFAULT NULL,\r\n" + 
	    			"  recordscollectionstatus48362 varchar(255) DEFAULT NULL,\r\n" + 
	    			"  billingcollectionstatus varchar(255) DEFAULT NULL,\r\n" + 
	    			"  recordrequestresponsedate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  asof varchar(255) DEFAULT NULL,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  policynumber varchar(255) DEFAULT NULL,\r\n" + 
	    			"  plaintiffstreatmentstatus varchar(255) DEFAULT NULL,\r\n" + 
	    			"  providersaccountnumber varchar(255) DEFAULT NULL,\r\n" + 
	    			"  billsordered varchar(255) DEFAULT NULL,\r\n" + 
	    			"  billsreceived varchar(255) DEFAULT NULL,\r\n" + 
	    			"  recordsordered varchar(255) DEFAULT NULL,\r\n" + 
	    			"  recordsreceived varchar(255) DEFAULT NULL) ;\r\n");
	    	
	    	System.out.println("'filevine_medicals' TABLE IS CREATED");
	    	
	    	//filevine contact phone
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_contact_phone (\r\n" + 
	    			"  contact_id varchar(225) DEFAULT NULL,\r\n" + 
	    			"  phone_id varchar(225) DEFAULT NULL,\r\n" + 
	    			"  phone_number varchar(225) DEFAULT NULL,\r\n" + 
	    			"  rawNumber varchar(225) DEFAULT NULL,\r\n" + 
	    			"  label varchar(225) DEFAULT NULL,\r\n" + 
	    			"  person_id varchar(255) DEFAULT NULL);\r\n");
			
			System.out.println("'filevine_contact_phone' TABLE IS CREATED");
			
			//filevine contact email
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_contact_email(\r\n" + 
					"  contact_id varchar(225) DEFAULT NULL,\r\n" + 
					"  email_id varchar(225) DEFAULT NULL,\r\n" + 
					"  address varchar(225) DEFAULT NULL,\r\n" + 
					"  label varchar(225) DEFAULT NULL,\r\n" + 
					"  person_id varchar(255) DEFAULT NULL);\r\n");
			
			System.out.println("'filevine_contact_email' TABLE IS CREATED");
			
			//filevine contact address
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_contact_address (\r\n" + 
					"  contact_id varchar(225) DEFAULT NULL,\r\n" + 
					"  address_id varchar(225) DEFAULT NULL,\r\n" + 
					"  address_line1 varchar(225) DEFAULT NULL,\r\n" + 
					"  address_line2 varchar(225) DEFAULT NULL,\r\n" + 
					"  city varchar(225) DEFAULT NULL,\r\n" + 
					"  state varchar(225) DEFAULT NULL,\r\n" + 
					"  zip varchar(225) DEFAULT NULL,\r\n" + 
					"  label varchar(225) DEFAULT NULL,\r\n" + 
					"  full_address varchar(225) DEFAULT NULL,\r\n" + 
					"  person_id varchar(255) DEFAULT NULL\r\n);\r\n");
	    	
	    	System.out.println("'filevine_contact_address' TABLE IS CREATED");
	    	
	    	//filevine contact linking
			stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_contactLinking_export (\r\n" + 
					"  id varchar(255) DEFAULT NULL,\r\n" + 
					"  contact_id varchar(255) DEFAULT NULL,\r\n" + 
					"  full_name varchar(255) DEFAULT NULL,\r\n" + 
					"  created_date varchar(255) DEFAULT NULL,\r\n" + 
					"  projectId varchar(255) DEFAULT NULL,\r\n" + 
					"  def_notes text,\r\n" + 
					"  referal_source text,\r\n" + 
					"  clientInfo_notes text\r\n);\r\n");
	    	
	    	System.out.println("'filevine_contactLinking_export' TABLE IS CREATED");
	    	
	    	//filevine insurance
	     	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_insurance_export(\r\n" + 
	     			"  project_id int(11) DEFAULT NULL,\r\n" + 
	     			"  policy_id varchar(255) NOT NULL,\r\n" + 
	     			"  policy_number varchar(255) DEFAULT NULL,\r\n" + 
	     			"  claim_number varchar(255) DEFAULT NULL,\r\n" + 
	     			"  policy_holder varchar(225) DEFAULT NULL,\r\n" + 
	     			"  inseurer_id int(11) DEFAULT NULL,\r\n" + 
	     			"  inseured_id int(11) DEFAULT NULL,\r\n" + 
	     			"  adjusterId int(11) DEFAULT NULL,\r\n" + 
	     			"  driver_vehicle_id int(11) DEFAULT NULL,\r\n" + 
	     			"  third_party_insurance_id int(11) DEFAULT NULL,\r\n" + 
	     			"  insurance_limit varchar(225) DEFAULT NULL,\r\n" + 
	     			"  ispipexhausted varchar(255) DEFAULT NULL,\r\n" + 
	     			"  pip varchar(255) DEFAULT NULL,\r\n" + 
	     			"  notes text,\r\n" + 
	     			"  pipcoverageamount varchar(255) DEFAULT NULL,\r\n" + 
	     			"  umuimcoverageamount varchar(255) DEFAULT NULL,\r\n" + 
	     			"  limit_ varchar(255) DEFAULT NULL,\r\n" + 
	     			"  total_limit varchar(255) DEFAULT NULL,\r\n" + 
	     			"  insurance_type varchar(255) DEFAULT NULL,\r\n" + 
	     			"  mType varchar(255) DEFAULT NULL,\r\n" + 
	     			"  insurance_provider_id varchar(255) DEFAULT NULL,\r\n" + 
	     			"  liability_decision varchar(255) DEFAULT NULL,\r\n" + 
	     			"  PRIMARY KEY (policy_id)\r\n);");
	    	
	    	System.out.println("'filevine_insurance_export' TABLE IS CREATED");
	    	
	    	//filevine notes
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_notes_export (\r\n" + 
	    			"  ID int(11) NOT NULL,\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  target_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(255) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  userName varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee_id int(11) DEFAULT NULL,\r\n" + 
	    			"  assignee_name varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee_type varchar(255) DEFAULT NULL,\r\n" + 
	    			"  last_activity varchar(255) DEFAULT NULL,\r\n" + 
	    			"  type_tag varchar(255) DEFAULT NULL,\r\n" + 
	    			"  batch varchar(255) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (ID));");
	    	
	    	System.out.println("'filevine_notes_export' TABLE IS CREATED");
	    	
	    	//filevine plnthsDisc
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_plnthsDisc_export (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  disclosure_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  created_date varchar(255) DEFAULT NULL\r\n)");
	    	
	    	System.out.println("'filevine_plnthsDisc_export' TABLE IS CREATED");
	    	
            //filevine comments notes
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_comment_notes_export (\r\n" + 
	    			"  comment_id int(11) NOT NULL,\r\n" + 
	    			"  note_id int(11) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(225) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  fullname varchar(225) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (comment_id)\r\n);\r\n");
	    	
	    	System.out.println("'filevine_comment_notes_export' TABLE IS CREATED");
		
	    	//filevine intake 
	    
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_intake_export(project_id int(11) NOT NULL,case_type varchar(225),facts text,location varchar(255), "
					+ "listof_any_injury text,medical_treatment text,case_rating varchar(100),intake_completed_by varchar(255),case_type_desc text, "
					+ "othe_parties_involved varchar(255),status varchar(255),police_report varchar(255),date_of_accident varchar(255),date_of_intake varchar(255), "
					+ "date_case_assigned varchar(255),contract_date_sent varchar(255),comments_referred varchar(255),defendant_insurance_id int(11), "
					+ "attonrny_ref_id int(11),PRIMARY KEY (project_id));");
	    	
	    	System.out.println("'filevine_intake_export' TABLE IS CREATED");
	    	
	    	//filevine negotiations
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_negotiations_export (\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  id varchar(225) DEFAULT NULL,\r\n" + 
	    			"  doc_id int(11) DEFAULT NULL,\r\n" + 
	    			"  doc_name text,\r\n" + 
	    			"  offer_letter varchar(225) DEFAULT NULL,\r\n" + 
	    			"  method_of_offer varchar(255) DEFAULT NULL,\r\n" + 
	    			"  to_from_demandId int(11) DEFAULT NULL,\r\n" + 
	    			"  amount double DEFAULT NULL,\r\n" + 
	    			"  prior_client_approval varchar(255) DEFAULT NULL,\r\n" + 
	    			"  date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  expiry_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  demandsent varchar(255) DEFAULT NULL,\r\n" + 
	    			"  offerhistory text,\r\n" + 
	    			"  datedemandsent varchar(255) DEFAULT NULL,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  negotiationtype varchar(255) DEFAULT NULL,\r\n" + 
	    			"  notes text\r\n);");
	    	
	    	System.out.println("'filevine_negotiations_export' TABLE IS CREATED");
	    	
	    	//filevine teams 
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_teams_export (\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  team_id int(11) DEFAULT NULL,\r\n" + 
	    			"  team_email varchar(255) DEFAULT NULL,\r\n" + 
	    			"  team_fullname varchar(255) DEFAULT NULL,\r\n" + 
	    			"  team_username varchar(225) DEFAULT NULL,\r\n" + 
	    			"  team_is_firPrimary varchar(100) DEFAULT NULL,\r\n" + 
	    			"  team_is_primary varchar(100) DEFAULT NULL,\r\n" + 
	    			"  team_isAdmin varchar(100) DEFAULT NULL,\r\n" + 
	    			"  team_type varchar(255) DEFAULT NULL,\r\n" + 
	    			"  tag_roleId int(11) DEFAULT NULL,\r\n" + 
	    			"  tag_roleName varchar(255) DEFAULT NULL);");
	    	
	    	System.out.println("'filevine_teams_export' TABLE IS CREATED");
	    	
	    	//filevine witness 
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_witness_export (\r\n" + 
	    			"  projectId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  witness_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  full_name varchar(255) DEFAULT NULL,\r\n" + 
	    			"  created_date varchar(255) DEFAULT NULL\r\n);");
	    	
	    	System.out.println("'filevine_teams_export' TABLE IS CREATED");
	    	
	    	//filevine activity sms 
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_activity_sms_export (\r\n" + 
	    			"  ID int(11) NOT NULL,\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  target_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(255) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  userName varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee_id int(11) DEFAULT NULL,\r\n" + 
	    			"  assignee_name varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee_type varchar(255) DEFAULT NULL,\r\n" + 
	    			"  last_activity varchar(255) DEFAULT NULL,\r\n" + 
	    			"  type_tag varchar(255) DEFAULT NULL,\r\n" + 
	    			"  batch int(11) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (ID));\r\n");
	    	
	    	System.out.println("'filevine_activity_sms_export' TABLE IS CREATED");
	    	
	    	//filevine activity task 
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_activity_task_export(\r\n" + 
	    			"  ID int(11) NOT NULL,\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  target_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(255) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  userName varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee_id int(11) DEFAULT NULL,\r\n" + 
	    			"  assignee_name varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee_type varchar(255) DEFAULT NULL,\r\n" + 
	    			"  last_activity varchar(255) DEFAULT NULL,\r\n" + 
	    			"  type_tag varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assignee varchar(500) DEFAULT NULL,\r\n" + 
	    			"  batch int(11) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (ID)\r\n" + 
	    			");");
	    	
	    	System.out.println("'filevine_activity_task_export' TABLE IS CREATED");
	    	
	    	//filevine activity task data
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_activity_taskdata_export (\r\n" + 
	    			"  task_id int(11) NOT NULL,\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  type_tag varchar(255) DEFAULT NULL,\r\n" + 
	    			"  target_date varchar(225) DEFAULT NULL,\r\n" + 
	    			"  is_unread varchar(255) DEFAULT NULL,\r\n" + 
	    			"  is_completed varchar(225) DEFAULT NULL,\r\n" + 
	    			"  completed_date varchar(225) DEFAULT NULL,\r\n" + 
	    			"  destination varchar(225) DEFAULT NULL,\r\n" + 
	    			"  source varchar(225) DEFAULT NULL,\r\n" + 
	    			"  is_edited varchar(225) DEFAULT NULL,\r\n" + 
	    			"  allow_editing varchar(225) DEFAULT NULL,\r\n" + 
	    			"  last_activity varchar(225) DEFAULT NULL,\r\n" + 
	    			"  assign_to varchar(225) DEFAULT NULL,\r\n" + 
	    			"  assignee_id int(11) DEFAULT NULL,\r\n" + 
	    			"  completer_id int(11) DEFAULT NULL,\r\n" + 
	    			"  complter_name varchar(255) DEFAULT NULL,\r\n" + 
	    			"  completer_createdAt varchar(255) DEFAULT NULL,\r\n" + 
	    			"  author_id int(11) DEFAULT NULL,\r\n" + 
	    			"  author_fullName varchar(255) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(255) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (task_id)\r\n);\r\n");
	    	
	    	System.out.println("'filevine_activity_taskdata_export' TABLE IS CREATED");
	    	
	    	//filevine client intake
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_clientIntake_export (\r\n" + 
	    			"  projectId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  clienthasanumber varchar(255) DEFAULT NULL,\r\n" + 
	    			"  clienthasstateidnumber varchar(255) DEFAULT NULL,\r\n" + 
	    			"  anumber varchar(255) DEFAULT NULL,\r\n" + 
	    			"  stateidnumber varchar(255) DEFAULT NULL,\r\n" + 
	    			"  language_ varchar(255) DEFAULT NULL,\r\n" + 
	    			"  currenttitle varchar(255) DEFAULT NULL,\r\n" + 
	    			"  currentemployer varchar(255) DEFAULT NULL,\r\n" + 
	    			"  referralsource varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateofintake varchar(255) DEFAULT NULL,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL);\r\n");
	    	
	    	System.out.println("'filevine_clientIntake_export' TABLE IS CREATED");
	    	
	    	//filevine client activity notes comment
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_comment_activitynotes_export (\r\n" + 
	    			"  comment_id int(11) NOT NULL,\r\n" + 
	    			"  task_id int(11) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(225) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  fullname varchar(225) DEFAULT NULL,\r\n" + 
	    			"  task_id_input int(11) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (comment_id));");
	    	
	    	System.out.println("'filevine_comment_activitynotes_export' TABLE IS CREATED");
	    	
	    	//filevine client activity sms comment
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_comment_activitysms_export (\r\n" + 
	    			"  comment_id int(11) NOT NULL,\r\n" + 
	    			"  task_id int(11) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(225) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  fullname varchar(225) DEFAULT NULL,\r\n" + 
	    			"  task_id_input int(11) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (comment_id)\r\n);\r\n");
	    	
	    	System.out.println("'filevine_comment_activitysms_export' TABLE IS CREATED");
	    	
	    	//filevine client activity task comment
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_comment_activitytasks_export (\r\n" + 
	    			"  comment_id int(11) NOT NULL,\r\n" + 
	    			"  task_id int(11) DEFAULT NULL,\r\n" + 
	    			"  body text,\r\n" + 
	    			"  created_at varchar(225) DEFAULT NULL,\r\n" + 
	    			"  userId int(11) DEFAULT NULL,\r\n" + 
	    			"  fullname varchar(225) DEFAULT NULL,\r\n" + 
	    			"  task_id_input int(11) DEFAULT NULL,\r\n" + 
	    			"  PRIMARY KEY (comment_id)\r\n);\r\n");
	    	
	    	System.out.println("'filevine_comment_activitytasks_export' TABLE IS CREATED");
	    	
	    	//filevine conflict checker
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_conflict_checker (\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  name text,\r\n" + 
	    			"  checked_by text,\r\n" + 
	    			"  batch int(11) DEFAULT NULL)");
	    	
	    	System.out.println("'filevine_conflict_checker' TABLE IS CREATED");
	    	
	    	//filevine conflict checker export
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+"filevine_conflict_checker_export (\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  ID int(11) DEFAULT NULL,\r\n" + 
	    			"  checker_name varchar(255) DEFAULT NULL,\r\n" + 
	    			"  checked_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  name_checked varchar(255) DEFAULT NULL,\r\n" + 
	    			"  is_success varchar(255) DEFAULT NULL,\r\n" + 
	    			"  batch varchar(255) DEFAULT NULL);\r\n");
	    	
	    	System.out.println("'filevine_conflict_checker_export' TABLE IS CREATED");
	    	
	    	//filevine defence counsel
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_defenceCounsel_export (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  firmNameId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  leadcounselId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  paralegalId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  assistantattorneyId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  legalassistantId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL\r\n);");
	    	
	    	System.out.println("'filevine_defenceCounsel_export' TABLE IS CREATED");
	    	
	    	//filevine Litigation
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_litigation_export (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  mainDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  name_ text,\r\n" + 
	    			"  chainTypeName varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chainTypeID varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chainTypeUrl varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chainTypeNotes varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chainTypeJurisdictionName text);");
	    	
	    	System.out.println("'filevine_litigation_export' TABLE IS CREATED");
	    	
	    	//filevine Litigation Visible dates
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_litigation_visibleDates (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  visibleDateId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dueDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  doneDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chainDateTypeID varchar(255) DEFAULT NULL,\r\n" + 
	    			"  name_ text,\r\n" + 
	    			"  behavior varchar(255) DEFAULT NULL,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  chainDateTypeUrl varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chainDateTypeNotes varchar(255) DEFAULT NULL);");
	    	
	    	System.out.println("'filevine_litigation_visibleDates' TABLE IS CREATED");
	    	
	    	//filevine depos
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_depos_export (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  deponent text,\r\n" + 
	    			"  generalNote text,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL\r\n)");
	    	
	    	System.out.println("'filevine_depos_export' TABLE IS CREATED");
	    	
	    	//filevine related case
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_related_case (\r\n" + 
	    			"  project_id int(11) DEFAULT NULL,\r\n" + 
	    			"  name text,\r\n" + 
	    			"  description text,\r\n" + 
	    			"  batch int(11) DEFAULT NULL\r\n);");
	    	
	    	System.out.println("'filevine_related_case' TABLE IS CREATED");
	    	
	    	//filevine reminder
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_reminder (\r\n" + 
	    			"  reminder_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  name_ text,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  dueDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  doneDate varchar(255) DEFAULT NULL\r\n);");
	    	
	    	System.out.println("'filevine_reminder' TABLE IS CREATED");
	    	
	    	//filevine WrittenDisc
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_WrittenDisc_export (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  done varchar(255) DEFAULT NULL,\r\n" + 
	    			"  inout_ text,\r\n" + 
	    			"  type_ text,\r\n" + 
	    			"  title text,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  drafter_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  responseDateValue varchar(255) DEFAULT NULL,\r\n" + 
	    			"  responseDoneDate varchar(255) DEFAULT NULL\r\n);");
	    	
	    	System.out.println("'filevine_WrittenDisc_export' TABLE IS CREATED");
	    	
	    	//filevine Yield
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_yield_export (\r\n" + 
	    			"  project_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  id varchar(255) NOT NULL,\r\n" + 
	    			"  name_ varchar(500) DEFAULT NULL,\r\n" + 
	    			"  offer varchar(255) DEFAULT NULL,\r\n" + 
	    			"  attorny_percentage varchar(255) DEFAULT NULL,\r\n" + 
	    			"  attorny_amount varchar(255) DEFAULT NULL,\r\n" + 
	    			"  medical_bill_amount varchar(255) DEFAULT NULL,\r\n" + 
	    			"  expense_amount varchar(255) DEFAULT NULL,\r\n" + 
	    			"  nettoClient varchar(255) DEFAULT NULL,\r\n" + 
	    			"  create_date varchar(255) DEFAULT NULL,\r\n" + 
	    			"  creator_id varchar(255) DEFAULT NULL,\r\n" + 
	    			"  creator_name varchar(500) DEFAULT NULL,\r\n" + 
	    			"  notes text,\r\n" + 
	    			"  hasCustomMeds varchar(255) DEFAULT NULL,\r\n" + 
	    			"  hasCustomExpense varchar(255) DEFAULT NULL);");
	    	
	    	System.out.println("'filevine_yield_export' TABLE IS CREATED");
	    	
	    	//filevine Intake AccidentInfo
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_intakeAccidentIfo_export (\r\n" + 
	    			"  projectId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  werecitationsissued varchar(255) DEFAULT NULL,\r\n" + 
	    			"  policereport varchar(255) DEFAULT NULL,\r\n" + 
	    			"  picturesofdamages varchar(255) DEFAULT NULL,\r\n" + 
	    			"  vehicletowed varchar(255) DEFAULT NULL,\r\n" + 
	    			"  estimatedone varchar(255) DEFAULT NULL,\r\n" + 
	    			"  picturestakenofinjuries varchar(255) DEFAULT NULL,\r\n" + 
	    			"  subsequentaccidents varchar(255) DEFAULT NULL,\r\n" + 
	    			"  reviewsocialmedialetterpolicy varchar(255) DEFAULT NULL,\r\n" + 
	    			"  concurrentemployment varchar(255) DEFAULT NULL,\r\n" + 
	    			"  witnesses varchar(255) DEFAULT NULL,\r\n" + 
	    			"  wereyoutransportedinanambulance varchar(255) DEFAULT NULL,\r\n" + 
	    			"  didyougotothehospital varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chiropractictreatment varchar(255) DEFAULT NULL,\r\n" + 
	    			"  accidenttype varchar(255) DEFAULT NULL,\r\n" + 
	    			"  timeofaccident varchar(255) DEFAULT NULL,\r\n" + 
	    			"  descriptionofaccident text,\r\n" + 
	    			"  clientsvehiclemakemodel text,\r\n" + 
	    			"  damagetoclientsvehicle text,\r\n" + 
	    			"  defendantsvehiclemakemodel text,\r\n" + 
	    			"  damagetodefendantsvehicle text,\r\n" + 
	    			"  bywhomandwhere text,\r\n" + 
	    			"  locationofclientsvehicle text,\r\n" + 
	    			"  rentaloptionsownliabnone text,\r\n" + 
	    			"  injuriessustainedpaincomplaints text,\r\n" + 
	    			"  priorinjuries varchar(255) DEFAULT NULL,\r\n" + 
	    			"  priorclaimswattorneyandreceived text,\r\n" + 
	    			"  priorlawsuitswattorneyandreceived text,\r\n" + 
	    			"  employmentstatus varchar(255) DEFAULT NULL,\r\n" + 
	    			"  jobtitle text,\r\n" + 
	    			"  thingsclientcannolongerdoatall text,\r\n" + 
	    			"  canbutwithpainnotaswell varchar(255) DEFAULT NULL,\r\n" + 
	    			"  lossoflifesenjoyment text,\r\n" + 
	    			"  healthhistoryoverallhealthsurgerie text,\r\n" + 
	    			"  additionalthoughtsconcernsraisedab text,\r\n" + 
	    			"  additionalinfo text,\r\n" + 
	    			"  locationofaccident text,\r\n" + 
	    			"  referralsource text,\r\n" + 
	    			"  resolution text,\r\n" + 
	    			"  qualificationstatus text,\r\n" + 
	    			"  citationcodesection text,\r\n" + 
	    			"  employerId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  personperformingintakeId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  spousepartnerifapplicableId text,\r\n" + 
	    			"  maincontactcaretakerguardianorclie varchar(255) DEFAULT NULL,\r\n" + 
	    			"  driverId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  vehicleownerId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  chiropracticfacilityId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  passengerId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  children varchar(255) DEFAULT NULL,\r\n" + 
	    			"  datetaken varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateofintake varchar(255) DEFAULT NULL,\r\n" + 
	    			"  datecontractsigned varchar(255) DEFAULT NULL,\r\n" + 
	    			"  statuteoflimitations varchar(255) DEFAULT NULL,\r\n" + 
	    			"  incidentdate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  referredfromId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  towed_byId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  towed_to text,\r\n" + 
	    			"  policereportnarative text\r\n);\r\n");
	    	
	    	System.out.println("'filevine_intakeAccidentIfo_export' TABLE IS CREATED");
	    	
	    	//filevine Intake Data
	    	stmt.executeUpdate("CREATE TABLE "+databaseName+".filevine_intakeData_export (\r\n" + 
	    			"  projectId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  madeappointment varchar(255) DEFAULT NULL,\r\n" + 
	    			"  feecancellationexplained varchar(255) DEFAULT NULL,\r\n" + 
	    			"  minorchildren varchar(255) DEFAULT NULL,\r\n" + 
	    			"  opposingpartyapplicable varchar(255) DEFAULT NULL,\r\n" + 
	    			"  bestwaytocontactyou varchar(255) DEFAULT NULL,\r\n" + 
	    			"  typeoffamilylaw varchar(255) DEFAULT NULL,\r\n" + 
	    			"  referralsource varchar(255) DEFAULT NULL,\r\n" + 
	    			"  timeofappointment varchar(255) DEFAULT NULL,\r\n" + 
	    			"  referralnameId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  opposingpartyId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  opposingpartyattorneyId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  intaketakenbyId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  childId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  married varchar(255) DEFAULT NULL,\r\n" + 
	    			"  childsupportarrearages varchar(255) DEFAULT NULL,\r\n" + 
	    			"  reportedtoemployer varchar(255) DEFAULT NULL,\r\n" + 
	    			"  treatingwithdoctor varchar(255) DEFAULT NULL,\r\n" + 
	    			"  fringebenefits varchar(255) DEFAULT NULL,\r\n" + 
	    			"  areyoureceivingchecks text,\r\n" + 
	    			"  haveyoureturnedtowork text,\r\n" + 
	    			"  areyouworkingnow text,\r\n" + 
	    			"  haveyoubeenterminated text,\r\n" + 
	    			"  weretherewitnessestoaccident text,\r\n" + 
	    			"  didyouhaveanythingtodrinkonthedayo text,\r\n" + 
	    			"  wereanymedsordrugslegalorillegalta text,\r\n" + 
	    			"  takentoahospital text,\r\n" + 
	    			"  takenbyambulance text,\r\n" + 
	    			"  referredforanyothertreatmentordoct text,\r\n" + 
	    			"  areyoucurrentlyourofworkbyatreatin text,\r\n" + 
	    			"  areyoureceivingchecksfromworkersco text,\r\n" + 
	    			"  locationofaccidentcitystate text,\r\n" + 
	    			"  resolution text,\r\n" + 
	    			"  educationlevel text,\r\n" + 
	    			"  positionheld text,\r\n" + 
	    			"  towhomreported text,\r\n" + 
	    			"  whoareyoutreatingwith text,\r\n" + 
	    			"  per varchar(255) DEFAULT NULL,\r\n" + 
	    			"  hoursperweek varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateslostfromworkbecauseofinjury varchar(255) DEFAULT NULL,\r\n" + 
	    			"  timeofday varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dayofweek varchar(255) DEFAULT NULL,\r\n" + 
	    			"  witnesses varchar(255) DEFAULT NULL,\r\n" + 
	    			"  describehowtheaccidenthappened text,\r\n" + 
	    			"  injuries text,\r\n" + 
	    			"  priorcomplaintsofinjuredbodyparts text,\r\n" + 
	    			"  priororcurrentmedicalconditions text,\r\n" + 
	    			"  priorworkerscompensationclaims text,\r\n" + 
	    			"  priorlawyersforaccidents text,\r\n" + 
	    			"  criminalbackground1 text,\r\n" + 
	    			"  objectiveinfilingworkerscompensati text,\r\n" + 
	    			"  otheroutstandingmedicalissues text,\r\n" + 
	    			"  otheroutstandingindemnityissues text,\r\n" + 
	    			"  interviewer text,\r\n" + 
	    			"  employersnameId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  directsupervisorsnameId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  personperformingintakeId varchar(255) DEFAULT NULL,\r\n" + 
	    			"  rateofpay text,\r\n" + 
	    			"  amountraised text,\r\n" + 
	    			"  dateofintake varchar(255) DEFAULT NULL,\r\n" + 
	    			"  datecontactsigned varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateemploymentstarted varchar(255) DEFAULT NULL,\r\n" + 
	    			"  whenreported varchar(255) DEFAULT NULL,\r\n" + 
	    			"  lastpayraisedate varchar(255) DEFAULT NULL,\r\n" + 
	    			"  datereturned varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateoftermination varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateofinterview varchar(255) DEFAULT NULL,\r\n" + 
	    			"  dateofappt varchar(255) DEFAULT NULL,\r\n" + 
	    			"  createdDate varchar(255) DEFAULT NULL\r\n);");
	    	
	    	System.out.println("'filevine_intakeData_export' TABLE IS CREATED");
	    	
	    	
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			conn.close();
		}
		
	}

}

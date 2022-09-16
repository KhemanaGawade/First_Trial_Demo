package com.filevine.dataexport.domain;


/**
 * This class is having all required fields of contact details tab which need to export from filevine ui
 * Creating & Initializing all related fields
 * Creating getter & setter methods for each field
 * Overiding toString() method with each values
 */
public class ContactExport {
	
	private String projectId=null;
	private String ID =null;
	private String Role=null ;
	private int personID =0;
	private int OrgID =0;
	private String FirstName =null;
	private String LastName=null ;
	private boolean IsSingleName=false ;
	private String Fullname =null;
	private String Ssn =null;
	private String BirthDate =null ;
	private String Notes =null;
	private String FromCompany =null;
	private String Specialty=null ;
	private String Gender=null ;
	private String Language=null;
	private String MaritalStatus=null ;
	private String middleName =null;
	private String IsTextingPermitted =null;
	private boolean Remarket=false ;
	private String AbbreviatedName=null;
	private String DriverLicenseNumber= null ;
	private boolean IsTypeClient =false;
	private boolean IsTypeAdjuster=false ;
	private boolean IsTypeDefendant =false;
	private boolean IsTypePlaintiff=false ;
	private boolean IsTypeAttorney=false ;
	private boolean IsTypeFirm=false ;
	private boolean IsTypeExpert=false ;
	private boolean IsTypeMedicalProvider=false ;
	private boolean IsTypeInvolvedParty=false ;
	private boolean IsTypeJudge=false ;
	private boolean IsTypeCourt=false ;
	private boolean IsTypeInsuranceCompany=false ;
	private String Salutation=null ;
	private String Fiduciary=null ;
	private boolean IsMinor=false ;
	private String UniqueID =null;
	private String SearchNames =null;
	private String BarNumber=null ;
	private String personType=null;
	private String RoleTitle=null;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getOrgID() {
		return OrgID;
	}
	public void setOrgID(int orgID) {
		OrgID = orgID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public boolean isIsSingleName() {
		return IsSingleName;
	}
	public void setIsSingleName(boolean isSingleName) {
		IsSingleName = isSingleName;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getSsn() {
		return Ssn;
	}
	public void setSsn(String ssn) {
		Ssn = ssn;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getFromCompany() {
		return FromCompany;
	}
	public void setFromCompany(String fromCompany) {
		FromCompany = fromCompany;
	}
	public String getSpecialty() {
		return Specialty;
	}
	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getIsTextingPermitted() {
		return IsTextingPermitted;
	}
	public void setIsTextingPermitted(String isTextingPermitted) {
		IsTextingPermitted = isTextingPermitted;
	}
	public boolean isRemarket() {
		return Remarket;
	}
	public void setRemarket(boolean remarket) {
		Remarket = remarket;
	}
	public String getAbbreviatedName() {
		return AbbreviatedName;
	}
	public void setAbbreviatedName(String abbreviatedName) {
		AbbreviatedName = abbreviatedName;
	}
	public String getDriverLicenseNumber() {
		return DriverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		DriverLicenseNumber = driverLicenseNumber;
	}
	public boolean isIsTypeClient() {
		return IsTypeClient;
	}
	public void setIsTypeClient(boolean isTypeClient) {
		IsTypeClient = isTypeClient;
	}
	public boolean isIsTypeAdjuster() {
		return IsTypeAdjuster;
	}
	public void setIsTypeAdjuster(boolean isTypeAdjuster) {
		IsTypeAdjuster = isTypeAdjuster;
	}
	public boolean isIsTypeDefendant() {
		return IsTypeDefendant;
	}
	public void setIsTypeDefendant(boolean isTypeDefendant) {
		IsTypeDefendant = isTypeDefendant;
	}
	public boolean isIsTypePlaintiff() {
		return IsTypePlaintiff;
	}
	public void setIsTypePlaintiff(boolean isTypePlaintiff) {
		IsTypePlaintiff = isTypePlaintiff;
	}
	public boolean isIsTypeAttorney() {
		return IsTypeAttorney;
	}
	public void setIsTypeAttorney(boolean isTypeAttorney) {
		IsTypeAttorney = isTypeAttorney;
	}
	public boolean isIsTypeFirm() {
		return IsTypeFirm;
	}
	public void setIsTypeFirm(boolean isTypeFirm) {
		IsTypeFirm = isTypeFirm;
	}
	public boolean isIsTypeExpert() {
		return IsTypeExpert;
	}
	public void setIsTypeExpert(boolean isTypeExpert) {
		IsTypeExpert = isTypeExpert;
	}
	public boolean isIsTypeMedicalProvider() {
		return IsTypeMedicalProvider;
	}
	public void setIsTypeMedicalProvider(boolean isTypeMedicalProvider) {
		IsTypeMedicalProvider = isTypeMedicalProvider;
	}
	public boolean isIsTypeInvolvedParty() {
		return IsTypeInvolvedParty;
	}
	public void setIsTypeInvolvedParty(boolean isTypeInvolvedParty) {
		IsTypeInvolvedParty = isTypeInvolvedParty;
	}
	public boolean isIsTypeJudge() {
		return IsTypeJudge;
	}
	public void setIsTypeJudge(boolean isTypeJudge) {
		IsTypeJudge = isTypeJudge;
	}
	public boolean isIsTypeCourt() {
		return IsTypeCourt;
	}
	public void setIsTypeCourt(boolean isTypeCourt) {
		IsTypeCourt = isTypeCourt;
	}
	public boolean isIsTypeInsuranceCompany() {
		return IsTypeInsuranceCompany;
	}
	public void setIsTypeInsuranceCompany(boolean isTypeInsuranceCompany) {
		IsTypeInsuranceCompany = isTypeInsuranceCompany;
	}
	public String getSalutation() {
		return Salutation;
	}
	public void setSalutation(String salutation) {
		Salutation = salutation;
	}
	public String getFiduciary() {
		return Fiduciary;
	}
	public void setFiduciary(String fiduciary) {
		Fiduciary = fiduciary;
	}
	public boolean isIsMinor() {
		return IsMinor;
	}
	public void setIsMinor(boolean isMinor) {
		IsMinor = isMinor;
	}
	public String getUniqueID() {
		return UniqueID;
	}
	public void setUniqueID(String uniqueID) {
		UniqueID = uniqueID;
	}
	public String getSearchNames() {
		return SearchNames;
	}
	public void setSearchNames(String searchNames) {
		SearchNames = searchNames;
	}
	public String getBarNumber() {
		return BarNumber;
	}
	public void setBarNumber(String barNumber) {
		BarNumber = barNumber;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getRoleTitle() {
		return RoleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		RoleTitle = roleTitle;
	}
	@Override
	public String toString() {
		return "ContactExport [projectId=" + projectId + ", ID=" + ID + ", Role=" + Role + ", personID=" + personID
				+ ", OrgID=" + OrgID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", IsSingleName="
				+ IsSingleName + ", Fullname=" + Fullname + ", Ssn=" + Ssn + ", BirthDate=" + BirthDate + ", Notes="
				+ Notes + ", FromCompany=" + FromCompany + ", Specialty=" + Specialty + ", Gender=" + Gender
				+ ", Language=" + Language + ", MaritalStatus=" + MaritalStatus + ", middleName=" + middleName
				+ ", IsTextingPermitted=" + IsTextingPermitted + ", Remarket=" + Remarket + ", AbbreviatedName="
				+ AbbreviatedName + ", DriverLicenseNumber=" + DriverLicenseNumber + ", IsTypeClient=" + IsTypeClient
				+ ", IsTypeAdjuster=" + IsTypeAdjuster + ", IsTypeDefendant=" + IsTypeDefendant + ", IsTypePlaintiff="
				+ IsTypePlaintiff + ", IsTypeAttorney=" + IsTypeAttorney + ", IsTypeFirm=" + IsTypeFirm
				+ ", IsTypeExpert=" + IsTypeExpert + ", IsTypeMedicalProvider=" + IsTypeMedicalProvider
				+ ", IsTypeInvolvedParty=" + IsTypeInvolvedParty + ", IsTypeJudge=" + IsTypeJudge + ", IsTypeCourt="
				+ IsTypeCourt + ", IsTypeInsuranceCompany=" + IsTypeInsuranceCompany + ", Salutation=" + Salutation
				+ ", Fiduciary=" + Fiduciary + ", IsMinor=" + IsMinor + ", UniqueID=" + UniqueID + ", SearchNames="
				+ SearchNames + ", BarNumber=" + BarNumber + ", personType=" + personType + ", RoleTitle=" + RoleTitle
				+ "]";
	}
	
	
	
}

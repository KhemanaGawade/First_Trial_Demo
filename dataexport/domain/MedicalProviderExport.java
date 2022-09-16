package com.filevine.dataexport.domain;

public class MedicalProviderExport {

	private String projectId=null;
	private String personId=null;
	private String orgId=null;
	private String FirstName =null;
	private String LastName=null ;
	private String IsSingleName=null ;
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
	private String Remarket=null ;
	private String AbbreviatedName=null;
	private String DriverLicenseNumber= null ;
	private String IsTypeClient =null;
	private String IsTypeAdjuster=null ;
	private String IsTypeDefendant =null;
	private String IsTypePlaintiff=null ;
	private String IsTypeAttorney=null ;
	private String IsTypeFirm=null ;
	private String IsTypeExpert=null ;
	private String IsTypeMedicalProvider=null ;
	private String IsTypeInvolvedParty=null ;
	private String IsTypeJudge=null ;
	private String IsTypeCourt=null ;
	private String IsTypeInsuranceCompany=null ;
	private String Salutation=null ;
	private String Fiduciary=null ;
	private String IsMinor=null ;
	private String UniqueID =null;
	private String SearchNames =null;
	private String BarNumber=null ;
	private String personType=null;
	// phone
	private String ContactId = null;
	private String phoneId = null;
	private String Number = null;
	private String RawNumber = null;
	private String phoneLabel = null;
	
	//address
	private String addressId = null;
	private String Line1 = null;
	private String Line2 = null;
	private String City = null;
	private String Zip = null;
	private String addressLabel = null;
	private String FullAddress= null;
	private String State= null;
	
	//
	private String emailId = null;
	private String Address = null;
	private String emailLable=null;
	
	//for witness
	private String created_date=null;
	private String id=null;
	
	//for client info
	private String referalSource=null;
	private String clientInfoNote=null;
	
	private String defendanNotes=null;
	
	
	public String getReferalSource() {
		return this.referalSource;
	}
	public void setReferalSource(String referalSource) {
		this.referalSource = referalSource;
	}
	
	public String getClientInfoNote() {
		return this.clientInfoNote;
	}
	public void setClientInfoNote(String clientInfoNote) {
		this.clientInfoNote = clientInfoNote;
	}
	public String getDefendanNotes() {
		return this.defendanNotes;
	}
	public void setDefendanNotes(String defendanNotes) {
		this.defendanNotes = defendanNotes;
	}
	public String getCreated_date() {
		return this.created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonType() {
		return this.personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getEmailLable() {
		return this.emailLable;
	}
	public void setEmailLable(String emailLable) {
		this.emailLable = emailLable;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPersonId() {
		return this.personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getOrgId() {
		return this.orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getFirstName() {
		return this.FirstName;
	}
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return this.LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public String isIsSingleName() {
		return this.IsSingleName;
	}
	public void setIsSingleName(String isSingleName) {
		this.IsSingleName = isSingleName;
	}
	public String getFullname() {
		return this.Fullname;
	}
	public void setFullname(String fullname) {
		this.Fullname = fullname;
	}
	public String getSsn() {
		return this.Ssn;
	}
	public void setSsn(String ssn) {
		this.Ssn = ssn;
	}
	public String getBirthDate() {
		return this.BirthDate;
	}
	public void setBirthDate(String birthDate) {
		this.BirthDate = birthDate;
	}
	public String getNotes() {
		return this.Notes;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	public String getFromCompany() {
		return this.FromCompany;
	}
	public void setFromCompany(String fromCompany) {
		this.FromCompany = fromCompany;
	}
	public String getSpecialty() {
		return this.Specialty;
	}
	public void setSpecialty(String specialty) {
		this.Specialty = specialty;
	}
	public String getGender() {
		return this.Gender;
	}
	public void setGender(String gender) {
		this.Gender = gender;
	}
	public String getLanguage() {
		return this.Language;
	}
	public void setLanguage(String language) {
		this.Language = language;
	}
	public String getMaritalStatus() {
		return this.MaritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.MaritalStatus = maritalStatus;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getIsTextingPermitted() {
		return this.IsTextingPermitted;
	}
	public void setIsTextingPermitted(String isTextingPermitted) {
		this.IsTextingPermitted = isTextingPermitted;
	}
	public String isRemarket() {
		return this.Remarket;
	}
	public void setRemarket(String remarket) {
		this.Remarket = remarket;
	}
	public String getAbbreviatedName() {
		return this.AbbreviatedName;
	}
	public void setAbbreviatedName(String abbreviatedName) {
		this.AbbreviatedName = abbreviatedName;
	}
	public String getDriverLicenseNumber() {
		return this.DriverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.DriverLicenseNumber = driverLicenseNumber;
	}
	public String isIsTypeClient() {
		return this.IsTypeClient;
	}
	public void setIsTypeClient(String isTypeClient) {
		this.IsTypeClient = isTypeClient;
	}
	public String isIsTypeAdjuster() {
		return this.IsTypeAdjuster;
	}
	public void setIsTypeAdjuster(String isTypeAdjuster) {
		this.IsTypeAdjuster = isTypeAdjuster;
	}
	public String isIsTypeDefendant() {
		return this.IsTypeDefendant;
	}
	public void setIsTypeDefendant(String isTypeDefendant) {
		this.IsTypeDefendant = isTypeDefendant;
	}
	public String isIsTypePlaintiff() {
		return this.IsTypePlaintiff;
	}
	public void setIsTypePlaintiff(String isTypePlaintiff) {
		this.IsTypePlaintiff = isTypePlaintiff;
	}
	public String isIsTypeAttorney() {
		return this.IsTypeAttorney;
	}
	public void setIsTypeAttorney(String isTypeAttorney) {
		this.IsTypeAttorney = isTypeAttorney;
	}
	public String isIsTypeFirm() {
		return this.IsTypeFirm;
	}
	public void setIsTypeFirm(String isTypeFirm) {
		this.IsTypeFirm = isTypeFirm;
	}
	public String isIsTypeExpert() {
		return this.IsTypeExpert;
	}
	public void setIsTypeExpert(String isTypeExpert) {
		this.IsTypeExpert = isTypeExpert;
	}
	public String isIsTypeMedicalProvider() {
		return this.IsTypeMedicalProvider;
	}
	public void setIsTypeMedicalProvider(String isTypeMedicalProvider) {
		this.IsTypeMedicalProvider = isTypeMedicalProvider;
	}
	public String isIsTypeInvolvedParty() {
		return this.IsTypeInvolvedParty;
	}
	public void setIsTypeInvolvedParty(String isTypeInvolvedParty) {
		this.IsTypeInvolvedParty = isTypeInvolvedParty;
	}
	public String isIsTypeJudge() {
		return this.IsTypeJudge;
	}
	public void setIsTypeJudge(String isTypeJudge) {
		this.IsTypeJudge = isTypeJudge;
	}
	public String isIsTypeCourt() {
		return this.IsTypeCourt;
	}
	public void setIsTypeCourt(String isTypeCourt) {
		this.IsTypeCourt = isTypeCourt;
	}
	public String isIsTypeInsuranceCompany() {
		return this.IsTypeInsuranceCompany;
	}
	public void setIsTypeInsuranceCompany(String isTypeInsuranceCompany) {
		this.IsTypeInsuranceCompany = isTypeInsuranceCompany;
	}
	public String getSalutation() {
		return this.Salutation;
	}
	public void setSalutation(String salutation) {
		this.Salutation = salutation;
	}
	public String getFiduciary() {
		return this.Fiduciary;
	}
	public void setFiduciary(String fiduciary) {
		this.Fiduciary = fiduciary;
	}
	public String isIsMinor() {
		return this.IsMinor;
	}
	public void setIsMinor(String isMinor) {
		this.IsMinor = isMinor;
	}
	public String getUniqueID() {
		return this.UniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.UniqueID = uniqueID;
	}
	public String getSearchNames() {
		return this.SearchNames;
	}
	public void setSearchNames(String searchNames) {
		this.SearchNames = searchNames;
	}
	public String getBarNumber() {
		return this.BarNumber;
	}
	public void setBarNumber(String barNumber) {
		this.BarNumber = barNumber;
	}
	
	public String getIsSingleName() {
		return this.IsSingleName;
	}
	public String getRemarket() {
		return this.Remarket;
	}
	public String getIsTypeClient() {
		return this.IsTypeClient;
	}
	public String getIsTypeAdjuster() {
		return this.IsTypeAdjuster;
	}
	public String getIsTypeDefendant() {
		return this.IsTypeDefendant;
	}
	public String getIsTypePlaintiff() {
		return this.IsTypePlaintiff;
	}
	public String getIsTypeAttorney() {
		return this.IsTypeAttorney;
	}
	public String getIsTypeFirm() {
		return this.IsTypeFirm;
	}
	public String getIsTypeExpert() {
		return this.IsTypeExpert;
	}
	public String getIsTypeMedicalProvider() {
		return this.IsTypeMedicalProvider;
	}
	public String getIsTypeInvolvedParty() {
		return this.IsTypeInvolvedParty;
	}
	public String getIsTypeJudge() {
		return this.IsTypeJudge;
	}
	public String getIsTypeCourt() {
		return this.IsTypeCourt;
	}
	public String getIsTypeInsuranceCompany() {
		return this.IsTypeInsuranceCompany;
	}
	public String getIsMinor() {
		return this.IsMinor;
	}
	public String getContactId() {
		return this.ContactId;
	}
	public void setContactId(String contactId) {
		this.ContactId = contactId;
	}
	public String getPhoneId() {
		return this.phoneId;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	public String getNumber() {
		return this.Number;
	}
	public void setNumber(String number) {
		this.Number = number;
	}
	public String getRawNumber() {
		return this.RawNumber;
	}
	public void setRawNumber(String rawNumber) {
		this.RawNumber = rawNumber;
	}
	public String getPhoneLabel() {
		return this.phoneLabel;
	}
	public void setPhoneLabel(String phoneLabel) {
		this.phoneLabel = phoneLabel;
	}
	public String getAddressId() {
		return this.addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getLine1() {
		return this.Line1;
	}
	public void setLine1(String line1) {
		this.Line1 = line1;
	}
	public String getLine2() {
		return this.Line2;
	}
	public void setLine2(String line2) {
		this.Line2 = line2;
	}
	public String getCity() {
		return this.City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getZip() {
		return this.Zip;
	}
	public void setZip(String zip) {
		this.Zip = zip;
	}
	public String getAddressLabel() {
		return this.addressLabel;
	}
	public void setAddressLabel(String addressLabel) {
		this.addressLabel = addressLabel;
	}
	public String getFullAddress() {
		return this.FullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.FullAddress = fullAddress;
	}
	public String getState() {
		return this.State;
	}
	public void setState(String state) {
		this.State = state;
	}
	public String getEmailId() {
		return this.emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return this.Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	@Override
	public String toString() {
		return "MedicalProviderExport [projectId=" + projectId + ", personId=" + personId + ", orgId=" + orgId
				+ ", FirstName=" + FirstName + ", LastName=" + LastName + ", IsSingleName=" + IsSingleName
				+ ", Fullname=" + Fullname + ", Ssn=" + Ssn + ", BirthDate=" + BirthDate + ", Notes=" + Notes
				+ ", FromCompany=" + FromCompany + ", Specialty=" + Specialty + ", Gender=" + Gender + ", Language="
				+ Language + ", MaritalStatus=" + MaritalStatus + ", middleName=" + middleName + ", IsTextingPermitted="
				+ IsTextingPermitted + ", Remarket=" + Remarket + ", AbbreviatedName=" + AbbreviatedName
				+ ", DriverLicenseNumber=" + DriverLicenseNumber + ", IsTypeClient=" + IsTypeClient
				+ ", IsTypeAdjuster=" + IsTypeAdjuster + ", IsTypeDefendant=" + IsTypeDefendant + ", IsTypePlaintiff="
				+ IsTypePlaintiff + ", IsTypeAttorney=" + IsTypeAttorney + ", IsTypeFirm=" + IsTypeFirm
				+ ", IsTypeExpert=" + IsTypeExpert + ", IsTypeMedicalProvider=" + IsTypeMedicalProvider
				+ ", IsTypeInvolvedParty=" + IsTypeInvolvedParty + ", IsTypeJudge=" + IsTypeJudge + ", IsTypeCourt="
				+ IsTypeCourt + ", IsTypeInsuranceCompany=" + IsTypeInsuranceCompany + ", Salutation=" + Salutation
				+ ", Fiduciary=" + Fiduciary + ", IsMinor=" + IsMinor + ", UniqueID=" + UniqueID + ", SearchNames="
				+ SearchNames + ", BarNumber=" + BarNumber + ", personType=" + personType + ", ContactId=" + ContactId
				+ ", phoneId=" + phoneId + ", Number=" + Number + ", RawNumber=" + RawNumber + ", phoneLabel="
				+ phoneLabel + ", addressId=" + addressId + ", Line1=" + Line1 + ", Line2=" + Line2 + ", City=" + City
				+ ", Zip=" + Zip + ", addressLabel=" + addressLabel + ", FullAddress=" + FullAddress + ", State="
				+ State + ", emailId=" + emailId + ", Address=" + Address + ", emailLable=" + emailLable + "]";
	}
	
}

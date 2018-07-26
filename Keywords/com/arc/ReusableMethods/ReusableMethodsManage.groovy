package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ReusableMethodsManage extends BaseClass {
	public ReusableMethodsDataInput ReusDataInput = new ReusableMethodsDataInput()
	@Keyword
	public void verifyProjectDetailsCityCom(String sheetName, int rowNum) throws IOException, InterruptedException {
		String prjId     = data.getCellData(sheetName, "Project ID", rowNum)
		String ownOrg     = data.getCellData(sheetName, "OwnerOrganization", rowNum)
		String own_country    = data.getCellData(sheetName, "OwnerCountry", rowNum)
		String own_email   = data.getCellData(sheetName, "OwnerEmail", rowNum)
		String prjAddress       = data.getCellData(sheetName, "Address", rowNum)
		String prjCity       = data.getCellData(sheetName, "City", rowNum)
		String prjState       = data.getCellData(sheetName, "State", rowNum)
		String prjCountry     = data.getCellData(sheetName, "Country", rowNum)
		String gross_area  = data.getCellData(sheetName, "Area", rowNum)
		String Population   = data.getCellData(sheetName, "Population", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/Parking/Manage'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/Parking/ManageProject'))
		WebUI.delay(2)

		println "Verify if  registered project  project id , address , city  , country , owner details , data commissioned , project country & satate population & area fields displays the correct data."
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Manage/CityCom/project_ID'),"value").contains(prjId),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Manage/CityCom/owner_org'),"value").contains(ownOrg),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Manage/CityCom/owner_country'),"value").contains(own_country),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Manage/CityCom/owner_Email'),"value").contains(own_email),"Not Valid")

		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Manage/CityCom/project_Add'),"value").contains(prjAddress),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Manage/CityCom/proj_city'),"value").contains(prjCity),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Manage/CityCom/owner_country'),"value").contains(prjCountry),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Manage/CityCom/proj_state'),"value").contains(prjState),"Not Valid")

		Assert.assertTrue(WebUI.getAttribute(findTestObject('Manage/CityCom/input_grossArea'),"value").contains(gross_area),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Manage/CityCom/input_population'),"value").contains(Population),"Not Valid")
		println "Verified successfully  registered project project id , address , city  , country , owner details , project country & satate population & area fields"
	}

	@Keyword
	public void editProjectDetailsCityCom( String sheetName, int rowNum) throws IOException, InterruptedException {

		String editArea  = data.getCellData(sheetName, "editArea", rowNum);
		String editPopulation  = data.getCellData(sheetName, "editPopulation", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/Parking/Manage'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/Parking/ManageProject'))
		WebUI.delay(2)

		WebUI.clearText(findTestObject('Manage/CityCom/input_grossArea'))
		WebUI.sendKeys(findTestObject('Manage/CityCom/input_grossArea'),editArea )
		WebUI.click(findTestObject('Object Repository/Manage/CityCom/ClickSave'))
		WebUI.delay(2)

		WebUI.clearText(findTestObject('Manage/CityCom/input_population'))
		WebUI.sendKeys(findTestObject('Manage/CityCom/input_population'),editPopulation)
		WebUI.click(findTestObject('Object Repository/Manage/CityCom/ClickSave'))
		WebUI.delay(2)

		WebUI.refresh()
		WebUI.delay(2)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Manage/CityCom/input_grossArea'),"value").contains(editArea),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Manage/CityCom/input_population'),"value").contains(editPopulation),"Not Valid")
	}
	@Keyword
	public String verifyBillingDate() throws IOException, InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now)
		System.out.println(dtf.format(now));
	}


	@Keyword
	public editOccupanyAreaAndOpreatingHours(){
		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Building Settings'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/opreating_Hours'))
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'), 1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/selectOpreatinghours'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingOccupancy'), '2,000')
		WebUI.clearText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/buildingArea'), '5000')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/updateBuildingSettingButton'))
	}


	@Keyword
	public void verifyProjectDetails(String sheetName, int rowNum){
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjId        = data.getCellData(sheetName,"ProjectID", rowNum)
		String prjOprHrs      = data.getCellData(sheetName,"opr_hrs1", rowNum)
		String prjOccupancy    = data.getCellData(sheetName,"occupancy", rowNum)

		WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Project'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectName'),'value'),prjName)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectId'),'value'),prjId)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectAddresses'),'value'),prjAddress)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/proejctCity'),'value'), prjCity)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectState'),'value'), prjState)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectCountry'),'value'),prjCountry)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_grossArea'),'value'),prjArea)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/input_operatingHours'),'value'),prjOprHrs)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Manage/ProjectDetailVerification/projectoccupancy'),'value'),prjOccupancy)
	}


	@Keyword
	public void billingStatus(String sheetName, int rowNum){
		WebUI.delay(2)
		String regdAmt = data.getCellData(sheetName, "Amount", rowNum)
		String reviewAmt = data.getCellData(sheetName, "ReviewAmount", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))

		//Registration Payment details verification

		WebUI.delay(5)

		String regDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/registrationPaymentDate'))
		String regOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationOrderId'))
		String regOrderType= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/span_REGISTRATION'))
		String regAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationAmount'))
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))


		String regorderId = data.setCellData(sheetName, "OrderId", rowNum,regOrderId)
		Assert.assertEquals(regDate,verifyBillingDate() )
		// Assert.assertEquals(regAmount, regdAmt)
		Assert.assertEquals(regOrderType, "REGISTRATION")
		Assert.assertEquals(regStatus, "Completed")

		//Review Payment details verification
		/*
		 String revieDate= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentDate'))
		 String reviewOrderId= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewOrderId'))
		 String reviewAmount= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewAmount'))
		 String reviewStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
		 String revieworderId = data.setCellData(sheetName, "ReviewId", rowNum,reviewOrderId)
		 Assert.assertEquals(revieDate, verifyBillingDate() )
		 //	Assert.assertEquals(reviewAmount, reviewAmt)
		 Assert.assertEquals(reviewStatus, "Completed")*/
	}

	@Keyword
	public void addTeamMember(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		WebUI.delay(5)
		WebUI.setText(findTestObject('Manage/TeamModule/input_input'), 'pkamal@usgbc.org')
		WebUI.click(findTestObject('Manage/TeamModule/button_Add Member'))
		WebUI.delay(5)
		String email=WebUI.getText(findTestObject('Manage/TeamModule/NewMemberAddedEmail'))
		print email
		//checking if the new member added successfully
		Assert.assertEquals(email, 'pkamal@usgbc.org')
	}

	@Keyword
	public void editTeamMemberRole(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Manage/TeamModule/a_ Team'),2)
		WebUI.click(findTestObject('Manage/TeamModule/a_ Team'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Manage/TeamModule/button_Edit'))
		WebUI.selectOptionByLabel(findTestObject('Manage/TeamModule/select_Arc AdministratorTeam M'), 'Team Manager', false)
		WebUI.click(findTestObject('Manage/TeamModule/button_Save'))
		String authLevel= WebUI.getText(findTestObject('Object Repository/Manage/TeamModule/NewRoleAssigned'))
		print authLevel
		WebUI.delay(5)
		//checking if the member role is edited successfully
		Assert.assertEquals(authLevel, 'Team Manager')
	}


	@Keyword
	public void certificationDetailVerification(String sheetName ,int rowNum){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Manage/CertificationAndScore/a_ Certifications'), 2)
		WebUI.click(findTestObject('Manage/CertificationAndScore/a_ Certifications'))
		String certiType= data.getCellData(sheetName, "CertiType", rowNum)
		String certificationType= WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationType'))
		Assert.assertEquals(certificationType, certiType, "Certification type didn't matched")
		String certificationLevel = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationLevel'))
		Assert.assertEquals(certificationLevel,'Pending',"Ceertification level didn't matched")
		String certificationDate = WebUI.getText(findTestObject('Manage/CertificationAndScore/CertificationLevel'))
		Assert.assertEquals(certificationDate, 'Pending',"Certification date status Didn't matched")
		print certificationDate
	}

	@Keyword
	public void scoreVersionVerification(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/ProjectDetailVerification/a_ Manage'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Manage/CertificationAndScore/a_ Score Version'),2)
		WebUI.click(findTestObject('Manage/CertificationAndScore/a_ Score Version'))
		String scoreVersion = WebUI.getText(findTestObject('Manage/CertificationAndScore/h3_Arc score v2.0'))
		Assert.assertEquals(scoreVersion, "Arc score v2.0","Score version is outdated")
		print scoreVersion
		String scoreStatus= WebUI.getText(findTestObject('Manage/CertificationAndScore/h4_You are all up to date'))
		Assert.assertEquals(scoreStatus, "You are all up to date!","Score version is not updated")
		print scoreStatus
	}

	@Keyword
	public void verifyAgreementFileDownload(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ CreditsActions'))
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'),2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Agreements'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/button_Download'))
		WebUI.delay(5)
		Assert.assertTrue(ReusDataInput.isFileDownloaded('Agreement.pdf'), "Agreement File Didn't downloaded successfully")
		println "Agreemnent File downloaded and verified successfully"
	}


	@Keyword
	public void verifyBillingOrderFileDownload(String sheetName, int rowNum){

		//Verify the billing order file

		String orderId = data.getCellData(sheetName,"OrderId", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/BillingSection/a_ Billing'))
		WebUI.click(findTestObject('Manage/BillingSection/button_Download'))
		WebUI.delay(6)
		print orderId +".pdf"
		Assert.assertTrue(ReusDataInput.isFileDownloaded(orderId +".pdf"), "Order File Didn't downloaded successfully")
		println "Order File downloaded and verified successfully"

	}

	@Keyword
	public void installAppsCustom() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Manage/VerifyAgreementFile/a_ Manage'))
		println "Clicking on Apps"
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/App/a_ Apps'),2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Manage/App/a_ Apps'))
		WebUI.delay(2)

		println "Installing Dropbox"
		WebUI.click(findTestObject('Object Repository/Manage/App/DropBox'))

		println  "Installing OneDrive"
		WebUI.click(findTestObject('Object Repository/Manage/App/OneDirve'))

		println  "Installing GoogleDrive"
		WebUI.click(findTestObject('Object Repository/Manage/App/GoogleDrive'))
		Thread.sleep(10000)

		WebUI.doubleClick(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Energy'))
		WebUI.delay(3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/BDropbox'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/BgoogleDrive'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Manage/App/BOneDrive'), 2)
	}
}

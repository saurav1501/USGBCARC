package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.io.IOException
import java.text.SimpleDateFormat

public class ReusableMethodsAddNewProject extends BaseClass{
	ReusableMethodsNavigation navigation = new ReusableMethodsNavigation()
	SimpleDateFormat formatarDate = new SimpleDateFormat(' HH:mm:ss')
	@Keyword
	public void buildingAddNewProject(String sheetName , int rowNum) {
		/**************Reading data form excel sheet*************************/
		String projName1 = data.getCellData(sheetName, "Project Name", rowNum)
		println projName1
		String prjName      = data.getCellData(sheetName,"Project Name", rowNum)
		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String spaceType    = data.getCellData(sheetName, "Space Type", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);

		String ProjectName = prjName +prjRating +formatarDate.format(date)
		navigation.clickAddProject()

		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select space type'),spaceType,true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_gross_area'),prjArea )
		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.delay(2)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'),prjState, false)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/strong_Promotional Code'))
		WebUI.verifyMatch(PaymentPageText,'Promotional Code',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"Project ID", rowNum, Project_ID)
		WebUI.delay(5)
	}

	@Keyword
	public void addNewProjectCityORCom(String sheetName , int rowNum) {
		/**************Reading data form excel sheet*************************/
		String prjName      = data.getCellData(sheetName,"ProjectName", rowNum)
		String prjType 		= data.getCellData(sheetName, "ProjectType", rowNum);
		String prjRating 	= data.getCellData(sheetName, "RatingSystem", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "OwnerOrganization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "OwnerType", rowNum);
		String ownerCountry = data.getCellData(sheetName, "OwnerCountry", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "OwnerEmail", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjPopulation= data.getCellData(sheetName, "Population", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);

		String ProjectName = prjName + prjRating +formatarDate.format(date)
		navigation.clickAddProject()

		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_gross_area'),prjArea )
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_occupancy'),prjPopulation)
		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'),prjState, true)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/strong_Promotional Code'))
		WebUI.verifyMatch(PaymentPageText,'Promotional Code',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"Project ID", rowNum, Project_ID)
		WebUI.delay(5)
	}
	@Keyword
	public void parkingAddNewProject(String sheetName , int rowNum) {
		String prjName      = data.getCellData(sheetName,"Project Name", rowNum)
		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String parkingSpaces = data.getCellData(sheetName, "no_park_space", rowNum);
		String parkingStructure=  data.getCellData(sheetName, "park_level", rowNum);
		String dataCommisioned= data.getCellData(sheetName, "date_comm", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);

		String ProjectName = prjName + prjRating +formatarDate.format(date)
		navigation.clickAddProject()

		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_noOfParkingSpace'),parkingSpaces )

		WebUI.setText(findTestObject('Add_Project_Details/input_noOfParkingLevels'),parkingStructure)
		WebUI.setText(findTestObject('Add_Project_Details/input_year_constructed'),dataCommisioned)
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/input_year_constructed'))

		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/country'), prjCountry, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/state'),prjState, true)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		String PaymentPageText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/strong_Promotional Code'))
		WebUI.verifyMatch(PaymentPageText,'Promotional Code',true)
		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"Project ID", rowNum, Project_ID)
		WebUI.delay(5)
	}

	@Keyword
	public void PortfolioProjectVerifcation(String sheetName, int rowNum) throws IOException, InterruptedException {

		/**********Verifying the Project Area, Total Occupancy *************/
		String projectArea 	        = data.getCellData(sheetName, "Area", 14 );
		String projectOccupancy 	= data.getCellData(sheetName, "occupancy", 14);
		String certifiedArea 	= data.getCellData(sheetName, "Area", 15);

		System.out.println(CommonMethod.getText("TotalGrossArea").replaceAll("[,sf]","").trim());
		System.out.println(projectArea);
		Assert.assertTrue(projectArea.contains(CommonMethod.getText("TotalGrossArea").replaceAll("[,sf]","").trim()), "Total Area Didn't Matched");
		CommonMethod.testlog( "Pass", "Total Gross Floor Area verified Successfully");


		System.out.println(CommonMethod.getText("TotalCertifiedArea").replaceAll("[,sf]",""));
		System.out.println(certifiedArea);
		Assert.assertTrue(certifiedArea.contains(CommonMethod.getText("TotalCertifiedArea").replaceAll("[,sf]","").trim()), "Total Certified Area Didn't Matched");
		CommonMethod.testlog( "Pass", "Total Certified Floor Area verified Successfully");

		/******** Verify Total Occupant ********/

		Assert.assertTrue(projectOccupancy.contains(CommonMethod.getText("TotalOccupant").replaceAll("[,sf]","").trim()), "Total Occupancy Didn't Matched");
		CommonMethod.testlog( "Pass", "Total Occupancy Verified Successfully");

		/********** Verify Total Project ************/

		CommonMethod.assertcontainsmessage("TotalProject", "10", " Total Project Not Matched ");
		CommonMethod.testlog( "Pass", "Total Project Count Verified Successfully");

		CommonMethod.testlog( "Pass", "Portfolio Projects Details Verified  Successfully");
	}
}
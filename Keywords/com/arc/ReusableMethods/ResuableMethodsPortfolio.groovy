package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.math.RoundingMode
import java.text.SimpleDateFormat
import javax.management.relation.Role
import org.testng.Assert
import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ResuableMethodsPortfolio extends BaseClass {
	SimpleDateFormat formatarDate = new SimpleDateFormat('HHmmss')
	@Keyword
	public void createNewPortfolio( String sheetName,int rowNum) throws IOException, InterruptedException {
		String  organization = data.getCellData(sheetName,"Organization",rowNum)
		String  orgCountry 	= data.getCellData(sheetName, "orgCountry", rowNum)
		String  orgContact 	= data.getCellData(sheetName, "orgContact", rowNum)
		String  location 	= data.getCellData(sheetName, "location", rowNum)
		String  email = data.getCellData(sheetName, "email", rowNum)
		String  desc 	= data.getCellData(sheetName,"portfolioDesc", rowNum)
		data.setCellData(sheetName,"ProjectName",rowNum, "Building Portfolio" +" " +formatarDate.format(date));
		String prjName 	= data.getCellData(sheetName, "ProjectName", rowNum)
		WebUI.click(findTestObject('Portfolio/Common/button_ Create a Portfolio'))
		WebUI.delay(4)
		WebUI.setText(findTestObject('Portfolio/Common/input_name'), prjName)
		WebUI.setText(findTestObject('Portfolio/Common/input_organization'), organization)
		WebUI.click(findTestObject('Portfolio/Common/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/span_Z Park'))
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Common/OwnerOrg'), orgCountry,false)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_organization_c'), orgContact)
		WebUI.setText(findTestObject('Portfolio/Common/input_location'),location)
		WebUI.setText(findTestObject('Portfolio/Common/input_portfolio_email'),email)
		WebUI.setText(findTestObject('Portfolio/Common/textarea_Description'), desc)
		WebUI.click(findTestObject('Portfolio/Common/button_Create'))
		WebUI.delay(7)
		WebUI.click(findTestObject('Portfolio/Common/button_Done'))
		WebUI.delay(5)
		String started = WebUI.getText(findTestObject('Portfolio/Common/p_Get Started'))
		WebUI.verifyMatch(started,"Get Started!", true)
	}

	@Keyword
	public void AddProjectInPortfolio(String sheetName , int rowNum) throws IOException, InterruptedException {
		String prjName 	= data.getCellData(sheetName,"ProjectName", rowNum)
		/**** Adding 10-Projects in Portfolio ****/
		for(int col=2;col<=11;col++ ) {
			String projectId 	= data.getCellData(sheetName,"ID", col)
			String portfolioName 	= data.getCellData(sheetName, "ProjectName", rowNum)
			WebUI.click(findTestObject('Portfolio/Common/span_Add a Project'))
			WebUI.delay(3)
			WebUI.setText(findTestObject('Portfolio/Common/input_searchBarPort'), projectId)
			WebUI.click(findTestObject('Portfolio/Common/input_searchBarPort'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Portfolio/Common/SelectProjectInPortfolio'))
			WebUI.setText(findTestObject('Portfolio/Common/input_searchBarPortfolio'),portfolioName)
			WebUI.click(findTestObject('Portfolio/Common/input_searchBarPortfolio'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Portfolio/Common/SelectPortfolio'))
			WebUI.click(findTestObject('Portfolio/Common/button_Add'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Portfolio/Common/button_Done'))
			WebUI.delay(2)
			String verifyPortfioio =WebUI.getText(findTestObject('Portfolio/Common/ProjectName'))
			WebUI.verifyMatch(verifyPortfioio,portfolioName,false)
		}
		println  "10 Projects Successfully added in DashBoard"
	}

	@Keyword
	public void addProjectDVProtfolio(String sheetName, int rowNum) throws IOException, InterruptedException {
		/**********Verifying the Project Area, Total Occupancy *************/
		String projectArea 	        = data.getCellData(sheetName, "Area", 14 );
		String projectOccupancy 	= data.getCellData(sheetName, "occupancy", 14);
		String certifiedArea 	= data.getCellData(sheetName, "Area", 15);

		String totalGrossArea = WebUI.getText(findTestObject('Portfolio/Common/TotalGrossArea'))
		WebUI.verifyMatch(projectArea,totalGrossArea,false)
		println  "Total Gross Floor Area verified Successfully"

		String ProjectOccupancy = WebUI.getText(findTestObject('Portfolio/Common/TotalOccupant'))
		WebUI.verifyMatch(projectOccupancy,ProjectOccupancy,false)
		println  "Total Gross Floor Area verified Successfully"

		String  CertifiedArea = WebUI.getText(findTestObject('Portfolio/Common/TotalCertifiedArea'))
		WebUI.verifyMatch(certifiedArea,CertifiedArea,false)
		System.out.println(certifiedArea)

		String TotalOccupant = WebUI.getText(findTestObject('Portfolio/Common/TotalOccupant'))
		WebUI.verifyMatch(projectOccupancy,TotalOccupant,false)

		String taddedProject = WebUI.getText(findTestObject('Portfolio/Common/TotalProject'))
		WebUI.verifyMatch(taddedProject,"10",false)
	}
	@Keyword
	public void portfolioTScorePDetailsVerifcation(String sheetName, int rowNum) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.click(findTestObject('Portfolio/Common/span_Scores'))
		WebUI.delay(2)
		for(int count =1;count<10;count++) {
			if(count==1) {
				int row =2;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==2) {
				int row =3;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==3) {
				int row =4;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==4) {
				int row =5;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==5) {
				int row =6;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==5) {
				int row =6;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==6) {
				int row =7;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}

			if(count==8) {
				int row =9;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==9) {
				int row =10;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
			if(count==10) {
				int row =11;
				String projectName = data.getCellData(sheetName, "Project Name", row)
				String totalScore = data.getCellData(sheetName, "totalScore", row )
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[1]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), projectName, false)
				myTestObject.addProperty("xpath", ConditionType.EQUALS,"//table[@class='table table-sorted arcTbl']/tbody/tr["+count+"]/td[2]").toString()
				WebUI.verifyMatch(WebUI.getText(myTestObject), totalScore, false)
				System.out.println("Total performance score " + totalScore + " Verified Successfully")
			}
		}
	}

	@Keyword
	public void analyticsEnergyScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "energyScore", 17);
		String averageScore =data.getCellData(sheetName, "energyScore", 19);
		String lowestScore  =data.getCellData(sheetName, "energyScore", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Energy'))
		WebUI.delay(5)

		println highScore
		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/EHighestScore'))
		println highestScorePoint

		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Energy verified Successfully"


		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/EAverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Energy verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/ELowestScore'))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Energy verified Successfully"

		println "Filering top 5 project name , project id , city , score"

		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjName1    =data.getCellData(sheetName, "Project Name", 2);  //2, 3 ,4, 8 , 6
		String prjId1    =data.getCellData(sheetName, "ID", 2);
		String prjCity1    =data.getCellData(sheetName, "City", 2);
		String prjScore1   =data.getCellData(sheetName, "energyScore", 2);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName1')), prjName1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId1')), prjId1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity1')), prjCity1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName1  + prjId1  + prjCity1 +  prjScore1

		String prjName2    =data.getCellData(sheetName, "Project Name", 3);
		String prjId2    =data.getCellData(sheetName, "ID", 3);
		String prjCity2    =data.getCellData(sheetName, "City", 3);
		String prjScore2   =data.getCellData(sheetName, "energyScore", 3);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName2')), prjName2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId2')), prjId2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity2')), prjCity2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName2  + prjId2  + prjCity2 +  prjScore2


		String prjName3   =data.getCellData(sheetName, "Project Name", 4);
		String prjId3    =data.getCellData(sheetName, "ID", 4);
		String prjCity3   =data.getCellData(sheetName, "City", 4);
		String prjScore3   =data.getCellData(sheetName, "energyScore", 4);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName3')), prjName3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId3')), prjId3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity3')), prjCity3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName3  + prjId3  + prjCity3 +  prjScore3

		String prjName4    =data.getCellData(sheetName, "Project Name", 8);
		String prjId4    =data.getCellData(sheetName, "ID", 8);
		String prjCity4    =data.getCellData(sheetName, "City", 8);
		String prjScore4   =data.getCellData(sheetName, "energyScore", 8);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName4')), prjName4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId4')), prjId4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity4')), prjCity4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName4  + prjId4  + prjCity4 +  prjScore4

		String prjName5    =data.getCellData(sheetName, "Project Name", 6);
		String prjId5    =data.getCellData(sheetName, "ID", 6);
		String prjCity5    =data.getCellData(sheetName, "City", 6);
		String prjScore5   =data.getCellData(sheetName, "energyScore", 6);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName5')), prjName5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId5')), prjId5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity5')), prjCity5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName5  + prjId5  + prjCity5 +  prjScore5

	}


	@Keyword
	public void analyticsTotalScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "totalScore", 17);
		String averageScore =data.getCellData(sheetName, "totalScore", 19);
		String lowestScore  =data.getCellData(sheetName, "totalScore", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Total/HighestScore '))
		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Total/AverageScore'))
		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Total/LowestScore '))

		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Tota Highest score  verified Successfully"

		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Tota Average score verified Successfully"

		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Total Lowest score verified Successfully"
	}

	@Keyword
	public void analyticsCarbonScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "carbonEmission", 17);
		String averageScore =data.getCellData(sheetName, "carbonEmission", 19);
		String lowestScore  =data.getCellData(sheetName, "carbonEmission", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Carbon'))
		WebUI.delay(5)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/CaronHighest'))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for carbon  verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/CarbonAvg'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for carbon verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/CarbonLow'))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for carbon verified Successfully"

		println "Filering top 5 project name , project id , city , score"

		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjName1    =data.getCellData(sheetName, "Project Name", 2);  //2, 3 ,4, 8 , 6
		String prjId1    =data.getCellData(sheetName, "ID", 2);
		String prjCity1    =data.getCellData(sheetName, "City", 2);
		String prjScore1   =data.getCellData(sheetName, "energyScore", 2);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName1')), prjName1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId1')), prjId1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity1')), prjCity1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for carbon top 5 score below details are verified Successfully" + prjName1  + prjId1  + prjCity1 +  prjScore1

		String prjName2    =data.getCellData(sheetName, "Project Name", 3);
		String prjId2    =data.getCellData(sheetName, "ID", 3);
		String prjCity2    =data.getCellData(sheetName, "City", 3);
		String prjScore2   =data.getCellData(sheetName, "energyScore", 3);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName2')), prjName2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId2')), prjId2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity2')), prjCity2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for carbon top 5 score below details are verified Successfully" + prjName2  + prjId2  + prjCity2 +  prjScore2


		String prjName3   =data.getCellData(sheetName, "Project Name", 4);
		String prjId3    =data.getCellData(sheetName, "ID", 4);
		String prjCity3   =data.getCellData(sheetName, "City", 4);
		String prjScore3   =data.getCellData(sheetName, "energyScore", 4);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName3')), prjName3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId3')), prjId3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity3')), prjCity3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for carbon top 5 score below details are verified Successfully" + prjName3  + prjId3  + prjCity3 +  prjScore3

		String prjName4    =data.getCellData(sheetName, "Project Name", 8);
		String prjId4    =data.getCellData(sheetName, "ID", 8);
		String prjCity4    =data.getCellData(sheetName, "City", 8);
		String prjScore4   =data.getCellData(sheetName, "energyScore", 8);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName4')), prjName4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId4')), prjId4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity4')), prjCity4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for carbon top 5 score below details are verified Successfully" + prjName4  + prjId4  + prjCity4 +  prjScore4

		String prjName5    =data.getCellData(sheetName, "Project Name", 6);
		String prjId5    =data.getCellData(sheetName, "ID", 6);
		String prjCity5    =data.getCellData(sheetName, "City", 6);
		String prjScore5   =data.getCellData(sheetName, "energyScore", 6);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName5')), prjName5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId5')), prjId5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity5')), prjCity5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for carbon top 5 score below details are verified Successfully" + prjName5  + prjId5  + prjCity5 +  prjScore5

	}

	@Keyword
	public void analyticsWaterScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "waterScore", 17);
		String averageScore =data.getCellData(sheetName, "waterScore", 19);
		String lowestScore  =data.getCellData(sheetName, "waterScore", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Water'))
		WebUI.delay(5)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/WHighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Energy verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/WAverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Energy verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/WLowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Energy verified Successfully"

		println "Filering top 5 project name , project id , city , score"

		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjName1    =data.getCellData(sheetName, "Project Name", 3);  //3,4,7,2,6
		String prjId1    =data.getCellData(sheetName, "ID", 3);
		String prjCity1    =data.getCellData(sheetName, "City", 3);
		String prjScore1   =data.getCellData(sheetName, "waterScore", 3);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName1')), prjName1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId1')), prjId1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity1')), prjCity1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName1  + prjId1  + prjCity1 +  prjScore1

		String prjName2    =data.getCellData(sheetName, "Project Name", 4);
		String prjId2    =data.getCellData(sheetName, "ID", 4);
		String prjCity2    =data.getCellData(sheetName, "City", 4);
		String prjScore2   =data.getCellData(sheetName, "waterScore", 4);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName2')), prjName2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId2')), prjId2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity2')), prjCity2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName2  + prjId2  + prjCity2 +  prjScore2


		String prjName3   =data.getCellData(sheetName, "Project Name", 7);
		String prjId3    =data.getCellData(sheetName, "ID", 7);
		String prjCity3   =data.getCellData(sheetName, "City", 7);
		String prjScore3   =data.getCellData(sheetName, "waterScore", 7);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName3')), prjName3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId3')), prjId3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity3')), prjCity3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName3  + prjId3  + prjCity3 +  prjScore3

		String prjName4    =data.getCellData(sheetName, "Project Name", 2);
		String prjId4    =data.getCellData(sheetName, "ID", 2);
		String prjCity4    =data.getCellData(sheetName, "City", 2);
		String prjScore4   =data.getCellData(sheetName, "waterScore", 2);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName4')), prjName4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId4')), prjId4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity4')), prjCity4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName4  + prjId4  + prjCity4 +  prjScore4

		String prjName5    =data.getCellData(sheetName, "Project Name", 6);
		String prjId5    =data.getCellData(sheetName, "ID", 6);
		String prjCity5    =data.getCellData(sheetName, "City", 6);
		String prjScore5   =data.getCellData(sheetName, "waterScore", 6);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName5')), prjName5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId5')), prjId5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity5')), prjCity5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for Energy top 5 score below details are verified Successfully" + prjName5  + prjId5  + prjCity5 +  prjScore5

	}

	@Keyword
	public void analyticsWasteScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "wasteScore", 17);
		String averageScore =data.getCellData(sheetName, "wasteScore", 19);
		String lowestScore  =data.getCellData(sheetName, "wasteScore", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Waste'))
		WebUI.delay(5)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/HighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Waste verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/AverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Waste verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/LowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Waste verified Successfully"

		println "Filering top 5 project name , project id , city , score"

		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjName1    =data.getCellData(sheetName, "Project Name", 3);  //3,4,7,8,5
		String prjId1    =data.getCellData(sheetName, "ID", 3);
		String prjCity1    =data.getCellData(sheetName, "City", 3);
		String prjScore1   =data.getCellData(sheetName, "wasteScore", 3);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName1')), prjName1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId1')), prjId1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity1')), prjCity1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre1')), prjScore1, false)
		println "Filter for waste top 5 score below details are verified Successfully" + prjName1  + prjId1  + prjCity1 +  prjScore1

		String prjName2    =data.getCellData(sheetName, "Project Name", 4);
		String prjId2    =data.getCellData(sheetName, "ID", 4);
		String prjCity2    =data.getCellData(sheetName, "City", 4);
		String prjScore2   =data.getCellData(sheetName, "wasteScore", 4);


		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName2')), prjName2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId2')), prjId2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity2')), prjCity2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre2')), prjScore2, false)
		println "Filter for waste top 5 score below details are verified Successfully" + prjName2  + prjId2  + prjCity2 +  prjScore2


		String prjName3    =data.getCellData(sheetName, "Project Name", 8);
		String prjId3    =data.getCellData(sheetName, "ID", 8);
		String prjCity3    =data.getCellData(sheetName, "City", 8);
		String prjScore3   =data.getCellData(sheetName, "wasteScore", 8);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName3')), prjName3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId3')), prjId3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity3')), prjCity3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre3')), prjScore3, false)
		println "Filter for waste top 5 score below details are verified Successfully" + prjName3  + prjId3  + prjCity3 +  prjScore3

		String prjName4    =data.getCellData(sheetName, "Project Name",7);
		String prjId4    =data.getCellData(sheetName, "ID", 7);
		String prjCity4    =data.getCellData(sheetName, "City",7);
		String prjScore4   =data.getCellData(sheetName, "wasteScore", 7);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName4')), prjName4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId4')), prjId4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity4')), prjCity4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre4')), prjScore4, false)
		println "Filter for waste top 5 score below details are verified Successfully" + prjName4  + prjId4  + prjCity4 +  prjScore4

		String prjName5    =data.getCellData(sheetName, "Project Name", 5);
		String prjId5    =data.getCellData(sheetName, "ID", 5);
		String prjCity5    =data.getCellData(sheetName, "City", 5);
		String prjScore5   =data.getCellData(sheetName, "wasteScore", 5);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectName5')), prjName5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FProjectId5')), prjId5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FCity5')), prjCity5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/Common/FTopSocre5')), prjScore5, false)
		println "Filter for waste top 5 score below details are verified Successfully" + prjName5  + prjId5  + prjCity5 +  prjScore5

	}

	@Keyword
	public void analyticsTransportScore(String sheetName, int rowNum ) throws IOException, InterruptedException {
		String highScore    =data.getCellData(sheetName, "transportation", 17);
		String averageScore =data.getCellData(sheetName, "transportation", 19);
		String lowestScore  =data.getCellData(sheetName, "transportation", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Transportation'))
		WebUI.delay(5)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/HighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Transportation verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/AverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Transportation verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/LowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Transportation verified Successfully"

		println "Filering top 5 project name , project id , city , score"
		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjName1    =data.getCellData(sheetName, "Project Name", 7);  //7,5,2,9,6
		String prjId1    =data.getCellData(sheetName, "ID", 7);
		String prjCity1    =data.getCellData(sheetName, "City", 7);
		String prjScore1   =data.getCellData(sheetName, "transportation", 7);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName1')), prjName1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId1')), prjId1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity1')), prjCity1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre1')), prjScore1, false)
		println "Filter for Transportation top 5 score below details are verified Successfully" + prjName1  + prjId1  + prjCity1 +  prjScore1

		String prjName2    =data.getCellData(sheetName, "Project Name", 5);
		String prjId2    =data.getCellData(sheetName, "ID", 5);
		String prjCity2    =data.getCellData(sheetName, "City", 5);
		String prjScore2   =data.getCellData(sheetName, "transportation", 5);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName2')), prjName2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId2')), prjId2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity2')), prjCity2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre2')), prjScore2, false)
		println "Filter for Transportation top 5 score below details are verified Successfully" + prjName2  + prjId2  + prjCity2 +  prjScore2

		String prjName3    =data.getCellData(sheetName, "Project Name", 2);
		String prjId3    =data.getCellData(sheetName, "ID", 2);
		String prjCity3    =data.getCellData(sheetName, "City", 2);
		String prjScore3   =data.getCellData(sheetName, "transportation", 2);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName3')), prjName3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId3')), prjId3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity3')), prjCity3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre3')), prjScore3, false)
		println "Filter for Transportation top 5 score below details are verified Successfully" + prjName3  + prjId3  + prjCity3 +  prjScore3

		String prjName4    =data.getCellData(sheetName, "Project Name",9);
		String prjId4    =data.getCellData(sheetName, "ID", 9);
		String prjCity4    =data.getCellData(sheetName, "City",9);
		String prjScore4   =data.getCellData(sheetName, "transportation", 9);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName4')), prjName4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId4')), prjId4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity4')), prjCity4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre4')), prjScore4, false)
		println "Filter for Transportation top 5 score below details are verified Successfully" + prjName4  + prjId4  + prjCity4 +  prjScore4

		String prjName5    =data.getCellData(sheetName, "Project Name", 6);
		String prjId5    =data.getCellData(sheetName, "ID", 6);
		String prjCity5    =data.getCellData(sheetName, "City", 6);
		String prjScore5   =data.getCellData(sheetName, "transportation", 6);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName5')), prjName5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId5')), prjId5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity5')), prjCity5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre5')), prjScore5, false)
		println "Filter for Transportation top 5 score below details are verified Successfully" + prjName5  + prjId5  + prjCity5 +  prjScore5

	}
	@Keyword
	public void analyticsHExperiaceScore(String sheetName, int rowNum ) throws IOException, InterruptedException {

		String highScore    =data.getCellData(sheetName, "humanExperience", 17);
		String averageScore =data.getCellData(sheetName, "humanExperience", 19);
		String lowestScore  =data.getCellData(sheetName, "humanExperience", 18);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Human Experience'))
		WebUI.delay(5)

		String highestScorePoint = WebUI.getText(findTestObject('Portfolio/Common/HighestScore '))
		WebUI.verifyMatch(highestScorePoint,highScore,false)
		println "Highest score for Humam experiace verified Successfully"

		String avgScorePoint = WebUI.getText(findTestObject('Portfolio/Common/AverageScore'))
		WebUI.verifyMatch(avgScorePoint,averageScore,false)
		println "Average score for Humam experiace verified Successfully"

		String lowScorePoint = WebUI.getText(findTestObject('Portfolio/Common/LowestScore '))
		WebUI.verifyMatch(lowScorePoint,lowScorePoint,false)
		println "Lowest score for Humam experiace verified Successfully"

		println "Filering top 5 project name , project id , city , score"

		WebUI.click(findTestObject('Portfolio/Common/span_Lowest 5 Performers'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_Top 5 Performers'))
		WebUI.delay(5)

		String prjName1    =data.getCellData(sheetName, "Project Name", 5);  //5 , 7 ,9 ,2 ,6
		String prjId1    =data.getCellData(sheetName, "ID", 5);
		String prjCity1    =data.getCellData(sheetName, "City", 5);
		String prjScore1   =data.getCellData(sheetName, "humanExperience", 5);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName1')), prjName1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId1')), prjId1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity1')), prjCity1, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre1')), prjScore1, false)
		println "Filter for Humam experiace top 5 score below details are verified Successfully" + prjName1  + prjId1  + prjCity1 +  prjScore1

		String prjName2    =data.getCellData(sheetName, "Project Name", 7);
		String prjId2    =data.getCellData(sheetName, "ID", 7);
		String prjCity2    =data.getCellData(sheetName, "City", 7);
		String prjScore2   =data.getCellData(sheetName, "humanExperience", 7);


		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName2')), prjName2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId2')), prjId2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity2')), prjCity2, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre2')), prjScore2, false)
		println "Filter for Humam experiace top 5 score below details are verified Successfully" + prjName2  + prjId2  + prjCity2 +  prjScore2


		String prjName3    =data.getCellData(sheetName, "Project Name",9 );
		String prjId3    =data.getCellData(sheetName, "ID", 9);
		String prjCity3    =data.getCellData(sheetName, "City", 9);
		String prjScore3   =data.getCellData(sheetName, "humanExperience", 9);


		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName3')), prjName3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId3')), prjId3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity3')), prjCity3, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre3')), prjScore3, false)
		println "Filter for Humam experiace top 5 score below details are verified Successfully" + prjName3  + prjId3  + prjCity3 +  prjScore3

		String prjName4    =data.getCellData(sheetName, "Project Name",2);
		String prjId4    =data.getCellData(sheetName, "ID", 2);
		String prjCity4    =data.getCellData(sheetName, "City",2);
		String prjScore4   =data.getCellData(sheetName, "humanExperience", 2);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName4')), prjName4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId4')), prjId4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity4')), prjCity4, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre4')), prjScore4, false)
		println "Filter for Humam experiace  top 5 score below details are verified Successfully" + prjName4  + prjId4  + prjCity4 +  prjScore4

		String prjName5    =data.getCellData(sheetName, "Project Name", 6);
		String prjId5    =data.getCellData(sheetName, "ID", 6);
		String prjCity5    =data.getCellData(sheetName, "City", 6);
		String prjScore5   =data.getCellData(sheetName, "humanExperience", 6);

		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectName5')), prjName5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FProjectId5')), prjId5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FCity5')), prjCity5, false)
		WebUI.verifyMatch(WebUI.getText(findTestObject('Portfolio/TranHum/FTopSocre5')), prjScore5, false)
		println "Filter for Humam experiace top 5 score below details are verified Successfully" + prjName5  + prjId5  + prjCity5 +  prjScore5

	}
	@Keyword
	public void goalCarbon(String sheetName, int rowNum) throws IOException, InterruptedException {
		/****** Methods Verifying the annual carbon emission, goal calculation & validating the text area is saving the text or not after refresh *****/
		String cpReduction = data.getCellData(sheetName, "CPReduction", rowNum);
		String cbValue = data.getCellData(sheetName, "CBValue", rowNum);
		String cUnit = data.getCellData(sheetName, "Cunit", rowNum);
		String ctextbox = data.getCellData(sheetName,"CTextBox", rowNum);
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum);
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying carbon unit MTCO2E"
		String mtco2e = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/CarbonUnit'))
		System.out.println(mtco2e);
		WebUI.delay(1)
		WebUI.verifyMatch(cUnit, mtco2e, false)
		println "Test passed verified carbon unit  MTCO2E successfully"

		println "Test Started Carbon differece of goal calcation"
		WebUI.clearText(findTestObject('Portfolio/Goal/carbon_percent_reduction'))
		WebUI.sendKeys(findTestObject('Portfolio/Goal/carbon_percent_reduction'), cpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Portfolio/Goal/energy_baseline_value'))
		WebUI.sendKeys(findTestObject('Portfolio/Goal/energy_baseline_value'), cbValue)

		WebUI.click(findTestObject('Portfolio/Goal/CarbonDiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/CarbonDiffGoal'))
		System.out.println(forntenddiffGoal);

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		System.out.println(currentProgress);
		String replace = currentProgress.replace("%" , "")
		double replace1=Double.parseDouble(replace);
		System.out.println("Fatching replaced value");
		System.out.println(replace)
		double depReduction=Double.parseDouble(cpReduction)
		double result1 =depReduction -replace1;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 = result2 .setScale(2, RoundingMode.HALF_UP)
		String calcalteddiffGoal = result2 + " %";
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/Carbon_base_year'), baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Portfolio/Goal/carbon_target_year'), targetYear, true)

		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Goal/CarbonGoalBar'))
		String greplace = carbonGoal.replace("%" , "");
		double cGexpected=Double.parseDouble(greplace);
		System.out.println(cGexpected);
		double cGactual = depReduction/2;
		System.out.println(cGactual);
		Assert.assertEquals(cGactual,cGexpected);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.click(findTestObject('Portfolio/Goal/carbon_description_textarea'))
		WebUI.clearText(findTestObject('Portfolio/Goal/carbon_description_textarea'))
		WebUI.sendKeys(findTestObject('Portfolio/Goal/carbon_description_textarea'),ctextbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)
		println cbValue
		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Object Repository/Portfolio/Goal/carbon_baseline_value'),"value").contains(cbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/carbon_percent_reduction'),"value").contains(cpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/carbon_description_textarea'),"value").contains(ctextbox),"Not Valid")
		println "Test passed verified carbon textarea, carbon reducion , base line value after refersh successfully"

	}
	@Keyword
	public void goalEnergy(String sheetName,int rowNum) throws IOException, InterruptedException {

		String epReduction 	= data.getCellData(sheetName, "EPReduction", rowNum);
		String ebValue 	= data.getCellData(sheetName, "EBValue", rowNum);
		String eUnit 	= data.getCellData(sheetName, "Eunit", rowNum);
		String textbox = data.getCellData(sheetName,"ETextBox", rowNum);
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum);
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying energy unit Kbtu"
		String kbtu = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/EnergyUnitkBtu'))
		System.out.println(kbtu);
		WebUI.delay(1)
		WebUI.verifyMatch(kbtu, eUnit, false)
		println "Test passed verified energy unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/energy_percent_reduction'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/energy_percent_reduction'), epReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/energy_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/energy_baseline_value'), ebValue)



		WebUI.click(findTestObject('Portfolio/Goal/EnergyDiffGoal'))
		WebUI.delay(2)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/EnergyDiffGoal'))
		System.out.println(forntenddiffGoal);

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/energy_CurrentProgess'))
		System.out.println(currentProgress);
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		System.out.println("Fatching replaced value");
		System.out.println(replace)
		double depReduction=Double.parseDouble(epReduction);
		double result1 =depReduction -replace1;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 = result2 .setScale(2, RoundingMode.HALF_UP);
		String calcalteddiffGoal = result2 + " %";
		System.out.println(calcalteddiffGoal);
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/energy_baseline_year'), baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/energy_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/EnergyGoal'))
		String greplace = energyGoal.replace("%" , "");
		double eGexpected=Double.parseDouble(greplace);
		System.out.println(eGexpected);
		double eGactual = 100/2;
		System.out.println(eGactual);
		Assert.assertEquals(eGactual,eGexpected);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/energy_description_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/energy_baseline_value'),"value").contains(ebValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/energy_percent_reduction'),"value").contains(epReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/energy_description_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified energy textarea, energy reducion , base line value after refersh successfully"



	}

	@Keyword
	public void goalWater(String sheetName,int rowNum) throws IOException, InterruptedException {

		String wpReduction = data.getCellData(sheetName, "WPReduction", rowNum);
		String wbValue 	= data.getCellData(sheetName, "WBValue", rowNum);
		String wUnit 	= data.getCellData(sheetName, "Wunit", rowNum);
		String textbox 	= data.getCellData(sheetName,"WTextBox", rowNum);
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying energy unit Gal"
		String gal = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/WaterUnit'))
		System.out.println(gal);
		WebUI.delay(1)
		WebUI.verifyMatch(gal, wUnit, false)
		println "Test passed verified water unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/water_percent_reduction'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/water_percent_reduction'), wpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/water_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/water_baseline_value'), wbValue)

		WebUI.click(findTestObject('Portfolio/Goal/waterDiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/waterDiffGoal'))
		System.out.println(forntenddiffGoal);

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/WaterCurrentProgess'))
		System.out.println(currentProgress);
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		System.out.println("Fatching replaced value");
		System.out.println(replace)
		double depReduction=Double.parseDouble(wpReduction);
		double result1 =depReduction -replace1;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 = result2 .setScale(2, RoundingMode.HALF_UP);
		String calcalteddiffGoal = result2 + " %";
		System.out.println(calcalteddiffGoal);
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/water_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/water_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/WaterGoal'))
		String greplace = energyGoal.replace("%" , "");
		double wGexpected=Double.parseDouble(greplace);
		System.out.println(wGexpected);
		double wGactual = depReduction/2;
		System.out.println(wGactual);
		Assert.assertEquals(wGactual,wGexpected);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/water_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/water_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/water_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/water_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/water_baseline_value'),"value").contains(wbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/water_percent_reduction'),"value").contains(wpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/water_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified water textarea, energy reducion , base line value after refersh successfully"

	}
	@Keyword
	public void goalGeneratedWaste(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/	

		String wpReduction = data.getCellData(sheetName, "WastePReduction", rowNum);
		String wbValue = data.getCellData(sheetName, "WasteBValue", rowNum);
		String wUnit = data.getCellData(sheetName, "Wasteunit", rowNum);
		String wtextbox = data.getCellData(sheetName,"WasteTextBox", rowNum);
		String textbox 	= data.getCellData(sheetName,"WTextBox", rowNum);
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying energy unit lbs"
		String lbs = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/generated_waste_Unit'))
		System.out.println(lbs);
		WebUI.delay(1)
		WebUI.verifyMatch(lbs, wUnit, false)
		println "Test passed verified water unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/generated_waste_percent_reduction'))
		println wpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/generated_waste_percent_reduction'), wpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/generated_waste_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/generated_waste_baseline_value'), wbValue)

		WebUI.click(findTestObject('Portfolio/Goal/generated_waste_DiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_DiffGoal'))
		System.out.println(forntenddiffGoal);

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_currentProgress'))
		System.out.println(currentProgress);
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		System.out.println("Fatching replaced value");
		System.out.println(replace)
		double depReduction=Double.parseDouble(wpReduction);
		double result1 =depReduction -replace1;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 = result2 .setScale(2, RoundingMode.HALF_UP);
		String calcalteddiffGoal = result2 + " %";
		System.out.println(calcalteddiffGoal);
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/generated_waste_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/generated_waste_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_Goal'))
		String greplace = energyGoal.replace("%" , "");
		double wGexpected=Double.parseDouble(greplace);
		System.out.println(wGexpected);
		double wGactual = depReduction/2;
		System.out.println(wGactual);
		Assert.assertEquals(wGactual,wGexpected);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/generated_waste_baseline_value'),"value").contains(wbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/generated_waste_percent_reduction'),"value").contains(wpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/waste_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified energy textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalDivertedWaste(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/

		String wpReduction = data.getCellData(sheetName, "WastePReduction", rowNum);
		String wbValue = data.getCellData(sheetName, "WasteBValue", rowNum);
		String wUnit = data.getCellData(sheetName, "Wasteunit", rowNum);
		String wtextbox = data.getCellData(sheetName,"WasteTextBox", rowNum);
		String textbox 	= data.getCellData(sheetName,"WTextBox", rowNum);
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)


		println "Test started verifying energy unit lbs"
		String lbs = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_unit'))
		System.out.println(lbs);
		WebUI.delay(1)
		WebUI.verifyMatch(lbs, wUnit, false)
		println "Test passed verified water unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_percent_reduction'))
		println wpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_percent_reduction'), wpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/diverted_waste_baseline_value'), wbValue)

		WebUI.click(findTestObject('Portfolio/Goal/diverted_waste_DiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/diverted_waste_DiffGoal'))
		System.out.println(forntenddiffGoal);

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/diverted_waste_currentProgess'))
		System.out.println(currentProgress);
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		System.out.println("Fatching replaced value");
		System.out.println(replace)
		double depReduction=Double.parseDouble(wpReduction);
		double result1 =depReduction -replace1;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 = result2 .setScale(2, RoundingMode.HALF_UP);
		String calcalteddiffGoal = result2 + " %";
		System.out.println(calcalteddiffGoal);

		Assert.assertEquals(forntenddiffGoal,calcalteddiffGoal);
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/diverted_waste_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/diverted_waste_target_year'),targetYear,true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/generated_waste_Goal'))
		String greplace = energyGoal.replace("%" , "");
		double wGexpected=Double.parseDouble(greplace);
		System.out.println(wGexpected);
		double wGactual = depReduction/2;
		System.out.println(wGactual);
		Assert.assertEquals(wGactual,wGexpected);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/waste_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/CarbonCurrentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/diverted_waste_baseline_value'),"value").contains(wbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/diverted_waste_percent_reduction'),"value").contains(wpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/waste_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified waste textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalTransport(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/

		String tpReduction = data.getCellData(sheetName, "TReduction", rowNum);
		String tbValue 	= data.getCellData(sheetName, "TBValue", rowNum);
		String tUnit 	= data.getCellData(sheetName, "Tunit", rowNum);
		String textbox = data.getCellData(sheetName,"TTextBox", rowNum);

		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying energy unit lbs"
		String mtco2e = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/TransportUnit'))
		System.out.println(mtco2e);
		WebUI.delay(1)
		WebUI.verifyMatch(mtco2e, tUnit, false)
		println "Test passed verified transport unit successfully"

		println "Test Started energy differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/transport_percent_reduction'))
		println tpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/transport_percent_reduction'), tpReduction)
		println  "Filling carbon baseline value"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/transport_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/transport_baseline_value'), tbValue)

		WebUI.click(findTestObject('Portfolio/Goal/diverted_waste_DiffGoal'))
		WebUI.delay(3)
		String forntenddiffGoal = WebUI.getText(findTestObject('Portfolio/Goal/transport_DiffGoal'))
		System.out.println(forntenddiffGoal);

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/transport_currentProgess'))
		System.out.println(currentProgress);
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		System.out.println("Fatching replaced value");
		System.out.println(replace)
		double depReduction=Double.parseDouble(tpReduction);
		double result1 =depReduction -replace1;
		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 = result2 .setScale(2, RoundingMode.HALF_UP);
		String calcalteddiffGoal = result2 + " %";
		System.out.println(calcalteddiffGoal);
		WebUI.verifyMatch(forntenddiffGoal,calcalteddiffGoal, false)
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/transport_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/transport_target_year'), targetYear, true)

		String energyGoal = WebUI.getText(findTestObject('Portfolio/Goal/transport_Goal'))
		String greplace = energyGoal.replace("%" , "");
		double wGexpected=Double.parseDouble(greplace);
		System.out.println(wGexpected);
		double wGactual = depReduction/2;
		System.out.println(wGactual);
		Assert.assertEquals(wGactual,wGexpected);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/transport_textarea'),textbox )
		WebUI.click(findTestObject('Portfolio/Goal/transport_currentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/transport_baseline_value'),"value").contains(tbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/transport_percent_reduction'),"value").contains(tpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/transport_textarea'),"value").contains(textbox),"Not Valid")
		println "Test passed verified waste textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalHumanExp(String sheetName,int rowNum) throws IOException, InterruptedException {
		/*****************Method verifies overall diverted waste generation reduction goal progress bar calculation by retrieve the data from different section ************/

		String hpReduction = data.getCellData(sheetName, "HReduction", rowNum);
		String hbValue 	= data.getCellData(sheetName, "HBValue", rowNum);
		String hUnit 	= data.getCellData(sheetName, "Hunit", rowNum);
		String htextbox = data.getCellData(sheetName,"HTextBox", rowNum);

		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying human experiace unit Average Score"
		String averageScore = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/humExpUnit_Average Score'))
		System.out.println(averageScore);
		WebUI.delay(1)
		WebUI.verifyMatch(averageScore, hUnit, false)
		println "Test passed verified human experiace unit successfully"

		println "Test Started human experiance differece of goal calcation"
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/humanExp_percent_reduction'))
		println hpReduction
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/humanExp_percent_reduction'), hpReduction)
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/humanExp_baseline_value'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/humanExp_baseline_value'), hbValue)

		WebUI.click(findTestObject('Portfolio/Goal/humExpDiffGoal'))
		WebUI.delay(3)

		String currentProgress=WebUI.getText(findTestObject('Portfolio/Goal/humExpCurrentProgress'))
		double dcurrentProgress= Double.parseDouble(currentProgress);
		String front_enddDGoal = WebUI.getText(findTestObject('Portfolio/Goal/humExpDiffGoal'))
		double afront_endDiffGoal =Double.parseDouble(front_enddDGoal);
		double dhpReduction =Double.parseDouble(hpReduction);
		double calculate_diff_Goal = dhpReduction - dcurrentProgress;
		System.out.println(calculate_diff_Goal);
		Assert.assertEquals(afront_endDiffGoal,calculate_diff_Goal);
		println "Test passed verified differece goal successfully"

		println "Test started verifying acheive goal in percentage"
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/humExp_score_baseline_year'),baseYear, true)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Portfolio/Goal/humExp_score_target_year'), targetYear, true)

		String hum_Goal = WebUI.getText(findTestObject('Portfolio/Goal/HumanExpGoal'))
		double dhum_Goal=Double.parseDouble(hum_Goal);
		System.out.println(dhum_Goal);
		double chum_Goal = dhpReduction/2;
		System.out.println(chum_Goal);
		Assert.assertEquals(chum_Goal, dhum_Goal);
		println "Test passed verified acheive goal percentage successfully"

		WebUI.waitForElementClickable(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'),10)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'))
		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/humanexp_textarea'),htextbox )
		WebUI.click(findTestObject('Portfolio/Goal/transport_currentProgess'))
		WebUI.delay(2)
		WebUI.refresh()
		WebUI.delay(5)

		println "Test started verifying carbon textarea, carbon reducion , base line value after refersh"
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/humanExp_baseline_value'),"value").contains(hbValue),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/humanExp_percent_reduction'),"value").contains(hpReduction),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Goal/humanexp_textarea'),"value").contains(htextbox),"Not Valid")
		println "Test passed verified waste textarea, energy reducion , base line value after refersh successfully"
	}

	@Keyword
	public void goalCertification(String sheetName,int rowNum) throws IOException, InterruptedException {
		String cpReduction 		= data.getCellData(sheetName, "CertReduction", rowNum);
		String cUnit 	= data.getCellData(sheetName, "Certunit", rowNum);
		String ctextbox 	= data.getCellData(sheetName,"CertTextBox", rowNum);
		String baseYear = data.getCellData(sheetName, "BaseYear", rowNum)
		String targetYear = data.getCellData(sheetName,"TargetYear", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)

		println "Test started verifying certification unit "
		String certification = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/CertificationsUnit'))
		WebUI.verifyMatch(certification, cUnit, false)
		println  "Test passed verified unit successfully"

		WebUI.clearText(findTestObject('Object Repository/Portfolio/Goal/certification_percent_reduction'))
		WebUI.sendKeys(findTestObject('Object Repository/Portfolio/Goal/certification_percent_reduction'), cpReduction)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/certification_currentProgess'))
		WebUI.delay(2)
		String  forntenddiffGoal = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/CertificationDiffGoal'))
		String  currentProgress = WebUI.getText(findTestObject('Object Repository/Portfolio/Goal/certification_currentProgess'))
		String replace = currentProgress.replace("%" , "");
		double replace1=Double.parseDouble(replace);
		double dwpercentagered=Double.parseDouble(cpReduction);
		double result1 =dwpercentagered -replace1;

		//NumberFormat formatter = new result("#000.00");
		BigDecimal result2 = new BigDecimal(result1);
		result2 =  result2 .setScale(2, RoundingMode.HALF_UP);
		String calcalteddiffGoal = result2 + " %";
		System.out.println(calcalteddiffGoal);
		Assert.assertEquals(forntenddiffGoal, calcalteddiffGoal)

	}
	@Keyword
	public void totalEnergyConsumption() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))

		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))

		double dlessthan50000  =  Double.parseDouble(lessthan50000);
		double dlessthan250000 =  Double.parseDouble(lessthan250000);
		double dlessthan500000 =  Double.parseDouble(lessthan500000);
		double dlessthan1000000 = Double.parseDouble(lessthan1000000);
		double dmorethan1000000 = Double.parseDouble(morethan1000000);
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000);
		System.out.println(total_No_Proj);

		println "Test passed counted total number of project based on Size"
		String  averageEnergyKBTU= WebUI.getText(findTestObject('Portfolio/Total/AverageEnergyKBTU'))
		System.out.println(averageEnergyKBTU);
		double averageenergyKBTU =Double.parseDouble(averageEnergyKBTU);
		String avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = avgOccupanit.replace(" occupants", "");
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit);
		String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "");
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1);
		System.out.println(avg_sqarefoot2);
		String  atotalmtco2eScope1=WebUI.getText(findTestObject('Portfolio/Total/AEnergyScope1'))
		System.out.println(atotalmtco2eScope1);
		double datotalmtco2eScope1 =Double.parseDouble(atotalmtco2eScope1);
		String  atotalmtco2eScope2=WebUI.getText(findTestObject('Portfolio/Total/AEnergyScope2'))
		System.out.println(atotalmtco2eScope2);
		double datotalmtco2eScope2 =Double.parseDouble(atotalmtco2eScope2);
		System.out.println("Fatching ");
		System.out.println(datotalmtco2eScope2);

		WebUI.click(findTestObject('Portfolio/Common/a_ Energy'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/EnergyGoal'))
		String greplace = carbonGoal.replace("%" , "");
		double cGoalPercetage=Double.parseDouble(greplace);
		System.out.println(cGoalPercetage);
		double result =((averageenergyKBTU) * (cGoalPercetage * total_No_Proj))/100;
		BigDecimal cGoalPercentage = new BigDecimal(result);
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP);
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/RTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget);
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1);
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP);
		Assert.assertEquals(areductionTarget2, cGoalPercentage);
		System.out.println(areductionTarget2);
		System.out.println(cGoalPercentage);
		println "verifyed 2018 Reduction Targets"

		println "Test started verifying average occpant per project"
		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/EAvgOccScope1'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint);
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant);
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(2, RoundingMode.HALF_UP);
		double occupancyCalcuation = (datotalmtco2eScope1 / favgOccupanit_proj);
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation);
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(2, RoundingMode.HALF_UP);
		System.out.println(avgmtco2_peroccupant);
		System.out.println(expavgmtco2_peroccupant1);
		Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot = WebUI.getText(findTestObject('Portfolio/Total/EAvgSqFootScope1'))
		System.out.println(avg_squarefoot);
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot);
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1);
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot2);
		double cavg_squarefoot = (datotalmtco2eScope1 / avg_sqarefoot2);
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot);
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP);
		System.out.println(cavg_squarefoot1);
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println "verified average sqaure feet per project successully"

		//Issue Found in rounding 4 postion after decimal Rajan will fix later .
		println "Test started verifying average occpant per project"
		String totalNoOccupaint2 = WebUI.getText(findTestObject('Portfolio/Total/EAvgOccScope2'))
		double expavgmtco2_peroccupant2 = Double.parseDouble(totalNoOccupaint2);
		BigDecimal expavgmtco2_peroccupantScope2 = new BigDecimal(expavgmtco2_peroccupant2);
		expavgmtco2_peroccupantScope2 = expavgmtco2_peroccupantScope2.setScale(4, RoundingMode.HALF_UP);
		double occupancyCalcuation2 = (datotalmtco2eScope2 / favgOccupanit_proj);
		BigDecimal cavgoccupancyCalcuationScope2 = new BigDecimal(occupancyCalcuation2);
		cavgoccupancyCalcuationScope2 = cavgoccupancyCalcuationScope2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(cavgoccupancyCalcuationScope2);
		Assert.assertEquals(cavgoccupancyCalcuationScope2, expavgmtco2_peroccupantScope2);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefootScope2 = WebUI.getText(findTestObject('Portfolio/Total/EAvgSqFootScope2'))
		System.out.println(avg_squarefootScope2);
		double avg_squarefootscope2 = Double.parseDouble(avg_squarefootScope2);
		BigDecimal avg_SquarefootScope2 = new BigDecimal(avg_squarefootscope2);
		avg_SquarefootScope2 = avg_SquarefootScope2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_SquarefootScope2);
		double cavg_SquarefootScope2 = (datotalmtco2eScope2 / avg_sqarefoot2);
		BigDecimal cAvg_SquarefootScope2 = new BigDecimal(cavg_SquarefootScope2);
		cAvg_SquarefootScope2 = cAvg_SquarefootScope2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(cAvg_SquarefootScope2);
		Assert.assertEquals(avg_SquarefootScope2,cAvg_SquarefootScope2);
		println " verified average sqaure feet per project successully"

	}
	@Keyword
	public void waterConsumptionTest() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000);
		double dlessthan250000 =  Double.parseDouble(lessthan250000);
		double dlessthan500000 =  Double.parseDouble(lessthan500000);
		double dlessthan1000000 = Double.parseDouble(lessthan1000000);
		double dmorethan1000000 = Double.parseDouble(morethan1000000);
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000);
		System.out.println(total_No_Proj);
		println "Test passed counted total number of project based on area"

		String  annualWaterConsuption=WebUI.getText(findTestObject('Portfolio/Total/AnnualWaterConsuption'))
		System.out.println(annualWaterConsuption);
		double awaterconsumption =Double.parseDouble(annualWaterConsuption);
		String avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = avgOccupanit.replace(" occupants", "");
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit);
		String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "");
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1);
		System.out.println(avg_sqarefoot2);

		WebUI.click(findTestObject('Portfolio/Common/a_ Water'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal =WebUI.getText(findTestObject('Portfolio/Total/WaterGoal'))
		String greplace = carbonGoal.replace("%" , "");
		double cGoalPercetage=Double.parseDouble(greplace);
		System.out.println(cGoalPercetage);
		double result =((awaterconsumption) * (cGoalPercetage * total_No_Proj))/100;
		BigDecimal cGoalPercentage = new BigDecimal(result);
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP);
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/RTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget);
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1);
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP);
		Assert.assertEquals(areductionTarget2, cGoalPercentage);
		System.out.println(areductionTarget2);
		System.out.println(cGoalPercentage);
		println "verifyed 2018 Reduction Targets"

		println "Test started verifying average occpant per project"
		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/AverageOccpantGallons'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint);
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant);
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP);
		double occupancyCalcuation = (awaterconsumption / favgOccupanit_proj);
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation);
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avgmtco2_peroccupant);
		System.out.println(expavgmtco2_peroccupant1);
		Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot = WebUI.getText(findTestObject('Portfolio/Total/AverageSquareFootGallons'))
		System.out.println(avg_squarefoot);
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot);
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1);
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot);
		double cavg_squarefoot = (awaterconsumption / avg_sqarefoot2);
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot);
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot2);
		System.out.println(cavg_squarefoot1);
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println  "verified average sqaure feet per project successully"
	}
	@Keyword
	public void totalCarbonConsumption(String param) throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000);
		double dlessthan250000 =  Double.parseDouble(lessthan250000);
		double dlessthan500000 =  Double.parseDouble(lessthan500000);
		double dlessthan1000000 = Double.parseDouble(lessthan1000000);
		double dmorethan1000000 = Double.parseDouble(morethan1000000);
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000);
		System.out.println(total_No_Proj);

		println "Test passed counted total number of project based on area"
		String  annualWaterConsuption=WebUI.getText(findTestObject('Portfolio/Total/ACMTCO2e'))
		System.out.println(annualWaterConsuption);
		double acmtco2e =Double.parseDouble(annualWaterConsuption);
		String avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = avgOccupanit.replace(" occupants", "");
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit);
		String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "");
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1);
		System.out.println(avg_sqarefoot2);


		WebUI.click(findTestObject('Portfolio/Common/a_ Carbon'))
		WebUI.delay(5)

		println  "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/CarbonGoal'))
		String greplace = carbonGoal.replace("%" , "");
		double cGoalPercetage=Double.parseDouble(greplace);
		System.out.println(cGoalPercetage);
		double result =((acmtco2e) * (cGoalPercetage * total_No_Proj))/100;
		BigDecimal cGoalPercentage = new BigDecimal(result);
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP);
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/RTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget);
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1);
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP);
		Assert.assertEquals(areductionTarget2, cGoalPercentage);
		System.out.println(areductionTarget2);
		System.out.println(cGoalPercentage);
		println  "verifyed 2018 Reduction Targets"

		println "Test started verifying average occpant per project"
		String totalNoOccupaint =WebUI.getText(findTestObject('Portfolio/Total/AverageOccupant'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint);
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant);
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP);
		double occupancyCalcuation = (acmtco2e / favgOccupanit_proj);
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation);
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avgmtco2_peroccupant);
		System.out.println(expavgmtco2_peroccupant1);
		Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println  "Test started verifying average sqaure feet per project"
		String avg_squarefoot =WebUI.getText(findTestObject('Portfolio/Total/CAvgSqaurefoot'))
		System.out.println(avg_squarefoot);
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot);
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1);
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot);
		double cavg_squarefoot = (acmtco2e / avg_sqarefoot2);
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot);
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot2);
		System.out.println(cavg_squarefoot1);
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println " verified average sqaure feet per project successully"
	}

	@Keyword
	public void transprtTransportationMetrics() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		println "counting total number of project based on size"
		String lessthan50000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000);
		double dlessthan250000 =  Double.parseDouble(lessthan250000);
		double dlessthan500000 =  Double.parseDouble(lessthan500000);
		double dlessthan1000000 = Double.parseDouble(lessthan1000000);
		double dmorethan1000000 = Double.parseDouble(morethan1000000);
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000);
		System.out.println(total_No_Proj);

		println "Test passed counted total number of project based on the area"
		String  transportDaliyAvg=WebUI.getText(findTestObject('Portfolio/Total/TransportDaliyAvg'))
		System.out.println(transportDaliyAvg);
		double transportdaliyAvg =Double.parseDouble(transportDaliyAvg);
		String   avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = avgOccupanit.replace(" occupants", "");
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit);
		String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "");
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1);
		System.out.println(avg_sqarefoot2);

		WebUI.click(findTestObject('Portfolio/Common/a_ Transportation'))
		WebUI.delay(5)

		println "Test started verifying average occpant per project"
		String transprotAvgEmissionOccpint =WebUI.getText(findTestObject('Portfolio/Total/TransprotAvgEmissionOccpint'))
		double transprotavgEmissionOccpint = Double.parseDouble(transprotAvgEmissionOccpint);
		BigDecimal transprotavgemissionoccpint = new BigDecimal(transprotavgEmissionOccpint);
		transprotavgemissionoccpint = transprotavgemissionoccpint.setScale(4, RoundingMode.HALF_UP);
		double occupancyCalcuation = (transportdaliyAvg / favgOccupanit_proj);
		BigDecimal avgtransport_peroccupant = new BigDecimal(occupancyCalcuation);
		avgtransport_peroccupant = avgtransport_peroccupant.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avgtransport_peroccupant);
		Assert.assertEquals(transprotavgemissionoccpint, avgtransport_peroccupant);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot = WebUI.getText(findTestObject('Portfolio/Total/TransportAvgDistOccupaint'))
		System.out.println(avg_squarefoot);
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot);
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1);
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot);
		double cavg_squarefoot = (transportdaliyAvg / avg_sqarefoot2);
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot);
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP);
		System.out.println(avg_squarefoot2);
		System.out.println(cavg_squarefoot1);
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println " verified average sqaure feet per project successully"
	}

	@Keyword
	public void wasteDiversionTest() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)
		println "counting total number of project based on size"
		String lessthan50000  =   WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)

		println "Test passed counted total number of project based on Size"
		String  avgWasteGen=  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteDiv'))
		System.out.println(avgWasteGen)
		double avgwasteGen =Double.parseDouble(avgWasteGen)
		String   avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = avgOccupanit.replace(" occupants", "")
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)
		String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "")
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2);

		WebUI.click(findTestObject('Portfolio/Common/a_ Waste'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/WasteGoal'))
		String greplace = carbonGoal.replace("%" , "");
		double cGoalPercetage=Double.parseDouble(greplace)
		double result =((avgwasteGen) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/WasteDRTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)
		Assert.assertEquals(areductionTarget2, cGoalPercentage)
		println "verifyed 2018 Reduction Targets"


		//Issue Found in rounding 4 postion after decimal can be fix later .
		println "Test started verifying average occpant per project"
		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGenPerOccupaint'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint)
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant)
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP)
		double occupancyCalcuation = (avgwasteGen / favgOccupanit_proj)
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation)
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avgmtco2_peroccupant);
		System.out.println(expavgmtco2_peroccupant1);
		Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot =  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGenPerSqFoot'))
		System.out.println(avg_squarefoot)
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot)
		double cavg_squarefoot = (avgwasteGen / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println "verified average sqaure feet per project successully"


	}



	@Keyword
	public void humExpTransportationMetrics()throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Portfolio/Goal/a_ Goals'))
		WebUI.delay(2)
		println "Test started verifying acheive goal in percentage"
		String hum_Goal =WebUI.getText(findTestObject('Portfolio/Goal/HumanExpGoal'))
		String ghum_avgScore = WebUI.getText(findTestObject('Portfolio/Total/humExpAvgScore'))
		String gavgScore =WebUI.getText(findTestObject('Portfolio/Total/GHumExp'))

		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)

		String havgSatisfaction = WebUI.getText(findTestObject('Portfolio/Total/AvgOccupaintSatisfaction'))
		Double havgsatisfaction = Double.parseDouble(havgSatisfaction);
		BigDecimal thAvgsatisfaction = new BigDecimal(havgsatisfaction);
		thAvgsatisfaction = thAvgsatisfaction.setScale(4, RoundingMode.HALF_UP)

		WebUI.click(findTestObject('Portfolio/Common/a_ Human Experience'))
		WebUI.delay(5)
		String ahum_Goal = WebUI.getText(findTestObject('Portfolio/Total/AGoalHumExp'))
		String ahum_avgScore = WebUI.getText(findTestObject('Portfolio/Total/humExpAvgScore'))
		String ahumAvgstisfaction = WebUI.getText(findTestObject('Portfolio/Total/AhumExpAvgSatisfaction'))
		Double aavgsatisfaction = Double.parseDouble(ahumAvgstisfaction);
		BigDecimal ahAvgsatisfaction = new BigDecimal(aavgsatisfaction);
		ahAvgsatisfaction = ahAvgsatisfaction.setScale(4, RoundingMode.HALF_UP)
		println "Test Started Verifying hum exp avg score"
		String havgScore =WebUI.getText(findTestObject('Portfolio/Total/AvgHumanExp'))
		Assert.assertEquals(havgScore, gavgScore)

		Assert.assertEquals(hum_Goal, ahum_Goal)
		println "Test passed verified acheive goal percentage successfully"
		Assert.assertEquals(ghum_avgScore, ahum_avgScore);
		println "Test passed verified hum exp avg socre sucore successully"
		Assert.assertEquals(ahAvgsatisfaction, thAvgsatisfaction)
		println " Test Passed verified hum exp average satisfaction"
	}

	@Keyword
	public void wasteGenerationTest() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Common/a_ Analytics'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Portfolio/Common/a_ Total'))
		WebUI.delay(5)
		println "counting total number of project based on size"
		String lessthan50000  =   WebUI.getText(findTestObject('Portfolio/Total/Lessthan50000'))
		String lessthan250000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan250000'))
		String lessthan500000  =  WebUI.getText(findTestObject('Portfolio/Total/Lessthan500000'))
		String lessthan1000000  = WebUI.getText(findTestObject('Portfolio/Total/Lessthan1000000'))
		String morethan1000000 =  WebUI.getText(findTestObject('Portfolio/Total/Morethan1000000'))
		double dlessthan50000  =  Double.parseDouble(lessthan50000)
		double dlessthan250000 =  Double.parseDouble(lessthan250000)
		double dlessthan500000 =  Double.parseDouble(lessthan500000)
		double dlessthan1000000 = Double.parseDouble(lessthan1000000)
		double dmorethan1000000 = Double.parseDouble(morethan1000000)
		Double total_No_Proj = (dlessthan50000 + dlessthan250000 + dlessthan500000 + dlessthan1000000 + dmorethan1000000)
		System.out.println(total_No_Proj)

		println "Test passed counted total number of project based on Size"
		String  avgWasteGen=  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGen'))
		System.out.println(avgWasteGen)
		double avgwasteGen =Double.parseDouble(avgWasteGen)
		String   avgOccupanit = WebUI.getText(findTestObject('Portfolio/Total/AOccupanit'))
		String repavgOccupanit  = avgOccupanit.replace(" occupants", "")
		double favgOccupanit_proj =Double.parseDouble(repavgOccupanit)
		String avg_sqarefoot =WebUI.getText(findTestObject('Portfolio/Total/AvgSqaurefoot'))
		String avg_sqarefoot1  = avg_sqarefoot.replace(" sf", "")
		double avg_sqarefoot2 =Double.parseDouble(avg_sqarefoot1)
		System.out.println(avg_sqarefoot2);

		WebUI.click(findTestObject('Portfolio/Common/a_ Waste'))
		WebUI.delay(5)

		println "Test started verifying 2018 Reduction Targets"
		String carbonGoal = WebUI.getText(findTestObject('Portfolio/Total/WasteGoal'))
		String greplace = carbonGoal.replace("%" , "");
		double cGoalPercetage=Double.parseDouble(greplace)
		double result =((avgwasteGen) * (cGoalPercetage * total_No_Proj))/100
		BigDecimal cGoalPercentage = new BigDecimal(result)
		cGoalPercentage =  cGoalPercentage .setScale(2, RoundingMode.HALF_UP)
		String areductionTarget = WebUI.getText(findTestObject('Portfolio/Total/WasteGRTarget'))
		double areductionTarget1 = Double.parseDouble(areductionTarget)
		BigDecimal areductionTarget2 = new BigDecimal(areductionTarget1)
		areductionTarget2 =  areductionTarget2 .setScale(2, RoundingMode.HALF_UP)
		Assert.assertEquals(areductionTarget2, cGoalPercentage)
		println "verifyed 2018 Reduction Targets"


		//Issue Found in rounding 4 postion after decimal can be fix later .
		println "Test started verifying average occpant per project"
		String totalNoOccupaint = WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGenPerOccupaint'))
		double expavgmtco2_peroccupant = Double.parseDouble(totalNoOccupaint)
		BigDecimal expavgmtco2_peroccupant1 = new BigDecimal(expavgmtco2_peroccupant)
		expavgmtco2_peroccupant1 = expavgmtco2_peroccupant1.setScale(4, RoundingMode.HALF_UP)
		double occupancyCalcuation = (avgwasteGen / favgOccupanit_proj)
		BigDecimal avgmtco2_peroccupant = new BigDecimal(occupancyCalcuation)
		avgmtco2_peroccupant = avgmtco2_peroccupant.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avgmtco2_peroccupant);
		System.out.println(expavgmtco2_peroccupant1);
		Assert.assertEquals(avgmtco2_peroccupant, expavgmtco2_peroccupant1);
		println "verified average occpant per project successully"

		println "Test started verifying average sqaure feet per project"
		String avg_squarefoot =  WebUI.getText(findTestObject('Portfolio/Total/AvgWasteGenPerSqFoot'))
		System.out.println(avg_squarefoot)
		double avg_squarefoot1 = Double.parseDouble(avg_squarefoot)
		BigDecimal avg_squarefoot2 = new BigDecimal(avg_squarefoot1)
		avg_squarefoot2 = avg_squarefoot2.setScale(4, RoundingMode.HALF_UP)
		System.out.println(avg_squarefoot)
		double cavg_squarefoot = (avgwasteGen / avg_sqarefoot2)
		BigDecimal cavg_squarefoot1 = new BigDecimal(cavg_squarefoot)
		cavg_squarefoot1 = cavg_squarefoot1.setScale(4, RoundingMode.HALF_UP)
		Assert.assertEquals(avg_squarefoot2, cavg_squarefoot1);
		println "verified average sqaure feet per project successully"

	}
	@Keyword
	public void editPortfolioDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
		String projectName   = data.getCellData(sheetName, "ProjectName", 2);
		String organization  = data.getCellData(sheetName, "Organization", 3);
		String orgCountry 	 = data.getCellData(sheetName, "orgCountry", 3);
		String orgContact    = data.getCellData(sheetName, "orgContact", 3);
		String location      = data.getCellData(sheetName, "location", 3);
		String email         = data.getCellData(sheetName, "email", 3);
		String prjDesc       = data.getCellData(sheetName, "portfolioDesc", 3);
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		WebUI.click(findTestObject('Portfolio/Total/a_ Portfolio'))

		WebUI.click(findTestObject('Portfolio/Total/span_Edit'))
		WebUI.delay(1)
		WebUI.clearText(findTestObject('Portfolio/Total/portfolio_name'))

		WebUI.sendKeys(findTestObject('Portfolio/Total/portfolio_name'), projectName);
		WebUI.clearText(findTestObject('Portfolio/Total/textarea_organization'))

		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_organization'), organization)
		WebUI.click(findTestObject('Portfolio/Total/textarea_organization'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Portfolio/Total/OrgV Architecture'))
		WebUI.delay(1)
		println "Entering the Portfolio Organization Name"

		WebUI.selectOptionByLabel(findTestObject('Portfolio/Total/org_country'), orgCountry, false)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Mob'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Mob'), orgContact)


		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Location'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Location'), location)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Email'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Email'), email)

		WebUI.clearText(findTestObject('Portfolio/Total/textarea_Description'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/textarea_Description'), prjDesc)

		WebUI.click(findTestObject('Portfolio/Total/span_Save'))
		WebUI.delay(2)

		WebUI.refresh()
		WebUI.waitForPageLoad(10)

		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/portfolio_name'),"value").contains(projectName),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_organization'),"value").contains(organization),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/org_country'),"value").contains("TR"),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_Mob'),"value").contains(orgContact),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_Location'),"value").contains(location),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('Portfolio/Total/textarea_Description'),"value").contains(prjDesc),"Not Valid")
		println  "Edit Project  Verified Successfully"
	}
	@Keyword
	public void AddTeamMember(String sheetName, int rowNum) throws IOException, InterruptedException {
		String teamMember   = data.getCellData(sheetName, "teamMember", rowNum)
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('Portfolio/Total/a_ Team'))
		WebUI.sendKeys(findTestObject('Portfolio/Total/input_AddCollabrator'), teamMember)
		WebUI.click(findTestObject('Portfolio/Total/button_Add'))
		WebUI.delay(7)
		String teammember = WebUI.getText(findTestObject('Portfolio/Total/VerifyTeamMail'))
		println teammember
		WebUI.verifyMatch(teammember, teamMember, false)
		println  "Add New Team Member Verified Successfully"
	}

	public void editTeamMember() throws IOException, InterruptedException {
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Portfolio/Total/a_ Manage'))
		WebUI.delay(1)
		WebUI.doubleClick(findTestObject('Portfolio/Total/a_ Team'))
		WebUI.delay(4)

		WebUI.click(findTestObject('Portfolio/Total/EditRole'))
		WebUI.click(findTestObject('Portfolio/Total/EditAuthRight'))
		WebUI.click(findTestObject('Portfolio/Total/SelectRole'))
		WebUI.click(findTestObject('Portfolio/Total/SaveRole'))
		WebUI.delay(5)

		String role = WebUI.getText(findTestObject('Portfolio/Total/GetRole'))
		WebUI.verifyMatch(role, "Can Edit", false)
		println "Team Member Authourization is updated"
		println "Edit Team Member Authourization Verified Successfully"
	}
}


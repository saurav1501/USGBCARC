package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ReusableMethodsPrerequisites extends BaseClass {

	@Keyword
	public void narrativeTextSave(String sheetName, int rowNum)throws IOException, InterruptedException {
		String preReqTexBox  = data.getCellData(sheetName, "PreReqTexBox", rowNum);
		WebUI.doubleClick(findTestObject('Page_Arc dashboard/a_ Precertification'))
		WebUI.delay(3)
		WebUI.doubleClick(findTestObject('Page_Arc dashboard/span_Project boundary'))
		WebUI.delay(3)


		for (int i = 0; i <= 3; i++) {
			if(i==0) {
				println "Verifying narrative Text Save functionality for Measure Project Boundary"
				WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureProjectBoundary'),preReqTexBox)
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.waitForPageLoad(10)
				Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureProjectBoundary')).contains(preReqTexBox),"Not Valid")
			}
			if(i==1) {
				println "Verifying narrative Text Save functionality for Measure Governance"
				for(int count=1; count<=3;count++){
					WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureGovernance'+count),preReqTexBox)
				}
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.waitForPageLoad(10)
				for(int count=1; count<=3;count++){
					Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureGovernance'+count)).contains(preReqTexBox),"Not Valid")
				}
			}

			if(i==2) {
				println "Verifying narrative Text Save functionality for Measure Stakeholders"
				for(int count=1; count<=2;count++){
					WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureStake'+count),preReqTexBox)
				}
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.waitForPageLoad(10)
				for(int count=1; count<=2;count++){
					Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureStake'+count)).contains(preReqTexBox),"Not Valid")
				}
			}

			if(i==3) {
				println "Verifying narrative Text Save functionality for Measure Meeting"
				WebUI.sendKeys(findTestObject('Page_Arc dashboard/textarea_measureMeeting'),preReqTexBox)
				WebUI.click(findTestObject('Page_Arc dashboard/ClickSaveTeam'))
				WebUI.delay(5)
				WebUI.refresh()
				WebUI.waitForPageLoad(10)
				Assert.assertTrue(WebUI.getText(findTestObject('Page_Arc dashboard/textarea_measureMeeting')).contains(preReqTexBox),"Not Valid")
			}

			if(i==4) {
				WebUI.sendKeys("RoadmapTextBox", preReqTexBox);
				WebUI.click("ClickSaveTeam");
				WebUI.delay(2)
				WebUI.click( "NextButtonprerequisites");
				WebUI.delay(2)
			}
			WebUI.click(findTestObject('Page_Arc dashboard/button_Next'))
			WebUI.delay(3)
		}
	}
	
	@Keyword
	public void preRequisiteAttemptCity(){
		WebUI.doubleClick(findTestObject('Page_Arc dashboard/a_ Precertification'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/CityCom/span_Commit to sharing data'))

		WebUI.delay(3)
		for(int i=1;i<=6;i++)
        {
		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.delay(3)
		WebUI.doubleClick(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

	}

	}

}

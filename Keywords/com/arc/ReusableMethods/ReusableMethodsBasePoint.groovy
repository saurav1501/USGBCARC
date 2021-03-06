package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert
import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
public class ReusableMethodsBasePoint extends BaseClass{

	
	@Keyword
	public void preRequisiteAttemptTransit(){
		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.click(findTestObject('PreRequisite/a_ Prerequisites'))
		//WebUI.setViewPortSize(1500,800)
		WebUI.delay(3)
		WebUI.click(findTestObject('PreRequisite/span_Site Management Policy'))

		WebUI.delay(5)
		println 1

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CheckBox2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))


		println 2

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 3

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 4

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))


		println 5

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/span_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 6

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CheckBox2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 7

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PreRequisite/CheckBox2'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))


		println 8

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 9

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/button_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		println 10

		WebUI.click(findTestObject('PreRequisite/CheckBox1'))
		WebUI.delay(2)
		WebUI.click(findTestObject('PreRequisite/span_Attempted'))
		WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
		WebUI.click(findTestObject('PreRequisite/button_Next'))

		Assert.assertEquals(WebUI.getText(findTestObject('PreRequisite/span_Site Management Policy')),'Site Management Policy')
	}

	@Keyword
	public void basePointAttemptTransit(){

		//WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.click(findTestObject('Object Repository/BasePoint/a_ Base Points'))
		//WebUI.setViewPortSize(1500,800)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/BasePoint/span_Site Development - Protec'))

		for (int c in 0..22){

			WebUI.delay(3)
			WebUI.click(findTestObject('PreRequisite/CheckBox1'))
			WebUI.delay(2)
			WebUI.click(findTestObject('PreRequisite/button_Attempted'))
			WebUI.click(findTestObject('PreRequisite/a_Ready for Review'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/BasePoint/button_Ok'))
			WebUI.delay(2)
			WebUI.scrollToElement(findTestObject('PreRequisite/button_Next'), 2)
			WebUI.click(findTestObject('PreRequisite/button_Next'))
		}

		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/BasePoint/span_Site Development - Protec')),'Site Development - Protect or Restore Habitat')
	}
	
	
	@Keyword
	public void basePointOptionA(String cdataInputSheet,int rowNum) throws IOException, InterruptedException{
		WebUI.waitForElementClickable(findTestObject('BasePoint/CityCom/a_ Base Points'), 10)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(5)
		WebUI.check(findTestObject('BasePoint/CityCom/Checkbox1'))
		WebUI.delay(3)
		for(int count=2;count<=11;count++) {
			myTestObject.addProperty("xpath", ConditionType.EQUALS,"(//input[@type='checkbox'])"+[count])
			WebUI.click(myTestObject)
		}
		WebUI.delay(5)
		String point = WebUI.getText(findTestObject('BasePoint/CityCom/OptionPointA'))
		WebUI.verifyMatch(point, "10", true)
	}

	@Keyword
	public void basePointOptionB(String sheetName, int rowNum) throws IOException, InterruptedException{
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "ADeatailsValueReading1", rowNum);
		String reading2  = data.getCellData(sheetName, "ADeatailsValueReading2", rowNum);
		String reading3  = data.getCellData(sheetName, "ADeatailsValueReading3", rowNum);
		String reading4  = data.getCellData(sheetName, "ADeatailsValueReading4", rowNum);
		String ureading1  = data.getCellData(sheetName, "ADeatailsUnitReading1", rowNum);
		String ureading2  = data.getCellData(sheetName, "ADeatailsUnitReading2", rowNum);
		String ureading3  = data.getCellData(sheetName, "ADeatailsUnitReading3", rowNum);
		String ureading4  = data.getCellData(sheetName, "ADeatailsUnitReading4", rowNum);

		WebUI.waitForElementClickable(findTestObject('BasePoint/CityCom/a_ Base Points'), 10)
		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(5)

		myTestObject.addProperty("xpath", ConditionType.EQUALS,"(//input[@type='checkbox'])[12]")
		WebUI.click(myTestObject)
		WebUI.check(findTestObject('BasePoint/CityCom/ClickOptionB'))
		WebUI.waitForPageLoad(15)

		for(int count =1 ;count<=4;count++ ) {
			WebUI.click(findTestObject('BasePoint/CityCom/ClickDropdown'))
			WebUI.delay(1)
			WebUI.click(findTestObject('BasePoint/Option'+count))
			WebUI.delay(1)
			WebUI.click(findTestObject('BasePoint/CityCom/AddButton'))
			WebUI.delay(1)
		}

		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue1'), reading1)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit1'), ureading1)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue2'), reading2)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit2'), ureading2)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue3'), reading3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit3'), ureading3)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Avalue4'), reading4)
		WebUI.sendKeys(findTestObject('BasePoint/CityCom/Aunit4'), ureading4)

		for(int count=1;count<=4;count++) {
			WebUI.click(findTestObject('BasePoint/BasePointCheckbox'+count))
			WebUI.delay(1)
			WebUI.click(findTestObject('DataInput/SaveButton'+count))
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(5)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue1'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue2'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue3'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue4'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit1'),"value").contains(ureading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit2'),"value").contains(ureading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit3'),"value").contains(ureading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit4'),"value").contains(ureading1),"Not Valid")

		WebUI.doubleClick(findTestObject('BasePoint/CityCom/a_ Base Points'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Page_Arc dashboard/sideBar'))
		String point = WebUI.getText(findTestObject('BasePoint/CityCom/OptionPointB'))
		WebUI.verifyMatch(point, "2", true)
	}
}

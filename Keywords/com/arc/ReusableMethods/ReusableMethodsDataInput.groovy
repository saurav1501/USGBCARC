package com.arc.ReusableMethods
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.arc.BaseClass.BaseClass
import org.testng.Assert
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.awt.Robot
import java.awt.event.KeyEvent

public class ReusableMethodsDataInput  extends BaseClass{
	@Keyword
	public void uploadArcDataTempte(){
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/span_Upload .XLS'),10)
		WebUI.doubleClick(findTestObject('DataInput/CityCom/span_Upload .XLS'))
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),10)
		WebUI.uploadFile(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),BaseClass.UploadArcDataTemplete )
		WebUI.doubleClick(findTestObject('DataInput/CityCom/ClickToUploadFileButton'))
		String successmessage= WebUI.getText(findTestObject('DataInput/p_Excel submitted successfully'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when you data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}

	@Keyword
	public void uploadCreditFormTest(){
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/span_Upload .XLS'),10)
		WebUI.doubleClick(findTestObject('DataInput/CityCom/span_Upload .XLS'))
		WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),10)
		WebUI.uploadFile(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),BaseClass.UploadArcDataTemplete )
		WebUI.click(findTestObject('DataInput/CityCom/ClickToUploadFileButton'))
		String successmessage= WebUI.getText(findTestObject('DataInput/p_Excel submitted successfully'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when you data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}

	public boolean isFileDownloaded(String fileName) {
		boolean flag = false
		File dir = new File(downloadPath)
		File[] dir_contents = dir.listFiles()
		println('Total Files Available in the folder are : ' + dir_contents.length)
		for (int i = 0; i < dir_contents.length; i++) {
			println('File Name at 0 is : ' + dir_contents[i].getName())
			if (dir_contents[i].getName().equals(fileName)) {
				return flag = true
			}
		}
		return flag
	}
	@Keyword
	public static void clickCancel(){
		WebUI.delay(1)
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CANCEL)
	}


	@Keyword
	public void createEnergyMeterReading(String sheetName, int rowNum) throws IOException, InterruptedException{

		String reading1  = data.getCellData(sheetName, "EReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "EReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "EReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "EReading4", rowNum)
		String reading5  = data.getCellData(sheetName, "EReading5", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Energy'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/button_Add Year'))
		WebUI.delay(3)

		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))

		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)

		for(int count = 1; count<=5; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.waitForPageLoad(10)

		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value").contains(reading5),"Not Valid")
	}
	@Keyword
	public void createWaterMeterReading(String sheetName, int rowNum ) throws IOException, InterruptedException {
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "WaterReading1", rowNum);
		String reading2  = data.getCellData(sheetName, "WaterReading2", rowNum);
		String reading3  = data.getCellData(sheetName, "WaterReading3", rowNum);
		String reading4  = data.getCellData(sheetName, "WaterReading4", rowNum);
		String reading5  = data.getCellData(sheetName, "WaterReading5", rowNum);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)


		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Water'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/button_Add Year'))
		WebUI.delay(3)

		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(1)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))


		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)


		for(int count = 1; count<=5; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.waitForPageLoad(10)

		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value").contains(reading5),"Not Valid")
	}

	@Keyword
	public void createWasteGenerationMeterReading(String sheetName,int rowNum) throws IOException, InterruptedException {

		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "wastegeneration1", rowNum);
		String reading2  = data.getCellData(sheetName, "wastegeneration2", rowNum);
		String reading3  = data.getCellData(sheetName, "wastegeneration3", rowNum);
		String reading4  = data.getCellData(sheetName, "wastegeneration4", rowNum);
		String reading5  = data.getCellData(sheetName, "wastegeneration5", rowNum);


		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Waste'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/GwAddYear'))
		WebUI.delay(3)

		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))

		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)

		for(int count = 1; count<=5; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.waitForPageLoad(10)

		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value").contains(reading5),"Not Valid")
	}

	@Keyword
	public void createWasteDiversionMeterReading(String sheetName, int rowNum) throws IOException, InterruptedException{
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "wastediversion1", rowNum)
		String reading2  = data.getCellData(sheetName, "wastediversion2", rowNum)
		String reading3  = data.getCellData(sheetName, "wastediversion3", rowNum)
		String reading4  = data.getCellData(sheetName, "wastediversion4", rowNum)
		String reading5  = data.getCellData(sheetName, "wastediversion5", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Waste'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/DwAddYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
		WebUI.click(findTestObject('DataInput/CityCom/DPreviousYear'))
		WebUI.click(findTestObject('DataInput/CityCom/DNextButton'))

		WebUI.setText(findTestObject('DataInput/CityCom/dWTextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/dWTextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/dWTextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/dWTextboxValue4'), reading4)

		for(int count = 6; count<=9; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}
		WebUI.delay(5)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue1'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue2'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue3'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/dWTextboxValue4'),"value").contains(reading4),"Not Valid")
	}
	@Keyword
	public void createTransportReading(String sheetName, int rowNum) throws IOException, InterruptedException{
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "TReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "TReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "TReading3", rowNum)
		String reading4  = data.getCellData(sheetName, "TReading4", rowNum)
		String reading5  = data.getCellData(sheetName, "TReading5", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Transportation'))
		WebUI.delay(3)

		WebUI.click(findTestObject('DataInput/CityCom/button_Add Year'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/button_Next Year'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.click(findTestObject('DataInput/CityCom/button_Previous Year'))
		WebUI.delay(1)

		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue3'), reading3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue4'), reading4)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue5'), reading5)

		for(int count = 1; count<=5; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}
		WebUI.delay(5)
		WebUI.refresh()
		WebUI.waitForPageLoad(15)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue3'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue4'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue5'),"value").contains(reading5),"Not Valid")
	}
	@Keyword
	public void createHumanExpMeterReading(String sheetName, int rowNum)throws IOException, InterruptedException {
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "EPReading1", rowNum)
		String reading2  = data.getCellData(sheetName, "EPReading2", rowNum)
		String reading3  = data.getCellData(sheetName, "HGiniReading1", rowNum)
		String reading4  = data.getCellData(sheetName, "HGiniReading2", rowNum)
		String reading5  = data.getCellData(sheetName, "Hincome1", rowNum)
		String reading6  = data.getCellData(sheetName, "Hincome2", rowNum)

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Human Experience'))
		WebUI.delay(5)
		WebUI.click(findTestObject('DataInput/CityCom/EducationAddYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/EducationAddPrevYear'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue1'), reading1)
		WebUI.setText(findTestObject('DataInput/CityCom/TextboxValue2'), reading2)
		WebUI.click(findTestObject('DataInput/CityCom/BachelorAddYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/BachelorAddPrevYear'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue3'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue4'), reading2)
		WebUI.click(findTestObject('DataInput/CityCom/EquAddYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/EquAddPrevYear'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue5'), reading1)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue6'), reading2)
		WebUI.click(findTestObject('DataInput/CityCom/GiniAddYear'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CityCom/GiniAddPrevYear'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue7'), reading3)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue8'), reading4)
		WebUI.doubleClick(findTestObject('DataInput/CityCom/ProsperityAddYear'))
		WebUI.delay(2)
		WebUI.click(findTestObject('DataInput/CityCom/ProsperityAddPrevYear'))
		WebUI.delay(2)
		WebUI.sendKeys(findTestObject('DataInput/CityCom/HTextboxValue9'), reading5)

		for(int count = 1; count<=9; count++){
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}

		WebUI.delay(10)
		WebUI.refresh()
		WebUI.waitForPageLoad(20)
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue1'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/TextboxValue2'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue3'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue4'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue5'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue6'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue7'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue8'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('DataInput/CityCom/HTextboxValue9'),"value").contains(reading5),"Not Valid")
	}

	@Keyword
	public void createADMeterReading(String sheetName, int rowNum) throws IOException, InterruptedException {
		/*************************Reading data from excel sheet ************************************/
		String reading1  = data.getCellData(sheetName, "ADeatailsValueReading1", rowNum);
		String reading2  = data.getCellData(sheetName, "ADeatailsValueReading2", rowNum);
		String reading3  = data.getCellData(sheetName, "ADeatailsValueReading3", rowNum);
		String reading4  = data.getCellData(sheetName, "ADeatailsValueReading4", rowNum);
		String ureading1  = data.getCellData(sheetName, "ADeatailsUnitReading1", rowNum);
		String ureading2  = data.getCellData(sheetName, "ADeatailsUnitReading2", rowNum);
		String ureading3  = data.getCellData(sheetName, "ADeatailsUnitReading3", rowNum);
		String ureading4  = data.getCellData(sheetName, "ADeatailsUnitReading4", rowNum);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)

		WebUI.click(findTestObject('DataInput/CityCom/a_ Data Input'))
		WebUI.click(findTestObject('DataInput/CityCom/span_Additional Data'))
		WebUI.delay(4)

		for(int count =1 ;count<=4;count++ ) {
			WebUI.click(findTestObject('BasePoint/CityCom/ClickDropdown'))
			WebUI.delay(1)
			WebUI.click(findTestObject('BasePoint/CityCom/Option'+count))
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
			WebUI.click(findTestObject('DataInput/CityCom/SaveButton'+count))
		}

		WebUI.delay(5)
		WebUI.refresh()
		WebUI.waitForPageLoad(10)

		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue1'),"value").contains(reading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue2'),"value").contains(reading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue3'),"value").contains(reading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Avalue4'),"value").contains(reading1),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit1'),"value").contains(ureading4),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit2'),"value").contains(ureading3),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit3'),"value").contains(ureading2),"Not Valid")
		Assert.assertTrue(WebUI.getAttribute(findTestObject('BasePoint/CityCom/Aunit4'),"value").contains(ureading1),"Not Valid")
	}
}

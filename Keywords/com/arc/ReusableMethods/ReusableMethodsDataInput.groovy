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
		/*WebUI.waitForElementClickable(findTestObject('DataInput/CityCom/span_Upload .XLS'),10)
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
		 WebUI.delay(5)*/
		WebUI.delay(11)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/span_Upload.XLS'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('Object Repository/DataInput/ClickOnUploadToSelectFile'),3)
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/UploadArcDataTemplete'),BaseClass.UploadArcDataTemplete )
		WebUI.delay(3)
		clickCancel()
		WebUI.doubleClick(findTestObject('DataInput/ClickToUploadFileButton'))
		String successmessage= WebUI.getText(findTestObject('Object Repository/DataInput/ExcelUploadSuccessMessage'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when your data is processed.' , true)
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
		WebUI.sendKeys(findTestObject('DataInput/CityCom/UploadArcDataTemplete'),BaseClass.UploadArcDataTemplete )
		WebUI.click(findTestObject('DataInput/CityCom/ClickToUploadFileButton'))
		String successmessage= WebUI.getText(findTestObject('DataInput/p_Excel submitted successfully'))
		WebUI.delay(5)
		WebUI.verifyMatch(successmessage,'Excel submitted successfully. We will send you an email when you data is processed.' , true)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/button_CLOSE'))
		WebUI.refresh()
		WebUI.delay(5)
	}

	@Keyword
	public void fileUploadDataInput(){
		WebUI.delay(10)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/DataInputFileUpload/buttonUPLOAD'))
		WebUI.click(findTestObject('Object Repository/DataInput/DataInputFileUpload/clickComputerFile'))
		WebUI.sendKeys(findTestObject('DataInput/DataInputFileUpload/sendFileToUpload'),UploadDocumentDataInput)
		String fileName= WebUI.getText(findTestObject('Object Repository/DataInput/DataInputFileUpload/a_USGBC.pdf'))
		clickCancel()
		WebUI.delay(3)
		Assert.assertEquals(fileName,"USGBC.pdf")
	}


	public boolean isFileDownloaded(String fileName) {
		boolean flag = false
		File dir = new File(downloadPath)
		File[] dir_contents = dir.listFiles()
		println('Total Files Available in the folder are : ' + dir_contents.length)
		for (int i = 0; i < dir_contents.length; i++) {
			println('File Name at'+ i +' is : ' + dir_contents[i].getName())
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

	//Building data input


	@Keyword
	public void createEnergyMeter(String sheetName, int rowNum){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum);
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum);
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum);
		String meterName=  data.getCellData(sheetName, "Meter Name", rowNum);


		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), meterName)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))

		//reading one

		WebUI.delay(8)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),meterName, FailureHandling.STOP_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading two

		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading 3

		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.delay(3)
		WebUI.refresh()
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)
	}

	@Keyword
	public void createWaterMeter(String sheetName, int rowNum){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum);
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum);
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum);
		String meterName=  data.getCellData(sheetName, "Meter Name", rowNum);


		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_Add New Meter'))
		WebUI.delay(3)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_Next'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('DataInput/CreateMeterBuilding/input_addMeterModal-body-Eleme'), meterName)
		println meterName
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ELECTRICITY'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/a_WATER'))
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_ADD'))

		//reading one

		WebUI.delay(8)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),meterName, FailureHandling.STOP_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading two

		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading 3

		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.delay(3)
		WebUI.refresh()
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)
	}




	@Keyword
	public void createWasteMeter(){

		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGenerated'), '1000')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDiverted'), '800')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/source') ,'office')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		/// Reading two

		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGenerated'), '500')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDiverted'), '200')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/source') ,'office')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading 3

		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGenerated'), '600')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDiverted'), '300')
		WebUI.sendKeys(findTestObject('Object Repository/DataInput/CreateMeterBuilding/source') ,'office')
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.delay(10)

		WebUI.refresh()

		WebUI.delay(4)
		//verifying the data inputted is persisting or not

		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingOne'),'value'),'600')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingTwo'),'value'),'500')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteGeneratedReadingThree'),'value'),'1000')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingOne'),'value'),'300')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingTwo'),'value'),'200')
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/wasteDivertedReadingThree'),'value'),'800')

	}



	@Keyword
	public void humanExperienceMeter(String sheetName, int rowNum ){

		String reading1  = data.getCellData(sheetName, "Reading1", rowNum);
		String reading2  = data.getCellData(sheetName, "Reading2", rowNum);
		String reading3  = data.getCellData(sheetName, "Reading3", rowNum);
		String reading4  = data.getCellData(sheetName, "Reading4", rowNum);
		String reading5  = data.getCellData(sheetName, "Reading5", rowNum);
		String reading6  = data.getCellData(sheetName, "Reading6", rowNum);

		WebUI.delay(10)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'), 2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'))
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Carbon Dioxide', FailureHandling.STOP_ON_FAILURE)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading1)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading two

		WebUI.delay(9)

		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading 3

		WebUI.delay(9)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading3)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))
		WebUI.delay(5)

		WebUI.refresh()
		WebUI.delay(6)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'), 2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_CO2 Meter'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading1)


		//Add the VOC Reading

		WebUI.delay(5)

		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'))
		WebUI.delay(4)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Total Volatile Organic Compounds', FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading4)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading two

		WebUI.delay(9)

		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading5)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading 3

		WebUI.delay(9)
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), reading6)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		WebUI.delay(5)
		WebUI.refresh()
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/click_VOC Meter'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),reading6)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),reading5)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),reading4)
	}



	@Keyword
	public void verifyAndDownloadExportData(){

		WebUI.delay(10)
		WebUI.click(findTestObject('DataInput/CreateMeterBuilding/button_tippy_init dropdown-tog'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/a_Create Report'))
		WebUI.delay(3)

		//Input Start Date

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/reportStartDate'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))

		//Input End date

		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/reportEndDate'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/DOWNLOAD_DataInputReport'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/cancelButton'))

		//'Verifying the file is download in the User defined Path'
		Assert.assertTrue(isFileDownloaded('Export Data.xlsx'), 'Failed to download Expected document')
	}




	//Transit ridership
	@Keyword
	public void humanExperienceMeterTransitRidership(String sheetName, int rowNum ){

		String Ridership1  = data.getCellData(sheetName, "Ridership1", rowNum)
		String Ridership2  = data.getCellData(sheetName, "Ridership2", rowNum)
		String Ridership3  = data.getCellData(sheetName, "Ridership3", rowNum)

		WebUI.delay(6)

		//Ridership

		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'))
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),2)
		WebUI.verifyElementText(findTestObject('Object Repository/DataInput/CreateMeterBuilding/div_ Meter Name'),'Ridership', FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jan'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Feb'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), Ridership1)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading two

		WebUI.delay(6)

		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Mar'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Apr'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), Ridership2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		//reading 3

		WebUI.delay(6)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'),2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Add Row'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter start_'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_May'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/input_date-picker-meter end_da'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/clickDatePicker2'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/year_2017'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/month_Jun'))
		WebUI.mouseOver(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.click(findTestObject('Object Repository/DataInput/CreateMeterBuilding/day_2'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('DataInput/CreateMeterBuilding/input_fw600 reading ng-pristin'), Ridership3)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/CreateMeterBuilding/button_Update'))

		WebUI.delay(5)
		WebUI.refresh()
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/DataInput/HumanExperienceTransit/Ridership'))
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingOne'),'value'),Ridership3)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingTwo'),'value'),Ridership2)
		Assert.assertEquals(WebUI.getAttribute(findTestObject('Object Repository/DataInput/CreateMeterBuilding/ReadingThree'),'value'),Ridership1)

	}



	//City DataInput



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

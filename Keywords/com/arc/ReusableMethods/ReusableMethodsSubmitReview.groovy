package com.arc.ReusableMethods

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement
import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.mysql.jdbc.Driver


public class ReusableMethodsSubmitReview extends BaseClass{
	@Keyword
	public void performanceScoreSelectionAndSummery(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/EnergyCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/WaterCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/WasteCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/TransportationCheckBox'))
		WebUI.click(findTestObject('Object Repository/SubmitReview/HumanExperienceCheckBox'))
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SendUploadFile'), UploadDocumentDataInput)
		ReusableMethodsDataInput.clickCancel()
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}


	@Keyword
	public void certificationSelectionAndSummeryTransit(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(5)
		(1..28).each {
			WebUI.check(findTestObject('Object Repository/SubmitReview/CkeckBoxReview',[('index') : it]))
		}
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SendUploadFile'), UploadDocumentDataInput)
		ReusableMethodsDataInput.clickCancel()
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}

	@Keyword
	public void certificationSelectionAndSummeryCityCom(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(5)
		(1..6).each {
			WebUI.check(findTestObject('Object Repository/SubmitReview/CkeckBoxReview',[('index') : it]))
		}
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.uploadFile(findTestObject('Object Repository/SubmitReview/SendUploadFile'), UploadDocumentDataInput)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}

	@Keyword
	public void  preCertificationSelectionAndSummeryCityCom(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'),1)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/SubmitReview/SelectPre-Certification'))
		WebUI.delay(5)
		(1..6).each {
			WebUI.check(findTestObject('Object Repository/SubmitReview/CkeckBoxReview',[('index') : it]))
		}
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SendUploadFile'), UploadDocumentDataInput)
		WebUI.delay(2)
		ReusableMethodsDataInput.clickCancel()
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}


	@Keyword
	public void preCertificationSelectionAndSummeryTransit(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.delay(5)
		WebUI.click(findTestObject('SubmitReview/a_ Review'))
		WebUI.delay(6)
		WebUI.scrollToElement(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'),1)
		WebUI.click(findTestObject('Object Repository/SubmitReview/ClickOnCertificationType'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/SubmitReview/SelectPre-Certification'))
		WebUI.delay(5)
		(1..28).each {
			WebUI.check(findTestObject('Object Repository/SubmitReview/CkeckBoxReview',[('index') : it]))
		}
		WebUI.click(findTestObject('SubmitReview/div_Upload'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/SendUploadFile'), UploadDocumentDataInput)
		ReusableMethodsDataInput.clickCancel()
		WebUI.click(findTestObject('Object Repository/SubmitReview/button_Continue'))
		WebUI.setText(findTestObject('SubmitReview/input_form-control ng-untouche'), 'abhishekkumar@groupten.com')
		WebUI.click(findTestObject('SubmitReview/span_Send'))
		WebUI.click(findTestObject('SubmitReview/button_Continue'))
	}


	/*@Keyword
	 public void checkReviewPaymentPayNowStatus(){
	 String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
	 Assert.assertEquals(regStatus, "Completed")
	 }*/



	@Keyword
	public void submitPerformanceScoreAndVerifySuccessMessage(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/SubmitPerformanceScore'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/MessageSuccessfullySubmitted')), "Successfully Submitted")
	}

	@Keyword
	public void submitCertificationAndVerifySuccessMessage(){

		WebUI.click(findTestObject('Object Repository/SubmitReview/SubmitCertification'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/MessageSuccessfullySubmitted')), "Successfully Submitted")
	}
	@Keyword
	public void submitPreCertAndVerifySuccessMessage(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/SubmitPreCertification'))
		WebUI.delay(5)
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/SubmitReview/MessageSuccessfullySubmitted')), "Successfully Submitted")
	}
}

package com.arc.ReusableMethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsPayment extends BaseClass{

	@Keyword
	public void paymentByCC(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		String cardName   = data.getCellData(sheetName, "Card Name", rowNum);
		String cardNum    = data.getCellData(sheetName, "Card Number", rowNum);
		String cardDate   = data.getCellData(sheetName, "Date ", rowNum);
		String cardCvv    = data.getCellData(sheetName, "CVV", rowNum);
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);

		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_name '),cardName)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), cardNum)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_expiry'),cardDate)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_CVV'),cardCvv)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , true)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(20)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
	}

	@Keyword
	public void regPaymentByCheckIND(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , false)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Continue'))
		WebUI.delay(10)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
	}

	@Keyword
	public void regPaymentByCheckINT(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/CheckRadio'))
		WebUI.delay(2)
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , false)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(15)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
	}
	@Keyword
	public void regPaymentByCheckCN(String sheetName , int rowNum){
		/********************Fetching the data via Excel Sheet ******************************/
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(4)
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Country'), country, false)
		WebUI.selectOptionByLabel(findTestObject('PaymenntLocator/Select_State'),state , false)
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(15)
		Boolean testCongratulations = WebUI.verifyTextPresent('Congratulations', false)
		Assert.assertTrue(testCongratulations)
	}

	@Keyword
	public void payNowRegistrationPaymentIND(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.scrollToElement(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'), 2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.switchToWindowTitle('')
		//WebUI.switchToWindowIndex(1)
		WebUI.setText(findTestObject('PayNowRegistrationPaymentIN/input_phone'), '9486861522')
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Continue'))
		WebUI.selectOptionByValue(findTestObject('PayNowRegistrationPaymentIN/select_Select Bank'), 'AvenuesTest', true)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_Make Payment'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/returnToMerchantSite'))
		WebUI.switchToWindowTitle('Arc dashboard')
		Assert.assertEquals(WebUI.getText(findTestObject('PayNowRegistrationPaymentIN/checkStatusCompleted')),'Completed')

	}

	@Keyword
	public void payNowSubmitReviewPaymentIND(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.switchToWindowTitle('')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentIN/input_phone'), '9486861522')
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Continue'))
		WebUI.selectOptionByValue(findTestObject('PayNowRegistrationPaymentIN/select_Select Bank'), 'AvenuesTest', true)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_Make Payment'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/returnToMerchantSite'))
		WebUI.switchToWindowTitle('Arc dashboard')
		Assert.assertEquals(WebUI.getText(findTestObject('Object Repository/PayNowSubmitReviewPaymentIN/submitReviewPaymentStatus')),'Completed')
	}


	@Keyword
	public void payNowRegistrationPaymentINT(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(1)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.scrollToElement(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'), 2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'), 'Saurav')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'), 'K')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_cardnumber'), '4012000010000')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_expiry'), '02/2025')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_number'), '999')
		//WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/div_Street Address  This field'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'), 'GBCI BUILDING')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('PayNowRegistrationPaymentUSTest/select_AfghanistanAland Island'), 'United States', false)
		WebUI.selectOptionByLabel(findTestObject('RegistrationPaymentCheck/select_Select StateAlabamaAlas'), 'Alabama', false)
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'), '35006')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_phone'), '9486861522')
		WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/button_Pay now_1'))
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/RegistrationPaymentStatus'))
		Assert.assertEquals(regStatus, "Completed")
	}


	@Keyword
	public void payNowReviewPaymentUS(){
		WebUI.click(findTestObject('Object Repository/SubmitReview/clickOnSideBar'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Manage'))
		WebUI.scrollToElement(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'), 2)
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/a_ Billing'))
		WebUI.click(findTestObject('PayNowRegistrationPaymentIN/button_Pay now'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_firstname'), 'Saurav')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_lastname'), 'K')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_cardnumber'), '4012000010000')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_expiry'), '02/2025')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_CC_number'), '999')
		//WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/div_Street Address  This field'))
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_streetaddress'), 'GBCI BUILDING')
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_city'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('PayNowRegistrationPaymentUSTest/select_AfghanistanAland Island'), 'United States', false)
		WebUI.selectOptionByLabel(findTestObject('RegistrationPaymentCheck/select_Select StateAlabamaAlas'), 'Alabama', false)
		WebUI.clearText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'))
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_postalcode'), '35006')
		WebUI.setText(findTestObject('PayNowRegistrationPaymentUSTest/input_phone'), '9486861522')
		WebUI.click(findTestObject('PayNowRegistrationPaymentUSTest/button_Pay now_1'))
		//WebUI.waitForElementVisible(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'),10)
		WebUI.delay(10)
		String regStatus= WebUI.getText(findTestObject('Object Repository/Manage/BillingSection/ReviewPaymentStatus'))
		Assert.assertEquals(regStatus, "Completed")
	}

	@Keyword
	public void clickCheckOptionRegistration(){

		WebUI.click(findTestObject('Object Repository/PaymenntLocator/SelectOptionCheck'))
	}

	@Keyword
	public void clickCheckOptionReview(){
		WebUI.delay(5)
		WebUI.click(findTestObject('ReviewPaymentByCheckUS/input_payment-type'))
	}


	@Keyword
	public void reviewPaymentByCheckINT(){
		WebUI.click(findTestObject('Page_Arc dashboard/a_Projects'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/payment-typeCheck'))
		WebUI.delay(2)
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_firstname2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_firstname2'), 'Saurav')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_lastname2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_lastname2'), 'K')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_streetaddress2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_streetaddress2'), 'GBCI')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_city2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_city2'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('ReviewPaymentByCheckUS/select_AfghanistanAland Island'), 'India', false)
		WebUI.selectOptionByLabel(findTestObject('ReviewPaymentByCheckUS/select_Select StateAndaman and'), 'Haryana', false)
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_postalcode2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_postalcode2'), '122018')
		WebUI.clearText(findTestObject('ReviewPaymentByCheckUS/input_email2'))
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_email2'), 'saurav@groupten.com')
		WebUI.setText(findTestObject('ReviewPaymentByCheckUS/input_phone2'), '9486861522')
		WebUI.click(findTestObject('ReviewPaymentByCheckUS/button_Continue'))
	}


	@Keyword
	public void reviewPaymentByCheckIND(){

		WebUI.delay(5)
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_firstname2'), 'Saurav')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_lastname2'), 'K')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_streetaddress2'), 'GBCI Gurgaon')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_city2'), 'Gurgaon')
		WebUI.selectOptionByLabel(findTestObject('ReviewPaymentByCheckIND/select_Select StateAndaman and'), 'Haryana', false)
		WebUI.delay(3)
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_postalcode2'), '122018')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_email2'), 'testuser@gmail.com')
		WebUI.setText(findTestObject('ReviewPaymentByCheckIND/input_phone2'), '9486861522')
		WebUI.click(findTestObject('ReviewPaymentByCheckIND/button_Continue'))
		WebUI.delay(3)
		WebUI.click(findTestObject('ReviewPaymentByCheckIND/button_Continue_1'))
		WebUI.delay(2)
	}

	@Keyword
	public void reviewPaymentByCreditcardINT(){
		WebUI.delay(6)
		WebUI.clearText(findTestObject('SubmitReview/input_firstname'))
		WebUI.setText(findTestObject('SubmitReview/input_firstname'), 'Saurav')
		WebUI.clearText(findTestObject('SubmitReview/input_lastname'))
		WebUI.setText(findTestObject('SubmitReview/input_lastname'), 'K')
		WebUI.setText(findTestObject('SubmitReview/input_cardnumber'), '4012000010000')
		WebUI.setText(findTestObject('SubmitReview/input_CC_expiry'), '09/2025')
		WebUI.setText(findTestObject('SubmitReview/input_CC_number'), '999')
		WebUI.clearText(findTestObject('SubmitReview/input_streetaddress'))
		WebUI.setText(findTestObject('SubmitReview/input_streetaddress'), 'GBCI BUILDING ')
		WebUI.clearText(findTestObject('SubmitReview/input_city'))
		WebUI.setText(findTestObject('SubmitReview/input_city'), 'gurgaon')
		WebUI.selectOptionByLabel(findTestObject('Object Repository/SubmitReview/ReviewPaymentSelectCountry'), 'India', false)
		WebUI.selectOptionByLabel(findTestObject('SubmitReview/select_Select StateAndaman and'), 'Haryana', false)
		WebUI.clearText(findTestObject('Object Repository/SubmitReview/postalcode'))
		WebUI.sendKeys(findTestObject('Object Repository/SubmitReview/postalcode'), '122018')
		WebUI.setText(findTestObject('SubmitReview/input_email'), 'saurav@grouppten.com')
		WebUI.setText(findTestObject('SubmitReview/input_phone'), '9486861522')
		WebUI.click(findTestObject('SubmitReview/span_Continue'))
	}
}


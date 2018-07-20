import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/CitiesSuites/USCitySuite/LEEDForCitesSuite')

suiteProperties.put('name', 'LEEDForCitesSuite')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\Group 10\\git\\KatalonStudio\\ArcWithKatalonStudio\\Reports\\CitiesSuites\\USCitySuite\\LEEDForCitesSuite\\20180721_011232\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/CitiesSuites/USCitySuite/LEEDForCitesSuite', suiteProperties, [new TestCaseBinding('Test Cases/MyCities/LEEDForCities/LoginWithCitesTest', 'Test Cases/MyCities/LEEDForCities/LoginWithCitesTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/AddNewProjectTest', 'Test Cases/MyCities/LEEDForCities/AddNewProjectTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/SearchProgramTest', 'Test Cases/MyCities/LEEDForCities/SearchProgramTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/RegPaymentByCreditCardTest', 'Test Cases/MyCities/LEEDForCities/RegPaymentByCreditCardTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/AddTeamMemberTest', 'Test Cases/MyCities/LEEDForCities/AddTeamMemberTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/AgreementFileDownloadTest', 'Test Cases/MyCities/LEEDForCities/AgreementFileDownloadTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/BasePointADMeterOptionBPointTest', 'Test Cases/MyCities/LEEDForCities/BasePointADMeterOptionBPointTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/BillingDateAndStatusTest', 'Test Cases/MyCities/LEEDForCities/BillingDateAndStatusTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CertificationDetailsTest.java', 'Test Cases/MyCities/LEEDForCities/CertificationDetailsTest.java',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/INTCertRevPaymentByCCTest', 'Test Cases/MyCities/LEEDForCities/INTCertRevPaymentByCCTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CreateEnergyMeterReadingTest', 'Test Cases/MyCities/LEEDForCities/CreateEnergyMeterReadingTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CreateHumanExpMeterReadingTest', 'Test Cases/MyCities/LEEDForCities/CreateHumanExpMeterReadingTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CreateTrasportMeterReadingTest', 'Test Cases/MyCities/LEEDForCities/CreateTrasportMeterReadingTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CreateWasteDiversionMeterReadingTest', 'Test Cases/MyCities/LEEDForCities/CreateWasteDiversionMeterReadingTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CreateWasteGenerationMeterReadingTest', 'Test Cases/MyCities/LEEDForCities/CreateWasteGenerationMeterReadingTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/CreateWaterMeterReadingTest', 'Test Cases/MyCities/LEEDForCities/CreateWaterMeterReadingTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/PreRequisiteAttemptTest', 'Test Cases/MyCities/LEEDForCities/PreRequisiteAttemptTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/PrerequisiteNarrativeTextSaveTest', 'Test Cases/MyCities/LEEDForCities/PrerequisiteNarrativeTextSaveTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/ProjectDetailsVerificationTest', 'Test Cases/MyCities/LEEDForCities/ProjectDetailsVerificationTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/ScoreVersionVerificationTest', 'Test Cases/MyCities/LEEDForCities/ScoreVersionVerificationTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/VerifyAndDownloadBillingReceiptTest', 'Test Cases/MyCities/LEEDForCities/VerifyAndDownloadBillingReceiptTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/EditProjectDetailsTest', 'Test Cases/MyCities/LEEDForCities/EditProjectDetailsTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/BasePointADMeterOptionAPointTest', 'Test Cases/MyCities/LEEDForCities/BasePointADMeterOptionAPointTest',  null), new TestCaseBinding('Test Cases/MyCities/LEEDForCities/LogoutToArcTest', 'Test Cases/MyCities/LEEDForCities/LogoutToArcTest',  null)])

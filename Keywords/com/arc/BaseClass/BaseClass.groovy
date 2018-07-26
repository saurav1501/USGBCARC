package com.arc.BaseClass
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject
public class BaseClass{

	public static String UploadDocumentDataInput = RunConfiguration.getProjectDir()+"/ARCDataTemplete/USGBC.pdf";
	public String downloadPath = RunConfiguration.getProjectDir()+"/Download/"
	public static String filePath= RunConfiguration.getProjectDir()+"/ArcTest.xlsx"
	public static XlsReader data = new XlsReader(filePath)
	public static String pdfFile = RunConfiguration.getProjectDir()+"/ARCDataTemplete/USGBC.pdf";
	public static String screenShot = RunConfiguration.getProjectDir()+"/ScreenShot/screenshot_"
	public static String UploadArcDataTemplete = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Arc_Data_Template.xlsm"
	public static String parkImageUpload = RunConfiguration.getProjectDir()+"/ARCDataTemplete/Parking SJ.jpg";
	public static TestObject myTestObject = new TestObject("customObject")
	public static Date date = new Date(System.currentTimeMillis())
}

package com.arc.BaseClass
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject
public class BaseClass{

	public static String UploadDocumentDataInput = System.getProperty("user.dir")+"\\ARCDataTemplete\\USGBC.pdf";
	public static String downloadPath = System.getProperty('user.dir') + '\\Download'
	public static String filePath= RunConfiguration.getProjectDir()+"\\ArcTest.xlsx"
	public static XlsReader data = new XlsReader(filePath)
	public static String pdfFile = System.getProperty("user.dir")+"\\ARCDataTemplete\\USGBC.pdf";
	public static String screenShot = System.getProperty("user.dir")+"\\ScreenShot\\screenshot_"
	public static String UploadArcDataTemplete = System.getProperty("user.dir") +"\\ARCDataTemplete\\Arc_Data_Template.xlsm"
	public static String parkImageUpload = System.getProperty("user.dir")+"\\ARCDataTemplete\\Parking SJ.jpg";
	public static TestObject myTestObject = new TestObject("customObject")
	public static Date date = new Date(System.currentTimeMillis())
}

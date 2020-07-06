/***************************************************************
 * Objective : To verify whether application displays property details in all properties upon clicking Restore link of selected property details in trash
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RestorePOM;
import com.training.pom.TrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RestoreFromTrash_02 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TrashPOM trashPOM;
	private RestorePOM restorePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		trashPOM = new TrashPOM(driver);
		restorePOM = new RestorePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		//login
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void restoreFromTrash() throws InterruptedException {
		
		
		//navigate properties - all properties (default)
		trashPOM.clickProperties();
		
		// trash
		trashPOM.clickTrash();
		
		// mouse over property to restore 
		restorePOM.mouseOver();
		String title = restorePOM.getTitle(); 
		
		// click restore and verify message
		restorePOM.clickRestore();
		
		String actualResult = restorePOM.restoreMsg();
		String expectedResult="1 post restored from the Trash.";
		Assert.assertEquals(actualResult, expectedResult);
		
		// verify under All
		trashPOM.clickAll();
		
		Assert.assertTrue(driver.getPageSource().contains(title),"entry restored");
		
		
		
		screenShot.captureScreenShot("RestoreFromTrash");
	}
}

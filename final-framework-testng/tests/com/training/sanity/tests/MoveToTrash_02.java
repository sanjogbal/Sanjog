/***************************************************************
 * Objective : To verify whether application allows admin to add property details into trash & display the same
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
import com.training.pom.TrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MoveToTrash_02 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TrashPOM trashPOM;
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
	public void moveToTrash() throws InterruptedException {
		//navigate properties
		trashPOM.clickProperties();
		//add new - title ,credential,feature, region
		trashPOM.addNewProperty();
		Thread.sleep(2000);
		String title ="testSan01";
		trashPOM.enterTitle(title);
		trashPOM.enterContent("this is testSan content");
		
		trashPOM.selectRegion();
		trashPOM.selectFeature();
		
		//move to trash
		trashPOM.clickDelete();
		Thread.sleep(1000);
				
		//pop-up confirmation leave 
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//assert
		String actualResult = trashPOM.deleteMsg();
		String expectedResult="1 post moved to the Trash. Undo";
		Assert.assertEquals(actualResult, expectedResult);
		
		
		//click trash icon to verify
		
		trashPOM.clickTrash();
		Assert.assertTrue(driver.getPageSource().contains(title),"entry deleted");
		
		
		
		screenShot.captureScreenShot("MovetoTrash");
	}

}

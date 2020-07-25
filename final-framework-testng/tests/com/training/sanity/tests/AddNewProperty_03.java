/***************************************************************
 * Objective : To verify whether application allows admin to add new property with all details & added property details in home screen for user
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PropertyPOM;
import com.training.pom.TrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewProperty_03 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TrashPOM trashPOM;
	private PropertyPOM propertyPOM;
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
		propertyPOM = new PropertyPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
		//login as admin
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
	public void addNewProperty() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;


		// click Properties
		trashPOM.clickProperties();
		
		//click Add new link
		trashPOM.addNewProperty();
		Thread.sleep(2000);

		//enter title
		String title ="New Launch San04";
		trashPOM.enterTitle(title);
		
		//enter textbox input
		trashPOM.enterContent("this is test San content");

		
		// enter price here
	    propertyPOM.enterPrice("50000.00");

		//enter price/sqft
		propertyPOM.enterSqftPrice("200.00");

		//click main details
		propertyPOM.clickMainDetails();
		
		//enter status
		propertyPOM.enterStatus("New");
		
		//enter location
		propertyPOM.enterLocation("Electronic City");

		//enter possession
		propertyPOM.enterPosession("Immediate");		

		//click location
		propertyPOM.clickLocation();

		//enter addressbook
		propertyPOM.enterFAddress("Yeshwantpur");

		//enter google map address
		propertyPOM.enterAddress("Yeshwantpur");

		//enter latitude
		propertyPOM.enterLatitude("120");

		//enter longitude
		propertyPOM.enterLongitude("56");

		//click details
		propertyPOM.clickDetails();

		// enter storage room
		propertyPOM.strRoom("2");

		//click Bangalore Central
		propertyPOM.clickReg();
		
		//scroll up
        js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(2000);
		
		//click features checkbox
		trashPOM.selectRegion();
		
		//click regions checkbox
		trashPOM.selectFeature();
		
		//scroll up
        js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(2000);

		//click publish
		propertyPOM.clickPublish();
		Thread.sleep(2000);

		//click logout
		propertyPOM.hoverAccount();
		propertyPOM.clickLogout();
		

		//click real-estate icon
		propertyPOM.clickRELogo();

		//search added property
		propertyPOM.enterSearch(title);
		Thread.sleep(1000);

		propertyPOM.clickSearch();
		Thread.sleep(1000);

		//assert
		
		//switch to tab and get URL
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(propertyPOM.getTitle().contains(title));

		screenShot.captureScreenShot("AddNewProperty");
	}

}

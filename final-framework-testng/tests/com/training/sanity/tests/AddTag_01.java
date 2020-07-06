/***************************************************************
 * Objective : To Verify whether application allows admin to add new tag
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddTag_01 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CategoryPOM categoryPOM;
	private TagPOM tagPOM;	
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
		categoryPOM = new CategoryPOM(driver);
		tagPOM = new TagPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);
		//login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();

		//navigate to Posts
		categoryPOM.clickPosts();

		//navigate to Tags
		tagPOM.clickTag();
		Thread.sleep(1000);

	}

	@AfterMethod 
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void addTag() {

		// select and populate fields Tag to be added
		String tagname = "test tag 5";   // Hard coded
		tagPOM.sendTag(tagname);
		tagPOM.sendSlug("test slug");
		tagPOM.sendDesc("this is my test tag");
		
		// add Tag and refresh page
		tagPOM.submit();
		driver.navigate().refresh();
		
		// assertion		
		String actualResult = tagPOM.getAddTagMsg(); // Hard coded
		Assert.assertEquals(actualResult, tagname);

		screenShot.captureScreenShot("AddTag");
	}

}

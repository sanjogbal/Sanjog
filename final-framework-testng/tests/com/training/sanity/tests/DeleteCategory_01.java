/***************************************************************
 * Objective : To Verify whether application allows admin to delete category from the categories page
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteCategory_01 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CategoryPOM categoryPOM;
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
		
		//navigate to Categories
		categoryPOM.clickCategories();		
		Thread.sleep(1000);
	}

	@AfterMethod 
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void deleteCategory() {


		// select category to be deleted
		categoryPOM.clickCat();
		
		// select delete and click action
		categoryPOM.selectDelete();		
		categoryPOM.clickAction();		
		
		// assertion
		String actualResult = categoryPOM.getMsg();
		String expectedResult="Categories deleted.";
		Assert.assertEquals(actualResult, expectedResult);

		//take screenshot
		screenShot.captureScreenShot("Delete Category");
	}
}




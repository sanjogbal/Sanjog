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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteTag {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		driver.findElement(By.id("menu-posts")).click();

		//navigate to Categories
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a")).click();
		Thread.sleep(1000);

	}

	@AfterMethod 
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void deleteTag() {

		// select Tag to be deleted
		driver.findElement(By.id("cb-select-1400")).click(); //Hard coded

		// delete Tag

		Select bulk = new Select(driver.findElement(By.id("bulk-action-selector-bottom")));
		bulk.selectByVisibleText("Delete");        
		driver.findElement(By.xpath("//*[@id=\"doaction2\"]")).click();	

		// assertion

		String actualResult = driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();
		String expectedResult="Tags deleted.";
		Assert.assertEquals(actualResult, expectedResult);

		screenShot.captureScreenShot("DeleteTag");
	}

}

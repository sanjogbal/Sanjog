/***************************************************************
 * Objective : To Verify whether application allows admin to Add multiple New Feature in the application from an excel file
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CategoryPOM;
import com.training.pom.FeaturesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.TagPOM;
import com.training.pom.TrashPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddMultipleFeatures_XL_03 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CategoryPOM categoryPOM;
	private TrashPOM trashPOM;
	private TagPOM tagPOM;
	private FeaturesPOM featuresPOM;;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		trashPOM = new TrashPOM(driver);

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);

		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(1000);

		//login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();

		Thread.sleep(1000);

		//click Properties
		trashPOM.clickProperties();

	}

	@BeforeMethod
	public void setUp() throws Exception {

		categoryPOM = new CategoryPOM(driver);		
		tagPOM = new TagPOM(driver);
		featuresPOM = new FeaturesPOM(driver);

		//click Features
		featuresPOM.clickFeature();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void addFeatures(String name, String slug, String pfeature, String description) throws InterruptedException{

		//select and enter name
		featuresPOM.enterName(name);

		//select and enter slug
		featuresPOM.enterSlug(slug);				

		//select and enter Parent feature
		featuresPOM.enterPFeature(pfeature);

		//select and enter Description
		featuresPOM.enterDescription(description);

		//click Add new feature and refresh
		featuresPOM.clickSubmit();
		driver.navigate().refresh();

		//assertion



		//generate report

		screenShot.captureScreenShot("AddMultipleFeatures");
	}

}

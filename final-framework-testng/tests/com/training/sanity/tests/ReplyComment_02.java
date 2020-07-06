/***************************************************************
 * Objective : To verify whether application allows admin to reply for the comment added by user
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.BlogPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReplyComment_02 {


	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private BlogPOM blogPOM;
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
		blogPOM = new BlogPOM(driver);
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 

		// open the browser 
		driver.get(baseUrl);

	}

	@AfterMethod 
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void addComment() throws AWTException, InterruptedException {

		//Click Blog
		blogPOM.clickBlog();		

		//click New Project		
		blogPOM.clickNewBlog();		

		//add comment
		String inComment = "this is my comment San09";
		blogPOM.comment(inComment);
		blogPOM.enterAuthor("San");
		blogPOM.enterEmail("sanj@123.com");
		blogPOM.clickSubmit();


		// assertion - comment added	
		Assert.assertTrue(driver.getPageSource().contains(inComment));


		//open in new tab
		blogPOM.openTab();
		
		//switch to tab
		blogPOM.switchTab();


		//login as admin
		loginPOM.clickLoginLink();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(3000);

		//navigate to comments
		blogPOM.clickComments();
		
		// comment value
		int prevVal = blogPOM.commentVal();

		//post reply
		blogPOM.mouseOver();
		blogPOM.clickReply();
		blogPOM.replyText("this is the admin reply 03");
		
		//assertion
		int postVal = blogPOM.commentVal();
		Assert.assertTrue(postVal>prevVal,"incremented");

		screenShot.captureScreenShot("Add blog comment");
	}

}

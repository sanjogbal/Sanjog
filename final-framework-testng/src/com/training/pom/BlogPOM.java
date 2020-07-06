/***************************************************************
 * Objective : POM file to support ReplyComment_02
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BlogPOM {
	private WebDriver driver; 

	public BlogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Comments
	@FindBy(id="menu-comments")
	private WebElement comments;
	
	//select specific comment
	@FindBy(id ="comment-2214")
	private WebElement toComment;
	
	//reply comment
	@FindBy(xpath="//*[@class=\"row-actions\"]/span[3]/a")
	private WebElement reply;
	
	//reply text
	@FindBy(xpath="//*[@id=\"replycontent\"]")
	private WebElement replyText;
	
	//comment count
	@FindBy(xpath="//*[@class =\"comment-count-approved\"]")
	private WebElement commentCount;
	

	//blog
	@FindBy (xpath="//*[@id=\"menu-item-617\"]")
	private WebElement blog;

	//blog New Project read more
	@FindBy (xpath="//*[@id=\"post-10245\"]/div/a")
	private WebElement newBlog;

	// comment textarea
	@FindBy (id="comment")
	private WebElement addComment;

	// name textarea
	@FindBy (id="author")
	private WebElement author;

	// email textarea
	@FindBy (id="email")
	private WebElement email;


	// submit
	@FindBy (id="submit")
	private WebElement submit;

	// logo
	@FindBy (xpath="//*[@id=\"logo\"]")
	private WebElement logo;


	public void clickComments() {
		this.comments.click();			
	}
	
	public void mouseOver() {
		Actions act= new Actions(driver);
		act.moveToElement(toComment).perform();
	}
	
	public void clickReply() {
		this.reply.click();
	}
	
	public void replyText(String replyInput) {
		this.replyText.clear();
		this.replyText.sendKeys(replyInput);
	}
	
	public int commentVal() {
		return Integer.parseInt(this.commentCount.getText());

	}
	
	public void clickBlog() {
		this.blog.click();;
	}


	public void clickNewBlog() {
		this.newBlog.click();
	}

	public void comment(String commentInput) {
		this.addComment.clear();
		this.addComment.sendKeys(commentInput);			
	}

	public void enterAuthor(String authorInput) {
		this.author.clear();
		this.author.sendKeys(authorInput);			
	}

	public void enterEmail(String emailInput) {
		this.email.clear();
		this.email.sendKeys(emailInput);			
	}

	public void clickSubmit() {
		this.submit.click();
	}

	public void openTab() throws AWTException, InterruptedException {

		Actions act= new Actions(driver);
		act.contextClick(logo).build().perform();
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);

	}
	
	public void switchTab() {
		ArrayList<String> tab=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
	}



}

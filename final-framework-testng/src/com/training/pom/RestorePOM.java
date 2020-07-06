/***************************************************************
 * Objective : POM file to support RestoreFromTrash_02
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestorePOM {
	private WebDriver driver; 

	public RestorePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	//select specific Property
	@FindBy(id ="post-10302")
	private WebElement toRestore;
	
	//select property title	
	@FindBy(xpath ="//*[@id=\"post-10302\"]/td/strong")
	private WebElement toRestoreTitle;
	
	//Restore
	@FindBy(xpath="//*[@id=\"post-10302\"]/td[1]/div[2]/span/a")
	private WebElement restore;
	
	//restore message
	@FindBy(xpath="//*[@id=\"message\"]/p")
	private WebElement restoreMsg;
	
	public void mouseOver() {
		Actions act= new Actions(driver);
		act.moveToElement(toRestore).perform();
	}
	
	public String getTitle() {
		return(this.toRestoreTitle.getText());
	}
	
	public void clickRestore() {
		this.restore.click();			
	}
	
	public String restoreMsg() {
		return this.restoreMsg.getText();			
	}
	
}

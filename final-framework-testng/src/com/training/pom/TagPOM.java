/***************************************************************
 * Objective : POM file to support AddTag_01, DeleteTag_01
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TagPOM {
	private WebDriver driver; 
	
	public TagPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
		
	//navigate to Tags
	// Tags
	@FindBy (xpath="//*[@id=\"menu-posts\"]/ul/li[5]/a")
	private WebElement tags;
	
	//tag name fields to add
	@FindBy (id="tag-name")
	private WebElement tagName;
	
	@FindBy (id="tag-slug")
	private WebElement tagSlug;
	
	@FindBy (id="tag-description")
	private WebElement tagDesc;
			
	//submit 
	@FindBy (id="submit")
	private WebElement submit;
	
	//assert
	@FindBy (linkText="test tag 5")
	private WebElement addTagConfirmMsg;		
	
	
	@FindBy (xpath="//*[@id=\"message\"]/p")
	private WebElement delTagConfirmMsg;
	
	// select Tag to be deleted
	@FindBy(id="cb-select-1415")
	private WebElement delTag; //Hard coded
	
	
			
	
	public void clickTag() {
		this.tags.click();			
	}
	
	public void sendTag(String tagname) {
		this.tagName.clear(); 
		this.tagName.sendKeys(tagname); 
	}
	
	public void sendSlug(String slug) {
		this.tagSlug.clear(); 
		this.tagSlug.sendKeys(slug); 
	}
	
	public void sendDesc(String desc) {
		this.tagDesc.clear(); 
		this.tagDesc.sendKeys(desc); 
	}
	
	public void submit() {
		this.submit.click();			
	}
	
	public void clickDelTag() {
		this.delTag.click();			
	}
	
	public String getAddTagMsg() {
		return this.addTagConfirmMsg.getText();			
	}
	
	public String getDelTagMsg() {
		return this.delTagConfirmMsg.getText();			
	}
}

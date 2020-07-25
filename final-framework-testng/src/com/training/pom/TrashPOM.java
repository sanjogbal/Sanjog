/***************************************************************
 * Objective : POM file to support MoveToTrash_02
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TrashPOM {

	private WebDriver driver; 

	public TrashPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	//Properties
	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/a/div[3]")
	private WebElement properties;

	//add property
	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[3]")
	private WebElement addProperty;

	//title 
	@FindBy(id="title")
	private WebElement title;
	
	//content 
	@FindBy(id="content")
	private WebElement content;
	
	//region 
	@FindBy(id="in-region-1348")
	private WebElement region;
	
	//feature 
	@FindBy(id="in-property_feature-1502")
	private WebElement feature;


	//move to trash
	@FindBy(xpath="//*[@id=\"delete-action\"]/a")
	private WebElement delete;

	
	//assert
	@FindBy(xpath="//*[@id=\"message\"]/p")
	private WebElement deleteMsg;

	//click trash icon to verify
	@FindBy(xpath="//*[@class=\"trash\"]/a")	
	private WebElement trash;
	
	//click all icon
	@FindBy(xpath="//*[@class=\"all\"]/a")	
	private WebElement all;


	public void clickProperties() {
		this.properties.click();			
	}

	public void addNewProperty() {
		this.addProperty.click();			
	}
	
	public void enterTitle(String inputTitle) {
		this.title.sendKeys(inputTitle);			
	}
	
	public void enterContent(String inputContent) {
		this.content.sendKeys(inputContent);			
	}

	public void selectRegion() {
		this.region.click();			
	}
	
	public void selectFeature() {
		this.feature.click();			
	}
	
	public void clickDelete() {
		this.delete.click();			
	}
	
	public String deleteMsg() {
		return this.deleteMsg.getText();			
	}
	
	public void clickTrash() {
		this.trash.click();			
	}
	
	public void clickAll() {
		this.all.click();			
	}
	
	
}

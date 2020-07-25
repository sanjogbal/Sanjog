/***************************************************************
 * Objective : POM file to support AddMultipleFeatures_03
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FeaturesPOM {
	private WebDriver driver; 

	public FeaturesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	//click Features
	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul/li[4]")
	private WebElement features;

	// name
	@FindBy(id="tag-name")
	private WebElement name;


	// slug
	@FindBy(id="tag-slug")
	private WebElement slug;


	// Parent feature
	@FindBy(id="parent")
	private WebElement feature;

	//Description
	@FindBy(id="tag-description")
	private WebElement description;

	//Add New Feature
	@FindBy(id="submit")
	private WebElement submit;
	
	//assert
	

	public void clickFeature() {
		this.features.click();			
	}
	
	public void enterName(String name) {
		this.name.clear(); 
		this.name.sendKeys(name); 
	}
	
	public void enterSlug(String slug) {
		this.slug.clear(); 
		this.slug.sendKeys(slug); 
	}
	
	// select parent feature from drop down
	public void enterPFeature(String pfeature) {		
		Select parentFeature = new Select(feature);
		parentFeature.selectByVisibleText(pfeature);
	}
	
	public void enterDescription(String desc) {
		this.description.clear(); 
		this.description.sendKeys(desc); 
	}
	
	public void clickSubmit() {
		this.submit.click();			
	}

}

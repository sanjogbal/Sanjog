/***************************************************************
 * Objective : POM file to support DeleteCategory_01
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
import org.testng.annotations.Test;

public class CategoryPOM {
	
		private WebDriver driver; 
		
		public CategoryPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		
		//Posts
		@FindBy(id="menu-posts")
		private WebElement posts;

		//Categories
		@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
		private WebElement categories;
		
		//category to be deleted
		@FindBy(id ="cb-select-1408") //Hard coded
		private WebElement delCategory;
		
		
		// bulk
		@FindBy(id="bulk-action-selector-bottom")
		private WebElement bulk;
		
		// action
		@FindBy(xpath="//*[@id=\"doaction2\"]")
		private WebElement action;
		
		//assert msg
		@FindBy(xpath="//*[@id=\"message\"]/p")
		private WebElement confirmMsg;
		
		public void clickPosts() {
			this.posts.click();			
		}
		
		public void clickCategories() {
			this.categories.click();			
		}
		
		public void clickCat() {
			this.delCategory.click();			
		}
		
		public void selectDelete() {
		Select bulkAct = new Select(this.bulk);
		bulkAct.selectByVisibleText("Delete");		
		}
			
		public void clickAction() {
			this.action.click();
		}
		
		public String getMsg() {
			return this.confirmMsg.getText();			
		}
				
}

/**********************************************************
 * Objective : POM file to support AddNewProperty_03
 * Author : Sanjog Bal
 * 
 **************************************************************/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PropertyPOM {
	private WebDriver driver; 

	public PropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	// enter price here
	@FindBy(id="_price")
	private WebElement price;
	
	public void enterPrice(String inputPrice) {
		this.price.clear(); 
		this.price.sendKeys(inputPrice);			
	}

	//enter price/sqft
	@FindBy(id="_price_per")
	private WebElement sqftprice;
	
	public void enterSqftPrice(String inputSqftPrice) {
		this.sqftprice.clear(); 
		this.sqftprice.sendKeys(inputSqftPrice);			
	}
	
	//click main details
	@FindBy(id="ui-id-2")
	private WebElement mainDetails;
	
	public void clickMainDetails() {
		this.mainDetails.click(); 
	}

	//enter status
	@FindBy(id="_status")
	private WebElement status;
	
	public void enterStatus(String inputStatus) {
		this.status.clear(); 
		this.status.sendKeys(inputStatus);			
	}

	//enter location
	@FindBy(id="_location")
	private WebElement location;
	
	public void enterLocation(String inputLocation) {
		this.location.clear(); 
		this.location.sendKeys(inputLocation);			
	}

	//enter posession
	@FindBy(id="_possession")
	private WebElement posession;
	
	public void enterPosession(String inputPosession) {
		this.posession.clear(); 
		this.posession.sendKeys(inputPosession);			
	}

	//click location
	@FindBy(id="ui-id-3")
	private WebElement loc;
	
	public void clickLocation() {
		this.loc.click(); 
	}

	//enter address
	@FindBy(id="_friendly_address")
	private WebElement fAddress;
	
	public void enterFAddress(String inputFAddress) {
		this.fAddress.clear(); 
		this.fAddress.sendKeys(inputFAddress);			
	}

	//enter google map address
	@FindBy(id="_address")
	private WebElement address;
	
	public void enterAddress(String inputAddr) {
		this.address.clear(); 
		this.address.sendKeys(inputAddr);			
	}

	//enter latitude
	@FindBy(id="_geolocation_lat")
	private WebElement latitude;
	
	public void enterLatitude(String inputLat) {
		this.latitude.clear(); 
		this.latitude.sendKeys(inputLat);			
	}

	//enter longitude
	@FindBy(id="_geolocation_long")
	private WebElement longitude;
	
	public void enterLongitude(String inputLong) {
		this.longitude.clear(); 
		this.longitude.sendKeys(inputLong);			
	}

	//click details
	@FindBy(id="ui-id-4")
	private WebElement details;
	
	public void clickDetails() {
		this.details.click(); 
	}

	//enter storage room
	@FindBy(id="_storage_room")
	private WebElement strRoom;
	
	public void strRoom(String inputStore) {
		this.strRoom.clear(); 
		this.strRoom.sendKeys(inputStore);			
	}

	//click Bangalore Central
	//@FindBy(id="in-region-1348")
	@FindBy(xpath="//*[@ data-id=\"1348\"]/label/input")
	private WebElement reg;
	
	public void clickReg() {
		this.reg.click(); 
	}


	//click publish
	@FindBy(id="publish")
	private WebElement publish;
	
	public void clickPublish() {
		this.publish.click(); 
	}
	

	public WebElement findPublish() {
		return publish; 
	}

	//click logout
		// on hover
	@FindBy(id="wp-admin-bar-my-account")
	private WebElement acct;

	public void hoverAccount() {
		Actions act= new Actions(driver);
		act.moveToElement(acct).perform();
	}

		
		//logout 
	@FindBy(id="wp-admin-bar-logout")
	private WebElement logout;
	
	public void clickLogout() {
		this.logout.click(); 
	}

	//click real-estate icon
	@FindBy(id="logo")
	private WebElement logo;
	
	public void clickRELogo() {
		this.logo.click(); 
	}

	//search added property
	@FindBy(xpath ="//*[@class=\"orig\"]")
	private WebElement searchText;
	
	public void enterSearch(String inputSearchString) {
		this.searchText.clear(); 
		this.searchText.sendKeys(inputSearchString);			
	}
	@FindBy(id="mCSBap_1_container")
	private WebElement search ;
	
	public void clickSearch() {
		this.search.click(); 
	}
	
	@FindBy(xpath="//*[@class=\"property-title\"]/h2")
	private WebElement assertActual;
	
	public String getTitle() {
		return this.assertActual.getText();
	}
	
	

}




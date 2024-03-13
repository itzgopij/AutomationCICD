package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By countryNames = By.cssSelector(".ta-results");
	
	
	@FindBy(css="button[class*='ta-item']:last-of-type")
	WebElement selectCountry;
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public void country(String countryName) {
		
		country.sendKeys(countryName);
	}
	
	public void selectCountry() {
		waitForElementToAppear(countryNames);
		selectCountry.click();
		
	}
	public  FinalPage placeOrder() { 
		javaScript();
		placeOrder.click();
		return new FinalPage(driver);
	}

	
	
	
	
	

}

package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	 
	public LandingPage(WebDriver driver) { 
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(css="#login")
	WebElement submit;
	
	@FindBy(css="div[class*=flyInOut]")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		return new ProductCatalogue(driver);
	}
	 
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

 }




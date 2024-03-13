package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class FinalPage  {
	
	 WebDriver driver;
	
	public FinalPage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="label[class*='star']")
	WebElement orderid;
	
	@FindBy(tagName="h1")
	WebElement text;

	
	
	public String getOrderId(){
		return orderid.getText();
	}

	public String Message() {
		String msg= text.getText();
		return msg;
		}
}

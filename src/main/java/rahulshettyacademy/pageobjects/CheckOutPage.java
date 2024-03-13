package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent  {
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	
  public List<WebElement> getSelectedProductsList() {
		return cartItems;
		
	}
	
	public boolean verifyProducts(String productName) {
		boolean flag = cartItems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return flag;
	}
	
	public ConfirmationPage goToConfirmationPage() {
		checkout.click();
		return new ConfirmationPage(driver);
		 
	}
	
	
}

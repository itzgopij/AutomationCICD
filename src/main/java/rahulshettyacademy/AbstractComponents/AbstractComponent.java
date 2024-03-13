package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.OrdersPage;

//we can write switching to frames, windows,tabs,javascript executor, alert handling,visibility waits,
// all we can write inside abstract components
public class AbstractComponent  {
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(css="button[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement OrdersPage;
	
	
	public CheckOutPage goToCartPage() {
		cartHeader.click();
		return new CheckOutPage(driver);
	}
	
	public OrdersPage goToOrdersPage() {
		OrdersPage.click();
		return new OrdersPage(driver);
	}
	
	public void actions() {
		Actions a = new Actions(driver);
	}
	public void javaScript() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement e) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(e));
	}
	
	
	
	public void waitForElementToDisappear(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		//WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		//w.until(ExpectedConditions.invisibilityOf(element));
	}
           
}

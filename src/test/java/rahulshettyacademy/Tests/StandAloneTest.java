package rahulshettyacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.FinalPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String productName = "ZARA COAT 3";
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productcatalogue = landingPage.loginApplication("gopij@gmail.com", "Gopinathj@123");
		//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement>products = productcatalogue.getProductsList();
		productcatalogue.addProductToCart(productName);
		 CheckOutPage cp= productcatalogue.goToCartPage();
	   // CheckOutPage cp = new CheckOutPage(driver);
	    List<WebElement> selectedProducts = cp.getSelectedProductsList();
	   Assert.assertTrue(cp.verifyProducts(productName));
	   ConfirmationPage cnfrmpg = cp.goToConfirmationPage();
	   //ConfirmationPage cnfrmpg = new ConfirmationPage(driver);
	   cnfrmpg.country("india");
	   cnfrmpg.selectCountry();
	   FinalPage fp = cnfrmpg.placeOrder();
	  // FinalPage fp =new FinalPage(driver);
	   String orderId = fp.getOrderId();
	   System.out.println(orderId);
	  String msg= fp.Message();
	  Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
	   driver.close();
	  
 }

 }

package rahulshettyacademy.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.FinalPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest { 

	@Test(groups= {"ErrorNandling"})
	public void errorLogin() throws IOException, InterruptedException {
 
		 landingPage.loginApplication("gopi1235j@gmail.com", "Gopinathj@456");
		String errorMsg = landingPage.getErrorMessage();
		
		Assert.assertEquals(errorMsg,"Incorrect email or password.");
  }
	
	@Test
	public void wrongProductValidation() throws InterruptedException {
		
		String productName = "ZARA COAT 3"; 
		//LandingPage lp = launchApplication();
		ProductCatalogue productcatalogue = landingPage.loginApplication("gopij@gmail.com", "Gopinathj@123");
		// ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getProductsList();
		productcatalogue.addProductToCart(productName);
		CheckOutPage cp = productcatalogue.goToCartPage();
		// CheckOutPage cp = new CheckOutPage(driver);
		List<WebElement> selectedProducts = cp.getSelectedProductsList(); 
		Assert.assertFalse(cp.verifyProducts("iphone"));
		
	}
	
	
 }

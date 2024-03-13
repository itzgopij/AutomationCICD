package rahulshettyacademy.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest { 
	String productName = "ZARA COAT 3";  
	
	@Test(dataProvider="getData",groups= {"purchase"},retryAnalyzer=rahulshettyacademy.TestComponents.Retry.class)
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
 
		
		
		//LandingPage lp = launchApplication();
		ProductCatalogue productcatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		// ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getProductsList();
		productcatalogue.addProductToCart(input.get("productName"));
		CheckOutPage cp = productcatalogue.goToCartPage();
		// CheckOutPage cp = new CheckOutPage(driver);
		List<WebElement> selectedProducts = cp.getSelectedProductsList(); 
		Assert.assertTrue(cp.verifyProducts(input.get("productName")));
		ConfirmationPage cnfrmpg = cp.goToConfirmationPage();
		// ConfirmationPage cnfrmpg = new ConfirmationPage(driver);
		cnfrmpg.country("india");
		cnfrmpg.selectCountry();
		FinalPage fp = cnfrmpg.placeOrder();
		// FinalPage fp =new FinalPage(driver);
		String orderId = fp.getOrderId();
		System.out.println("Order Id is "+orderId);
		String msg = fp.Message();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		
		
	}
	
	//@Test(dependsOnMethods={"submitOrder"})
		public void orderHistoryTest() {
		
		ProductCatalogue productcatalogue = landingPage.loginApplication("gopij@gmail.com", "Gopinathj@123");
		OrdersPage orderspage =  productcatalogue.goToOrdersPage();
		Assert.assertTrue(orderspage.verifyOrdersDisplay(productName));
		
 }
	@DataProvider
	public Object[][] getData() throws IOException {
		
		 /* HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("email", "gopij@gmail.com");
		map.put("password", "Gopinathj@123");
		map.put("productName", "ZARA COAT 3");
		
        HashMap<String,String> map1 = new HashMap<String,String>();
		
		map1.put("email", "adithya123@gmail.com");
		map1.put("password", "Adithya@123");
		map1.put("productName", "ADIDAS ORIGINAL"); */
		
		List<HashMap<String,String>> data =  getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	

 }

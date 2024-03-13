package rahulshettyacademy.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.FinalPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImplementation extends BaseTest {
	public LandingPage landinpage;
	public ProductCatalogue productcatalogue;
	public CheckOutPage cp;
	public ConfirmationPage cnfrmpg;
	public FinalPage fp;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		  landinpage =launchApplication();
	}
	
	@Given("^Logged in with username (.+)  and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password) {
		productcatalogue = landingPage.loginApplication(username,password);
	}

	 @When("^I add product (.+) to cart$")
		 public void I_add_product_to_cart(String productName) throws InterruptedException {
		 List<WebElement> products = productcatalogue.getProductsList();
			productcatalogue.addProductToCart(productName);
	 }
	 
	 @And("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_the_order(String productName ) {
		  cp = productcatalogue.goToCartPage();
			List<WebElement> selectedProducts = cp.getSelectedProductsList(); 
			Assert.assertTrue(cp.verifyProducts(productName));
			cnfrmpg = cp.goToConfirmationPage();
			
			cnfrmpg.country("india");
			cnfrmpg.selectCountry();
			 fp = cnfrmpg.placeOrder();
	 }
	 
	 @Then ("{string} message is displayed on ConfirmationPage")
	 public void message_displayed_on_ConfirmationPage(String string) {
		 String orderId = fp.getOrderId();
			System.out.println("Order Id is "+orderId);
			String msg = fp.Message();
			Assert.assertEquals(msg,string);
			driver.close();	 }
	 
	 @Given("I landed on login page")
	 public void i_landed_on_login_page() throws IOException {
		 landinpage =launchApplication();
	 }

	 @When("^Login with username (.+) and password (.+)$")
	 public void login_with_username_and_password(String userName,String password) {
		 landingPage.loginApplication(userName, password);
	 }

	 @Then("{string} is displayed")
	 public void is_displayed(String string) {
		 String errorMsg = landingPage.getErrorMessage();
			
			Assert.assertEquals(errorMsg,string);
			driver.close();
	 }
	 
}

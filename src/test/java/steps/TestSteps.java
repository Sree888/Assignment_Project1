package steps;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import hooks.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.HookTestStep;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestSourceRead;
import pages.Ecommerce;
import pages.MagnetoHomePage;

public class TestSteps {
	static WebDriver driver;
	static Ecommerce ec = new Ecommerce(driver);
	static MagnetoHomePage mPage = new MagnetoHomePage(driver);
	
	
	@Given("user is opening the web browser")
	public void user_is_opening_the_web_browser() {
	    ec.openBrowser();
	}
	
	@Given("Navigate to the URL of {string}")
	public void navigate_to_the_url_of(String string) {
		ec.navigateToUrl(string);
	}
	
	@Then("Verify that the homepage of Amazon.in is displayed correctly.")
	public void verify_that_the_homepage_of_amazon_in_is_displayed_correctly() {
	    ec.verifyHomePage();
	}
	
	@When("user Click on the {string} button\\/link.")
	public void user_click_on_the_button_link(String string) {
	    ec.clickSigInButtonLandingPage();
	}
	
	@Then("user Enter valid login credentials")
	public void user_enter_valid_login_credentials() {
	    ec.enterCredentials();
	}
	
	@When("user Click on the {string} button.")
	public void user_click_on_the_button(String string) {
	    //real creadentials are not used
	}
	
	@When("Verify that the user is successfully logged in and redirected to the homepage.")
	public void verify_that_the_user_is_successfully_logged_in_and_redirected_to_the_homepage() {
	    ec.verifyLoginSuccess();
	}
	
	@Then("In the search bar, search {string}")
	public void in_the_search_bar_search(String string) {
	    ec.searchProduct(string);
	}
	
	@Then("verify the product text and price")
	public void verify_the_product_text_and_price() {
	    ec.verifyProduct();
	}
	
	////////////////////////
	
	@Then("verify user is on Landing page")
	public void verify_user_is_on_landing_page() {
		mPage.verifyLandingPage();
	}
	
	@Then("user clicks on {string} button")
	public void user_clicks_on_button(String string) {
	    mPage.clickButton(string);
	}
	
	@Then("verify user navigates to Create Account page")
	public void verify_user_navigates_to_create_account_page() {
	    mPage.verifyCreateAccountPage();
	}
	
	@Then("user enter following details:")
	public void user_enter_following_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String firstName = data.get(0).get("First Name");
		String lastName = data.get(0).get("Last Name");
		String email = data.get(0).get("Email");
		String password = data.get(0).get("Password");
		mPage.enterCreateAccountDetails(firstName,lastName,email,password);
	}
	
	@Then("user clicks on Create Account Button")
	public void user_clicks_on_create_account_button() {
	    try {
	    	String btnXp = "//span[contains(text(),'Create an Account')]//parent::button";
	    	DriverManager.getDriver().findElement(By.xpath(btnXp)).click();
	    	mPage.AddInfoLog("User Clicked to Create Account button");
	    }catch(Exception e) {
	    	mPage.AddFailLog("Failed to click Create Account button due to: "+e.getMessage());
	    }
	}
	
	@Then("verify user navigates to My account page")
	public void verify_user_navigates_to_my_account_page() {
	    mPage.verifyMyAccountPage();
	}
	
	@Then("verify the success message {string}")
	public void verify_the_success_message(String string) {
	    String actualMessageXp = "//div[contains(text(),'Thank you')]";
	    String actualMessage = DriverManager.getDriver().findElement(By.xpath(actualMessageXp)).getText();
	    if(string.equals(actualMessage)) {
	    	mPage.AddPassLog("Message Matching. Expected: "+string+", Actual: "+actualMessage+"");
	    }else {
	    	mPage.AddFailLog("Message NOT Matching. Expected: "+string+", Actual: "+actualMessage+"");
	    }
	}
	
	@Then("verify the user details entered displaying correctly on My Account page")
	public void verify_the_user_details_entered_displaying_correctly_on_my_account_page() {
	    mPage.verifyDataInMyAccountPage();
	}
	
	@Then("verify user navigates to login page")
	public void verify_user_navigates_to_login_page() {
	    mPage.verifyLoginPage();
	}
	
	@Then("user enter login details:")
	public void user_enter_login_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		mPage.threadLocalHashMap.get().put("loginFirstName", data.get(0).get("First Name"));
		mPage.threadLocalHashMap.get().put("loginlastName", data.get(0).get("Last Name"));
		String email = data.get(0).get("Email");
		String password = data.get(0).get("Password");
		mPage.enterLoginDetails(email,password);
	}

	@Then("user click on sign in button")
	public void user_click_on_sign_in_button() {
		try {
	    	String btnXp = "(//span[contains(text(),'Sign In')]//parent::button)[1]";
	    	DriverManager.getDriver().findElement(By.xpath(btnXp)).click();
	    	mPage.AddInfoLog("User Clicked to Sign in button");
	    }catch(Exception e) {
	    	mPage.AddFailLog("Failed to click Sign in button due to: "+e.getMessage());
	    }
	}
	
	@Then("verify user login successfully")
	public void verify_user_login_successfully() {
		mPage.verifyUserLogin();
	}
	
	@Then("user enter following details for existing user:")
	public void user_enter_following_details_for_existing_user(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String firstName = data.get(0).get("First Name");
		String lastName = data.get(0).get("Last Name");
		String email = data.get(0).get("Email");
		String password = data.get(0).get("Password");
		mPage.enterCreateAccountDetailsExistingUser(firstName,lastName,email,password);
	}
	
	@Then("verify the error message displayed: {string}")
	public void verify_the_error_message_displayed(String string) {
	    mPage.verifyErrorMessage(string);
	}
	
	@Then("verify error message for invalid login: {string}")
	public void verify_error_message_for_invalid_login(String string) {
	    mPage.verifyInvalidLoginErrorMessage(string);
	}

}

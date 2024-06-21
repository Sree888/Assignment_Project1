package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import hooks.DriverManager;

public class Ecommerce {
	
	private WebDriver driver;

	public Ecommerce(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
	static String timeStamp = sdf.format(new Date());
	
	
	//locators 
	By landingpageLogo = By.xpath("//a[@href=\"/ref=nav_logo\"]");
	By landingpageSignInButton = By.xpath("(//a[contains(@href,'https://www.amazon.in/ap/signin?')])[1]");
	By emailInput = By.xpath("//input[@type=\"email\"]");
	By loginPageLogo = By.xpath("//a[@href=\"/ref=ap_frn_logo\"]");
	By searchInput = By.xpath("//input[@id=\"twotabsearchtextbox\"]");
	By searchButton = By.xpath("//input[@type=\"submit\"]");
	By resultIcon = By.xpath("//span[contains(text(),'Results')]");
	By resultElems = By.xpath("//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-2\"]");
	
	//methods
	 public void openBrowser() {
	        DriverManager.getDriver();
	        AddInfoLog("The browser is opened!");
	   }
	 
	 public void navigateToUrl(String url) {
		 DriverManager.getDriver().get(url);
		 AddInfoLog("User navigated to: "+url);
	 }
	 
	 public void verifyHomePage() {
		 waitForElement(DriverManager.getDriver(),landingpageLogo,10);
		 if(DriverManager.getDriver().findElement(landingpageLogo).isDisplayed()) {
			 AddPassLog("User Navigated to Landing page!");
		 }else {
			 AddFailLog("Failed to Navigate to Landing page!");
		 }
	 }
	 
	 public void clickSigInButtonLandingPage() {
		 DriverManager.getDriver().findElement(landingpageSignInButton).click();
		 AddInfoLog("User clicked on sign In Button");
	 }
	 
	 public void enterCredentials() {
		 waitForElement(DriverManager.getDriver(), emailInput,10);
		 DriverManager.getDriver().findElement(emailInput).sendKeys("test123@abc.com");
		 AddInfoLog("User Enters email: "+"test123@abc.com");
		 AddInfoLog("User enters password: "+"********");
	 }
	 
	 public void verifyLoginSuccess() {
		 DriverManager.getDriver().findElement(loginPageLogo).click();
		 waitForElement(DriverManager.getDriver(),landingpageLogo,10);
		 AddPassLog("User Login Success!");
	 }
	 
	 public void searchProduct(String product) {
		 DriverManager.getDriver().findElement(searchInput).sendKeys(product);
		 DriverManager.getDriver().findElement(searchButton).click();
		 AddInfoLog("User enter: '"+product+"' and click on search button");
	 }
	 
	 public void verifyProduct() {
		 waitForElement(DriverManager.getDriver(), resultIcon, 10);
		 List<WebElement> results = DriverManager.getDriver().findElements(resultElems);
		 String productName = "Samsung 80 cm (32 Inches) Wondertainment Series HD Ready LED Smart TV UA32T4340BKXXL (Glossy Black)";
		 String priceXp = "(//span[contains(text(),'"+productName+"')])[2]//parent::a//parent::h2//parent::div//parent::div/div[3]//span[@class=\"a-price\"]";
		 for(WebElement i:results) {
			 if(i.getText().contains(productName)) {
				 //get the name
				 String nameDisplayed = i.getText();
				 //get the price
				 String priceDisplayed = DriverManager.getDriver().findElement(By.xpath(priceXp)).getText();
				 AddPassLog("Product Name: "+nameDisplayed);
				 AddPassLog("Product Price: "+priceDisplayed);
				 System.out.println("Product Name: "+nameDisplayed);
				 System.out.println("Product Price: "+priceDisplayed);
			 }
			 break;
		 }
	 }
	 
	 public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	 
	 public static void AddFailLog(String string) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,"</font></span>"+"<span class=\"badge white-text transparent\"><font weight=\"bold\" color=\"red\" size=\"2\"> FAIL </font> - "+timeStamp+" - <font weight\"bold\" color\"Black\">"+string+"</font></span>");
		}
		
		public static void AddPassLog(String string) {
			ExtentCucumberAdapter.addTestStepLog("</font></span>"+"<span class=\"badge white-text transparent\"><font weight=\"bold\" color=\"green\" size=\"2\"> PASS </font> - "+timeStamp+" - <font weight\"bold\" color\"Black\">"+string+"</font></span>");
		}
		
		public static void AddInfoLog(String string) {
			ExtentCucumberAdapter.addTestStepLog("</font></span>"+"<span class=\"badge white-text transparent\"><font weight=\"bold\" color=\"Indigo\" size=\"2\"> INFO </font> - "+timeStamp+" - <font weight\"bold\" color\"Black\">"+string+"</font></span>");
		}
	
}

package pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import hooks.DriverManager;

public class MagnetoHomePage {

	
	private WebDriver driver;

	public MagnetoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
	static String timeStamp = sdf.format(new Date());
	public static ThreadLocal<Map<String, String>> threadLocalHashMap = ThreadLocal.withInitial(HashMap::new);
	
	
	//locators
	By landingPageLogo = By.xpath("//a[@class=\"logo\"]");
	By createAccountPageIcon = By.xpath("//span[normalize-space(text())='Create New Customer Account']");
	By firstNameInput = By.xpath("//input[@title=\"First Name\"]");
	By lastNameInput = By.xpath("//input[@title=\"Last Name\"]");
	By emailInputs = By.xpath("//input[@title=\"Email\"]");
	By passwordInput = By.xpath("//input[@title=\"Password\"]");
	By confirmPasswordInput = By.xpath("//input[@title=\"Confirm Password\"]");
	By myAccountPage = By.xpath("//span[normalize-space(text())='My Account']");
	By userDetails = By.xpath("//span[contains(text(),'Contact Information')]//parent::strong/following-sibling::div[1]");
	By loginPageLogo = By.xpath("//span[normalize-space(text())='Customer Login']");
	By loginUserProfile = By.xpath("(//li[@class=\"greet welcome\"]/span)[1]");
	By loginExistingMailMessage = By.xpath("//div[contains(text(),'email')]");
	By InvalidLoginMessage = By.xpath("//div[contains(text(),'incorrect')]");
	
	//methods
	 public void openBrowser() {
	        DriverManager.getDriver();
	        AddInfoLog("The browser is opened!");
	   }
	 
	 public void navigateToUrl(String url) {
		 DriverManager.getDriver().get(url);
		 AddInfoLog("User navigated to: "+url);
	 }
	 
	 public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	 
	 public void AddFailLog(String string) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,"</font></span>"+"<span class=\"badge white-text transparent\"><font weight=\"bold\" color=\"red\" size=\"2\"> FAIL </font> - "+timeStamp+" - <font weight\"bold\" color\"Black\">"+string+"</font></span>");
			System.err.println(timeStamp+" FAIL: "+string);
	 }
		
		public void AddPassLog(String string) {
			ExtentCucumberAdapter.addTestStepLog("</font></span>"+"<span class=\"badge white-text transparent\"><font weight=\"bold\" color=\"green\" size=\"2\"> PASS </font> - "+timeStamp+" - <font weight\"bold\" color\"Black\">"+string+"</font></span>");
			System.out.println(timeStamp+" PASS: "+string);
		}
		
		public void AddInfoLog(String string) {
			ExtentCucumberAdapter.addTestStepLog("</font></span>"+"<span class=\"badge white-text transparent\"><font weight=\"bold\" color=\"Indigo\" size=\"2\"> INFO </font> - "+timeStamp+" - <font weight\"bold\" color\"Black\">"+string+"</font></span>");
			System.out.println(timeStamp+" INFO: "+string);
		}
		
		
		/////////////////////////////////
		
		public void verifyLandingPage() {
			try {
			waitForElement(DriverManager.getDriver(),landingPageLogo,10);
			AddPassLog("User successfully navigated to Landing page");
			}catch(NoSuchElementException e) {
				AddFailLog("Failed to navigate Landing page due to: "+e.getMessage());
			}
		}
		
		public void clickButton(String btn) {
			try {
				String btnXp = "(//a[normalize-space(text())='"+btn+"'])[1]";
				waitForElement(DriverManager.getDriver(),By.xpath(btnXp),10);
				DriverManager.getDriver().findElement(By.xpath(btnXp)).click();
				AddInfoLog("User clicked on "+btn+" button");
			}catch(Exception e) {
				AddFailLog("Failed to click on "+btn+" button due to: "+e.getMessage());
			}
		}
		
		public void verifyCreateAccountPage() {
			try {
				waitForElement(DriverManager.getDriver(),createAccountPageIcon,10);
				AddPassLog("User successfully navigated to Create Account page");
			}catch(Exception e) {
				AddFailLog("Failed to navigate Create Account page due to: "+e.getMessage());
			}
		}
		
		public void enterCreateAccountDetails(String firstName,String lastName,String email,String password) {
			try {
				DriverManager.getDriver().findElement(firstNameInput).sendKeys(firstName);
				AddInfoLog("User Entered firstName: "+firstName);
				threadLocalHashMap.get().put("firstname", firstName);
				
				DriverManager.getDriver().findElement(lastNameInput).sendKeys(lastName);
				AddInfoLog("User Entered lastName: "+lastName);
				threadLocalHashMap.get().put("lastname", lastName);
				
				String emailNew = generateRandomCharacters()+email; //to prevent same user create multiple
				DriverManager.getDriver().findElement(emailInputs).sendKeys(emailNew);
				AddInfoLog("User Entered email: "+lastName);
				threadLocalHashMap.get().put("email", emailNew);
				
				DriverManager.getDriver().findElement(passwordInput).sendKeys(password);
				AddInfoLog("User Entered password: ********");
				
				DriverManager.getDriver().findElement(confirmPasswordInput).sendKeys(password);
				AddInfoLog("User Entered confirm password: ********");
				
				AddPassLog("User Entered the Create Account form details");
			}catch(Exception e) {
				AddFailLog("Fail to Enter the Create Account form details due to: "+e.getMessage());
			}
		}
		
		public void enterCreateAccountDetailsExistingUser(String firstName,String lastName,String email,String password) {
			try {
				DriverManager.getDriver().findElement(firstNameInput).sendKeys(firstName);
				AddInfoLog("User Entered firstName: "+firstName);
				threadLocalHashMap.get().put("firstname", firstName);
				
				DriverManager.getDriver().findElement(lastNameInput).sendKeys(lastName);
				AddInfoLog("User Entered lastName: "+lastName);
				threadLocalHashMap.get().put("lastname", lastName);
				
				DriverManager.getDriver().findElement(emailInputs).sendKeys(email);
				AddInfoLog("User Entered email: "+lastName);
				threadLocalHashMap.get().put("email", email);
				
				DriverManager.getDriver().findElement(passwordInput).sendKeys(password);
				AddInfoLog("User Entered password: ********");
				
				DriverManager.getDriver().findElement(confirmPasswordInput).sendKeys(password);
				AddInfoLog("User Entered confirm password: ********");
				
				AddPassLog("User Entered the Create Account form details");
			}catch(Exception e) {
				AddFailLog("Fail to Enter the Create Account form details due to: "+e.getMessage());
			}
		}
		
		public void verifyMyAccountPage() {
			try {
				waitForElement(DriverManager.getDriver(),myAccountPage,10);
				AddPassLog("User successfully navigated to My Account page");
				}catch(NoSuchElementException e) {
					AddFailLog("Failed to navigate My Account page due to: "+e.getMessage());
				}
		}
		
		public void verifyDataInMyAccountPage() {
			try {
				String userDetailsUI = DriverManager.getDriver().findElement(userDetails).getText();
				//verify firstname
				if(userDetailsUI.contains(threadLocalHashMap.get().get("firstname"))) {
					AddPassLog("First Name verified");
				}else {
					AddPassLog("First Name not available");
				}
				if(userDetailsUI.contains(threadLocalHashMap.get().get("lastname"))) {
					AddPassLog("Last Name verified");
				}else {
					AddPassLog("Last Name not available");
				}
				if(userDetailsUI.contains(threadLocalHashMap.get().get("email"))) {
					AddPassLog("email verified");
				}else {
					AddPassLog("email not available");
				}
				DriverManager.quitDriver();
			}catch(Exception e) {
				AddFailLog("Failed to verify data in My Account page due to: "+e.getMessage());
				DriverManager.quitDriver();
			}
		}
		
		public String generateRandomCharacters() {
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < 3; i++) {
	            char randomChar = (char) (random.nextInt(26) + 'a');
	            sb.append(randomChar);
	        }

	        return sb.toString();
	    }
		
		
		public void verifyLoginPage() {
			try {
				waitForElement(DriverManager.getDriver(),loginPageLogo,10);
				AddPassLog("User successfully navigated to Login page");
				}catch(NoSuchElementException e) {
					AddFailLog("Failed to navigate Login page due to: "+e.getMessage());
				}
		}
		
		public void enterLoginDetails(String email, String password) {
			try {
				DriverManager.getDriver().findElement(emailInputs).sendKeys(email);
				AddInfoLog("Entered email: "+email);
				
				DriverManager.getDriver().findElement(passwordInput).sendKeys(password);
				AddInfoLog("Entered password ********");
			}catch(Exception e) {
				AddFailLog("Failed to enter user credentials due to: "+e.getMessage());
			}
		}
		
		public void verifyUserLogin() {
			 try {
				 	waitForElement(DriverManager.getDriver(),loginUserProfile,10);
				 	Thread.sleep(3000);
			    	String profileIconData = DriverManager.getDriver().findElement(loginUserProfile).getText();
			    	if(profileIconData.contains(threadLocalHashMap.get().get("loginFirstName"))) {
			    		AddPassLog("First Name Displayed: "+threadLocalHashMap.get().get("loginFirstName"));
			    	}else {
			    		AddFailLog("First Name NOT Displayed: "+threadLocalHashMap.get().get("loginFirstName"));
			    	}
			    	
			    	if(profileIconData.contains(threadLocalHashMap.get().get("loginlastName"))) {
			    		AddPassLog("Last Name Displayed: "+threadLocalHashMap.get().get("loginlastName"));
			    	}else {
			    		AddFailLog("Last Name NOT Displayed: "+threadLocalHashMap.get().get("loginlastName"));
			    	}
			    	DriverManager.quitDriver();
			    }catch(Exception e) {
			    	AddFailLog("Validation fail due to: "+e.getMessage());
			    	DriverManager.quitDriver();
			    }
		}
		
		public void verifyErrorMessage(String message) {
			try {
				waitForElement(DriverManager.getDriver(),loginExistingMailMessage,10);
				Thread.sleep(2000);
				String actualText = DriverManager.getDriver().findElement(loginExistingMailMessage).getText();
				if(message.equals(actualText)) {
					AddPassLog("Existing user registration fail message is matching: "+message);
				}else {
					AddFailLog("Error message mismatch. Expected: "+message+", Actual: "+actualText);
				}
				DriverManager.quitDriver();
			}catch(Exception e) {
				AddFailLog("Validation failed due to: "+e.getMessage());
				DriverManager.quitDriver();
			}
		}
		
		public void verifyInvalidLoginErrorMessage(String message) {
			try {
				waitForElement(DriverManager.getDriver(),InvalidLoginMessage,10);
				Thread.sleep(2000);
				String actualText = DriverManager.getDriver().findElement(InvalidLoginMessage).getText();
				if(message.equals(actualText)) {
					AddPassLog("Invalid login error message is matching: "+message);
				}else {
					AddFailLog("Error message mismatch. Expected: "+message+", Actual: "+actualText);
				}
				DriverManager.quitDriver();
			}catch(Exception e) {
				AddFailLog("Validation failed due to: "+e.getMessage());
				DriverManager.quitDriver();
			}
		}
}

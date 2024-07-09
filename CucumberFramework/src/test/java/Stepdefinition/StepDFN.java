package Stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.CustomerAddNewPage;
import PageObjectModel.LoginPage;
import PageObjectModel.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDFN extends BaseClass{

	@Before
	public void SetUp() {
		System.out.println("Setup method executed");
		driver = new ChromeDriver();
	}


	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		driver = new ChromeDriver();
		loginpg = new LoginPage(driver);
		Addcustomer = new CustomerAddNewPage(driver);
		searchCustomerpg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pass) {

		loginpg.EnterMail(email);
		loginpg.EnterPass(pass);
	}

	@When("Click login button")
	public void click_login_button() {

		loginpg.ClickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String ExpectedTitle) {

		String ActualTitle = driver.getTitle();

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {

		loginpg.ClickLogout();
	}

	@Then("close browser")
	public void close_browser() {

		driver.close();
		driver.quit();
	}

	//////////////////////// Add new Customer////////////////////////////////

	@Then("User can view dashboard")
	public void user_can_view_dashboard() {

		String Actual = Addcustomer.getPageTitle();
		String Expected = "Dashboard / nopCommerce administration";
		Assert.assertEquals(Actual, Expected);

	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() {
		Addcustomer.ClickCustomerMenu();
	}

	@When("click on customer menu item")
	public void click_on_customer_menu_item() {
		Addcustomer.ClickMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {

		Addcustomer.ClickAddNewButton();
	}

	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		String ActualTitle = Addcustomer.getPageTitle();
		String ExpectedTitle = "Add a new customer / nopCommerce administration";
		Assert.assertEquals(ActualTitle , ExpectedTitle);

	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		
		Addcustomer.enterMail(GenerateEmailID() + "@gmail.com");
		//Addcustomer.enterMail("seela7@gmail.com");
		Addcustomer.enterPassword("seela@1");
		Addcustomer.enterfname("Seela");
		Addcustomer.enterlname("Charu");
		Addcustomer.SelectGender();
		Addcustomer.EnterCompName("XYZ Limited");
		Addcustomer.selectDob("01/02/2001");
		Addcustomer.EnterComment("Hello");
		Addcustomer.EnterVendor();
		
	}

	@When("click on Save button")
	public void click_on_save_button() {
		Addcustomer.ClickSavebutton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String Expected) {

		String bodyTag = driver.findElement(By.tagName("Body")).getText();
		if(bodyTag.contains(Expected)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	//////////////////////////////Search by Email////////////////////////////////	
		
	}
	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCustomerpg.EnterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCustomerpg.ClickSearch();
	}
	
	@When("Close browser")
	public void close_browser1() {
		driver.close();
	}
	
	//////////////////Search By Name////////////////////////////
	
	@When("Enter customer Firstname")
	public void enter_customer_firstname() {
		searchCustomerpg.EnterFname("Victoria");
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() {
		searchCustomerpg.EnterLname("Terces");
	}

	//Hooks
   /* @After
    public void TearDown(Scenario sc) throws IOException {
    	System.out.println("Tear down method executed");
    	
    	if(sc.isFailed()==true) {
    		
    		TakesScreenshot ts = ((TakesScreenshot)driver);
    		File src = ts.getScreenshotAs(OutputType.FILE);
    		File trg = new File("C:\\Workspace\\CucumberFramework\\Screenshot\\FailedTC.png");
    		
    		FileUtils.copyFile(src, trg);
    		
    	}
    	driver.quit();
    }*/
	
	@AfterStep
	public void addScreenshot(Scenario sc) {
		
	if(sc.isFailed()) {
	final byte[] screenshot  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
    sc.attach(screenshot, "image/png", sc.getName());	
		
	}
			
		}

	}

	


	



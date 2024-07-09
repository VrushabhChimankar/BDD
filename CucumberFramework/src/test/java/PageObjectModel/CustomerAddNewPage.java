package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerAddNewPage {

	WebDriver driver;

	public CustomerAddNewPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	// Find elements on the webpage
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement Customer_menu;
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement Customer_list;
	@FindBy(xpath = "//a[normalize-space()='Add new']")
	WebElement Addnewbtn;
	@FindBy(id = "Email")
	WebElement emailadd;
	@FindBy(id = "Password")
	WebElement pass;
	@FindBy(id = "FirstName")
	WebElement fname;
	@FindBy(id = "LastName")
	WebElement lname;
	@FindBy(id = "Gender_Male")
	WebElement selectMale;
	@FindBy(id = "DateOfBirth")
	WebElement SelectDOB;
	@FindBy(id = "Company")
	WebElement company;
	@FindBy(xpath = "//li[text()='Administrators']")
	WebElement ListAdministrators;
	@FindBy(id = "VendorId")
	WebElement DropdownVendor;
	@FindBy(xpath = "//li[text()='Test store 2']")
	WebElement ListTestStore;
	@FindBy(id = "AdminComment")
	WebElement Entercomment;
	@FindBy(name = "save")
	WebElement Savebtn;

	// Actions Method for web Elements

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void ClickCustomerMenu() {
		Customer_menu.click();
	}

	public void ClickMenuItem() {
		Customer_list.click();
	}

	public void ClickAddNewButton() {
		Addnewbtn.click();

	}

	public void enterMail(String entermail) {
		emailadd.sendKeys(entermail);
	}
	
	public void enterPassword(String pwd) {
		pass.sendKeys(pwd);
	}
	

	public void enterfname(String firstname) {
		fname.sendKeys(firstname);
	}

	public void enterlname(String lastname) {
		lname.sendKeys(lastname);
	}

	public void selectDob(String dob) {
		SelectDOB.sendKeys(dob);
	}

	public void EnterCompName(String compName) {
		company.sendKeys(compName);
	}
	public void SelectGender() {
		selectMale.click();
	}

	public void EnterVendor() {
		Select select = new Select(DropdownVendor);
		select.selectByVisibleText("Vendor 1");

	}

	public void EnterComment(String entercomment) {
		Entercomment.sendKeys(entercomment);
	}

	public void ClickSavebutton() {
		Savebtn.click();
	}
}

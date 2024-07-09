package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver driver;

	public SearchCustomerPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "SearchEmail")
	WebElement EmailAdd;
	@FindBy(id = "search-customers")
	WebElement SearchBtn;
	@FindBy(id = "SearchFirstName")
	WebElement Fname;
	@FindBy(id = "SearchLastName")
	WebElement Lname;

	// Action method to enter mail and click on search button
	public void EnterEmailAdd(String email) {

		EmailAdd.sendKeys(email);
	}

	public void ClickSearch() {
		SearchBtn.click();
	}

	public void EnterFname(String firstname) {
		Fname.sendKeys(firstname);
	}

	public void EnterLname(String lastname) {
		Lname.sendKeys(lastname);
	}

}

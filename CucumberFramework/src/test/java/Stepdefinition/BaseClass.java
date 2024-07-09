package Stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjectModel.CustomerAddNewPage;
import PageObjectModel.LoginPage;
import PageObjectModel.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginpg;
	public CustomerAddNewPage Addcustomer;
	public SearchCustomerPage searchCustomerpg;
	
	public String GenerateEmailID() {
		return RandomStringUtils.randomAlphabetic(5);
		
	}
}

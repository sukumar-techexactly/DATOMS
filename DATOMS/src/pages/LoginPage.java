package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import generic.BaseTest;

/*
 * LoginPage class use Page Object Model framework to avoid stale element reference exception
 * This class have all page element and action method of that page
 * and This method call by Test script class
 */

public class LoginPage extends BaseTest{
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement Email_Address;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@id='form_submit_btn']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[@id='show_message']")
	private WebElement ErrorMessage;
	
	
	public LoginPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	

	public void enterLoginCredentail(String email,String pwd) {
		Email_Address.sendKeys(email);
		Password.sendKeys(pwd);
		LoginButton.click();
	}
	
	public void verifyErrorMessage() {
		String ActaulMessage = ErrorMessage.getText();
		String ExpectedMessage="Email id does not exist!";
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfAllElements(ErrorMessage));
		Assert.assertEquals(ActaulMessage, ExpectedMessage, "If both actaul and expected math it will pass the test case otherwise fail the test case");
		
	}

}


package scripts;

import org.testng.annotations.Test;
import generic.BaseTest;
import pages.LoginPage;

/*
 * This is test script class use TestNG framework anotation @Test
 */

public class LoginWithInvalidCredentail extends BaseTest{
	
	@Test
	public void loginTest() {
		String InvalidEmailID = "sukumar11cs54@gmail.com";
		String InvalidPassword = "test@123!";
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginCredentail(InvalidEmailID, InvalidPassword);
		lp.verifyErrorMessage();
	}

}

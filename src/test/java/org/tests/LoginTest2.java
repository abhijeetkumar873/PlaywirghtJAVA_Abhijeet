package org.tests;

import org.base.BaseTest;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseTest {
	@Test
	public void loginPassTest() {

		LoginPage loginpage = new LoginPage(page);
		HomePage homepage = new HomePage(page);
		test.info("Nevagiting to URL");
		loginpage.navigateURL();
		test.info("Entering valid Username and password");
		loginpage.addUserName("Admin");
		loginpage.addPassword("admin123");
		loginpage.clickLoginButton();
		test.info("login succssfully");
		homepage.clickLeaveLink();

	}

	@Test(priority = 1)
	public void loginFailTest() {

		LoginPage loginpage = new LoginPage(page);
		//HomePage homepage = new HomePage(page);
		test.info("Nevagiting to URL");
		loginpage.navigateURL();
		test.info("Entering Invalid Username and password");
		loginpage.addUserName("Admin");
		loginpage.addPassword("admin1234");
		loginpage.clickLoginButton();
		
	}

	@Test
	public void loginSkipTest() {

		throw new SkipException("Skipping this test case");
	}

}

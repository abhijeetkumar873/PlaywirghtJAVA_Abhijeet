package org.tests;

import org.base.BaseTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginTest extends BaseTest {
	@Test
	public void test() {
		page.setDefaultTimeout(60000);
		page.setDefaultNavigationTimeout(60000);

		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).waitFor();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("Admin");
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard")).waitFor();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave")).waitFor();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave")).click();

	}

}

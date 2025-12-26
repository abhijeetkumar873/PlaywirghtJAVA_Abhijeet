package org.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
	// Locators
	private Page page;
//	private final String userNameTextBox = "getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(\"Username\"))";
//	private final String passwordTextBox = "getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(\"Password\"))";
//	private final String loginButton = "getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(\"Login\"))";

	private final String userNameTextBox = "input[name='username']";
	private final String passwordTextBox = "input[name='password']";
	private final String loginButton = "button[type='submit']";

	// Constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// Navigate URL
	public void navigateURL() {
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	// Page Actions
	public void addUserName(String username) {
		page.fill(userNameTextBox, username);
	}

	public void addPassword(String password) {
		page.fill(passwordTextBox, password);
	}

	public void clickLoginButton() {
		page.click(loginButton);
	}

	public void login(String username, String password) {
		page.fill(userNameTextBox, username);
		page.fill(userNameTextBox, password);
		page.click(loginButton);
	}

}

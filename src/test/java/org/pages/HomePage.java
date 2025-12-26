package org.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	// private final String leaveLink = "getByRole(AriaRole.LINK, new
	// Page.GetByRoleOptions().setName(\"Leave\"))";
	private final String leaveLink = "//span[normalize-space()='Leave']";

	public HomePage(Page page) {
		this.page = page;

	}

	public void clickLeaveLink() {
		page.click(leaveLink);
	}
}

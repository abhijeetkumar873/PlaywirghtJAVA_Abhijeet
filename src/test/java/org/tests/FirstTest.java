package org.tests;

import org.base.BaseTest;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

	@Test
	public void verifyTitle() {
		page.navigate("https://playwright.dev");
		System.out.println("The Page Title is : " + page.title());
	}

}

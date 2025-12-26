package org.base;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.utils.ExtentManager;
import org.utils.ScreenshotUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeMethod
	public void setUp(Method method) {

		// Reporting
		extent = ExtentManager.getInstance();
		test = extent.createTest(method.getName());

		// Playwright setup
		playwright = Playwright.create();
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
		page = browser.newPage();
		//page.setDefaultTimeout(5000);
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Reporting Logic

		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
			test.fail("login Failed");
			
			
			// Capture Screenshot
			
			String screenshotPath = ScreenshotUtil.takeScreenshot(page, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
			//test.addScreenCaptureFromBase64String(screenshotPath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test Case passed");
		} else {
			test.skip("Test Case Skipped");
		}
		extent.flush();

		if (browser != null)
			browser.close();
		if (playwright != null)
			playwright.close();

	}

}

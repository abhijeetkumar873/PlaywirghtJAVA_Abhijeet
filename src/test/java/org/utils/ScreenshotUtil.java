package org.utils;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class ScreenshotUtil {
	public static String takeScreenshot(Page page, String testName) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = "test-output/Screenshots/" + testName + "_" + timestamp + ".png";
		
		String projectPath = System.getProperty("user.dir");
		String absoluePath = projectPath +"/"+path;
		
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return absoluePath;

	}

}

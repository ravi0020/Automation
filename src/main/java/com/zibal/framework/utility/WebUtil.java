package com.zibal.framework.utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.codeborne.selenide.ex.InvalidStateException;

public class WebUtil {

	/**
	 * All generic Method Related to Web
	 */

	public static WebDriver driver;

	
	/**
	 * Launch Browser window
	 * @param browserName
	 */
	public static  void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./driver\\chromedriver.exe");

			driver = new ChromeDriver();

			Reporter.log("Chrome Browser is Successfully launched");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./driver\\geckodriver.exe");

			driver = new FirefoxDriver();

			Reporter.log("firefox Browser is Successfully launched");

		} else if (browserName.equalsIgnoreCase("internet explorer")) {

			System.setProperty("webdriver.ie.driver", "./driver\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();

			Reporter.log("IE Browser is Successfully launched");
		} else {

			Assert.fail(
					"Entered browser Name is wrong Please correct browser name i.e. chrome, firefox, internet explorer");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	/**
	 * open Url 
	 * @param url
	 */
	public static void openUrl(String url) {

		driver.get(url);

		Reporter.log(url + " url is successfully open");
	}

	/**
	 * click on element
	 * @param element
	 * @param msg
	 */
	public static void click(WebElement element) {

		element.click();
		
	}

	/**
	 * get javaScript Executor
	 * @param NA            
	 */
	public static JavascriptExecutor getJavaScriptExecutor() {
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		
		return javascriptExecutor;
	}

	/**
	 * Scroll element into view.
	 * @param  element         
	 */
	public static void scrollIntoView(WebElement element) {
		
		try {
			getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
			Reporter.log("Scroll into element"+element+" view ");
			
		} catch (Exception e) {
			Assert.fail("Element " + element + " not found.");
		}
	}
	
	/**
	 * Forces click on an element that is otherwise invisible to WebDriver due to
	 * hidden attribute or other issue.
	 * @param  element
	 */
	public static void jsClick(WebElement element) {
		try {
			getJavaScriptExecutor().executeScript("arguments[0].click();", element);
			
		} catch (Exception | InvalidStateException e) {
			Assert.fail("Element " + element + " not found.");
		}
	}
	
	/**
	 * action click on an element that is otherwise invisible to WebDriver due to
	 * hidden attribute or other issue.
	 * @param  element
	 */
	public static void actionClick(WebElement element) {
		try {
			getActions().click(element).perform();
			
		} catch (Exception | InvalidStateException e) {
			Assert.fail("Element " + element + " not found.");
		}
	}

	/**
	 * Try multiple ways of clicking into an element
	 * @param webElement
	 */
	public static void superClick(WebElement webElement) {
		try {
			
			scrollIntoView(webElement);
			webElement.click();
		} catch (InvalidStateException e) {

			scrollIntoView(webElement);
			jsClick(webElement);
		}
	}
	
	/**
	 * Fill Value in the Text Box
	 * @param textBox
	 * @param value
	 */
	public static void fillTextBox(WebElement textBox, String value) {
		try {
			if (textBox.getAttribute("value").equals(value))
				return;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		textBox.clear();
		textBox.sendKeys(value);
	}
	
	/**
	 * get action object
	 * @return action
	 */
	public static Actions getActions(){
		
		return new Actions(driver);
		
	}

	
}

package com.zibal.framework.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitUtil {
	
	
	
	
	/**
	 * wait till element visible
	 * @param element
	 */
	public static WebElement waitUntillElementPresent(WebElement element){
		
	WebElement	element2=new WebDriverWait(WebUtil.driver, 20).until(ExpectedConditions.visibilityOf(element));
		 return element2;
		
	}
	
	/**
	 * wait till element clickable
	 * @param element
	 */
	public static WebElement waitUntillElementClickable(WebElement element){
		
		WebElement	element2=new WebDriverWait(WebUtil.driver, 20).until(ExpectedConditions.elementToBeClickable(element));
			 return element2;
			
	}
	
	/**
	 * wait till element disappear
	 * @param element
	 * @return boolean
	 */
	public static boolean waitUntillElementDisappear(WebElement element){
		
		boolean status=new WebDriverWait(WebUtil.driver, 10).until(ExpectedConditions.invisibilityOf(element));

		Assert.assertTrue(status);
		return status;
	}
	
	/**
	 *  wait till attribute not present
	 * @param element
	 * @param attribute
	 * @param value
	 * @return
	 */
	public static boolean waitUntillAttributeContains(WebElement element,String attribute,String value){
		
		boolean status=new WebDriverWait(WebUtil.driver, 20).until(ExpectedConditions.attributeContains(element, attribute, value));

		Assert.assertTrue(status);
		return status;
	}
	
	/**
	 *  wait till text not present
	 * @param element
	 * @param value
	 * @return
	 */
	public static boolean waitUntillTextPresent(WebElement element,String value){
		
		waitUntillElementPresent(element);
		
		boolean status=new WebDriverWait(WebUtil.driver, 20).until(ExpectedConditions.textToBePresentInElement(element, value));

		Assert.assertTrue(status);
		return status;
	}
}

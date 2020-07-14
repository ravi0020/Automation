package com.zibal.product.desktop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import com.zibal.framework.utility.WaitUtil;
import com.zibal.framework.utility.WebUtil;
import com.zibal.pages.generic.GenericMethods;

public class MacPage extends WebUtil {

	final By MAC_HEADER_SECTION	= By.xpath("//div[@id='product-category']//h2");	
	final By ADD_TO_CART_BUTTON	= By.xpath("//button[contains(@onclick,'cart')]");
	
	
	/**
	 * verify Mac product page loaded
	 * @return
	 */
	public MacPage verifyMacProductPageLoaded(){
		
		WaitUtil.waitUntillElementPresent(driver.findElement(MAC_HEADER_SECTION));
		
		String text=driver.findElement(MAC_HEADER_SECTION).getText();
		
		Assert.assertTrue(text.contains("Mac"),"Mac product page is not loaded");
		
		Reporter.log("Mac product page is loaded successfully");
		return this;
	}
	
	/**
	 * click on mac product add to cart button 
	 * @return
	 */
	public MacPage clickOnAddtoCartButtonForIMac(){
		
		GenericMethods.clickOnAddToCartButton("iMac");
		return this;
		
	}
	
	
}

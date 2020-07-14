package com.zibal.product.phones_pdas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.zibal.framework.utility.WaitUtil;
import com.zibal.framework.utility.WebUtil;
import com.zibal.pages.generic.GenericMethods;


public class PhonesPDAsPage extends WebUtil{

	final By PHONES_AND_PDAS_LINK	= By.xpath("//aside[@id='column-left']//a[contains(text(),'Phones & PDAs')]");

	String phonesPDAsItemCount;
	
	
	/**
	 * verify phone & PDAs link displayed
	 * @return
	 */
	public PhonesPDAsPage verifyPhonesPDAsDisplayed(){
			
		WaitUtil.waitUntillElementPresent(driver.findElement(PHONES_AND_PDAS_LINK));
		
		Assert.assertTrue(driver.findElement(PHONES_AND_PDAS_LINK).isDisplayed(),"Phones & PDAs link is not displayed in left column list");
		Reporter.log("Phones & PDAs link is displayed in left column list");
		
		return this;
	}
	
	
	/**
	 * click on phone & PDAs link
	 * @return
	 */
	public PhonesPDAsPage clickOnPhonesPDAsLink(){
				
		WaitUtil.waitUntillElementPresent(driver.findElement(PHONES_AND_PDAS_LINK));
		
		superClick(driver.findElement(PHONES_AND_PDAS_LINK));
				
		Reporter.log("click on Phones & PDAS link from left column list");
		return this;
	}
	
	/**
	 * get PDAs link count item
	 * @return
	 */
	public PhonesPDAsPage getItemCountOfMacProduct(){
		

		WaitUtil.waitUntillElementPresent(driver.findElement(PHONES_AND_PDAS_LINK));
		
		phonesPDAsItemCount=driver.findElement(PHONES_AND_PDAS_LINK).getText();
		 
		return this;
	}
	
	/**
	 * click on Iphone Add to cart button
	 * @return
	 */
	public PhonesPDAsPage clickOnAddToCartButtonForIPhone(){
		
		GenericMethods.clickOnAddToCartButton("iPhone");
		return this;
	}
	
	/**
	 * verify product on page
	 * @return
	 */
	public PhonesPDAsPage verifyNoOfProductOnPage(){
			
		List<WebElement>totalProductDisplay=driver.findElements(By.xpath("//div[contains(@class,'product-layout')]"));
		
		int totalNoOfProduct=totalProductDisplay.size();
		
		Assert.assertTrue(phonesPDAsItemCount.contains(String.valueOf(totalNoOfProduct)),"displayed product no are not same as phonePdas item count");
		
		Reporter.log("displayed product no are same as phonePdas item count");
		
		return this;
	}
}

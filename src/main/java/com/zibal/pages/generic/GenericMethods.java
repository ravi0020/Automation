package com.zibal.pages.generic;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.zibal.framework.utility.WaitUtil;
import com.zibal.framework.utility.WebUtil;

public class GenericMethods {

	static WebDriver  driver	= WebUtil.driver;
	static By CART_BUTTON		= By.xpath("//div[@id='cart']//button[contains(@class,'inverse')]");
	static By VIEW_CART_LINK	= By.xpath("//p[@class='text-right']//a[1]");
	static By SUCCESS_MESSAGE	= By.xpath("//div[contains(@class,'alert-success')]");
	
	/**
	 * click on add to cart button of the product
	 * @param productName
	 */
	public static void clickOnAddToCartButton(String productName){
		
		
		WebElement product= driver.findElement(By.xpath(String.format("//a[text()='%s']/../../..//button[contains(@onclick,'cart')]", productName)));
		
		WaitUtil.waitUntillElementPresent(product);
		
		WebUtil.superClick(product);
		
		WaitUtil.waitUntillElementPresent(driver.findElement(SUCCESS_MESSAGE));
		
		Reporter.log("click on add to cart button for "+productName);
	}
	
	/**
	 * click on cart button from the top section
	 */
	public static void clickOnCartButton(){
		
		
		WebElement cartButton=WaitUtil.waitUntillElementPresent(driver.findElement(CART_BUTTON));
		
		WaitUtil.waitUntillElementClickable(cartButton);
		
		WebUtil.jsClick(cartButton);
		
		WaitUtil.waitUntillAttributeContains(cartButton,"aria-expanded","true");
		
		Reporter.log("click on cart button");
	}
	
	public static void verifyAddedCartItem(String[] addedProduct){
		
		boolean status= false;
		
		String attribute=driver.findElement(CART_BUTTON).getAttribute("aria-expanded");
		
		if(attribute.equalsIgnoreCase("false")){
			
			clickOnCartButton();
		}
		
		for(String text: addedProduct){
			
			status=driver.findElement(By.xpath(String.format("//td[normalize-space()='%s']/..",text))).isDisplayed();
		}
		
		Assert.assertTrue(status,addedProduct+" product are not added into cart");
		
		Reporter.log(addedProduct+" product are successfully added into cart");
		
	}
	
	public static void clickOnViewCartLink(){
		
		WebElement cartButton=WaitUtil.waitUntillElementPresent(driver.findElement(CART_BUTTON));
				
		String attribute=cartButton.getAttribute("aria-expanded");
		
		if(attribute.equalsIgnoreCase("false")){
			
			clickOnCartButton();
		}
		
		WebUtil.jsClick(WaitUtil.waitUntillElementPresent(driver.findElement(VIEW_CART_LINK)));
		
		Reporter.log("click on view cart link present on cart");
	}
	
	public static void verifyCartButtonUpdated(int quantity) throws InterruptedException{
		
		WebElement cartButton=WaitUtil.waitUntillElementPresent(driver.findElement(CART_BUTTON));

		Thread.sleep(2000);
		
		String cartText=cartButton.getText();
		
		Assert.assertTrue(cartText.contains(quantity+" item"),quantity+" quantity not updated in cart button current Quantity is "+cartText);
		
		Reporter.log(quantity+" quantity successfully updated in cart button");
	}
}

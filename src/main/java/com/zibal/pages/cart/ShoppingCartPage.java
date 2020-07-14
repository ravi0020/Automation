package com.zibal.pages.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.zibal.framework.utility.WaitUtil;
import com.zibal.framework.utility.WebUtil;

public class ShoppingCartPage extends WebUtil {
	
	
	final By CART_MODIFICATION_MESSAGE		= By.xpath("//div[contains(@class,'alert-success')]");
	
	/**
	 * update quantity of the product
	 * @param productName
	 * @param value
	 */
	private void updateQuantityForProduct(String productName ,String value){
				
		WebElement productRow=WaitUtil.waitUntillElementPresent(driver.findElement(By.xpath(String.format("//div[@id='checkout-cart']//a[normalize-space()='%s']/../..", productName))));
		
		fillTextBox(productRow.findElement(By.xpath(".//input")), value);
		
		superClick(productRow.findElement(By.xpath(".//button[@type='submit']")));
		
	}
	

	/**
	 * retrieve quantity data of product
	 * @param productName
	 * @return
	 */
	private String getQuantityofProducts(String productName){
		
		WebElement productRow=WaitUtil.waitUntillElementPresent(driver.findElement(By.xpath(String.format("//div[@id='checkout-cart']//a[normalize-space()='%s']/../..", productName))));

		String quantity=productRow.findElement(By.xpath(".//input")).getAttribute("value");
		
		return quantity;
		
	}
	
	/**
	 * click on remove button of the product
	 * @param productName
	 */
	private void clickOnRemoveButtonForProduct(String productName){
		
		WebElement productRow=WaitUtil.waitUntillElementPresent(driver.findElement(By.xpath(String.format("//div[@id='checkout-cart']//a[normalize-space()='%s']/../..", productName))));

		superClick(productRow.findElement(By.xpath(".//button[@data-original-title='Remove']")));
		
	}
	
	/**
	 * update quantity of iMac product
	 * @return
	 */
	public ShoppingCartPage updateQuantityForIMacProduct(){
		
		updateQuantityForProduct("iMac", "2");
		return this;
	}
	
	
	/**
	 * verify cart modification success message
	 * @return
	 */
	public ShoppingCartPage verifyCartModificationMessage(){
		
		String expMessage= "Success: You have modified your shopping cart!";
		
		WebElement cartModification=WaitUtil.waitUntillElementPresent(driver.findElement(CART_MODIFICATION_MESSAGE));
		
		String actMessage=cartModification.getText();
		
		Assert.assertTrue(actMessage.contains(expMessage),expMessage+" cart update success message not appear");
		
		Reporter.log(expMessage+" cart update success message appear and verify");
		
		return this;
	}
	
	/**
	 * verufy quantity update of Imac product
	 * @return
	 */
	public ShoppingCartPage verifyQuantityUpdatedofIMacProduct(){
		
		String quantity=getQuantityofProducts("iMac");
		
		Assert.assertTrue(quantity.equals("2"),"Quantity not updated for iMac products");
		
		Reporter.log("Quantity gets updated for Imac product on shopping cart page");
		return this;
	}
	
	/**
	 * click on remove button od IPhone product
	 * @return
	 */
	public ShoppingCartPage clickOnRemoveButtonForIPhone(){
		
		
		clickOnRemoveButtonForProduct("iPhone");
		
		Reporter.log("click on remove button of iPhone product on shopping cart page");
		return this;
	}
	
	/**
	 * verify  product not present in the table
	 * @param productName
	 */
	private void verifyProductNotListedInCart(String productName){
		
		boolean status=WaitUtil.waitUntillElementDisappear(driver.findElement(By.xpath(String.format("//div[@id='checkout-cart']//a[normalize-space()='%s']/../..", productName))));
		
		Assert.assertTrue(status,productName+"product are not removed from the cart table on shopping cart page");
		
		Reporter.log(productName+"product are successfully removed from the cart table on shopping cart page");
		
	}
	
	/**
	 * verify IPhone product removed from the table
	 * @return
	 */
	public ShoppingCartPage verifyIPhoneProductNotPresent(){
		
		verifyProductNotListedInCart("iPhone");
		
		return this;
	}
}

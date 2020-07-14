package com.zibal.framework.testScript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zibal.framework.utility.WebUtil;
import com.zibal.pages.cart.ShoppingCartPage;
import com.zibal.pages.generic.GenericMethods;
import com.zibal.pages.homepage.HomePage;
import com.zibal.product.phones_pdas.PhonesPDAsPage;


/***************************************************************************************************************************************
* TestCaseId:- 		TC001
* TestCaseDesc:- 	Verify if Add to Cart functionality is working
* Created By:- 		Ravi Kumar 
* Created Date:- 	07-July-2020
***************************************************************************************************************************************/


public class TC001  {

	@BeforeMethod
	@Parameters({"BROWSER","URL"})
	public void open(String BROWSER,String URL){
			
	WebUtil.openBrowser(BROWSER);
	WebUtil.openUrl(URL);
	
	}
		
	@AfterMethod
	public void close(){
		
		WebUtil.driver.close();
	}
		
	
@Test
public void validateAddCartFunctionality() throws InterruptedException{
	
		
// Step 1: Open Google Chrome browser
// Step 2: Go to Url: https://demo.opencart.com/
		
		// implement in above step
		
// Step 3: Mouse hover ‘Desktops’ link on navigation bar
		
	new HomePage().mouseHoverToMP3Player()
	
// Step 4: Click on item ‘Mac’ from list and store the count of available item for further use
	
				 .clickOnTest20();
				  
// Step 5. Verify if desired product page is open
				  
/*				  .verifyMacProductPageLoaded()
				  
// Step 6: Click on ‘Add to Cart’ button for the product ‘iMac’ (Create dynamic xpath in which you pass the product name, and also can reuse for another item)

				  .clickOnAddtoCartButtonForIMac();
	
// Step 7: Verify if in Cart button, Number of Item and price is getting reflected
	
	GenericMethods.verifyCartButtonUpdated(1);
	
// Step 8: Verify if link ‘Phones & PDAs’ is displayed on page
	
	new PhonesPDAsPage().verifyPhonesPDAsDisplayed()
	
// Step 9: Click on link ‘Phones & PDAs’ and store the count of available item for further use
	
						.getItemCountOfMacProduct()
						.clickOnPhonesPDAsLink()
	
// Step 10: Verify the number of products getting displayed on page against the stored count in Step 9	
						
						.verifyNoOfProductOnPage()
	
// Step 11: Click on ‘Add to Cart’ button for the product ‘iPhone’ (using dynamic xpath created in Step 5, don’t create new xpath)	
	
						.clickOnAddToCartButtonForIPhone();
						
// Step 12: Verify if updated item count and price on Cart button, is getting reflected
	
		GenericMethods.verifyCartButtonUpdated(2);
	
// Step 13: Click on Cart button and verify if Added items are listed with count and price
	
	
		GenericMethods.clickOnCartButton();
		GenericMethods.verifyAddedCartItem(new String[]{"iMac","iPhone"});
		
	
// Step 14: Click on ‘View Cart’ link
	
		GenericMethods.clickOnViewCartLink();
		
// Step 15: On Shopping cart page, Enter quantity ‘2’ for product ‘iMac’ and click on update button	
	
		new ShoppingCartPage().updateQuantityForIMacProduct()
		
// Step 16: Verify Shopping cart modification success message “Success: You have modified your shopping cart!”	
	
							  .verifyCartModificationMessage()
							  
// Step 17: Verify if new quantity is getting displayed in quantity column for ‘iMac’
	
							  .verifyQuantityUpdatedofIMacProduct()
							  
// Step 18: Click on Remove button for Product Name ‘IPhone’
	
							  .clickOnRemoveButtonForIPhone()
		
// Step 19: Verify if cart is updated and Removed product is not listed in cart
	
							  .verifyIPhoneProductNotPresent();
		
// Step 20: Verify if Cart button is updated with new item count and price	
		
		GenericMethods.verifyCartButtonUpdated(2);*/
		
	}
}

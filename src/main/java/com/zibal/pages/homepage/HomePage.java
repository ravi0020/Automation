package com.zibal.pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.zibal.framework.utility.WaitUtil;
import com.zibal.framework.utility.WebUtil;
import com.zibal.product.desktop.MacPage;

public class HomePage extends WebUtil{

	final By DESKTOP_BUTTON = By.xpath("//a[text()='Desktops']");
	final By MAC_BUTTON	= By.xpath("");
	final By MP3Player_BUTTON	= By.xpath("//a[contains(text(),'MP3 Player')]");
	
	
	public String macItemCount;
	
	
	/**
	 * click on mac link
	 * @return
	 */
	public MacPage clickOnMacIcon(){	
		
		WebElement macButton=WaitUtil.waitUntillElementPresent(driver.findElement(DESKTOP_BUTTON).findElement(By.xpath(".//..//li[2]//a")));
		
		click(macButton);
		
		WaitUtil.waitUntillElementDisappear(macButton);
		
		Reporter.log("click on mac icon button on homepage");
		return new MacPage();
	}
	
	/**
	 * move to the desktop link 
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage mouserHoverDesktopIcon() throws InterruptedException{
		
		WebElement desktoButton=WaitUtil.waitUntillElementPresent(driver.findElement(DESKTOP_BUTTON));
		
		Thread.sleep(2000);
		
		getActions().moveToElement(desktoButton).perform();
		
		Reporter.log("move to the desktop button on homepage");
		return this;
	}
	
	/**
	 * get count of mac product
	 * @return
	 */
	public HomePage getItemCountOfMacProduct(){
		
		WebElement macButton=driver.findElement(DESKTOP_BUTTON).findElement(By.xpath(".//..//li[2]//a"));

		WaitUtil.waitUntillElementPresent(macButton);
		 macItemCount=macButton.getText();
		 
		return this;
	}
	
	public HomePage mouseHoverToMP3Player(){
		
		WebElement mp3Player_link=WaitUtil.waitUntillElementPresent(driver.findElement(MP3Player_BUTTON));
		
		WebUtil.getActions().moveToElement(mp3Player_link).perform();
			
		return this;
	}
	
	public void clickOnTest20(){
		
		WebElement mp3Player_link=WaitUtil.waitUntillElementPresent(driver.findElement(MP3Player_BUTTON));

		WebElement test20Link=mp3Player_link.findElement(By.xpath("./..//a[contains(text(),'test 20')]"));
		
		
		WebUtil.superClick(test20Link);
		
	}
}
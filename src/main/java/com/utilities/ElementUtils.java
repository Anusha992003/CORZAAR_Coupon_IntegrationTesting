package com.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private final WebDriver driver;
	private final WebDriverWait wait;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtils.EXPLICIT_WAIT_TIME));

	}

	public WebElement waitForClick(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> element) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public Alert alertIsDisplayed() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void click(WebElement element) {
		WebElement webElement = waitForClick(element);
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().perform();
	}
	public void sendKeys(WebElement element, String value) {
		WebElement webElement =  wait.until(ExpectedConditions.elementToBeClickable(element));
		//webElement.click();
		webElement.clear();
		webElement.sendKeys(value);
	}
	public int getSize(List<WebElement>elements) {
		List<WebElement>webElements=waitForVisibilityOfAllElements(elements);
				return webElements.size();
	}
	public String getText(WebElement element) {
		WebElement webElement=waitForVisibility(element);
		return webElement.getText();
	}
	public String getAttribute(WebElement element,String attributename) {
		WebElement webElement=waitForVisibility(element);
		return webElement.getAttribute(attributename);

	}
	public void selectByValue(WebElement element,String value) {
		WebElement webElement=waitForVisibility(element);
		Select select=new Select(webElement);
		select.selectByValue(value);
	}
	public void selectByIndex(WebElement element, int  index) {
		WebElement webElement=waitForVisibility(element);
		Select select=new Select(webElement);
		select.selectByIndex(index);
	}
	public void selectByText(WebElement element,String value) {
		WebElement webElement=waitForVisibility(element);
		Select select=new Select(webElement);
		select.selectByVisibleText(value);
	}
	
	private String parentWindow;
	public void getParentWindow() {
		parentWindow = driver.getWindowHandle();
	}
	public void switchToNewWindow() {
		for (String window : driver.getWindowHandles()) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	public void switchBackToParentWindow() {
		driver.switchTo().window(parentWindow);
	}
	
	public String getTitle() {
 		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		 return driver.getCurrentUrl();
	}
	
	public boolean isDisplayed(WebElement element) {
		WebElement webElement=waitForVisibility(element);
		return webElement.isDisplayed();
	}
	
	public void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	
	public void  scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollintoView({block:'center'});",element);
	}
	public void clickVisibleElement(By locator) {
		List<WebElement>elements=driver.findElements(locator);
		for(WebElement element: elements) {
		if(element.isDisplayed()&&element.isEnabled()) {
			element.click();
			break;
		}
		}
		
	}
	public void clickElementByText(List<WebElement> elements, String text) {

	    for (WebElement element : elements) {

	        if (element.isDisplayed() && element.isEnabled()

	                && element.getText().trim().equals(text)) {

	            element.click();

	            break;

	        }

	    }

	}
}

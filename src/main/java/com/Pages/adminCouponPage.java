package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class adminCouponPage {
	
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public adminCouponPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement admin;
	
	@FindBy(id="super-admin-email")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pwdField;
	
	@FindBy(xpath="//span[text()='Authenticate Super-Admin']")
	private WebElement authBtn;
	
	@FindBy(id="enter-admin-2fa-code")
	private WebElement codeField;
	
	@FindBy(xpath="//span[text()='Authorize Administrative Session']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Coupons Approval']")
	private WebElement couponModule;
	
	@FindBy(xpath="//input[@placeholder=\"Search coupon codes...\"]")
	private WebElement searchField;
	
	@FindBy(xpath="//span[contains(@class,'font-mono text-xs font-bol')]")
	private WebElement verifyCouponDisplay;
	
	@FindBy(xpath="//span[text()='Reject']")
	private WebElement rejectBtn;
	
	@FindBy(xpath="//span[text()='Approve']")
	private WebElement approveBtn;
	
	@FindBy(xpath="//*[text()='Coupon status updated to approved.']")
	private WebElement apprMsg;
	
	@FindBy(xpath="//button[@title=\"Sign out\"]")
	private WebElement signOutBtn;
	
	public void adminLogin(String email,String pwd, String code) {
		elementUtils.click(signInBtn);
		//elementUtils.waitForVisibility(admin);
		elementUtils.click(admin);
		elementUtils.sendKeys(emailField, email);
		elementUtils.sendKeys(pwdField, pwd);
		elementUtils.click(authBtn);
		elementUtils.sendKeys(codeField, code);
		elementUtils.click(submitBtn);
	}
	
	public void searchCoupon() {
		elementUtils.click(couponModule);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchField));
		elementUtils.sendKeys(searchField, "FIRE2026");
	}
	
	public void verifyCouponDisplay() {
		String a=elementUtils.getAttribute(searchField, "value");
		//elementUtils.waitForVisibility(verifyCouponDisplay);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(verifyCouponDisplay));
		String b=elementUtils.getText(verifyCouponDisplay);
		Assert.assertEquals(a, b, "Search result is not matching");
	}
	
	public void approveCoupon() {
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		if(!approveBtn.isEmpty()) {
//			wait.until(ExpectedConditions.elementToBeClickable(approveBtn.get(0))).click();
//			
//		}
//		else {
//			if(!rejectBtn.isEmpty()) {
//				wait.until(ExpectedConditions.elementToBeClickable(rejectBtn.get(0))).click();
//			}
//		}
		if (approveBtn.isDisplayed()) {
			elementUtils.click(approveBtn);
		}
		else if(rejectBtn.isDisplayed()) {
			elementUtils.click(rejectBtn);
			elementUtils.click(approveBtn);
		}
		String d=elementUtils.getText(apprMsg);
		System.out.println("Message: "+d);
	}
	
	public void adminSignOut() {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles: true}));", signOutBtn);
		elementUtils.click(signOutBtn);
	}
	
	public void reject() {
		
		if(rejectBtn.isDisplayed()) {
			elementUtils.click(rejectBtn);
		}
		else if(approveBtn.isDisplayed()) {
			elementUtils.click(approveBtn);
			elementUtils.click(rejectBtn);
		}
	}
	
	
	
	
	

}
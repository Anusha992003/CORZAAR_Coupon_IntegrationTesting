package com.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class merchantCouponPage {
	
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public merchantCouponPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(xpath="//span[text()='Merchant']")
	private WebElement merchant;
	
	@FindBy(id="institute-manager-mobile-number")
	private WebElement mobileField;
	
	@FindBy(id="institute-contact-person-/-faculty-name")
	private WebElement nameField;
	
	@FindBy(xpath="//span[text()='Send Institute Verification Code']")
	private WebElement submitBtn;
	
	@FindBy(id="enter-6-digit-passcode")
	private WebElement otpField;
	
	@FindBy(xpath="//span[text()='Verify & Enter Merchant Studio']")
	private WebElement otpSubmitBtn;
	
	@FindBy(xpath="//span[text()='Coupons & Promos']")
	private WebElement couponModule;
	
	@FindBy(xpath="//span[text()='Create Coupon']")
	private WebElement createBtn;
	
	@FindBy(id="coupon-code")
	private WebElement couponCodeField;
	
	@FindBy(id="discount-percentage-(%)")
	private WebElement disPerField;
	
	@FindBy(xpath="//span[text()='Submit for Approval']")
	private WebElement couponSubmitBtn;
	
	@FindBy(xpath="//span[text()='FIRE2026']")
	private WebElement verifyCreatedCoupon;
	
	@FindBy(xpath="//tr[.//span[normalize-space()='FIRE2026']]/td[3]//span")
	private WebElement statusVerify;
	
	@FindBy(xpath="//button[.//*[contains(@class,'lucide lucide-log-out w-4 h-4')]]")
	private WebElement signOutBtn;
	
	String b;
	
	public void merchantLogin(String mobile, String name, String otp) {
		elementUtils.click(signInBtn);
		//elementUtils.waitForVisibility(merchant);
		elementUtils.click(merchant);
		elementUtils.sendKeys(mobileField, mobile);
		elementUtils.sendKeys(nameField, name);
		elementUtils.click(submitBtn);
		elementUtils.sendKeys(otpField, otp);
		elementUtils.click(otpSubmitBtn);
	}
	
	public void createCoupon() {
		elementUtils.click(couponModule);
		elementUtils.click(createBtn);
		elementUtils.sendKeys(couponCodeField, "FIRE2026");
		elementUtils.sendKeys(disPerField, "20");
		b=elementUtils.getAttribute(couponCodeField, "value");
		elementUtils.click(couponSubmitBtn);
	}
	
	public void verifyCreatedCoupon() {
		String a=elementUtils.getText(verifyCreatedCoupon);
		Assert.assertEquals(a, b,"Coupon is not created");
	}
	
	public void merchantSignOut() {
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(signOutBtn));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles: true}));", signOutBtn);
		//elementUtils.click(signOutBtn);
	}
	
	public void verifyStatus() {
		elementUtils.click(couponModule);
		String a=elementUtils.getText(statusVerify);
		System.out.println("Status of the coupon is : "+a);
	}

}

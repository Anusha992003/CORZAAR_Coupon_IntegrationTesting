package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.ElementUtils;

public class learnerCouponPage {
	
	private final WebDriver driver;
	private ElementUtils elementUtils;
	
	public learnerCouponPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signInBtn;
	
	@FindBy(id="learner-mobile-number")
	private WebElement mobileNumberField;
	
	@FindBy(id="full-name-(optional-for-existing-learners)")
	private WebElement fullNameField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sendOtpBtn;
	
	@FindBy(id="enter-6-digit-passcode")
	private WebElement otpField;
	
	@FindBy(xpath="//span[text()='Verify & Enter Learning Space']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[text()='Offers']")
	private WebElement offersModule;
	
	@FindBy(xpath="//div[text()='FIRE2026']")
	private WebElement couponDisplay;
	
	@FindBy(xpath="//div[text()='FIRE2026']")
	private List<WebElement> couponDisplay1;
	
	@FindBy(xpath="//button[contains(@class,'flex items-center gap-2 p-1 ')]")
	private WebElement profileIcon;
	
	@FindBy(xpath="//button[text()='Sign Out']")
	private WebElement signOutOption;
	
	public void learnerLogin(String mobile,String name, String otp) {
		elementUtils.click(signInBtn);
		elementUtils.sendKeys(mobileNumberField, mobile);
		elementUtils.sendKeys(fullNameField, name);
		elementUtils.click(sendOtpBtn);
		elementUtils.sendKeys(otpField, otp);
		elementUtils.click(submitBtn);
	}
	
	public void verifyCoupon() {
		elementUtils.click(offersModule);
		String a=elementUtils.getText(couponDisplay);
		Assert.assertEquals(a, "FIRE2026");
	}
	
	public void learnerSignOut() {
		elementUtils.click(profileIcon);
		elementUtils.click(signOutOption);
	}
	
	public void verifyReject() {
		elementUtils.click(offersModule);
		boolean a=couponDisplay1.size()>0;
		Assert.assertFalse(a,"Rejected coupon should notbe displayed");
	}

}

package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class learnerCertificatePage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public learnerCertificatePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="(//h3[text()='UI UX Design Fundamentals'])[1]")
	private WebElement course;
	
	@FindBy(xpath="(//div[contains(@class,'flex items-center justify-between')])[4]")
	private WebElement module2;
	
	@FindBy(xpath="(//div[contains(@class,'flex items-center justify-between')])[5]")
	private WebElement module3;
	
	@FindBy(xpath="(//div[contains(@class,'flex items-center justify-between')])[6]")
	private WebElement module4;
	
	@FindBy(xpath="//span[@class='text-brand font-black text-sm']")
	private WebElement courseStatus;
	
	@FindBy(xpath="//span[@class='font-mono font-bold text-brand']")
	private WebElement certificateID;
	
	

}

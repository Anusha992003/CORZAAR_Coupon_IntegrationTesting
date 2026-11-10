package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class merchantCertificatePage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public merchantCertificatePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	


}

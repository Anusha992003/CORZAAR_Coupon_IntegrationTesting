package com.utilities;

public class ConstantUtils {

	public static final int IMPLICIT_WAIT_TIME = 10;

	public static final int EXPLICIT_WAIT_TIME = 10;

	public static final int PAGE_LOAD_TIME = 20;

	public static final String LEARNERMOBILENUMBER = ConfigReader.getProperty("learnerMobile");

	public static final String LEARNERNAME = ConfigReader.getProperty("learnerName");
	
	public static final String LEARNEROTP = ConfigReader.getProperty("learnerOtp");
	
	public static final String MERCHANTMOBILE = ConfigReader.getProperty("merchantMobile");
	
	public static final String MERCHANTNAME = ConfigReader.getProperty("merchantName");
	
	public static final String MERCHANTOTP = ConfigReader.getProperty("merchantOtp");
	
	public static final String ADMINEMAIL = ConfigReader.getProperty("adminEmail");
	
	public static final String ADMINPASSWORD = ConfigReader.getProperty("adminPassword");
	
	public static final String ADMINCODE = ConfigReader.getProperty("adminCode");
}

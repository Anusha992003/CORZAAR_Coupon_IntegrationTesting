package com.StepDefinition;

import com.Pages.adminCouponPage;
import com.Pages.learnerCouponPage;
import com.Pages.merchantCouponPage;
import com.driverFactory.DriverFactory;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class couponIntegrationSteps {
	
	private merchantCouponPage merCou;
	private adminCouponPage admCou;
	private learnerCouponPage leaCou;
	
	@Given("the merchant is logged in")
	public void the_merchant_is_logged_in() {
	    merCou=new merchantCouponPage(DriverFactory.getDriver());
	    merCou.merchantLogin(ConstantUtils.MERCHANTMOBILE, ConstantUtils.MERCHANTNAME, ConstantUtils.MERCHANTOTP);
	}
	@When("the merchant creates a coupon with code {string} and {int} percent discount")
	public void the_merchant_creates_a_coupon_with_code_and_percent_discount(String string, Integer int1) {
	    merCou.createCoupon();
	}
	@Then("the merchant panel should show the coupon as created")
	public void the_merchant_panel_should_show_the_coupon_as_created() {
	    merCou.verifyCreatedCoupon();
	}
	@When("the merchant logged out")
	public void the_merchant_logged_out() {
	    merCou.merchantSignOut();
	}
	@When("the admin logs in")
	public void the_admin_logs_in() {
	    admCou = new adminCouponPage(DriverFactory.getDriver());
	    admCou.adminLogin(ConstantUtils.ADMINEMAIL, ConstantUtils.ADMINPASSWORD, ConstantUtils.ADMINCODE);
	}
	@When("the admin searches the coupon {string}")
	public void the_admin_searches_the_coupon(String string) {
	    admCou.searchCoupon();
	}
	@Then("the admin panel should show the coupon as pending approval")
	public void the_admin_panel_should_show_the_coupon_as_pending_approval() {
	    admCou.verifyCouponDisplay();
	}
	@When("admin approves the coupon {string}")
	public void admin_approves_the_coupon(String string) {
	    admCou.approveCoupon();
	}
	@When("the admin logged out")
	public void the_admin_logged_out() {
	    admCou.adminSignOut();
	}
	@When("the learner is logged in")
	public void the_learner_is_logged_in() {
		leaCou=new learnerCouponPage(DriverFactory.getDriver());
	    leaCou.learnerLogin(ConstantUtils.LEARNERMOBILENUMBER, ConstantUtils.LEARNERNAME, ConstantUtils.LEARNEROTP);
	}
	@Then("the learner navigates to offers page and verifies the approved coupon visibility")
	public void the_learner_navigates_to_offers_page_and_verifies_the_approved_coupon_visibility() {
	    leaCou.verifyCoupon();
	    leaCou.learnerSignOut();
	}
	
	@Given("the admin rejects the coupon")
	public void the_admin_rejects_the_coupon() {
		admCou = new adminCouponPage(DriverFactory.getDriver());
		admCou.adminLogin(ConstantUtils.ADMINEMAIL, ConstantUtils.ADMINPASSWORD, ConstantUtils.ADMINCODE);
		admCou.searchCoupon();
		admCou.reject();
		admCou.adminSignOut();
	}
	@Given("the learner verifies the rejected coupon visibility")
	public void the_learner_verifies_the_rejected_coupon_visibility() {
		leaCou=new learnerCouponPage(DriverFactory.getDriver());
		leaCou.learnerLogin(ConstantUtils.LEARNERMOBILENUMBER, ConstantUtils.LEARNERNAME, ConstantUtils.LEARNEROTP);
		leaCou.verifyReject();
		leaCou.learnerSignOut();
	}
	
	@Then("the merchant verifies the status of the respective coupon")
	public void the_merchant_verifies_the_status_of_the_respective_coupon() {
		merCou=new merchantCouponPage(DriverFactory.getDriver());
	    merCou.merchantLogin(ConstantUtils.MERCHANTMOBILE, ConstantUtils.MERCHANTNAME, ConstantUtils.MERCHANTOTP);
	    merCou.verifyStatus();
	}

}

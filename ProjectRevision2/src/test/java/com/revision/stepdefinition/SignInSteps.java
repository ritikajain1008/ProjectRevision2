package com.revision.stepdefinition;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.revision.factory.DriverFactory;
import com.revision.pages.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends DriverFactory{
	
	public static Logger log = Logger.getLogger(SignInSteps.class); // logging
	
	@Given("^user launches the browser$")
	public void user_launches_the_browser() throws Throwable {
		log.info("****************Browser is Opened*****************");
	   
	}

	@When("^user enter valid mailid and valid password$")
	public void user_enter_valid_mailid_and_valid_password() throws Throwable {
		SignInPage login = new SignInPage(driver);
		log.info("***************User click on signIn option*****************");
		login.clickSignin();
		log.info("****************User enter Valid Mail Id*******************");
		login.entermail(prop.getProperty("mailid"));
		login.clickNextbtn();
		log.info("****************User enter Valid Password*******************");
		login.enterPassword(prop.getProperty("password"));
		login.clickNextbtn();
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		SignInPage login = new SignInPage(driver);
		log.info("****************User logged In Successfully*****************");
		login.clickLoginIcon();
		login.clickSignOut();
		log.info("****************User SignOut Successfully********************");
	   
	    
	}
	
	@When("^user enter valid mailid and invalid password$")
	public void user_enter_valid_mailid_and_invalid_password() throws Throwable {
		SignInPage login = new SignInPage(driver);
		login.clickSignin();
		log.info("****************User enter Valid Mail Id*******************");
		login.entermail(prop.getProperty("mailid"));
		login.clickNextbtn();
		log.info("****************User enter InValid Password*******************");
		login.enterPassword(prop.getProperty("invalidpassword"));
		login.clickNextbtn();
		Thread.sleep(5000);
	    
	}

	@Then("^user should not be able to login successfully$")
	public void user_should_not_be_able_to_login_successfully() throws Throwable {
		SignInPage login = new SignInPage(driver);
		Assert.assertEquals(login.invalidPasswordtext(),"Wrong password. Try again or click Forgot password to reset it.");
		log.info("****************User not able to logged In Successfully*****************");
		
	    
	}




}

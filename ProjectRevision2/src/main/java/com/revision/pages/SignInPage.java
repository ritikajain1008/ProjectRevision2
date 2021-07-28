package com.revision.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	public WebElement signin;
	
	@FindBy(how = How.XPATH, using = "//input[@id='identifierId']")
	public WebElement mail;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	public WebElement nextbtn;
	
	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/img[1]")
	public WebElement loginicon;
	
    @FindBy(how = How.XPATH, using = "//a[@id='gb_71']")
	public WebElement signout;
    
    @FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
   	public WebElement invalidpswdtext;
	
	
	public void clickSignin()
	{
		signin.click();
	}
	
	public void entermail(String mailid)
	{
		mail.sendKeys(mailid);
	}
	
	public void clickNextbtn()
	{
		nextbtn.click();
	}
	
	public void enterPassword(String pswd) 
	{
		password.sendKeys(pswd);
	}
	
	public void clickLoginIcon()
	{
		loginicon.click();
	}
	
	public void clickSignOut()
	{
		signout.click();
	}
	
	public String invalidPasswordtext()
	{
		return invalidpswdtext.getText();
	}
	

}

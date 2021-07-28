package com.revision.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "q") // name locator
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//body/div[@id='main']/div[@id='cnt']/div[@id='top_nav']/div[@id='hdtb']/div[@id='pTwnEc']/div[@id='hdtb-msb']/div[1]/div[1]/div[3]/a[1]")
	public WebElement image;

	@FindBy(how = How.XPATH, using = "//input[@value='Show more results']") // xpath locator
	public WebElement showmoreresults;

	@FindBy(how = How.XPATH, using = "//body/div[2]/c-wiz[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	public WebElement endtext;

	public void enterSearchedTerm(String searcheditem) {
		search.sendKeys(searcheditem);
	}

	public void clickSearch() {
		search.sendKeys(Keys.ENTER);
	}

	public void clickImageOption() {
		image.click();
	}

	public int SearchedTermAllResults() {
		int fg = 0;
		List<WebElement> output = driver.findElements(By.tagName("cite"));

		for (int i = 0; i < output.size(); i++) {
			if (output.get(i).getText().contains("Selenium") || output.get(i).getText().contains("selenium")
					|| output.get(i).getText().contains("sele...") || output.get(i).getText().isEmpty()) {

			} else {
				fg = 1;
				break;
			}
		}
		return fg;
	}

	public void LastImageClick() {
		int fg = 0;
		try {
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);
				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (showmoreresults.isDisplayed() && fg == 0) {
					showmoreresults.click();
					fg = 1;
					Thread.sleep(2000);
					continue;

				}
				if (endtext.isDisplayed()) {
					Thread.sleep(2000);
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> output = driver.findElements(By.tagName("img"));
		WebElement lastimage = output.get(output.size() - 1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastimage);
	}

}

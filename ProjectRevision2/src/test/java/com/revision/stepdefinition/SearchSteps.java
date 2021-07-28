package com.revision.stepdefinition;

import org.apache.log4j.Logger;

import com.revision.factory.DriverFactory;
import com.revision.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends DriverFactory {

	public static Logger log = Logger.getLogger(SearchSteps.class); // logging

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		log.info("**********Browser is Opened***************");
	}

	@When("User search an item using search option")
	public void user_search_an_item_using_search_option() throws Exception {
		SearchPage searchpage = new SearchPage(driver);
		log.info("******************User search a term******************");
		searchpage.enterSearchedTerm(prop.getProperty("searchterm"));
		searchpage.clickSearch();
		log.info("****************User reached on searched term page***************");
	}

	@Then("Validate all search results are according to the item searched")
	public void validate_all_search_results_are_according_to_the_item_searched() {
		SearchPage searchpage = new SearchPage(driver);
		int fg = searchpage.SearchedTermAllResults();
		if (fg == 0) {
			log.info("************All Searched Results are as per the searched term***********");
		} else {
			log.info("************All Searched Results are not as per the searched term***********");
		}

		

	}

	@When("^User search an item & opens Image search results$")
	public void user_search_an_item_opens_Image_search_results() throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		log.info("******************User search a term******************");
		searchpage.enterSearchedTerm(prop.getProperty("searchimageterm"));
		searchpage.clickSearch();
		log.info("****************User reached on images of searched term**************");
		searchpage.clickImageOption();
	}

	@Then("^User scroll down & click on last image$")
	public void user_scroll_down_click_on_last_image() throws Throwable {
		SearchPage searchpage = new SearchPage(driver);
		searchpage.LastImageClick();
        Thread.sleep(2000);
       

	}

}

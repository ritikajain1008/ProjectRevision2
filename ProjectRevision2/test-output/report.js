$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SearchFunctionality.feature");
formatter.feature({
  "line": 1,
  "name": "Validate Search functionality",
  "description": "",
  "id": "validate-search-functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User can validate all the search results on first page contain search term entered",
  "description": "",
  "id": "validate-search-functionality;user-can-validate-all-the-search-results-on-first-page-contain-search-term-entered",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User launches the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User search an item using search option",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Validate all search results are according to the item searched",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchSteps.user_launches_the_browser()"
});
formatter.result({
  "duration": 8642465900,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.user_search_an_item_using_search_option()"
});
formatter.result({
  "duration": 2406068601,
  "status": "passed"
});
formatter.match({
  "location": "SearchSteps.validate_all_search_results_are_according_to_the_item_searched()"
});
formatter.result({
  "duration": 2056383999,
  "status": "passed"
});
});
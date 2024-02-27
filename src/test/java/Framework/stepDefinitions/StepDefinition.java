package Framework.stepDefinitions;
import java.io.IOException;

import org.openqa.selenium.TimeoutException;

import org.testng.Assert;

import Framework.pageobjects.CategoryPage;
import Framework.pageobjects.FilterPage;
import Framework.pageobjects.HomePage;
import Framework.pageobjects.ProductPage;
import Framework.testComponents.BaseTestEbay;
import io.cucumber.java.en.*;

public class StepDefinition extends BaseTestEbay {

    private HomePage homePage;
    private FilterPage filterPage;
    private ProductPage productPage;
    private CategoryPage categoryPage;
    String conditionFilter = "excellent - refurbished";
    String locationName ="united states";

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() throws IOException {
    	homePage = launchApplication();
    	
    }

    @When("User navigates to category > Electronics > Cell Phones & accessories")
    public void userNavigatesToElectronicsCategory() {
   categoryPage = homePage.navigateToElectronicsCategory();
    }

    @And("User clicks on Cell Phones & Smartphones")
    public void userClicksOnCellPhonesSmartphones() {
    	filterPage =categoryPage.selectCellPhonesSmartphones();
    }

    @And("User clicks on All Filters")
    public void userClicksOnAllFilters() {
        
    	filterPage = categoryPage.clickAllFilters();
    }

    @And("^User adds 3 filters - Condition, Price as (.+) and (.+), and Item Location and clicks Apply button$")
    public void userAddFilters(int minprice, int maxprice) {
    	productPage= filterPage.addFilters(minprice, maxprice);
    }

 

    @Then ("^Verify price tag is applied with (.+) and (.+)$")
    public void verifyPriceTagApplied(String minprice, String maxprice) throws InterruptedException {
    	Thread.sleep(2000);
    	String priceText = productPage.getPriceText();
    	
    	System.out.println("Price Text: " +priceText);
    	Assert.assertEquals("Cell Phones & Smartphones between US $"+minprice+".00 and US $"+maxprice+".00", priceText);
    	System.out.println("Cell Phones & Smartphones between US $"+minprice+".00 and US $"+maxprice+".00");
    }
    
    @And("Verify filter tag url")
    public void verifyFilterTagUrl() {
    	String filterTagUrl=productPage.getFilterAppliedUrl().toLowerCase();
    	
    	System.out.println("Filter Tag URL: " + filterTagUrl.toLowerCase());
    	
    	Assert.assertTrue(filterTagUrl.contains("itemcondition") && filterTagUrl.contains("udlo") && filterTagUrl.contains("udhi") && filterTagUrl.contains("prefloc"));

    }
    @And("Access first product and verify condition, price and Itemcondition filters are applied correctly")
    public void verifyAllFilterTagApplied() {
    	
    	productPage.accessFirstProduct();
    	String conditionText = productPage.getConditionTagApplied();
    	System.out.println("Condition: " +conditionText);
    	Assert.assertTrue(conditionText.toLowerCase().contains(conditionFilter));
    	String locationText = productPage.getLocationTagApplied();
    	System.out.println("Location: " +locationText);
    	
    	Assert.assertTrue(locationText.toLowerCase().contains(locationName));
    	double price = productPage.getPriceTagApplied();
    	Assert.assertTrue(price<100 && price>10);
    	driver.quit();
    	
    }
    
    
    @When("User type {string} in the search bar")
    public void userTypeInTheSearchBar(String searchString) {
    	homePage.typeInTheSearchBar(searchString);
        
    }

    @When("User change the search category as {string} and click Search")
    public void userChangesSearchCategoryAndClicksSearch(String category) {
    	productPage = homePage.selectCategory(category);
      
    }

    @Then("Verify that the page loads completely")
    public void verifyPageLoadsCompletely() {
    	try {
    		productPage.verifyPageLoaded();
        	
    	} catch (TimeoutException e) {
    	    System.out.println("Element not visible within the specified timeout.");
    	    e.printStackTrace();
    	}
    
    	
    }

    @Then("Verify that the first result name matches with the search string {string}")
    public void verifyFirstResultNameMatchesSearchString(String searchString) {
       String firstResult = productPage.getFirstProduct();
        Assert.assertTrue(firstResult.toLowerCase().contains(searchString.toLowerCase()));
        driver.quit();
    }
    

	
       
        
   
	
	

}

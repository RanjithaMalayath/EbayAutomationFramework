
@tag
Feature: eBay Automation
  

  @filter
  Scenario: Access a Product via category after applying multiple filters
    Given User is on the homepage
    When User navigates to category > Electronics > Cell Phones & accessories
    And User clicks on Cell Phones & Smartphones
    And User clicks on All Filters
    And User adds 3 filters - Condition, Price as <minprice> and <maxprice>, and Item Location and clicks Apply button
    Then Verify price tag is applied with <minprice> and <maxprice>
    And Verify filter tag url
    And Access first product and verify condition, price and Itemcondition filters are applied correctly

  

    Examples: 
      | minprice | maxprice  | 
      |   10     |   100     | 
     
      
      
   @search
   Scenario: Access a Product via Search
    Given User is on the homepage
    When User type "MacBook" in the search bar
    And User change the search category as "Computers/Tablets & Networking" and click Search
    Then Verify that the page loads completely
    And Verify that the first result name matches with the search string "MacBook"
   
    
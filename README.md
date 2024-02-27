# Selenium Framework Design for eBay Automation

This repository contains a Selenium-based automation framework designed for automating eBay scenarios using the Cucumber BDD framework. The framework utilizes Java, TestNG, Selenium WebDriver, and Cucumber for end-to-end testing of eBay functionalities.

## Prerequisites

- Java JDK
- Eclipse 
- Maven 
- TestNG
- Cucumber

# Project Structure

## 1. Framework Components

**a. Page Objects**

**HomePage.java:**  Represents the eBay homepage, providing methods to interact with elements on the homepage.

**CategoryPage.java:**  Handles interactions with the category page, including selecting specific categories and filters.

**FilterPage.java:**  Manages interactions with filter options on eBay, allowing users to apply various filters.

**ProductPage.java:** Represents the product page and provides methods to retrieve information about products.


**b. Abstract Components**

**AbstractComponent.java:** Contains the abstract components used by other page objects, such as waiting for elements to appear.

**c. BaseTest**

**BaseTestEbay.java:**  Initializes the WebDriver, launches the application, and provides common methods for test classes.

## 2. Step Definitions

**a. StepDefinition.java**

Implements step definitions for Cucumber scenarios, defining the actions to be taken for each step in the scenarios.

## 3. Cucumber

**a. Test Runner**

**TestNGTestRunnerEbay.java:**  Configures Cucumber options, defines the features and glue paths, and extends the TestNG test class.

## 4. Resources

**a. Global Data**

**GlobalData.Properties:**  Contains global configuration data, such as browser selection.

## 5. Maven Configuration

**pom.xml:**  Maven project configuration file containing dependencies, plugins, and profiles for executing Cucumber tests.

# How to Run the Tests

## 1.Clone the Repository: 

Clone this repository to your local machine.

```git clone https://github.com/RanjithaMalayath/EbayAutomationFramework.git```


## 2.Configure Browser: 

Update the browser preference in the GlobalData.Properties file.

## 3. Run Tests:

Execute the TestNGTestRunnerEbay class as a TestNG test to run all Cucumber scenarios.


# Test Scenarios
## Scenario 1: Access a Product via category after applying multiple filters

1. User is on the homepage.
2. User navigates to Electronics > Cell Phones & accessories.
3. User clicks on Cell Phones & Smartphones.
4. User clicks on All Filters.
5. User adds 3 filters - Condition, Price, and Item Location and clicks Apply button.
6. Verify the applied price tag.
7. Verify the filter tag URL.
8. Access the first product and verify applied filters.

## Scenario 2: Access a Product via Search

1. User is on the homepage.
2. User types "MacBook" in the search bar.
3. User changes the search category to "Computers/Tablets & Networking" and clicks Search.
4. Verify that the page loads completely.
5. Verify that the first result name matches with the search string "MacBook."

# Dependencies 

Selenium WebDriver 4.16.1
TestNG 7.8.0
WebDriverManager 5.6.2
Cucumber 7.15.0

# Conclusion
Test cases are successfully executed.

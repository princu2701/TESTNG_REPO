
@Project
Feature: Ebay

  @MainProcess
  Scenario: Validate the working of Ebay Search Functionality
  
    Given User Enters the Browser and Enter Ebay Url
    
    And Clicks on Advanced Search and Select the Options
    
    When User Clicks on Using Advanced Search options button and In new page verifies the Customer Service and Comeback to the main page 
    
    And Select the checkboxes and Clicks on Search button
    
    Then No Exact matches found Page should have been Appeared  
    
    And Close the Browser

 

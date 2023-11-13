Feature: Search Functionality

Scenario: Search with existing product
Given User landed the search page
When User provide "Existing" Product into search box field
And User clicks on search button
Then User should get valid product displayed in search results

Scenario: Search with Non-existing product
Given User landed the search page
When User provide "Non Existing" Product into search box field
And User clicks on search button
Then User should get a message about no product matching


Scenario: Search without providing product name in search box
Given User landed the search page
When User dont enter any product name into search box field
And User clicks on search button
Then User should get a message about no product matching

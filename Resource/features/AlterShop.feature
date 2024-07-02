Feature: Search and Filter functionality

Background:
 Given I am on the home page
   

Scenario: Search for an asset
 When I search for product
 Then I should see the search results

Scenario: All categories tab Validation
 Then I should see the filtered Categories
 Then I should see the filtered All Categories
 Then I should see the filtered All Body
 Then I should see the filtered All Building
 Then I should see the filtered All IndoorAsset
 Then I should see the filtered All OutdoorAsset
 Then I should see the filtered AlterLand
 
Scenario: View creator's profile and their assets
 When I search for product
 Then I should see the creator's assets
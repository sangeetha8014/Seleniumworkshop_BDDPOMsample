Feature: Search and Place Order


Scenario: Place Order
Given User is on Home Page
When User search "Phone"
And Add Item to cart
Then Item must be in Cart
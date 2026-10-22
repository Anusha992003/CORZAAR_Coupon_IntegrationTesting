Feature: Verifying the integration flow of coupon 

Scenario: Coupon flow

Given the merchant is logged in
When the merchant creates a coupon with code "FIRE2026" and 20 percent discount
Then the merchant panel should show the coupon as created
When the merchant logged out 

And the admin logs in 
And the admin searches the coupon "FIRE2026" 
Then the admin panel should show the coupon as pending approval 
When admin approves the coupon "FIRE2026"
When the admin logged out 

And the learner is logged in
Then the learner navigates to offers page and verifies the approved coupon visibility 

@reject
Scenario: Verification of rejected coupon

Given the admin rejects the coupon 
And the learner verifies the rejected coupon visibility 
Then the merchant verifies the status of the respective coupon 
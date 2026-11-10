Feature: Certificate integration flow 

Scenario: Verifying the flow of certificate 

Given the learner login to the application 
When the learner completes all the required course modules 
Then certificate should be generated after completing

When the merchant logged in  
Then merchant should able to view the certificate for approval 
Feature: Free CRM Login Feature
   Scenario Outline: Free CRM Login Test Scenario

     Given user is already on Home Page
     When title of home page is Free CRM
     And user clicks on login button
     And user enters "<username>" and "<password>"
     Then  user verify invalid login message on login page

     Examples:

     |username     | password|
     |abc@test.com |test123  |
     |jack@test.com|test1416 |


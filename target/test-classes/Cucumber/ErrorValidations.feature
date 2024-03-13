

Feature: Validating Login with wrong username and password
 

 @ErrorValidation
  Scenario Outline: Checking Error Login Text 
    Given I landed on login page
    When Login with username <userName> and password <password>
    Then "Incorrect email or password." is displayed

    Examples: 
      | userName            | password      | 
      | gopi1235j@gmail.com | Gopinathj@456 |
     

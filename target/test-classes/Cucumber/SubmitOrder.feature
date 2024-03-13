

Feature: Purchase the product from E-Commerce website
  I want to use this template for my feature file

 Background: 
 Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <username>  and password <password>
    When I add product <productName> to cart 
    And Checkout <productName> and submit the order
   Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:   
      | username             | password       | productName     |
      | gopij@gmail.com      |Gopinathj@123   | ZARA COAT 3     |
      | adithya123@gmail.com |Adithya@123     | ADIDAS ORIGINAL |

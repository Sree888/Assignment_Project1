Feature: Account Creation


@tag20
  Scenario: User creates a new account on Magento
    Given user is opening the web browser
    And Navigate to the URL of "https://magento.softwaretestingboard.com/"
    Then verify user is on Landing page
    And user clicks on "Create an Account" button
    Then verify user navigates to Create Account page
    And user enter following details:
    |First Name|Last Name|Email|Password|
    |Raju|Test2|raju.test3@testmail.com|raju@9976@0|
    And user clicks on Create Account Button
    Then verify user navigates to My account page
    And verify the success message "Thank you for registering with Main Website Store."
    Then verify the user details entered displaying correctly on My Account page
    
    
    @tag20
  Scenario: User signs in with existing credentials on Magento
    Given user is opening the web browser
    And Navigate to the URL of "https://magento.softwaretestingboard.com/"
    Then verify user is on Landing page
    And user clicks on "Sign In" button
    Then verify user navigates to login page
    And user enter login details:
    |First Name|Last Name|Email|Password|
    |Raju|Test2|raju.test3@testmail.com|raju@9976@0|
    And user click on sign in button
    Then verify user login successfully
    
    @tag20
  Scenario: User create account using same email
    Given user is opening the web browser
    And Navigate to the URL of "https://magento.softwaretestingboard.com/"
    Then verify user is on Landing page
    And user clicks on "Create an Account" button
    And user enter following details for existing user:
    |First Name|Last Name|Email|Password|
    |Raju|Test2|raju.test3@testmail.com|raju@9976@0|
    And user clicks on Create Account Button
    Then verify the error message displayed: "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."
    
    
     @tag20
  Scenario: User signs in with incorrect credentials on Magento
    Given user is opening the web browser
    And Navigate to the URL of "https://magento.softwaretestingboard.com/"
    Then verify user is on Landing page
    And user clicks on "Sign In" button
    Then verify user navigates to login page
    And user enter login details:
    |First Name|Last Name|Email|Password|
    |Raju|Test2|raju.testzz3@testmail.com|raju@9976@0|
    And user click on sign in button
    Then verify error message for invalid login: "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."
    
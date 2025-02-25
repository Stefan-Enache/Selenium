Feature: Login user

  Scenario: Valid Login
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "Admin", password: "admin123")
    And the user clicks on the login page
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
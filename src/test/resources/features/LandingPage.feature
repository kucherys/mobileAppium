Feature: Check landing page

  @landAndroid
  Scenario: Verify elements on landing page for Android
    Given Appium server with "Android" real application is running
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton    |
      | Log In      | Welcome to | I'm new to Ryse |


  @landIOS
  Scenario: Verify elements on landing page for iOS
    Given Appium server with "iOS" real application is running
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton    |
      | Log in      | Welcome to | I'm new to Ryse |



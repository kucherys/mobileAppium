Feature: Check e2e Onboarding scenario for Android

  @e2eAndroid
  Scenario: Verify onboarding flow for Android
    Given Appium server with "Android" real application is running
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton    |
      | Log In      | Welcome to | I'm new to Ryse |
    And I log in to product carousel page
    And I verify product carousel page is loaded
    Then I verify elements on product carousel page
      | pageNumber | logoText                     | instructionText                                  | openBankAccountButton | eligibilityLabel |
      | 2          | Achieve your financial goal  | Make your money work harder with our Savings Pot | Open bank account     | Am I eligible?   |
      | 3          | Discover exciting new deals  | Enjoy exclusive offers from our partners         | Open bank account     | Am I eligible?   |
      | 4          | Financing at your fingertips | Apply online hassle-free                         | Open bank account     | Am I eligible?   |
      | 1          | Manage your money on the go  | Stay in control with our Savings Account-i       | Open bank account     | Am I eligible?   |
    When I verify if I am eligible
    And I verify Eligibility criteria modal is loaded
    Then I verify elements on Eligibility criteria modal
      | I’m a Malaysian citizen with a MyKad, currently residing in Malaysia      |
      | I’m aged 18 years and above                                               |
      | I have an existing internet banking account with another bank in Malaysia |
      | I’m NOT a US person                                                       |
      | I’m NOT a tax resident in any other country                               |
      | I’m NOT an existing Al-Rajhi bank customer                                |
    And I close eligibility modal

  @e2e
  Scenario: Verify onboarding flow happy path
    Given Appium server with "Android" real application is running
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton    |
      | Log In      | Welcome to | I'm new to Ryse |
    And I log in to product carousel page
    And I verify product carousel page is loaded
    Then I verify elements on product carousel page
      | pageNumber | logoText                     | instructionText                                  | openBankAccountButton | eligibilityLabel |
      | 2          | Achieve your financial goal  | Make your money work harder with our Savings Pot | Open bank account     | Am I eligible?   |
      | 3          | Discover exciting new deals  | Enjoy exclusive offers from our partners         | Open bank account     | Am I eligible?   |
      | 4          | Financing at your fingertips | Apply online hassle-free                         | Open bank account     | Am I eligible?   |
      | 1          | Manage your money on the go  | Stay in control with our Savings Account-i       | Open bank account     | Am I eligible?   |
    When I verify if I am eligible
    And I verify Eligibility criteria modal is loaded
    Then I verify elements on Eligibility criteria modal
      | I am a Malaysian with a MyKad, residing in Malaysia                       |
      | I am aged 18 years and above                                              |
      | I have an existing internet banking account with another bank in Malaysia |
      | I am NOT a US person                                                      |
      | I am NOT a tax resident in any other country                              |
      | I am a new Al-Rajhi bank customer applying for an individual account      |
    And I close eligibility modal

    Then I am openning bank account
    Then I verify application flow page is loaded
#    Then I verify elements on application flow page
#      | logoLabel                       | labelFirst                             | signUpButton  |
#      | This shouldn't take long at all | We pride ourselves on a quick sign up. | Let's sign up |

    When I'm processing to terms and conditions page
    And I stop appium server
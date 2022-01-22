Feature: Create New Task

  @testIOS
  Scenario: The user can add new task again for iOS
    Given Appium server with "iOS" application is running
    Given Click Add new Task
    Given Print task number "iOS EXP app WITH ADDED CAPABILITIES"
    Given Enter TaskName
    Given Enter TaskDesc
    When Click Save
    Then Task added successfully

  @testAndroid
  Scenario: The user can add new task again for Android
    Given Appium server with "Android" application is running
    Given Click Add new Task
    Given Print task number "ANDROID EXP app WITH ADDED CAPABILITIES new RUN"
    Given Enter TaskName
    Given Enter TaskDesc
    When Click Save
    Then Task added successfully

  @landingExpIOS
  Scenario: Verify elements on landing page for iOS experimental
    Given Appium server with "iOS" real application is running
    When I print login button name
    And I print SignIn button name
    Then I confirm tests completed with result "IOS TEST PASSED"


  @landingExpAndroid
  Scenario: Basic landing page test for Android experimental
    Given Appium server with "Android" real application is running
    When I print login button name
    And I print SignIn button name
    Then I confirm tests completed with result "REAL Android APP TEST PASSED SUCCESS 1"


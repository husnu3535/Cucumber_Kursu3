Feature: Employee Functinoality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: Employee Menu
    Given Human Resources
      |humanSrc|
    And Employee to click
      |employee|
    And Click on the element in the Dialog
      | createButton |
    And Employee firstname or lastname
      | firtsName  | mehmet    |
      | lastName   | aslan     |
      | employeeID | mehmet123 |
    And Gender to Click
      |gender|
      |male  |
    And Employee Type Select
  









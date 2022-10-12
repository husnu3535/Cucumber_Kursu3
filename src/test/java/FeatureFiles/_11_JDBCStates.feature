Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

    Scenario: States testing with JDBC
      And Click on the element in the left Nav
        | setup      |
        | parameters |
        | states     |
      Then States JDBC "select * from states" and UI States with match

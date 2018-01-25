Feature: Application Startup
  As a user
  I want a view of my people
  So that I can knock them into shape

  Scenario: Show media list
    Given I have the application open
    Then treeView is visible

  Scenario: Show info
    Given I have the application open
    Then infoView is visible

  Scenario Outline: Select item
    Given I have the application open
    When I select item <index> in treeView
    Then nameField value is equal to the name of item <index> in treeView
  Examples:
    | index  |
    | 1      |
    | 2      |
    | 3      |
    | 4      |
    | 5      |
    | 6      |
    | 7      |
    | 8      |
    | 9      |
    | 10     |


  Scenario: Select item after selecting another item
    Given I have the application open
    When I select item 1 in treeView
    And I select item 2 in treeView
    Then nameField value is equal to the name of item 2 in treeView
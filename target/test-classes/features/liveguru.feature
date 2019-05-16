@liveguru
Feature: Login to live application

  Scenario Outline: Login to system
    Given I want to open live app
    When I input data to textbox "<User>"
    And Input password to textbox"<Password>"
    And Click on to button
Examples: User and Passwword information
|User                    | Password |
| yennt@gmail.com        | 123321   |
| yennt1@gmail.com        | 123321   |
| yennt2@gmail.com        | 123321   |


Examples: test for login invalid information
|User                    |Password |Message|
| auto_test_01@g          |Pass111 |Please enter a valid email address. For example johndoe@domain.com.|
| auto_test_02@gmail.com | Pass111 |Invalid login or password.|
| auto_test_03@gmail.com | Pass    |Please enter 6 or more characters without leading or trailing spaces.|
    
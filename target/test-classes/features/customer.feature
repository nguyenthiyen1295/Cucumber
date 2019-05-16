@createCustomer
Feature: Register and login

  Scenario Outline: Register and Login to application
    Given I open application
    And I get Login page Url
    And I click to here link
    And I input to email textbox with data "autorandom"
    And I click to Submit button at Register page
    Then I get UserID infor
    And I get Password infor
    When I open login page again
    And I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    Given I open New Customer page
    When Input to New Customer form with data
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | EMail   | Password   |
      | <Name> | m      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <EMail> | <Password> |
    And I click to Submit button at New Customer page
    Then Verify message displayed with data "<Message>"
    And I verify all above infomation created success
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | EMail   |
      | <Name> | male   | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <EMail> |
    When I get Customer ID at New Customer page

    Examples: New Customer info
      | Name       | DateOfBirth | Address    | City   | State    | Pin    | Phone      | EMail    | Password | Message                             |
      | Automation | 1999_01_01  | 123 Le Loi | Ho Noi | Chau Anh | 123456 | 0908765543 | Autotest |   123321 | Customer Registered Successfully!!! |

  
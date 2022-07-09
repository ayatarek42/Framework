Feature: user registration
  I want to check the user can register to automation practice website

  Scenario Outline: User registration
    Given The user in the sign in page
    When  I enter "<account>"
    And   I enter the "<fname>", "<lname>", "<password>", "<day>", "<month>", "<year>", "<address>", "<city>","<state>", "<postalCode>", "<phone>"
    And   I click on register button
    Then  User is registered successfully

    Examples:
      | account | fname | lname | password | day | month | year | address | city | state | postalCode| phone|
      | ayaaaaaa3@gmail.com  | Aya | Tarek | 12345 | 1 | 2 | 2022 | Cairo | Cairo | 1 | 88888 | 01144942707  |


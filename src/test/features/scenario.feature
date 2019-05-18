Feature: Ui test of my site

#  Scenario Outline: Login with valid name and password
#    Given Login page is opened
#    Then Enter valid  username <username>
#    Then Enter valid  password <password>
#    And Click login button
#    Then Button LogOut should be displayed
#    Examples:
#      | username  | password |
#      | admin-ira | 11111    |
#
#
#  Scenario Outline: Login with invalid  password
#    Given Login page is opened
#    Then Enter valid  username <username>
#    Then Enter invalid  password <password>
#    And Click login button
#    Then  Error message should be displayed
#    Examples:
#      | username  | password |
#      | admin-ira | password |
#
#
#  Scenario Outline: Login with invalid  username
#    Given Login page is opened
#    Then Enter invalid  username <username>
#    Then Enter valid  password <password>
#    And Click login button
#    Then  Error message should be displayed
#    Examples:
#      | username | password |
#      | adminira | 11111    |


  Scenario Outline: Scenario Outline: Add new User
    Given Login page is opened
    Then Enter valid  username <username>
    Then Enter valid  password <password>
    And Click login button
    Then Click on button manage
    Then Click on button people
    And Page people is opened
    Then Click on button add user
    When Form for add new user is opened
    Then Enter email address of user
    Then Enter username for new user
    Then Enter password for new user
    And Click on button create new user
    Then Message that new user is add is displayed
    Examples:
      | username  | password |
      | admin-ira | 11111    |

#  Scenario: Youtube search
#    Given Youtube is opened
#    Then Input search word
#    And Click search button
#    Then Opened first video
#    And Video must be start


Feature: Go calculator screen

  Scenario: Open app show calculator screen
    Then I see "Enter First Number"
    Then I see "Enter Second Number"
    Then I enter "10" into input field number 1
    Then I enter "20" into input field number 2
    When I press "ok"
    Then I wait for 1 second
    Then I see "200"

Feature: dealerTurn
  Can the program successfully process a dealer's turn

  Scenario: The player has stood with a hand value of 16, the dealer has a hand of value 17.
    Given dealer has hand 10♣ and 7♠
    When dealerTurn runs
    Then dealer should stand
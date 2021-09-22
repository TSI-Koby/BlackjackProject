Feature: playerTurn
  Can the program successfully process a player's turn

  Scenario: player has a hand of 1♥ and 1♦ and wishes to hit once then stand
    Given player has hand 1♥ and 1♦
    When player hits once
    And player stands once
    Then player should be dealt one card
    And player should be recorded as standing
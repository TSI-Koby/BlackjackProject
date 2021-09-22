package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;
import com.blackjack.*;

public class StepDefinitions {
    Deck deck = new Deck(1);
    Player player = new Player("Geoff");

    @Given("player has hand 1♥ and 1♦")
    public void givenHand() {
        Card card1 = new Card();
        card1.createCard(1, "hearts", false);
        player.addToHand(card1);
        Card card2 = new Card();
        card2.createCard(1, "diamonds", false);
        player.addToHand(card2);
    }


    @When("player hits once")
    public void playerHitsOnce() {
        Deck.shuffleDeck(deck);
        Player.hitMe(deck, player);
    }

    @And("player stands once")
    public void playerStandsOnce() {
        Player.standMe(player);
    }

    @Then("player should be dealt one card")
    public void playerShouldBeDealtOneCard() {
        assertEquals(3, player.getHand().size(), "expected hand size 3, actual: "
                + player.getHand().size());
    }

    @And("player should be recorded as standing")
    public void playerShouldBeRecordedAsStanding() {
        assertTrue(player.getStandStatus(), "player not standing");
    }
}

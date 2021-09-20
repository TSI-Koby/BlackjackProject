package com.blackjack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public class dummyMain extends Main {
        private int inputCounter = 0;
        private String[] outputArray;

        public void setOutputArray(String[] strings) {
            this.outputArray = strings;
        }

        @Override
        public String takeInput(String inputRequest) {
            String string = outputArray[inputCounter];
            inputCounter++;
            return string;
        }
    }

    @Test
    @DisplayName("initMain test")
    void initMain() {
        dummyMain main = new dummyMain();
        main.initMain();
        for (Player c : main.getPlayerList().getCurrentPlayers()) {
            assertEquals(2, c.getHand().size(), "initMain failure, expected: 2, actual: "
                    + c.getHand().size());
        }
    }

    @Test
    @DisplayName("playerTurn test")
    void playerTurn() {
        dummyMain main = new dummyMain();
        main.initMain();
        
        main.playerTurn();
    }
}
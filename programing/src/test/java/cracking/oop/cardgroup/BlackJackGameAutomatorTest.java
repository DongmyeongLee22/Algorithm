package cracking.oop.cardgroup;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackGameAutomatorTest {

    @Test
    public void 카드생성(){
        BlackJackGameAutomator automator = new BlackJackGameAutomator(5);
        automator.initializeDeck();

    }

}
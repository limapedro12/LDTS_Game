package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerScoreTest {

    @Test
    public void getScoreTest() {
        int expected = 0;
        PlayerScore playerScore = new PlayerScore("", 0);
        Assertions.assertEquals(expected, playerScore.getScore());
    }
    @Test
    public void compareToTest() {
        int a = 10;
        int b = 20;
        int expected = 10;
        PlayerScore playerScoreA = new PlayerScore("", a);
        PlayerScore playerScoreB = new PlayerScore("", b);
        Assertions.assertEquals(expected, playerScoreA.compareTo(playerScoreB));
    }
}

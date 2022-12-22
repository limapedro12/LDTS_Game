package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

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

    @Test
    public void hashCodeTest() {
        int expected = 0;
        PlayerScore playerScore = new PlayerScore("", 0);
        Assertions.assertEquals(expected, playerScore.hashCode());
    }

    @Test
    public void equalsTest() {
        PlayerScore playerScoreA = new PlayerScore("A", 5);
        PlayerScore playerScoreB = new PlayerScore("A", 5);
        Assertions.assertEquals(playerScoreA, playerScoreB);
    }

    @Test
    public void equalsTest2() {
        PlayerScore playerScoreA = new PlayerScore("A", 5);
        PlayerScore playerScoreB = new PlayerScore("B", 5);
        Assertions.assertFalse(playerScoreA.equals(playerScoreB));
    }

    @Test
    public void equalsTest3() {
        PlayerScore playerScoreA = new PlayerScore("A", 5);
        PlayerScore playerScoreB = new PlayerScore("A", 3);
        Assertions.assertFalse(playerScoreA.equals(playerScoreB));
    }

    @Test
    public void hashCodeTest2() {
        int expected = "player".hashCode() + 5;
        PlayerScore playerScore = new PlayerScore("player", 5);
        Assertions.assertEquals(expected, playerScore.hashCode());
    }

}

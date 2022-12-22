package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerScoreTest {

    @Test
    public void getScoreTest() {
        PlayerScore playerScore = new PlayerScore("", 0);
        assertEquals(0, playerScore.getScore());
        PlayerScore playerScore2 = new PlayerScore("", 100);
        assertEquals(100, playerScore2.getScore());
    }
    @Test
    public void compareToTest() {
        int a = 10;
        int b = 20;
        int expected = 10;
        PlayerScore playerScoreA = new PlayerScore("", a);
        PlayerScore playerScoreB = new PlayerScore("", b);
        assertEquals(expected, playerScoreA.compareTo(playerScoreB));
    }
    @Test
    public void testLoadScores() {
        TreeSet<PlayerScore> scores = PlayerScore.loadScores();
        assertEquals(880, scores.first().getScore());
    }

    public void testStoreScores()  {
        TreeSet<PlayerScore> t = PlayerScore.loadScores();
        int r = t.size();
        TreeSet<PlayerScore> scores = new TreeSet<>();
        scores.add(new PlayerScore("player1", 100));
        scores.add(new PlayerScore("player2", 200));
        scores.add(new PlayerScore("player3", 300));
        PlayerScore.storeScores(scores);
        TreeSet<PlayerScore> scores2 = PlayerScore.loadScores();
        int result = scores2.size();
        assertEquals(3+r, result);
        TreeSet<PlayerScore> clean = new TreeSet<>();
        PlayerScore.storeScores(clean);

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

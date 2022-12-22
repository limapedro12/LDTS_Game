package spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
}

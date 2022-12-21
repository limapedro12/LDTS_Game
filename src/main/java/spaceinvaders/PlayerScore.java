package spaceinvaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;

public class PlayerScore implements Comparable<PlayerScore>{
    private String player;
    private int score;
    public PlayerScore(String player, int score) {
        super();
        this.player = player;
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public int compareTo(PlayerScore playerScore) {
        return playerScore.score - this.score;
    }
    public static TreeSet<PlayerScore> loadScores() {
        TreeSet<PlayerScore> r = new TreeSet<>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/highscores.csv"));
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(splitBy);
                PlayerScore playerScore = new PlayerScore(arr[0], Integer.parseInt(arr[1]));
                r.add(playerScore);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
    public static void storeScores(TreeSet<PlayerScore> scores) {
        while (scores.size() > 10) scores.pollLast();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("resources/highscores.csv");
            writer.print("");
            for (PlayerScore score : scores) {
                writer.print(score.player + "," +  score.score + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}

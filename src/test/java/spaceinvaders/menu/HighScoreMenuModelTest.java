package spaceinvaders.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.ArenaModel;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.HighScoreMenuModel;
import spaceinvaders.model.menu.StartCommand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreMenuModelTest {
    GameModel gameModelMock;
    HighScoreMenuModel model;
    @BeforeEach
    public void helper(){
        gameModelMock = Mockito.mock(GameModel.class);
        HighScoreMenuModel.reset();
        model = HighScoreMenuModel.getInstance(gameModelMock);
    }
    @Test
    public void getScoreTest(){
        List<Integer> scores = new ArrayList<>();
        model.setScores(scores);
        assertEquals(scores, model.getScores());
    }
    @Test
    public void getExitCommandTest(){
        StartCommand startCommand = new StartCommand(gameModelMock);
        model.setExitCommand(startCommand);
        assertEquals(startCommand, model.getExitCommand());
    }
}

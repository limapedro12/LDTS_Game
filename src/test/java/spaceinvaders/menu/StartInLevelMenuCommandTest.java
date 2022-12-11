package spaceinvaders.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.controller.menu.StartInLevelMenuController;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.StartCommand;
import spaceinvaders.model.menu.StartInLevelMenuCommand;
import spaceinvaders.model.menu.StartInLevelMenuModel;
import spaceinvaders.model.menu.MenuStateModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartInLevelMenuCommandTest {
    GameModel gameModel;
    StartInLevelMenuCommand StartInLevelMenuCommand;
    StartCommand startCommand;
    @BeforeEach
    public void helper() {
        gameModel = Mockito.mock(GameModel.class);
        startCommand = Mockito.mock(StartCommand.class);
        StartInLevelMenuCommand = new StartInLevelMenuCommand(gameModel, startCommand);
    }

    @Test
    public void getGameModelTest() {
        assertEquals(StartInLevelMenuCommand.getGameModel(), gameModel);
    }

    @Test
    public void getTitle() {
        assertEquals(StartInLevelMenuCommand.getTitle(), "Start In Level");
    }

    @Test
    public void executeTest() {
        StartInLevelMenuCommand.execute();
        Mockito.verify(gameModel, Mockito.times(1)).setState(Mockito.any());
    }

    @Test
    public void executeTest2() {
        GameModel gameModel2 = new GameModel();
        StartInLevelMenuCommand.setGameModel(gameModel2);
        StartInLevelMenuCommand.execute();
        MenuStateModel menuStateModel = (MenuStateModel) gameModel2.getState();
        StartInLevelMenuModel model = StartInLevelMenuModel.getInstance(gameModel, startCommand);
        assertEquals(menuStateModel.getModel(), model);
        assertEquals(menuStateModel.getController(), StartInLevelMenuController.getInstance(model));
    }

    @Test
    public void getStartCommandTest() {
        assertEquals(StartInLevelMenuCommand.getStartCommand(), startCommand);
    }
}

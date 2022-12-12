//package spaceinvaders;
//
//import com.googlecode.lanterna.input.KeyStroke;
//import com.googlecode.lanterna.screen.Screen;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import spaceinvaders.controller.GameController;
//
//import java.awt.*;
//import java.io.IOException;
//
//public class GameTest {
//    @Test
//    public void runTest() throws IOException, FontFormatException {
//        Game game = new Game();
//        game.run();
//    }
//    public KeyStroke aux() {
//        System.exit(0);
//        return Mockito.mock(KeyStroke.class);
//    }
//    @Test
//    public void runTest2() throws IOException, FontFormatException {
//        Screen screen = Mockito.mock(Screen.class);
//        Mockito.when(screen.pollInput()).thenReturn(aux());
//        assert(false);
//    }
//
//}
package test;

import org.junit.Test;

import static auf2.battleship.game.Game.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jihed on 22.05.2016.
 * test Code Game class
 */
public class GameTest {

    private String[][] field = new String[][]{
            {"w", "w", "w", "s", "s", "s", "s"},
            {"w", "w", "w", "w", "w", "w", "w"},
            {"w", "w", "w", "w", "w", "w", "w"},
            {"w", "w", "w", "w", "w", "w", "w"},
            {"w", "w", "w", "w", "w", "w", "w"},
            {"w", "w", "w", "w", "w", "w", "w"},
            {"w", "w", "w", "w", "w", "w", "w"}
    };

    @Test
    public void testCoordinationTest() throws Exception {
        String validUserChoice = "a1";
        String notValidUserChoice = "11";
        Boolean result = testCoordination(validUserChoice);
        assertTrue(result);

        result = testCoordination(notValidUserChoice);
        assertFalse(result);

        notValidUserChoice = "1a";
        result = testCoordination(notValidUserChoice);
        assertFalse(result);

        notValidUserChoice = "aa";
        result = testCoordination(notValidUserChoice);
        assertFalse(result);
    }

    @Test
    public void playGameHappyPath() {
        assertTrue(checkHits("a4", field));
        assertFalse(checkHits("a4", field));

        assertTrue(checkHits("a5", field));
        assertFalse(checkHits("a5", field));

        assertTrue(checkHits("a6", field));
        assertFalse(checkHits("a6", field));
        assertFalse(testWinGame(field));

        assertTrue(checkHits("a7", field));
        assertFalse(checkHits("a7", field));
        assertTrue(testWinGame(field));
    }

}
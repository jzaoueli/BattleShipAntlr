package auf2.battleship.game;

public class Controller {
    private static Game game;

    private static void createPlayField() {
        game = new Game(Field.getField());
    }

    public static void main(String[] args) {
        createPlayField();
        game.play();
    }
}

package auf3.battleship.game;

public class Controller {
    private static Game game;
    private static String[] sequence;

    private static void createPlayField() {
        sequence = Sequence.getSequence();
        game = new Game(Field.getField(), sequence);
    }

    public static void main(String[] args) {
        createPlayField();
        game.play();
    }
}

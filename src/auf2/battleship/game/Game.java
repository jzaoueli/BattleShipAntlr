package auf2.battleship.game;

import java.util.Scanner;

class Game {

    private String[][] field;

    Game(String[][] field) {
        this.field = field;
    }

    void play() {

        int shoot = 0;
        while (!testWinGame()) {

            String coordination = readInputFromUser();
            boolean test = testCoordination(coordination);
            while (!test) {
                System.out.println("Die eingegebenen Schusskoordinaten sind ungültig. Bitte versuche es erneut.");
                coordination = readInputFromUser();
                test = testCoordination(coordination);
            }
            shoot++;

            if (field[coordination.charAt(0) - 97][Character.getNumericValue(coordination.charAt(1)) - 1].equals("0")) {
                System.out.println("kein Treffer");
            } else {
                System.out.println("Treffer");
                field[coordination.charAt(0) - 97][Character.getNumericValue(coordination.charAt(1)) - 1] = ("0");
            }
        }
        if (testWinGame())
            System.out.println("Du hast das Spiel nach Abgabe von " + shoot + " Schüssen gewonnen.");
        else {
            System.out.println("Du hast das Spiel nach Abgabe von 49 Schüssen verloren.");
        }
    }


    private boolean testWinGame() {
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                if (field[i][j].equals("1")) {
                    return false;
                }
            }
        return true;
    }

    private boolean testCoordination(String coordination) {
        boolean test = (coordination.length() == 2);
        test = test && (Character.isLetter(coordination.charAt(0))) && (coordination.charAt(0) >= 'a') && (coordination.charAt(0) <= 'g');
        test = test && (Character.isDigit(coordination.charAt(1))) && (coordination.charAt(1) >= '1') && (coordination.charAt(1) <= '7');

        return test;
    }

    private String readInputFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Gib Deine Schusskoordinaten in Form <Spalte><Zeile> ein:");
        return reader.next();
    }
}
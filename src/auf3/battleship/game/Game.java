package auf3.battleship.game;

import java.util.Scanner;

class Game {

    private String[][] field;

    Game(String[][] field) {
        this.field = field;
    }

    void play() {

        int shoot = 0;
        while (!testWinGame(field)) {

            String coordination = readInputFromUser();
            boolean test = testCoordination(coordination);
            while (!test) {
                System.out.println("Die eingegebenen Schusskoordinaten sind ungültig. Bitte versuche es erneut.");
                coordination = readInputFromUser();
                test = testCoordination(coordination);
            }
            shoot++;

            if (checkHits(coordination, field)) {
                System.err.println("Treffer");
            } else {
                System.err.println("kein Treffer");
            }
            if (shoot == 49) {
                break;
            }
        }
        if (testWinGame(field))
            System.err.println("Du hast das Spiel nach Abgabe von " + shoot + " Schüssen gewonnen.");
        else {
            System.err.println("Du hast das Spiel nach Abgabe von \'" + shoot + "\' Schüssen verloren.");
        }
    }

    private static boolean checkHits(String coordination, String[][] field) {
        if (field[coordination.charAt(0) - 97][Character.getNumericValue(coordination.charAt(1)) - 1].equals("w")) {
            return false;
        } else {
            field[coordination.charAt(0) - 97][Character.getNumericValue(coordination.charAt(1)) - 1] = ("w");
            return true;
        }
    }


    private static boolean testWinGame(String[][] field) {
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                if (field[i][j].equals("s")) {
                    return false;
                }
            }
        return true;
    }

    private static boolean testCoordination(String coordination) {
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

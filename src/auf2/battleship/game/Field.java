package auf2.battleship.game;

class Field {

   private static String[][] field = new String[][]{
       {"1","1","0","0","0","0","0"},
       {"0","0","1","1","1","1","0"},
       {"1","0","0","0","0","0","0"},
       {"1","0","0","0","0","0","0"},
       {"1","0","0","0","0","0","0"},
       {"0","0","0","0","0","0","0"},
       {"1","0","0","1","1","1","1"}
   };

   static String[][] getField(){
     return field;
   }
}
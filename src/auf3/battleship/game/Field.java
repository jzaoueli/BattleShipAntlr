package auf3.battleship.game;

class Field {

/**
* created : 2016/05/25 00:27:33
*/
   private static String[][] field = new String[][]{
       {"s","w","w","w","w","w","w"},
       {"w","w","w","w","w","w","w"},
       {"w","w","w","w","w","w","w"},
       {"w","w","w","w","w","w","w"},
       {"w","w","w","w","w","w","w"},
       {"w","w","w","w","w","w","w"},
       {"w","w","w","w","w","w","w"}
   };

   static String[][] getField(){
     return field;
   }
}
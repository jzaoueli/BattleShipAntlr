package yahima;

class Field {

   private static String[][] field = new String[][]{
       {"w","w","w","s","s","s","s"},
       {"w","s","w","w","w","w","w"},
       {"w","s","w","w","w","w","w"},
       {"w","s","w","s","s","s","w"},
       {"w","s","w","w","w","w","w"},
       {"w","s","w","w","w","w","w"},
       {"w","w","s","s","w","w","w"}
};

   static String[][] getField(){
     return field;
   }
}
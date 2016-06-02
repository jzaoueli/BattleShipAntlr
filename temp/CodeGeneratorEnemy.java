package yahima;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;

public class CodeGeneratorEnemy extends EnemySequenceBaseListener {

    private static String result = "";

    public static void main(String[] args) throws IOException {

        String generatedStr = getHeaderStrings();
        generatedStr += getTableValues();
        generatedStr = setFooter(generatedStr);

        createAndWriteInFile("../BattleShip/src/EnemySequence.java", generatedStr);

    }

    public static String setFooter(String generatedStr) {
        return generatedStr.substring(0, generatedStr.length() - 2) + "};\n\n"
                + "   static String[] getEnemySequence(){\n"
                + "     return enemySequence;\n"
                + "   }\n}";
    }

    private static String getHeaderStrings() {
        return  "class EnemySequence {\n\n" +
                "   private static String[] enemySequence = new String[]{\n";
    }

    public static void createAndWriteInFile(String path, String text) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.flush();
        writer.close();
    }

    private static String getTableValues() throws IOException {
        getEnemySequenceString();
        String csvString = result;
        //tempResultString = "       {";

        String tempResultString = setContent(csvString);

        tempResultString += "\"";
        //System.out.println(tempResultString);

        return tempResultString;
    }


    public static String setContent(String csvString) throws IOException {
        String tempResult = "";
        BufferedReader br = new BufferedReader(new StringReader(csvString));
        System.out.println(br.toString());
        String line ;
        while((line = br.readLine()) != null){
            System.out.println(line);
            if(line.startsWith("Der Computer feuert per Zufall auf eine noch nicht getroffene Zelle.")) {
                System.out.println("zufall");
                tempResult += "     \"Der Computer feuert per Zufall auf eine noch nicht getroffene Zelle.\"";
                tempResult += ",\n";
                //System.out.println(tempResult);
            }
            else if(line.startsWith("Der Computer feuert auf ")){
                System.out.println("feld");
                tempResult += "     \"Der Computer feuert auf ";
                tempResult += line.charAt(line.length() - 3);
                tempResult += line.charAt(line.length() - 2);
                tempResult += "\",\n";
            }
            else{
                System.out.println("nichts");
            }
        }
        /*try {
            for
            do {

                i++;
                if(br.l)) {
                    System.out.println(csvString.startsWith("Der Computer feuert per Zufall auf eine noch nicht getroffene Zelle."));
                    tempResult += "\"Der Computer feuert per Zufall auf eine noch nicht getroffene Zelle.\"";
                    tempResult += ",";
                    //System.out.println(tempResult);
                }
                else if(csvString.startsWith("Der Computer feuert auf ")) {
                    System.out.println("ja");

                    tempResult += "\"Der Computer feuert auf \"";
                    tempResult += csvString.charAt(csvString.length() - 3);
                    tempResult += csvString.charAt(csvString.length() - 2);
                    tempResult += "." + ",";
                    //System.out.println(tempResult);

                }
                else{
                    System.out.println("nichts");
                }
            }

            System.out.println("fertig" + i);



        } catch (Exception e) {
            System.out.println("end");
            System.out.println(e);
        }*/

        return tempResult;
    }

    private static String getEnemySequenceString() throws IOException {

        FileReader fileReader = new FileReader("src/EnemySequence.csv");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileReader);
        // Get CSV lexer
        EnemySequenceLexer lexer = new EnemySequenceLexer(antlrInputStream);
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        EnemySequenceParser parser = new EnemySequenceParser(tokens);
        // Specify our entry point
        EnemySequenceParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        EnemySequenceBaseListener listener = new CodeGeneratorEnemy();
        walker.walk(listener, fileContext);
       // System.out.println(result);
        return result;
    }

    public void exitFile(EnemySequenceParser.FileContext ctx) {
        System.out.println("OOO");
        result += ctx.getText();
    }

    private static void setResult() throws IOException {
        System.out.println("set");
        getEnemySequenceString();
    }


}

package auf2.battleship.generator;

import auf2.antlergeneration.FieldGramBaseListener;
import auf2.antlergeneration.FieldGramLexer;
import auf2.antlergeneration.FieldGramParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;

public class CodeGenerator extends FieldGramBaseListener {

    private static String result;

    public static void main(String[] args) throws IOException {

        String generatedStr = getHeaderStrings();
        generatedStr += getTableValues();
        generatedStr = setFooter(generatedStr);

        createAndWriteInFile("src/auf2/battleship/game/Field.java", generatedStr);

    }

    private static String setFooter(String generatedStr) {
        return generatedStr.substring(0, generatedStr.length() - 2) + "}\n   };\n\n"
                + "   static String[][] getField(){\n"
                + "     return field;\n"
                + "   }\n}";
    }

    private static String getHeaderStrings() {
        return "package auf2.battleship.game;\n\n" +
                "class Field {\n\n" +
                "   private static String[][] field = new String[][]{\n";
    }

    private static void createAndWriteInFile(String path, String text) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.flush();
        writer.close();
    }

    private static String getTableValues() throws IOException {
        setResult();
        String csvString = result;
        String tempResultString = "       {";

        for (int i = 0; i < csvString.length(); i++) {
            switch (csvString.charAt(i)) {
                case 'w':
                    tempResultString += "\"0\"";
                    if (csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r') {
                        tempResultString += ",";
                    }
                    break;
                case 's':
                    tempResultString += "\"1\"";
                    if (csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r') {
                        tempResultString += ",";
                    }
                    break;
                case '\n':
                    tempResultString += "},\n       {";
                    break;
                default:
                    System.err.println(i + "- this character will not be moved = " + csvString.charAt(i));
            }
            System.err.println("actual string : " + tempResultString);
        }
        tempResultString += "\"";
        return tempResultString;
    }

    private static String getPlayerFieldString() throws IOException {

        FileReader fileReader = new FileReader("files/auf2/playfield.csv");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileReader);
        // Get CSV lexer
        FieldGramLexer lexer = new FieldGramLexer(antlrInputStream);
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        FieldGramParser parser = new FieldGramParser(tokens);
        // Specify our entry point
        FieldGramParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        FieldGramBaseListener listener = new CodeGenerator();
        walker.walk(listener, fileContext);

        //System.err.print("this is the value of result :\n" + result);
        return result;
    }

    public void exitFile(FieldGramParser.FileContext ctx) {
        result += ctx.getText();
    }

    private static void setResult() throws IOException {
        getPlayerFieldString();
    }


}

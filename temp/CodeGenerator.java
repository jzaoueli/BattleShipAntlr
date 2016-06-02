package yahima;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;

public class CodeGenerator extends FieldBaseListener {

    private static String result;

    public static void main(String[] args) throws IOException {

        String generatedStr = getHeaderStrings();
        generatedStr += getTableValues();
        generatedStr = setFooter(generatedStr);

        createAndWriteInFile("src/Field.java", generatedStr);

    }

    public static String setFooter(String generatedStr) {
        return generatedStr.substring(0, generatedStr.length() - 2) + "}\n};\n\n"
                + "   static String[][] getField(){\n"
                + "     return field;\n"
                + "   }\n}";
    }

    private static String getHeaderStrings() {
        return  "class Field {\n\n" +
                "   private static String[][] field = new String[][]{\n";
    }

    public static void createAndWriteInFile(String path, String text) throws IOException {
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

        tempResultString = setContent(csvString, tempResultString);
        tempResultString += "\"";
        return tempResultString;
    }

    public static String setContent(String csvString, String tempResultString) {

        try {
            for (int i = 0; i < csvString.length(); i++) {
                switch (csvString.charAt(i)) {
                    case 'w':
                        tempResultString += "\"w\"";
                        if (csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r') {
                            tempResultString += ",";
                        }
                        break;
                    case 's':
                        tempResultString += "\"s\"";
                        if (csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r') {
                            tempResultString += ",";
                        }
                        break;
                    case '\n':
                        tempResultString += "},\n       {";
                        break;
                    default:
                        //System.err.println(i + "- this character will not be moved = " + csvString.charAt(i));
                }
                //System.err.println("actual string : " + tempResultString);
            }
        } catch (Exception e) {
            System.out.println("can not generate tableContent");
            throw new RuntimeException("with error:\n" + e.getMessage());
        }

        return tempResultString;
    }

    private static String getPlayerFieldString() throws IOException {

        FileReader fileReader = new FileReader("src/Field.csv");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileReader);
        // Get CSV lexer
        FieldLexer lexer = new FieldLexer(antlrInputStream);
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        FieldParser parser = new FieldParser(tokens);
        // Specify our entry point
        FieldParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        FieldBaseListener listener = new CodeGenerator();
        walker.walk(listener, fileContext);

        //System.err.print("this is the value of result :\n" + result);
        return result;
    }

    public void exitFile(FieldParser.FileContext ctx) {
        result += ctx.getText();
    }

    private static void setResult() throws IOException {
        getPlayerFieldString();
    }


}
